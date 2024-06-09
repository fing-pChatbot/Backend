package swe.pingp.domain.chatbot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swe.pingp.domain.chatbot.entity.Source;

@Repository
public interface SourceRepository extends JpaRepository<Source, Long> {
    List<GetSource> findAllByChattingId(Long chatId);
}
