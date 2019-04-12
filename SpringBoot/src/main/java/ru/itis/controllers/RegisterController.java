package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

@Controller
@RequestMapping(path = "/register")
public class RegisterController {

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping(params = {"name", "email", "password"}, method = RequestMethod.POST)
    public String registerUser(@RequestParam(name = "name") String name, @RequestParam(name = "email") String email,
                          @RequestParam(name = "password") String password) {
        User newUser = new User(name, email, password);
        System.out.println(newUser);
        usersRepository.save(newUser);
        return "redirect:users";
    }

    @GetMapping
    public String showPage(){
        return "register";
    }
}
