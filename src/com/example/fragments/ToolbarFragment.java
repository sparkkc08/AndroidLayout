/*
 * Copyright (C) 2013 Maxim Mironyuk 
 * https://github.com/sparkkc08/AndroidLayout
 */

package com.example.fragments;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidlayout.R;
import com.twotoasters.android.horizontalimagescroller.image.ImageToLoad;
import com.twotoasters.android.horizontalimagescroller.image.ImageToLoadDrawableResource;
import com.twotoasters.android.horizontalimagescroller.widget.HorizontalImageScroller;
import com.twotoasters.android.horizontalimagescroller.widget.HorizontalImageScrollerAdapter;

/** Performs processing events of the toolbar fragment. */
public class ToolbarFragment extends Fragment implements OnClickListener{
   
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
    		Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.toolbar, null);
        
        Button mBtnNext = (Button) v.findViewById(R.id.toolbar_btn);
        mBtnNext.setOnClickListener(this);
        
        ArrayList<ImageToLoad> mImages = new ArrayList<ImageToLoad>();

        // TODO: Change this to use a loop.
        mImages.add(new ImageToLoadDrawableResource(R.drawable.girl1));
        mImages.add(new ImageToLoadDrawableResource(R.drawable.girl2));
        mImages.add(new ImageToLoadDrawableResource(R.drawable.girl3));
        mImages.add(new ImageToLoadDrawableResource(R.drawable.girl4));
        mImages.add(new ImageToLoadDrawableResource(R.drawable.girl5));

        // set up the scroller with an adapter populated with the list of ImageToLoad objects
        HorizontalImageScroller mScroller = (HorizontalImageScroller) v.findViewById(
        		R.id.small_avatar_scroller);
        HorizontalImageScrollerAdapter mAdapter = new HorizontalImageScrollerAdapter(
        		getActivity().getApplicationContext(), mImages);
        mScroller.setAdapter(mAdapter);

        return v;
    }
	
    @Override
    public void onClick(View v) {
    	Toast.makeText(this.getActivity(), "Button is clicked!", Toast.LENGTH_SHORT).show();
        Log.d("AndroidLayout", "click");
    }
}