package kz.mobile.listapplication;

import android.widget.ImageView;

public class Place {
    private int photo;
    private String name;
    private String city_country;
    private int price;
    private String working_days;
    private String working_hours;

    public Place(String name, int photo, String city_country, int price, String working_days, String working_hours ){
        this.name = name;
        this.photo = photo;
        this.city_country = city_country;
        this.price = price;
        this.working_days = working_days;
        this.working_hours = working_hours;
    }

    public String getName(){
        return this.name;
    }

    public int getPhoto() {
        return this.photo;
    }

    public String getCity_country(){
        return this.city_country;
    }
    public String getWorking_days(){
        return this.working_days;
    }
    public String getWorking_hours(){
        return this.working_hours;
    }
    public int getPrice(){
        return this.price;
    }

    public void setName(String name){
        this.name = name;
    }
}
