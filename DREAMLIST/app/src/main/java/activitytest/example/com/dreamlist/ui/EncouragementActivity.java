package activitytest.example.com.dreamlist.ui;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import activitytest.example.com.dreamlist.R;
import activitytest.example.com.dreamlist.entity.EncouragementData;

/**
 * Created by HP on 2018/3/27.
 */

public class EncouragementActivity extends BaseActivity {
    private ListView mListView;
    private List<EncouragementData> mList = new ArrayList<>();
    //标题
    private List<String> mListTitle = new ArrayList<>();
    //地址
    private List<String> mListUrl = new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encouragement);
}
