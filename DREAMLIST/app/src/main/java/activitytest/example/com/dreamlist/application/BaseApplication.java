package activitytest.example.com.dreamlist.application;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

import activitytest.example.com.dreamlist.utils.StaticClass;
import cn.bmob.v3.Bmob;

/**
 * Created by HP on 2018/3/27.
 */

public class BaseApplication extends Application {
    public void onCreate()
    {
        super.onCreate();
        //初始化Bugly
        CrashReport.initCrashReport(getApplicationContext(), StaticClass.BUGLY_APP_ID, true);

        Bmob.initialize(this, StaticClass.BMOB_APP_ID);

    }
}
