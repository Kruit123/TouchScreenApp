package com.example.krutant.touchscreen;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class TouchView extends View implements View.OnTouchListener {

    private float x;
    private float y;
    TextView mTVCoordinates;
    Paint drawPaint;
    private Path path = new Path();

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTVCoordinates = null;
        drawPaint = new Paint(Paint.DITHER_FLAG);
        drawPaint.setAntiAlias(true);
        drawPaint.setColor(Color.parseColor("#5D4037"));
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeWidth(3);
        setWillNotDraw(false);
    }

    @Override
    protected void onSizeChanged(int w, int h, int width, int height) {
        super.onSizeChanged(w, h, width, height);
    }
    public void setTextView(TextView tv) {
        // Reference to TextView Object
        mTVCoordinates = tv;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, drawPaint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        int pointerIndex = event.getActionIndex();
        // ...which we can use to find the pointer ID!
        int id = event.getPointerId(pointerIndex);
        //float id = event.getPointerId(0);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                if (mTVCoordinates != null) {
                    mTVCoordinates.setText("ID :" +id+ " , " + "X :" + x + " , " + "Y :" + y);
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                if (mTVCoordinates != null) {
                    mTVCoordinates.setText("ID :" +id+ " , " +"X :" + x + " , " + "Y :" + y);
                }
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }
}