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

public class AvatarFragment extends Fragment implements OnClickListener{
    Button btn_call;
    Button btn_add;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.avatar, null);
        
        ImageView iv= (ImageView)v.findViewById(R.id.big_avatar);
        iv.setImageBitmap(getCroppedBitmap(R.drawable.girl2));
        
        btn_call = (Button) v.findViewById(R.id.btn_avatar_call);
        btn_call.setOnClickListener(this);
        
        btn_add = (Button) v.findViewById(R.id.btn_avatar_add);
        btn_add.setOnClickListener(this);
        
        return v;
    }
	
	public Bitmap getCroppedBitmap(int src_image) {
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), src_image);
		
	    Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
	    Canvas canvas = new Canvas(output);

	    final Paint paint = new Paint();
	    final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

	    paint.setAntiAlias(true);
	    //canvas.drawARGB(0, 0, 0, 0);
	    // canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
	    canvas.drawCircle(bitmap.getWidth()/2, bitmap.getHeight()/2, bitmap.getWidth()/2, paint);
	    	    
	    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
	    canvas.drawBitmap(bitmap, rect, rect, paint);
	    //Bitmap _bmp = Bitmap.createScaledBitmap(output, 60, 60, false);
	    //return _bmp;
	    paint.setStrokeWidth(20);
	    paint.setStyle(Paint.Style.STROKE);
	    paint.setColor(Color.LTGRAY);
	    canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth()/2, paint);
	    
	    return output;
	}
	
    @Override
    public void onClick(View v) {
        Toast.makeText(this.getActivity(), "Button is clicked!", Toast.LENGTH_SHORT).show();	
        Log.d("AndroidLayout", "click");
    }

}