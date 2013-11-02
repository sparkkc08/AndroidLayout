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

public class ToolbarFragment extends Fragment implements OnClickListener{
    Button btn_next;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	Log.v("AndroidLayout", "start_of_toolbarfragment");
        View v = inflater.inflate(R.layout.toolbar, null);
        
        btn_next = (Button) v.findViewById(R.id.toolbar_btn);
        btn_next.setOnClickListener(this);
        
        
        ArrayList<ImageToLoad> images = new ArrayList<ImageToLoad>();
        //for (int i=0; i<1; i++) {
            //images.add(new ImageToLoadUrl("http://link.to/some-awesome-image.jpg")); // substitute some pretty picture you can stand to see 20 times in a list
            images.add(new ImageToLoadDrawableResource(R.drawable.girl1)); // plug in some of your own drawables
            images.add(new ImageToLoadDrawableResource(R.drawable.girl2));
            images.add(new ImageToLoadDrawableResource(R.drawable.girl3));
            images.add(new ImageToLoadDrawableResource(R.drawable.girl4));
            images.add(new ImageToLoadDrawableResource(R.drawable.girl5));
            
        //}

        // set up the scroller with an adapter populated with the list of ImageToLoad objects
        HorizontalImageScroller scroller = (HorizontalImageScroller) v.findViewById(R.id.small_avatar_scroller);
        HorizontalImageScrollerAdapter adapter = new HorizontalImageScrollerAdapter(getActivity().getApplicationContext(), images);
        scroller.setAdapter(adapter);

        return v;
    }
	
    @Override
    public void onClick(View v) {
    	Toast.makeText(this.getActivity(), "Button is clicked!", Toast.LENGTH_SHORT).show();
        Log.d("AndroidLayout", "click");
    }
}