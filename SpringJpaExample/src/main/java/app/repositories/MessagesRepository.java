package app.repositories;

import app.models.Message;
import app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MessagesRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByAuthor_Name(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM message WHERE content= ?1 and date= ?2")
    List<Message> findAllByContent(String content, String date);

    void deleteById(Long id);

    //    @Query(nativeQuery = true, value = "delete from message where content=? and id= ?")
    @Transactional
    void deleteByContentAndId(String content, Long id);

    <S extends Message> S save(S s);
}
