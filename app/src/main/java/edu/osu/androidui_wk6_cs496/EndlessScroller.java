package edu.osu.androidui_wk6_cs496;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * File: EndlessScroller.java
 * Author: "Chris Kirchner" (transcribed form source below)
 * Description: loads more data on scrolling
 * Class: CS496
 * Email: kirchnch@oregonstate.edu
 */

//endless scroller with help
//http://android-pratap.blogspot.com/2015/01/endless-recyclerview-onscrolllistener.html

public abstract class EndlessScroller extends RecyclerView.OnScrollListener {

    private int prevTotal = 0;
    private boolean loading = true;
    //load more when there is 10 visible elements remaining
    private int visibleThreshold = 10;
    int first, visible, total;
    //keep track of pages
    private int current_page = 1;
    private GridLayoutManager glm;

    //construct scroller with grid layout manager
    public EndlessScroller(GridLayoutManager glm){
        this.glm = glm;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy){
        super.onScrolled(recyclerView, dx, dy);

        //get counts of visible elements
        visible = recyclerView.getChildCount();
        //get count of total elements
        total = glm.getItemCount();
        //get the index of first visible element
        first = glm.findFirstVisibleItemPosition();

        //reset loading when more elements are added
        if (loading){
            if (total > prevTotal){
                loading = false;
                prevTotal = total;
            }
        }
        //load more contents when threshold of un-scrolled elements is reached
        if (!loading && (total - visible) <= (first+visibleThreshold)){
            current_page++;
            onLoadMore(current_page);
            //reset loading
            loading = true;
        }
    }

    //override in activity
    public abstract void onLoadMore(int current_page);

}
