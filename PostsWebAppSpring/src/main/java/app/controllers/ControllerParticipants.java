package app.controllers;

import app.dao.SimpleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
@RequestMapping(path = "/participants")
public class ControllerParticipants {
    @Qualifier("participantsDao")
    @Autowired
    private SimpleDao dao;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(ModelMap model) {
        System.out.println(dao.getParticipants());
        model.put("participants", dao.getParticipants());
        return "participants";
    }
}
