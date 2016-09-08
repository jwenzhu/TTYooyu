package com.ttyooyu.market.presenter;

import android.app.Activity;

import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.presenter.base.BasePresenter;
import com.ttyooyu.market.ui.view.ICommunityView;
import com.ttyooyu.market.ui.view.IHomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-25.
 */
public class CommunityPresenter extends BasePresenter<ICommunityView> {

    public CommunityPresenter(Activity context, ICommunityView view) {
        super(context, view);
    }


    public void getCommunityData(){
        List<Product> productList = new ArrayList<>();
        for(int i = 0;i < 20;i++){
            Product product = new Product("秋刀鱼","18.8");
            productList.add(product);
        }
        mView.fillCommunityData(productList);
    }
}
