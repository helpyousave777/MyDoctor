package com.example.saeed_pc.mydoctor.OnTabSwipable;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.saeed_pc.mydoctor.R;



public class MyFragmentExample extends AppCompatActivity implements FragmentExampleB.OnItemSelectedListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction ft;
    private int i=0;
    private Button btn;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment_example);
        Log.i("===>", "MyFragmentExample1");
        fragmentFunction(savedInstanceState);
        Log.i("===>", "MyFragmentExample2");
        btn = (Button) findViewById(R.id.button5);
        txt = (TextView) findViewById(R.id.txtOnTabExample);
    }



    private void fragmentFunction(Bundle savedInstanceState) {

        Log.i("===>", "MyFragmentExample1.1");
        fragmentManager = getFragmentManager();
        Log.i("===>", "MyFragmentExample1.2");
        // Begin the transaction
        ft = getFragmentManager().beginTransaction();
        Log.i("===>", "MyFragmentExample1.3");
        // Replace the contents of the container with the new fragment
       // FragmentExample fragmentDemo = FragmentExample.newInstance(5, "my title");
        FragmentExampleB fragmentDemo = new FragmentExampleB();
        Log.i("===>", "MyFragmentExample1.4");
        ft.addToBackStack(null);
        ft.add(R.id.fragment_container, fragmentDemo);
        Log.i("===>", "MyFragmentExample1.5");
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();
        Log.i("===>", "MyFragmentExample1.6");

        if (savedInstanceState == null) {
            FragmentExample fragment = (FragmentExample)getFragmentManager().findFragmentById(R.id.fragment_container);

        }
        Log.i("===>", "MyFragmentExample1.7");



    }


    public void onChangeFrag(View view) {

        i=i+1;
        Log.i("===>","onChangeFrag1");
        fragmentManager = getFragmentManager();
        ft = getFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        String s = FragmentExample.outputFragment();
        FragmentExample fragmentDemo = FragmentExample.newInstance(i, "new title :" + s);
        //FragmentExample fragment = (FragmentExample) getFragmentManager().findFragmentById(R.id.exa);



        ft.replace(R.id.fragment_container, fragmentDemo);
        ft.addToBackStack(null);
        Log.i("===>", "onChangeFrag2");
        ft.commit();
        Log.i("===>", "onChangeFrag3");
    }

    public void onExampleFragmentA(View view) {

    }

    // Now we can define the action to take in the activity when the fragment event fires
    // This is implementing the `OnItemSelectedListener` interface methods
    @Override
    public void onRssItemSelected(String link) {
        Log.i("===>", "Main.onRssItemSelected.1 "+link);
        txt.setText(link);
        Log.i("===>", "Main.onRssItemSelected.2");
    }

    public void onListFragment(View view) {

        Log.i("===>","onChangeFrag1");
        fragmentManager = getFragmentManager();
        ft = getFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.fragment_container, new myListFragment());
        ft.addToBackStack(null);
        Log.i("===>", "onChangeFrag2");
        ft.commit();
        Log.i("===>", "onChangeFrag3");

    }
}
