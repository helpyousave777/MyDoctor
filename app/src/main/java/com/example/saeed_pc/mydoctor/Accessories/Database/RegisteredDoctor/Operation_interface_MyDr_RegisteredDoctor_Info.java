package com.example.saeed_pc.mydoctor.Accessories.Database.RegisteredDoctor;

import com.example.saeed_pc.mydoctor.Accessories.Database.RegisteredDoctor.Info.Info_Registered_Doctor_Information;

import java.util.List;

/**
 * Created by ici80071 on 4/12/2016.
 */
public interface Operation_interface_MyDr_RegisteredDoctor_Info {

    void add_MyDr_db_MyDr_RegisteredDoctor_Info(Info_Registered_Doctor_Information info);

    void add_MyDr_db_MyDr_RegisteredDoctor_Info(Info_Registered_Doctor_Information info, int id);

    void update_MyDr_db_MyDr_RegisteredDoctor_Info(Info_Registered_Doctor_Information info);
    void update_MyDr_db_MyDr_RegisteredDoctor_Info(int id);
    void update_MyDr_db_MyDr_RegisteredDoctor_Info(Info_Registered_Doctor_Information info,int id);

    void delete_MyDr_db_MyDr_RegisteredDoctor_Info(Info_Registered_Doctor_Information info);


    void delete_MyDr_db_MyDr_RegisteredDoctor_Info(int id);
    void delete_MyDr_db_MyDr_RegisteredDoctor_Info(Info_Registered_Doctor_Information info,int id);

    void deleteAll_MyDr_db_MyDr_RegisteredDoctor_Info();

    List<Info_Registered_Doctor_Information> getRegistered_MyDr_db_MyDr_AllDoctor_Info();

    List<Info_Registered_Doctor_Information> query_MyDr_db_MyDr_RegisteredDoctor_Info(Info_Registered_Doctor_Information info);
}
