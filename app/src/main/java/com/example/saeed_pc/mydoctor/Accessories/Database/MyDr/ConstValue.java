package com.example.saeed_pc.mydoctor.Accessories.Database.MyDr;

/**
 * Created by SAEED-PC on 10/1/2015.
 */
public class ConstValue {


    public static String DATABASE_NAME = "my_db.db";
    public static int VERSION_DATABASE_INFO_NEW = 1;


    //----------------------------- database registration ----------------------------------------//

    public static String COLUMN_ID = "_id";
    public static String TABLE_INFO_REGISTRATION = "registration_table";

    public static String TABLE_REGISTRATION_ELEMENT_NAME = "name";
    public static String TABLE_REGISTRATION_ELEMENT_FAMILY = "family";
    public static String TABLE_REGISTRATION_ELEMENT_USERNAME = "user_name";
    public static String TABLE_REGISTRATION_ELEMENT_PASSWORD = "password";
    public static String TABLE_REGISTRATION_ELEMENT_PHONE = "phone";
    public static String TABLE_REGISTRATION_ELEMENT_MAIL = "mail";
    public static String TABLE_REGISTRATION_ELEMENT_AGE = "age";
    public static String TABLE_REGISTRATION_ELEMENT_SEX = "sex";
    public static String TABLE_REGISTRATION_ELEMENT_RESERVE1 = "reserve1";
    public static String TABLE_REGISTRATION_ELEMENT_RESERVE2 = "reserve2";
    public static String TABLE_REGISTRATION_ELEMENT_RESERVE3 = "reserve3";
    public static String TABLE_REGISTRATION_ELEMENT_RESERVE4 = "reserve4";
    public static String TABLE_REGISTRATION_ELEMENT_RESERVE5 = "reserve5";




    public static String CREATE_INFORMATION_REGISTRATION_TABLE = "create table " + TABLE_INFO_REGISTRATION + " ("
            + COLUMN_ID + " integer primary key, "
            + TABLE_REGISTRATION_ELEMENT_NAME + " TEXT, "
            + TABLE_REGISTRATION_ELEMENT_FAMILY + " TEXT, "
            + TABLE_REGISTRATION_ELEMENT_USERNAME + " TEXT, "
            + TABLE_REGISTRATION_ELEMENT_PASSWORD + " TEXT, "
            + TABLE_REGISTRATION_ELEMENT_PHONE + " TEXT, "
            + TABLE_REGISTRATION_ELEMENT_MAIL + " TEXT, "
            + TABLE_REGISTRATION_ELEMENT_AGE + " TEXT, "
            + TABLE_REGISTRATION_ELEMENT_SEX + " TEXT, "
            + TABLE_REGISTRATION_ELEMENT_RESERVE1 + " TEXT, "
            + TABLE_REGISTRATION_ELEMENT_RESERVE2 + " TEXT, "
            + TABLE_REGISTRATION_ELEMENT_RESERVE3 + " TEXT, "
            + TABLE_REGISTRATION_ELEMENT_RESERVE4 + " TEXT, "
            + TABLE_REGISTRATION_ELEMENT_RESERVE5 + " TEXT);";


//------------------------------------------------------------------------------------------------//

//----------------------------- database HiDOctor_USER_APP ----------------------------------------//

    /*modified at 95/02/06

    reserve1 = Dr ID
    changes: setInfo_fromNewMessage

     */

    public static String TABLE_INFO_HiDoctor_UserApp = "HiDr_UserApp_table";

