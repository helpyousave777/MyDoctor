package com.example.saeed_pc.mydoctor.OnTabSwipable.RecycleView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.saeed_pc.mydoctor.OnTabSwipable.RecycleView.adapter.Recycler_View_Adapter;
import com.example.saeed_pc.mydoctor.OnTabSwipable.RecycleView.data.Data;
import com.example.saeed_pc.mydoctor.OnTabSwipable.RecycleView.listener.RecyclerItemClickListener;
import com.example.saeed_pc.mydoctor.R;

import java.util.ArrayList;
import java.util.List;

public class MainResycleView extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        List<Data> data = fillData();
        Log.i("===>","data "+data);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplication());
        // add adapter to recycle
        recyclerView.setAdapter(adapter);
        // set one of default layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // set one of default animator for add, remove and select item
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);


        // listener
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click
                    }
                })
        );

      //  adapter.animate();
    }

    public List<Data> fillData(){
        List<Data> list = new ArrayList<>();

        list.add(new Data("saeed","first",R.mipmap.hi_doctor_search));
        list.add(new Data("mushi","second",R.mipmap.hi_doctor_search));
        list.add(new Data("mahdi","third",R.mipmap.hi_doctor_search));


        return list;
    }

}

