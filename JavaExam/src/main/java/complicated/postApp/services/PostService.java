package complicated.postApp.services;

import complicated.postApp.models.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> findAll();

    void addPost(Post newPost);

    void increaseLikes(Long id);

    Post answer(Long id);

    Optional<Post> findById(Long id);
}
