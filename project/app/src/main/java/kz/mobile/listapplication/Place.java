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
    private City city;
    @SerializedName("country")
    private Country country;
    @SerializedName("price")
    private int price;
    @SerializedName("address")
    private String address;
    @SerializedName("place_type")
    private int place_type;

    public Place(int id, String name, String avatar, City city, Country country,
                 int price, String address, int place_type){
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.city = city;
        this.country = country;
        this.price = price;
        this.address = address;
        this.place_type = place_type;
    }

    public String getName(){
        return this.name;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public City getCity(){
        return this.city;
    }

    public Country getCountry(){
        return this.country;
    }

    public int getPrice(){
        return this.price;
    }

    public void setName(String name){
        this.name = name;
    }
}
