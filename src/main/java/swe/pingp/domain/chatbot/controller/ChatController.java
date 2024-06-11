package swe.pingp.domain.chatbot.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import swe.pingp.domain.chatbot.dto.request.CreateChatRoomRequest;
import swe.pingp.domain.chatbot.dto.request.CreateFaqRequest;
import swe.pingp.domain.chatbot.dto.response.ChatResponse;
import swe.pingp.domain.chatbot.dto.response.ChatRoomResponse;
import swe.pingp.domain.chatbot.dto.response.CreateChatRoomResponse;
import swe.pingp.domain.chatbot.dto.response.CreateFaqResponse;
import swe.pingp.domain.chatbot.dto.response.DeleteChatResponse;
import swe.pingp.domain.chatbot.dto.response.FaqResponse;
import swe.pingp.domain.chatbot.service.ChatService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/chatbot")
public class ChatController {

    private final ChatService chatService;

    /**
     * 채팅방 목록 조회
     */
    @GetMapping("/chatroom")
    public ResponseEntity<List<ChatRoomResponse>> getChatRooms(@RequestParam Long userId) {
        List<ChatRoomResponse> chatRooms = chatService.findAllChatRooms(userId);

        return ResponseEntity.status(HttpStatus.OK).body(chatRooms);
    }

    /**
     * 채팅방 생성
     */
    @PostMapping("/chatting")
    public ResponseEntity<CreateChatRoomResponse> createChatRoom(
            @RequestBody CreateChatRoomRequest createChatRoomRequest) {
        CreateChatRoomResponse chatRoomResponse = chatService.createChatRoom(createChatRoomRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(chatRoomResponse);
    }

    /**
     * 사용자 채팅방 삭제 (채팅 기록 삭제)
     */
    @DeleteMapping("/chatroom/{chatroomId}")
    public ResponseEntity<DeleteChatResponse> deleteChatRoom(@PathVariable("chatroomId") Long roomId) {
        DeleteChatResponse deleteChatResponse = chatService.deleteChatRoom(roomId);

        return ResponseEntity.status(HttpStatus.OK).body(deleteChatResponse);
    }

    /**
     * 사용자 채팅 기록 조회
     */
    @GetMapping("/chatting/{chatroomId}")
    public ResponseEntity<List<ChatResponse>> getChatting(@PathVariable("chatroomId") Long roomId) {

        List<ChatResponse> chats = chatService.findChatByRoomId(roomId);

        return ResponseEntity.status(HttpStatus.OK).body(chats);
    }

    /**
     * FAQ 조회
     */
    @GetMapping("/faq")
    public ResponseEntity<List<FaqResponse>> getFaqs(@RequestParam Long userId) {

        List<FaqResponse> faqs = chatService.findAllFaqs();

        return ResponseEntity.status(HttpStatus.OK).body(faqs);
    }

    /**
     * FAQ 생성
     */
    @PostMapping("/faq")
    public ResponseEntity<CreateFaqResponse> createFaq(@RequestBody CreateFaqRequest createFaqRequest) {

        CreateFaqResponse faqResponse = chatService.createFaq(createFaqRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(faqResponse);
    }
}
