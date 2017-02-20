package edu.osu.androidui_wk6_cs496;

/**
 * File: GamepadAcitivty.java
 * Author: Chris Kirchner
 * Description: displays randomly colored game pads in random position on screen
 * Class: CS496
 * Email: kirchnch@oregonstate.edu
 */

import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class GamepadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamepad);

        Random r = new Random();

        //http://stackoverflow.com/questions/9575706/android-get-height-of-a-view-before-it%C2%B4s-drawn/10134260#10134260
        //setup relative layout to absolutely position images
        //absolute layout is deprecated
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.gamepadLayout);

        //set image dimensions
        int width = 200;
        int height = 200;
        for (int i=0; i<50; i++){
            ImageView iv = new ImageView(this);
            //http://stackoverflow.com/questions/3294590/set-the-absolute-position-of-a-view
            iv.setImageResource(R.mipmap.gamepad);
            RelativeLayout.LayoutParams lp =
                    new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT
                    );

            //http://stackoverflow.com/questions/1016896/get-screen-dimensions-in-pixels
            //display unfortunately gives device display and not application window display
            //so some image shrink on boundaries
            Display d = getWindowManager().getDefaultDisplay();
            Point p = new Point();
            d.getSize(p);
            lp.leftMargin = r.nextInt((p.x+1)-(3*width/2)) + width/2;
            lp.topMargin = r.nextInt((p.y+1)-(3*height/2)) + height/2;
            iv.setColorFilter(Color.rgb(
                    r.nextInt(256), r.nextInt(256), r.nextInt(256)
            ));
            rl.addView(iv, lp);
        }

    }
}
