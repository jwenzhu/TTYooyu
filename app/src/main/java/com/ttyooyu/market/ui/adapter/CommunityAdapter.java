package com.ttyooyu.market.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ttyooyu.market.data.entity.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommunityAdapter extends FragmentPagerAdapter {

	private Map<Integer,Fragment> vFragments= new HashMap<Integer,Fragment>();
	private List<Category> mDataList =new ArrayList<>();

	public CommunityAdapter(FragmentManager fm, Map<Integer,Fragment> fragments, List<Category> data) {
		super(fm);
		this.vFragments = fragments;
		this.mDataList = data;
	}


	@Override
	public int getCount() {
		return vFragments.size();
	}

	@Override
	public Fragment getItem(int position) {
		return vFragments.get(position);
	}
	@Override
	public CharSequence getPageTitle(int position) {
		return mDataList.get(position).name;
	}


}
