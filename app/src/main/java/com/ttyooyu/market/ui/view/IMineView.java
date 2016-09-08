package com.ttyooyu.market.ui.view;

import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.data.entity.Tool;
import com.ttyooyu.market.data.entity.User;
import com.ttyooyu.market.ui.view.base.IBaseView;

import java.util.List;

/**
 * Created by Administrator on 2016-08-25.
 */
public interface IMineView extends IBaseView{

    /**
     * @param user
     */
    void fillUserData(User user);
    /**
     * @param tools
     */
    void fillToolsData(List<Tool> tools);
}
