package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.question_UI_HiDr.date_Setting;

import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.QuestionHiDrActivity;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.date.date;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.Info_HiDoctor_UserApp;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.question_UI_HiDr.Activity.QuestionFragment;

/**
 * Created by ici80481 on 11/28/2015.
 */
public class date_Setting {

    public static void sendDateQuestionSetting_fragment(Info_HiDoctor_UserApp info){

        String sendDate = info.getSendDate();

        String timeOnly_integer_eq = date.getTimeOnly_Integer_eq(sendDate);
        String timeOnly = date.getTimeOnly_String_eq(timeOnly_integer_eq);


        String dateOnly_integer_eq = date.getDateOnly_Integer_eq(sendDate);
        String dateOnly = date.getDateOnly_String_eq(dateOnly_integer_eq);


        QuestionFragment.txt_dateSend_question_HiDr.setText(dateOnly);
        QuestionFragment.txt_timeSend_question_HiDr.setText(timeOnly);
    }

  //deprecated
    public static void sendDateQuestionSetting(Info_HiDoctor_UserApp info){

        String sendDate = info.getSendDate();

      String timeOnly_integer_eq = date.getTimeOnly_Integer_eq(sendDate);
      String timeOnly = date.getTimeOnly_String_eq(timeOnly_integer_eq);


      String dateOnly_integer_eq = date.getDateOnly_Integer_eq(sendDate);
      String dateOnly = date.getDateOnly_String_eq(dateOnly_integer_eq);

      QuestionHiDrActivity.txt_dateSend_question_HiDr.setText(dateOnly);
      QuestionHiDrActivity.txt_timeSend_question_HiDr.setText(timeOnly);
    }
}
