package app.controllers;

import app.dao.PostsDao;
import app.models.Participant;
import app.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private PostsDao postsDao;

    @GetMapping(path = "/profile")
    public String getLoginPage(ModelMap model, HttpSession session) {
        Participant participant = (Participant) session.getAttribute("participant");
        List<Post> posts = postsDao.getAll(participant.getId());
        model.addAttribute("posts", posts);
        return "profile";
    }
}
