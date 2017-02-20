package edu.osu.androidui_wk6_cs496;

/**
 * File: FlameActivity.java
 * Author: Chris Kirchner
 * Description: displays hardcoded flames in a vertical linear layout
 * Class: CS496
 * Email: kirchnch@oregonstate.edu
 */

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.Random;

public class FlameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flame);

        Random r = new Random();

        //get hardcoded image views
        ImageView iv1 = (ImageView) findViewById(R.id.flameImg1);
        ImageView iv2 = (ImageView) findViewById(R.id.flameImg2);
        ImageView iv3 = (ImageView) findViewById(R.id.flameImg3);
        ImageView iv4 = (ImageView) findViewById(R.id.flameImg4);
        ImageView iv5 = (ImageView) findViewById(R.id.flameImg5);

        //set random color filters on images
        iv1.setColorFilter(Color.rgb(
                r.nextInt(256),
                r.nextInt(256),
                r.nextInt(256))
        );

        iv2.setColorFilter(Color.rgb(
                r.nextInt(256),
                r.nextInt(256),
                r.nextInt(256))
        );

        iv3.setColorFilter(Color.rgb(
                r.nextInt(256),
                r.nextInt(256),
                r.nextInt(256))
        );

        iv4.setColorFilter(Color.rgb(
                r.nextInt(256),
                r.nextInt(256),
                r.nextInt(256))
        );
        iv5.setColorFilter(Color.rgb(
                r.nextInt(256),
                r.nextInt(256),
                r.nextInt(256))
        );
    }

}
