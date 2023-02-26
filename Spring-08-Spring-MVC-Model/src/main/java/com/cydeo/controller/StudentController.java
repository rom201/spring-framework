package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public  String homePage(Model model){

        model.addAttribute("name", "Cydeo");   // this is belong only this page method
        model.addAttribute("course", "MVC");  // can bring this from DB or any
        return "student/welcome";  //this is thymeleaf template
    }

}
