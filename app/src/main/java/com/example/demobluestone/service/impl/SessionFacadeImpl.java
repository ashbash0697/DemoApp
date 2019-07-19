package com.example.demobluestone.service.impl;

import com.example.demobluestone.service.CollectionApiService;
import com.example.demobluestone.service.SessionFacade;
import com.example.demobluestone.utils.BlueStoneResponseHandler;

public class SessionFacadeImpl implements SessionFacade {

    private static SessionFacade sessionFacade;
    private static CollectionApiService collectionApiService;

   public SessionFacadeImpl(){
   }

   //thank you for telling me about this:)
   public synchronized static SessionFacade getInstance(){
       sessionFacade = new SessionFacadeImpl();
       collectionApiService = CollectionApiServiceImpl.getInstance();
       return sessionFacade;
   }


    @Override
    public void getCollections(Boolean flag, String authKey, BlueStoneResponseHandler.ResponseListner responseListner, BlueStoneResponseHandler.ErrorListner errorListner) {
       collectionApiService.getCollections(flag, authKey, responseListner, errorListner);
    }
}
