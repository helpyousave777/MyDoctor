package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.saeed_pc.mydoctor.Accessories.constValue_General.constValue_General;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.Database_HiDr.Operation_HiDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.Database_HiDr.setInfoToDatabase_HiDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDoctorFragment;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDoctorMainActivity;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDoctorQuestionActivity;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.QuestionHiDrActivity;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.Info_HiDoctor_UserApp;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.listViewOperation_HiDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.MainMyDr;
import com.example.saeed_pc.mydoctor.R;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by ici80481 on 11/23/2015.
 */
public class dialog {

    private static List<Info_HiDoctor_UserApp> all_message_info;
    private static Operation_HiDr operation_hiDr;
    private Context context;
    public static EditText edit_HiDr_Subject;
    public static EditText edit_HiDr_Question;


    public dialog(Context context) {
        this.context=context;
        operation_hiDr = new Operation_HiDr(context);


    }

    public void newMessage(final int position) {



        AlertDialog.Builder builder =  new AlertDialog.Builder(context);
        builder.setTitle("Question UI ");

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root_view = inflater.inflate(R.layout.dialog_hi_dr_new_message, null);

        edit_HiDr_Subject = (EditText) root_view.findViewById(R.id.editHiDrSubject);
        edit_HiDr_Question = (EditText) root_view.findViewById(R.id.editHiDrQuestion);
        TextView txt = (TextView) root_view.findViewById(R.id.txtHiDrQuestion);
        txt.setVisibility(View.INVISIBLE);
        edit_HiDr_Question.setVisibility(View.INVISIBLE);



        //  info_Restaurant_step1 info_restaurant =new info_Restaurant_step1(MainActivity.this,root_view);
        //  info_restaurant.getParameterInfoRestaurant_step1(root_view);
        try {
            Info_HiDoctor_UserApp info = dialog_HiDr_SetGetInformationShared.getInformationFromShared();
            edit_HiDr_Subject.setText(info.getSubject());
            Log.i("===>","newMessage subject: "+ info.getSubject());
            //edit_HiDr_Question.setText(info.getQuestion());
            dialog_HiDr_SetGetInformationShared.setInformationOnShared_HiDr();
        }catch (Exception e){
            Log.i("===>", "oops");
        }



        builder.setView(root_view);

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


              //  setInfoToDatabase_HiDr setInfoToDatabase_hiDr = new setInfoToDatabase_HiDr(context);
              //  setInfoToDatabase_hiDr.setInfo_fromNewMessage();
              //  dialog_HiDr_SetGetInformationShared.setInformationOnShared_HiDr_Cancel();
                all_message_info = operation_hiDr.getAll_HiDr_db_MyDr();
                Log.i("===>", "new message.sav.4");
                // context.startActivity(new Intent(context,HiDoctorMainActivity.class));
                Intent intent = new Intent(context, HiDoctorQuestionActivity.class);
                intent.putExtra("Subject", edit_HiDr_Subject.getText().toString());
                intent.putExtra("Position", position);
                Log.i("===>", "new message.sav.4.5 " + ((all_message_info.size()) - 1));
                    setIntentPutExtra(((all_message_info.size()) - 1), intent);
                MainMyDr.flag_question_pos =constValue_General.HyDr_NewMessage;
              //  HiDoctorQuestionActivity.editQuestion.setVisibility(View.VISIBLE);
              //  HiDoctorQuestionActivity.imgSend.setVisibility(View.VISIBLE);
                context.startActivity(intent);


                Log.i("===>", "new message.sav.5");



                //Todo
                //send data to server

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                dialog_HiDr_SetGetInformationShared.setInformationOnShared_HiDr_Cancel();
                Intent intent = new Intent(context, MainMyDr.class);
                MainMyDr.flag_current_pos= constValue_General.MyDr_HiDr;
                MainMyDr.flag_question_pos =constValue_General.HyDr_ShowMessage;
                context.startActivity(intent);


            }
        });


        builder.create();
        builder.show();
        Log.i("===>", "newMessage.7");
    }


    public static void setIntentPutExtra(int position, Intent intent) {
        if(position != -1) {
            Info_HiDoctor_UserApp info = all_message_info.get(position);
            Bundle bundle = new Bundle();
            bundle.putSerializable("HiDr_information", info);
            intent.putExtras(bundle);
        }else{
            Bundle bundle = new Bundle();
            bundle.putSerializable("HiDr_information", null);
            intent.putExtras(bundle);

        }


    }





}
