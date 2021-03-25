package com.adventurealley.adventure_cms.controllers;

import com.adventurealley.adventure_cms.VTOs.ActivityVTO;
import com.adventurealley.adventure_cms.VTOs.ActivityValidationVTO;
import com.adventurealley.adventure_cms.model.Activity;
import com.adventurealley.adventure_cms.model.ActivityRepository;
import com.adventurealley.adventure_cms.model.UserRepository;
import com.adventurealley.adventure_cms.presenters.LandingPagePresenter;
import com.adventurealley.adventure_cms.services.ValidateActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import java.security.Principal;
import java.util.ArrayList;


@Controller
public class AccountController {

    private int[] errorCodes = new int[7];

    // Spring initializes thin interface WITH a class.
    // This bean will be used communicate with hibernate in order to acces "users" in the db --> orm.
    // This class will be implementing the interface "UserRepository"
    @Autowired
    private UserRepository userRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    LandingPagePresenter landingPagePresenter;

    @GetMapping("/")
    public String getLandingPage(Principal principal, Model indexModel, boolean createActivity, boolean activateErrorHandling){

        if(activateErrorHandling){

            for(int i = 0; i<6; i++){

                int errorCode = errorCodes[i];

                switch(errorCode) {
                    case 1:
                        boolean titleError = true;
                        indexModel.addAttribute("titleError", titleError);
                        errorCodes[0] = 0;
                        break;
                    case 2:
                        boolean descriptionError = true;
                        indexModel.addAttribute("descriptionError",descriptionError);
                        errorCodes[1] = 0;
                        break;
                    case 3:
                        boolean priceError = true;
                        indexModel.addAttribute("priceError",priceError);
                        errorCodes[2] = 0;
                        break;
                    case 4:
                        boolean durationError = true;
                        indexModel.addAttribute("durationError",durationError);
                        errorCodes[3] = 0;
                        break;
                    case 5:
                        boolean ageError = true;
                        indexModel.addAttribute("ageError",ageError);
                        errorCodes[4] = 0;
                        break;
                    case 6:
                        boolean participantsError = true;
                        indexModel.addAttribute("participantsError",participantsError);
                        errorCodes[5] = 0;
                        break;
                    case 7:
                        boolean photoURLError = true;
                        indexModel.addAttribute("photoURLError",photoURLError);
                        errorCodes[6] = 0;
                        break;
                }

            }
        }


        //Add variable "newActivity" to Model.
        indexModel.addAttribute("createActivity", createActivity);

        //Add singleActivity to model (for edit or default)
        ActivityVTO defaultActivityVTO = landingPagePresenter.getDefaultActivityVTO(new Activity());
        indexModel.addAttribute("defaultActivityVTO", defaultActivityVTO);

        // Get list of ActivityVTO's for model
        ArrayList<ActivityVTO> activityVTOList = landingPagePresenter.getActivityVTOList();

        //Add activityVTOList to Model.
        indexModel.addAttribute("activityVTOList", activityVTOList);


        //Add variable control variable "loggedIn" to Model.
        boolean loggedIn;
        if(principal != null){ loggedIn = true; }
        else { loggedIn = false; }

        indexModel.addAttribute("loggedIn", loggedIn);

        return "index";

    }


    @GetMapping("/login")
    public String getLogIn(){

        return "login";
    }


    @PostMapping("/createActivity")
    public String getLandingPage(WebRequest dataFromFormCreateActivity){

        Activity newActivity = new Activity();
        ValidateActivityService validateActivityService = new ValidateActivityService();

        ActivityValidationVTO activityValidationVTO = validateActivityService.validateNewActivity(dataFromFormCreateActivity, newActivity);

        if(activityValidationVTO.getStatusCode()){
            activityRepository.save(newActivity);
        }


        if(!activityValidationVTO.getIsValidTitle()){
            errorCodes[0] = 1;
        }
        if(!activityValidationVTO.getIsValidDescription()){
            errorCodes[1] = 2;
        }
        if(!activityValidationVTO.getIsValidPrice()){
            errorCodes[2] = 3;
        }
        if(!activityValidationVTO.getIsValidDurationMinutes()){
            errorCodes[3] = 4;
        }
        if(!activityValidationVTO.getIsValidMinAge()){
            errorCodes[4] = 5;

        }
        if(!activityValidationVTO.getIsValidMaxParticipants()){
            errorCodes[5] = 6;
        }
        if(!activityValidationVTO.getIsValidPhotoURL()){
            errorCodes[6] = 7;
        }

        return "redirect:/?createActivity=true&activateErrorHandling=true";
    }




}

// Bruger følgende til at oprette passwords til brugere i systemet: https://bcryptgenerator.com/