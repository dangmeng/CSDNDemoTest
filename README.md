# CSDNDemoTest
ViewPager+PagerSlidingTabStrip+Viewpager动画
在你的项目里面layout的实现
   <astuetz.PagerSlidingTabStripExtends
        xmlns:dm="http://schemas.android.com/apk/res-auto"
        android:id="@+id/main_tabs"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        dm:pstsIndicatorColor="@color/tab_indicator_selected"
        dm:pstsIndicatorHeight="3dp"
        dm:pstsSelectedTextTabColor="@color/tab_text_selected"
        dm:pstsSelectedTextTabSize="18sp"
        dm:pstsTextTabColor="@color/tab_text_normal"
        dm:pstsTextTabSize="16sp"
        dm:pstsDividerColor="#faf8f8">
    </astuetz.PagerSlidingTabStripExtends>

    <android.support.v4.view.ViewPager
        android:id="@+id/viewpager"
        android:layout_height="match_parent"
        android:layout_width="match_parent"/>
        在Activity的Oncreat();里面
        
        mMainTabs = (PagerSlidingTabStripExtends) findViewById(R.id.main_tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        MainFragmentStatePagerAdapter adapter = new MainFragmentStatePagerAdapter(getSupportFragmentManager());
        //给viewpager绑定适配器  
        mViewPager.setAdapter(adapter);
        //viewpager和PagerSlidingTab绑定
        mMainTabs.setViewPager(mViewPager);

        //给viewpager添加动画  
        //mViewPager.setPageTransformer(true, new DepthPageTransformer());//google提供的第一种动画 
        mViewPager.setPageTransformer(true,new ZoomOutPageTransformer());//google提供的第二种动画 
        
        //这样简单的 viewpager+PagerSlidingTabStrip+viewpager动画就能简单地实现了  
        
