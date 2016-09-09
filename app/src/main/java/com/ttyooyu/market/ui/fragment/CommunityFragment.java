package com.ttyooyu.market.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ttyooyu.market.R;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.presenter.CommunityPresenter;
import com.ttyooyu.market.ui.adapter.CommunityAdapter;
import com.ttyooyu.market.ui.fragment.base.BaseFragment;
import com.ttyooyu.market.ui.view.ICommunityView;
import com.ttyooyu.market.ui.widget.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: Jwen
 * date:2016-08-31.
 */
public class CommunityFragment extends BaseFragment<CommunityPresenter> implements ICommunityView{

    View view;
    @Override
    protected View getLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_community, container, false);
        return view;
    }

    @Override
    protected void initPresenter() {
        mPresenter = new CommunityPresenter(getActivity(),this);
    }

    @Override
    protected void requestData() {
    }

    @Override
    protected void initView() {
        initTabs();

    }

    PagerSlidingTabStrip vTabs;
    private void initTabs() {
        vTabs = (PagerSlidingTabStrip) view.findViewById(R.id.id_indicator);
        vTabs.setBackgroundColor(getResources().getColor(R.color.colorBlue));
        vTabs.setTextColor(getResources().getColor(R.color.colorWhite));
        vTabs.setIndicatorColor(getResources().getColor(R.color.colorWhite));
        initViewPager();
    }
    private void initViewPager() {
        List<String> mDataList =new ArrayList<String>();
        mDataList.add(getString(R.string.app_temp_freshwater));
        mDataList.add(getString(R.string.app_temp_aquarium));
        mDataList.add(getString(R.string.app_temp_freshwater));
        mDataList.add(getString(R.string.app_temp_aquarium));
        mDataList.add(getString(R.string.app_temp_aquarium));
        mDataList.add(getString(R.string.app_temp_aquarium));
        Map<Integer,Fragment> mFragments= new HashMap<Integer,Fragment>();
        mFragments.put(0, new HotFragment());
        mFragments.put(1, new HotFragment());
        mFragments.put(2,  new HotFragment());
        mFragments.put(3, new HotFragment());
        mFragments.put(4, new HotFragment());
        mFragments.put(5, new HotFragment());

        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.id_viewpager);
        CommunityAdapter mAdapter = new CommunityAdapter(getActivity().getSupportFragmentManager(),mFragments,mDataList);
        mViewPager.setAdapter(mAdapter);
        vTabs.setViewPager(mViewPager);

    }

    @Override
    public void showErrorView(Throwable throwable) {

    }

    @Override
    public void getDataFinish() {

    }

    @Override
    public void fillCommunityData(List<Product> products) {
    }
}
