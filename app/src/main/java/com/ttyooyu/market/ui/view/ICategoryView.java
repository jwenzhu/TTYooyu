package com.ttyooyu.market.ui.view;

import com.ttyooyu.market.data.entity.Category;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.ui.view.base.IBaseView;
import com.ttyooyu.market.ui.view.base.ISwipeRefreshView;

import java.util.List;

/**
 * Created by Administrator on 2016-08-25.
 */
public interface ICategoryView extends IBaseView{

    /**
     * @param categories
     */
    void fillCategoryData(List<Category> categories);
    /**
     * @param products
     */
    void fillProductData(List<Product> products);
}
