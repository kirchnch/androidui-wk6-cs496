package edu.osu.androidui_wk6_cs496;

/**
 * File: MainActivity.java
 * Author: Chris Kirchner
 * Description: first page activity that links to four activities through buttons
 * Class: CS496
 * Email: kirchnch@oregonstate.edu
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get different buttons for each activity
        ImageButton btn_flame = (ImageButton) findViewById(R.id.btn_flame);
        ImageButton btn_radio = (ImageButton) findViewById(R.id.btn_radio);
        ImageButton btn_gamepad = (ImageButton) findViewById(R.id.btn_gamepad);
        ImageButton btn_cog = (ImageButton) findViewById(R.id.btn_cog);

        //set click event listeners to direct to specific activity for each button
        btn_flame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, FlameActivity.class);
                startActivity(intent);
            }
        });

        btn_radio.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, RadioActivity.class);
                startActivity(intent);
            }
        });

        btn_gamepad.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, GamepadActivity.class);
                startActivity(intent);
            }
        });
        btn_cog.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, CogActivity.class);
                startActivity(intent);
            }
        });
    }
}
