package app.repositories;

import app.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessagesRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByAuthor_Name(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM message WHERE content= ?1 and date= ?2")
    List<Message> findAllByContent(String content, String date);

    <S extends Message> S save(S s);
}
