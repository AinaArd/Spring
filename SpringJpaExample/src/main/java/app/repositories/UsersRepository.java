package app.repositories;

import app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    List<User> findById(Long id);
    List<User> findByName(String name);
}
