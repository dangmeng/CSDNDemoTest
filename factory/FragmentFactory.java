package com.dm.csdndemo.factory;

import android.support.v4.util.SparseArrayCompat;

import com.dm.csdndemo.fragment.BaseFragment;
import com.dm.csdndemo.fragment.BigdataFragment;
import com.dm.csdndemo.fragment.CalculateFragment;
import com.dm.csdndemo.fragment.DatasFragment;
import com.dm.csdndemo.fragment.GameFragment;
import com.dm.csdndemo.fragment.JobFragment;
import com.dm.csdndemo.fragment.LanguigerFragment;
import com.dm.csdndemo.fragment.LifeFragment;
import com.dm.csdndemo.fragment.LotFragment;
import com.dm.csdndemo.fragment.MoveFragment;
import com.dm.csdndemo.fragment.NewFragment;
import com.dm.csdndemo.fragment.SafeFragment;
import com.dm.csdndemo.fragment.ServiceFragment;
import com.dm.csdndemo.fragment.SoftwareFragment;
import com.dm.csdndemo.fragment.ToolFragment;
import com.dm.csdndemo.fragment.TopFragment;

/**
 * Created by Administrator on 2016/5/30.
 */
public class FragmentFactory {
    /**
     "最新","前端","移动开发","语言","游戏&图像","系统&安全","loT",
     "数据库","业界","云计算","大数据","研发工具","软件工程","程序人生","社区服务"
     */
    public static final int FRAGMENT_NEW = 0;
    public static final int FRAGMENT_TOP = 1;
    public static final int FRAGMENT_MOVE = 2;
    public static final int FRAGMENT_LANGUIGER = 3;
    public static final int FRAGMENT_GAME  = 4;
    public static final int FRAGMENT_SAFE = 5;
    public static final int FRAGMENT_LOT = 6;
    public static final int FRAGMENT_DATAS = 7;
    public static final int FRAGMENT_JOB = 8;
    public static final int FRAGMENT_CALCULATE = 9;
    public static final int FRAGMENT_BIGDATA = 10;
    public static final int FRAGMENT_TOOL  = 11;
    public static final int FRAGMENT_SOFTWARE = 12;
    public static final int FRAGMENT_LIFE = 13;
    public static final int FRAGMENT_SERVICE = 14;
    static SparseArrayCompat<BaseFragment>	cachesFragment		= new SparseArrayCompat<BaseFragment>();
    public static BaseFragment getFragment(int position) {
        BaseFragment fragmet = null;

        BaseFragment temFragment = cachesFragment.get(position);
        if (temFragment != null){
            fragmet = temFragment;
            return fragmet;
        }
        switch (position){
            case FRAGMENT_NEW:
                fragmet = new NewFragment();
                break;
            case FRAGMENT_TOP:
                fragmet = new TopFragment();
                break;
            case FRAGMENT_MOVE:
                fragmet = new MoveFragment();
                break;
            case FRAGMENT_LANGUIGER:
                fragmet = new LanguigerFragment();
                break;
            case FRAGMENT_GAME:
                fragmet = new GameFragment();
                break;
            case FRAGMENT_SAFE:
                fragmet = new SafeFragment();
                break;
            case FRAGMENT_LOT:
                fragmet = new LotFragment();
                break;
            case FRAGMENT_DATAS:
                fragmet = new DatasFragment();
                break;
            case FRAGMENT_JOB:
                fragmet = new JobFragment();
                break;
            case FRAGMENT_CALCULATE:
                fragmet = new CalculateFragment();
                break;
            case FRAGMENT_BIGDATA:
                fragmet = new BigdataFragment();
                break;
            case FRAGMENT_TOOL:
                fragmet = new ToolFragment();
                break;
            case FRAGMENT_SOFTWARE:
                fragmet = new SoftwareFragment();
                break;
            case FRAGMENT_LIFE:
                fragmet = new LifeFragment();
                break;
            case FRAGMENT_SERVICE:
                fragmet = new ServiceFragment();
                break;

        }
        cachesFragment.put(position,fragmet);
        return fragmet;
    }
}
