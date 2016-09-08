package com.ttyooyu.market.ui.view;

import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.ui.view.base.IBaseView;
import com.ttyooyu.market.ui.view.base.ISwipeRefreshView;

import java.util.List;

/**
 * Created by Administrator on 2016-08-25.
 */
public interface IHomeView extends IBaseView{

    /**
     * @param products
     */
    void fillHomeData(List<Product> products);
}
