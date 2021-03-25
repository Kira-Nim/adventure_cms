package com.adventurealley.adventure_cms.controllers;

import com.adventurealley.adventure_cms.VTOs.ActivityValidationVTO;
import com.adventurealley.adventure_cms.model.Activity;
import com.adventurealley.adventure_cms.model.ActivityRepository;
import com.adventurealley.adventure_cms.services.ValidateActivityService;
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

        Activity newActivity = new Activity();
        ValidateActivityService validateActivityService = new ValidateActivityService();

        ActivityValidationVTO activityValidationVTO = validateActivityService.validateNewActivity(dataFromformCreateActivity, newActivity);

        if(activityValidationVTO.getStatusCode()){
            activityRepository.save(newActivity);
        }

        return "redirect:/";

    }


}
