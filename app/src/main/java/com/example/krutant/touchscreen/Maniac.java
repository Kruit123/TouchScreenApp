package com.example.krutant.touchscreen;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.View;

public class Maniac extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        TouchView touchView = (TouchView)findViewById(R.id.touch_view);
        TextView tvCoordinates = (TextView)findViewById(R.id.instruction);
        touchView.setTextView(tvCoordinates);
        touchView.setOnTouchListener(touchView);
    }

}