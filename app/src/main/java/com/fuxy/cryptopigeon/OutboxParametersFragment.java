package com.fuxy.cryptopigeon;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OutboxParametersFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class OutboxParametersFragment extends Fragment {

    private Spinner authProtocolSpinner;
    private EditText smtpServerAddressEditText, portEditText;
    private OnFragmentInteractionListener mListener;

    public OutboxParametersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_outbox_parameters, container, false);

        String[] authProtocols = getResources().getStringArray(R.array.auth_protocols);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        view.getContext(),
                        android.R.layout.simple_spinner_item,
                        authProtocols);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        authProtocolSpinner = view.findViewById(R.id.spinner_auth_protocol);
        authProtocolSpinner.setAdapter(adapter);

        smtpServerAddressEditText = view.findViewById(R.id.edit_server_address);
        portEditText = view.findViewById(R.id.edit_port);

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

    public boolean isServerAddressEmpty()
    {
        return TextUtils.isEmpty(smtpServerAddressEditText.getText());
    }

    public void focusServerAddressEditText()
    {
        smtpServerAddressEditText.requestFocus();
    }

    public boolean isPortEmpty()
    {
        return TextUtils.isEmpty(portEditText.getText());
    }


    public void focusPortEditText()
    {
        portEditText.requestFocus();
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
