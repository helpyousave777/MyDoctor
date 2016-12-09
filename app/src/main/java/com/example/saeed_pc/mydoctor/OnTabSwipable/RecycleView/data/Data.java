package com.example.saeed_pc.mydoctor.OnTabSwipable.RecycleView.data;

/**
 * Created by SAEED-PC on 3/19/2016.
 */
public class Data {
    public String title;
    public String description;
    public int imageId;

    public Data(String title, String description, int imageId) {
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
