package kz.mobile.listapplication;

import com.google.gson.annotations.SerializedName;

public class Company {
    @SerializedName("name")
    private String name;
    @SerializedName("catchPhrase")
    private String catchPhrase;
    @SerializedName("bs")
    private String bs;

    public Company(String name, String catchPhrase, String bs){
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public String getBs() {
        return bs;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }
}
