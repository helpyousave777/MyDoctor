package com.example.saeed_pc.mydoctor.Main_MyDr.Design.model_Design;

/**
 * Created by SAEED-PC on 3/18/2016.
 */
public class NavDrawerItem_Design_main_MyDr {
    private boolean showNotify;
    private String title;


    public NavDrawerItem_Design_main_MyDr() {

    }

    public NavDrawerItem_Design_main_MyDr(boolean showNotify, String title) {
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