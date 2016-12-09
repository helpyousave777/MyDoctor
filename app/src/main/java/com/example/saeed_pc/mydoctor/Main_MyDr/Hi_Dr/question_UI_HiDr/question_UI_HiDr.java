package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.question_UI_HiDr;

import android.content.Context;

import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.QuestionHiDrActivity;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.Info_HiDoctor_UserApp;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.question_UI_HiDr.date_Setting.date_Setting;

/**
 * Created by ici80481 on 11/28/2015.
 */
public class question_UI_HiDr {

    private static Info_HiDoctor_UserApp info;
    private Context context;

    public question_UI_HiDr(Context context ,Info_HiDoctor_UserApp info ) {
        this.info = info;
        this.context = context;
    }

    public static void setUI_question_HiDr(){
        QuestionHiDrActivity.txt_subject_question_HiDr.setText(info.getSubject());
        QuestionHiDrActivity.txt_question_question_HiDr.setText(info.getQuestion());

        date_Setting.sendDateQuestionSetting(info);
    }
}
