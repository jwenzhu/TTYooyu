package com.ttyooyu.market.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ttyooyu.market.R;
import com.ttyooyu.market.data.entity.Category;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.presenter.CategoryPresenter;
import com.ttyooyu.market.ui.adapter.CategoryAdapter;
import com.ttyooyu.market.ui.widget.expandrecyclerview.manager.LinearLayoutManagerWrapper;
import com.ttyooyu.market.ui.fragment.base.BaseFragment;
import com.ttyooyu.market.ui.view.ICategoryView;
import com.ttyooyu.market.ui.widget.CategoryScrollView;

import java.util.List;

/**
 * author: Jwen
 * date:2016-08-31.
 */
public class CategoryFragment extends BaseFragment<CategoryPresenter> implements ICategoryView{

    View view;
    @Override
    protected View getLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_category, container, false);
        return view;
    }

    @Override
    protected void initPresenter() {
        mPresenter = new CategoryPresenter(getActivity(),this);
    }

    @Override
    protected void requestData() {
        mPresenter.getCategoryData();
        mPresenter.getProductData();
    }

    TextView vAdvertisement;
    @Override
    protected void initView() {
        vAdvertisement = (TextView) view.findViewById(R.id.iv_advertisement);
        vAdvertisement.setText("来自中国的金鱼");
        initRecyclerView();
    }

    RecyclerView vRecyclerView;
    CategoryAdapter mAdapter;
    private void initRecyclerView() {
        LinearLayoutManagerWrapper layoutManager=new LinearLayoutManagerWrapper(getActivity());
        vRecyclerView = (RecyclerView) view.findViewById(R.id.rv_category);
        vRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new CategoryAdapter(getActivity());
        vRecyclerView.setAdapter(mAdapter);
    }
    private CategoryScrollView vScrollView;
    private void initScrollView(final List<Category> categoryList) {
        vScrollView=(CategoryScrollView) view.findViewById(R.id.category_scrollview);
        vScrollView.initScrollView(categoryList);
        vScrollView.setOnIClickListener(new CategoryScrollView.OnIClickListener() {
            @Override
            public void onIClickListener(int position) {
                mPresenter.getProductData();
            }
        });
    }
    @Override
    public void showErrorView(Throwable throwable) {

    }

    @Override
    public void getDataFinish() {

    }

    @Override
    public void fillCategoryData(List<Category> categories) {
        initScrollView(categories);
    }

    @Override
    public void fillProductData(List<Product> products) {
        mAdapter.updateWithClear(products);
    }
}
