package activitytest.example.com.dreamlist.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 2018/4/5.
 */

public class DreamListDB extends SQLiteOpenHelper {
    public static final String TABLE_NAME="DreamList";
    public static final String CONTENT="content";
    public static final String PATH="path";
    public static final String VIDEO="video";
    public static final String ID="_id";
    public static final String TIME="time";
    public DreamListDB(Context context) {
        super(context, "DreamList", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("CREATE TABLE "+TABLE_NAME+"("+ID
       +" INTEGER PRIMARY KEY AUTOINCREMENT,"+CONTENT
       +" TEXT NOT NULL,"+PATH+" TEXT NOT NULL,"
               + VIDEO+" TEXT NOT NULL,"+TIME+" TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
