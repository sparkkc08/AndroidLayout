package com.example.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidlayout.R;

public class SettingsFragment extends Fragment implements OnClickListener{
	Button btn_notify;
	Button btn_terms;
	Button btn_safety;
	Button btn_support;
	Button btn_log_out;
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.settings, null);
        
        btn_notify = (Button) v.findViewById(R.id.btn_notify);
        btn_notify.setOnClickListener(this);

        btn_terms = (Button) v.findViewById(R.id.btn_terms);
        btn_terms.setOnClickListener(this);

        btn_safety = (Button) v.findViewById(R.id.btn_safety);
        btn_safety.setOnClickListener(this);

        btn_support = (Button) v.findViewById(R.id.btn_support);
        btn_support.setOnClickListener(this);

        btn_log_out = (Button) v.findViewById(R.id.btn_log_out);
        btn_log_out.setOnClickListener(this);
        
        return v;
    }
    
    @Override
    public void onClick(View v) {
    	switch(v.getId()){
    	case R.id.btn_log_out: 
    		FragmentManager fragmentManager = getFragmentManager();
            AvatarFragment avatar_fragment = new AvatarFragment();
            SettingsFragment settings_fragment = new SettingsFragment();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.avatarfragment, settings_fragment);
            transaction.replace(R.id.settingsfragment, avatar_fragment);
            transaction.addToBackStack(null);
            transaction.commit();	
    	}
    	Toast.makeText(this.getActivity(), "Button is clicked!", Toast.LENGTH_SHORT).show();
        Log.d("AndroidLayout", "click");
    }
}


 