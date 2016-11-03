package com.ttyooyu.market.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ttyooyu.market.R;
import com.ttyooyu.market.presenter.HomeTabPresenter;
import com.ttyooyu.market.ui.activity.base.BaseActivity;
import com.ttyooyu.market.ui.fragment.CartFragment;
import com.ttyooyu.market.ui.fragment.CategoryFragment;
import com.ttyooyu.market.ui.fragment.CommunityFragment;
import com.ttyooyu.market.ui.fragment.MainFragment;
import com.ttyooyu.market.ui.fragment.PersonalFragment;
import com.ttyooyu.market.ui.view.IHomeTabView;
import com.ttyooyu.market.ui.widget.HomeMenuRelativeLayout;
import com.ttyooyu.market.ui.widget.popmenu.PopMenu;
import com.ttyooyu.market.ui.widget.popmenu.PopMenuItem;
import com.ttyooyu.market.ui.widget.popmenu.PopMenuItemListener;

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
    LinearLayout vPublish;
    HomeMenuRelativeLayout vHome;
    HomeMenuRelativeLayout vCategory;
    HomeMenuRelativeLayout vCommunity;
    HomeMenuRelativeLayout vCart;
    HomeMenuRelativeLayout vMine;
    @Override
    public void initView() {
        vPublish = (LinearLayout) findViewById(R.id.ll_publish);
        vHome = (HomeMenuRelativeLayout) findViewById(R.id.rl_home);
        vCategory = (HomeMenuRelativeLayout) findViewById(R.id.rl_category);
        vCommunity = (HomeMenuRelativeLayout) findViewById(R.id.rl_community);
        vCart = (HomeMenuRelativeLayout) findViewById(R.id.rl_cart);
        vMine = (HomeMenuRelativeLayout) findViewById(R.id.rl_mine);
        initPopWindowMenu();
        registerOnClick();
    }
    private PopMenu mPopMenu;
    private void initPopWindowMenu() {
        mPopMenu = new PopMenu.Builder().attachToActivity(HomeTabActivity.this)
                .addMenuItem(new PopMenuItem("文字", getResources().getDrawable(R.mipmap.icon_compose_idea)))
                .addMenuItem(new PopMenuItem("照片/视频", getResources().getDrawable(R.mipmap.icon_compose_photo)))
                .addMenuItem(new PopMenuItem("头条文章", getResources().getDrawable(R.mipmap.icon_compose_headlines)))
                .addMenuItem(new PopMenuItem("签到", getResources().getDrawable(R.mipmap.icon_compose_lbs)))
                .addMenuItem(new PopMenuItem("点评", getResources().getDrawable(R.mipmap.icon_compose_review)))
                .addMenuItem(new PopMenuItem("更多", getResources().getDrawable(R.mipmap.icon_compose_more)))
                .setOnItemClickListener(new PopMenuItemListener() {
                    @Override
                    public void onItemClick(PopMenu popMenu, int position) {
                        Toast.makeText(HomeTabActivity.this, "你点击了第" + position + "个位置", Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    private void registerOnClick() {
        MainFragment mainFragment = new MainFragment();
        mFragmentManager.beginTransaction().add(R.id.fragment_content,mainFragment).show(mainFragment).commit();
        mFragmentList.add(mainFragment);
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
        vPublish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_publish:
                if (!mPopMenu.isShowing()) {
                    mPopMenu.show();
                }
                break;
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
                if(vMenu.equals(vCommunity)){
                    vPublish.setVisibility(View.VISIBLE);
                }else{
                    vPublish.setVisibility(View.GONE);
                }
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
