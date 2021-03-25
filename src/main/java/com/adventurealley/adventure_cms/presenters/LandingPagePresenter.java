package com.adventurealley.adventure_cms.presenters;

import com.adventurealley.adventure_cms.VTOs.ActivityVTO;
import com.adventurealley.adventure_cms.model.Activity;
import com.adventurealley.adventure_cms.model.ActivityRepository;
import com.adventurealley.adventure_cms.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;


@Component
public class LandingPagePresenter {

    @Autowired
    ActivityRepository activityRepository;

    public ArrayList<ActivityVTO> getActivityVTOList() {

        ArrayList<ActivityVTO> activityVTOList = new ArrayList<ActivityVTO>();


        // Make list for ActivityVTO's for each Activity in db
        for (Activity activity : activityRepository.findAll()) {
            ActivityVTO newActivityVTO = this.tempName(activity);
            newActivityVTO.setActivity(activity);
            activityVTOList.add(newActivityVTO);
        }

        return activityVTOList;
    }

    public ActivityVTO getDefaultActivityVTO(Activity activity) {

        ActivityVTO activityVTO = new ActivityVTO();
        activityVTO.setActivity(activity);
        activityVTO.setPriceString("fx. 235.50");
        activityVTO.setDurationString("Varighed i minutter - fx. 240");
        activityVTO.getActivity().setTitle("ny titel");
        activityVTO.getActivity().setPhotoURL("indsæt url til foto");
        activityVTO.getActivity().setDescription("Skriv beskrivelse her.. maks 700 anslag");

        return activityVTO;
    }


    // Help method for creating an instance of activityVTO and setting attributes priceString and durationString on this.
    public ActivityVTO tempName(Activity activity){

        // Calculate hours and minutes of duration and make String.
        int durationHour = activity.getDurationMinutes() / 60;
        int durationMinutes = activity.getDurationMinutes() % 60;
        String durationString = "Varighed: " + durationHour + " " + "timer " + durationMinutes + " minutter";

        //For getting a formatted price as string for each activityVTO
        PriceService priceService = new PriceService();
        String priceString = priceService.getPriceString(activity.getPrice());

        // Create AvtivityVTO obj
        ActivityVTO activityVTO = new ActivityVTO();

        // set setPriceString and setDurationString on activityVTO
        activityVTO.setPriceString(priceString);
        activityVTO.setDurationString(durationString);

        return activityVTO;

    }


}

