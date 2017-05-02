package com.tc2r.tabviewfrags.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tc2r.tabviewfrags.R;

/**
 * Created by Tc2r on 4/25/2017.
 * <p>
 * Description:
 */

public class ViewPagerItemFragment extends Fragment {
	private static final String PAGE_TITLE = "PAGE_TITLE";

	private String pageTitle;
	public FragmentPagerItemCallback callback;


	public ViewPagerItemFragment() {
	}

	public static ViewPagerItemFragment getInstance(String pageTitle){
		ViewPagerItemFragment fragment = new ViewPagerItemFragment();
		Bundle bundle = new Bundle();
		bundle.putString(PAGE_TITLE, pageTitle);
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(getArguments() != null){
			this.pageTitle = getArguments().getString(pageTitle);
		}else{
			Log.d("TAG", "No Arguments Found");
		}
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.viewpager_item, container, false);

		final TextView textView = (TextView) view.findViewById(R.id.item_tv);
		textView.setText(pageTitle);
		textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				callback.onPagerItemClick(
								((TextView)view).getText().toString()
				);

			}
		});
		return view;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof FragmentPagerItemCallback){
			callback = (FragmentPagerItemCallback) context;
		}else{
			throw new RuntimeException(context.toString() + " must implement FragmentPagerItemCallback");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		callback = null;
	}

	private interface FragmentPagerItemCallback{
		void onPagerItemClick(String message);
	}
}
