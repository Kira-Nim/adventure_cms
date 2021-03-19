package com.adventurealley.adventure_cms.services;

public class PriceService {


    public String getPriceString(float price){
        String priceString = "Pris: " + String.format("%.02f", price) + " kr";
        return priceString;
    }
}
