package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.date.date;
import com.example.saeed_pc.mydoctor.R;
import com.example.saeed_pc.mydoctor.Accessories.constValue_General.constValue_General;

import java.util.List;

/**
 * Created by SAEED-PC on 11/22/2015.
 */
public class arrayAdapter extends ArrayAdapter<Info_HiDoctor_UserApp> {

    private Context context;
    private List<Info_HiDoctor_UserApp> list;


    public arrayAdapter(Context context,List<Info_HiDoctor_UserApp> list) {
        super(context,0, list);
        this.context = context;
        this.list = list;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rootView = inflater.inflate(R.layout.hi_doctor_listview_layout, null);

        TextView txt_date = (TextView) rootView.findViewById(R.id.txtHiDr_main_listview_date);
        TextView txt_subject = (TextView) rootView.findViewById(R.id.txtHiDr_main_listview_subject_user_add);
        ImageView img_delivery = (ImageView) rootView.findViewById(R.id.imgDelivey_HiDr);

        final Info_HiDoctor_UserApp info = list.get(position);

        String date_status = date.date_status(info);
        String subject = cut_Subject(info.getSubject());


        txt_date.setText(date_status);
        txt_subject.setText(subject);
        img_delivery.setVisibility(View.INVISIBLE);


        return rootView;
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
