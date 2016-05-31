package com.dm.csdndemo.fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/30.
 */
public class BigdataFragment extends BaseFragment {
    @Override
    public View initView() {

        mRoot.setBackgroundColor(Color.argb(120,110,192,86));
        mRoot.setGravity(Gravity.CENTER);
        TextView tv = new TextView(getActivity());
        tv.setText("11");
        tv.setTypeface(Typeface.DEFAULT_BOLD);
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(25);
        return tv;
    }
}
