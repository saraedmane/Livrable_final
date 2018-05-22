package com.example.pierre.myapplication;

import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant {
    public String distance;
    public String name;
    public String address;
    public Double latitude;
    public Double longitude;
    public Double stars;
    public ArrayList<String> categories;
    public HashMap<String,String> hours;

    public Restaurant(double latitude,double longitude) {
        this.latitude=latitude;
        this.longitude=longitude;
    }
    public HashMap<String,String> getHours() {
        return hours;
    }
    public void setHours(HashMap<String,String> hours) {
        this.hours=hours;
    }
    public String getDistance() {
        return distance;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public ArrayList<String> getCategories() {
        return categories;
    }
    public Double getLatitude() {
        return latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public Double getStars() {
        return stars;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public void setStars(Double stars) {
        this.stars = stars;
    }


    //cette methode permet d afficher tous les mots cles dans un string
    public String category(ArrayList<String> categories2) {
        String a="";
        for (String word: categories2) {
            a+=word+", ";
        }
        return a;
    }

    //cette methode permet d afficher les heures en colonnes
    public String hoursDisplay(HashMap<String,String> hours) {
        String a="";
        if (hours.isEmpty())
            return "No schedules available";
        for (String key: hours.keySet()) {
            a+=key+":"+hours.get(key)+System.getProperty("line.separator");
        }
        return a;
    }
}
