package com.ttyooyu.market.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ttyooyu.market.R;
import com.ttyooyu.market.data.entity.Category;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.presenter.CommunityPresenter;
import com.ttyooyu.market.ui.adapter.CommunityAdapter;
import com.ttyooyu.market.ui.fragment.base.BaseFragment;
import com.ttyooyu.market.ui.view.ICommunityView;
import com.ttyooyu.market.ui.widget.PagerTabHorizontalScrollView;

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
        initTest();
        initViewPager();
    }
    PagerTabHorizontalScrollView vHorizontalScrollView;
    private void initTest() {
        vHorizontalScrollView = (PagerTabHorizontalScrollView) view.findViewById(R.id.msv_test);
    }


    private void initViewPager() {

        List<Category> mDataList = new ArrayList<>();
        Map<Integer,Fragment> mFragments= new HashMap<Integer,Fragment>();
        for(int i = 0;i < 8;i++){
            mFragments.put(i, new HotFragment());
            mDataList.add(new Category(getResources().getDrawable(R.mipmap.icon_temp6),getString(R.string.app_temp_freshwater)));
        }
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.id_viewpager);
        mViewPager.setAdapter(new CommunityAdapter(getActivity().getSupportFragmentManager(),mFragments,mDataList));
        vHorizontalScrollView.setViewPager(mViewPager,mDataList);
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
