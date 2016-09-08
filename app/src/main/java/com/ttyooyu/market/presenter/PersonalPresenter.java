package com.ttyooyu.market.presenter;

import android.app.Activity;

import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.data.entity.Tool;
import com.ttyooyu.market.data.entity.User;
import com.ttyooyu.market.presenter.base.BasePresenter;
import com.ttyooyu.market.ui.view.IHomeView;
import com.ttyooyu.market.ui.view.IMineView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-25.
 */
public class PersonalPresenter extends BasePresenter<IMineView> {

    public PersonalPresenter(Activity context, IMineView view) {
        super(context, view);
    }


    public void getUserData(){
        User user  = new User();
        mView.fillUserData(user);
    }
    public void getUserTools(){
        List<Tool> toolList = new ArrayList<>();
        for(int i = 0; i < 11;i++){
            toolList.add(new Tool());
        }
        mView.fillToolsData(toolList);
    }
}
