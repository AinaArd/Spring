package app.controllers;

import app.models.Message;
import app.models.User;
import app.repositories.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/messages")
public class MessagesController {
    @Autowired
    MessagesRepository messagesRepository;

    @RequestMapping(method = RequestMethod.GET, params = {"userName"})
    public ModelAndView getMessagesOfUser(@RequestParam(name = "userName") String userName) {
        ModelAndView modelAndView = new ModelAndView();
        List<Message> userMessages = messagesRepository.findAllByAuthor_Name(userName);

        modelAndView.setViewName("messages");
        modelAndView.addObject("messages", userMessages);
        modelAndView.addObject("userName", userName);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, params = {"content", "date"})
    public ModelAndView getMessagesByContentAndDate(@RequestParam(name = "content") String content,
                                                    @RequestParam(name = "date") String date) {
        ModelAndView modelAndView = new ModelAndView();
        List<Message> userMessages = messagesRepository.findAllByContent(content, date);

        modelAndView.setViewName("messages");
        modelAndView.addObject("messages", userMessages);
        modelAndView.addObject("content", content);
        modelAndView.addObject("date", date);
        return modelAndView;
    }

    @GetMapping
    public ModelAndView getAllMessages() {
        ModelAndView modelAndView = new ModelAndView();
        List<Message> messages = messagesRepository.findAll();
        System.out.println(messages);
        modelAndView.setViewName("messages");
        modelAndView.addObject("messages", messages);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, params = {"content"})
    public String createMessage(@RequestParam("content") String content) {
        Message message = new Message();
        message.setContent(content);
        messagesRepository.save(message);
        return "redirect:messages";
    }
}
