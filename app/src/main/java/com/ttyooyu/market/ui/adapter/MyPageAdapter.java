package com.ttyooyu.market.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ttyooyu.market.R;


public class MyPageAdapter<T extends View> extends PagerAdapter {

	private T[] mArrays;
	private Context mContext;
	private ViewPager vViewPager;
	private ViewGroup vViewGroup;
	private ImageView[] vTips;

	public MyPageAdapter(T[] arrays) {
		this.mArrays = arrays;
	}

	public MyPageAdapter(T[]arrays, Context context, ViewPager viewPager, ViewGroup viewGroup) {
		this.mContext = context;
		this.vViewPager = viewPager;
		this.mArrays = arrays;
		this.vViewGroup = viewGroup;

		initTips();
	}

	private void initTips() {
		vViewGroup.removeAllViews();
		vTips = new ImageView[mArrays.length];
		for (int i = 0; i < vTips.length; i++) {
			ImageView imageView = new ImageView(mContext);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			params.setMargins(0, 0, 10, 0);
			params.gravity = Gravity.CENTER_VERTICAL;
			imageView.setLayoutParams(params);
			vTips[i] = imageView;
			if (i == 0) {
				vTips[i].setBackgroundResource(R.drawable.shape_indicator_focused);
			} else {
				vTips[i].setBackgroundResource(R.drawable.shape_indicator_unfocused);
			}
			vViewGroup.addView(imageView);
		}

		vViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				setImageBackground(position % mArrays.length);
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});

	}

	@Override
	public int getCount() {
		return mArrays.length;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView(mArrays[position
				% mArrays.length]);

	}
	@Override
	public Object instantiateItem(View container, int position) {
		((ViewPager) container).addView(mArrays[position
				% mArrays.length], 0);
		return mArrays[position % mArrays.length];
	}

	private void setImageBackground(int selectItems) {
		for (int i = 0; i < vTips.length; i++) {
			if (i == selectItems) {
				vTips[i].setBackgroundResource(R.drawable.shape_indicator_focused);
			} else {
				vTips[i].setBackgroundResource(R.drawable.shape_indicator_unfocused);
			}
		}
	}

}
