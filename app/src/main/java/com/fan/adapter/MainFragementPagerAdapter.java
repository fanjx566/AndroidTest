package com.fan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MainFragementPagerAdapter extends FragmentPagerAdapter {
//    FragmentStatePagerAdapter不需要缓存的时候可以用

    List<Fragment> mList;

    public MainFragementPagerAdapter(FragmentManager fm,List<Fragment> mList) {
        super(fm);
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
