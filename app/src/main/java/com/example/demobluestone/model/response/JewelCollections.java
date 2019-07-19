package com.example.demobluestone.model.response;

import com.example.demobluestone.model.common.JCollection;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JewelCollections {
    @SerializedName("collections")
    @Expose
    private List<JCollection> collections = null;

    public List<JCollection> getCollections() {
        return collections;
    }

    public void setCollections(List<JCollection> collections) {
        this.collections = collections;
    }
}
