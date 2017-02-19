package edu.osu.androidui_wk6_cs496;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FlameActivity extends AppCompatActivity {

    String[] flames = {"blah", "eek", "oof"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flame);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        R.layout.textrow,
                        flames
                );

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);


    }
}
