package app.controllers;

import app.dao.ParticipantsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
@RequestMapping(path = "/participants")
public class ParticipantsController {

    @Autowired
    private ParticipantsDao dao;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(ModelMap model) {
        model.put("participants", dao.getAll());
        return "participants";
    }

    /*@RequestMapping(path = "/login", method = RequestMethod.POST)
    public String loginPage(){
        return "redirect:login";
    }*/
}
