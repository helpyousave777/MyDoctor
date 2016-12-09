package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.Database_HiDr;

import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.Info_HiDoctor_UserApp;

import java.util.List;

/**
 * Created by SAEED-PC on 11/22/2015.
 */
public interface Operation_interface_HiDr {

    void add_HiDr_db_MyDr(Info_HiDoctor_UserApp info);

    void add_HiDr_db_MyDr(Info_HiDoctor_UserApp info, int id);

    void update_HiDr_db_MyDr(Info_HiDoctor_UserApp info);
    void update_HiDr_db_MyDr(int id);
    void update_HiDr_db_MyDr(Info_HiDoctor_UserApp info,int id);

    void delete_HiDr_db_MyDr(Info_HiDoctor_UserApp info);


    void delete_HiDr_db_MyDr(int id);
    void delete_HiDr_db_MyDr(Info_HiDoctor_UserApp info,int id);

    void deleteAll_HiDr_db_MyDr();

    List<Info_HiDoctor_UserApp> getAll_HiDr_db_MyDr();

    List<Info_HiDoctor_UserApp> query_HiDr_db_MyDr(Info_HiDoctor_UserApp info);
}
