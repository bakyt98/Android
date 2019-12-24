package kz.mobile.listapplication;

import com.google.gson.annotations.SerializedName;

public class Address {
    @SerializedName("street")
    private String street;
    @SerializedName("suite")
    private String suite;
    @SerializedName("city")
    private String city;
    @SerializedName("zipcode")
    private String zipcode;
    @SerializedName("geo")
    private Geo geo;

    public Address(String street, String suite, String city, String zipcode, Geo geo){
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public Geo getGeo() {
        return geo;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
