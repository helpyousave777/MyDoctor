package com.example.saeed_pc.mydoctor.test.InternetTest.net;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by saeed on 05/08/2016.
 */
public class Login_push_netTest extends AsyncTask<String, String, String> {

    private Context context;

    public Login_push_netTest(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        String s = "";
        try {
            // GET
//                URL url = new URL("http://10.10.201.17/site/login.php?username=Mohammad&password=4456789");
            URL url = new URL("http://192.168.1.2/mySite/login.php");

            String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(params[0], "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8");
       //     data += "&" + URLEncoder.encode("role", "UTF-8") + "=" + URLEncoder.encode(params[2], "UTF-8");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true); // this is for post operation

            // Write To server
            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(data);
            writer.flush();

            // Read From server
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


