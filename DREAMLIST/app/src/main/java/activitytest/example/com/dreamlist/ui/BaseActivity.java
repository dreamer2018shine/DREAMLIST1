package activitytest.example.com.dreamlist.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import activitytest.example.com.dreamlist.MainActivity;
import activitytest.example.com.dreamlist.R;



/**
 * 主要做的事情：
 * 1.统一的属性
 * 2.统一的接口
 * 3.统一的方法
 */



public class BaseActivity extends AppCompatActivity  {
//    Button dreamlist,todayplan,checkout,memory,achievement,encouragement;
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //使用ToolBar
        setContentView(R.layout.toolbar_layout);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        //设置主标题颜色
//        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
//        //设置导航菜单
//        toolbar.setNavigationIcon(R.drawable.ic_menu);
//        //对NavigationIcon添加点击
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        //给它加上一个返回按钮
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    //菜单栏操作
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}
