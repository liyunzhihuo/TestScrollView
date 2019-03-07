package com.xiao.testscrollview.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.xiao.testscrollview.R;
import com.xiao.testscrollview.fragment.TestFragment;
import com.xiao.testscrollview.util.CommonRecyclerAdapter;
import com.xiao.testscrollview.util.VideoIndictorAdapter;
import com.xiao.testscrollview.util.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TestScrollAndRvActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> list = new ArrayList<>();
    private CommonRecyclerAdapter adapter;
    private String[] tags = new String[]{"美白", "护肤", "养发", "沐浴"};
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private VideoIndictorAdapter videoIndictorAdapter;
    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_scroll_rv_act);
        initUI();
        initData();
        initData2();
    }

    private void initData() {
        fragments.clear();
        titles.clear();
        for (int i = 0; i < tags.length; i++) {
            fragments.add(new TestFragment());
            titles.add(tags[i]);
        }
//        videoIndictorAdapter.notifyDataSetChanged();
        smartTabLayout.setViewPager(viewPager);

    }

    private void initData2() {
        fragments.clear();
        titles.clear();
        for (int i = 0; i < tags.length; i++) {
            fragments.add(new TestFragment());
            titles.add(tags[i] + "*");
        }
//        videoIndictorAdapter.notifyDataSetChanged();
        smartTabLayout.setViewPager(viewPager);

    }

    private void initUI() {

        viewPager = findViewById(R.id.view_pager);

        videoIndictorAdapter = new VideoIndictorAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(videoIndictorAdapter);

        smartTabLayout = findViewById(R.id.tab_layout);
        smartTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {
                Log.e("onPageScrollState", "i=" + i);
                resetData(i);
            }
        });
        smartTabLayout.setOnTabClickListener(new SmartTabLayout.OnTabClickListener() {
            @Override
            public void onTabClicked(int position) {

                resetData(position);
            }
        });
        smartTabLayout.setViewPager(viewPager);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CommonRecyclerAdapter<String>(TestScrollAndRvActivity.this, list, R.layout.test_item) {
            @Override
            public void convert(ViewHolder holder, String item, int position) {
                holder.setText(R.id.item_tv_message, item);
            }
        };
        recyclerView.setAdapter(adapter);

    }

    private void resetData(int index) {
        list.clear();
        int len = 10 * index;
        for (int i = 0; i < len; i++) {
            list.add("条目 " + i);
        }
        adapter.notifyDataSetChanged();
    }
}
