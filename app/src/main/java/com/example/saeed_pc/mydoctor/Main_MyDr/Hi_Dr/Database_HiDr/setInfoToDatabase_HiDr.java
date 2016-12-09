package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.Database_HiDr;

import android.content.Context;
import android.util.Log;

import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDoctorQuestionActivity;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.date.date;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.dialog.dialog_HiDr_SetGetInformationShared;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.Info_HiDoctor_UserApp;
import com.example.saeed_pc.mydoctor.Main_MyDr.MainMyDr;

/**
 * Created by ici80481 on 11/25/2015.
 */
public class setInfoToDatabase_HiDr {


    private static String key_shared_MyDoctor_add_subject;
    private static String key_shared_MyDoctor_add_question;
    private static String send_date;
    private static Operation_HiDr operation_hiDr;
    private static String Dr_ID;

    private Context context;

    public setInfoToDatabase_HiDr(Context context) {
        this.context=context;
        operation_hiDr = new Operation_HiDr(context);
    }

    public static void setInfo_fromNewMessage(){


        Log.i("===>", "setInfo_fromNewMessage.1");
        Info_HiDoctor_UserApp info = new Info_HiDoctor_UserApp();

        //get question and subject
        dialog_HiDr_SetGetInformationShared.setInformationOnShared_HiDr();
        key_shared_MyDoctor_add_subject = MainMyDr.preferences_add_HiDr.getString("key_shared_MyDoctor_add_subject", "");
        key_shared_MyDoctor_add_question = HiDoctorQuestionActivity.question;
        Dr_ID = HiDoctorQuestionActivity.info_all_doctor_information.getId_doctor();

        //get Send Date
        send_date = date.getDate();
        date.getDateOnly_Integer();
        date.getDateOnly_String();

        date.getTimeOnly_Integer();
        date.getTimeOnly_String();
        Log.i("===>", "date: " + send_date + "  date only: ");

        String s = date.compareTime_TimeStatus("20151125160539", send_date);
        Log.i("===>", "compareTime_TimeStatus  " + s);

        // regulate info
        info.setSendDate(send_date);
        info.setReceiveDate("0");
       info.setSubject(key_shared_MyDoctor_add_subject);
       info.setQuestion(key_shared_MyDoctor_add_question);
       Log.i("===>", "setInfo_fromNewMessage0.1 " + "subject: " + key_shared_MyDoctor_add_subject + " question: " + key_shared_MyDoctor_add_question);
       info.setAnswer("0");
       info.setFlag_new_answered("0");
       info.setReservation1(Dr_ID);
       info.setReservation2("0");
       info.setReservation3("0");
       info.setReservation4("0");
       info.setReservation5("0");


        operation_hiDr.add_HiDr_db_MyDr(info);
        Log.i("===>", "setInfo_fromNewMessage2");
    }
}
