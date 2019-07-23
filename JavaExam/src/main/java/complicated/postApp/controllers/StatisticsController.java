package complicated.postApp.controllers;

import complicated.postApp.models.Post;
import complicated.postApp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class StatisticsController {

    @Autowired
    private PostService postService;

    @GetMapping("/statistics")
    public String getStatisticsPage() {
        return "postsStatistics";
    }

    @PostMapping(value = "/statistics", params = "likes")
    public String makeStatisticsByLikes(ModelMap model) {
        List<Post> posts = postService.findAll();
        Comparator<Post> postComparator = (o1, o2) -> o2.getLikes().compareTo(o1.getLikes());
        posts.sort(postComparator);
        System.out.println(posts);
        model.addAttribute("posts", posts);
        return "postsStatistics";
    }

    @PostMapping(value = "/statistics", params = "answers")
    public String makeStatisticsByAnswers(ModelMap model) {
        List<Post> posts = postService.findAll();
        Comparator<Post> postComparator = (o1, o2) -> Integer.compare(o2.getAnswers().size(), o1.getAnswers().size());
        posts.sort(postComparator);
        model.addAttribute("posts", posts);
        return "postsStatistics";
    }
}
