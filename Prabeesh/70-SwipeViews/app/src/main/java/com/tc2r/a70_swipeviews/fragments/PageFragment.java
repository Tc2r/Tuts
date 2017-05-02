package com.tc2r.a70_swipeviews.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tc2r.a70_swipeviews.R;


public class PageFragment extends Fragment {

	TextView textView;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_page, container, false);
		textView = (TextView) view.findViewById(R.id.textView);

		Bundle bundle = getArguments();
		String message = Integer.toString(bundle.getInt("count"));
		textView.setText("This is the " + message + " Swipe View Page.");

		return view;



	}
}


