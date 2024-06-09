package swe.pingp.domain.chatbot.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateChatRoomRequest {

    private String title;
    private String mode;
    private Long userId;
}
