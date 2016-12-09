package com.example.saeed_pc.mydoctor.OnTabSwipable;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.saeed_pc.mydoctor.R;

/**
 * Created by SAEED-PC on 12/29/2015.
 */
public class FragmentExample extends Fragment {

    private TextView title_change;
    private static TextView txtExamActivity;
    private static int i=0;
    private Button btnFr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        txtExamActivity = (TextView) getActivity().findViewById(R.id.txtOnTabExample);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        Log.i("===>", "FragmentExample_onCreateView1");
        View view = inflater.inflate(R.layout.example_fragment, container, false);
        Log.i("===>", "FragmentExample_onCreateView2");
        title_change = (TextView) view.findViewById(R.id.txtFragmentA);
        btnFr = (Button) view.findViewById(R.id.btnFragmentExampleA);
        Log.i("===>", "FragmentExample_onCreateView3");
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        doSth();
        Log.i("===>", "FragmentExample.onResume.1");
        int SomeInt = getArguments().getInt("someInt", 0);
        Log.i("===>", "FragmentExample.onResume.2");
        String someTitle = getArguments().getString("someTitle", "");
        Log.i("===>", "FragmentExample.onResume.3");
        title_change.setText(someTitle + "  :  " + SomeInt);
        Log.i("===>", "FragmentExample.onResume.4");
        btnFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                // Replace the contents of the container with the new fragment
                FragmentExampleB fragmentDemo = new FragmentExampleB();
                //FragmentExample fragment = (FragmentExample) getFragmentManager().findFragmentById(R.id.exa);



                ft.replace(R.id.fragment_container, fragmentDemo);
                ft.addToBackStack(null);
                Log.i("===>", "onChangeFrag2");
                ft.commit();
                Log.i("===>", "onChangeFrag3");

            }
        });
    }



    @Override
    public void onPause() {
        super.onPause();
    }


    public static FragmentExample newInstance(int someInt, String someTitle) {
        Log.i("===>", "FragmentExample.newInstance.1");
        FragmentExample fragmentDemo = new FragmentExample();
        Log.i("===>", "FragmentExample.newInstance.2");
        Bundle args = new Bundle();
        Log.i("===>", "FragmentExample.newInstance.3");
        args.putInt("someInt", someInt);
        Log.i("===>", "FragmentExample.newInstance.4");
        args.putString("someTitle", someTitle);
        Log.i("===>", "FragmentExample.newInstance.5");
        fragmentDemo.setArguments(args);
        Log.i("===>", "FragmentExample.newInstance.6");

        return fragmentDemo;
    }

    public static void doSth(){
        i=i+1;
        Log.i("===>", "FragmentExample.doSth.2");
        txtExamActivity.setText("" + i);
        Log.i("===>", "FragmentExample.doSth.3");

    }

    public static String outputFragment(){

        String ali="ali";
        return ali;
    }
}
