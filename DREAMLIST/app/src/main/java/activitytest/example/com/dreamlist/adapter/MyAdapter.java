package activitytest.example.com.dreamlist.adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import activitytest.example.com.dreamlist.R;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private Cursor cursor;
    private LinearLayout layout;
    public  MyAdapter(Context context, Cursor cursor){
        this.context=context;
        this.cursor=cursor;
    }
    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override
    public Object getItem(int position) {
        return cursor.getPosition();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        layout=(LinearLayout)inflater.inflate(R.layout.cell,null);
        TextView contenttv=layout.findViewById(R.id.list_content);
        TextView timetv=layout.findViewById(R.id.list_time);
        ImageView imgiv=layout.findViewById(R.id.list_img);
        ImageView videoiv=layout.findViewById(R.id.list_video);

        cursor.moveToPosition(position);

        String content=cursor.getString(cursor.getColumnIndex("content"));
        String time=cursor.getString(cursor.getColumnIndex("time"));
//        String url=cursor.getString(cursor.getColumnIndex("path"));
        //content为在SQLite中显示的行的名称
        contenttv.setText(content);
        timetv.setText(time);

//        System.out.println(url);
//        imgiv.setImageBitmap(getImageThumbnail(url,200,200));
        return layout;

    }
//    public Bitmap getImageThumbnail(String uri,int width,int height){
//        Bitmap bitmap=null;
//        BitmapFactory.Options options=new BitmapFactory.Options();
//        options.inJustDecodeBounds=true;
//        bitmap=BitmapFactory.decodeFile(uri,options);
//        options.inJustDecodeBounds=false;
//        int beWidth=options.outWidth / width;
//        int beheight=options.outHeight / height;
//        int be = 1;
//        if(beWidth<beheight){
//            be=beWidth;
//        }else{
//            be=beheight;
//        }
//        if(be <=0){
//            be=1;
//        }
//        options.inSampleSize=be;
//        bitmap=BitmapFactory.decodeFile(uri,options);
//        bitmap= ThumbnailUtils.extractThumbnail(bitmap,width,height,
//                ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
//        return bitmap;
//
//    }
}
