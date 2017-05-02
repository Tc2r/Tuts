package com.tc2r.tabviewfrags;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.tc2r.tabviewfrags.adapters.CustomAdapter;
/* Instructor: wiseAss
* Link: https://www.youtube.com/watch?v=_1VwY0P1g-Y
*
* In this Android View Tutorial, we'll put together a very basic
* implementation of Android's TabView, which is commonly used for
* horizontal navigation (perhaps an alternative to the Navigation Drawer).
*
* Notes on Project:
* We use the same fragment repeatedly in this implimentation to
* create new versions of itself.
*
*/

public class MainActivity extends AppCompatActivity {
	private TabLayout tabLayout;
	private ViewPager viewPager;

	private static final String[] titles = {"Movies", "Music", "Podcast", "Other"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// sets tab layout elevation to same depth as content.
		getSupportActionBar().setElevation(0f);

		tabLayout = (TabLayout) findViewById(R.id.tablayout);
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		setUpPagerAndTabs();




	}
	private void setUpPagerAndTabs(){
		// Customize Tabs
		tabLayout.setTabTextColors(ContextCompat.getColor(this, android.R.color.white), ContextCompat.getColor(this, R.color.colorAccent));

		tabLayout.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_bright));

		CustomAdapter adapter = new CustomAdapter(getSupportFragmentManager(), titles);
		viewPager.setAdapter(adapter);

		tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab){
			}
			@Override
			public void onTabUnselected(TabLayout.Tab tab){
			}
			@Override
			public void onTabReselected(TabLayout.Tab tab){
			}
		});
	}

}
