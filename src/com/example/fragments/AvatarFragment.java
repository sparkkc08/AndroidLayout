/*
 * Copyright (C) 2013 Maxim Mironyuk 
 * https://github.com/sparkkc08/AndroidLayout
 */

package com.example.fragments;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;

import com.example.androidlayout.R;

/** Performs processing events of the avatar fragment. */
public class AvatarFragment extends Fragment implements OnClickListener{
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
    		Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_avatar, null);
        
        ImageView mImageView= (ImageView)v.findViewById(R.id.big_avatar);
        
        mImageView.setImageBitmap(getCroppedBitmap(R.drawable.img_girl3));
        mImageView.setScaleType(ScaleType.FIT_CENTER);
        
        Button mBtnCall = (Button) v.findViewById(R.id.btn_avatar_call);
        mBtnCall.setOnClickListener(this);
        
        Button mBtnAdd = (Button) v.findViewById(R.id.btn_avatar_add);
        mBtnAdd.setOnClickListener(this);
        
        return v;
    }
	
	/** Returns circled Bitmap from different images in resources. */
	public Bitmap getCroppedBitmap(int src_image) {
		Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), src_image);
	    Bitmap mScaledBitmap = Bitmap.createScaledBitmap(mBitmap, mBitmap.getWidth()/2, 
	    		mBitmap.getWidth()/2, false);

	    Bitmap mOutputBitmap = Bitmap.createBitmap(mScaledBitmap.getWidth(), mScaledBitmap.getHeight(), Config.ARGB_8888);
	    Canvas mCanvas = new Canvas(mOutputBitmap);

	    final Paint mPaint = new Paint();
	    final Rect mRect = new Rect(0, 0, mScaledBitmap.getWidth(), mScaledBitmap.getHeight());

	    mPaint.setAntiAlias(true);
	    mPaint.setFilterBitmap(true);
	    mPaint.setDither(true);
	    mCanvas.drawARGB(0, 0, 0, 0);
	    mPaint.setColor(Color.parseColor("#BAB399"));
	    mCanvas.drawCircle(mScaledBitmap.getWidth() / 2+3.7f, mScaledBitmap.getHeight() / 2+3.7f,
	    		mScaledBitmap.getWidth() / 2+0.1f, mPaint);
	    mPaint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
	    mCanvas.drawBitmap(mScaledBitmap, mRect, mRect, mPaint);
	    
	    return mOutputBitmap;
	}
	
	
    @Override
    public void onClick(View v) {
        Toast.makeText(this.getActivity(), "Button is clicked!", Toast.LENGTH_SHORT).show();
        Log.d("AndroidLayout", "click");
    }

}