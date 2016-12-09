package com.example.saeed_pc.mydoctor.Main.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {


    private Handler handler;
    private MyThread myThread;
    public MyService() {

    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

     //   Toast.makeText(this, "onStartCommand", Toast.LENGTH_LONG).show();


        if (myThread == null) {
            handler = new Handler();
            myThread = new MyThread();
            myThread.start();
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        myThread.interrupt();
        myThread = null;

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i == 9) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                             //   Toast.makeText(MyService.this, "U CAN NOT STOPE ME !!!!!!",Toast.LENGTH_LONG).show();
                            }
                        });
                        Intent intent = new Intent(MyService.this, MyService.class);
                        startService(intent);
                    }
                }
            }
        }).start();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show();
    }
}
