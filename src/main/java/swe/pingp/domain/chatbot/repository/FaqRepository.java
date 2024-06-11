package swe.pingp.domain.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swe.pingp.domain.chatbot.entity.Faq;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Long> {
}
