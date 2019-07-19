package com.example.demobluestone.service;

import com.example.demobluestone.utils.BlueStoneResponseHandler;

public interface CollectionApiService {

    void getCollections(Boolean flag, String authKey, BlueStoneResponseHandler.ResponseListner responseListner, BlueStoneResponseHandler.ErrorListner errorListner);
}
