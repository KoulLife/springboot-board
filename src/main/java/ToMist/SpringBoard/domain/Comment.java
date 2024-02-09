package ToMist.SpringBoard.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "comments")
@Entity
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "TEXXT", nullable = false)
  private String comment;

  @Column(name = "created_date")
  @CreatedDate
  private String createdDate;

  @Column(name = "modified_date")
  @LastModifiedDate
  private String modifiedDate;

  @ManyToOne
  @JoinColumn(name = "posts_id")
  private Posts posts;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  public void update(String comment){ //댓글 수정
    this.comment = comment;
  }
}