package ToMist.SpringBoard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {

  @Bean
  public AuditorAware<String> auditorAware(){ //@CreatedBy 어노테이션 때 누가 작성했는지 알리기 위해
    return () -> Optional.of("Discipline"); //TODO: 스프링 시큐리티로 인증 기능을 붙이게 될 때, 수정
  }
}
