package com.example.saeed_pc.mydoctor.Accessories.dialogue;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by SAEED-PC on 11/9/2015.
 */
public class dialog {

    private static Context context;
    private static int sleep_timer =1;
    public dialog(Context context) {
        this.context=context;
    }

    public static void simpleDialog(String title , String Message){
        AlertDialog.Builder builder = new  AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.create();
        builder.show();
    }


    }