    public static String TABLE_HiDr_UserApp_ELEMENT_SEND_DATE = "send_date";
    public static String TABLE_HiDr_UserApp_ELEMENT_RECEIVED_DATE = "receive_date";
    public static String TABLE_HiDr_UserApp_ELEMENT_SUBJECT = "subject";
    public static String TABLE_HiDr_UserApp_ELEMENT_QUESTION = "question";
    public static String TABLE_HiDr_UserApp_ELEMENT_ANSWER = "answer";
    public static String TABLE_HiDr_UserApp_ELEMENT_FLAG_NEW_ANSWERED = "flag_new_answered";
    public static String TABLE_HiDr_UserApp_ELEMENT_RESERVE1 = "reserve1";
    public static String TABLE_HiDr_UserApp_ELEMENT_RESERVE2 = "reserve2";
    public static String TABLE_HiDr_UserApp_ELEMENT_RESERVE3 = "reserve3";
    public static String TABLE_HiDr_UserApp_ELEMENT_RESERVE4 = "reserve4";
    public static String TABLE_HiDr_UserApp_ELEMENT_RESERVE5 = "reserve5";





    public static String CREATE_HI_DOCTOR_USER_APP_TABLE = "create table " + TABLE_INFO_HiDoctor_UserApp + " ("
            + COLUMN_ID + " integer primary key, "
            + TABLE_HiDr_UserApp_ELEMENT_SEND_DATE + " TEXT, "
            + TABLE_HiDr_UserApp_ELEMENT_RECEIVED_DATE + " TEXT, "
            + TABLE_HiDr_UserApp_ELEMENT_SUBJECT + " TEXT, "
            + TABLE_HiDr_UserApp_ELEMENT_QUESTION + " TEXT, "
            + TABLE_HiDr_UserApp_ELEMENT_ANSWER + " TEXT, "
            + TABLE_HiDr_UserApp_ELEMENT_FLAG_NEW_ANSWERED + " TEXT, "
            + TABLE_HiDr_UserApp_ELEMENT_RESERVE1 + " TEXT, "
            + TABLE_HiDr_UserApp_ELEMENT_RESERVE2 + " TEXT, "
            + TABLE_HiDr_UserApp_ELEMENT_RESERVE3 + " TEXT, "
            + TABLE_HiDr_UserApp_ELEMENT_RESERVE4 + " TEXT, "
            + TABLE_HiDr_UserApp_ELEMENT_RESERVE5 + " TEXT);";



//------------------------------------------------------------------------------------------------//

    //----------------------------- database HiDOctor_SERVER ----------------------------------------//

    public static String TABLE_INFO_HiDoctor_Server = "HiDr_Server_table";

    public static String TABLE_HiDr_Server_ELEMENT_SEND_DATE = "send_date";
    public static String TABLE_HiDr_Server_ELEMENT_RECEIVED_DATE = "receive_date";
    public static String TABLE_HiDr_Server_ELEMENT_SUBJECT = "subject";
    public static String TABLE_HiDr_Server_ELEMENT_QUESTION = "question";
    public static String TABLE_HiDr_Server_ELEMENT_ANSWER = "answer";
    public static String TABLE_HiDr_Server_ELEMENT_FLAG_NEW_ANSWERED = "flag_new_answered";
    public static String TABLE_HiDr_Server_ELEMENT_RESERVE1 = "reserve1";
    public static String TABLE_HiDr_Server_ELEMENT_RESERVE2 = "reserve2";
    public static String TABLE_HiDr_Server_ELEMENT_RESERVE3 = "reserve3";
    public static String TABLE_HiDr_Server_ELEMENT_RESERVE4 = "reserve4";
    public static String TABLE_HiDr_Server_ELEMENT_RESERVE5 = "reserve5";




    public static String CREATE_HI_DOCTOR_Server_TABLE = "create table " + TABLE_INFO_HiDoctor_Server + " ("
            + COLUMN_ID + " integer primary key, "
            + TABLE_HiDr_Server_ELEMENT_SEND_DATE + " TEXT, "
            + TABLE_HiDr_Server_ELEMENT_RECEIVED_DATE + " TEXT, "
            + TABLE_HiDr_Server_ELEMENT_SUBJECT + " TEXT, "
            + TABLE_HiDr_Server_ELEMENT_QUESTION + " TEXT, "
            + TABLE_HiDr_Server_ELEMENT_ANSWER + " TEXT, "
            + TABLE_HiDr_Server_ELEMENT_FLAG_NEW_ANSWERED + " TEXT, "
            + TABLE_HiDr_Server_ELEMENT_RESERVE1 + " TEXT, "
            + TABLE_HiDr_Server_ELEMENT_RESERVE2 + " TEXT, "
            + TABLE_HiDr_Server_ELEMENT_RESERVE3 + " TEXT, "
            + TABLE_HiDr_Server_ELEMENT_RESERVE4 + " TEXT, "
            + TABLE_HiDr_Server_ELEMENT_RESERVE5 + " TEXT);";



//------------------------------------------------------------------------------------------------//



