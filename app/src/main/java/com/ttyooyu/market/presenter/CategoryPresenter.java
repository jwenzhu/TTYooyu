package com.ttyooyu.market.presenter;

import android.app.Activity;
import android.util.Log;

import com.ttyooyu.market.data.entity.Category;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.presenter.base.BasePresenter;
import com.ttyooyu.market.ui.view.ICategoryView;
import com.ttyooyu.market.ui.view.IHomeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016-08-25.
 */
public class CategoryPresenter extends BasePresenter<ICategoryView> {

    public CategoryPresenter(Activity context, ICategoryView view) {
        super(context, view);
    }


    public void getCategoryData(){
        List<Category> categories = new ArrayList<>();
        for(int i = 0;i < 20;i++){
            Category product = new Category(i,"秋刀鱼");
            categories.add(product);
        }
        mView.fillCategoryData(categories);
    }
    public void getProductData(){
        List<Product> products = new ArrayList<>();
        for(int i = 0;i < 20;i++){
            int random = new Random().nextInt(2);
            Product product = new Product("秋刀鱼","18.8",random);
            products.add(product);
        }
        mView.fillProductData(products);
    }
}
