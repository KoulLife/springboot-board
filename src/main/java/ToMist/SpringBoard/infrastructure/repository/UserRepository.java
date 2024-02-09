package ToMist.SpringBoard.infrastructure.repository;

import ToMist.SpringBoard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  //username 으로 User 찾기
  Optional<User> findByUsername(String username);
  //email 로 User 찾기
  Optional<User> findByEmail(String email);
  //nickname 으로 User 찾기
  Optional<User> findByNickname(String nickname);

  //username 으로 User 있는지 확인
  boolean existsByUsername(String username);
  //nickname 으로 User 잇는지 확인
  boolean existsByNickname(String nickname);
  //email 으로 User 있는지 확인
  boolean existsByEmail(String email);
}
