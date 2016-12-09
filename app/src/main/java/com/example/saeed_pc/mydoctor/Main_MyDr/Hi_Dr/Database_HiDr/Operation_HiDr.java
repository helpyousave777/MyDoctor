package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.Database_HiDr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.saeed_pc.mydoctor.Accessories.Database.MyDr.ConstValue;
import com.example.saeed_pc.mydoctor.Accessories.Database.MyDr.myDatabase;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.Info_HiDoctor_UserApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SAEED-PC on 11/22/2015.
 */
public class Operation_HiDr implements Operation_interface_HiDr {

    private SQLiteDatabase db;
    private myDatabase myDatabase;

    public Operation_HiDr(Context context) {
        myDatabase = new myDatabase(context);
        db = myDatabase.getWritableDatabase();
    }

    @Override
    public void add_HiDr_db_MyDr(Info_HiDoctor_UserApp info) {
        ContentValues values = new ContentValues();

        //values.put(ConstValue.COLUMN_ID,info.getCOLUMN_ID());

        Log.i("===>", "addHi Dr1");
                values.put(ConstValue.TABLE_HiDr_Server_ELEMENT_SEND_DATE, info.getSendDate());
        Log.i("===>", "addHi Dr2");
        values.put(ConstValue.TABLE_HiDr_Server_ELEMENT_RECEIVED_DATE,info.getReceiveDate());
        values.put(ConstValue.TABLE_HiDr_Server_ELEMENT_SUBJECT,info.getSubject());
        values.put(ConstValue.TABLE_HiDr_Server_ELEMENT_QUESTION,info.getQuestion());
        values.put(ConstValue.TABLE_HiDr_Server_ELEMENT_ANSWER,info.getAnswer());
        values.put(ConstValue.TABLE_HiDr_Server_ELEMENT_FLAG_NEW_ANSWERED,info.getFlag_new_answered());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_RESERVE1,info.getReservation1());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_RESERVE2,info.getReservation2());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_RESERVE3,info.getReservation3());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_RESERVE4,info.getReservation4());
        values.put(ConstValue.TABLE_REGISTRATION_ELEMENT_RESERVE5,info.getReservation5());

        db.insert(ConstValue.TABLE_INFO_HiDoctor_UserApp, null, values);
        Log.i("===>", "addHi Dr"+ConstValue.TABLE_INFO_HiDoctor_UserApp+".........."+values);

    }


    @Override
    public void add_HiDr_db_MyDr(Info_HiDoctor_UserApp info, int id) {

    }

    @Override
    public void update_HiDr_db_MyDr(Info_HiDoctor_UserApp info) {


    }

    @Override
    public void update_HiDr_db_MyDr(int id) {

    }

    @Override
    public void update_HiDr_db_MyDr(Info_HiDoctor_UserApp info, int id) {

    }


    @Override
    public void delete_HiDr_db_MyDr(Info_HiDoctor_UserApp info) {

    }

    @Override
    public void delete_HiDr_db_MyDr(int id) {

    }

    @Override
    public void delete_HiDr_db_MyDr(Info_HiDoctor_UserApp info, int id) {

    }

    @Override
    public void deleteAll_HiDr_db_MyDr() {
        db.delete(ConstValue.TABLE_INFO_HiDoctor_UserApp,null,null);
    }

    @Override
    public List<Info_HiDoctor_UserApp> getAll_HiDr_db_MyDr() {
        List<Info_HiDoctor_UserApp> list = new ArrayList<>();

        Cursor cursor = db.query(ConstValue.TABLE_INFO_HiDoctor_UserApp, null, null, null, null, null, null);

        while (cursor.moveToNext()){

            Info_HiDoctor_UserApp info = new Info_HiDoctor_UserApp();

            int id = cursor.getInt(cursor.getColumnIndex(ConstValue.COLUMN_ID));
            String send_date = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_HiDr_UserApp_ELEMENT_SEND_DATE));
            String receive_date = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_HiDr_UserApp_ELEMENT_RECEIVED_DATE));
            String subject = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_HiDr_UserApp_ELEMENT_SUBJECT));
            String question = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_HiDr_UserApp_ELEMENT_QUESTION));
            String answer = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_HiDr_UserApp_ELEMENT_ANSWER));
            String flag_answer = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_HiDr_UserApp_ELEMENT_FLAG_NEW_ANSWERED));
            String reserve1 = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_HiDr_UserApp_ELEMENT_RESERVE1));
            String reserve2 = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_HiDr_UserApp_ELEMENT_RESERVE2));
            String reserve3 = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_HiDr_UserApp_ELEMENT_RESERVE3));
            String reserve4 = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_HiDr_UserApp_ELEMENT_RESERVE4));
            String reserve5 = cursor.getString(cursor.getColumnIndex(ConstValue.TABLE_HiDr_UserApp_ELEMENT_RESERVE5));


            info.setId(id);
            info.setSendDate(send_date);
            info.setReceiveDate(receive_date);
            info.setSubject(subject);
            info.setQuestion(question);
            info.setAnswer(answer);
            info.setFlag_new_answered(flag_answer);
            info.setReservation1(reserve1);
            info.setReservation2(reserve2);
            info.setReservation3(reserve3);
            info.setReservation4(reserve4);
            info.setReservation5(reserve5);


            list.add(info);


        }


        return list;
    }

    @Override
    public List<Info_HiDoctor_UserApp> query_HiDr_db_MyDr(Info_HiDoctor_UserApp info) {
        return null;
    }
}
