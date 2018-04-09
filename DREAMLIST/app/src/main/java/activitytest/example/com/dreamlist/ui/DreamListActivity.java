package activitytest.example.com.dreamlist.ui;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


import java.util.Date;

import activitytest.example.com.dreamlist.DB.DreamListDB;
import activitytest.example.com.dreamlist.R;
import activitytest.example.com.dreamlist.adapter.MyAdapter;

/**
 * Created by HP on 2018/3/27.
 */

public class DreamListActivity extends BaseActivity implements View.OnClickListener{
//    private DreamListDB dreamListDB;
//    private SQLiteDatabase dbWriter;

    private Button textbtn,imgbtn,videobtn;
    private ListView lv;
    private Intent i;
    private MyAdapter adapter;
    private DreamListDB dreamListDB;
    private SQLiteDatabase dbReader;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dreamlist);
        initview();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //给它加上一个返回按钮
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        dreamListDB=new DreamListDB(this);
//        dbWriter =dreamListDB.getWritableDatabase();
//        addDB();
    }
    public void initview(){
        lv= (ListView) findViewById(R.id.list);
        textbtn= (Button) findViewById(R.id.text);
        imgbtn= (Button) findViewById(R.id.img);
        videobtn= (Button) findViewById(R.id.video);
        textbtn.setOnClickListener(this);
        imgbtn.setOnClickListener(this);
        videobtn.setOnClickListener(this);
        dreamListDB=new DreamListDB(this);
        dbReader=dreamListDB.getReadableDatabase();

    }

    @Override
    public void onClick(View v) {
        i=new Intent(this,AddContent.class);
        switch (v.getId()){
            case R.id.text:
                i.putExtra("flag","1");
                startActivity(i);
                break;
            case R.id.img:
                i.putExtra("flag","2");
                startActivity(i);
                break;
            case R.id.video:
                i.putExtra("flag","3");
                startActivity(i);
                break;
        }
    }
//    public void addDB(){
//        ContentValues cv=new ContentValues();
//        cv.put(DreamListDB.CONTENT,"Hello");
//        cv.put(DreamListDB.TIME,getTime());
//        dbWriter.insert(DreamListDB.TABLE_NAME,null,cv);
//    }
//    public String getTime(){
//        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//        Date curDate=new Date();
//        String str=format.format(curDate);
//        return str;
//    }
    public void selectDB(){
        Cursor cursor=dbReader.query(DreamListDB.TABLE_NAME,null,null,
                null,null,null,null);
        adapter=new MyAdapter(this,cursor);
        lv.setAdapter(adapter);
    }
    public void OnResume(){
        super.onResume();
        selectDB();
    }
}
