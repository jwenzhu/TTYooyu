package com.ttyooyu.market.ui.adapter.base;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


import com.ttyooyu.market.data.entity.Soul;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-07-08.
 */
public abstract class RecyclerViewAdapter<T extends Soul> extends RecyclerView.Adapter<BaseViewHolder<T>> {


    public ArrayList<T> mDataList = new ArrayList<>();
    private List<View> mHeaderViewData = new ArrayList<>();
    private List<View> mFooterViewData = new ArrayList<>();
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
            return EItemType.ITEM_HEADER.ordinal();
        }else if(mFooterViewData.size() > 0 && position >= getItemCount()- mFooterViewData.size()){
            return EItemType.ITEM_FOOTER.ordinal();
        }else{
            return EItemType.ITEM_NORMAL.ordinal();
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
        if(getItemViewType(position) == EItemType.ITEM_HEADER.ordinal()
                || getItemViewType(position) == EItemType.ITEM_FOOTER.ordinal()) return;
        final int pos = getRealPosition(viewHolder);
        final T data = mDataList.get(pos);
        viewHolder.bindItem(mContext, data);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        if(mHeaderViewData.size() > 0 && viewType == EItemType.ITEM_HEADER.ordinal()) {
            return new HeaderHolder(mHeaderViewData.get(0));
        }else if(mFooterViewData.size() > 0 && viewType == EItemType.ITEM_FOOTER.ordinal()){
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
                    if(getItemViewType(position) == EItemType.ITEM_HEADER.ordinal()
                            || getItemViewType(position) == EItemType.ITEM_FOOTER.ordinal()){
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
