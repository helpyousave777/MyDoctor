package com.example.saeed_pc.mydoctor.Main_MyDr.GCM.manger;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.saeed_pc.mydoctor.Main.MainActivity;
import com.example.saeed_pc.mydoctor.test.InternetTest.MainNetTest;

import java.io.BufferedInputStream;
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
public class MyWebPageDownloader extends AsyncTask<String, String, String> {

    private final NetworkFunction network;
    private ProgressDialog progress;
    private Context context;
    private String result;

    public MyWebPageDownloader(Context context) {

        Log.i("===>","MyWebPageDownloader.1");
        this.context = context;
        network = new NetworkFunction (context);
        Log.i("===>","MyWebPageDownloader.2");
    }

    /* this function run during starting doInBackground until starting onPostExecute */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.i("===>","MyWebPageDownloader.onPreExecute.1");
        progress = ProgressDialog.show(context, "Loading Message List", "Please wait...", true, false);
        Log.i("===>","MyWebPageDownloader.onPreExecute.2");
    }


    @Override
    protected String doInBackground(String... params) {

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

            if(network.validURL(connection)) {
            /* read data in stream position and write into buffer */
                Log.i("===>", "MyWebPageDownloader.doInBackground.5");
                InputStream inputStream = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader buffer = new BufferedReader(reader);
                /*********************************************************/
                Log.i("===>", "MyWebPageDownloader.doInBackground.6 buffer: " + buffer);

           /* read buffer line by line and write into output for shown in onPostExecute */
                String temp = "";
                while ((temp = buffer.readLine()) != null) {
                    result += temp;
                }
                /*****************************************************************************/

            }else{
                /* any command in the function cant be shown in context */
                // we use onProgressUpdate via call publishProgress() ( input for publishProgress() is input for onProgressUpdate )
                publishProgress();
            }
            Log.i("===>","MyWebPageDownloader.doInBackground.7 result: " + result);

        } catch (MalformedURLException e) {
            Log.i("===>","MyWebPageDownloader.doInBackground.7.exception1: " + result);
            e.printStackTrace();
                    } catch (IOException e) {
            Log.i("===>","MyWebPageDownloader.doInBackground.7.exception2 " + result);
            e.printStackTrace();
        }
        Log.i("===>","MyWebPageDownloader.doInBackground.8");
        return result;
    }


    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        Toast.makeText(context, "Invalid URL", Toast.LENGTH_LONG).show();
    }

    /* every command in the function can be shown in context */
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.i("===>","MyWebPageDownloader.onPostExecute.1");
        MainNetTest.pageContent.setText(result);
        Log.i("===>","MyWebPageDownloader.onPostExecute.2");
        progress.dismiss();
        Log.i("===>","MyWebPageDownloader.onPostExecute.3");
    }
}
