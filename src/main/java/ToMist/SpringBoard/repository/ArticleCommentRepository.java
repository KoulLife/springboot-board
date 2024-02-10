package ToMist.SpringBoard.repository;

import ToMist.SpringBoard.domain.Article;
import ToMist.SpringBoard.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}
