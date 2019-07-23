package complicated.postApp.services;

import complicated.postApp.models.Post;
import complicated.postApp.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public void addPost(Post newPost) {
        postRepository.save(newPost);
    }

    @Override
    public void increaseLikes(Long id) {
        postRepository.increaseLikes(id);
    }

    @Override
    public Post answer(Long id) {
        return postRepository.answer(id);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }
}
