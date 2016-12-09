package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.SelectContact.Data;

/**
 * Created by ici80071 on 4/13/2016.
 */
public class Data_SelectDr_HiDr {
    public String title;
    public String description;
    public int imageId;

    public Data_SelectDr_HiDr(String title, String description, int imageId) {
        this.title = title;
        this.description = description;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
