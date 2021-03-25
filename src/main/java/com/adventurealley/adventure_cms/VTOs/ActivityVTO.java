package com.adventurealley.adventure_cms.VTOs;

import com.adventurealley.adventure_cms.model.Activity;


public class ActivityVTO {

    private Activity activity;
    private String priceString;
    private String durationString;


    public Activity getActivity() { return activity; }
    public void setActivity(Activity activity) { this.activity = activity; }

    public String getPriceString() { return priceString; }
    public void setPriceString(String priceString) { this.priceString = priceString; }

    public String getDurationString() { return durationString; }
    public void setDurationString(String durationString) { this.durationString = durationString; }


}
