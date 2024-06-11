package swe.pingp.domain.chatbot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swe.pingp.domain.chatbot.dto.request.CreateChatRoomRequest;
import swe.pingp.domain.chatbot.dto.request.CreateFaqRequest;
import swe.pingp.domain.chatbot.dto.response.ChatResponse;
import swe.pingp.domain.chatbot.dto.response.ChatRoomResponse;
import swe.pingp.domain.chatbot.dto.response.CreateChatRoomResponse;
import swe.pingp.domain.chatbot.dto.response.CreateFaqResponse;
import swe.pingp.domain.chatbot.dto.response.DeleteChatResponse;
import swe.pingp.domain.chatbot.dto.response.FaqResponse;
import swe.pingp.domain.chatbot.entity.Chat;
import swe.pingp.domain.chatbot.entity.ChatRoom;
import swe.pingp.domain.chatbot.entity.Faq;
import swe.pingp.domain.chatbot.entity.Source;
import swe.pingp.domain.chatbot.repository.ChatRepository;
import swe.pingp.domain.chatbot.repository.ChatRoomRepository;
import swe.pingp.domain.chatbot.repository.FaqRepository;
import swe.pingp.domain.chatbot.repository.GetSource;
import swe.pingp.domain.chatbot.repository.SourceRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRepository chatRepository;
    private final SourceRepository sourceRepository;
    private final FaqRepository faqRepository;

    public List<ChatRoomResponse> findAllChatRooms(Long userId) {
        List<ChatRoom> chatRooms = chatRoomRepository.findAllByUserId(userId);

        return chatRooms.stream()
                .map(ChatRoomResponse::from)
                .collect(Collectors.toList());
    }

    public CreateChatRoomResponse createChatRoom(CreateChatRoomRequest createChatRoomRequest) {
        ChatRoom chatRoom = ChatRoom.toEntity(createChatRoomRequest);

        ChatRoom res = chatRoomRepository.save(chatRoom);

        return CreateChatRoomResponse.from(res);
    }

    public List<ChatResponse> findChatByRoomId(Long roomId) {
        List<Chat> chats = chatRepository.findAllByChatroomId(roomId);

        List<ChatResponse> chatResponses = new ArrayList<>();
        for (Chat chat : chats) {
            Long chatId = chat.getId();
            List<GetSource> contents = sourceRepository.findAllByChattingId(chatId);

            List<String> strContents = contents.stream()
                    .map(GetSource::getContents)
                    .collect(Collectors.toList());

            ChatResponse chatResponse = ChatResponse.from(chat, strContents);
            chatResponses.add(chatResponse);
        }

        return chatResponses;
    }

    public DeleteChatResponse deleteChatRoom(Long roomId) {
        chatRoomRepository.deleteById(roomId);

        return DeleteChatResponse.from(roomId);
    }

    public List<FaqResponse> findAllFaqs() {
        List<Faq> faqs = faqRepository.findAll();

        return faqs.stream()
                .map(FaqResponse::from)
                .collect(Collectors.toList());
    }

    public CreateFaqResponse createFaq(CreateFaqRequest createFaqRequest) {
        Faq faq = Faq.toEntity(createFaqRequest);

        Faq res = faqRepository.save(faq);

        return CreateFaqResponse.from(res);
    }

}
