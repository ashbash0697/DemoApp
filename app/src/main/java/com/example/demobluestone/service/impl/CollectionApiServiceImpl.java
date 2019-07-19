package com.example.demobluestone.service.impl;

import com.example.demobluestone.model.response.JewelCollections;
import com.example.demobluestone.service.CollectionApiService;
import com.example.demobluestone.service.ServiceGenerator;
import com.example.demobluestone.service.api.CollectionAPI;
import com.example.demobluestone.utils.BlueStoneResponseHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollectionApiServiceImpl implements CollectionApiService {
    private CollectionAPI collectionAPI;
    private static CollectionApiServiceImpl collectionApiService;

    public CollectionApiServiceImpl(){
        collectionAPI = ServiceGenerator.createService(CollectionAPI.class);
    }

    public static CollectionApiServiceImpl getInstance(){
        if (collectionApiService == null){
            collectionApiService = new CollectionApiServiceImpl();
        }
        return collectionApiService;
    }


    @Override
    public void getCollections(Boolean flag, String authKey, final BlueStoneResponseHandler.ResponseListner responseListner, final BlueStoneResponseHandler.ErrorListner errorListner) {
        Call<JewelCollections> jewelCollectionsCall = collectionAPI.getCollections(flag, authKey);
        jewelCollectionsCall.enqueue(new Callback<JewelCollections>() {
            @Override
            public void onResponse(Call<JewelCollections> call, Response<JewelCollections> response) {
                responseListner.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<JewelCollections> call, Throwable t) {
                errorListner.onError(t);
            }
        });
    }
}
