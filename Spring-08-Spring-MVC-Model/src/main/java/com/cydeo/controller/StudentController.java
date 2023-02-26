package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public  String homePage(Model model){

        model.addAttribute("name", "Cydeo");   // this is belong only this page method
        model.addAttribute("course", "MVC");  // can bring this from DB or any

        String subject = "Collections";  //can br DB
        model.addAttribute("subject",subject);

        int studentId = new Random().nextInt();
        model.addAttribute("id",studentId);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
        numbers.add(10);
        model.addAttribute("numbers",numbers);

        Student student = new Student(1, "Mike", "Smith");
        model.addAttribute("student", student);





        return "student/welcome";  //this is thymeleaf template
    }

}
