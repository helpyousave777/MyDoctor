package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.question_UI_HiDr.Activity;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Info.Info_All_Doctor_Information;
import com.example.saeed_pc.mydoctor.Accessories.Database.DoctorInformation.Operation_MyDr_AllDoctor_Info;
import com.example.saeed_pc.mydoctor.Accessories.constValue_General.constValue_General;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView.Info_HiDoctor_UserApp;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.question_UI_HiDr.date_Setting.date_Setting;
import com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.question_UI_HiDr.question_UI_HiDr;
import com.example.saeed_pc.mydoctor.Main_MyDr.MainMyDr;
import com.example.saeed_pc.mydoctor.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuestionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";



    private question_UI_HiDr question_ui_hiDr;

    public static TextView txt_question_question_HiDr;
    public static TextView txt_subject_question_HiDr;
    public static TextView txt_dateSend_question_HiDr;
    public static TextView txt_timeSend_question_HiDr;
    public static TextView txt_answer_question_HiDr;
    public static TextView txt_dateReceive_question_HiDr;
    public static TextView txt_timeReceive_question_HiDr;


    // TODO: Rename and change types of parameters
    private String txt_subject;
    private String txt_question;
    private Info_HiDoctor_UserApp info_Message;


    private OnFragmentInteractionListener mListener;
    private ImageView sendIcon;
    private EditText edtQuestionFromActivity;
    private String question;
    private boolean flag_question_done = false;
    private Operation_MyDr_AllDoctor_Info operation_myDr_allDoctor_info;
    private Info_All_Doctor_Information info_Dr;

    public QuestionFragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param txt_subject Parameter 1.
     * @param txt_question Parameter 2.
     * @param info_Message
     * @return A new instance of fragment QuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionFragment newInstance(String txt_subject, String txt_question, Info_HiDoctor_UserApp info_Message) {
        Log.i("===>", "QuestionFragment.newInstance.subject " + txt_subject);
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, txt_subject);
        args.putString(ARG_PARAM2, txt_question);
        args.putSerializable(ARG_PARAM3,info_Message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("===>", "QuestionHiDrActivity.onCreate.2");


        if (getArguments() != null) {
            txt_subject  = getArguments().getString(ARG_PARAM1);
            txt_question = getArguments().getString(ARG_PARAM2);
            info_Message         = (Info_HiDoctor_UserApp) getArguments().getSerializable(ARG_PARAM3);

        }


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root_view=inflater.inflate(R.layout.fragment_question, container, false);


        txt_subject_question_HiDr = (TextView) root_view.findViewById(R.id.txtSubjectQuestion_HiDr_fragment);

        txt_question_question_HiDr = (TextView) root_view.findViewById(R.id.txtQuestionQuestion_HiDr_fragment);
        txt_dateSend_question_HiDr = (TextView) root_view.findViewById(R.id.txtDateSendQuestion_HiDr_fragment);
        txt_timeSend_question_HiDr = (TextView) root_view.findViewById(R.id.txtTimeSendQuestion_HiDr_fragment);

        txt_answer_question_HiDr = (TextView) root_view.findViewById(R.id.txtAnswerQuestion_HiDr_fragment);
        txt_dateReceive_question_HiDr = (TextView) root_view.findViewById(R.id.txtDateReceiveQuestion_HiDr_fragment);
        txt_timeReceive_question_HiDr = (TextView) root_view.findViewById(R.id.txtTimeReceiveQuestion_HiDr_fragment);






        //txt_question_question_HiDr.setText("" + info.getSendDate() + info.getSubject() + info.getQuestion());
        Log.i("===>", "QuestionFragment.onCreateView.subject " + txt_subject);
        txt_subject_question_HiDr.setText(txt_subject);


        if(MainMyDr.flag_question_pos == constValue_General.HyDr_ShowMessage){
            date_Setting.sendDateQuestionSetting_fragment(info_Message);
        }

        sendIcon = (ImageView) getActivity().findViewById(R.id.imgViewSendQuestionHiDr);
        edtQuestionFromActivity = (EditText) getActivity().findViewById(R.id.edtTxtQuestionHiDr);

        setVisibilityOfView();
        setQuestionView();



        return root_view;
    }

    private void setQuestionView() {
        sendIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("===>", "setQuestionView.1");
                question = edtQuestionFromActivity.getText().toString();
                edtQuestionFromActivity.setText("");
                txt_question_question_HiDr.setVisibility(View.VISIBLE);
                txt_question_question_HiDr.setText(question);
                Log.i("===>", "setQuestionView.2");

                if (mListener != null) {
                    mListener.onFragmentInteraction(true, question);
                }


                Log.i("===>","QuestionFragment.onCreateView.setQuestionView.question : "+ question);

            }
        });

        if(MainMyDr.flag_question_pos == constValue_General.HyDr_ShowMessage){
            txt_question_question_HiDr.setText(info_Message.getQuestion());

        }
    }

    private void setVisibilityOfView() {
        if(MainMyDr.flag_question_pos == constValue_General.HyDr_NewMessage){

            Log.i("===>","QuestionFragment.setVisibilityOfView.HyDr_NewMessage");
            txt_question_question_HiDr.setVisibility(View.INVISIBLE);
            txt_dateSend_question_HiDr.setVisibility(View.INVISIBLE);
            txt_timeSend_question_HiDr.setVisibility(View.INVISIBLE);
            txt_answer_question_HiDr.setVisibility(View.INVISIBLE);
            txt_dateReceive_question_HiDr.setVisibility(View.INVISIBLE);
            txt_timeReceive_question_HiDr .setVisibility(View.INVISIBLE);
            sendIcon.setVisibility(View.VISIBLE);
            edtQuestionFromActivity.setVisibility(View.VISIBLE);

        }else{
            Log.i("===>","QuestionFragment.setVisibilityOfView.HyDr_ShowMessage");

            txt_question_question_HiDr.setVisibility(View.VISIBLE);
            txt_dateSend_question_HiDr.setVisibility(View.VISIBLE);
            txt_timeSend_question_HiDr.setVisibility(View.VISIBLE);
            txt_answer_question_HiDr.setVisibility(View.INVISIBLE);
            txt_dateReceive_question_HiDr.setVisibility(View.INVISIBLE);
            txt_timeReceive_question_HiDr .setVisibility(View.INVISIBLE);
            //txt_answer_question_HiDr.setVisibility(View.VISIBLE);
            //txt_dateReceive_question_HiDr.setVisibility(View.VISIBLE);
            //txt_timeReceive_question_HiDr .setVisibility(View.VISIBLE);
            sendIcon.setVisibility(View.INVISIBLE);
            edtQuestionFromActivity.setVisibility(View.INVISIBLE);

        }
    }

    @Override
    public void onResume() {
        super.onResume();

       // if(question)
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(true , ""+constValue_General.null_number);
        }
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        operation_myDr_allDoctor_info = new Operation_MyDr_AllDoctor_Info(context);

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

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
        public void onFragmentInteraction(boolean flag_question_done , String question );
    }



}
