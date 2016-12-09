package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.SelectContact.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collections;
import java.util.List;

import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.SelectContact.Data.Data_SelectDr_HiDr;
import com.example.saeed_pc.mydoctor.R;


/**
 * Created by ici80071 on 4/13/2016.
 */

public class Recycler_View_Adapter_SelectDr_HiDr extends RecyclerView.Adapter<View_Holder_SelectDr_HiDr> {

    List<Data_SelectDr_HiDr> list = Collections.emptyList();
    private LayoutInflater inflater;

    Context context;

    public Recycler_View_Adapter_SelectDr_HiDr(List<Data_SelectDr_HiDr> list, Context context) {
        Log.i("===>", "Recycler_View_Adapter_SelectDr_HiDr.1 " );
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        Log.i("===>", "Recycler_View_Adapter_SelectDr_HiDr.2 " );
    }




    @Override
    public View_Holder_SelectDr_HiDr onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        Log.i("===>", "onCreateViewHolder.1 " );
        View view = inflater.inflate(R.layout.row_layout, parent, false);
        Log.i("===>", "onCreateViewHolder.2 " );
        View_Holder_SelectDr_HiDr holder = new View_Holder_SelectDr_HiDr(view);
        Log.i("===>", "onCreateViewHolder.3 ");
        return holder;

    }




    @Override
    public void onBindViewHolder(View_Holder_SelectDr_HiDr holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        Log.i("===>", "onBindViewHolder.0 ");
        Data_SelectDr_HiDr current = list.get(position);
        Log.i("===>", "onBindViewHolder.1 title: " + list.get(position).title);
        holder.title.setText(current.getTitle());
        Log.i("===>", "onBindViewHolder.2 description: " + list.get(position).description);
        holder.description.setText(current.getDescription());
        Log.i("===>", "onBindViewHolder.3 ");
       // Bitmap bitMap = BitmapFactory.decodeFile("");
       // holder.imageView.setImageBitmap(bitMap);
        holder.imageView.setImageResource(current.getImageId());
        Log.i("===>", "onBindViewHolder.4 ");

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
    public void insert(int position, Data_SelectDr_HiDr data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Data_SelectDr_HiDr data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }



}