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
public class DeleteChatResponse {
    private Long chatroomId;

    public static DeleteChatResponse from(Long roomId) {
        return DeleteChatResponse.builder()
                .chatroomId(roomId)
                .build();
    }
}
