package ToMist.SpringBoard.infrastructure.repository;

import ToMist.SpringBoard.domain.Comment;
import ToMist.SpringBoard.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
  //게시글 댓글 목록 가져오기
  List<Comment> getCommentByPostsOrderById(Posts posts);

  //postId, commentId 로 댓글 찾기
  Optional<Comment> findByPostsIdAndId(Long postsId, Long id);
}
