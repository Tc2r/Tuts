package com.tc2r.a71_imageslider.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tc2r.a71_imageslider.R;

/**
 * Created by Tc2r on 4/25/2017.
 * <p>
 * Description:
 */

public class CustomSwipeAdapter extends PagerAdapter{
	// get image resources from drawable folder.

	private int[] imageResources = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7};
	private Context context;
	private LayoutInflater layoutInflater;

	public CustomSwipeAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return imageResources.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return (view == (LinearLayout)object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View item_view = layoutInflater.inflate(R.layout.swipe_layout, container, false);

		ImageView imageView = (ImageView) item_view.findViewById(R.id.image_view);
		TextView textView = (TextView) item_view.findViewById(R.id.image_count);

		textView.setText("Image : " + position);
		imageView.setImageResource(imageResources[position]);
		container.addView(item_view);
		return item_view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// When user moves from one slide to another, destory an item to save memory.

		container.removeView((LinearLayout) object);

	}
}
