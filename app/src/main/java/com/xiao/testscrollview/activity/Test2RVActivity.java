package com.xiao.testscrollview.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.xiao.testscrollview.R;
import com.xiao.testscrollview.fragment.TestFragment;
import com.xiao.testscrollview.util.CommonRecyclerAdapter;
import com.xiao.testscrollview.util.FullyLinearLayoutManager;
import com.xiao.testscrollview.util.VideoIndictorAdapter;
import com.xiao.testscrollview.util.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class Test2RVActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Integer> list = new ArrayList<>();
    private CommonRecyclerAdapter adapter;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private String[] tags = new String[]{"美白", "护肤", "养发", "沐浴"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_vp_act);
        initUI();
        initData();
    }

    private void initData() {
        list.clear();
        list.add(0);
        adapter.notifyDataSetChanged();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new FullyLinearLayoutManager(this));
        adapter = new CommonRecyclerAdapter<Integer>(this, list, R.layout.recycler2_item) {
            @Override
            public void convert(ViewHolder holder, Integer item, int position) {
                RecyclerView recyclerView = holder.getView(R.id.recyclerView_content);
                CommonRecyclerAdapter contentAdapter = new CommonRecyclerAdapter<String>(Test2RVActivity.this, titles, R.layout.content_item) {
                    @Override
                    public void convert(ViewHolder holder, String item, int position) {
                        Fragment fragment = new TestFragment();
                        Bundle bundle = new Bundle();
                        bundle.putInt("index", position);
                        fragment.setArguments(bundle);
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.ll_fragment, fragment)
                                .commit();
                    }


                };
                recyclerView.setAdapter(contentAdapter);

            }
        };
        View view = LayoutInflater.from(this).inflate(R.layout.recycler_vp_head, null);
        adapter.removeHeaderView(view);
        adapter.addHeaderView(view);
        TextView textView = new TextView(this);
        textView.setText("bottom");
        adapter.removeFooterView(textView);
        adapter.addFooterView(textView);
        recyclerView.setAdapter(adapter);
    }

    private void initVPData() {
        fragments.clear();
        titles.clear();
        for (int i = 0; i < tags.length; i++) {
            Fragment fragment = new TestFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            fragment.setArguments(bundle);
            fragments.add(fragment);
            titles.add(tags[i]);
        }

    }
}
