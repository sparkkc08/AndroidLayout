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
import android.widget.Toast;

import com.example.androidlayout.R;

/** Performs processing events of the avatar fragment. */
public class AvatarFragment extends Fragment implements OnClickListener{
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
    		Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.avatar, null);
        
        ImageView mImageView= (ImageView)v.findViewById(R.id.big_avatar);
        mImageView.setImageBitmap(getCroppedBitmap(R.drawable.girl2));
        
        Button mBtnCall = (Button) v.findViewById(R.id.btn_avatar_call);
        mBtnCall.setOnClickListener(this);
        
        Button mBtnAdd = (Button) v.findViewById(R.id.btn_avatar_add);
        mBtnAdd.setOnClickListener(this);
        
        return v;
    }
	
	/** Returns circled Bitmap from different images in resources. */
	public Bitmap getCroppedBitmap(int src_image) {
		Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), src_image);
		
	    Bitmap mOutputBitmap = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(),
	    		Config.ARGB_8888);
	    Canvas mCanvas = new Canvas(mOutputBitmap);

	    final Paint mPaint = new Paint();
	    final Rect mRect = new Rect(0, 0, mBitmap.getWidth(), mBitmap.getHeight());

	    mPaint.setAntiAlias(true);
	    mCanvas.drawCircle(mBitmap.getWidth()/2, mBitmap.getHeight()/2, mBitmap.getWidth()/2, 
	    		mPaint);	    	    
	    mPaint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
	    mCanvas.drawBitmap(mBitmap, mRect, mRect, mPaint);
	    mPaint.setStrokeWidth(20);
	    mPaint.setStyle(Paint.Style.STROKE);
	    mPaint.setColor(Color.LTGRAY);
	    mCanvas.drawCircle(mBitmap.getWidth()/2, mBitmap.getHeight()/2, mBitmap.getWidth()/2, 
	    		mPaint);
	    
	    return mOutputBitmap;
	}
	
    @Override
    public void onClick(View v) {
        Toast.makeText(this.getActivity(), "Button is clicked!", Toast.LENGTH_SHORT).show();
        Log.d("AndroidLayout", "click");
    }

}