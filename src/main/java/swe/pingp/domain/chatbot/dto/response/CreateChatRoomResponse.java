package swe.pingp.domain.chatbot.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import swe.pingp.domain.chatbot.entity.ChatRoom;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateChatRoomResponse {
    private Long chatroomId;

    public static CreateChatRoomResponse from(ChatRoom chatRoom) {
        return CreateChatRoomResponse.builder()
                .chatroomId(chatRoom.getId())
                .build();
    }
}
