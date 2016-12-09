package com.example.saeed_pc.mydoctor.OnTabSwipable;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
 * Created by ici80481 on 1/4/2016.
 */
public class FragmentExampleB extends Fragment   {


    // ...
    // Define the listener of the interface type
    // listener will the activity instance containing fragment
    private OnItemSelectedListener listener;
    private Button btnFr;
    private Button btnFr2;
    private TextView txtFr;
    private int i=0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("===>", "FragmentExampleB1");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        Log.i("===>", "FragmentExampleB2");
        View view = inflater.inflate(R.layout.example_fragment_b, container, false);
        btnFr = (Button) view.findViewById(R.id.btnFragmentExampleB_1);
        btnFr2 = (Button) view.findViewById(R.id.btnFragmentExampleB_2);
        txtFr = (TextView) view.findViewById(R.id.txtFragmentExampleB_1);
        Log.i("===>", "FragmentExampleB3");
        onSomeClick(view);
        // Setup handles to view objects here
        // etFoo = (EditText) view.findViewById(R.id.etFoo);
        return view;
    }



    // Define the events that the fragment will use to communicate
    public interface OnItemSelectedListener {
        // This can be any number of events to be sent to the activity
        public void onRssItemSelected(String link);
    }

    // Now we can fire the event when the user selects something in the fragment
    public void onSomeClick(View v) {
        btnFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = i + 1;
                txtFr.setText("" + i);
                Log.i("===>", "FragmentExampleB.onSomeClick.1 " + txtFr.getText().toString());

                Log.i("===>", "FragmentExampleB.onSomeClick.2 " + txtFr.getText().toString());
                listener.onRssItemSelected(txtFr.getText().toString());
                Log.i("===>", "FragmentExampleB.onSomeClick.3 " + txtFr.getText().toString());


            }
        });


    }

    // Store the listener (activity) that will have events fired once the fragment is attached
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OnItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");

        }
    }



    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        btnFr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                // Replace the contents of the container with the new fragment
                FragmentExample fragmentDemo = FragmentExample.newInstance(0,"inner Fragment click");
                //FragmentExample fragment = (FragmentExample) getFragmentManager().findFragmentById(R.id.exa);


                ft.replace(R.id.fragment_container, fragmentDemo);
                ft.addToBackStack(null);
                Log.i("===>", "onChangeFrag2");
                ft.commit();
                Log.i("===>", "onChangeFrag3");

            }
        });
    }
}
