package com.ttyooyu.market.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ttyooyu.market.R;

/**
 * Created by Administrator on 2016-08-30.
 */
public class HomeMenuRelativeLayout extends RelativeLayout{
    public HomeMenuRelativeLayout(Context context) {
        super(context);
    }

    public HomeMenuRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeMenuRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setSelected(boolean isSelected){
        ImageView vIcon = (ImageView) getChildAt(0);
        TextView vTitle = (TextView) getChildAt(1);
        vIcon.setSelected(isSelected);
        if(isSelected){
            vTitle.setTextColor(getResources().getColor(R.color.colorBlue));
        }else{
            vTitle.setTextColor(getResources().getColor(R.color.colorGray));
        }
    }

}
