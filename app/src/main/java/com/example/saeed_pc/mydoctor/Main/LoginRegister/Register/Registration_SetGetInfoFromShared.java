package com.example.saeed_pc.mydoctor.Main.LoginRegister.Register;



import com.example.saeed_pc.mydoctor.Accessories.Database.MyDr.Info_registration_MyDr;
import com.example.saeed_pc.mydoctor.Main.LoginRegister.Login.LoginActivity;
import com.example.saeed_pc.mydoctor.Main.Splash.Splash;

/**
 * Created by ici80481 on 10/7/2015.
 */
public class Registration_SetGetInfoFromShared {


    private static String key_shared_registration_add_name;
    private static String key_shared_registration_add_family;
    private static String key_shared_registration_add_userName;
    private static String key_shared_registration_add_password;
    private static String key_shared_registration_add_phone;
    private static String key_shared_registration_add_mail;
    private static String key_shared_registration_add_age;
    private static String key_shared_registration_add_sex;
    private static String key_shared_registration_add_reservation1;
    private static String key_shared_registration_add_reservation2;
    private static String key_shared_registration_add_reservation3;
    private static String key_shared_registration_add_reservation4;
    private static String key_shared_registration_add_reservation5;

    public static Info_registration_MyDr getInfo(){


        String key_shared_registration_add_name = Splash.preferences_add_Mydr.getString("key_shared_registration_add_name", "0");
        String key_shared_registration_add_family = Splash.preferences_add_Mydr.getString("key_shared_registration_add_family", "0");
        String shared_registration_add_userName = Splash.preferences_add_Mydr.getString("key_shared_registration_add_userName", "0");
        String key_shared_registration_add_password = Splash.preferences_add_Mydr.getString("key_shared_registration_add_password", "0");
        String key_shared_registration_add_phone = Splash.preferences_add_Mydr.getString("key_shared_registration_add_phone", "0");
        String key_shared_registration_add_mail = Splash.preferences_add_Mydr.getString("key_shared_registration_add_mail", "0");
        String key_shared_registration_add_age = Splash.preferences_add_Mydr.getString("key_shared_registration_add_age", "0");
        String key_shared_registration_add_sex = Splash.preferences_add_Mydr.getString("key_shared_registration_add_sex", "0");
        String key_shared_registration_add_reservation1 = Splash.preferences_add_Mydr.getString("key_shared_registration_add_reservation1", "0");
        String key_shared_registration_add_reservation2 = Splash.preferences_add_Mydr.getString("key_shared_registration_add_reservation2", "0");
        String key_shared_registration_add_reservation3 = Splash.preferences_add_Mydr.getString("key_shared_registration_add_reservation3", "0");
        String key_shared_registration_add_reservation4 = Splash.preferences_add_Mydr.getString("key_shared_registration_add_reservation4", "0");
        String key_shared_registration_add_reservation5 = Splash.preferences_add_Mydr.getString("key_shared_registration_add_reservation5", "0");


        Info_registration_MyDr info =new Info_registration_MyDr();
        info.setTABLE_REGISTRATION_ELEMENT_NAME(key_shared_registration_add_name);
        info.setTABLE_REGISTRATION_ELEMENT_FAMILY(key_shared_registration_add_family);
        info.setTABLE_REGISTRATION_ELEMENT_USERNAME(shared_registration_add_userName);
        info.setTABLE_REGISTRATION_ELEMENT_PASSWORD(key_shared_registration_add_password);
        info.setTABLE_REGISTRATION_ELEMENT_PHONE(key_shared_registration_add_phone);
        info.setTABLE_REGISTRATION_ELEMENT_MAIL(key_shared_registration_add_mail);
        info.setTABLE_REGISTRATION_ELEMENT_AGE(key_shared_registration_add_age);
        info.setTABLE_REGISTRATION_ELEMENT_SEX(key_shared_registration_add_sex);
        info.setTABLE_REGISTRATION_ELEMENT_RESERVE1(key_shared_registration_add_reservation1);
        info.setTABLE_REGISTRATION_ELEMENT_RESERVE2(key_shared_registration_add_reservation2);
        info.setTABLE_REGISTRATION_ELEMENT_RESERVE3(key_shared_registration_add_reservation3);
        info.setTABLE_REGISTRATION_ELEMENT_RESERVE4(key_shared_registration_add_reservation4);
        info.setTABLE_REGISTRATION_ELEMENT_RESERVE5(key_shared_registration_add_reservation5);


     //  myApp.getRestaurantInfo().addRestaurant(info);
     //  Log.i("===>", "data4");
        return info;



    }


