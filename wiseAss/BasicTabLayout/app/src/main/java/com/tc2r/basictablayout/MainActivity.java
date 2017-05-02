package com.tc2r.basictablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/* Instructor: wiseAss
* Link: https://www.youtube.com/watch?v=_1VwY0P1g-Y
*
*  In this Android View Tutorial, we'll put together a very basic
*  implementation of Android's TabView, which is commonly used for
*  horizontal navigation (perhaps an alternative to the Navigation Drawer).
*
* Notes on Project:
* This way of creating the tab layout is VERY reactive, however it is not dynamic.
*
*
*/


public class MainActivity extends AppCompatActivity {
	private TabLayout tabLayout;
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// sets tab layout elevation to same depth as content.
		getSupportActionBar().setElevation(0f);

		tabLayout = (TabLayout) findViewById(R.id.tablayout);
		textView = (TextView) findViewById(R.id.basic_textview);

		// Creating tabs

		tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_title_movies));
		tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_title_music));


		// Customize Tabs
		tabLayout.setTabTextColors(ContextCompat.getColor(this, android.R.color.white), ContextCompat.getColor(this, R.color.colorAccent));

		tabLayout.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_bright));

		tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				textView.setText(tab.getText());

			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {

			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {
				textView.setText(tab.getText());

			}
		});
	}


}
