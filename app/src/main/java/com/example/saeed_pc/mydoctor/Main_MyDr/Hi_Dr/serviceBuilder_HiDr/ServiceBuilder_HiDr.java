package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.serviceBuilder_HiDr;

import android.content.Context;
import android.content.Intent;

import com.example.saeed_pc.mydoctor.Main.service.MyService;

/**
 * Created by ici80481 on 12/1/2015.
 */
public class ServiceBuilder_HiDr {

    private Context context;
    public ServiceBuilder_HiDr(Context context) {
        this.context=context;
    }

    public void start_Service(){
        context.startService(new Intent(context, MyService.class));
    }
    public void stop_Service(){
        context.stopService(new Intent(context,MyService.class));
    }
}