    public void setInformationOnShared_Registration() {


        Splash.preferences_add_Mydr.edit().putString("key_shared_registration_add_name", RegisterActivity.editName_registration.getText().toString()).commit();
        Splash.preferences_add_Mydr.edit().putString("key_shared_registration_add_family", RegisterActivity.editFamily_registration.getText().toString()).commit();
        Splash.preferences_add_Mydr.edit().putString("key_shared_registration_add_userName", RegisterActivity.editUserName_registration.getText().toString()).commit();
        Splash.preferences_add_Mydr.edit().putString("key_shared_registration_add_password", RegisterActivity.editPassword_registration.getText().toString()).commit();
        Splash.preferences_add_Mydr.edit().putString("key_shared_registration_add_phone", RegisterActivity.editPhone_registration.getText().toString()).commit();
        Splash.preferences_add_Mydr.edit().putString("key_shared_registration_add_mail", RegisterActivity.editMail_registration.getText().toString()).commit();
        Splash.preferences_add_Mydr.edit().putString("key_shared_registration_add_age", RegisterActivity.editAge_registration.getText().toString()).commit();
        Splash.preferences_add_Mydr.edit().putString("key_shared_registration_add_sex", RegisterActivity.item_sex_registration).commit();
       //RegisterActivity.preferences_add_Mydr.edit().putString("key_shared_registration_add_reservation1", ).commit();
       //RegisterActivity.preferences_add_Mydr.edit().putString("key_shared_registration_add_reservation2", ).commit();
       //RegisterActivity.preferences_add_Mydr.edit().putString("key_shared_registration_add_reservation3", ).commit();
       //RegisterActivity.preferences_add_Mydr.edit().putString("key_shared_registration_add_reservation4", ).commit();
       //RegisterActivity.preferences_add_Mydr.edit().putString("key_shared_registration_add_reservation5", ).commit();

    }

    public boolean setInformationOnShared_Login() {

        //Todo
        // get information from server ( all key shared ) and save in shared... and then we should save it on db
        // name need for set subtext of actionbar

        boolean flag_SetInformation_Login = true;

        try {


            Splash.preferences_add_Mydr.edit().putString("key_shared_registration_add_name", "this part should set from server").commit();
            Splash.preferences_add_Mydr.edit().putString("key_shared_registration_add_userName", LoginActivity.editUserName_login.getText().toString()).commit();
            Splash.preferences_add_Mydr.edit().putString("key_shared_registration_add_password", LoginActivity.editPassword_login.getText().toString()).commit();
            //RegisterActivity.preferences_add_Mydr.edit().putString("key_shared_registration_add_reservation1", ).commit();
            //RegisterActivity.preferences_add_Mydr.edit().putString("key_shared_registration_add_reservation2", ).commit();
            //RegisterActivity.preferences_add_Mydr.edit().putString("key_shared_registration_add_reservation3", ).commit();
            //RegisterActivity.preferences_add_Mydr.edit().putString("key_shared_registration_add_reservation4", ).commit();
            //RegisterActivity.preferences_add_Mydr.edit().putString("key_shared_registration_add_reservation5", ).commit();
        }catch (Exception e){
            flag_SetInformation_Login = false;


        }
        return flag_SetInformation_Login;

    }

    public void getInformationFromShared(){


        key_shared_registration_add_name = Splash.preferences_add_Mydr.getString("key_shared_registration_add_name", "0");
        key_shared_registration_add_family =   Splash.preferences_add_Mydr.getString("key_shared_registration_add_family", "0");
        key_shared_registration_add_userName =  Splash.preferences_add_Mydr.getString("key_shared_registration_add_userName", "0");
        key_shared_registration_add_password = Splash.preferences_add_Mydr.getString("key_shared_registration_add_password", "0");
        key_shared_registration_add_phone =  Splash.preferences_add_Mydr.getString("key_shared_registration_add_phone", "0");
        key_shared_registration_add_mail =  Splash.preferences_add_Mydr.getString("key_shared_registration_add_mail", "0");
        key_shared_registration_add_age =  Splash.preferences_add_Mydr.getString("key_shared_registration_add_age", "0");
        key_shared_registration_add_sex =  Splash.preferences_add_Mydr.getString("key_shared_registration_add_sex", "0");
        key_shared_registration_add_reservation1 =  Splash.preferences_add_Mydr.getString("key_shared_registration_add_reservation1", "0");
        key_shared_registration_add_reservation2 =  Splash.preferences_add_Mydr.getString("key_shared_registration_add_reservation2", "0");
        key_shared_registration_add_reservation3 =  Splash.preferences_add_Mydr.getString("key_shared_registration_add_reservation3", "0");
        key_shared_registration_add_reservation4 =  Splash.preferences_add_Mydr.getString("key_shared_registration_add_reservation4", "0");
        key_shared_registration_add_reservation5 =  Splash.preferences_add_Mydr.getString("key_shared_registration_add_reservation5", "0");




    }

    public void setInfoFromSharedToUI_Registration(){

        RegisterActivity.editName_registration.setText("" + key_shared_registration_add_name);
        RegisterActivity.editFamily_registration.setText("" + key_shared_registration_add_family);
        RegisterActivity.editUserName_registration.setText("" + key_shared_registration_add_userName);
        RegisterActivity.editPhone_registration.setText("" + key_shared_registration_add_phone);
        RegisterActivity.editMail_registration.setText("" + key_shared_registration_add_mail);
        RegisterActivity.editAge_registration.setText("" + key_shared_registration_add_age);

    }
}
