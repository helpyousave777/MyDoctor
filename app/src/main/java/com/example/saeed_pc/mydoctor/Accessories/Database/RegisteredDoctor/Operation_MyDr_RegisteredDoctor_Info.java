package com.example.saeed_pc.mydoctor.Accessories.Database.RegisteredDoctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.saeed_pc.mydoctor.Accessories.Database.MyDr.ConstValue;
import com.example.saeed_pc.mydoctor.Accessories.Database.MyDr.myDatabase;
import com.example.saeed_pc.mydoctor.Accessories.Database.RegisteredDoctor.Info.Info_Registered_Doctor_Information;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ici80071 on 4/12/2016.
 */
public class Operation_MyDr_RegisteredDoctor_Info implements Operation_interface_MyDr_RegisteredDoctor_Info {

    private SQLiteDatabase db;
    private myDatabase myDatabase;

    public Operation_MyDr_RegisteredDoctor_Info(Context context) {

        Log.i("===>", "Operation_MyDr_RegisteredDoctor_Info.1");
        myDatabase = new myDatabase(context);
        db = myDatabase.getWritableDatabase();
        Log.i("===>","Operation_MyDr_RegisteredDoctor_Info.2");
    }

    @Override
    public void add_MyDr_db_MyDr_RegisteredDoctor_Info(Info_Registered_Doctor_Information info) {

        ContentValues values = new ContentValues();

        //values.put(ConstValue.COLUMN_ID,info.getCOLUMN_ID());

        values.put(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_ID_DR, info.getId_doctor());
        values.put(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_ACCESS_LEVEL, info.getAccess_level());
        values.put(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE1,info.getReserve1_Info_Registered_Dr());
        values.put(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE2,info.getReserve2_Info_Registered_Dr());
        values.put(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE3,info.getReserve3_Info_Registered_Dr());
        values.put(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE4,info.getReserve4_Info_Registered_Dr());
        values.put(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE5,info.getReserve5_Info_Registered_Dr());
        values.put(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE6,info.getReserve6_Info_Registered_Dr());
        values.put(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE7,info.getReserve7_Info_Registered_Dr());
        values.put(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE8,info.getReserve8_Info_Registered_Dr());
        values.put(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE9,info.getReserve9_Info_Registered_Dr());

        db.insert(ConstValue.TABLE_INFO_MyDoctor_Info_Registered_Dr, null, values);
        Log.i("===>", "addHi Dr"+ConstValue.TABLE_INFO_MyDoctor_Info_Registered_Dr+".........."+values);

    }

    @Override
    public void add_MyDr_db_MyDr_RegisteredDoctor_Info(Info_Registered_Doctor_Information info, int id) {

    }

    @Override
    public void update_MyDr_db_MyDr_RegisteredDoctor_Info(Info_Registered_Doctor_Information info) {

    }

    @Override
    public void update_MyDr_db_MyDr_RegisteredDoctor_Info(int id) {

    }

    @Override
    public void update_MyDr_db_MyDr_RegisteredDoctor_Info(Info_Registered_Doctor_Information info, int id) {

    }

    @Override
    public void delete_MyDr_db_MyDr_RegisteredDoctor_Info(Info_Registered_Doctor_Information info) {

    }

    @Override
    public void delete_MyDr_db_MyDr_RegisteredDoctor_Info(int id) {

    }

    @Override
    public void delete_MyDr_db_MyDr_RegisteredDoctor_Info(Info_Registered_Doctor_Information info, int id) {

    }

    @Override
    public void deleteAll_MyDr_db_MyDr_RegisteredDoctor_Info() {

    }

    @Override
    public List<Info_Registered_Doctor_Information> getRegistered_MyDr_db_MyDr_AllDoctor_Info() {





        List<Info_Registered_Doctor_Information> list = new ArrayList<>();

        Cursor cursor = db.query(ConstValue.TABLE_INFO_MyDoctor_Info_Registered_Dr, null, null, null, null, null, null);


        while (cursor.moveToNext()) {

            Info_Registered_Doctor_Information info = new Info_Registered_Doctor_Information();

            int id = cursor.getInt(cursor.getColumnIndex(ConstValue.COLUMN_ID));
            String id_doctor = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_ID_DR));
            String access_level = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_ACCESS_LEVEL));
            String reserve1_Info_Registered_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE1));
            String reserve2_Info_Registered_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE2));
            String reserve3_Info_Registered_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE3));
            String reserve4_Info_Registered_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE4));
            String reserve5_Info_Registered_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE5));
            String reserve6_Info_Registered_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE6));
            String reserve7_Info_Registered_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE7));
            String reserve8_Info_Registered_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE8));
            String reserve9_Info_Registered_Dr = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE9));


            info.setId(id);
            info.setId_doctor(id_doctor);
            info.setAccess_level(access_level);
            info.setReserve1_Info_Registered_Dr(reserve1_Info_Registered_Dr);
            info.setReserve2_Info_Registered_Dr(reserve2_Info_Registered_Dr);
            info.setReserve3_Info_Registered_Dr(reserve3_Info_Registered_Dr);
            info.setReserve4_Info_Registered_Dr(reserve4_Info_Registered_Dr);
            info.setReserve5_Info_Registered_Dr(reserve5_Info_Registered_Dr);
            info.setReserve6_Info_Registered_Dr(reserve6_Info_Registered_Dr);
            info.setReserve7_Info_Registered_Dr(reserve7_Info_Registered_Dr);
            info.setReserve8_Info_Registered_Dr(reserve8_Info_Registered_Dr);
            info.setReserve9_Info_Registered_Dr(reserve9_Info_Registered_Dr);


            list.add(info);
        }

        return list;
    }

    @Override
    public List<Info_Registered_Doctor_Information> query_MyDr_db_MyDr_RegisteredDoctor_Info(Info_Registered_Doctor_Information info) {
        return null;
    }
}
