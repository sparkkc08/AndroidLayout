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

public class AvatarFragment extends Fragment implements OnClickListener{
    Button btn_call;
    Button btn_add;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.avatar, null);
        
        btn_call = (Button) v.findViewById(R.id.btn_avatar_call);
        btn_call.setOnClickListener(this);
        
        btn_add = (Button) v.findViewById(R.id.btn_avatar_add);
        btn_add.setOnClickListener(this);
        
        return v;
    }
	
    @Override
    public void onClick(View v) {
        Toast.makeText(this.getActivity(), "Button is clicked!", Toast.LENGTH_SHORT/4).show();	
        Log.d("AndroidLayout", "click");
    }

}