package com.tc2r.a71_imageslider;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tc2r.a71_imageslider.adapters.CustomSwipeAdapter;

/* Instructor: Prabeesh
* Link: https://www.youtube.com/watch?v=nL0k2usU7I8
*
*  How to create a simple image slideshow in your android application using ViewPager widget.
*
* Notes on Project:
* This creates a viewpager that holds images.
* Using a viewpager for a lot of images or large images can be very taxing on your phone.
* It is better to downsize the image, or use a recyclerview, or memory management techniques
* However you can also increase the memory cache your app uses.
*
*/

public class MainActivity extends AppCompatActivity {

	// Declare variables
	ViewPager viewPager;
	CustomSwipeAdapter adapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initialize variables
		viewPager = (ViewPager) findViewById(R.id.view_pager);
		adapter = new CustomSwipeAdapter(this);

		// Set viewpager's adapter
		viewPager.setAdapter(adapter);
	}
}
