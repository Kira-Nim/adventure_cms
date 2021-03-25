package com.adventurealley.adventure_cms.services;

import com.adventurealley.adventure_cms.VTOs.ActivityValidationVTO;
import com.adventurealley.adventure_cms.model.Activity;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ValidateActivityService{


    public ActivityValidationVTO validateNewActivity(WebRequest dataFromForm, Activity newActivity){

        ActivityValidationVTO activityValidationVTO = new ActivityValidationVTO();


        // Validate title --> title max 200 characters
        if(dataFromForm.getParameter("title").length() <= 200){
            activityValidationVTO.setValidTitle(true);

            // Set title on new activity
            newActivity.setTitle(dataFromForm.getParameter("title"));
        }

        // Validate price --> of format kr,øre --> 200,50
        try{
            String priceString = dataFromForm.getParameter("price");

            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.CEILING);
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(',');
            df.setDecimalFormatSymbols(symbols);

            float price = df.parse(priceString).floatValue();

            // Set price on new activity
            activityValidationVTO.setValidPrice(true);

            newActivity.setPrice(price);

        }catch(Exception e){ System.out.println("exception on passing price from string to float");}


        // Validate working URL
        try {
            String photoURL = dataFromForm.getParameter("photoURL");

            URL url = new URL(photoURL);
            URLConnection conn = url.openConnection();
            conn.connect();

            activityValidationVTO.setValidPhotoURL(true);

            // Set attribute prhotoURL on new activity
            newActivity.setPhotoURL(photoURL);

        } catch (MalformedURLException e) {
            System.out.println("the URL is not in a valid form");
        } catch (IOException e) {
            System.out.println("the connection couldn't be established");
        }


        // Validate description text --> max 700 characters.
        if(dataFromForm.getParameter("description").length() <= 700){
            activityValidationVTO.setValidDescription(true);

            // Set description on new activity
            newActivity.setDescription(dataFromForm.getParameter("description"));
        }


        // Validate that maxParticipants is greater than 0 and of type int.
        try{
            int maxParticipants = Integer.parseInt(dataFromForm.getParameter("maxParticipants"));

            if(maxParticipants >=1){
                activityValidationVTO.setValidMaxParticipants(true);

                // Set maximum participants attribute on new activity
                newActivity.setMaxParticipants(maxParticipants);
            }

        }catch(Exception e){System.out.println("problem parsing maxparticipant string to int");}


        // Validate that duration is an integer -->
        try{
            int duration = Integer.parseInt(dataFromForm.getParameter("duration"));

            if(duration >0){
                activityValidationVTO.setValidDurationMinutes(true);
                newActivity.setDurationMinutes(duration);
            }

        }catch(Exception e){System.out.println("problem parsing duration string to int");}


        // validate min-age is an integer
        try{
            int minAge = Integer.parseInt(dataFromForm.getParameter("minAge"));

            activityValidationVTO.setValidMinAge(true);

            if(minAge <0){
                // Set minimum age attribute on new activity
                newActivity.setMinAge(0);
            }

            else{
                // Set minimum age attribute on new activity
                newActivity.setMinAge(minAge);
            }

        }catch(Exception e){System.out.println("problem parsing minAge string to int");}

        if(
            activityValidationVTO.getIsValidTitle() &&
            activityValidationVTO.getIsValidDescription() &&
            activityValidationVTO.getIsValidPrice() &&
            activityValidationVTO.getIsValidDurationMinutes() &&
            activityValidationVTO.getIsValidMinAge() &&
            activityValidationVTO.getIsValidMaxParticipants() &&
            activityValidationVTO.getIsValidPhotoURL()
        ){
            activityValidationVTO.setStatusCode(true);


        }

        return activityValidationVTO;
    }




}
