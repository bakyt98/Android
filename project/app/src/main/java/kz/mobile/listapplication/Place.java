package kz.mobile.listapplication;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class Place {
    @SerializedName("id")
    private int id;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("name")
    private String name;
    @SerializedName("city")
    private JSONObject city;
    @SerializedName("country")
    private JSONObject country;
    @SerializedName("price")
    private int price;
    @SerializedName("address")
    private String address;
    private String working_days;
    private String working_hours;

    public Place(int id, String name, String avatar, JSONObject city, JSONObject country, int price, String address){
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.city = city;
        this.country = country;
        this.price = price;
        this.address = address;
    }

    public Place(String name, String avatar, JSONObject city, JSONObject country, int price, String working_days, String working_hours ){
        this.name = name;
        this.avatar = avatar;
        this.city = city;
        this.country = country;
        this.price = price;
        this.working_days = working_days;
        this.working_hours = working_hours;
    }

    public String getName(){
        return this.name;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public JSONObject getCity(){
        return this.city;
    }

    public JSONObject getCountry(){
        return this.country;
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
