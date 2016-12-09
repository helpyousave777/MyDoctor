package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView;

import java.util.Comparator;

/**
 * Created by ici80481 on 11/28/2015.
 */
public class compare_date implements Comparator<Info_HiDoctor_UserApp> {



        @Override
        public int compare(Info_HiDoctor_UserApp e1, Info_HiDoctor_UserApp e2) {

            long e1_date;
            long e1_sendDate = Long.parseLong(e1.getSendDate());
            long e1_receiveDate = Long.parseLong(e1.getReceiveDate());

            long e2_date;
            long e2_sendDate = Long.parseLong(e2.getSendDate());
            long e2_receiveDate = Long.parseLong(e2.getReceiveDate());

            if(e1_sendDate > e1_receiveDate){
                e1_date = e1_sendDate;
            }else{
                e1_date = e1_receiveDate;
            }

            if(e2_sendDate > e2_receiveDate){
                e2_date = e2_sendDate;
            }else{
                e2_date = e2_receiveDate;
            }

            try {

                if(e1_date < e2_date){
                    return 1;
                } else {
                    return -1;
                }
            }catch (Exception e){

            }
            return 0;
        }


}
