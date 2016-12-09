package com.example.saeed_pc.mydoctor.Main_MyDr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Info.Info_All_Doctor_Information;
import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Operation_MyDr_AllDoctor_Info;
import com.example.saeed_pc.mydoctor.Accessories.constValue_General.constValue_General;
import com.example.saeed_pc.mydoctor.Main.LoginRegister.Login.LoginActivity;
import com.example.saeed_pc.mydoctor.Main.LoginRegister.Register.RegisterActivity;
import com.example.saeed_pc.mydoctor.Main.MainActivity;
import com.example.saeed_pc.mydoctor.Main.Splash.Splash;
import com.example.saeed_pc.mydoctor.Main_MyDr.Design.SmartViewPager.MyPagerAdapter_Smart_main_MyDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.Design.activity_Design.FragmentDrawer_main_MyDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.Design.model_Design.NavDrawerItem_Design_main_MyDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDoctorFragment;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.dialog.dialog;
import com.example.saeed_pc.mydoctor.OnTabSwipable.SmartViewPager.MyPagerAdapter_Smart;
import com.example.saeed_pc.mydoctor.OnTabSwipable.TabLayoutSwipeable.adapter.NavDrawerListAdapter;
import com.example.saeed_pc.mydoctor.OnTabSwipable.TabLayoutSwipeable.model.NavDrawerItem;
import com.example.saeed_pc.mydoctor.OnTabSwipable.materialDesign.FragmentDrawer;
import com.example.saeed_pc.mydoctor.OnTabSwipable.materialDesign.HomeFragment;
import com.example.saeed_pc.mydoctor.R;

import java.util.ArrayList;
import java.util.List;

public class MainMyDr extends AppCompatActivity implements FragmentDrawer_main_MyDr.FragmentDrawerListener {

    public static int flag_current_pos = constValue_General.MyDr_HiDr;
    public static int flag_question_pos = constValue_General.HyDr_ShowMessage;

    private Toolbar mToolbar;
    private FragmentDrawer_main_MyDr drawerFragment;
    private Toolbar toolbar;


    private MyPagerAdapter_Smart_main_MyDr adapterViewPager;
    private TabLayout tabLayout;
    private dialog dialog;
    public static SharedPreferences preferences_add_HiDr;

    private MenuItem mSearchAction;
    private boolean isSearchOpened = false;
    private EditText edtSeach;

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    // nav drawer title
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    private ArrayList<NavDrawerItem_Design_main_MyDr> navDrawerItems;
    private   ViewPager viewPager;
    // private NavDrawerListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("===>", "onCreate.1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_my_dr);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_Main_MyDr);
        setSupportActionBar(toolbar);
        toolbar.setTitle("My Dr");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Log.i("===>", "onCreate.1.2");

        drawerFragment = (FragmentDrawer_main_MyDr)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer_Main_MyDr);
        Log.i("===>","onCreate.1.3");
        drawerFragment.setUp(R.id.fragment_navigation_drawer_Main_MyDr, (DrawerLayout) findViewById(R.id.drawer_layout_Main_MyDr), toolbar);
        Log.i("===>", "onCreate.1.4");
        drawerFragment.setDrawerListener(this);
        Log.i("===>", "onCreate.1.5");
        // display the first navigation drawer view on app launch
       // displayView(0);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        viewPager = (ViewPager) findViewById(R.id.viewpager_Main_MyDr);
        Log.i("===>","onCreate.2");
        adapterViewPager = new MyPagerAdapter_Smart_main_MyDr(getSupportFragmentManager());
        Log.i("===>","onCreate.3");
        viewPager.setAdapter(adapterViewPager);
        Log.i("===>", "onCreate.4");

        // Give the TabLayout the ViewPager
        tabLayout = (TabLayout) findViewById(R.id.tabs_Main_MyDr);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        Log.i("===>", "onCreate.5");

        // attach listener on view pager
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        Log.i("===>", "onCreate.6");
        // attach listener on Tab layout
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        init();
        Operation_MyDr_AllDoctor_Info allDoctor_DB = new Operation_MyDr_AllDoctor_Info(this);
        List<Info_All_Doctor_Information> list = allDoctor_DB.getAll_MyDr_db_MyDr_AllDoctor_Info();
        if(list.size() != 0) {
            Log.i("===>", "onCreate.6.9 list size " + list.size());
            Log.i("===>", "onCreate.6.9 list " + list.get(0).getName());
            Log.i("===>", "onCreate.6.9 list " + list.get(1).getName());
            Log.i("===>", "onCreate.6.9 list " + list.get(2).getName());
            Log.i("===>", "onCreate.6.9 list " + list.get(3).getName());
            Log.i("===>", "onCreate.7");
        }
    }


    private void setupTabIcons() {

        Log.i("===>","setupTabIcons.1");

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Calendar");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.calendar, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Hi Dr");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.hi_doctor, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Dr Resume");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.advertisement_2, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
        Log.i("===>", "setupTabIcons.2");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_my_dr, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.i("===>","onOptionsItemSelected.1 id:"+id);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == R.id.action_search){
            Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

        Log.i("===>", "onDrawerItemSelected.1 position:" + position);
        displayView(position);
        Log.i("===>", "onDrawerItemSelected.2 position:" + position);

    }

    private void displayView(int position) {

        // drawer labels
        if(Splash.preferences_flag.getBoolean("flag_shared_splashStatus", false)){

            switch (position){
                case 0:
                    Splash.preferences_flag.edit().putBoolean("flag_shared_splashStatus", false).commit();
                    startActivity(new Intent(MainMyDr.this, LoginActivity.class));
                    finish();
                    break;
                case 1:
                    //startActivity(new Intent(MainMyDr.this, SettingActivity.class));
                    //finish();
                    break;
                default:
                    break;
            }
        }else{
            switch (position){
                case 0:
                    startActivity(new Intent(MainMyDr.this, LoginActivity.class));
                    finish();
                    break;
                case 1:
                    startActivity(new Intent(MainMyDr.this, RegisterActivity.class));
                    finish();
                    break;
                case 2:
                    //startActivity(new Intent(MainMyDr.this, SettingActivity.class));
                    //finish();
                    break;
                default:
                    break;
            }
        }
    }

    private void init() {
        Log.i("===>", "My Dr init1");

      //  dialog = new dialog(this);
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
        Log.i("===>", "My Dr init4");

        switch (flag_current_pos){
            case constValue_General.MyDr_Reservation :
                break;
            case constValue_General.MyDr_HiDr :
                viewPager.setCurrentItem(constValue_General.MyDr_HiDr);
                break;
            case constValue_General.MyDr_DrResume :
                break;
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}