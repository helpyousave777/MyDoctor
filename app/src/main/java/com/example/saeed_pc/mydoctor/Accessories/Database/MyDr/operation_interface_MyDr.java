package com.example.saeed_pc.mydoctor.Accessories.Database.MyDr;

import java.util.List;

/**
 * Created by SAEED-PC on 10/1/2015.
 */
public interface operation_interface_MyDr {

    void add_Registration_db_MyDr(Info_registration_MyDr info_registration_myDr);

    void add_Registration_db_MyDr(Info_registration_MyDr info_registration_myDr, int id);

    void update_Registration_db_MyDr(Info_registration_MyDr info_registration_myDr);
    void update_Registration_db_MyDr(int id);
    void update_Registration_db_MyDr(Info_registration_MyDr info_registration_myDr,int id);

    void delete_Registration_db_MyDr(Info_registration_MyDr info_registration_myDr);
    void delete_Registration_db_MyDr(int id);
    void delete_Registration_db_MyDr(Info_registration_MyDr info_registration_myDr,int id);

    void deleteAll_Registration_db_MyDr();

    List<Info_registration_MyDr> getAll_Registration_db_MyDr();

    List<Info_registration_MyDr> query_Registration_db_MyDr(Info_registration_MyDr info_registration_myDr);


}
