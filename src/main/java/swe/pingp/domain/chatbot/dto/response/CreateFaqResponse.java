package swe.pingp.domain.chatbot.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import swe.pingp.domain.chatbot.entity.Faq;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateFaqResponse {

    private Long faqId;

    public static CreateFaqResponse from(Faq faq) {
        return CreateFaqResponse.builder()
                .faqId(faq.getId())
                .build();
    }

}
