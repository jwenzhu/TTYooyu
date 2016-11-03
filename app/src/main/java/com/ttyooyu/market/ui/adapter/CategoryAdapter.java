package com.ttyooyu.market.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ttyooyu.market.R;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.ui.widget.expandrecyclerview.base.BaseViewHolder;
import com.ttyooyu.market.ui.widget.expandrecyclerview.RecyclerViewAdapter;
import com.ttyooyu.market.ui.widget.ExpandGridView;
import com.ttyooyu.market.ui.widget.expandrecyclerview.base.ItemType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-25.
 */
public class CategoryAdapter extends RecyclerViewAdapter<Product> {

    public CategoryAdapter(Context context) {
        super(context);
    }


    @Override
    public int getItemViewType(int position) {
        if(mDataList.get(position).isAdvertisement == 0){
            return ItemType.ITEM_ADVERTISEMENT;
        }else{
            return  super.getItemViewType(position);
        }
    }

    @Override
    public BaseViewHolder onCreate(ViewGroup parent, int viewType) {
        View view;
        if( viewType == ItemType.ITEM_ADVERTISEMENT){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_advertisement,null);
            return new AdvertisementViewHolder(view);
        }else{
            view = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_category,null);
            return new ProductViewHolder(view);
        }
    }



    class ProductViewHolder extends BaseViewHolder<Product>{

        ExpandGridView vGridView;
        CategoryProductAdapter mAdapter;

        public ProductViewHolder(View itemView) {
            super(itemView);
            vGridView = (ExpandGridView) itemView.findViewById(R.id.mgv_category);
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

    class AdvertisementViewHolder extends BaseViewHolder<Product>{

        public AdvertisementViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindItem(Context context, Product product) {

        }
    }

}
