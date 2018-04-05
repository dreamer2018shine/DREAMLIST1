package activitytest.example.com.dreamlist.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import activitytest.example.com.dreamlist.R;

/**
 * Created by HP on 2018/3/27.
 */

public class DreamListActivity extends BaseActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dreamlist);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //给它加上一个返回按钮
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
