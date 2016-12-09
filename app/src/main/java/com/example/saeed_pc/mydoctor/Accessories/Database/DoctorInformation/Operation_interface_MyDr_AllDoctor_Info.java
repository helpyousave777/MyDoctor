package com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation;

import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Info.Info_All_Doctor_Information;

import java.util.List;

/**
 * Created by ici80071 on 4/11/2016.
 */
public interface Operation_interface_MyDr_AllDoctor_Info {

    void add_MyDr_db_MyDr_AllDoctor_Info(Info_All_Doctor_Information info);

    void add_MyDr_db_MyDr_AllDoctor_Info(Info_All_Doctor_Information info, int id);

    void update_MyDr_db_MyDr_AllDoctor_Info(Info_All_Doctor_Information info);
    void update_MyDr_db_MyDr_AllDoctor_Info(int id);
    void update_MyDr_db_MyDr_AllDoctor_Info(Info_All_Doctor_Information info,int id);

    void delete_MyDr_db_MyDr_AllDoctor_Info(Info_All_Doctor_Information info);


    void delete_MyDr_db_MyDr_AllDoctor_Info(int id);
    void delete_MyDr_db_MyDr_AllDoctor_Info(Info_All_Doctor_Information info,int id);

    void deleteAll_MyDr_db_MyDr_AllDoctor_Info();

    Info_All_Doctor_Information query_db_MyDr_AllDoctor(String id_doctor);



    List<Info_All_Doctor_Information> getAll_MyDr_db_MyDr_AllDoctor_Info();

    List<Info_All_Doctor_Information> query_MyDr_db_MyDr_AllDoctor_Info(Info_All_Doctor_Information info);
}
