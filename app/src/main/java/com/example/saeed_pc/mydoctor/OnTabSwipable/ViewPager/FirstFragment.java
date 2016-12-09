package com.example.saeed_pc.mydoctor.OnTabSwipable.ViewPager;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Operation_MyDr_AllDoctor_Info;
import com.example.saeed_pc.mydoctor.Main.MainActivity;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.dialog.dialog;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.listViewOperation_HiDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.thread_listView.Thread_ListView_HiDr;
import com.example.saeed_pc.mydoctor.R;

/**
 * Created by SAEED-PC on 1/15/2016.
 */
public class FirstFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    private static final String ARG_PARAM1 = "param1";  //
    private static final String ARG_PARAM2 = "param2";  //
    public static  RecyclerView recycler_HiDr;     //
    private Context context;   //
    private dialog dialog;   //

    private OnFragmentInteractionListener mListener;

    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, String title) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);

        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.example_fragment, container, false);

        return view;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        //     void onFragmentInteraction(Uri uri);
    }
}