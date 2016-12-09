package com.example.saeed_pc.mydoctor.OnTabSwipable.TabLayoutSwipeable;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.saeed_pc.mydoctor.OnTabSwipable.FragmentExample;
import com.example.saeed_pc.mydoctor.OnTabSwipable.FragmentExampleB;
import com.example.saeed_pc.mydoctor.OnTabSwipable.SmartViewPager.MyPagerAdapter_Smart;
import com.example.saeed_pc.mydoctor.OnTabSwipable.TabLayoutSwipeable.adapter.NavDrawerListAdapter;
import com.example.saeed_pc.mydoctor.OnTabSwipable.TabLayoutSwipeable.model.NavDrawerItem;
import com.example.saeed_pc.mydoctor.OnTabSwipable.ViewPager.FirstFragment;
import com.example.saeed_pc.mydoctor.OnTabSwipable.ViewPager.SecondFragment;
import com.example.saeed_pc.mydoctor.R;

import java.util.ArrayList;

public class MainTabLayoutSwipeable extends AppCompatActivity {

    private MyPagerAdapter_Smart adapterViewPager;
    private android.support.v7.widget.Toolbar toolbar;
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
    private NavDrawerListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("===>", "onCreate.1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab_layout_swipeable);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_main_tab_layout_swipeable);
        toolbar.setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Log.i("===>", "onCreate.1.1");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.i("===>", "onCreate.1.2");
     //    getActionBar().setHomeButtonEnabled(true);
//




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

        drawerSetup(savedInstanceState);
        Log.i("===>", "onCreate.2");


    }

    private void drawerSetup(Bundle savedInstanceState) {
        Log.i("===>","drawerSetup.1");
        mTitle = mDrawerTitle = getTitle();

        // load slide menu items
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        // nav drawer icons from resources
        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

       navDrawerItems = new ArrayList<NavDrawerItem>();

       // adding nav drawer items to array
       // Home
       navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
       // Find People
       navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(0, -1)));
       // Photos
       navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(0, -1)));
       // Communities, Will add a counter here
       navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(0, -1), true, "22"));
       // Pages
       navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(0, -1)));
       // What's hot, We  will add a counter here
       navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(0, -1), true, "50+"));


        // Recycle the typed array
        navMenuIcons.recycle();

        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(),
                navDrawerItems);
        mDrawerList.setAdapter(adapter);
        Log.i("===>", "drawerSetup.2");

        // enabling action bar app icon and behaving it as toggle button

        Log.i("===>", "drawerSetup.2.1");


        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ){

            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
                Log.i("====>","onDrawerClosed");
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
                Log.i("====>", "onDrawerOpened");
            }
        };
        Log.i("===>", "drawerSetup.2.2");
        //mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

        if (savedInstanceState == null) {
            // on first time display view for first nav item
          //  displayView(0);
        }
        Log.i("===>", "drawerSetup.3");
    }


    /**
     * Slide menu item click listener
     * */
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            displayView(position);
        }
    }

    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    private void displayView(int position) {
        // update the main content by replacing fragments
       // Fragment fragment = null;
        FragmentExampleB fragment=new FragmentExampleB();
        switch (position) {
            case 0:
               // fragment = new Fragment();
                break;
            case 1:
              //  fragment = new FragmentExampleB();
                break;
            case 2:
              //  fragment = new SecondFragment();
                break;
            case 3:
           //     fragment = new FirstFragment();
                break;
            case 4:
             //   fragment = new SecondFragment();
                break;
            case 5:
             //   fragment = new FirstFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.i("MainActivity", "Error in creating fragment");
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
        Log.i("===>", "onCreateOptionsMenu.1");
        getMenuInflater().inflate(R.menu.menu_main_tab_layout_swipeable, menu);
        Log.i("===>", "onCreateOptionsMenu.2");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("===>","onOptionsItemSelected.1");
        int id = item.getItemId();

        // toggle nav drawer on selecting action bar app icon/title
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            Log.i("===>","onOptionsItemSelected.2.mDrawerToggle");
            return true;
        }

        switch (id) {
            case R.id.action_settings:
                Log.i("===>","onOptionsItemSelected.2.action_settings");
                return true;
            case R.id.action_Search_test:
                Log.i("===>","onOptionsItemSelected.2.action_Search_test");
                handleMenuSearch();
                return true;
        }
        Log.i("===>","onOptionsItemSelected.2.onOptionsItemSelected");

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.i("===>","onPrepareOptionsMenu.1");
        //for search part
        mSearchAction = menu.findItem(R.id.action_Search_test);
        Log.i("===>","onPrepareOptionsMenu.1.1");

        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        Log.i("===>","onPrepareOptionsMenu.1.2" + drawerOpen);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        Log.i("===>","onPrepareOptionsMenu.2");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void setTitle(CharSequence title) {
        Log.i("===>","setTitle.1");
        mTitle = title;
        getActionBar().setTitle(mTitle);
        Log.i("===>", "setTitle.2 "+ getActionBar().getTitle());
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        Log.i("===>","onPostCreate.1");
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
        Log.i("===>", "onPostCreate.2");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.i("===>","onConfigurationChanged.1");
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
        Log.i("===>", "onConfigurationChanged.2");
    }


    protected void handleMenuSearch(){
        Log.i("===>","handleMenuSearch.1");
        ActionBar action = getSupportActionBar(); //get the actionbar

        if(isSearchOpened){ //test if the search is open

            action.setDisplayShowCustomEnabled(false); //disable a custom view inside the actionbar
            action.setDisplayShowTitleEnabled(true); //show the title in the action bar

            //hides the keyboard
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(edtSeach.getWindowToken(), 0);

            //add the search icon in the action bar
            mSearchAction.setIcon(getResources().getDrawable(R.mipmap.hi_doctor_search));

            isSearchOpened = false;
        } else { //open the search entry

            action.setDisplayShowCustomEnabled(true); //enable it to display a
            // custom view in the action bar.
            action.setCustomView(R.layout.search_bar);//add the custom view
            action.setDisplayShowTitleEnabled(false); //hide the title

            edtSeach = (EditText)action.getCustomView().findViewById(R.id.edtSearch); //the text editor

            //this is a listener to do a search when the user clicks on search button
            edtSeach.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        doSearch();
                        return true;
                    }
                    return false;
                }


            });


            edtSeach.requestFocus();

            //open the keyboard focused in the edtSearch
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(edtSeach, InputMethodManager.SHOW_IMPLICIT);


            //add the close icon
            mSearchAction.setIcon(getResources().getDrawable(R.mipmap.hi_doctor_search));

            isSearchOpened = true;
        }
        Log.i("===>","handleMenuSearch.2");
    }

    //To this tutorial, I created an empty doSearch method.

   // You can anything here and do your custom search:
    private void doSearch() {
        Log.i("===>","doSearch.1");
    }

    @Override
    public void onBackPressed() {
        Log.i("===>","onBackPressed.1");
        if(isSearchOpened) {
            handleMenuSearch();
            return;
        }
        Log.i("===>","onBackPressed.2");
        super.onBackPressed();
    }

}
