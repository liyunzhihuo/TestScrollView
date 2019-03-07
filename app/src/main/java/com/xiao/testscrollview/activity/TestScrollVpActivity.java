package com.xiao.testscrollview.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.xiao.testscrollview.R;
import com.xiao.testscrollview.fragment.TestFragment;
import com.xiao.testscrollview.util.VideoIndictorAdapter;

import java.util.ArrayList;
import java.util.List;

public class TestScrollVpActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_vp_act);
        initData();
        initUI();

    }

    private void initData() {
        fragments.clear();
        titles.clear();
        Fragment fragment;
        Bundle bundle;
        for (int i = 0; i < 4; i++) {
            fragment = new TestFragment();
            bundle = new Bundle();
            bundle.putInt("index", i);
            fragment.setArguments(bundle);
            fragments.add(fragment);
            titles.add(String.valueOf(i));
        }
    }

    private void initUI() {
        viewPager = findViewById(R.id.view_pager);
        VideoIndictorAdapter videoIndictorAdapter = new VideoIndictorAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(videoIndictorAdapter);
    }
}
