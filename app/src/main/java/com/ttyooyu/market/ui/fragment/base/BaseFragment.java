package com.ttyooyu.market.ui.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ttyooyu.market.presenter.base.BasePresenter;


/**
 * Created by Administrator on 2016-06-28.
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    protected P mPresenter;


    /**
     * 获取布局
     */
    protected abstract View getLayout(LayoutInflater inflater, ViewGroup container);

    /**
     * 初始化控制器
     */
    protected abstract void initPresenter();

    /**
     * 获取数据
     */
    protected abstract void requestData();

    /**
     * 初始化view
     */
    protected abstract void initView();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayout(inflater,container);
        initView();
        requestData();
        return view;
    }


}
