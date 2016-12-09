package com.example.saeed_pc.mydoctor.OnTabSwipable.TabLayoutSwipeable.test;

/**
 * Created by ici80071 on 3/16/2016.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saeed_pc.mydoctor.R;

public class HomeFragment extends Fragment {

    public HomeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.example_fragment, container, false);

        return rootView;
    }
}