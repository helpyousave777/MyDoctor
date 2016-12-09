package com.example.saeed_pc.mydoctor.Main.service;

import com.example.saeed_pc.mydoctor.Accessories.constValue_General.constValue_General;

/**
 * Created by ici80481 on 12/1/2015.
 */
public class MyThread extends Thread {



    @Override
    public void run() {
        super.run();
        for (int i = 0; i < constValue_General.TIME_START_AGAIN_SERVICE ; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }

    }
}
