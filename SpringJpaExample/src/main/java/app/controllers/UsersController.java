package app.controllers;

import app.dao.UsersDao;
import app.models.Message;
import app.models.User;
import app.repositories.MessagesRepository;
import app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class UsersController {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    MessagesRepository messagesRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public ModelAndView getUsers() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = usersRepository.findAll();

        modelAndView.setViewName("users");
        modelAndView.addObject("usersFromDB", users);
        return modelAndView;
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET, params = {"userName"})
    public ModelAndView getUserByName(@RequestParam("userName") String name) {
        List<User> usersCandidates = usersRepository.findByName(name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("usersFromDB", usersCandidates);
        modelAndView.addObject("userName", name);
        return modelAndView;

    }

    @RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
    public ModelAndView getUserById(@PathVariable(name = "id") Long id) {
        List<User> usersCandidates = usersRepository.findById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("usersFromDB", usersCandidates);
        modelAndView.addObject("userId", id);
        return modelAndView;
    }

}
