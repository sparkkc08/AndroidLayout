package com.example.androidlayout;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;

import com.example.fragments.AvatarFragment;
import com.example.fragments.SettingsFragment;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("AndroidLayout", "start_of_main");
        setContentView(R.layout.main);
        
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //add a fragment
        AvatarFragment avatarfragment = new AvatarFragment();
        fragmentTransaction.add(R.id.avatarfragment, avatarfragment);
        SettingsFragment settingsfragment = new SettingsFragment();
        fragmentTransaction.add(R.id.settingsfragment, settingsfragment);
        
        fragmentTransaction.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}






		/*
		Fragment toolbar = new ToolbarFragment();
		Fragment avatar = new AvatarFragment();
		Fragment settings = new SettingsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.toolbar, toolbar);
        fragmentTransaction.add(R.id.avatar, avatar);
        fragmentTransaction.add(R.id.settings, settings);

        fragmentTransaction.commit();
        */
