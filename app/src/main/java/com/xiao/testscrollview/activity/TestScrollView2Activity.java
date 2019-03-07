package com.xiao.testscrollview.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.xiao.testscrollview.R;
import com.xiao.testscrollview.fragment.TestFragment;
import com.xiao.testscrollview.util.SignViewPager;
import com.xiao.testscrollview.util.VideoIndictorAdapter;

import java.util.ArrayList;
import java.util.List;

public class TestScrollView2Activity extends AppCompatActivity {
    private SignViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private VideoIndictorAdapter videoIndictorAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_vp_2_act);

        initUI();
        initData();
    }

    private void initData() {
        fragments.clear();
        titles.clear();
        Fragment fragment;
        Bundle bundle;
        for (int i = 0; i < 4; i++) {
            fragment = new TestFragment(viewPager);
            bundle = new Bundle();
            bundle.putInt("index", i);
            fragment.setArguments(bundle);
            fragments.add(fragment);
            titles.add(String.valueOf(i));
        }
        videoIndictorAdapter.notifyDataSetChanged();

    }

    private void initUI() {
        viewPager = findViewById(R.id.view_pager);
        videoIndictorAdapter = new VideoIndictorAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(videoIndictorAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.resetHeight(position);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        viewPager.resetHeight(0);
    }


}
