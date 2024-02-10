package ToMist.SpringBoard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

//title, content, createdAt, cratedBy에 검색을 가능하도록 할 예정

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Setter private String title;
  @Setter private String content;
  @Setter private String hashtag;

  private LocalDateTime createdAt;
  private String createdBy;
  private LocalDateTime modifiedAt;
  private String modifiedBy;
}
