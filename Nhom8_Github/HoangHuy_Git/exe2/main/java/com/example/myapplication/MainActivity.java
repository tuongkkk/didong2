package com.example.myapplication;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    DrawingView drawingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawingView = findViewById(R.id.canvas);
        drawingView.setOnTouchListener(new TouchListener());


    }

    public void setColor(View view) {
        ColorDrawable buttonColor = (ColorDrawable) view.getBackground();
        drawingView.setCurrentColor(buttonColor.getColor());
    }

    public void deleteDrawing(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        drawingView.erase();
        //AlertDialog dialog = builder.create();
        //dialog.show();
    }
}
