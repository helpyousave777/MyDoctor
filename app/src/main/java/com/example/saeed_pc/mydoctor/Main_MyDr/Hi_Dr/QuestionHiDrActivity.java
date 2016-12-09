package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.saeed_pc.mydoctor.Accessories.constValue_General.constValue_General;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.Info_HiDoctor_UserApp;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.question_UI_HiDr.question_UI_HiDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.MainMyDr;
import com.example.saeed_pc.mydoctor.R;

public class QuestionHiDrActivity extends AppCompatActivity {

    private Info_HiDoctor_UserApp info;
    private question_UI_HiDr  question_ui_hiDr;

    public static TextView txt_question_question_HiDr;
    public static TextView txt_subject_question_HiDr;
    public static TextView txt_dateSend_question_HiDr;
    public static TextView txt_timeSend_question_HiDr;
    public static TextView txt_answer_question_HiDr;
    public static TextView txt_dateReceive_question_HiDr;
    public static TextView txt_timeReceive_question_HiDr;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("===>", "QuestionHiDrActivity.onCreate.1");
        setContentView(R.layout.activity_question_hi_dr);
        Log.i("===>", "QuestionHiDrActivity.onCreate.2");

        init();
        Log.i("===>", "QuestionHiDrActivity.onCreate.3");
    }

    private void init() {
        //ActionBar actionBar=getSupportActionBar();
        //actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1E90FF")));
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_Main_MyDr);
        setSupportActionBar(toolbar);
        toolbar.setTitle("My Dr");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        txt_subject_question_HiDr = (TextView) findViewById(R.id.txtSubjectQuestion_User_add_HiDr);

        txt_question_question_HiDr = (TextView) findViewById(R.id.txtQuestionQuestion_HiDr);
        txt_dateSend_question_HiDr = (TextView) findViewById(R.id.txtDateSendQuestion_HiDr);
        txt_timeSend_question_HiDr = (TextView) findViewById(R.id.txtTimeSendQuestion_HiDr);

        txt_answer_question_HiDr = (TextView) findViewById(R.id.txtAnswerQuestion_HiDr);
        txt_dateReceive_question_HiDr = (TextView) findViewById(R.id.txtDateReceiveQuestion_HiDr);
        txt_timeReceive_question_HiDr = (TextView) findViewById(R.id.txtTimeReceiveQuestion_HiDr);

        info= (Info_HiDoctor_UserApp) getIntent().getExtras().getSerializable("HiDr_information");
        question_ui_hiDr=new question_UI_HiDr(this,info);

        txt_question_question_HiDr.setText("" + info.getSendDate() + info.getSubject() + info.getQuestion());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("===>", "QuestionHiDrActivity.onResume.1");
        init_resume();
        Log.i("===>", "QuestionHiDrActivity.onResume.2");
        question_ui_hiDr.setUI_question_HiDr();
        Log.i("===>", "QuestionHiDrActivity.onResume.3");
    }

    private void init_resume() {
        String receiveDate = info.getReceiveDate();
        if(Long.parseLong(receiveDate)==0){
            txt_answer_question_HiDr.setVisibility(View.INVISIBLE);
            txt_dateReceive_question_HiDr.setVisibility(View.INVISIBLE);
            txt_timeReceive_question_HiDr.setVisibility(View.INVISIBLE);
        }else{
            txt_answer_question_HiDr.setVisibility(View.VISIBLE);
            txt_dateReceive_question_HiDr.setVisibility(View.VISIBLE);
            txt_timeReceive_question_HiDr.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MainMyDr.flag_current_pos= constValue_General.MyDr_HiDr;
        startActivity(new Intent(this, MainMyDr.class));
        finish();
    }
}
