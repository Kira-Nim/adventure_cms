package com.adventurealley.adventure_cms.controllers;

import com.adventurealley.adventure_cms.model.Activity;
import com.adventurealley.adventure_cms.model.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.Column;

@Controller
public class ActivityController {

    @Autowired
    ActivityRepository activityRepository;

    @PostMapping("/createActivity")
    public String getLandingPage(WebRequest dataFromformCreateActivity){

        Activity activity = new Activity();

        activity.setTitle(dataFromformCreateActivity.getParameter("title"));
        activity.setPrice(Float.parseFloat(dataFromformCreateActivity.getParameter("price")));
        activity.setPhotoURL(dataFromformCreateActivity.getParameter("photoURL"));
        activity.setDescription(dataFromformCreateActivity.getParameter("description"));

        activity.setMinAge(Integer.parseInt(dataFromformCreateActivity.getParameter("maxParticipants")));
        activity.setDurationMinutes(Integer.parseInt(dataFromformCreateActivity.getParameter("duration")));
        activity.setMaxParticipants(Integer.parseInt(dataFromformCreateActivity.getParameter("maxParticipants")));






        return "redirect:/";

    }


}
