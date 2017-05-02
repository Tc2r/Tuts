package com.tc2r.viewpagertabs.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tc2r.viewpagertabs.R;

/**
 * Created by Tc2r on 4/25/2017.
 * <p>
 * Description:
 */
public class Fragment1 extends Fragment {

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frag1, container, false);
	}
}
