package com.ttyooyu.market.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.ttyooyu.market.R;
import com.ttyooyu.market.presenter.HomeTabPresenter;
import com.ttyooyu.market.ui.activity.base.BaseActivity;
import com.ttyooyu.market.ui.fragment.CartFragment;
import com.ttyooyu.market.ui.fragment.CategoryFragment;
import com.ttyooyu.market.ui.fragment.CommunityFragment;
import com.ttyooyu.market.ui.fragment.HomeFragment;
import com.ttyooyu.market.ui.fragment.PersonalFragment;
import com.ttyooyu.market.ui.view.IHomeTabView;
import com.ttyooyu.market.ui.widget.HomeMenuRelativeLayout;

import java.util.ArrayList;
import java.util.List;


public class HomeTabActivity extends BaseActivity<HomeTabPresenter> implements IHomeTabView, View.OnClickListener {


    private List<Fragment> mFragmentList = new ArrayList<>();
    private int mCurrentPosition = 0;
    private FragmentManager mFragmentManager;
    FragmentTransaction transaction;

    @Override
    public int getLayout() {
        return R.layout.activity_hometab;
    }


    @Override
    public void initPresenter() {
        mPresenter = new HomeTabPresenter(this,this);
        mFragmentManager = getSupportFragmentManager();
    }

    @Override
    public void requestData() {
    }
    HomeMenuRelativeLayout vHome;
    HomeMenuRelativeLayout vCategory;
    HomeMenuRelativeLayout vCommunity;
    HomeMenuRelativeLayout vCart;
    HomeMenuRelativeLayout vMine;
    @Override
    public void initView() {
        vHome = (HomeMenuRelativeLayout) findViewById(R.id.rl_home);
        vCategory = (HomeMenuRelativeLayout) findViewById(R.id.rl_category);
        vCommunity = (HomeMenuRelativeLayout) findViewById(R.id.rl_community);
        vCart = (HomeMenuRelativeLayout) findViewById(R.id.rl_cart);
        vMine = (HomeMenuRelativeLayout) findViewById(R.id.rl_mine);
        registerOnClick();
    }

    private void registerOnClick() {
        HomeFragment homeFragment = new HomeFragment();
        mFragmentManager.beginTransaction().add(R.id.fragment_content,homeFragment).show(homeFragment).commit();
        mFragmentList.add(homeFragment);
        mFragmentList.add(new CategoryFragment());
        mFragmentList.add(new CommunityFragment());
        mFragmentList.add(new CartFragment());
        mFragmentList.add(new PersonalFragment());
        vHome.setSelected(true);
        vHome.setOnClickListener(new MenuOnClickListener(0,vHome));
        vCategory.setOnClickListener(new MenuOnClickListener(1,vCategory));
        vCommunity.setOnClickListener(new MenuOnClickListener(2,vCommunity));
        vCart.setOnClickListener(new MenuOnClickListener(3,vCart));
        vMine.setOnClickListener(new MenuOnClickListener(4,vMine));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }

    @Override
    public void showErrorView(Throwable throwable) {

    }

    @Override
    public void getDataFinish() {

    }


    class MenuOnClickListener implements View.OnClickListener {

        private int mPosition;
        private HomeMenuRelativeLayout vMenu;
        public MenuOnClickListener(int position,HomeMenuRelativeLayout vMenu) {
            this.mPosition = position;
            this.vMenu = vMenu;
        }

        @Override
        public void onClick(View v) {
            if(mCurrentPosition != mPosition){
                vHome.setSelected(false);
                vCategory.setSelected(false);
                vCommunity.setSelected(false);
                vCart.setSelected(false);
                vMine.setSelected(false);
                vMenu.setSelected(true);
                Fragment fromFragment = mFragmentList.get(mCurrentPosition);
                Fragment toFragment = mFragmentList.get(mPosition);
                transaction = mFragmentManager.beginTransaction();
                if(toFragment.isAdded()){
                    transaction.hide(fromFragment).show(toFragment);
                }else{
                    transaction.hide(fromFragment).add(R.id.fragment_content,toFragment);
                }
                transaction.commit();
                mCurrentPosition = mPosition;
            }

        }
    }

}
