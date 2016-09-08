package com.ttyooyu.market.ui.adapter.base;

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
