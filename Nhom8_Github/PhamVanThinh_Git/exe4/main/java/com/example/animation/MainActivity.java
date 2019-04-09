package com.example.animation;

import android.graphics.drawable.AnimationDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

//import static com.example.animation.R.id.btnRotate;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;
    Button btn;
    ToggleButton tbSound;
    int streamID = -1;
    int stream1,stream2;

    private SoundPool soundPool;
    private int sound1, sound2, sound3,sound4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //animation
        imgView = (ImageView) findViewById(R.id.ivImage);
        //btn = (Button) findViewById(R.id.btnRotate);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.move);
        //drawable animation
        imgView.setBackgroundResource(R.drawable.trump_walk);
        final AnimationDrawable animationDrawable = (AnimationDrawable) imgView.getBackground();

        //togglebutton
        tbSound = (ToggleButton) findViewById(R.id.tbSound);
        tbSound.setChecked(false);


        tbSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (tbSound.isChecked() == true)
                {
                    animationDrawable.start();
                    //streamID = soundPool.play(sound1,1,1,1,1,1f);

                    //soundPool.play(sound1,1,1,0,-1,1f);
                    stream1 = soundPool.play(sound2,1,1,0,-1,1f);
                }else
                {
                    animationDrawable.stop();
                    soundPool.pause(stream1);
                    //soundPool.pause(sound1);
                    //soundPool.autoPause();
                }
            }
        });
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stream2= soundPool.play(sound3,1,1,0,0,1f);
            }
        });


        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP)
        {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(3)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }else
        {
            soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC,0);
        }

        //load nhac
        sound1 = soundPool.load(this,R.raw.windhowl01,1);
        sound2 = soundPool.load(this,R.raw.footsteps3,1);
        sound3 = soundPool.load(this,R.raw.manlaughing04,1);
//        btn.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                animationDrawable.stop();
////
////
////            }
////        });
////        imgView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                animationDrawable.start();
////                //imgView.startAnimation(animation);
////            }
////        });
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgView.startAnimation(animation);
//            }
//        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }

    public void ini()
    {

    }

}
