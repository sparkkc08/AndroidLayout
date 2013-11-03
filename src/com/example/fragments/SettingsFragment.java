/*
 * Copyright (C) 2013 Maxim Mironyuk 
 * https://github.com/sparkkc08/AndroidLayout
 */

package com.example.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidlayout.R;

/** Performs processing events of the settings fragment. */
public class SettingsFragment extends Fragment implements OnClickListener{
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
    		Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.settings, null);
        
        Button mBtnNotify = (Button) v.findViewById(R.id.btn_notify);
        mBtnNotify.setOnClickListener(this);

        Button mBtnTerms = (Button) v.findViewById(R.id.btn_terms);
        mBtnTerms.setOnClickListener(this);

        Button mBtnSafety = (Button) v.findViewById(R.id.btn_safety);
        mBtnSafety.setOnClickListener(this);

        Button mBtnSupport = (Button) v.findViewById(R.id.btn_support);
        mBtnSupport.setOnClickListener(this);

        Button mBtnLogOut = (Button) v.findViewById(R.id.btn_log_out);
        mBtnLogOut.setOnClickListener(this);
        
        return v;
    }
    
    @Override
    public void onClick(View v) {
    	switch(v.getId()){
    	case R.id.btn_log_out: 
            AvatarFragment avatar_fragment = new AvatarFragment();
            SettingsFragment settings_fragment = new SettingsFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.avatarfragment, settings_fragment);
            transaction.replace(R.id.settingsfragment, avatar_fragment);
            transaction.addToBackStack(null);
            transaction.commit();
            break;
    	}
    	Toast.makeText(this.getActivity(), "Button is clicked!", Toast.LENGTH_SHORT).show();
        Log.d("AndroidLayout", "click");
    }
}


 