package com.ttyooyu.market.ui.widget.expandrecyclerview.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ttyooyu.market.data.entity.Soul;

/**
 * Created by jwen on 2016-07-08.
 */
public abstract class BaseViewHolder<V extends Soul>  extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void bindItem(Context context, V v);
}
