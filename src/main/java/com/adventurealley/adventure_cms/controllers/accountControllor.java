package com.adventurealley.adventure_cms.controllers;

import com.adventurealley.adventure_cms.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class accountControllor {

    // Spring initializes thin interface WITH a class.
    // This bean will be used communicate with hibernate in order to acces "users" in the db --> orm.
    // This class will be implementing the interface "UserRepository"
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String getLandingPage(Principal principal){

        if(principal != null){
            return "redirect:/adminMainPage";
        }
        else {return "index";}
    }

    @GetMapping("/login")
    public String getLogIn(){

        return "logIn";
    }
    
}
