package com.example.saeed_pc.mydoctor.Main_MyDr.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

import com.example.saeed_pc.mydoctor.Main.service.MyThread;


/*
  service can be started everywhere for ex we can start it via a button and onClick...
*/

public class TestService extends Service {


    private Handler handler;
    private MyThread myThread;

    public TestService() {
    }

    //attach service to activity
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    // write all code that we expect run in the service
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (myThread == null) {
            handler = new Handler();
            myThread = new MyThread();
            myThread.start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <21 ; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Intent senderIntent = new Intent("com.example.saeed_pc.mydoctor.test.InternetTest.MyDownloaderReceiver.BroadcastPM");
                    senderIntent.putExtra("number",""+i);
                    if(i%5 == 0) {
                        sendBroadcast(senderIntent);
                    }
                }

            }
        }).start();


        return START_STICKY;
    }

    //service will be destroyed completely in this function
    /*
    this service will never stop
     */
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
                        Intent intent = new Intent(TestService.this, TestService.class);
                        startService(intent);
                    }
                }
            }
        }).start();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show();
    }






}
