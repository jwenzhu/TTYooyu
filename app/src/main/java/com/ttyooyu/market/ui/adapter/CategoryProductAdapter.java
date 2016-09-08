package com.ttyooyu.market.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ttyooyu.market.R;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.data.entity.Tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-06-06.
 */
public class CategoryProductAdapter extends BaseAdapter{

    private Context mContext;
    private List<Product> mDataList;

    public CategoryProductAdapter(Context context){
        this.mContext = context;
        this.mDataList = new ArrayList<>();
    }


    public void updateWithClear(List<Product> data) {
        mDataList.clear();
        update(data);
    }
    public void update(List<Product> data) {
        formatData(data);
        notifyDataSetChanged();
    }

    public void formatData(List<Product> data) {
        for (int i = 0; i < data.size(); i++) {
            mDataList.add(data.get(i));
        }
    }


    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_category_product, null);
            holder = new ViewHolder();
            holder.vIvProduct = (ImageView) convertView.findViewById(R.id.iv_product);
            holder.vName = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }

//        holder.vName.setText(product.alias);
        return convertView;
    }
    static class ViewHolder{
        ImageView vIvProduct;
        TextView vName;
    }
}
