package com.ydkim2110.onboardingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Kim Yongdae on 2018-12-05
 * email : ydkim2110@gmail.com
 */
public class SlideAdapter extends PagerAdapter {

    private static final String TAG = "SlideAdapter";

    private Context mContext;
    private LayoutInflater mInflater;

    public SlideAdapter(Context context) {

        mContext = context;
    }

    // Arrays
    public int[] slide_images = {
            R.drawable.eat_icon,
            R.drawable.sleep_icon,
            R.drawable.code_icon
    };

    public String[] slide_headings = {
            "EAT",
            "SLEEP",
            "CODE"
    };

    public String[] slide_descs = {
            "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Libero officiis vitae corrupti unde maiores dignissimos ut.",
            "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Libero officiis vitae corrupti unde maiores dignissimos ut.",
            "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Libero officiis vitae corrupti unde maiores dignissimos ut."
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        mInflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = mInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.slide_heading);
        TextView sldieDescription = view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        sldieDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }

}
