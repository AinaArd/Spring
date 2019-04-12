package app.controllers;

import app.dao.SimpleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class ControllerRegister {

    @Qualifier("participantsDao")
    @Autowired
    private SimpleDao dao;

    @RequestMapping(method = RequestMethod.POST, params = {"name", "city", "email"})
    public String save(ModelMap modelMap, @RequestParam("name") String name, @RequestParam("city") String city,
                       @RequestParam("email") String email) {
        dao.saveParticipant(name, city, email);
        return "redirect:participants";
    }

    @RequestMapping(method = RequestMethod.GET)
    private String showRegisterPage(){
        return "register";
    }
}
