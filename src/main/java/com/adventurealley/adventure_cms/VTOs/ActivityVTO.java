package com.adventurealley.adventure_cms.VTOs;

import com.adventurealley.adventure_cms.model.Activity;


public class ActivityVTO {

    private Activity activity;
    private String priceString;
    private String durationString;


    public ActivityVTO(Activity activity, String priceString, String durationString) {
        this.activity = activity;
        this.priceString = priceString;
        this.durationString = durationString;
    }

    public Activity getActivity() { return activity; }
    public String getPriceString() { return priceString; }
    public String getDurationString() { return durationString; }
}
