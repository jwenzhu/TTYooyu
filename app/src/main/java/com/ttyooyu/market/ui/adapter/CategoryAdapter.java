package com.ttyooyu.market.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ttyooyu.market.R;
import com.ttyooyu.market.data.entity.Category;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.ui.adapter.base.BaseViewHolder;
import com.ttyooyu.market.ui.adapter.base.GridLayoutManagerWrapper;
import com.ttyooyu.market.ui.adapter.base.LinearLayoutManagerWrapper;
import com.ttyooyu.market.ui.adapter.base.RecyclerViewAdapter;
import com.ttyooyu.market.ui.fragment.base.BaseFragment;
import com.ttyooyu.market.ui.widget.MyGridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-08-25.
 */
public class CategoryAdapter extends RecyclerViewAdapter<Product> {

    public CategoryAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_category,null);
        return new ProductViewHolder(view);
    }



    class ProductViewHolder extends BaseViewHolder<Product>{

        MyGridView vGridView;
        CategoryProductAdapter mAdapter;

        public ProductViewHolder(View itemView) {
            super(itemView);
            vGridView = (MyGridView) itemView.findViewById(R.id.mgv_category);
            mAdapter = new CategoryProductAdapter(mContext);
            vGridView.setAdapter(mAdapter);
        }

        @Override
        public void bindItem(Context context, final Product product) {
            List<Product> productList = new ArrayList<>();
            for(int i = 0; i < 8;i++){
                productList.add(product);
            }
            mAdapter.updateWithClear(productList);

        }
    }
}
