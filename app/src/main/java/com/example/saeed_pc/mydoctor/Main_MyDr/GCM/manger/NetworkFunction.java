package com.example.saeed_pc.mydoctor.Main_MyDr.GCM.manger;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.saeed_pc.mydoctor.Main.MainActivity;
import com.example.saeed_pc.mydoctor.Main_MyDr.GCM.MainGCMTest;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by saeed on 30/07/2016.
 */
public class NetworkFunction {

    private Context context;

    public NetworkFunction(Context context) {
        this.context = context;
    }

    public boolean isNetworkReady(){

        ConnectivityManager  manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if ((networkInfo != null)&& (networkInfo.isConnected())){
            MainActivity.flag_ready_network = true;

        }else {
            MainActivity.flag_ready_network = false;
        }

        return MainActivity.flag_ready_network;
    }

    public boolean validURL (HttpURLConnection connection) throws IOException {
        boolean flag_validity = true;

        int responseCode = connection.getResponseCode();
        if (responseCode  != 200 ){
            flag_validity = false;
        }

        return flag_validity;
    }


}
