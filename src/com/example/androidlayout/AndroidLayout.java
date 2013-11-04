/*
 * Copyright (C) 2013 Maxim Mironyuk 
 * https://github.com/sparkkc08/AndroidLayout
 */

package com.example.androidlayout;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;

import com.example.fragments.AvatarFragment;
import com.example.fragments.SettingsFragment;

/** Performs processing events of program components, 
 * which includes initialization of fragments  */
public class AndroidLayout extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();

        //add a fragments
        AvatarFragment mAvatarFragment = new AvatarFragment();
        mFragmentTransaction.add(R.id.avatarfragment, mAvatarFragment);
        SettingsFragment mSettingsFragment = new SettingsFragment();
        mFragmentTransaction.add(R.id.settingsfragment, mSettingsFragment);        
        mFragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }   
    
}
