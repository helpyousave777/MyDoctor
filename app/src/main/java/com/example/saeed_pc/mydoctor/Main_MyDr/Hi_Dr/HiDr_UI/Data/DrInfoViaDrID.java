package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDr_UI.Data;

import android.content.Context;
import android.util.Log;

import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Info.Info_All_Doctor_Information;
import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Operation_MyDr_AllDoctor_Info;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.Info_HiDoctor_UserApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ici80071 on 5/4/2016.
 */
public class DrInfoViaDrID {

    private final Operation_MyDr_AllDoctor_Info operation_myDr_allDoctor_info;
    private final Info_All_Doctor_Information info;
    private Info_HiDoctor_UserApp data;

    public DrInfoViaDrID(Info_HiDoctor_UserApp data ,  Context context) {
        Log.i("===>", "DrInfoViaDrID.1");
        this.data = data;
        operation_myDr_allDoctor_info = new Operation_MyDr_AllDoctor_Info(context);
        Log.i("===>", "DrInfoViaDrID.2 dr_id : "+data.getReservation1());
        info = operation_myDr_allDoctor_info.query_db_MyDr_AllDoctor(data.getReservation1());
        Log.i("===>", "DrInfoViaDrID.3 name: "+ info.getName());
    }

    public String getDrName (){
        Log.i("===>", "DrInfoViaDrID.getDrName.1");
        String DrName="0";
        Log.i("===>", "DrInfoViaDrID.getDrName.2 name: "+info.getName());
        DrName=info.getName();
        Log.i("===>", "DrInfoViaDrID.getDrName.3 name: "+DrName);

        return DrName;
    }

    public int getDrImageID(){
        int imageID=0;
        String addressImage=info.getAddress_image();

        return imageID;
    }


}
