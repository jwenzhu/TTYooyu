package com.ttyooyu.market.ui.widget.expandrecyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * author: Jwen
 * date:2016-09-24.
 */
public class ExpandRecyclerView extends RecyclerView{

    public ExpandRecyclerView(Context context) {
        this(context,null);
    }

    public ExpandRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ExpandRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


}
