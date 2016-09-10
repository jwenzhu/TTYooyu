package com.ttyooyu.market.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ttyooyu.market.R;
import com.ttyooyu.market.data.entity.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Jwen
 * date:2016-09-10.
 */
public class PagerTabHorizontalScrollView extends HorizontalScrollView{

    private Context mContext;
    private LinearLayout vContentTabs;
    private List<Category> mTabsData = new ArrayList<>();
    private ViewPager vPager;
    private int mCurrentPosition = 0;
    private float mCurrentPositionOffset = 0f;
    private int mTabCount;
    private int mScrollOffset = 80;
    private int mLastScrollX = 0;
    private final PageListener mPageListener = new PageListener();

    public PagerTabHorizontalScrollView(Context context) {
        this(context,null);
    }

    public PagerTabHorizontalScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PagerTabHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        vContentTabs = new LinearLayout(context);
        vContentTabs.setOrientation(LinearLayout.HORIZONTAL);
        vContentTabs.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        addView(vContentTabs);
    }

    public void setViewPager(ViewPager pager, List<Category> mTabsData) {
        this.vPager = pager;
        this.mTabsData = mTabsData;

        if(mTabsData == null){
            return;
        }

        if (pager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }

        pager.setOnPageChangeListener(mPageListener);
        notifyDataSetChanged();
    }

    private void notifyDataSetChanged() {
        mTabCount = vPager.getAdapter().getCount();
        vContentTabs.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10,5,10,5);
        layoutParams.gravity = Gravity.CENTER;
        for(int i = 0;i < mTabsData.size(); i++){
            Category category = mTabsData.get(i);
            addItem(i,category,layoutParams);
        }
        updateTabStyles(mCurrentPosition);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
            @SuppressLint("NewApi")
            @Override
            public void onGlobalLayout() {

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                mCurrentPosition = vPager.getCurrentItem();
                scrollToChild(mCurrentPosition, 0);
            }
        });

    }

    private void updateTabStyles(int mCurrentPosition) {
        for(int i = 0; i < mTabCount;i++){
            View itemView = (LinearLayout) vContentTabs.getChildAt(i);
            itemView.setBackgroundColor(getResources().getColor(R.color.colorBlueTranslucence));
            if(i == mCurrentPosition){
                itemView.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            }
        }
    }

    private void addItem(final int position, Category category, LinearLayout.LayoutParams layoutParams) {
        View itemView = (ViewGroup) LayoutInflater.from(mContext).inflate(R.layout.item_community_title,null);
        ((ImageView) itemView.findViewById(R.id.iv_communityIcon)).setImageDrawable(category.img);
        ((TextView) itemView.findViewById(R.id.tv_communityName)).setText(category.name);;
        itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                vPager.setCurrentItem(position);
            }
        });
        vContentTabs.addView(itemView);
    }

    private void scrollToChild(int position, int offset) {

        if (mTabCount == 0) {
            return;
        }

        int newScrollX = vContentTabs.getChildAt(position).getLeft() + offset;

        if (position > 0 || offset > 0) {
            newScrollX -= mScrollOffset;
        }

        if (newScrollX != mLastScrollX) {
            mLastScrollX = newScrollX;
            scrollTo(newScrollX, 0);
        }
    }


    private class PageListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            mCurrentPosition = position;
            mCurrentPositionOffset = positionOffset;


            updateTabStyles(mCurrentPosition);
            scrollToChild(position, (int) (positionOffset * vContentTabs.getChildAt(position).getWidth()));

            invalidate();
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == ViewPager.SCROLL_STATE_IDLE) {
                scrollToChild(vPager.getCurrentItem(), 0);
            }
        }

        @Override
        public void onPageSelected(int position) {
        }

    }

}
