package com.tc2r.viewpagertabs;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tc2r.viewpagertabs.adapter.CustomAdapter;

/* Instructor: FilipVujovic
* https://www.youtube.com/watch?v=-a2jJ92bmzw
*
* Viewpager with Tab Layout in android - Sliding Tabs
*
* Notes on Project: My Adapter is pretty static.
*
* We could use an adapter such as this to make a dynamically populating tab_layout.
* This version of tab layout has a border around the tabs.
*
*/

public class MainActivity extends AppCompatActivity {

	TabLayout tabLayout;
	ViewPager viewPager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewPager = (ViewPager) findViewById(R.id.viewpager);
		viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(), getApplicationContext()));

		tabLayout = (TabLayout) findViewById(R.id.tab_layout);
		tabLayout.setupWithViewPager(viewPager);

		// Changes to the fragment that corresponds to app's position.
		tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				viewPager.setCurrentItem(tab.getPosition());

			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {
				viewPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {
				viewPager.setCurrentItem(tab.getPosition());
			}
		});
	}
}
