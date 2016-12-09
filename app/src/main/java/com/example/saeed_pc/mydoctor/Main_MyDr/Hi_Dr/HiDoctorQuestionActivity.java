package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr;

import android.app.FragmentManager;
import android.content.Intent;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Info.Info_All_Doctor_Information;
import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Operation_MyDr_AllDoctor_Info;
import com.example.saeed_pc.mydoctor.Accessories.constValue_General.constValue_General;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.Database_HiDr.setInfoToDatabase_HiDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.dialog.dialog_HiDr_SetGetInformationShared;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.Info_HiDoctor_UserApp;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.question_UI_HiDr.Activity.QuestionFragment;
import com.example.saeed_pc.mydoctor.Main_MyDr.MainMyDr;
import com.example.saeed_pc.mydoctor.R;

import java.util.List;

public class HiDoctorQuestionActivity extends AppCompatActivity implements QuestionFragment.OnFragmentInteractionListener {

    public static String question;
    public static Info_All_Doctor_Information info_all_doctor_information;

    public static EditText editQuestion;
    public static ImageView imgSend;
    private String subject;
    private int Position;
    private Info_HiDoctor_UserApp info_Message;
    private Toolbar toolbar;
    private Info_All_Doctor_Information info_Dr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hi_doctor_question);
        toolbar = (Toolbar) findViewById(R.id.toolbar_Question_HiDr);





    }

    private void init() {
        Log.i("===>","HiDoctorQuestionActivity.init.0");
        editQuestion = (EditText) findViewById(R.id.edtTxtQuestionHiDr);
        imgSend = (ImageView) findViewById(R.id.imgViewSendQuestionHiDr);
        info_Message= (Info_HiDoctor_UserApp) getIntent().getExtras().getSerializable("HiDr_information");


        Operation_MyDr_AllDoctor_Info allDoctor_DB = new Operation_MyDr_AllDoctor_Info(this);
        List<Info_All_Doctor_Information> list_DB = allDoctor_DB.getAll_MyDr_db_MyDr_AllDoctor_Info();



        //fragment_container_Question_HiDr
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();



        if(MainMyDr.flag_question_pos == constValue_General.HyDr_ShowMessage){
            Log.i("===>", "HiDoctorQuestionActivity.init.HyDr_ShowMessage");
            editQuestion.setVisibility(View.INVISIBLE);
            imgSend.setVisibility(View.INVISIBLE);
            subject = getIntent().getStringExtra("Subject");
            Position = getIntent().getIntExtra("Position", 0);
            info_all_doctor_information=allDoctor_DB.query_db_MyDr_AllDoctor(info_Message.getReservation1());
            toolbar.setTitle(info_all_doctor_information.getName());
            toolbar.setSubtitle(info_all_doctor_information.getField());

            QuestionFragment questionFragment = QuestionFragment.newInstance(subject, info_Message.getQuestion(),info_Message);
            fragmentTransaction.replace(R.id.fragment_container_Question_HiDr, questionFragment);
            fragmentTransaction.commit();
            Log.i("===>", "HiDoctorQuestionActivity subject:" + subject + "  HiDoctorQuestionActivity position:" + Position);

            //Todo : Position = getIntent().getIntExtra("Position", 0);
        }else {
            Log.i("===>","HiDoctorQuestionActivity.init.HyDr_NewMessage");
            editQuestion.setVisibility(View.VISIBLE);
            imgSend.setVisibility(View.VISIBLE);
            subject = getIntent().getStringExtra("Subject");
            Position = getIntent().getIntExtra("Position", 0);
            info_all_doctor_information = list_DB.get(Position);
            toolbar.setTitle(info_all_doctor_information.getName());
            toolbar.setSubtitle(info_all_doctor_information.getField());

            QuestionFragment questionFragment = QuestionFragment.newInstance(subject, "" + constValue_General.null_number,info_Message);
            fragmentTransaction.replace(R.id.fragment_container_Question_HiDr, questionFragment);
            fragmentTransaction.commit();
            Log.i("===>","HiDoctorQuestionActivity subject:"+subject +"  HiDoctorQuestionActivity position:"+ Position);
            //String subject = getIntent().getIntExtra("Subject", constValue_General.null_number).getSt;
           // getIntent().getIntExtra("Position", constValue_General.null_number);
        }


        toolbar.setLogo(R.mipmap.test_dr);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Log.i("===>", "HiDoctorQuestionActivity.init.8");




    }

    @Override
    protected void onResume() {
        super.onResume();

        init();
        setFragment();
    }

    private void setFragment() {

        //Todo start fragment and insert subject to it
        if(MainMyDr.flag_question_pos == constValue_General.HyDr_NewMessage) {
            new QuestionFragment().newInstance(subject, "" + constValue_General.null_number, info_Message);
        }else {
           // new QuestionFragment().newInstance(subject, editQuestion.getText().toString());

        }
        }



    public void onClick_SendQuestion_HiDr(View view) {
        //Todo check if edit text is not null then replace question fragment to new fragment with question part
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainMyDr.class));
        finish();
    }

    @Override
    public void onFragmentInteraction(boolean flag_ques_done , String question) {
        Log.i("===>", "HiDoctorQuestionActivity.onFragmentInteraction.1");
        if(flag_ques_done){
            Log.i("===>","HiDoctorQuestionActivity.onFragmentInteraction.2");
            editQuestion.setVisibility(View.INVISIBLE);
            imgSend.setVisibility(View.INVISIBLE);
            Toast.makeText(this,"Your message was sent",Toast.LENGTH_LONG).show();
            this.question=question;
            saveInfoOnDB();
            Log.i("===>", "HiDoctorQuestionActivity.onFragmentInteraction.3");
        }
        Log.i("===>", "HiDoctorQuestionActivity.onFragmentInteraction.4");

    }

    private void saveInfoOnDB() {



        setInfoToDatabase_HiDr setInfoToDatabase_hiDr = new setInfoToDatabase_HiDr(this);
        setInfoToDatabase_hiDr.setInfo_fromNewMessage();
        dialog_HiDr_SetGetInformationShared.setInformationOnShared_HiDr_Cancel();



        //Position

    }
}
