package app.controllers;

import app.dao.ParticipantsDao;
import app.dao.SimpleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
@RequestMapping(path = "/participants")
public class ControllerParticipants {

    @Autowired
    private ParticipantsDao dao;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(ModelMap model) {
        System.out.println(dao.getAll());
        model.put("participants", dao.getAll());
        return "participants";
    }
}
