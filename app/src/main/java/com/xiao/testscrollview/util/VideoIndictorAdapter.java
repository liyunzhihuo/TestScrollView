package com.xiao.testscrollview.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * description: 指示器adapter
 * Created by 谢光亚 on  2017-09-29
 * QQ/E-mail：409918544
 * Version：1.0
 */

public class VideoIndictorAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;

    private List<String> titles;

    public VideoIndictorAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.mFragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
