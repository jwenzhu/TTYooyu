package com.ttyooyu.market.ui.activity;

import android.view.View;

import com.ttyooyu.market.R;
import com.ttyooyu.market.presenter.HomeTab2Presenter;
import com.ttyooyu.market.ui.activity.base.BaseActivity;
import com.ttyooyu.market.ui.view.IHomeTab2View;

/**
 * author: Jwen
 * date:2016-10-27.
 */
public class HomeTab2Activity extends BaseActivity<HomeTab2Presenter> implements IHomeTab2View, View.OnClickListener {

    @Override
    public int getLayout() {
        return R.layout.activity_hometab2;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void requestData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void showErrorView(Throwable throwable) {

    }

    @Override
    public void getDataFinish() {

    }
}
