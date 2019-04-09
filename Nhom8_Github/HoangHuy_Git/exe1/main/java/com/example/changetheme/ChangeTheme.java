package com.example.changetheme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class ChangeTheme extends AppCompatActivity {

    Button blackbutton, bluebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themeUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        setcontrol();
    }

    public void setcontrol()
    {
        blackbutton = (Button) findViewById(R.id.blackbutton);
        bluebutton = (Button) findViewById(R.id.bluebutton);
    }


    public void onClick(View v)

    {

        switch (v.getId())
        {
            case R.id.blackbutton:

                themeUtils.changeToTheme(this, themeUtils.BLACK);

                break;

            case R.id.bluebutton:

                themeUtils.changeToTheme(this, themeUtils.BLUE);

                break;

        }
    }
}
