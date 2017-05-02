package com.tc2r.tabviewfrags.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tc2r.tabviewfrags.fragments.ViewPagerItemFragment;

/**
 * Created by Tc2r on 4/25/2017.
 * <p>
 * Description:
 */

public class CustomAdapter extends FragmentPagerAdapter {
	String[] pageTitles;

	public CustomAdapter(FragmentManager fm, String[] pageTitles) {
		super(fm);
		this.pageTitles = pageTitles;
	}

	@Override
	public Fragment getItem(int position) {
		return ViewPagerItemFragment.getInstance(pageTitles[position]);
	}

	@Override
	public int getCount() {
		return pageTitles.length;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return pageTitles[position];
	}
}
