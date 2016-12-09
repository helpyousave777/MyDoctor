package com.example.saeed_pc.mydoctor.Main_MyDr.GCM.manger;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.example.saeed_pc.mydoctor.test.InternetTest.MainNetTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by saeed on 30/07/2016.
 */
public class MyImageDownloader extends AsyncTask<String, String, Bitmap> {

    private ProgressDialog progress;
    private Context context;
    private Bitmap result;

    public MyImageDownloader(Context context) {
        this.context = context;
    }

    /* this function run during starting doInBackground until starting onPostExecute */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.i("===>","MyWebPageDownloader.onPreExecute.1");
        progress = ProgressDialog.show(context, "Loading Image", "Please wait...", true, false);
        Log.i("===>","MyWebPageDownloader.onPreExecute.2");
    }

    /* every command in the function can be shown in context */
    @Override
    protected Bitmap doInBackground(String... params) {

        Bitmap bitmap =null;
        Log.i("===>","MyWebPageDownloader.doInBackground.1");
        // get URL from input parameter of doInBackground
        try {
            Log.i("===>","MyWebPageDownloader.doInBackground.2");
            URL url = new URL(params[0]);

            Log.i("===>","MyWebPageDownloader.doInBackground.3 url:"+ url);
            // open Connection for communication with Http Server
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Log.i("===>","MyWebPageDownloader.doInBackground.4 connection:"+ connection);
            // now connection is ready

            /* read data in stream position and write into buffer */
            Log.i("===>","MyWebPageDownloader.doInBackground.5");
            InputStream inputStream = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            /*********************************************************/

            /*****************************************************************************/


        } catch (MalformedURLException e) {
            Log.i("===>","MyWebPageDownloader.doInBackground.7.exception1: " + result);
            e.printStackTrace();
        } catch (IOException e) {
            Log.i("===>","MyWebPageDownloader.doInBackground.7.exception2 " + result);
            e.printStackTrace();
        }
        Log.i("===>","MyWebPageDownloader.doInBackground.8");
        return bitmap;
    }



    /* every command in the function can be shown in context */
    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        Log.i("===>","MyWebPageDownloader.onPostExecute.1");
        MainNetTest.ButtnSearch.setImageBitmap(result);
        Log.i("===>","MyWebPageDownloader.onPostExecute.2");
        progress.dismiss();
        Log.i("===>","MyWebPageDownloader.onPostExecute.3");
    }
}
