package ToMist.SpringBoard.repository;

import ToMist.SpringBoard.domain.Article;
import ToMist.SpringBoard.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}
