package com.ttyooyu.market.ui.fragment;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ttyooyu.market.R;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.presenter.MainPresenter;
import com.ttyooyu.market.ui.adapter.MainAdapter;
import com.ttyooyu.market.ui.adapter.MyPageAdapter;
import com.ttyooyu.market.ui.widget.expandrecyclerview.manager.GridLayoutManagerWrapper;
import com.ttyooyu.market.ui.fragment.base.BaseSwipeRefreshFragment;
import com.ttyooyu.market.ui.view.IMainView;

import java.util.List;


/**
 * author: Jwen
 * date:2016-08-31.
 */
public class MainFragment extends BaseSwipeRefreshFragment<MainPresenter> implements IMainView {

    private float mTransparent = 0f;

    @Override
    protected void onRefreshStarted() {

    }

    View view;
    @Override
    protected View getLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    protected void initPresenter() {
        mPresenter = new MainPresenter(getActivity(),this);
    }

    @Override
    protected void requestData() {
        mPresenter.getHomeData();
    }

    ImageView vTopBg;
    ImageView vMessage;
    ImageView vScam;
    TextView vAdvertisement;
    @Override
    protected void initView() {
        vTopBg = (ImageView) view.findViewById(R.id.iv_bg);
        vTopBg.setAlpha(mTransparent);
        vMessage = (ImageView) view.findViewById(R.id.iv_message);
        vMessage.setSelected(true);
        vScam = (ImageView) view.findViewById(R.id.iv_scan);
        vScam.setSelected(true);
        vAdvertisement = (TextView) view.findViewById(R.id.iv_advertisement);
        vAdvertisement.setText("来自中国的金鱼");
        initRecyclerView();
    }

    RecyclerView vRecyclerView;
    MainAdapter mAdapter;
    private void initRecyclerView() {
        vRecyclerView = (RecyclerView) view.findViewById(R.id.rv_home);
        vRecyclerView.setLayoutManager(new GridLayoutManagerWrapper(getActivity(),2));
        mAdapter = new MainAdapter(getActivity());
        vRecyclerView.setAdapter(mAdapter);
        mAdapter.setHeaderView(initHeaderView());
        vRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int totalY = 0;
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalY += dy;
                mTransparent = totalY/300f;
                vTopBg.setAlpha(mTransparent);
                if(mTransparent > 0.8f){
                    vMessage.setSelected(false);
                    vScam.setSelected(false);
                }else{
                    vMessage.setSelected(true);
                    vScam.setSelected(true);
                }
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