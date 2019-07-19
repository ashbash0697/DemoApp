package com.example.demobluestone.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.demobluestone.model.common.HeaderItem;
import com.example.demobluestone.model.common.JCollection;
import com.example.demobluestone.model.common.ListItem;
import com.example.demobluestone.model.response.JewelCollections;
import com.example.demobluestone.service.SessionFacade;
import com.example.demobluestone.service.impl.SessionFacadeImpl;
import com.example.demobluestone.utils.BlueStoneResponseHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class MainActivityViewModel extends ViewModel {

    public static final String authKey = "asdfasdf1234123";

    private MutableLiveData<List<ListItem>> collectionList;

    public LiveData<List<ListItem>> getCollection(){
        if (collectionList == null){
            collectionList = new MutableLiveData<List<ListItem>>();
            fetchCollectionFromApi();
        }
        return collectionList;
    }

    private void fetchCollectionFromApi() {
        SessionFacadeImpl.getInstance().getCollections(true, authKey,new BlueStoneResponseHandler.ResponseListner() {
            @Override
            public void onSuccess(Object response) {
                if ((JewelCollections) response!=null){
                    List<JCollection> collections = ((JewelCollections) response).getCollections();
                    if (!collections.isEmpty()){
                        sortCollections(collections);
                    }
                }

            }
        }, new BlueStoneResponseHandler.ErrorListner() {
            @Override
            public void onError(Throwable errorWrapper) {

            }
        });
    }

    private void sortCollections(List<JCollection> collections) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM-yyyy", Locale.ENGLISH);
        Collections.sort(collections, new Comparator<JCollection>() {
            @Override
            public int compare(JCollection o1, JCollection o2) {
                try {
                    return simpleDateFormat.parse(o1.getDate()).compareTo(simpleDateFormat.parse(o2.getDate()));
                } catch (ParseException e) {
                    return 0;
                }
            }
        });

        HashSet<String> dateFound = new HashSet<>();
        List<ListItem> listItems = new ArrayList<>();

        for (JCollection temp: collections) {
            if (dateFound.add(temp.getDate())){
                HeaderItem headerItem = new HeaderItem();
                headerItem.setHeadingName(temp.getDate());
                listItems.add(headerItem);
                listItems.add(temp);
            }else {
                listItems.add(temp);
            }
        }

        collectionList.setValue(listItems);

    }

}
