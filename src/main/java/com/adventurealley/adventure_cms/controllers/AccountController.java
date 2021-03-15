package com.adventurealley.adventure_cms.controllers;

import com.adventurealley.adventure_cms.model.Activity;
import com.adventurealley.adventure_cms.model.ActivityRepository;
import com.adventurealley.adventure_cms.model.UserRepository;
import com.adventurealley.adventure_cms.presenters.LandingpagePresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
public class AccountController {

    // Spring initializes thin interface WITH a class.
    // This bean will be used communicate with hibernate in order to acces "users" in the db --> orm.
    // This class will be implementing the interface "UserRepository"
    @Autowired
    private UserRepository userRepository;



    @GetMapping("/")
    public String getLandingPage(Principal principal, Model indexModel){

        LandingpagePresenter landingpagePresenter = new LandingpagePresenter();

        // Get all upcomming activities in a List.
        List<Activity> activityList = landingpagePresenter.getAllUpcomingActivities();

        // Get Get all upcomming activities in a List, but with no duplicates


        //Add to Model.
        indexModel.addAttribute("activityList", activityList);
        indexModel.addAttribute("noDuplicatesActivityList", noDuplicatesActivityList);

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