package ToMist.SpringBoard.repository;

import ToMist.SpringBoard.domain.Article;
import ToMist.SpringBoard.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends
        JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<Article>,
        QuerydslBinderCustomizer<QArticle>
{
  @Override
  default void customize(QuerydslBindings bindings, QArticle root){
    bindings.excludeUnlistedProperties(true); //선택적으로 검색 가능하게 됨
    bindings.including(root.title, root.content, root.hashtag, root.createdAt, root.createdBy); //원하는 필드 추가
//    bindings.bind(root.title).first(StringExpression::likeIgnoreCase);  //부분 검색 확장: like '${v}'
    bindings.bind(root.title).first(StringExpression::containsIgnoreCase);
    bindings.bind(root.content).first(StringExpression::containsIgnoreCase);  //부분 검색 확장: like '%${v}%'
    bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);
    bindings.bind(root.createdAt).first(DateTimeExpression::eq);
    bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
  }
}

