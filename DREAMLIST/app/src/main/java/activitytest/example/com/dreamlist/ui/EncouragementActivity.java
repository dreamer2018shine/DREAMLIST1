package activitytest.example.com.dreamlist.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import activitytest.example.com.dreamlist.R;
import activitytest.example.com.dreamlist.adapter.EncouragementAdapter;
import activitytest.example.com.dreamlist.entity.EncouragementData;
import activitytest.example.com.dreamlist.utils.L;
import activitytest.example.com.dreamlist.utils.StaticClass;

/**
 * Created by HP on 2018/3/27.
 */

public class EncouragementActivity extends BaseActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encouragement);

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //给它加上一个返回按钮
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView tv1=(TextView) findViewById(R.id.tv1);
        String  str1 = "<a href='http://mp.weixin.qq.com/s/NlR5Od_aLSQu7OfceIahcQ'>内心不极度渴望的东西，它不可能轻易靠近你</a>";
        tv1.setText(Html.fromHtml(str1));
        tv1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv2=(TextView) findViewById(R.id.tv2);
        String  str2 = "<a href='http://mp.weixin.qq.com/s/0isYuIl4GIylSNnhygCZeg'>普通人如何从平庸到优秀，再到卓越？</a>";
        tv2.setText(Html.fromHtml(str2));
        tv2.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv3=(TextView) findViewById(R.id.tv3);
        String  str3 = "<a href='http://mp.weixin.qq.com/s/bEK6s2rGSbibHqq4wBHZBw'>失败是成功之母？不，孤独才是</a>";
        tv3.setText(Html.fromHtml(str3));
        tv3.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv4=(TextView) findViewById(R.id.tv4);
        String  str4 = "<a href='http://mp.weixin.qq.com/s/1FSq4o7MlebctctHAMmc5A'>为什么坚持运动的人，更能升职加薪？</a>";
        tv4.setText(Html.fromHtml(str4));
        tv4.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv5=(TextView) findViewById(R.id.tv5);
        String  str5 = "<a href='http://mp.weixin.qq.com/s/CiLVEuqHD8H3J5s2i5VeAQ'>苏东坡：你如何度过人生低谷，决定了你的格局</a>";
        tv5.setText(Html.fromHtml(str5));
        tv5.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv6=(TextView) findViewById(R.id.tv6);
        String  str6 = "<a href='http://mp.weixin.qq.com/s/xkOoMzaMwH_jj3dlKz-7ZA'>我最怕年轻人说要做自己</a>";
        tv6.setText(Html.fromHtml(str6));
        tv6.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv7=(TextView) findViewById(R.id.tv7);
        String  str7 = "<a href='http://mp.weixin.qq.com/s/rfHY6jWkTWCwEx0N4aZKQA'>我的一万小时梦想倒计时</a>";
        tv7.setText(Html.fromHtml(str7));
        tv7.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv8=(TextView) findViewById(R.id.tv8);
        String  str8 = "<a href='http://mp.weixin.qq.com/s/x74K-fnlEqKiizti5mwojg'>快感和成就感的区别是什么？多巴胺 vs 内啡肽</a>";
        tv8.setText(Html.fromHtml(str8));
        tv8.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv9=(TextView) findViewById(R.id.tv9);
        String  str9 = "<a href='http://mp.weixin.qq.com/s/a_BBcuDAw0HNIm67Hp5Xgg'>你与牛逼人士的距离，就差这 5 个工作习惯</a>";
        tv9.setText(Html.fromHtml(str9));
        tv9.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv10=(TextView) findViewById(R.id.tv10);
        String  str10 = "<a href='http://mp.weixin.qq.com/s/wvO6mVOjEtHtFd97yDCbfQ'>让你与众不同的不是努力，而是深度思考力</a>";
        tv10.setText(Html.fromHtml(str10));
        tv10.setMovementMethod(LinkMovementMethod.getInstance());


    }


}