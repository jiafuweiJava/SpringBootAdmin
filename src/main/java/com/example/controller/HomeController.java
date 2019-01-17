package com.example.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping(value="/home")
public class HomeController {

    @RequestMapping("/console")
    public String console(Model model){
        return "home/console";
    }


    @RequestMapping("/homepage1")
    public String homepage1(Model model){
        return "home/homepage1";
    }

    @RequestMapping("/homepage2")
    public String index(Model model){
        return "home/homepage2";
    }

}
