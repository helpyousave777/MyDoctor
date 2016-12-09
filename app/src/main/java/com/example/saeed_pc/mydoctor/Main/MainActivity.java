package com.example.saeed_pc.mydoctor.Main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Info.Info_All_Doctor_Information;
import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Operation_MyDr_AllDoctor_Info;
import com.example.saeed_pc.mydoctor.Accessories.Database.MyDr.Info_registration_MyDr;
import com.example.saeed_pc.mydoctor.Accessories.Database.MyDr.Operation_Mydr;
import com.example.saeed_pc.mydoctor.Accessories.Database.RegisteredDoctor.Info.Info_Registered_Doctor_Information;
import com.example.saeed_pc.mydoctor.Accessories.Database.RegisteredDoctor.Operation_MyDr_RegisteredDoctor_Info;
import com.example.saeed_pc.mydoctor.Main_MyDr.GCM.MainGCMTest;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDoctorMainActivity;
import com.example.saeed_pc.mydoctor.Main.LoginRegister.Login.LoginActivity;
import com.example.saeed_pc.mydoctor.Main.LoginRegister.Register.RegisterActivity;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.SelectContactActivity;
import com.example.saeed_pc.mydoctor.Main_MyDr.MainMyDr;
import com.example.saeed_pc.mydoctor.OnTabSwipable.SmartViewPager.MainSmartViewPager;
import com.example.saeed_pc.mydoctor.OnTabSwipable.materialDesign.mainMaterialDesign;
import com.example.saeed_pc.mydoctor.R;
import com.example.saeed_pc.mydoctor.Main.Splash.Splash;
import com.example.saeed_pc.mydoctor.Accessories.dialogue.dialog;
import com.example.saeed_pc.mydoctor.test.DrInfo.AddDrInfoToDB;
import com.example.saeed_pc.mydoctor.test.InternetTest.MainNetTest;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private dialog dialog;
    public static boolean flag_ready_network = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(Splash.preferences_flag.getBoolean("flag_shared_splashStatus", false)){
            getMenuInflater().inflate(R.menu.menu_main_registered, menu);
        }else{
            getMenuInflater().inflate(R.menu.menu_main_unregistered, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.action_settings:
                break;
            case R.id.action_login:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
                break;
            case R.id.action_register:
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                finish();
                break;
            case R.id.action_logout:
                Splash.preferences_flag.edit().putBoolean("flag_shared_splashStatus", false).commit();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void init(){
        dialog =new dialog(this);
       // ActionBar actionBar=getSupportActionBar();
       // actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1E90FF")));
        Operation_Mydr operation_mydr = new Operation_Mydr(this);
        List<Info_registration_MyDr> all_registration_db_myDr = operation_mydr.getAll_Registration_db_MyDr();
        int size_all_registration_db_myDr = all_registration_db_myDr.size();
        String name;
        if(size_all_registration_db_myDr !=0){
        Info_registration_MyDr info_registration_myDr = all_registration_db_myDr.get(0);
        name = info_registration_myDr.getTABLE_REGISTRATION_ELEMENT_NAME();
        }else {
            name = "Guest";
        }

        if(Splash.preferences_flag.getBoolean("flag_shared_splashStatus", false)){
           // getSupportActionBar().setSubtitle("Hi " + name);
        }else{
          //  getSupportActionBar().setSubtitle("Hi Guest");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if((Splash.preferences_flag.getBoolean("flag_shared_splashStatus", false)) &&(Splash.preferences_flag.getBoolean("flag_shared_firstDialog",true))) {
            dialog.simpleDialog("Welcome", "You can Use all facilities of this App");
            Splash.preferences_flag.edit().putBoolean("flag_shared_firstDialog", false).commit();
        }else if ((Splash.preferences_flag.getBoolean("flag_shared_splashStatus", false))==false) {
            dialog.simpleDialog("Warning", "You should be registered for using all facilities of My Doctor App by free \n " +
                    ",so you are in limited version now");
            Splash.preferences_flag.edit().putBoolean("flag_shared_firstDialog", true).commit();
        }
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
                //System.exit(0);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "It is sweet of you...", Toast.LENGTH_LONG).show();
            }
        });

        builder.create();
        builder.show();
    }


    //--------- on Click --------------------------//
    public void onHiDr(View view) {
        startActivity(new Intent(this, HiDoctorMainActivity.class));
    }

    public void onStore(View view) {
        Log.i("===>", "onStore.1");
        AddDrInfoToDB addDrInfoToDB = new AddDrInfoToDB(this);
        Log.i("===>", "onStore.2");
        try {

            addDrInfoToDB.deleteFromDB();
        }catch (Exception e){
            Log.i("===>","Oooops ..... addDrInfoToDB.deleteFromDB");
        }
        Log.i("===>", "onStore.3");
        addDrInfoToDB.addToDB();
        Log.i("===>", "onStore.4");

       Operation_MyDr_AllDoctor_Info allDoctor_DB = new Operation_MyDr_AllDoctor_Info(this);
        Operation_MyDr_RegisteredDoctor_Info registeredDoctor_DB = new Operation_MyDr_RegisteredDoctor_Info(this);
       Log.i("===>", "onStore.5");
       List<Info_All_Doctor_Information> list = allDoctor_DB.getAll_MyDr_db_MyDr_AllDoctor_Info();

       Log.i("===>", "main.6.9 list " + list.get(0).getName());
       Log.i("===>", "main.6.9 list " + list.get(1).getName());
       Log.i("===>", "main.6.9 list " + list.get(2).getName());
       Log.i("===>", "main.6.9 list " + list.get(3).getName());

        addDrInfoToDB.addDataToRegisteredDrDB(list);
        Log.i("===>", "onStore.5.1");
        List<Info_Registered_Doctor_Information> list_reg = registeredDoctor_DB.getRegistered_MyDr_db_MyDr_AllDoctor_Info();
        Log.i("===>", "onStore.5.2");
        for (int i = 0; i < list_reg.size(); i++) {
            Log.i("===>", "main.6.9 list " + list_reg.get(i).getId_doctor());
        }

        // startActivity(new Intent(this, mainMaterialDesign.class));
        Log.i("===>", "onStore.6");
    }

    public void onReservation(View view) {
        Log.i("===>","onReservation.1");
        //Intent intent = new Intent(this, MainSmartViewPager.class);
        //intent.putExtra("CurrentTab",3);
        //startActivity(intent);

        startActivity(new Intent(this, MainGCMTest.class));

        Log.i("===>", "onReservation.2");
    }

    public void onAdvertisement(View view) {
        Log.i("===>", "onAdvertisement.1");
        startActivity(new Intent(this, MainMyDr.class));
       // startActivity(new Intent(this, mainMaterialDesign.class));
        Log.i("===>", "onAdvertisement.2");
    }

    public void onDiscount(View view) {
        Log.i("===>","onDiscount1");
            startActivity(new Intent(this, MainNetTest.class));
        Log.i("===>", "onDiscount2");
    }
}
