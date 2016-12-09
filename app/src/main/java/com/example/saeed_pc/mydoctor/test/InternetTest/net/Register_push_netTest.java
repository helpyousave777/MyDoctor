package com.example.saeed_pc.mydoctor.test.InternetTest.net;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by saeed on 05/08/2016.
 */
public class Register_push_netTest extends AsyncTask<String, String, String> {

    private Context context;

    public Register_push_netTest(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {


        String s = "";
        try {
            URL url = new URL("http://192.168.1.2/mySite/register.php?username="+params[0]+"&password="+params[1]+"&role="+params[2]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            s = reader.readLine();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
