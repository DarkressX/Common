package org.common.common.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @RequestMapping("/login")
    public String login(Model model){
        return "HTMLPage1";
    }

    @RequestMapping("/")
    public String home(Model model) {return "homepage";}

}
