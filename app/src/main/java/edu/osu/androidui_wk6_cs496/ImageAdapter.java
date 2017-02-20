package edu.osu.androidui_wk6_cs496;

/**
 * File: ImageAdapter.java
 * Author: Chris Kirchner
 * Description: custom adapter to show images in recycle view
 * Class: CS496
 * Email: kirchnch@oregonstate.edu
 */

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;


//http://www.vogella.com/tutorials/AndroidRecyclerView/article.html
//https://developer.android.com/samples/RecyclerView/src/com.example.android.recyclerview/CustomAdapter.html

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    //hold an array of integer colors
    private ArrayList<Integer> myColors;

    //define view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgView;

        //set view holder so that resource is not constantly searched for
        public ViewHolder(View v){
            super(v);
            imgView = (ImageView) v.findViewById(R.id.imgItemView);
        }

        //return image view
        public ImageView getImgView(){
            return imgView;
        }
    }

    //constructor for image adapter using integer colors
    public ImageAdapter(ArrayList<Integer> imgColors) {
        myColors = imgColors;
    }

    //overrides onCreateViewHolder to inflate image views
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.img_item, parent, false);

        return new ViewHolder(v);
    }

    //overrides onBindViewHolder to bind item position resource to view
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position){
        //get color based on item index
        final int color = myColors.get(position);
        //create image view
        ImageView iv = viewHolder.getImgView();
        //set image resource
        iv.setImageResource(R.mipmap.settings);
        //set color filter
        iv.setColorFilter(color);
    }

    //return size of items
    @Override
    public int getItemCount(){
        return myColors.size();
    }

    public ArrayList<Integer> getColors(){
        return myColors;
    }

    public void setColors(ArrayList<Integer> colors){
        myColors = colors;
    }

}
