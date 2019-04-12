package app.controllers;

import org.springframework.ui.ModelMap;

@org.springframework.stereotype.Controller
public interface Controller {
    String findAll(ModelMap model);

    String save(ModelMap model, String name, String city, String email);
}
