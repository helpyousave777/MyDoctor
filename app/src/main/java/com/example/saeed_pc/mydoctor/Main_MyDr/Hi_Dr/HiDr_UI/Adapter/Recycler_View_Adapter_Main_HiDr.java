package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDr_UI.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.saeed_pc.mydoctor.Accessories.constValue_General.constValue_General;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDr_UI.Data.DrInfoViaDrID;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.date.date;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.Info_HiDoctor_UserApp;
import com.example.saeed_pc.mydoctor.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by ici80071 on 4/26/2016.
 */


public class Recycler_View_Adapter_Main_HiDr extends RecyclerView.Adapter<View_Holder_Main_HiDr> {

    List<Info_HiDoctor_UserApp> list = Collections.emptyList();
    private LayoutInflater inflater;

    Context context;

    public Recycler_View_Adapter_Main_HiDr(List<Info_HiDoctor_UserApp> list, Context context) {
        Log.i("===>", "Recycler_View_Adapter_SelectDr_HiDr.1 " );
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        Log.i("===>", "Recycler_View_Adapter_SelectDr_HiDr.2 " );
    }




    @Override
    public View_Holder_Main_HiDr onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        Log.i("===>", "onCreateViewHolder.1 ");
        View view = inflater.inflate(R.layout.row_layout_hi_dr, parent, false);
        Log.i("===>", "onCreateViewHolder.2 ");
        View_Holder_Main_HiDr holder = new View_Holder_Main_HiDr(view);
        Log.i("===>", "onCreateViewHolder.3 ");
        return holder;
    }






    @Override
    public void onBindViewHolder(View_Holder_Main_HiDr holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        Log.i("===>", "onBindViewHolder.0 ");
        Info_HiDoctor_UserApp current = list.get(position);

        String subject = cut_Subject(current.getSubject());
        String date_status = date.date_status(current);

        Log.i("===>", "onBindViewHolder.0.1 dr ID: "+current.getReservation1() );
        DrInfoViaDrID drInfoViaDrID = new DrInfoViaDrID(current , context);
        Log.i("===>", "onBindViewHolder.0.2 title: " + drInfoViaDrID.getDrName());
            holder.Name_Dr.setText(drInfoViaDrID.getDrName());
        Log.i("===>", "onBindViewHolder.1 title: " + drInfoViaDrID.getDrName());
            holder.image_Dr.setImageResource(drInfoViaDrID.getDrImageID());
        Log.i("===>", "onBindViewHolder.1 title: " + drInfoViaDrID.getDrImageID());


            holder.subject_PM.setText(subject);
        Log.i("===>", "onBindViewHolder.1 title: " + list.get(position).getSubject());
            holder.time_PM.setText(date_status);
        Log.i("===>", "onBindViewHolder.1 title: " + date_status);
        holder.delivery_PM.setVisibility(View.INVISIBLE);
         //   holder.delivery_PM.setImageResource(current.getDelivery_Id_PM());
        Log.i("===>", "onBindViewHolder.1 title: ");









        //animate(holder);

    }


    @Override
    public int getItemCount() {
        Log.i("===>", "getItemCount.1 size: " + list.size());
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Log.i("===>", "onAttachedToRecyclerView.0 " );
        super.onAttachedToRecyclerView(recyclerView);
        Log.i("===>", "onAttachedToRecyclerView.0 ");
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Info_HiDoctor_UserApp data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Info_HiDoctor_UserApp data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }



    private String cut_Subject(String main_subject){
        String subject="";
        if(main_subject.length()> constValue_General.number_cut_subject_HiDr_ListView){
            subject=main_subject.substring(0,constValue_General.number_cut_subject_HiDr_ListView)+"...";
        }else{
            subject=main_subject;
        }
        return subject;
    }

}
