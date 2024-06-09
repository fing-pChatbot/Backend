package swe.pingp.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swe.pingp.domain.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByName(String name);
}
