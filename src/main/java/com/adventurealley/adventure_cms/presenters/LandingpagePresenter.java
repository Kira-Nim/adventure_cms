package com.adventurealley.adventure_cms.presenters;

import com.adventurealley.adventure_cms.model.Activity;
import com.adventurealley.adventure_cms.model.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class LandingpagePresenter {

    @Autowired
    private ActivityRepository activityRepository;

    // Get all upcoming activities from db
    public List<Activity> getAllUpcomingActivities() {

        ArrayList<Activity> upcomingActivityList = new ArrayList<Activity>();

        try {
            List<Activity> activityList = activityRepository.findAll();
            List<Activity> sortedActivityList = activityList
                    .stream()
                    .sorted(Comparator.comparing(Activity::getTitle))
                    .collect(Collectors.toList());

            for (Activity activity : activityList) {

                System.out.println(activity.getTitle());

                if (activity.getStartDateTime().isBefore(LocalDateTime.now())) {
                    upcomingActivityList.add(activity);
                }
            }
        }catch(Exception e){ upcomingActivityList = null; }

        return upcomingActivityList;
    }



    // Get List of activity titles without duplicates.
    public List<String> getUpcomingActivityTitleListNoDuplicates(){

        ArrayList<String> titleList = new ArrayList<String>();

        try {
            for (Activity activity : getAllUpcomingActivities()) {
                titleList.add(activity.getTitle());
            }

            List<String> noDuplicatesTitleList = titleList
                    .stream()
                    .distinct()
                    .collect(Collectors.toList());

            return noDuplicatesTitleList;

        }catch(Exception e){
            List<String> noDuplicatesTitleList = null;
            return noDuplicatesTitleList;
        }

    }

}
