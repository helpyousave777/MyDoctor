package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.date;

import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.Info_HiDoctor_UserApp;
import com.example.saeed_pc.mydoctor.Accessories.constValue_General.constValue_General;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ici80481 on 11/25/2015.
 */
public class date {

    public static String date_status(Info_HiDoctor_UserApp info){
        String st_date = "Sep 11";

        String date_current = getDate();
      //  Log.i("===>","date_status2 date_current"+date_current );
        String date_message = "0";

        String sendDate = info.getSendDate();
        String receiveDate = info.getReceiveDate();
        if(Integer.parseInt(receiveDate)==0){
            date_message =sendDate;
        }else{
            date_message=receiveDate;

        }
        st_date = compareTime_TimeStatus(date_current, date_message);


        return st_date;
    }

public static String getDate(){
    SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
    String time = format.format(new Date());
    time = time.replace("_", "");
    return time;
}

    public static String getDateOnly_Integer(){
        String DateOnly="0101" ;
        String date = getDate();
        char day_1 = date.charAt(6);
        char day_2 = date.charAt(7);
        char month_1 = date.charAt(4);
        char month_2 = date.charAt(5);


        DateOnly = ""+month_1+month_2+day_1+day_2;

        return DateOnly;
    }



    public static String getTimeOnly_Integer(){
        String TimeOnly="0000" ;

        String date = getDate();
        char min_1 = date.charAt(10);
        char min_2 = date.charAt(11);
        char hour_1 = date.charAt(8);
        char hour_2 = date.charAt(9);

        TimeOnly = ""+hour_1+hour_2+min_1+min_2;
        return TimeOnly;
    }

    public static String getTimeOnly_String(){
        String TimeOnly="0000" ;
        String timeOnly_integer = getTimeOnly_Integer();
        char min_1 = timeOnly_integer.charAt(2);
        char min_2 = timeOnly_integer.charAt(3);
        String min = ""+min_1+min_2;

        char hour_1 = timeOnly_integer.charAt(0);
        char hour_2 = timeOnly_integer.charAt(1);
        String hour = ""+hour_1+hour_2;

        TimeOnly=""+hour+":"+min;
        return TimeOnly;
    }

    public static String getDateOnly_String(){
        String DateOnly_String="0123" ;


        String dateOnly_integer = getDateOnly_Integer();

        char day_1 = dateOnly_integer.charAt(2);
        char day_2 = dateOnly_integer.charAt(3);
        String day = ""+day_1+day_2;

        char month_1 = dateOnly_integer.charAt(0);
        char month_2 = dateOnly_integer.charAt(1);
        String month = ""+month_1+month_2;

        int date = Integer.parseInt(month);

        switch (date){
            case constValue_General.JANUARY:
                month="Jan";
                break;
            case constValue_General.FEBRUARY:
                month="Feb";
                break;
            case constValue_General.MARCH:
                month="March";
                break;
            case constValue_General.APRIL:
                month="Apr";
                break;
            case constValue_General.MAY:
                month="May";
                break;
            case constValue_General.JUNE:
                month="Jun";
                break;
            case constValue_General.JULY:
                month="Jan";
                break;
            case constValue_General.AUGUST:
                month="Jan";
                break;
            case constValue_General.SEPTEMBER:
                month="Sep";
                break;
            case constValue_General.OCTOBER:
                month="Oct";
                break;
            case constValue_General.NOVEMBER:
                month="Nov";
                break;
            case constValue_General.DECEMBER:
                month="Dec";
                break;


        }

        DateOnly_String=""+month+" "+ day;

        return DateOnly_String;

    }



    //------  equation box ... not operating ...............----------------//

    public static String compareTime_TimeStatus(String date_current, String date_message){
        String time_status = "Sep 11";


        String Date_only_Current = getEspecialDate(date_current);
        String Date_only_Message = getEspecialDate(date_message);
       // Log.i("===>","Date_only_Current: "+Date_only_Current+" Date_only_Message: "+Date_only_Message);

        String date_only = getDateOnly_Integer_eq(date_message);
        String date = getDateOnly_String_eq(date_only);

        String time_only = getTimeOnly_Integer_eq(date_message);
        String time = getTimeOnly_String_eq(time_only);


        if(Integer.parseInt(Date_only_Current) == Integer.parseInt(Date_only_Message)){
            time_status=time;
        //    Log.i("===>","time_status + same day: "+time_status);
        }else {
            time_status=date;
         //   Log.i("===>","time_status + other day: "+time_status);

        }


        return time_status;
    }

    private static String getEspecialDate(String date){
        String esp_date="";

        char esp_date_1 = date.charAt(7);
        char esp_date_2 = date.charAt(6);
        char esp_date_3 = date.charAt(5);
        char esp_date_4 = date.charAt(4);
        char esp_date_5 = date.charAt(3);
        char esp_date_6 = date.charAt(2);
        char esp_date_7 = date.charAt(1);
        char esp_date_8 = date.charAt(0);

        esp_date=""+esp_date_1+esp_date_2+esp_date_3+esp_date_4+esp_date_5+esp_date_6+esp_date_7+esp_date_8;
        return esp_date;
    }


    public static String getDateOnly_Integer_eq(String date){
        String DateOnly="0101" ;
        char day_1 = date.charAt(6);
        char day_2 = date.charAt(7);
        char month_1 = date.charAt(4);
        char month_2 = date.charAt(5);


        DateOnly = ""+month_1+month_2+day_1+day_2;

        return DateOnly;
    }



    public static String getTimeOnly_Integer_eq(String date){
        String TimeOnly="0000" ;

        char min_1 = date.charAt(10);
        char min_2 = date.charAt(11);
        char hour_1 = date.charAt(8);
        char hour_2 = date.charAt(9);

        TimeOnly = ""+hour_1+hour_2+min_1+min_2;
        return TimeOnly;
    }

    public static String getTimeOnly_String_eq(String time){
        String TimeOnly="0000" ;
        char min_1 = time.charAt(2);
        char min_2 = time.charAt(3);
        String min = ""+min_1+min_2;

        char hour_1 = time.charAt(0);
        char hour_2 = time.charAt(1);
        String hour = ""+hour_1+hour_2;

        TimeOnly=""+hour+":"+min;
        return TimeOnly;
    }

    public static String getDateOnly_String_eq(String date_only){
        String DateOnly_String="0123" ;



        char day_1 = date_only.charAt(2);
        char day_2 = date_only.charAt(3);
        String day = ""+day_1+day_2;

        char month_1 = date_only.charAt(0);
        char month_2 = date_only.charAt(1);
        String month = ""+month_1+month_2;

        int date = Integer.parseInt(month);

        switch (date){
            case constValue_General.JANUARY:
                month="Jan";
                break;
            case constValue_General.FEBRUARY:
                month="Feb";
                break;
            case constValue_General.MARCH:
                month="March";
                break;
            case constValue_General.APRIL:
                month="Apr";
                break;
            case constValue_General.MAY:
                month="May";
                break;
            case constValue_General.JUNE:
                month="Jun";
                break;
            case constValue_General.JULY:
                month="Jan";
                break;
            case constValue_General.AUGUST:
                month="Jan";
                break;
            case constValue_General.SEPTEMBER:
                month="Sep";
                break;
            case constValue_General.OCTOBER:
                month="Oct";
                break;
            case constValue_General.NOVEMBER:
                month="Nov";
                break;
            case constValue_General.DECEMBER:
                month="Dec";
                break;


        }

        DateOnly_String=""+month+" "+ day;

        return DateOnly_String;

    }
    //---------------------------------------------------------------------//
}
