package com.demo.demo01;

import java.io.InputStream;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyView extends View {

	Paint mPaint;
	Context mContext;
	
	public MyView(Context context) {
		super(context);
		mPaint = new Paint();
		// TODO Auto-generated constructor stub
	}

	public MyView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		mPaint = new Paint();
		
		
		
	}

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mPaint = new Paint();
		//TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyView);
	}
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Log.i("View大小", this.getHeight()+","+this.getWidth());
		mPaint.setColor(Color.BLUE);
		
		mPaint.setAntiAlias(true);
		mPaint.setTextSize(18);
		canvas.drawColor(Color.BLACK);
		canvas.drawText("hello world", 20, 20, mPaint);
		canvas.drawBitmap(UseBitmapDrawable(R.drawable.a), 30, 40, mPaint);
		
		canvas.drawLine(20, 20, getWidth(), getHeight(), mPaint);
		
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	
	}
	
	
	//用BitmapFactory解析图片
	private Bitmap UseBitmapFactory (int id){
		InputStream in = getResources().openRawResource(id);
		Bitmap bitmap = BitmapFactory.decodeStream(in);
		
		return bitmap;
	}
	
	//用BitmapDrawable解析图片
	private Bitmap UseBitmapDrawable(int id){
		Bitmap bitmap = null;
		BitmapDrawable bd = (BitmapDrawable) getResources().getDrawable(id);
		bitmap = bd.getBitmap();
		return bitmap;
		
	}
	
	 //  使用InputStream和BitmapDrawable解析图片
	private Bitmap UseInputStreamandBitmapDrawable(int id){
		Bitmap bitmap = null;
		InputStream in = getResources().openRawResource(id);
		BitmapDrawable bd = new BitmapDrawable(in);
		bitmap = bd.getBitmap();
		return bitmap;
		
	}
	
	

}
