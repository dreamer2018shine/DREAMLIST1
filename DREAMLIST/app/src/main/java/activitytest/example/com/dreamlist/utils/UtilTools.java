package activitytest.example.com.dreamlist.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by HP on 2018/3/27.
 * 工具统一类
 */

public class UtilTools {
    //设置字体
    public static void setFont(Context mContext, TextView textview) {
        Typeface fontType = Typeface.createFromAsset(mContext.getAssets(), "fonts/FONT.ttf");
        textview.setTypeface(fontType);
    }
}
