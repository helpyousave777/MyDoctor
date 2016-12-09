package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.thread_listView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDoctorFragment;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.listViewOperation_HiDr;

/**
 * Created by ici80481 on 11/30/2015.
 */
public class Thread_ListView_HiDr extends AsyncTask<String,String,String> {


    private Context context;
    private ProgressDialog progress;
    private listViewOperation_HiDr listViewOp_hiDr;


    public Thread_ListView_HiDr( Context context ) {

        this.context=context;
        listViewOp_hiDr = new listViewOperation_HiDr(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progress = ProgressDialog.show(context, "Loading Message List", "Please wait...", true, false);
    }

    @Override
    protected String doInBackground(String... params) {


        Log.i("===>", "doInBackground1");
        //listViewOp_hiDr.advancedListView(HiDoctorFragment.listView_HiDr);
        listViewOp_hiDr.advancedRecyclerView(HiDoctorFragment.recycler_HiDr);
        Log.i("===>", "doInBackground2");
        return "OK" ;
    }



    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        progress.dismiss();
    }
}

