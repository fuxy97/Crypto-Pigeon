package com.fuxy.cryptopigeon;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EnterEmailCredentialsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */

public class EnterEmailCredentialsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private EditText emailAddressEditText, emailPasswordEditText;

    public EnterEmailCredentialsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_enter_email_credentials, container, false);

        emailAddressEditText = view.findViewById(R.id.edit_email_address);
        emailPasswordEditText = view.findViewById(R.id.edit_email_password);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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

    public boolean isEmailAddressEmpty()
    {
        return TextUtils.isEmpty(emailAddressEditText.getText());
    }

    public void focusEmailAddressEditText()
    {
        emailAddressEditText.requestFocus();
    }

    public boolean isEmailPasswordEmpty()
    {
        return TextUtils.isEmpty(emailPasswordEditText.getText());
    }


    public void focusPasswordEditText()
    {
        emailPasswordEditText.requestFocus();
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
