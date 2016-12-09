package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDr_UI.Data;

import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ici80071 on 4/26/2016.
 */
public class Data_Main_HiDr {


    public String Name_Dr;
    public int image_Id_Dr;

    public String  subject_PM;
    public String time_PM;
    public int delivery_Id_PM;


    public Data_Main_HiDr(String name_Dr, int image_Id_Dr, String subject_PM, String time_PM, int delivery_Id_PM) {

        Name_Dr = name_Dr;
        this.image_Id_Dr = image_Id_Dr;
        this.subject_PM = subject_PM;
        this.time_PM = time_PM;
        this.delivery_Id_PM = delivery_Id_PM;
    }

    public String getName_Dr() {
        return Name_Dr;
    }

    public void setName_Dr(String name_Dr) {
        Name_Dr = name_Dr;
    }

    public int getImage_Id_Dr() {
        return image_Id_Dr;
    }

    public void setImage_Id_Dr(int image_Id_Dr) {
        this.image_Id_Dr = image_Id_Dr;
    }

    public String getSubject_PM() {
        return subject_PM;
    }

    public void setSubject_PM(String subject_PM) {
        this.subject_PM = subject_PM;
    }

    public String getTime_PM() {
        return time_PM;
    }

    public void setTime_PM(String time_PM) {
        this.time_PM = time_PM;
    }

    public int getDelivery_Id_PM() {
        return delivery_Id_PM;
    }

    public void setDelivery_Id_PM(int delivery_Id_PM) {
        this.delivery_Id_PM = delivery_Id_PM;
    }




}
