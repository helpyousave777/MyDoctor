package com.example.saeed_pc.mydoctor.Main.Splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.serviceBuilder_HiDr.ServiceBuilder_HiDr;
import com.example.saeed_pc.mydoctor.Main.LoginRegister.Login.LoginActivity;
import com.example.saeed_pc.mydoctor.Main.MainActivity;
import com.example.saeed_pc.mydoctor.Main_MyDr.Service.TestBroadcastReceiver;
import com.example.saeed_pc.mydoctor.R;

public class Splash extends AppCompatActivity {


    private int sleep_timer = 1;
    public static SharedPreferences preferences_flag ;
    public static SharedPreferences preferences_add_Mydr;
    private ServiceBuilder_HiDr serviceBuilder_hiDr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       // getSupportActionBar().hide();
        init();



    }
    private void init(){

        serviceBuilder_hiDr=new ServiceBuilder_HiDr(this);
        serviceBuilder_hiDr.start_Service();

        preferences_flag = getSharedPreferences("flag_shared_splashStatus",MODE_PRIVATE);
        preferences_flag = getSharedPreferences("flag_shared_firstDialog",MODE_PRIVATE);

        preferences_add_Mydr = getSharedPreferences("key_shared_registration_add_id",MODE_PRIVATE);
        preferences_add_Mydr = getSharedPreferences("key_shared_registration_add_name",MODE_PRIVATE);
        preferences_add_Mydr = getSharedPreferences("key_shared_registration_add_family",MODE_PRIVATE);
        preferences_add_Mydr = getSharedPreferences("key_shared_registration_add_userName",MODE_PRIVATE);
        preferences_add_Mydr = getSharedPreferences("key_shared_registration_add_password",MODE_PRIVATE);
        preferences_add_Mydr = getSharedPreferences("key_shared_registration_add_phone",MODE_PRIVATE);
        preferences_add_Mydr = getSharedPreferences("key_shared_registration_add_mail",MODE_PRIVATE);
        preferences_add_Mydr = getSharedPreferences("key_shared_registration_add_age",MODE_PRIVATE);
        preferences_add_Mydr = getSharedPreferences("key_shared_registration_add_sex",MODE_PRIVATE);
        preferences_add_Mydr = getSharedPreferences("key_shared_registration_add_reservation1",MODE_PRIVATE);
        preferences_add_Mydr = getSharedPreferences("key_shared_registration_add_reservation2",MODE_PRIVATE);
        preferences_add_Mydr = getSharedPreferences("key_shared_registration_add_reservation3",MODE_PRIVATE);
        preferences_add_Mydr = getSharedPreferences("key_shared_registration_add_reservation4",MODE_PRIVATE);
        preferences_add_Mydr = getSharedPreferences("key_shared_registration_add_reservation5",MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final boolean flag_shared_splashStatus = Splash.preferences_flag.getBoolean("flag_shared_splashStatus", false);
        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <= sleep_timer ; i++) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
                if(flag_shared_splashStatus){
                    startActivity(new Intent(Splash.this, MainActivity.class));
                    finish();

                }else {
                    startActivity(new Intent(Splash.this, LoginActivity.class));
                    finish();

                }
            }
        }).start();

    }
}

