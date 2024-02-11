package ToMist.SpringBoard.repository;

import ToMist.SpringBoard.domain.Article;
import ToMist.SpringBoard.domain.ArticleComment;
import ToMist.SpringBoard.domain.QArticle;
import ToMist.SpringBoard.domain.QArticleComment;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>,
        QuerydslPredicateExecutor<ArticleComment>,
        QuerydslBinderCustomizer<QArticleComment>
{
  @Override
  default void customize(QuerydslBindings bindings, QArticleComment root){
    bindings.excludeUnlistedProperties(true); //선택적으로 검색 가능하게 됨
    bindings.including(root.content, root.createdAt, root.createdBy); //원하는 필드 추가
    bindings.bind(root.content).first(StringExpression::containsIgnoreCase);  //부분 검색 확장: like '%${v}%'
    bindings.bind(root.createdAt).first(DateTimeExpression::eq);
    bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
  }
}
