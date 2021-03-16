package com.adventurealley.adventure_cms.controllers;

import com.adventurealley.adventure_cms.model.Activity;
import com.adventurealley.adventure_cms.model.ActivityRepository;
import com.adventurealley.adventure_cms.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;


@Controller
public class AccountController {

    // Spring initializes thin interface WITH a class.
    // This bean will be used communicate with hibernate in order to acces "users" in the db --> orm.
    // This class will be implementing the interface "UserRepository"
    @Autowired
    private UserRepository userRepository;

    @Autowired
    ActivityRepository activityRepository;

    @GetMapping("/")
    public String getLandingPage(Principal principal, Model indexModel){

        //Get list of all activities from db
        List<Activity> activityList = activityRepository.findAll();

        //Add to Model.
        indexModel.addAttribute("activityList", activityList);


        if(principal != null){

            boolean loggedIn = true;

            //Add to Model.
            indexModel.addAttribute("loggedIn", loggedIn);

            return "index";
        }
        else {
            boolean loggedIn = false;

            //Add to Model.
            indexModel.addAttribute("loggedIn", loggedIn);

            return "index";}
    }


    @GetMapping("/login")
    public String getLogIn(){

        return "login";
    }

}

// Bruger følgende til at oprette passwords til brugere i systemet: https://bcryptgenerator.com/