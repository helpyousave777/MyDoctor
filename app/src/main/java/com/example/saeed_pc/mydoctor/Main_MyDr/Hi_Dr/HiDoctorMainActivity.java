package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.dialog.dialog;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.thread_listView.Thread_ListView_HiDr;
import com.example.saeed_pc.mydoctor.R;

public class HiDoctorMainActivity extends AppCompatActivity {

    public static RecyclerView recycler_HiDr;
    private dialog dialog;
    public static SharedPreferences preferences_add_HiDr;
   // private listViewOperation_HiDr listViewOp_hiDr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hi_doctor_main);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // Inflate menu to add items to action bar if it is present.
        inflater.inflate(R.menu.menu_hi_doctor_main, menu);
        // Associate searchable configuration with the SearchView
       SearchManager searchManager =
               (SearchManager) getSystemService(Context.SEARCH_SERVICE);
     SearchView searchView =
             (SearchView) menu.findItem(R.id.action_HiDr_Search).getActionView();
        SearchableInfo info =
                searchManager.getSearchableInfo(getComponentName());
        Log.i("===>", "SearchableInfo  " + info.getSuggestSelection());
        Log.i("===>", "SearchableInfo  " + info.getHintId());
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getComponentName());
        try {
            Log.i("===>", "SearchableInfo1  " + info.getHintId());
            searchView.setSearchableInfo(searchableInfo);
            Log.i("===>", "SearchableInfo2  " + info.getHintId());
        }catch(Exception e){
            Log.i("===>", "SearchableInfo3  " + info.getHintId());

        }

        return true;
    }



    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("===>", "onResume HiDr1");
        new Thread_ListView_HiDr(this).execute();
       // listViewOp_hiDr.advancedListView(listView_HiDr);
        Log.i("===>", "onResume HiDr2");

    }

    private void init() {
        Log.i("===>", "HiDr init1");
     // ActionBar actionBar=getSupportActionBar();
     // actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1E90FF")));
        recycler_HiDr = (RecyclerView) findViewById(R.id.RecyclerView_HiDr);


        dialog = new dialog(this);
       // listViewOp_hiDr = new listViewOperation_HiDr(this);

        preferences_add_HiDr = getSharedPreferences("key_shared_MyDoctor_add_send_date",MODE_PRIVATE);
        preferences_add_HiDr = getSharedPreferences("key_shared_MyDoctor_add_receive_date",MODE_PRIVATE);
        preferences_add_HiDr = getSharedPreferences("key_shared_MyDoctor_add_subject",MODE_PRIVATE);
        preferences_add_HiDr = getSharedPreferences("key_shared_MyDoctor_add_question",MODE_PRIVATE);
        preferences_add_HiDr = getSharedPreferences("key_shared_MyDoctor_add_answer",MODE_PRIVATE);
        preferences_add_HiDr = getSharedPreferences("key_shared_MyDoctor_add_flag_new_answered",MODE_PRIVATE);
        preferences_add_HiDr = getSharedPreferences("key_shared_MyDoctor_add_reservation1",MODE_PRIVATE);
        preferences_add_HiDr = getSharedPreferences("key_shared_MyDoctor_add_reservation2",MODE_PRIVATE);
        preferences_add_HiDr = getSharedPreferences("key_shared_MyDoctor_add_reservation3",MODE_PRIVATE);
        preferences_add_HiDr = getSharedPreferences("key_shared_MyDoctor_add_reservation4",MODE_PRIVATE);
        preferences_add_HiDr = getSharedPreferences("key_shared_MyDoctor_add_reservation5",MODE_PRIVATE);
        Log.i("===>", "HiDr init4");


    }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

      Log.i("===>", "HiDr option1");
      int id = item.getItemId();
      switch (id){
          case R.id.action_HiDr_newMessage:
              Log.i("===>", "HiDr option2");
            //  dialog.newMessage();
              Log.i("===>", "HiDr option3");
              break;
          case R.id.action_HiDr_Search:
              break;
      }



       return super.onOptionsItemSelected(item);
   }


}
