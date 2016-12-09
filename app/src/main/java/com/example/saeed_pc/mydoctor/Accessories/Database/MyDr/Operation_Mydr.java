package com.example.saeed_pc.mydoctor.Accessories.Database.MyDr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SAEED-PC on 10/1/2015.
 */
public class Operation_Mydr implements operation_interface_MyDr {
    private  SQLiteDatabase db;
    private myDatabase myDatabase;

    public Operation_Mydr(Context context) {
        Log.i("===>","operation");
        myDatabase = new myDatabase(context);
        db = myDatabase.getWritableDatabase();
        Log.i("===>","operation1");
    }

    @Override
    public void add_Registration_db_MyDr(Info_registration_MyDr info) {
        ContentValues values = new ContentValues();

        //values.put(ConstValue.COLUMN_ID,info.getCOLUMN_ID());

        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_NAME, info.getTABLE_REGISTRATION_ELEMENT_NAME());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_FAMILY,info.getTABLE_REGISTRATION_ELEMENT_FAMILY());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_USERNAME,info.getTABLE_REGISTRATION_ELEMENT_USERNAME());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_PASSWORD,info.getTABLE_REGISTRATION_ELEMENT_PASSWORD());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_PHONE,info.getTABLE_REGISTRATION_ELEMENT_PHONE());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_MAIL,info.getTABLE_REGISTRATION_ELEMENT_MAIL());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_AGE,info.getTABLE_REGISTRATION_ELEMENT_AGE());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_SEX,info.getTABLE_REGISTRATION_ELEMENT_SEX());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_RESERVE1,info.getTABLE_REGISTRATION_ELEMENT_RESERVE1());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_RESERVE2,info.getTABLE_REGISTRATION_ELEMENT_RESERVE2());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_RESERVE3,info.getTABLE_REGISTRATION_ELEMENT_RESERVE3());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_RESERVE4,info.getTABLE_REGISTRATION_ELEMENT_RESERVE4());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_RESERVE5, info.getTABLE_REGISTRATION_ELEMENT_RESERVE5());

        db.insert(ConstValue.TABLE_INFO_REGISTRATION, null, values);
        Log.i("===>", "addRestaurant3"+ConstValue.TABLE_INFO_REGISTRATION+".........."+values);

    }


    @Override
    public void add_Registration_db_MyDr(Info_registration_MyDr info, int id) {

    }

    @Override
    public void update_Registration_db_MyDr(Info_registration_MyDr info) {


    }

    @Override
    public void update_Registration_db_MyDr(int id) {

    }

    @Override
    public void update_Registration_db_MyDr(Info_registration_MyDr info, int id) {

    }


    @Override
    public void delete_Registration_db_MyDr(Info_registration_MyDr info) {

    }

    @Override
    public void delete_Registration_db_MyDr(int id) {

    }

    @Override
    public void delete_Registration_db_MyDr(Info_registration_MyDr info, int id) {

    }

    @Override
    public void deleteAll_Registration_db_MyDr() {
        db.delete(ConstValue.TABLE_INFO_REGISTRATION,null,null);
    }

    @Override
    public List<Info_registration_MyDr> getAll_Registration_db_MyDr() {
        List<Info_registration_MyDr> list = new ArrayList<>();

        Cursor cursor = db.query(ConstValue.TABLE_INFO_REGISTRATION, null, null, null, null, null, null);

        while (cursor.moveToNext()){

            Info_registration_MyDr info = new Info_registration_MyDr();

            int id = cursor.getInt(cursor.getColumnIndex(ConstValue.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_REGISTRATION_ELEMENT_NAME));
            String family = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_REGISTRATION_ELEMENT_FAMILY));
            String user_name = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_REGISTRATION_ELEMENT_USERNAME));
            String password = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_REGISTRATION_ELEMENT_PASSWORD));
            String phone = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_REGISTRATION_ELEMENT_PHONE));
            String mail = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_REGISTRATION_ELEMENT_MAIL));
            String age = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_REGISTRATION_ELEMENT_AGE));
            String sex = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_REGISTRATION_ELEMENT_SEX));
            String reserve1 = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_REGISTRATION_ELEMENT_RESERVE1));
            String reserve2 = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_REGISTRATION_ELEMENT_RESERVE2));
            String reserve3 = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_REGISTRATION_ELEMENT_RESERVE3));
            String reserve4 = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_REGISTRATION_ELEMENT_RESERVE4));
            String reserve5 = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_REGISTRATION_ELEMENT_RESERVE5));


            info.setCOLUMN_ID(id);
            info.setTABLE_REGISTRATION_ELEMENT_NAME(name);
            info.setTABLE_REGISTRATION_ELEMENT_FAMILY(family);
            info.setTABLE_REGISTRATION_ELEMENT_USERNAME(user_name);
            info.setTABLE_REGISTRATION_ELEMENT_PASSWORD(password);
            info.setTABLE_REGISTRATION_ELEMENT_PHONE(phone);
            info.setTABLE_REGISTRATION_ELEMENT_MAIL(mail);
            info.setTABLE_REGISTRATION_ELEMENT_AGE(age);
            info.setTABLE_REGISTRATION_ELEMENT_SEX(sex);
            info.setTABLE_REGISTRATION_ELEMENT_RESERVE1(reserve1);
            info.setTABLE_REGISTRATION_ELEMENT_RESERVE2(reserve2);
            info.setTABLE_REGISTRATION_ELEMENT_RESERVE3(reserve3);
            info.setTABLE_REGISTRATION_ELEMENT_RESERVE4(reserve4);
            info.setTABLE_REGISTRATION_ELEMENT_RESERVE5(reserve5);


            list.add(info);


        }


        return list;
    }

    @Override
    public List<Info_registration_MyDr> query_Registration_db_MyDr(Info_registration_MyDr info) {
        return null;
    }
}
