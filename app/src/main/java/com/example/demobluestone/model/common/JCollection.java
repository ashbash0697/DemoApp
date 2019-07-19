package com.example.demobluestone.model.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JCollection extends ListItem{
    @SerializedName("tag_name")
    @Expose
    private String tagName;
    @SerializedName("design_count")
    @Expose
    private Integer designCount;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("start_price")
    @Expose
    private Integer startPrice;
    @SerializedName("short_description")
    @Expose
    private String shortDescription;
    @SerializedName("name")
    @Expose
    private String name;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getDesignCount() {
        return designCount;
    }

    public void setDesignCount(Integer designCount) {
        this.designCount = designCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
