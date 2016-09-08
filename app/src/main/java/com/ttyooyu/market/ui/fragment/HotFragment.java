package com.ttyooyu.market.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ttyooyu.market.R;
import com.ttyooyu.market.data.entity.Community;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.presenter.HotPresenter;
import com.ttyooyu.market.ui.adapter.HomeAdapter;
import com.ttyooyu.market.ui.adapter.HotAdapter;
import com.ttyooyu.market.ui.adapter.base.LinearLayoutManagerWrapper;
import com.ttyooyu.market.ui.fragment.base.BaseFragment;
import com.ttyooyu.market.ui.view.IHotView;

import java.util.List;

/**
 * author: Jwen
 * date:2016-08-31.
 */
public class HotFragment extends BaseFragment<HotPresenter> implements IHotView {


    View view;
    @Override
    protected View getLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_hot, container, false);
        return view;
    }

    @Override
    protected void initPresenter() {
        mPresenter  = new HotPresenter(getActivity(),this);
    }

    @Override
    protected void requestData() {
        mPresenter.getDiscussionData();
    }

    @Override
    protected void initView() {
        initRecyclerView();
    }


    RecyclerView vRecyclerView;
    HotAdapter mAdapter;
    private void initRecyclerView() {
        vRecyclerView = (RecyclerView) view.findViewById(R.id.rv_discussion);
        vRecyclerView.setLayoutManager(new LinearLayoutManagerWrapper(getActivity()));
        mAdapter = new HotAdapter(getActivity());
        vRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void fillDiscussionData(List<Community> communities) {
        mAdapter.updateWithClear(communities);
    }

    @Override
    public void showErrorView(Throwable throwable) {

    }

    @Override
    public void getDataFinish() {

    }
}
