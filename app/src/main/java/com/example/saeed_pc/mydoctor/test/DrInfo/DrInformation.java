package com.example.saeed_pc.mydoctor.test.DrInfo;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Info.Info_All_Doctor_Information;
import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Operation_MyDr_AllDoctor_Info;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.SdCard.SDCard;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.date.date;
import com.example.saeed_pc.mydoctor.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ici80071 on 4/12/2016.
 */
public class DrInformation {


    private  Context context;
    private  final String ANDROID_RESOURCE = "android.resource://";
    private  final String FORESLASH="/";
    public static int i=0;


    public DrInformation(Context context) {
        this.context=context;
    }

    public List<Info_All_Doctor_Information> setSampleData (){
        List<Info_All_Doctor_Information> list = new ArrayList<>();
        i=i+1;
        String id_Dr = date.getDate();
        Uri uri = resIdToUri(R.mipmap.dr_image_test_1);
        Info_All_Doctor_Information info_Dr1 = addDr(id_Dr+i, "Saeed", "a", "dentistry",uri);
        i=i+1;
        id_Dr = date.getDate();
        uri = resIdToUri(R.mipmap.home);
        Info_All_Doctor_Information info_Dr2 = addDr(id_Dr+i, "Mehrdad", "b", "dentistry",uri);
        i=i+1;
        id_Dr = date.getDate();
        uri = resIdToUri(R.mipmap.message);
        Info_All_Doctor_Information info_Dr3 = addDr(id_Dr+i, "Araz", "c", "surgery",uri);
        i=i+1;
        id_Dr = date.getDate();
        uri = resIdToUri(R.mipmap.ic_launcher);
        Info_All_Doctor_Information info_Dr4 = addDr(id_Dr+i, "Arash", "d", "veterinarian",uri);

        list.add(info_Dr1);
        list.add(info_Dr2);
        list.add(info_Dr3);
        list.add(info_Dr4);


        return list;
    }

    private Info_All_Doctor_Information addDr(String id_doctor, String name, String family, String field , Uri uri){

        Info_All_Doctor_Information info = new Info_All_Doctor_Information();

        //String address_image = UriToPath(resIdToUri(R.mipmap.dr_image_test_1));
        SDCard sdCard = new SDCard(context);
        String address_image = sdCard.saveImageToSdCard(uri, name);
        Log.i("===>","DrInformation.addDr"+address_image);

        info.setId_doctor(id_doctor);
        info.setName(name);
        info.setFamily(family);
        info.setField(field);
        info.setAddress_image(address_image);

        return info;
    }

    public  Uri resIdToUri(int resId){
        return Uri.parse(ANDROID_RESOURCE+context.getPackageName()+FORESLASH+resId);

    }

    public String UriToPath(Uri uri){
        return uri.getPath();
    }


}
