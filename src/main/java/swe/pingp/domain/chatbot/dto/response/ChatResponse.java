package swe.pingp.domain.chatbot.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import swe.pingp.domain.chatbot.entity.Chat;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatResponse {

    private Long id;
    private String question;
    private String answer;
    private LocalDateTime createdAt;
    private List<String> source;

    public static ChatResponse from (Chat chat, List<String> contents) {
        return ChatResponse.builder()
                .id(chat.getId())
                .question(chat.getQuestion())
                .answer(chat.getQuestion())
                .createdAt(chat.getCreatedAt())
                .source(contents)
                .build();
    }
}
