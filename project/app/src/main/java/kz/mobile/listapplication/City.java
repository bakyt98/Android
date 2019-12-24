package kz.mobile.listapplication;

import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private int country;

    public City(int id, String name, int country){
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
