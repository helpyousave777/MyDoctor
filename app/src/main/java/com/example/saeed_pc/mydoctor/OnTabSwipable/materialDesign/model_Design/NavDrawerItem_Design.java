package com.example.saeed_pc.mydoctor.OnTabSwipable.materialDesign.model_Design;

/**
 * Created by SAEED-PC on 3/18/2016.
 */
public class NavDrawerItem_Design {
    private boolean showNotify;
    private String title;


    public NavDrawerItem_Design() {

    }

    public NavDrawerItem_Design(boolean showNotify, String title) {
        this.showNotify = showNotify;
        this.title = title;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}