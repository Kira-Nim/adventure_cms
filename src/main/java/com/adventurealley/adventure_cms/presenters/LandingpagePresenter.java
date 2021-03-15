package com.adventurealley.adventure_cms.presenters;

import com.adventurealley.adventure_cms.model.Activity;
import com.adventurealley.adventure_cms.model.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
public class LandingpagePresenter {

    @Autowired
    private ActivityRepository activityRepository;

    // Get all upcoming activities from db
    public List<Activity> getAllUpcomingActivities(){

        List<Activity> activityList = activityRepository.findAll();
        ArrayList<Activity> upcomingActivityList = new ArrayList<Activity>();

        List<Activity> sortedActivityList = activityList
                .stream()
                .sorted(Comparator.comparing(Activity::getTitle))
                .collect(Collectors.toList());

        for(Activity activity : activityList){

            System.out.println(activity.getTitle());

            if(activity.getStartDateTime().isBefore(LocalDateTime.now())){
                upcomingActivityList.add(activity);
            }
        }

        return upcomingActivityList;
    }


    // Remove duplicates from List using Stream

    public List<Activity> getUpcomingActivityListWithoutDuplicates(){
        getAllUpcomingActivities();

        return noDuplicatesList;
    }

    Stream<Activity> activityStream = activityList.stream();
    List<Activity> noDuplicatesActivityList = activityList
            .stream()
            .distinct()
            .collect(Collectors.toList());
}
