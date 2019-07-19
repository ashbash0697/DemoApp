package com.example.demobluestone.utils;

public class BlueStoneResponseHandler {
    public interface ResponseListner<T>{
        void onSuccess(T response);
    }
    public interface ErrorListner<T>{
        void onError(Throwable errorWrapper);
    }
}
