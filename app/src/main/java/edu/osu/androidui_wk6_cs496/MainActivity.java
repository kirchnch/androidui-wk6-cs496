package edu.osu.androidui_wk6_cs496;

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

        ImageButton btn_flame = (ImageButton) findViewById(R.id.btn_flame);
        ImageButton btn_radio = (ImageButton) findViewById(R.id.btn_radio);
        ImageButton btn_gamepad = (ImageButton) findViewById(R.id.btn_gamepad);
        ImageButton btn_settings = (ImageButton) findViewById(R.id.btn_settings);

        btn_flame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, FlameActivity.class);
                startActivity(intent);
            }
        });
    }
}
