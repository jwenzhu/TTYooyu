package com.ttyooyu.market.ui.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ttyooyu.market.R;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.presenter.HomePresenter;
import com.ttyooyu.market.ui.adapter.HomeAdapter;
import com.ttyooyu.market.ui.adapter.MyPageAdapter;
import com.ttyooyu.market.ui.adapter.base.GridLayoutManagerWrapper;
import com.ttyooyu.market.ui.fragment.base.BaseSwipeRefreshFragment;
import com.ttyooyu.market.ui.view.IHomeView;

import java.util.List;


/**
 * author: Jwen
 * date:2016-08-31.
 */
public class HomeFragment extends BaseSwipeRefreshFragment<HomePresenter> implements IHomeView{


    @Override
    protected void onRefreshStarted() {

    }

    View view;
    @Override
    protected View getLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    protected void initPresenter() {
        mPresenter = new HomePresenter(getActivity(),this);
    }

    @Override
    protected void requestData() {
        mPresenter.getHomeData();
    }

    RelativeLayout vTop;
    @Override
    protected void initView() {
        vTop = (RelativeLayout) view.findViewById(R.id.layout_top);
        initRecyclerView();
    }

    RecyclerView vRecyclerView;
    HomeAdapter mAdapter;
    private void initRecyclerView() {
        vRecyclerView = (RecyclerView) view.findViewById(R.id.rv_home);
        vRecyclerView.setLayoutManager(new GridLayoutManagerWrapper(getActivity(),2));
        mAdapter = new HomeAdapter(getActivity());
        vRecyclerView.setAdapter(mAdapter);
        mAdapter.setHeaderView(initHeaderView());
        vRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int totalY = 0;
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalY += dy;
                Drawable drawable = getResources().getDrawable(R.drawable.shape_rectangle_gray);
                drawable.setAlpha(totalY/1000);
                vTop.setBackgroundDrawable(drawable);
            }
        });
    }
    ViewPager viewPager;
    ViewGroup viewGroup;
    private View initHeaderView() {
        View viewHeader = LayoutInflater.from(getActivity()).inflate(R.layout.layout_header_home,null);
        viewPager = (ViewPager) viewHeader.findViewById(R.id.viewPager);
        viewGroup = (ViewGroup) viewHeader.findViewById(R.id.viewGroup);

        fillViewPageData();
        return viewHeader;
    }


    private void fillViewPageData() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT);
        ImageView[] imageViews = new ImageView[5];
        for(int i = 0; i < imageViews.length;i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageDrawable(getResources().getDrawable(R.mipmap.icon_temp0));
            imageView.setLayoutParams(params);
            imageViews[i] = imageView;
        }
        viewPager.setAdapter(new MyPageAdapter<>(imageViews, getActivity(), viewPager, viewGroup));
    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showErrorView(Throwable throwable) {

    }

    @Override
    public void fillHomeData(List<Product> products) {
        mAdapter.updateWithClear(products);
    }
}
