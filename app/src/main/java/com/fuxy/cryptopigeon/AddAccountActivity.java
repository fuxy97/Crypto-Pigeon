package com.fuxy.cryptopigeon;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddAccountActivity extends AppCompatActivity implements
        EnterEmailCredentialsFragment.OnFragmentInteractionListener,
        InboxParametersFragment.OnFragmentInteractionListener,
        OutboxParametersFragment.OnFragmentInteractionListener {

    private FragmentManager fragmentManager;
    private EnterEmailCredentialsFragment enterEmailCredentialsFragment;
    private InboxParametersFragment inboxParametersFragment;
    private OutboxParametersFragment outboxParametersFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle(getResources().getString(R.string.add_account));
        setContentView(R.layout.activity_add_account);

        enterEmailCredentialsFragment = new EnterEmailCredentialsFragment();

        fragmentManager = getSupportFragmentManager();

        fragmentManager
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.frame_layout_add_account, enterEmailCredentialsFragment)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onEnterEmailCredentialsNextButtonClick(View v) {
        if (enterEmailCredentialsFragment.isEmailAddressEmpty()) {
            enterEmailCredentialsFragment.focusEmailAddressEditText();
        }
        else if (enterEmailCredentialsFragment.isEmailPasswordEmpty()) {
            enterEmailCredentialsFragment.focusPasswordEditText();
        }
        else {
            inboxParametersFragment = new InboxParametersFragment();

            fragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.frame_layout_add_account, inboxParametersFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void onInboxParametersNextButtonClick(View v) {
        if (inboxParametersFragment.isServerAddressEmpty()) {
            inboxParametersFragment.focusServerAddressEditText();
        }
        else if (inboxParametersFragment.isPortEmpty()) {
            inboxParametersFragment.focusPortEditText();
        }
        else {
            outboxParametersFragment = new OutboxParametersFragment();

            fragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.frame_layout_add_account, outboxParametersFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void onOutboxParametersNextButtonClick(View v) {
        if (outboxParametersFragment.isServerAddressEmpty()) {
            outboxParametersFragment.focusServerAddressEditText();
        }
        else if (outboxParametersFragment.isPortEmpty()) {
            outboxParametersFragment.focusPortEditText();
        }
        else {

        }
    }

}
