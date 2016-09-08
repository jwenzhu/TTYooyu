package com.ttyooyu.market.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


import com.ttyooyu.market.R;
import com.ttyooyu.market.data.entity.Category;

import java.util.List;


/**
 * Created by Jwen on 2016-07-13.
 * product category in searchActivity
 */
public class CategoryScrollView extends ScrollView {

    LinearLayout mLinearLayout;
    private TextView vTextViews[];
    private View views[];
    private int currentItem=0;
    private int scrollViewWidth = 0;
    private int scrollViewMiddle = 0;
    private int length;


    public CategoryScrollView(Context context) {
        this(context,null);
    }

    public CategoryScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CategoryScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mLinearLayout = new LinearLayout(getContext());
        mLinearLayout.setOrientation(LinearLayout.VERTICAL);
    }

    public void initScrollView(List<Category> toolsList) {
        length = toolsList.size();
        LayoutInflater inflater=LayoutInflater.from(getContext());

        vTextViews=new TextView[length];
        views=new View[length];

        for (int i = 0; i < length; i++) {
            Category category = toolsList.get(i);

            View view=inflater.inflate(R.layout.item_category, null);
            view.setId(i);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId();
                    if(currentItem!=id){
                        changeTextColor(id);
                        changeTextLocation(id);
                        onIClickListener.onIClickListener(id);
                    }
                    currentItem=v.getId();

                }
            });
            TextView textView=(TextView) view.findViewById(R.id.text);
            textView.setText(category.name);
            mLinearLayout.addView(view);
            vTextViews[i]=textView;
            views[i]=view;
        }
        changeTextColor(0);

        addView(mLinearLayout);
    }


    /**
     * 改变textView的颜色
     * @param id
     */
    private void changeTextColor(int id) {
        for (int i = 0; i < length; i++) {
            if(i!=id){
                vTextViews[i].setBackgroundColor(getResources().getColor(R.color.colorWhite));
                vTextViews[i].setTextColor(getResources().getColor(R.color.colorBlue));
            }
        }
        vTextViews[id].setBackgroundColor(getResources().getColor(R.color.colorGrayLight));
        vTextViews[id].setTextColor(getResources().getColor(R.color.colorGray));
    }

    /**
     * 改变栏目位置
     *
     * @param clickPosition
     */
    private void changeTextLocation(int clickPosition) {

        int x = (views[clickPosition].getTop() - getScrollViewMiddle() + (getViewHeight(views[clickPosition]) / 2));
        this.smoothScrollTo(0, x);
    }

    /**
     * 返回scrollview的中间位置
     *
     * @return
     */
    private int getScrollViewMiddle() {
        if (scrollViewMiddle == 0)
            scrollViewMiddle = getScrollViewHeight() / 2;
        return scrollViewMiddle;
    }

    /**
     * 返回ScrollView的宽度
     *
     * @return
     */
    private int getScrollViewHeight() {
        if (scrollViewWidth == 0)
            scrollViewWidth = this.getBottom() - this.getTop();
        return scrollViewWidth;
    }

    /**
     * 返回view的宽度
     *
     * @param view
     * @return
     */
    private int getViewHeight(View view) {
        return view.getBottom() - view.getTop();
    }


    public interface OnIClickListener{
        void onIClickListener(int id);
    }
    private OnIClickListener onIClickListener;

    public void  setOnIClickListener(OnIClickListener viewClickListener){
        this.onIClickListener = viewClickListener;
    }

}
