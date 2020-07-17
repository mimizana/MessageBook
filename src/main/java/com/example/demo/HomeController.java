package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HomeController {
    public ArrayList<Message > allMessages =new ArrayList<>();


    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/addMessage")
    public String add(Model model) {
        model.addAttribute("message", new Message());
        return "addMessage";
    }

    @PostMapping("/listAll")
    public String listAll(@ModelAttribute Message message, Model model){
        allMessages.add(message);
        model.addAttribute("message",allMessages);
        return "listAll";
    }


    @RequestMapping("/allMessages")
    public String allMessages(Model model){
        model.addAttribute("message", allMessages);
        return "listAll";
    }




}