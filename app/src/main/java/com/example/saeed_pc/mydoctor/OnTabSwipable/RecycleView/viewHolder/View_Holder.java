package com.example.saeed_pc.mydoctor.OnTabSwipable.RecycleView.viewHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saeed_pc.mydoctor.R;

public class View_Holder extends RecyclerView.ViewHolder {

    public CardView cv;
    public TextView title;
    public TextView description;
    public ImageView imageView;

    public View_Holder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView_Recycler_SelectDr_HiDr);
        title = (TextView) itemView.findViewById(R.id.title_SelectDr_HiDr);
        description = (TextView) itemView.findViewById(R.id.description_SelectDr_HiDr);
        imageView = (ImageView) itemView.findViewById(R.id.imageView_Recycler_SelectDr_HiDr);
    }
}