package com.hktstudio.music;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.hktstudio.music.activities.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SlashActivity extends AppCompatActivity {
    Timer timer;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash);

        ImageView imageMusic = (ImageView)findViewById(R.id.imageMusic);
        @SuppressLint("ResourceType") AnimatorSet imageMusicSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.anim.action_image);
        imageMusicSet.setTarget(imageMusic);
        imageMusicSet.start();


        TextView text1 = (TextView) findViewById(R.id.tex1);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_right);
        text1.setAnimation(animation);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SlashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}
