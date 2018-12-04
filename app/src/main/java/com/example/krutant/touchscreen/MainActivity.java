package com.example.krutant.touchscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting reference to PaintView
        PaintView paintView = (PaintView)findViewById(R.id.paint_view);

        // Getting reference to TextView tv_cooridinate
        TextView tvCoordinates = (TextView)findViewById(R.id.tv_coordinates);

        // Passing reference of textview to PaintView object to update on coordinate changes
        paintView.setTextView(tvCoordinates);

        // Setting touch event listener for the PaintView
        paintView.setOnTouchListener(paintView);

        Button but = (Button)findViewById(R.id.button);
        Button but2 = (Button)findViewById(R.id.button2);
        but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent into = new Intent(MainActivity.this,Maniac.class);
                startActivity(into);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent into2 = new Intent(MainActivity.this,Multiple.class);
                startActivity(into2);
            }
        });

    }


}