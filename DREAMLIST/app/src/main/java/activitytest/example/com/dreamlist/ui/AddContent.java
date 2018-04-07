package activitytest.example.com.dreamlist.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import activitytest.example.com.dreamlist.R;

public class AddContent extends BaseActivity {
    private String val;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontent);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //给它加上一个返回按钮
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        val=getIntent().getStringExtra("flag");
    }
}