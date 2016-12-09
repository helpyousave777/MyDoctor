package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Operation_MyDr_AllDoctor_Info;
import com.example.saeed_pc.mydoctor.Main.MainActivity;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.dialog.dialog;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.listViewOperation_HiDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.thread_listView.Thread_ListView_HiDr;
import com.example.saeed_pc.mydoctor.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HiDoctorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HiDoctorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HiDoctorFragment extends Fragment {

    //--------------------------------------------------------------//
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static  RecyclerView recycler_HiDr;
    private Context context;
    private dialog dialog;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ////-------------------------------------------------------//


    public static SharedPreferences preferences_add_HiDr;
    private FloatingActionButton fab;
    private listViewOperation_HiDr listViewOp_hiDr;
    // private listViewOperation_HiDr listViewOp_hiDr;

    public HiDoctorFragment() {
        // Required empty public constructor
    }


    public static HiDoctorFragment newInstance(String param1, String param2) {
        HiDoctorFragment fragment = new HiDoctorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hi_doctor, container, false);
        context=container.getContext();

        recycler_HiDr = (RecyclerView) view.findViewById(R.id.RecyclerView_Main_HiDr);
        dialog =new dialog(context);
        fab = (FloatingActionButton) view.findViewById(R.id.fab_HiDr);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // dialog.newMessage();
                startActivity(new Intent(context,SelectContactActivity.class));
            }
        });
        return view;


    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("===>", "onResume HiDr1");
        listViewOp_hiDr = new listViewOperation_HiDr(context);
        listViewOp_hiDr.advancedRecyclerView(HiDoctorFragment.recycler_HiDr);
        //new Thread_ListView_HiDr(context).execute();

        // listViewOp_hiDr.advancedListView(listView_HiDr);
        Log.i("===>", "onResume HiDr2");
    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
      //  if (mListener != null) {
      //      mListener.onFragmentInteraction(uri);
      //  }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
     //   if (context instanceof OnFragmentInteractionListener) {
     //       mListener = (OnFragmentInteractionListener) context;
     //   } else {
     //       throw new RuntimeException(context.toString()
     //               + " must implement OnFragmentInteractionListener");
     //   }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
   //     void onFragmentInteraction(Uri uri);
    }
}
