package com.example.saeed_pc.mydoctor.Main.LoginRegister.Login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.saeed_pc.mydoctor.Accessories.Database.MyDr.Info_registration_MyDr;
import com.example.saeed_pc.mydoctor.Accessories.Database.MyDr.Operation_Mydr;
import com.example.saeed_pc.mydoctor.Main.LoginRegister.Register.RegisterActivity;
import com.example.saeed_pc.mydoctor.Main.LoginRegister.Register.Registration_SetGetInfoFromShared;
import com.example.saeed_pc.mydoctor.Main.MainActivity;
import com.example.saeed_pc.mydoctor.R;
import com.example.saeed_pc.mydoctor.Main.Splash.Splash;

public class LoginActivity extends AppCompatActivity {

    public static EditText editUserName_login;
    public static EditText editPassword_login;
    private Registration_SetGetInfoFromShared registration_SetGetInfoFromShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

    private void init(){
        editUserName_login = (EditText) findViewById(R.id.editUserNameLogin);
        editPassword_login = (EditText) findViewById(R.id.editPasswordLogin);

        registration_SetGetInfoFromShared = new Registration_SetGetInfoFromShared();

    }

    public void onLogin(View view) {
        //Todo
        // send Info to server
        //------------------------ send to server--------------------------//
        //Todo
        //if ( receive acknowledge from server ){
        Splash.preferences_flag.edit().putBoolean("flag_shared_splashStatus", true).commit();
        //}
        //---------------------------------------------------------------//



        Operation_Mydr operation = new Operation_Mydr(LoginActivity.this);
        registration_SetGetInfoFromShared.setInformationOnShared_Login();

            //-------- save register information on db --------------------------//
            Info_registration_MyDr info = registration_SetGetInfoFromShared.getInfo();
            operation.deleteAll_Registration_db_MyDr();
            operation.add_Registration_db_MyDr(info);
            //------------------------------------------------------------------//


            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    public void onCancel(View view) {
        Log.i("===>","onCancel1");
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        Log.i("===>", "onCancel2");
        finish();
        Log.i("===>", "onCancel3");

    }

    public void onRegister(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        finish();
    }


    @Override
    public void onBackPressed() {
        dialogExit();
    }
    private void dialogExit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit");
        builder.setMessage("Are you sure to exit ?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LoginActivity.this, "It is sweet of you...", Toast.LENGTH_LONG).show();
            }
        });

        builder.create();
        builder.show();
    }
}
