package edu.osu.androidui_wk6_cs496;

/**
 * File: CogActivity.java
 * Author: Chris Kirchner
 * Description: displays randomly colored cogs in a recycle view using a grid layout
 * Class: CS496
 * Email: kirchnch@oregonstate.edu
 */

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Random;

//With help from:
//http://www.vogella.com/tutorials/AndroidRecyclerView/article.html

public class CogActivity extends AppCompatActivity {

    //create private variables
    private RecyclerView recyclerView;
    private RecyclerView.Adapter imgAdapter;
    private RecyclerView.LayoutManager gridLayoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //use recycleview in activity layout
        setContentView(R.layout.activity_cog);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //improve performance by giving a known set size
//        recyclerView.setHasFixedSize(true);

        //randomize colors
        Random r = new Random();
        ArrayList<Integer> colors = new ArrayList<>();
        for (int i=0; i<100; i++){
            colors.add(Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        }

        //setup a grid layout
        gridLayoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(gridLayoutManager);



        //setup custom adapter and set to recycle viewer
        ImageAdapter imgAdapter = new ImageAdapter(colors);
        recyclerView.setAdapter(imgAdapter);

        //with help from: http://android-pratap.blogspot.com/2015/01/endless-recyclerview-onscrolllistener.html
        recyclerView.addOnScrollListener(
                new EndlessScroller((GridLayoutManager) gridLayoutManager) {
                    @Override
                    public void onLoadMore(int current_page) {

                        //get image adapter from recycle view
                        ImageAdapter imgAdapter = (ImageAdapter) recyclerView.getAdapter();
                        //get back the list of colors
                        ArrayList<Integer> colors = imgAdapter.getColors();
                        //add to the list of colors
                        Random r = new Random();
                        for (int i=0; i<100; i++){
                            colors.add(Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
                        }
                        //set list of old and additional colors
                        imgAdapter.setColors(colors);
                        //notify the adapter of data change to send to manager
                        imgAdapter.notifyDataSetChanged();

                    }
                });
    }

}