    //----------------------------- database MyDoctor_Information of all doctor ----------------------------------------//

    public static String TABLE_INFO_MyDoctor_Info_All_Dr = "All_dr_info";

    public static String TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_ID_DR = "id_doctor";
    public static String TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_NAME = "name";
    public static String TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_FAMILY = "family";
    public static String TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_FIELD = "field";
    public static String TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_IMAGE_ADD = "address_image";
    public static String TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESUME_ADD = "address_resume";
    public static String TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_JSON_ADD = "address_json";
    public static String TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE1 = "reserve1_Info_All_Dr";
    public static String TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE2 = "reserve2_Info_All_Dr";
    public static String TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE3 = "reserve3_Info_All_Dr";
    public static String TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE4 = "reserve4_Info_All_Dr";






    public static String CREATE_MyDoctor_Info_All_Dr_Table = "create table " + TABLE_INFO_MyDoctor_Info_All_Dr + " ("
            + COLUMN_ID + " integer primary key, "
            + TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_ID_DR + " TEXT, "
            + TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_NAME + " TEXT, "
            + TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_FAMILY + " TEXT, "
            + TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_FIELD + " TEXT, "
            + TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_IMAGE_ADD + " TEXT, "
            + TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESUME_ADD + " TEXT, "
            + TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_JSON_ADD + " TEXT, "
            + TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE1 + " TEXT, "
            + TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE2 + " TEXT, "
            + TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE3 + " TEXT, "
            + TABLE_INFO_MyDoctor_Info_All_Dr_ELEMENT_RESERVE4 + " TEXT);";


//------------------------------------------------------------------------------------------------//

    //----------------------------- database MyDoctor information of registered doctor ----------------------------------------//

    public static String TABLE_INFO_MyDoctor_Info_Registered_Dr = "Registered_dr";

    public static String TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_ID_DR = "id_doctor";
    public static String TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_ACCESS_LEVEL = "access_level";
    public static String TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE1 = "reserve1_Info_Registered_Dr";
    public static String TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE2 = "reserve2_Info_Registered_Dr";
    public static String TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE3 = "reserve3_Info_Registered_Dr";
    public static String TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE4 = "reserve4_Info_Registered_Dr";
    public static String TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE5 = "reserve5_Info_Registered_Dr";
    public static String TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE6 = "reserve6_Info_Registered_Dr";
    public static String TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE7 = "reserve7_Info_Registered_Dr";
    public static String TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE8 = "reserve8_Info_Registered_Dr";
    public static String TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE9 = "reserve9_Info_Registered_Dr";



    public static String CREATE_MyDoctor_Info_Registered_Dr_Table = "create table " + TABLE_INFO_MyDoctor_Info_Registered_Dr + " ("
            + COLUMN_ID + " integer primary key, "
            + TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_ID_DR + " TEXT, "
            + TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_ACCESS_LEVEL + " TEXT, "
            + TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE1 + " TEXT, "
            + TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE2 + " TEXT, "
            + TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE3 + " TEXT, "
            + TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE4 + " TEXT, "
            + TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE5 + " TEXT, "
            + TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE6 + " TEXT, "
            + TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE7 + " TEXT, "
            + TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE8 + " TEXT, "
            + TABLE_MyDoctor_Info_Registered_Dr_ELEMENT_RESERVE9 + " TEXT);";



//------------------------------------------------------------------------------------------------//







}  /// THE END