package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.dialog;

import android.util.Log;

import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDoctorMainActivity;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.Info_HiDoctor_UserApp;
import com.example.saeed_pc.mydoctor.Main_MyDr.MainMyDr;

/**
 * Created by ici80481 on 11/25/2015.
 */
public class dialog_HiDr_SetGetInformationShared {


    private String key_shared_MyDoctor_add_send_date;
    private String key_shared_MyDoctor_add_receive_date;
    private static String key_shared_MyDoctor_add_subject;
    private static String key_shared_MyDoctor_add_question;
    private String key_shared_MyDoctor_add_answer;
    private String key_shared_MyDoctor_add_flag_new_answered;
    private String key_shared_MyDr_add_reservation1;
    private String key_shared_MyDr_add_reservation2;
    private String key_shared_MyDr_add_reservation3;
    private String key_shared_MyDr_add_reservation4;
    private String key_shared_MyDr_add_reservation5;

    public static void setInformationOnShared_HiDr() {



     //   HiDoctorMainActivity.preferences_add_HiDr.edit().putString("key_shared_MyDoctor_add_send_date", RegisterActivity.editName_registration.getText().toString()).commit();
     //   HiDoctorMainActivity.preferences_add_HiDr.edit().putString("key_shared_MyDoctor_add_receive_date", RegisterActivity.editFamily_registration.getText().toString()).commit();

        MainMyDr.preferences_add_HiDr.edit().putString("key_shared_MyDoctor_add_subject", dialog.edit_HiDr_Subject.getText().toString()).commit();
        MainMyDr.preferences_add_HiDr.edit().putString("key_shared_MyDoctor_add_question", dialog.edit_HiDr_Question.getText().toString()).commit();

        Log.i("===>","data: subject: " + dialog.edit_HiDr_Subject.getText().toString()+"quest: "+dialog.edit_HiDr_Question.getText().toString());

      //  HiDoctorMainActivity.preferences_add_HiDr.edit().putString("key_shared_MyDoctor_add_answer", RegisterActivity.editPhone_registration.getText().toString()).commit();
      //  HiDoctorMainActivity.preferences_add_HiDr.edit().putString("key_shared_MyDoctor_add_flag_new_answered", RegisterActivity.editMail_registration.getText().toString()).commit();
        //RegisterActivity.preferences_add_HiDr.edit().putString("key_shared_registration_add_reservation1", ).commit();
        //RegisterActivity.preferences_add_HiDr.edit().putString("key_shared_registration_add_reservation2", ).commit();
        //RegisterActivity.preferences_add_HiDr.edit().putString("key_shared_registration_add_reservation3", ).commit();
        //RegisterActivity.preferences_add_HiDr.edit().putString("key_shared_registration_add_reservation4", ).commit();
        //RegisterActivity.preferences_add_HiDr.edit().putString("key_shared_registration_add_reservation5", ).commit();

    }

    public  static void setInformationOnShared_HiDr_Cancel() {


        //   HiDoctorMainActivity.preferences_add_HiDr.edit().putString("key_shared_MyDoctor_add_send_date", RegisterActivity.editName_registration.getText().toString()).commit();
        //   HiDoctorMainActivity.preferences_add_HiDr.edit().putString("key_shared_MyDoctor_add_receive_date", RegisterActivity.editFamily_registration.getText().toString()).commit();

        MainMyDr.preferences_add_HiDr.edit().putString("key_shared_MyDoctor_add_subject", "").commit();
        MainMyDr.preferences_add_HiDr.edit().putString("key_shared_MyDoctor_add_question", "").commit();

        //  HiDoctorMainActivity.preferences_add_HiDr.edit().putString("key_shared_MyDoctor_add_answer", RegisterActivity.editPhone_registration.getText().toString()).commit();
        //  HiDoctorMainActivity.preferences_add_HiDr.edit().putString("key_shared_MyDoctor_add_flag_new_answered", RegisterActivity.editMail_registration.getText().toString()).commit();
        //RegisterActivity.preferences_add_HiDr.edit().putString("key_shared_registration_add_reservation1", ).commit();
        //RegisterActivity.preferences_add_HiDr.edit().putString("key_shared_registration_add_reservation2", ).commit();
        //RegisterActivity.preferences_add_HiDr.edit().putString("key_shared_registration_add_reservation3", ).commit();
        //RegisterActivity.preferences_add_HiDr.edit().putString("key_shared_registration_add_reservation4", ).commit();
        //RegisterActivity.preferences_add_HiDr.edit().putString("key_shared_registration_add_reservation5", ).commit();

    }

    public static Info_HiDoctor_UserApp getInformationFromShared(){


        Info_HiDoctor_UserApp info =new Info_HiDoctor_UserApp();

     //  key_shared_MyDoctor_add_send_date = HiDoctorMainActivity.preferences_add_HiDr.getString("key_shared_MyDoctor_add_send_date", "0");
     //  key_shared_MyDoctor_add_receive_date =   HiDoctorMainActivity.preferences_add_HiDr.getString("key_shared_MyDoctor_add_receive_date", "0");
        key_shared_MyDoctor_add_subject =  MainMyDr.preferences_add_HiDr.getString("key_shared_MyDoctor_add_subject", "");
        key_shared_MyDoctor_add_question = MainMyDr.preferences_add_HiDr.getString("key_shared_MyDoctor_add_question", "");
     //  key_shared_MyDoctor_add_answer =  HiDoctorMainActivity.preferences_add_HiDr.getString("key_shared_MyDoctor_add_answer", "0");
     //  key_shared_MyDoctor_add_flag_new_answered =  HiDoctorMainActivity.preferences_add_HiDr.getString("key_shared_MyDoctor_add_flag_new_answered", "0");
     //  key_shared_MyDr_add_reservation1 =  HiDoctorMainActivity.preferences_add_HiDr.getString("key_shared_registration_add_reservation1", "0");
     //  key_shared_MyDr_add_reservation2 =  HiDoctorMainActivity.preferences_add_HiDr.getString("key_shared_registration_add_reservation2", "0");
     //  key_shared_MyDr_add_reservation3 =  HiDoctorMainActivity.preferences_add_HiDr.getString("key_shared_registration_add_reservation3", "0");
     //  key_shared_MyDr_add_reservation4 =  HiDoctorMainActivity.preferences_add_HiDr.getString("key_shared_registration_add_reservation4", "0");
     //  key_shared_MyDr_add_reservation5 =  HiDoctorMainActivity.preferences_add_HiDr.getString("key_shared_registration_add_reservation5", "0");

      // info.setSendDate(key_shared_MyDoctor_add_send_date);
      // info.setReceiveDate(key_shared_MyDoctor_add_receive_date);
        info.setSubject(key_shared_MyDoctor_add_subject);
        info.setQuestion(key_shared_MyDoctor_add_question);
      //  info.setAnswer(key_shared_MyDoctor_add_answer);
      //  info.setFlag_new_answered(key_shared_MyDoctor_add_flag_new_answered);
      //  info.setReservation1(key_shared_MyDr_add_reservation1);
      //  info.setReservation2(key_shared_MyDr_add_reservation2);
      //  info.setReservation3(key_shared_MyDr_add_reservation3);
      //  info.setReservation4(key_shared_MyDr_add_reservation4);
      //  info.setReservation5(key_shared_MyDr_add_reservation5);

        return info;

    }


}
