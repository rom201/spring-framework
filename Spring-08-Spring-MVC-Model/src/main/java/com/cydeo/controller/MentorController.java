package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")    //by doing this we change end point to remove duplicates for end point
public class MentorController {

    @RequestMapping("/list")   // localhost:8080/mentor/list
    public String showMentorsList(Model model){

        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Tom","Hanks", 64, Gender.MALE));
        mentorList.add(new Mentor("Mike","Smith", 45, Gender.MALE));
        mentorList.add(new Mentor("Ammy","Bryan", 26, Gender.FEMALE));

        model.addAttribute("mentors", mentorList);

        return "mentor/mentor-list";
    }

}
