package com.example.saeed_pc.mydoctor.Main.LoginRegister.Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.saeed_pc.mydoctor.Accessories.Database.MyDr.Info_registration_MyDr;
import com.example.saeed_pc.mydoctor.Accessories.Database.MyDr.Operation_Mydr;
import com.example.saeed_pc.mydoctor.Main.MainActivity;
import com.example.saeed_pc.mydoctor.R;
import com.example.saeed_pc.mydoctor.Main.Splash.Splash;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static EditText editName_registration;
    public static EditText editFamily_registration;
    public static EditText editUserName_registration;
    public static EditText editPassword_registration;
    public static EditText editPhone_registration;
    public static EditText editMail_registration;
    public static EditText editAge_registration;

    public static String item_sex_registration;
    private Registration_SetGetInfoFromShared registration_SetGetInfoFromShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spinnerManager();

    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
        registration_SetGetInfoFromShared.getInformationFromShared();
        registration_SetGetInfoFromShared.setInfoFromSharedToUI_Registration();
    }

    @Override
    protected void onPause() {
        super.onPause();
        registration_SetGetInfoFromShared.setInformationOnShared_Registration();
    }

    private void spinnerManager()
    {
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinnerSexRegister);
// Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Male");
        categories.add("Female");
        categories.add("Other");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        item_sex_registration = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item_sex_registration, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    private void init(){

        registration_SetGetInfoFromShared = new Registration_SetGetInfoFromShared();

        editName_registration = (EditText) findViewById(R.id.editNameRegister);
        editFamily_registration = (EditText) findViewById(R.id.editFamilyRegister);
        editUserName_registration = (EditText) findViewById(R.id.editUserNameRegister);
        editPassword_registration = (EditText) findViewById(R.id.editPasswordRegister);
        editPhone_registration = (EditText) findViewById(R.id.editPhoneRegister);
        editMail_registration = (EditText) findViewById(R.id.editMailRegister);
        editAge_registration = (EditText) findViewById(R.id.editAgeRegister);
        editName_registration = (EditText) findViewById(R.id.editNameRegister);





    }
    public void onSaveRegister(View view) {
        //Todo
        // send Info to server
        //------------------------ send to server--------------------------//
        //Todo
        //if ( receive acknowledge from server ){
        Splash.preferences_flag.edit().putBoolean("flag_shared_splashStatus", true).commit();
        //}
        //---------------------------------------------------------------//



        Operation_Mydr operation = new Operation_Mydr(RegisterActivity.this);
        registration_SetGetInfoFromShared.setInformationOnShared_Registration();

        //-------- save register information on db --------------------------//
        Info_registration_MyDr info = registration_SetGetInfoFromShared.getInfo();
        operation.deleteAll_Registration_db_MyDr();
        operation.add_Registration_db_MyDr(info);
        //------------------------------------------------------------------//

        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
        finish();
    }

    public void onCancelRegister(View view) {
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity.class));
    }
}
