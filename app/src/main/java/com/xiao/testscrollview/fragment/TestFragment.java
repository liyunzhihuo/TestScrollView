package com.xiao.testscrollview.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiao.testscrollview.R;
import com.xiao.testscrollview.util.CommonRecyclerAdapter;
import com.xiao.testscrollview.util.FullyLinearLayoutManager;
import com.xiao.testscrollview.util.SignViewPager;
import com.xiao.testscrollview.util.ViewHolder;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class TestFragment extends Fragment {
    private CommonRecyclerAdapter adapter;
    private List<String> list = new ArrayList<>();
    private int index;


    private SignViewPager signViewPager;

    public TestFragment(){}
    public TestFragment(SignViewPager signViewPager) {
        this.signViewPager = signViewPager;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            index = bundle.getInt("index");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_frg, container, false);
        initUI(view);
        initData();
        if(signViewPager!=null){
            signViewPager.setObjectForPosition(view, 1);
        }

        return view;
    }

    private void initData() {
        list.clear();
        int len = 10 * index;
        for (int i = 0; i < len; i++) {
            list.add("条目 " + i);
        }
        Log.e("TestFragment", "size =" + list.size());
        adapter.notifyDataSetChanged();
    }

    private void initUI(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setLayoutManager(new FullyLinearLayoutManager(getActivity()));
        adapter = new CommonRecyclerAdapter<String>(getActivity(), list, R.layout.test_item) {
            @Override
            public void convert(ViewHolder holder, String item, int position) {
                holder.setText(R.id.item_tv_message, item);
            }
        };
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
