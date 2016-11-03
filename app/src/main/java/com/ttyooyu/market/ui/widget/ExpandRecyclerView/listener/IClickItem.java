package com.ttyooyu.market.ui.widget.expandrecyclerview.listener;

import android.view.View;

/**
 * Created by Administrator on 2016-07-08.
 */
public interface IClickItem<T> {

    /**
     * item click
     */
    void onClickItem(T t, View view);
}
