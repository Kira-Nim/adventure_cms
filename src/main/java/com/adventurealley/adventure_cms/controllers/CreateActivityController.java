package com.adventurealley.adventure_cms.controllers;

import com.adventurealley.adventure_cms.model.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class CreateActivityController {

    @Autowired
    ActivityRepository activityRepository;



}
