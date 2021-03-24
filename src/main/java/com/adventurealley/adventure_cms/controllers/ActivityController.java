package com.adventurealley.adventure_cms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class ActivityController {

    @PostMapping("/createActivity")
    public String getLandingPage(WebRequest dataFromformCreateActivity){

        return "redirect:/";

    }


}
