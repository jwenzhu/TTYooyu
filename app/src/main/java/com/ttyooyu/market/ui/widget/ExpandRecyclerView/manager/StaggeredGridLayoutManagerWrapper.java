package com.ttyooyu.market.ui.widget.expandrecyclerview.manager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

/**
 * author: Jwen
 * date:2016-09-27.
 */
public class StaggeredGridLayoutManagerWrapper extends StaggeredGridLayoutManager {

    public StaggeredGridLayoutManagerWrapper(int spanCount, int orientation) {
        super(spanCount, orientation);
    }

    public StaggeredGridLayoutManagerWrapper(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        }catch (IndexOutOfBoundsException  e){
            e.printStackTrace();
        }
    }
}
