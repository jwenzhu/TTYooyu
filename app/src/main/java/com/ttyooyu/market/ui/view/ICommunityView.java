package com.ttyooyu.market.ui.view;

import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.ui.view.base.IBaseView;

import java.util.List;

/**
 * Created by Administrator on 2016-08-25.
 */
public interface ICommunityView extends IBaseView{

    /**
     * @param products
     */
    void fillCommunityData(List<Product> products);
}
