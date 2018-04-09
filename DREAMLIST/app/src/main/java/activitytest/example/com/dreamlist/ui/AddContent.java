package activitytest.example.com.dreamlist.ui;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.service.media.MediaBrowserService;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import activitytest.example.com.dreamlist.DB.DreamListDB;
import activitytest.example.com.dreamlist.R;

public class AddContent extends BaseActivity implements View.OnClickListener {
    private String val;
    private Button savebtn,deletebtn;
    private EditText ettext;
    private ImageView c_img;
    private VideoView v_video;
    private DreamListDB dreamListDB;
    private SQLiteDatabase dbWriter;
//    private File phoneFile;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontent);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //给它加上一个返回按钮
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        val=getIntent().getStringExtra("flag");
        savebtn= (Button) findViewById(R.id.save);
        deletebtn= (Button) findViewById(R.id.delete);
        ettext= (EditText) findViewById(R.id.ettext);
        c_img= (ImageView) findViewById(R.id.c_img);
        v_video= (VideoView) findViewById(R.id.c_video);
        savebtn.setOnClickListener(this);
        deletebtn.setOnClickListener(this);
        dreamListDB=new DreamListDB(this);
//        dbWriter=dreamListDB.getWritableDatabase();
        dbWriter=dreamListDB.getWritableDatabase();
        initView();
    }

    public void initView(){//文字
        if(val.equals("1")){
            c_img.setVisibility(View.GONE);
            v_video.setVisibility(View.GONE);
        }
        if(val.equals("2")){//图片
            c_img.setVisibility(View.VISIBLE);
            v_video.setVisibility(View.GONE);
//            Intent iimg=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            phoneFile =new File(Environment.getExternalStorageDirectory().getAbsoluteFile()
//            +"/"+getTime()+".jpg");
//            iimg.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(phoneFile));
//            startActivityForResult(iimg,1);

        }
        if(val.equals("3")){//视频
            c_img.setVisibility(View.GONE);
            v_video.setVisibility(View.VISIBLE);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save:
                addDB();
                finish();
                break;
            case R.id.delete:
                finish();
                break;
        }
    }
    public void addDB(){

//        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(DreamListDB.CONTENT,ettext.getText().toString());
        cv.put(DreamListDB.TIME,getTime());
//        cv.put(DreamListDB.PATH,phoneFile+"");

        dbWriter.insert(DreamListDB.TABLE_NAME,null,cv);
    }
    private String getTime(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
        Date date=new Date();
        String str=format.format(date);
        return str;
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode==1)
//        {
//            Bitmap bitmap= BitmapFactory.decodeFile(phoneFile.getAbsolutePath());
//        }
//    }
}