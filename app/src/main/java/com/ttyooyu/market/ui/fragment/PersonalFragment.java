package com.ttyooyu.market.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ttyooyu.market.R;
import com.ttyooyu.market.data.entity.Tool;
import com.ttyooyu.market.data.entity.User;
import com.ttyooyu.market.presenter.PersonalPresenter;
import com.ttyooyu.market.ui.adapter.ToolsAdapter;
import com.ttyooyu.market.ui.fragment.base.BaseFragment;
import com.ttyooyu.market.ui.view.IMineView;
import com.ttyooyu.market.ui.widget.MyGridView;

import java.util.List;

/**
 * author: Jwen
 * date:2016-08-31.
 */
public class PersonalFragment extends BaseFragment<PersonalPresenter> implements IMineView{


    View view;
    @Override
    protected View getLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_personal, container, false);
        return view;
    }

    @Override
    protected void initPresenter() {
        mPresenter = new PersonalPresenter(getActivity(),this);
    }

    @Override
    protected void requestData() {
        mPresenter.getUserData();
        mPresenter.getUserTools();
    }

    @Override
    protected void initView() {

        initTools();
    }

    MyGridView vToolsGridView;
    ToolsAdapter mAdapter;
    private void initTools() {
        vToolsGridView = (MyGridView) view.findViewById(R.id.mgv_tools);
        mAdapter = new ToolsAdapter(getActivity());
        vToolsGridView.setAdapter(mAdapter);
    }


    @Override
    public void fillUserData(User user) {
        
    }

    @Override
    public void fillToolsData(List<Tool> tools) {
        mAdapter.updateWithClear(tools);
    }

    @Override
    public void showErrorView(Throwable throwable) {

    }

    @Override
    public void getDataFinish() {

    }
}
