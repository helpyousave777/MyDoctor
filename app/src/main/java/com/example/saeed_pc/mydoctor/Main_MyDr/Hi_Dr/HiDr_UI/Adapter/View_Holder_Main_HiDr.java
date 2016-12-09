package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDr_UI.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saeed_pc.mydoctor.R;

/**
 * Created by ici80071 on 4/26/2016.
 */
public class View_Holder_Main_HiDr  extends RecyclerView.ViewHolder {

    CardView cv;

    TextView  Name_Dr;
    ImageView image_Dr;

    TextView  subject_PM;
    TextView time_PM;
    ImageView delivery_PM;

    public View_Holder_Main_HiDr(View itemView) {
        super(itemView);
        Log.i("===>", "View_Holder_SelectDr_HiDr.0 ");

        cv = (CardView) itemView.findViewById(R.id.cardView_Recycler_HiDr);

        Name_Dr = (TextView) itemView.findViewById(R.id.title_Recycler_HiDr);
        image_Dr = (ImageView) itemView.findViewById(R.id.imageView_Recycler_HiDr);

        subject_PM = (TextView) itemView.findViewById(R.id.subject_Recycler_HiDr);
        time_PM = (TextView) itemView.findViewById(R.id.txtHiDr_main_Recycler_date);
        delivery_PM = (ImageView) itemView.findViewById(R.id.imgDelivey_Recycler_HiDr);

        Log.i("===>", "View_Holder_SelectDr_HiDr.1 " );
    }
}
