package com.example.saeed_pc.mydoctor.Main_MyDr.Design.adapter_Design;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saeed_pc.mydoctor.Main_MyDr.Design.model_Design.NavDrawerItem_Design_main_MyDr;
import com.example.saeed_pc.mydoctor.OnTabSwipable.materialDesign.model_Design.NavDrawerItem_Design;
import com.example.saeed_pc.mydoctor.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ravi Tamada on 12-03-2015.
 */
public class NavigationDrawerAdapter_main_MyDr extends RecyclerView.Adapter<NavigationDrawerAdapter_main_MyDr.MyViewHolder> {
        List<NavDrawerItem_Design_main_MyDr> data = Collections.emptyList();
        private LayoutInflater inflater;
        private Context context;

        public NavigationDrawerAdapter_main_MyDr(Context context, List<NavDrawerItem_Design_main_MyDr> data) {
                this.context = context;
                inflater = LayoutInflater.from(context);
                this.data = data;
        }

        public void delete(int position) {
                data.remove(position);
                notifyItemRemoved(position);
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = inflater.inflate(R.layout.main_my_dr_nav_drawe_row, parent, false);
                MyViewHolder holder = new MyViewHolder(view);
                return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
                NavDrawerItem_Design_main_MyDr current = data.get(position);
                Log.i("===>","onBindViewHolder.1");
                holder.title.setText(current.getTitle());
                Log.i("===>", "onBindViewHolder.2");
        }

        @Override
        public int getItemCount() {
                return data.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
                TextView title;

                public MyViewHolder(View itemView) {
                        super(itemView);
                        Log.i("===>", "MyViewHolder.1");
                        title = (TextView) itemView.findViewById(R.id.title_nav_main_MyDr);
                        Log.i("===>","MyViewHolder.2");
                }
        }
}