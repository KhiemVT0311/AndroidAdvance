package com.eup.androidadvancedemo.model;

import androidx.annotation.DrawableRes;

import com.google.gson.annotations.SerializedName;

public class News {
    private @DrawableRes int resId;

    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String desc;
    @SerializedName("url")
    private String url;
    @SerializedName("urlToImage")
    private String image;
    @SerializedName("publishedAt")
    private String pubDate;

    public int getResId() {
        return resId;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public String getPubDate() {
        return pubDate;
    }
}
