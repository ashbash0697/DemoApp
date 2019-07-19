package com.example.demobluestone.service.api;

import com.example.demobluestone.model.response.JewelCollections;
import com.example.demobluestone.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CollectionAPI {
    @Headers("content-type: application/json;charset=UTF-8")
    @GET(Constants.BASE_URL+"/bluestone")
    Call<JewelCollections> getCollections (@Query("show_collections") Boolean flag, @Header("auth_key") String authKey);
}
