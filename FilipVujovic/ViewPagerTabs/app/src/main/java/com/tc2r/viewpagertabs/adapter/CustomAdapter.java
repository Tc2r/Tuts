package com.tc2r.viewpagertabs.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tc2r.viewpagertabs.fragments.Fragment1;
import com.tc2r.viewpagertabs.fragments.Fragment2;


/**
 * Created by Tc2r on 4/25/2017.
 * <p>
 * Description:
 */
public class CustomAdapter extends FragmentPagerAdapter {
	private String fragments[] = {"Fragments 1", "Fragment 2"};
	public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
		super(supportFragmentManager);
	}

	@Override
	public Fragment getItem(int position) {
		// for each position create corresponding fragments.
		switch (position){
			case 0:
				return new Fragment1();
			case 1:
				return new Fragment2();
		}
		return null;
	}

	@Override
	public int getCount() {
		return fragments.length;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return fragments[position];
	}
}