package com.dm.csdndemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dm.csdndemo.factory.FragmentFactory;
import com.dm.csdndemo.fragment.BaseFragment;

import astuetz.PagerSlidingTabStripExtends;

public class MainActivity extends AppCompatActivity {

    private PagerSlidingTabStripExtends mMainTabs;
    private ViewPager mViewPager;
    private String[] mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initView() {

        mMainTabs = (PagerSlidingTabStripExtends) findViewById(R.id.main_tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        MainFragmentStatePagerAdapter adapter = new MainFragmentStatePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mMainTabs.setViewPager(mViewPager);

        //mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.setPageTransformer(true,new ZoomOutPageTransformer());
    }

    private void initData() {
        mTabs = new String[]{"最新", "前端", "移动开发", "语言", "游戏&图像", "系统&安全", "loT",
                "数据库", "业界", "云计算", "大数据", "研发工具", "软件工程", "程序人生", "社区服务"};
    }

    class HomeAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            if (mTabs != null) {
                return mTabs.length;
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(getApplicationContext());
            tv.setText(mTabs[position]);
            tv.setGravity(Gravity.CENTER);
            container.addView(tv);
            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        /**
         * 必须重写
         *
         * @param position
         * @return
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return mTabs[position];
        }
    }

    class MainFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

        public MainFragmentStatePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            BaseFragment fragment = FragmentFactory.getFragment(position);
            return fragment;
        }

        @Override
        public int getCount() {
            return mTabs.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabs[position];
        }
    }

    /**
     * viewpager的动画①
     */
    class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }

    /**
     * viewpager的动画②
     */
    class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        @SuppressLint("NewApi")
        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            Log.e("TAG", view + " , " + position + "");

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) //a页滑动至b页 ； a页从 0.0 -1 ；b页从1 ~ 0.0
            { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE)
                        / (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }


}
