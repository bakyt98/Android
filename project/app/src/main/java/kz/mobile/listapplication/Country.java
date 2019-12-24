package kz.mobile.listapplication;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public Country(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
