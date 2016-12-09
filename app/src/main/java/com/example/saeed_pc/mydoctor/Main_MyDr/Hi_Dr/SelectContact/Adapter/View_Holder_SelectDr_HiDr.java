package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.SelectContact.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saeed_pc.mydoctor.R;

/**
 * Created by ici80071 on 4/13/2016.
 */


public class View_Holder_SelectDr_HiDr extends RecyclerView.ViewHolder {

    CardView cv;
    TextView title;
    TextView description;
    ImageView imageView;

   public View_Holder_SelectDr_HiDr(View itemView) {
        super(itemView);
        Log.i("===>", "View_Holder_SelectDr_HiDr.0 ");
        cv = (CardView) itemView.findViewById(R.id.cardView_Recycler_SelectDr_HiDr);
        title = (TextView) itemView.findViewById(R.id.title_SelectDr_HiDr);
        description = (TextView) itemView.findViewById(R.id.description_SelectDr_HiDr);
        imageView = (ImageView) itemView.findViewById(R.id.imageView_Recycler_SelectDr_HiDr);
        Log.i("===>", "View_Holder_SelectDr_HiDr.0 " );
    }
}
