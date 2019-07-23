package complicated.postApp.repositories;

import complicated.postApp.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(nativeQuery = true, value = "select * from post order by date")
    List<Post> findAll();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update post set likes = likes+1 where id = ?")
    void increaseLikes(Long id);

    @Query(nativeQuery = true, value = "update post set reply_to_id = ?")
    Post answer(Long id);
}
