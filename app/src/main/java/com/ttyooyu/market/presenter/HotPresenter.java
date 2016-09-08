package com.ttyooyu.market.presenter;

import android.app.Activity;

import com.ttyooyu.market.data.entity.Community;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.presenter.base.BasePresenter;
import com.ttyooyu.market.ui.view.IHotView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-25.
 */
public class HotPresenter extends BasePresenter<IHotView> {

    public HotPresenter(Activity context, IHotView view) {
        super(context, view);
    }


    public void getDiscussionData(){
        List<Community> communityList = new ArrayList<>();
        for(int i = 0;i < 20;i++){
            Community community = new Community();
            communityList.add(community);
        }
        mView.fillDiscussionData(communityList);
    }
}
