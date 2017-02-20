package edu.osu.androidui_wk6_cs496;

/**
 * File: MainActivity.java
 * Author: Chris Kirchner
 * Description: construct horizontal of linear layout of radio images programmatically
 * (not-hardcoded)
 * Class: CS496
 * Email: kirchnch@oregonstate.edu
 */

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.util.Xml;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.xmlpull.v1.XmlPullParser;

import java.util.Random;

public class RadioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create linear layout
        LinearLayout ll = new LinearLayout(this);
        //set horizontal orientation
        ll.setOrientation(LinearLayout.HORIZONTAL);
        //add linear layout to content view
        setContentView(ll);

        //set randomly colored radio images horizontally
        Random r = new Random();
        for (int i=0; i<5; i++){
            //make new image view
            ImageView iv = new ImageView(this);
            //even layout images
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    0.2f
            );
            //set layout param
            iv.setLayoutParams(lp);
            //set image resource
            iv.setImageResource(R.mipmap.radio_checked);
            //set random color filter
            iv.setColorFilter(Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
            //add image view to linear layout
            ll.addView(iv);
        }

        //previous hardcoded layout
//        ImageView iv1 = (ImageView) findViewById(R.id.radioImg1);
//        ImageView iv2 = (ImageView) findViewById(R.id.radioImg2);
//        ImageView iv3 = (ImageView) findViewById(R.id.radioImg3);
//        ImageView iv4 = (ImageView) findViewById(R.id.radioImg4);
//
//        iv1.setColorFilter(Color.rgb(
//                r.nextInt(256),
//                r.nextInt(256),
//                r.nextInt(256))
//        );
//
//        iv2.setColorFilter(Color.rgb(
//                r.nextInt(256),
//                r.nextInt(256),
//                r.nextInt(256))
//        );
//
//        iv3.setColorFilter(Color.rgb(
//                r.nextInt(256),
//                r.nextInt(256),
//                r.nextInt(256))
//        );
//
//        iv4.setColorFilter(Color.rgb(
//                r.nextInt(256),
//                r.nextInt(256),
//                r.nextInt(256))
//        );
    }
}
