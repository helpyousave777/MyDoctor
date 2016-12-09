package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.saeed_pc.mydoctor.Accessories.constValue_General.constValue_General;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.Database_HiDr.Operation_HiDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDoctorQuestionActivity;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDr_UI.Adapter.Recycler_View_Adapter_Main_HiDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDr_UI.Listener.RecyclerItemClickListener_Main_HiDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.QuestionHiDrActivity;
import com.example.saeed_pc.mydoctor.Main_MyDr.MainMyDr;

import java.util.Collections;
import java.util.List;

/**
 * Created by SAEED-PC on 11/22/2015.
 */
public class listViewOperation_HiDr {



    private static Context context;
    private static List<Info_HiDoctor_UserApp> all_message_info;
    private static Operation_HiDr operation_hiDr;


    public listViewOperation_HiDr(Context context) {

        this.context =context;
        operation_hiDr = new Operation_HiDr(context);
    }

    public static void advancedListView(ListView listView){

        try {

            Log.i("===>","advancedListView.1");
            all_message_info = operation_hiDr.getAll_HiDr_db_MyDr();
            Log.i("===>", "advancedListView.2 info size:"+all_message_info.size());
            Collections.sort(all_message_info, new compare_date());
            Log.i("===>", "advancedListView.2");


            //Todo this part should be replaced with recycler view

            //from
            arrayAdapter adapter =new arrayAdapter(context,all_message_info);
            Log.i("===>","advancedListView.3");
            listView.setAdapter(adapter);
            Log.i("===>", "advancedListView.4");

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.i("===>", "advancedListView.4.1");

                    Intent intent = new Intent(context, QuestionHiDrActivity.class);
                    Log.i("===>", "advancedListView.4.2");
                    setIntentPutExtra(position, intent);
                    Log.i("===>", "advancedListView.4.3");
                    context.startActivity(intent);
                    Log.i("===>", "advancedListView.4.4");
                }
            });
            Log.i("===>", "advancedListView.5");
        }catch (Exception e){
            Log.i("===>","advancedListView.oops");
           // Toast.makeText(context,"There is no message !!",Toast.LENGTH_LONG).show();
        }

        //to

    }

    public static void setIntentPutExtra(int position, Intent intent) {
        Info_HiDoctor_UserApp info_Message = all_message_info.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("HiDr_information", info_Message);
        intent.putExtras(bundle);
        Log.i("===>", "advancedListView.4.setIntentPutExtra position :"+position+"info: "+ info_Message);


    }


    public static void advancedRecyclerView(RecyclerView recycler){

        try {

            Log.i("===>","advancedListView.1");
            all_message_info = operation_hiDr.getAll_HiDr_db_MyDr();
            Log.i("===>", "advancedListView.2 info size:"+all_message_info.size());
            Collections.sort(all_message_info, new compare_date());
            Log.i("===>", "advancedListView.2");


            //Todo this part should be replaced with recycler view

            //from
            Recycler_View_Adapter_Main_HiDr adapter =new Recycler_View_Adapter_Main_HiDr(all_message_info,context);
            Log.i("===>", "advancedListView.3");
            recycler.setAdapter(adapter);
            recycler.setLayoutManager(new LinearLayoutManager(context));

            RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
            itemAnimator.setAddDuration(1000);
            itemAnimator.setRemoveDuration(1000);
            recycler.setItemAnimator(itemAnimator);


            Log.i("===>", "advancedListView.4");





            // listener
            recycler.addOnItemTouchListener(
                    new RecyclerItemClickListener_Main_HiDr(context, new RecyclerItemClickListener_Main_HiDr.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            // TODO Handle item click
                            Log.i("===>", "advancedListView.4.1");

                            Intent intent = new Intent(context, HiDoctorQuestionActivity.class);
                            Log.i("===>", "advancedListView.4.2");
                            setIntentPutExtra(position, intent);
                            Log.i("===>", "advancedListView.4.3");
                            MainMyDr.flag_question_pos = constValue_General.HyDr_ShowMessage;
                            context.startActivity(intent);
                            Log.i("===>", "advancedListView.4.4");
                        }


                    })
            );


            Log.i("===>", "advancedListView.5");
        }catch (Exception e){
            Log.i("===>","advancedListView.oops");
            // Toast.makeText(context,"There is no message !!",Toast.LENGTH_LONG).show();
        }

        //to

    }

}
