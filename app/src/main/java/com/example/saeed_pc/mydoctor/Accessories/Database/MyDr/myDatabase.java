package com.example.saeed_pc.mydoctor.Accessories.Database.MyDr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SAEED-PC on 10/1/2015.
 */
public class myDatabase extends SQLiteOpenHelper {
    public myDatabase(Context context) {
        super(context, ConstValue.DATABASE_NAME, null, ConstValue.VERSION_DATABASE_INFO_NEW);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ConstValue.CREATE_INFORMATION_REGISTRATION_TABLE);
         db.execSQL(ConstValue.CREATE_HI_DOCTOR_USER_APP_TABLE);
         db.execSQL(ConstValue.CREATE_HI_DOCTOR_Server_TABLE);

         db.execSQL(ConstValue.CREATE_MyDoctor_Info_All_Dr_Table);
         db.execSQL(ConstValue.CREATE_MyDoctor_Info_Registered_Dr_Table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ConstValue.CREATE_INFORMATION_REGISTRATION_TABLE);

       db.execSQL(ConstValue.CREATE_HI_DOCTOR_USER_APP_TABLE);
        db.execSQL(ConstValue.CREATE_HI_DOCTOR_Server_TABLE);

        db.execSQL(ConstValue.CREATE_MyDoctor_Info_All_Dr_Table);
        db.execSQL(ConstValue.CREATE_MyDoctor_Info_Registered_Dr_Table);

    }
}
