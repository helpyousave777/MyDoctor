package com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Info;

import java.io.Serializable;

/**
 * Created by ici80071 on 4/11/2016.
 */
public class Info_All_Doctor_Information implements Serializable {


    private int id ;

    private String id_doctor ;
    private String name ;
    private String family;
    private String field;
    private String address_image;
    private String address_resume;
    private String address_json;
    private String reserve1_Info_All_Dr;
    private String reserve2_Info_All_Dr;
    private String reserve3_Info_All_Dr;
    private String reserve4_Info_All_Dr;

    public int getId() {
        return id;
    }
    public String getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(String id_doctor) {
        this.id_doctor = id_doctor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getAddress_image() {
        return address_image;
    }

    public void setAddress_image(String address_image) {
        this.address_image = address_image;
    }

    public String getAddress_resume() {
        return address_resume;
    }

    public void setAddress_resume(String address_resume) {
        this.address_resume = address_resume;
    }


    public String getAddress_json() {
        return address_json;
    }

    public void setAddress_json(String address_json) {
        this.address_json = address_json;
    }

    public String getReserve1_Info_All_Dr() {
        return reserve1_Info_All_Dr;
    }

    public void setReserve1_Info_All_Dr(String reserve1_Info_All_Dr) {
        this.reserve1_Info_All_Dr = reserve1_Info_All_Dr;
    }

    public String getReserve2_Info_All_Dr() {
        return reserve2_Info_All_Dr;
    }

    public void setReserve2_Info_All_Dr(String reserve2_Info_All_Dr) {
        this.reserve2_Info_All_Dr = reserve2_Info_All_Dr;
    }

    public String getReserve3_Info_All_Dr() {
        return reserve3_Info_All_Dr;
    }

    public void setReserve3_Info_All_Dr(String reserve3_Info_All_Dr) {
        this.reserve3_Info_All_Dr = reserve3_Info_All_Dr;
    }

    public String getReserve4_Info_All_Dr() {
        return reserve4_Info_All_Dr;
    }

    public void setReserve4_Info_All_Dr(String reserve4_Info_All_Dr) {
        this.reserve4_Info_All_Dr = reserve4_Info_All_Dr;
    }
}
