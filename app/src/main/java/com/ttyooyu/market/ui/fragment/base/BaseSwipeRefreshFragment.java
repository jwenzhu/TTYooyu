package com.ttyooyu.market.ui.fragment.base;

import android.support.annotation.CheckResult;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.ttyooyu.market.R;
import com.ttyooyu.market.presenter.base.BasePresenter;
import com.ttyooyu.market.ui.view.base.ISwipeRefreshView;


/**
 * Created by Administrator on 2016-06-28.
 */
public abstract class BaseSwipeRefreshFragment<P extends BasePresenter> extends BaseFragment<P> implements ISwipeRefreshView {


    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected  void initSwipeLayout(View view){
//        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (prepareRefresh()) {
                    onRefreshStarted();
                } else {
                    hideRefresh();
                }
            }
        });
    };

    /**
     * check data status
     */
    protected boolean prepareRefresh(){
        return true;
    }

    /**
     * the method of get data
     */
    protected abstract void onRefreshStarted();

    @Override
    public void hideRefresh() {
        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mSwipeRefreshLayout != null){
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        },1000);
    }

    @Override
    public void showRefresh() {
        if(mSwipeRefreshLayout !=null ){
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }

    /**
     * check refresh layout is refreshing
     */
    @CheckResult
    protected boolean isRefreshing(){
        return mSwipeRefreshLayout.isRefreshing();
    }

    @Override
    public void getDataFinish() {
        hideRefresh();
    }
}
