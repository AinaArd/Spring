package complicated.postApp.controllers;

import complicated.postApp.forms.PostForm;
import complicated.postApp.models.Post;
import complicated.postApp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostsController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public String getPostsPage(ModelMap model) {
        List<Post> posts = postService.findAll();
        if (!posts.isEmpty()) {
            model.addAttribute("posts", posts);
        }
        return "posts";
    }

    @PostMapping("/posts")
    public String sendPost(PostForm postForm) {
        Date date = new Date();
        Post newPost = Post.builder()
                .theme(postForm.getTheme())
                .text(postForm.getText())
                .likes(0)
                .answers(new ArrayList<>())
                .date(date)
                .build();
        postService.addPost(newPost);
        return "redirect:/posts";
    }

    @PostMapping(value = "/posts", params = "like")
    public String giveLike(@RequestParam(name = "id") Long id) {
        postService.increaseLikes(id);
        return "redirect:/posts";
    }

    @PostMapping(value = "/posts", params = "answer")
    public String answerPost(@RequestParam("id") Long id, ModelMap model, PostForm postForm) {
        Post reply = postService.findById(id).orElseThrow(IllegalArgumentException::new);
        Date date = new Date();
        Post newPost = Post.builder()
                .theme(reply.getTheme())
                .text(postForm.getText())
                .likes(0)
                .answers(new ArrayList<>())
                .date(date)
                .replyTo(reply)
                .build();
        postService.addPost(newPost);
        reply.getAnswers().add(newPost);
        model.addAttribute("answer", newPost);
        return "redirect:/posts";
    }
}
