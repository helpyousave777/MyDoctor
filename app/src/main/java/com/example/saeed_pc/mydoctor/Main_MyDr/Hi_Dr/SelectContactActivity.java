package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr;

import android.content.Intent;
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

import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Info.Info_All_Doctor_Information;
import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Operation_MyDr_AllDoctor_Info;
import com.example.saeed_pc.mydoctor.Accessories.constValue_General.constValue_General;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.SelectContact.Adapter.Recycler_View_Adapter_SelectDr_HiDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.SelectContact.Data.Data_SelectDr_HiDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.SelectContact.Listener.RecyclerItemClickListener_SelectDr_HiDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.dialog.dialog;
import com.example.saeed_pc.mydoctor.Main_MyDr.MainMyDr;
import com.example.saeed_pc.mydoctor.R;

import java.util.ArrayList;
import java.util.List;

public class SelectContactActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_contact);
        dialog =new dialog(this);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_SelectDr_HiDr);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Select Your Doctor");

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        List<Data_SelectDr_HiDr> data = fillData();



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerView_SelectDr_HiDr);
        Recycler_View_Adapter_SelectDr_HiDr adapter = new Recycler_View_Adapter_SelectDr_HiDr(data, this);
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
                new RecyclerItemClickListener_SelectDr_HiDr(this, new RecyclerItemClickListener_SelectDr_HiDr.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO Handle item click
                        MainMyDr.flag_question_pos = constValue_General.HyDr_NewMessage;
                        dialog.newMessage(position);
                    }


                })
        );




        Log.i("===>", "onCreate.10 ");

        //  adapter.animate();
    }


    public List<Data_SelectDr_HiDr> fillData(){

        //Todo extract data from DB and set on List

        Operation_MyDr_AllDoctor_Info allDoctor_DB = new Operation_MyDr_AllDoctor_Info(this);
        List<Info_All_Doctor_Information> list_DB = allDoctor_DB.getAll_MyDr_db_MyDr_AllDoctor_Info();
        List<Data_SelectDr_HiDr> list = new ArrayList<>();
        int res_Id = getResources().getIdentifier("test_dr", "mipmap",getPackageName());

        for (int i = 0; i < list_DB.size(); i++) {
            list.add(new Data_SelectDr_HiDr(list_DB.get(i).getName(), list_DB.get(i).getField(), res_Id));
        }


     //   list.add(new Data_SelectDr_HiDr("saeed", "first", R.mipmap.hi_doctor_search));
     //   list.add(new Data_SelectDr_HiDr("mushi", "second", R.mipmap.hi_doctor_search));
     //   list.add(new Data_SelectDr_HiDr("mahdi", "third", R.mipmap.hi_doctor_search));


        return list;
    }


    public void onClickBack_SelectDr(View view) {
        startActivity(new Intent(this, MainMyDr.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainMyDr.class));
        finish();
    }
}
