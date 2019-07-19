package com.example.demobluestone.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.demobluestone.R;
import com.example.demobluestone.ViewModel.MainActivityViewModel;
import com.example.demobluestone.model.common.JCollection;
import com.example.demobluestone.model.common.ListItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rec_view)
    RecyclerView recView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MainActivityViewModel mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        recView.setHasFixedSize(true);
        recView.setLayoutManager(new LinearLayoutManager(this));


        mainActivityViewModel.getCollection().observe(this, new Observer<List<ListItem>>() {
            @Override
            public void onChanged(@Nullable List<ListItem> jCollections) {
                CollectionAdapter collectionAdapter = new CollectionAdapter(MainActivity.this, jCollections);
                recView.setAdapter(collectionAdapter);
            }
        });

    }
}
