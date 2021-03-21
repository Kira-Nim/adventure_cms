package com.adventurealley.adventure_cms.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterService {

    // Method for formatting a LocalDateTime obj and making a string that looks like this:
    // 21 Mar 2021  21:51
    public String getDateTimePresentationString(LocalDateTime localDateTime){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm");

        String[] parts = localDateTime.format(formatter).split(",");

        String[] monthDate = parts[1].split(" ");
        String month = monthDate[1];
        String dayInMonth = monthDate[2];

        String[] yearTime = parts[2].split(" ");
        String year = yearTime[1];
        String time = yearTime[2];

        if(month.equals("Oct")){
            month = "Okt";
        }

        String dateTimeString = dayInMonth + " " + month + " " + year + "  " + time;

        return dateTimeString;
    }

}
