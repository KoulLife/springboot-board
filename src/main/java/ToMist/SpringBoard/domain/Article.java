package ToMist.SpringBoard.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

//title, content, createdAt, cratedBy에 검색을 가능하도록 할 예정

//@EqualsAndHashCode(동등성 검사) 안 쓰는 이유: 필드를 모두 다 비교해서 보통의 표준적인 방법으로 구현하기 때문
@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter @Column(nullable = false) private String title;
  @Setter @Column(nullable = false, length = 10000) private String content;

  @Setter private String hashtag;


  @OrderBy("id")
  @OneToMany(mappedBy = "article", cascade = CascadeType.ALL) // 양방향 바인딩
  @ToString.Exclude //circular referencing 이슈 방지
  private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

  @CreatedDate @Column(nullable = false) private LocalDateTime createdAt;
  @CreatedBy @Column(nullable = false, length = 100) private String createdBy;
  @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt;
  @LastModifiedBy @Column(nullable = false, length = 100) private String modifiedBy;

  protected Article() {}

  private Article(String title, String content, String hashtag) {
    this.title = title;
    this.content = content;
    this.hashtag = hashtag;
  }

  public static Article of(String title, String content, String hashtag){
    return new Article(title, content, hashtag);
  }

  //id가 null일 수도 있다. 따라서 null인지도 비교해줘야 한다. => id != null
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Article article)) return false;
    return id != null && id.equals(article.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
