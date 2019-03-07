package com.xiao.testscrollview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xiao.testscrollview.activity.Test2RVActivity;
import com.xiao.testscrollview.activity.TestRVpActivity;
import com.xiao.testscrollview.activity.TestScrollAndRvActivity;
import com.xiao.testscrollview.activity.TestScrollView2Activity;
import com.xiao.testscrollview.activity.TestScrollVpActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void  toTestScrollVp(View view){
        startActivity(new Intent(MainActivity.this, TestScrollVpActivity.class));
    }
    public void  toTestScrollVp2(View view){
        startActivity(new Intent(MainActivity.this, TestScrollView2Activity.class));
    }
    public void toTestRecyclerVp(View view) {
        startActivity(new Intent(MainActivity.this, TestRVpActivity.class));
    }
    public void toTest2Recycler(View view) {
        startActivity(new Intent(MainActivity.this, Test2RVActivity.class));
    }
    public void toTestSvRecycler(View view) {
        startActivity(new Intent(MainActivity.this, TestScrollAndRvActivity.class));
    }
}
