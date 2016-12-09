package com.example.saeed_pc.mydoctor.test.DrInfo;

import android.content.Context;
import android.util.Log;

import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Info.Info_All_Doctor_Information;
import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Operation_MyDr_AllDoctor_Info;
import com.example.saeed_pc.mydoctor.Accessories.Database.RegisteredDoctor.Info.Info_Registered_Doctor_Information;
import com.example.saeed_pc.mydoctor.Accessories.Database.RegisteredDoctor.Operation_MyDr_RegisteredDoctor_Info;

import java.util.List;

/**
 * Created by ici80071 on 4/12/2016.
 */
public class AddDrInfoToDB {

    private Context context;
    private DrInformation drInformation;
    private List<Info_All_Doctor_Information> list;
    private Operation_MyDr_AllDoctor_Info allDoctor_DB;
    private Operation_MyDr_RegisteredDoctor_Info registeredDoctor_DB;

    public AddDrInfoToDB(Context context) {
        this.context = context;
        allDoctor_DB =new Operation_MyDr_AllDoctor_Info(context);
        drInformation = new DrInformation(context);
    }

    public void addToDB() {

        Log.i("===>","addToDB.1");
        list = drInformation.setSampleData();
        Log.i("===>","addToDB.2 list size: "+list.size());
        for (int i = 0; i < list.size(); i++) {

            allDoctor_DB.add_MyDr_db_MyDr_AllDoctor_Info(list.get(i));
        }

        Log.i("===>","addToDB.3");

    }

    public void deleteFromDB(){
        Log.i("===>", "deleteFromDB.1");
        allDoctor_DB.deleteAll_MyDr_db_MyDr_AllDoctor_Info();
        Log.i("===>", "deleteFromDB.2");
    }



    public void addDataToRegisteredDrDB(List<Info_All_Doctor_Information> list_all){
        Log.i("===>", "addDataToRegisteredDrDB.2");
        Info_Registered_Doctor_Information info = new Info_Registered_Doctor_Information();
        registeredDoctor_DB=new Operation_MyDr_RegisteredDoctor_Info(context);
        Log.i("===>", "addDataToRegisteredDrDB.2");

        for (int i = 0; i < list_all.size(); i++) {

            info.setId_doctor(list_all.get(i).getId_doctor());
            Log.i("===>", "addDataToRegisteredDrDB.2.1");
            info.setAccess_level("1");
            Log.i("===>", "addDataToRegisteredDrDB.2.2");
            registeredDoctor_DB.add_MyDr_db_MyDr_RegisteredDoctor_Info(info);
            Log.i("===>", "addDataToRegisteredDrDB.2.3");

        }
        Log.i("===>", "addDataToRegisteredDrDB.3");

    }




}
