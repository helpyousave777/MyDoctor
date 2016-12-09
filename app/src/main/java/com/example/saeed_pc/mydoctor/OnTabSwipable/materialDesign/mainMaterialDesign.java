package com.example.saeed_pc.mydoctor.OnTabSwipable.materialDesign;

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

import com.example.saeed_pc.mydoctor.OnTabSwipable.SmartViewPager.MyPagerAdapter_Smart;
import com.example.saeed_pc.mydoctor.OnTabSwipable.TabLayoutSwipeable.adapter.NavDrawerListAdapter;
import com.example.saeed_pc.mydoctor.OnTabSwipable.TabLayoutSwipeable.model.NavDrawerItem;
import com.example.saeed_pc.mydoctor.R;

import java.util.ArrayList;

public class mainMaterialDesign extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private Toolbar toolbar;


    private MyPagerAdapter_Smart adapterViewPager;
    private TabLayout tabLayout;

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

    private ArrayList<NavDrawerItem> navDrawerItems;
   // private NavDrawerListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("===>", "onCreate.1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_material_design);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("My Dr");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Log.i("===>", "onCreate.1.2");

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapterViewPager = new MyPagerAdapter_Smart(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);

        // Give the TabLayout the ViewPager
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        // attach listener on view pager
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
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
        getMenuInflater().inflate(R.menu.menu_main_material_design, menu);
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

        Log.i("===>","onDrawerItemSelected.1 position:"+position);
        displayView(position);
        Log.i("===>", "onDrawerItemSelected.2 position:" + position);

    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        Log.i("===>", "displayView.1 title:" + title + " position: "+ position);
        switch (position) {
            case 0:

                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                Log.i("===>", "displayView.2.0 title:" + title);
                break;
            case 1:
                fragment = new HomeFragment();
                title = getString(R.string.title_friends);
                Log.i("===>", "displayView.2.1 title:" + title);
                break;
            case 2:
                fragment = new HomeFragment();
                title = getString(R.string.title_messages);
                Log.i("===>", "displayView.2.2 title:" + title);
                break;
            default:
                Log.i("===>", "displayView.2.null title:" + title);
                break;
        }

        if (fragment != null) {
            Log.i("===>", "displayView.3");
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();
            Log.i("===>", "displayView.4");

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
}