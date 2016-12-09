package com.example.saeed_pc.mydoctor.Main_MyDr.Design.SmartViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.HiDoctorFragment;
import com.example.saeed_pc.mydoctor.OnTabSwipable.ViewPager.FirstFragment;


// Extend from SmartFragmentStatePagerAdapter now instead for more dynamic ViewPager items
public  class MyPagerAdapter_Smart_main_MyDr extends SmartFragmentStatePagerAdapter {
    private SmartFragmentStatePagerAdapter adapterViewPager;
    private static int NUM_ITEMS = 3;

    public MyPagerAdapter_Smart_main_MyDr(FragmentManager fragmentManager) {
        super(fragmentManager);
        Log.i("===>", "MyPagerAdapter_Smart_main_MyDr.1");
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }


    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        Log.i("===>", "MyPagerAdapter_Smart_main_MyDr.2");
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return FirstFragment.newInstance(0, "Page # 1");
            case 1: // Fragment # 0 - This will show FirstFragment different title
               // return FirstFragment.newInstance(0, "Page # 1");
                return HiDoctorFragment.newInstance("param1", "param2");
          //  return FirstFragment.newInstance(2, "Hi Dr page ");
            case 2: // Fragment # 1 - This will show SecondFragment
                return FirstFragment.newInstance(1, "Hi Dr page ");
            default:
                return null;
        }

    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Hi Dr";
            case 1:
                return "Book";
            case 2:
                return "Dr resume";
        }
        return "Page " + position;
    }



}
