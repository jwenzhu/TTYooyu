package com.ttyooyu.market.ui.widget.expandrecyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;


import com.ttyooyu.market.data.entity.Soul;
import com.ttyooyu.market.ui.widget.expandrecyclerview.base.BaseViewHolder;
import com.ttyooyu.market.ui.widget.expandrecyclerview.base.ItemType;
import com.ttyooyu.market.ui.widget.expandrecyclerview.listener.IClickItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-07-08.
 */
public abstract class RecyclerViewAdapter<T extends Soul> extends RecyclerView.Adapter<BaseViewHolder<T>> {




    public ArrayList<T> mDataList = new ArrayList<>();
    private ArrayList<View> mHeaderViewData = new ArrayList<>();//header view
    private ArrayList<View> mFooterViewData = new ArrayList<>();//footer view
    public static Context mContext;

    public RecyclerViewAdapter(Context context){
        this.mContext = context;
        mDataList = new ArrayList<>();
    }

    public void updateWithClear(List<T> data) {
        mDataList.clear();
        update(data);
    }
    public void update(List<T> data) {
        formatData(data);
        notifyDataSetChanged();
    }

    public void formatData(List<T> data) {
        for (int i = 0; i < data.size(); i++) {
            mDataList.add(data.get(i));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(mHeaderViewData.size() > 0 && position < mHeaderViewData.size()){
            return ItemType.ITEM_HEADER;
        }else if(mFooterViewData.size() > 0 && position >= getItemCount()- mFooterViewData.size()){
            return ItemType.ITEM_FOOTER;
        }else{
            return ItemType.ITEM_NORMAL;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
        if(getItemViewType(position) == ItemType.ITEM_HEADER
                || getItemViewType(position) == ItemType.ITEM_FOOTER) return;
        final int pos = getRealPosition(viewHolder);
        final T data = mDataList.get(pos);
        viewHolder.bindItem(mContext, data);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        if(mHeaderViewData.size() > 0 && viewType == ItemType.ITEM_HEADER) {
            return new HeaderHolder(mHeaderViewData.get(0));
        }else if(mFooterViewData.size() > 0 && viewType == ItemType.ITEM_FOOTER){
            return new FooterHolder(mFooterViewData.get(0));
        }else{
            return onCreate(parent, viewType);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if(manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if(getItemViewType(position) == ItemType.ITEM_HEADER
                            || getItemViewType(position) == ItemType.ITEM_FOOTER){
                        return gridManager.getSpanCount();
                    }else{
                        return 1;
                    }
                }
            });
        }
    }
    @Override
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if(lp != null
                && lp instanceof StaggeredGridLayoutManager.LayoutParams
                && holder.getLayoutPosition() == 0) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            p.setFullSpan(true);
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size()+ mHeaderViewData.size() + mFooterViewData.size();
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderViewData.size() > 0 ? position - mHeaderViewData.size(): position;
    }


    public abstract BaseViewHolder onCreate(ViewGroup parent, final int viewType);
    public class HeaderHolder extends BaseViewHolder {
        public HeaderHolder(View itemView) {
            super(itemView);
        }
        @Override
        public void bindItem(Context context, Soul soul) {

        }
    }
    public class FooterHolder extends BaseViewHolder {
        public FooterHolder(View itemView) {
            super(itemView);
        }
        @Override
        public void bindItem(Context context, Soul soul) {

        }
    }

    public void setHeaderView(View headerView) {
        mHeaderViewData.add(0,headerView);
        notifyItemInserted(0);
    }

    public void setFooterView(View footerView) {
        mFooterViewData.add(0,footerView);
        notifyItemInserted(getItemCount()-1);
    }

    public IClickItem mIClickItem;
    public void setIClickItem(IClickItem IClickItem) {
        mIClickItem = IClickItem;
    }

}
