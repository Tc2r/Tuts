package com.tc2r.a70_swipeviews.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tc2r.a70_swipeviews.fragments.PageFragment;

/**
 * Created by Tc2r on 4/25/2017.
 * <p>
 * Description:
 */

public class SwipeAdapter extends FragmentStatePagerAdapter{

	public SwipeAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		// Create view for each fragment, 5 separate fragment objects.

		Fragment fragment = new PageFragment();
		Bundle bundle = new Bundle();

		bundle.putInt("count", position+1);
		fragment.setArguments(bundle);
		return fragment;

	}

	@Override
	public int getCount() {
		return 5;
	}
}
