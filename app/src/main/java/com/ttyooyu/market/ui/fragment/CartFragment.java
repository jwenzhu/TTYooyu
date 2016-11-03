package com.ttyooyu.market.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ttyooyu.market.R;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.presenter.CartPresenter;
import com.ttyooyu.market.ui.adapter.CartAdapter;
import com.ttyooyu.market.ui.widget.expandrecyclerview.manager.LinearLayoutManagerWrapper;
import com.ttyooyu.market.ui.fragment.base.BaseFragment;
import com.ttyooyu.market.ui.view.ICartView;

import java.util.List;

/**
 * author: Jwen
 * date:2016-08-31.
 */
public class CartFragment extends BaseFragment<CartPresenter> implements ICartView{


    View view;
    @Override
    protected View getLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_cart, container, false);
        return view;
    }

    @Override
    protected void initPresenter() {
        mPresenter = new CartPresenter(getActivity(),this);
    }

    @Override
    protected void requestData() {
        mPresenter.getCartData();
    }

    @Override
    protected void initView() {

        initRecyclerView();
    }


    RecyclerView vRecyclerView;
    CartAdapter mAdapter;
    private void initRecyclerView() {
        vRecyclerView = (RecyclerView) view.findViewById(R.id.rv_cart);
        vRecyclerView.setLayoutManager(new LinearLayoutManagerWrapper(getActivity()));
        mAdapter = new CartAdapter(getActivity());
        vRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void fillCartData(List<Product> products) {
        mAdapter.updateWithClear(products);
    }

    @Override
    public void showErrorView(Throwable throwable) {

    }

    @Override
    public void getDataFinish() {

    }
}
