package vn.edu.tdc.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDown = (Button)findViewById(R.id.btn_down);
        Button btnUp = (Button)findViewById(R.id.btn_up);

        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDownAnimator();
            }
        });
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpAnimator();
            }
        });
    }

    private void setDownAnimator() {
        TextView textAnimation = (TextView)findViewById(R.id.tw);
        textAnimation.animate().rotation(360f).y(500).setDuration(2000);
    }

    private void setUpAnimator() {
        TextView textAnimation = (TextView)findViewById(R.id.tw);
        textAnimation.animate().rotation(720f).y(100f).setDuration(2000);
    }
}
