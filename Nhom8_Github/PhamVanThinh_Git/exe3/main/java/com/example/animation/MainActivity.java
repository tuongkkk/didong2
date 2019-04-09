package com.example.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import static com.example.animation.R.id.btnRotate;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = (ImageView) findViewById(R.id.ivImage);
        btn = (Button) findViewById(R.id.btnRotate);

        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.move);
        //drawable animation
        imgView.setBackgroundResource(R.drawable.trump_walk);
        final AnimationDrawable animationDrawable = (AnimationDrawable) imgView.getBackground();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.stop();


            }
        });
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.start();
                imgView.startAnimation(animation);
            }
        });
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgView.startAnimation(animation);
//            }
//        });

    }

}
