package com.example.saeed_pc.mydoctor.OnTabSwipable.SmartViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.saeed_pc.mydoctor.OnTabSwipable.ViewPager.MyPagerAdapter;
import com.example.saeed_pc.mydoctor.R;

public class MainSmartViewPager extends AppCompatActivity {

    private MyPagerAdapter_Smart adapterViewPager;
    private ViewPager vpPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_smart_view_pager);
        vpPager = (ViewPager) findViewById(R.id.vpPager_smart);


        adapterViewPager = new MyPagerAdapter_Smart(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        //fragment of current page.. also you can give number instead of current page
        Fragment registeredFragment = adapterViewPager.getRegisteredFragment(vpPager.getCurrentItem());
        //to let the system keep 3 page instances on both sides of the current page:
        vpPager.setOffscreenPageLimit(3);

        //Animating the Scroll with PageTransformer
        vpPager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {

                // Do our transformations to the pages here

            }
        });

        // Attach the page change listener inside the activity
        vpPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainSmartViewPager.this,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });


        setSelectedTab();
    }


    // Reads selected tab from launching intent and
// sets page accordingly
    public void setSelectedTab() {
        // Fetch the selected tab index with default
        int selectedTabIndex = getIntent().getIntExtra("CurrentTab", 3);
        // Switch to page based on index
        vpPager.setCurrentItem(selectedTabIndex);
    }
}
