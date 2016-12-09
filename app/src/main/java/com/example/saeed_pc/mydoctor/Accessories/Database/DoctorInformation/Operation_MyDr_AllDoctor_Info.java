package com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Info.Info_All_Doctor_Information;
import com.example.saeed_pc.mydoctor.Accessories.Database.MyDr.ConstValue;
import com.example.saeed_pc.mydoctor.Accessories.Database.MyDr.myDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ici80071 on 4/11/2016.
 */
public class Operation_MyDr_AllDoctor_Info implements Operation_interface_MyDr_AllDoctor_Info {

    private SQLiteDatabase db;
    private myDatabase myDatabase;

    public Operation_MyDr_AllDoctor_Info(Context context) {
        myDatabase = new myDatabase(context);
        db = myDatabase.getWritableDatabase();
    }

    @Override
    public void add_MyDr_db_MyDr_AllDoctor_Info(Info_All_Doctor_Information info) {

        ContentValues values = new ContentValues();

        //values.put(ConstValue.COLUMN_ID,info.getCOLUMN_ID());


        values.put(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_ID_DR, info.getId_doctor());
        values.put(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_NAME, info.getName());
        values.put(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_FAMILY,info.getFamily());
        values.put(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_FIELD,info.getField());
        values.put(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_IMAGE_ADD,info.getAddress_image());
        values.put(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESUME_ADD,info.getAddress_resume());
        values.put(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_JSON_ADD,info.getAddress_json());
        values.put(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE1,info.getReserve1_Info_All_Dr());
        values.put(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE2,info.getReserve2_Info_All_Dr());
        values.put(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE3,info.getReserve3_Info_All_Dr());
        values.put(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE4,info.getReserve4_Info_All_Dr());

        db.insert(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr, null, values);
        Log.i("===>", "addHi Dr"+ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr+".........."+values);
    }

    @Override
    public void add_MyDr_db_MyDr_AllDoctor_Info(Info_All_Doctor_Information info, int id) {

    }

    @Override
    public void update_MyDr_db_MyDr_AllDoctor_Info(Info_All_Doctor_Information info) {

    }

    @Override
    public void update_MyDr_db_MyDr_AllDoctor_Info(int id) {

    }

    @Override
    public void update_MyDr_db_MyDr_AllDoctor_Info(Info_All_Doctor_Information info, int id) {

    }

    @Override
    public void delete_MyDr_db_MyDr_AllDoctor_Info(Info_All_Doctor_Information info) {

    }

    @Override
    public void delete_MyDr_db_MyDr_AllDoctor_Info(int id) {

    }

    @Override
    public void delete_MyDr_db_MyDr_AllDoctor_Info(Info_All_Doctor_Information info, int id) {

    }

    @Override
    public void deleteAll_MyDr_db_MyDr_AllDoctor_Info() {
        db.delete(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr,null,null);

    }

    @Override
    public Info_All_Doctor_Information query_db_MyDr_AllDoctor(String id_doctor) {

        Info_All_Doctor_Information info = new Info_All_Doctor_Information();

        //get reference to readable DB
       // SQLiteDatabase db = context.getReadable

        //build query
        Cursor cursor = db.query(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr,  //a. tables
                null,    //b. columns name
                " id_doctor = ?",   // c. selections
                new String[] { id_doctor} ,     // d. selections args
                null,     // e. group by
                null,     // f. having
                null      // g. order by
        );

        // if we got result get the first one
        if(cursor != null){
            cursor.moveToFirst();
        }

        //build object
        int id = cursor.getInt(cursor.getColumnIndex(ConstValue.COLUMN_ID));
        String name = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_NAME));
        String family = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_FAMILY));
        String field = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_FIELD));
        String address_image = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_IMAGE_ADD));
        String address_resume = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESUME_ADD));
        String address_json = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_JSON_ADD));
        String reserve1_Info_All_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE1));
        String reserve2_Info_All_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE2));
        String reserve3_Info_All_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE3));
        String reserve4_Info_All_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE4));

        Log.i("===>", "getAll_MyDr_db_MyDr_AllDoctor_Info.1.5 + name:  "+name);


        info.setId(id);
        info.setId_doctor(id_doctor);
        info.setName(name);
        info.setFamily(family);
        info.setField(field);
        info.setAddress_image(address_image);
        info.setAddress_resume(address_resume);
        info.setAddress_json(address_json);
        info.setReserve1_Info_All_Dr(reserve1_Info_All_Dr);
        info.setReserve2_Info_All_Dr(reserve2_Info_All_Dr);
        info.setReserve3_Info_All_Dr(reserve3_Info_All_Dr);
        info.setReserve4_Info_All_Dr(reserve4_Info_All_Dr);
        Log.i("===>", "getAll_MyDr_db_MyDr_AllDoctor_Info.2 + name:  " + info.getName());

        return info;
    }

    @Override
    public List<Info_All_Doctor_Information> getAll_MyDr_db_MyDr_AllDoctor_Info() {

        List<Info_All_Doctor_Information> list = new ArrayList<>();

        Cursor cursor = db.query(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr, null, null, null, null, null, null);

        while (cursor.moveToNext()) {

            Info_All_Doctor_Information info = new Info_All_Doctor_Information();

            int id = cursor.getInt(cursor.getColumnIndex(ConstValue.COLUMN_ID));
            String id_doctor = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_ID_DR));
            String name = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_NAME));
            String family = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_FAMILY));
            String field = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_FIELD));
            String address_image = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_IMAGE_ADD));
            String address_resume = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESUME_ADD));
            String address_json = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_JSON_ADD));
            String reserve1_Info_All_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE1));
            String reserve2_Info_All_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE2));
            String reserve3_Info_All_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE3));
            String reserve4_Info_All_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE4));



            info.setId(id);
            info.setId_doctor(id_doctor);
            info.setName(name);
            info.setFamily(family);
            info.setField(field);
            info.setAddress_image(address_image);
            info.setAddress_resume(address_resume);
            info.setAddress_json(address_json);
            info.setReserve1_Info_All_Dr(reserve1_Info_All_Dr);
            info.setReserve2_Info_All_Dr(reserve2_Info_All_Dr);
            info.setReserve3_Info_All_Dr(reserve3_Info_All_Dr);
            info.setReserve4_Info_All_Dr(reserve4_Info_All_Dr);


            list.add(info);
        }

      //  Log.i("===>", "getAll_MyDr_db_MyDr_AllDoctor_Info.2 "+list.get(list.size()-1).getName());
            return list;

    }

    @Override
    public List<Info_All_Doctor_Information> query_MyDr_db_MyDr_AllDoctor_Info(Info_All_Doctor_Information info) {
        return null;
    }
}
