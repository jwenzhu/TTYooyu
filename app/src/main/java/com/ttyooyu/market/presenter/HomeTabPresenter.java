package com.ttyooyu.market.presenter;

import android.app.Activity;

import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.presenter.base.BasePresenter;
import com.ttyooyu.market.ui.view.IHomeTabView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-25.
 */
public class HomeTabPresenter  extends BasePresenter<IHomeTabView> {

    public HomeTabPresenter(Activity context, IHomeTabView view) {
        super(context, view);
    }


}
