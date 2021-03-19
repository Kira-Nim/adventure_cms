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

        //For getting a formatted price as string for each activityVTO
        PriceService priceService = new PriceService();

        // Make list for ActivityVTO's for each Activity in db
        for (Activity activity : activityRepository.findAll()) {

            // Calculate hours and minutes of duration and make String.
            int durationHour = activity.getDurationMinutes() / 60;
            int durationMinutes = activity.getDurationMinutes() % 60;
            String durationString = "Varighed: " + durationHour + " " + "timer " + durationMinutes + " minutter";

            String priceString = priceService.getPriceString(activity.getPrice());

            ActivityVTO activityVTO = new ActivityVTO(activity, priceString, durationString);
            activityVTOList.add(activityVTO);
        }

        return activityVTOList;
    }
}

