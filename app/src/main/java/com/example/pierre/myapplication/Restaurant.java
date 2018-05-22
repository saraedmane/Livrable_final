package com.example.pierre.myapplication;

import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant {
    public String distance;
    String business_id;
    public String name;
    String address;
    public Double latitude;
    public Double longitude;
    Double stars;
    public ArrayList<String> categories;
    Double review_count;
    Boolean is_open;
    double note;
    public HashMap<String,String> hours;

    public Restaurant(){}

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

    public String toString() {
        return "Name:"+" "+name+" / "+"Address:"+" "+address+" / Distance: "+distance+ " / "+"Stars:"+" "+stars+" / "+" Category: "+category(categories)+System.lineSeparator()+"Hours: "+hoursDisplay(hours);
    }

    public String getBusiness_id() {
        return business_id;
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

    public Double getReview_count() {
        return review_count;
    }

    public Boolean getIs_open() {
        return is_open;
    }

    public double getNote() {
        return note;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
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

    public void setReview_count(Double review_count) {
        this.review_count = review_count;
    }

    public void setIs_open(Boolean is_open) {
        this.is_open = is_open;
    }

    public void setNote(double note) {
        this.note = note;
    }
    public String category(ArrayList<String> categories2) {
        String a="";
        for (String word: categories2) {
            a+=word+", ";
        }
        return a;
    }
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
