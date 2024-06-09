package swe.pingp.domain.chatbot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import swe.pingp.domain.chatbot.dto.request.CreateChatRoomRequest;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String mode;

    @Column(name = "user_id")
    private Long userId;

    public static ChatRoom toEntity(CreateChatRoomRequest createChatRoomRequest) {
        return ChatRoom.builder()
                .title(createChatRoomRequest.getTitle())
                .mode(createChatRoomRequest.getMode())
                .userId(createChatRoomRequest.getUserId())
                .build();
    }
}
