package com.tc2r.a70_swipeviews.activites;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.tc2r.a70_swipeviews.R;
import com.tc2r.a70_swipeviews.adapters.SwipeAdapter;

/* Instructor: Prabeesh
* Link: https://www.youtube.com/watch?v=9phSvgqpNtE
*
* How to create a simple swipe view using ViewPager widget in your android application.
*
*
* Notes on Project:
* This is a very simple way to imply fragments using a viewpager.
* I really liked the simplicity of the project to give an impressive result
*
*/


public class MainActivity extends FragmentActivity {
	private ViewPager viewPager;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewPager = (ViewPager) findViewById(R.id.viewpager);
		SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
		viewPager.setAdapter(swipeAdapter);


	}
}
