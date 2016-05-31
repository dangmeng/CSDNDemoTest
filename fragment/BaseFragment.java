package com.dm.csdndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2016/5/30.
 */
public abstract class BaseFragment extends Fragment {

    public RelativeLayout mRoot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRoot = new RelativeLayout(getActivity());

        RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        mRoot.setLayoutParams(param);

        mRoot.addView(initView());
        return mRoot;
    }

    public abstract View initView();
}
