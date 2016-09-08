package com.ttyooyu.market.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ttyooyu.market.R;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.ui.adapter.base.BaseViewHolder;
import com.ttyooyu.market.ui.adapter.base.RecyclerViewAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016-08-25.
 */
public class CartAdapter extends RecyclerViewAdapter<Product> {

    public CartAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_cart,null);
        return new ProductViewHolder(view);
    }



    class ProductViewHolder extends BaseViewHolder<Product>{


        public ProductViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindItem(Context context, final Product product) {
        }
    }
}
