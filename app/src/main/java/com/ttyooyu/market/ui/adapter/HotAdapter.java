package com.ttyooyu.market.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ttyooyu.market.R;
import com.ttyooyu.market.data.entity.Community;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.ui.widget.expandrecyclerview.base.BaseViewHolder;
import com.ttyooyu.market.ui.widget.expandrecyclerview.RecyclerViewAdapter;
import com.ttyooyu.market.ui.widget.ExpandGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-25.
 */
public class HotAdapter extends RecyclerViewAdapter<Community> {

    public HotAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_hot,null);
        return new HotViewHolder(view);
    }



    class HotViewHolder extends BaseViewHolder<Community>{

        ExpandGridView vGridView;
        HotProductAdapter mAdapter;

        public HotViewHolder(View itemView) {
            super(itemView);
            vGridView = (ExpandGridView) itemView.findViewById(R.id.mgv_hot);
            mAdapter = new HotProductAdapter(mContext);
            vGridView.setAdapter(mAdapter);
        }

        @Override
        public void bindItem(Context context, final Community community) {
            List<Product> productList = new ArrayList<>();
            for(int i = 0; i < 7;i++){
                productList.add(community.product);
            }
            mAdapter.updateWithClear(productList);
        }
    }
}
