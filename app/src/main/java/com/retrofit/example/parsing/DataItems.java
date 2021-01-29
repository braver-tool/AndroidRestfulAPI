package com.retrofit.example.parsing;

import com.google.gson.annotations.SerializedName;

public class DataItems {
    @SerializedName("name")
    private String name;
    @SerializedName("about")
    private String about;
    @SerializedName("link")
    private String link;
    @SerializedName("profile_url")
    private String profile_url;
    @SerializedName("quote")
    private String quote;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }


}
