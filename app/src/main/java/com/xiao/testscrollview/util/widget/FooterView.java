package com.xiao.testscrollview.util.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.xiao.testscrollview.R;
import com.xiao.testscrollview.util.interfaces.ILoadMoreStatus;




public class FooterView extends LinearLayout implements ILoadMoreStatus {
    private View mHeaderView;
    private LinearLayout mLoadLayout;
    private TextView mLoadTv;

    public FooterView(Context context) {
        this(context, null);
    }

    public FooterView(Context context, @Nullable AttributeSet attrs) {
        this(context, null, 0);
    }

    public FooterView(final Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHeaderView = LayoutInflater.from(context).inflate(R.layout.ui_default_footer_load, FooterView.this, false);
        mLoadLayout = mHeaderView.findViewById(R.id.ll_load_layout);
        mLoadTv = mHeaderView.findViewById(R.id.load_tv);
        addView(mHeaderView, 0);
    }


    @Override
    public void loadingMore() {
        if (mLoadLayout != null) {
            mLoadLayout.setVisibility(View.VISIBLE);
            mLoadTv.setVisibility(View.GONE);
        }
    }

    @Override
    public void loadComplete() {
        if (mLoadLayout != null) {
            mLoadLayout.setVisibility(View.GONE);
            mLoadTv.setVisibility(View.VISIBLE);
            mLoadTv.setText("已经全部加载");
        }
    }

    @Override
    public void loadComplete(String text) {
        if (mLoadLayout != null) {
            mLoadLayout.setVisibility(View.GONE);
            mLoadTv.setVisibility(View.VISIBLE);
            mLoadTv.setText(text == null ? "已经全部加载" : text);
        }
    }

    @Override
    public void loadFailed() {
        if (mLoadLayout != null) {
            mLoadLayout.setVisibility(View.GONE);
            mLoadTv.setVisibility(View.VISIBLE);
            mLoadTv.setText("数据加载失败");
        }
    }

}
