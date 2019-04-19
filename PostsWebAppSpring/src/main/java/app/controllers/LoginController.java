package app.controllers;

import app.dao.ParticipantsDao;
import app.models.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private ParticipantsDao dao;

    @GetMapping(path = "/login")
    public String getLoginPage(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"email"})
    public String logIn(ModelMap modelMap, @RequestParam("email") String email, HttpSession session) {
        Participant participant = dao.logIn(email);
        if (participant != null) {
            session.setAttribute("participant", participant);
            return "redirect:profile";
        }
        modelMap.addAttribute("error", true);
        return "login";
    }
}
