package activitytest.example.com.dreamlist;

import android.content.ClipData;
import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import activitytest.example.com.dreamlist.ui.AchievementActivity;
import activitytest.example.com.dreamlist.ui.BaseActivity;
import activitytest.example.com.dreamlist.ui.CheckOutActivity;
import activitytest.example.com.dreamlist.ui.DreamListActivity;
import activitytest.example.com.dreamlist.ui.EncouragementActivity;
import activitytest.example.com.dreamlist.ui.EventActivity;
import activitytest.example.com.dreamlist.ui.HistoryActivity;
import activitytest.example.com.dreamlist.ui.MemoryActivity;
import activitytest.example.com.dreamlist.ui.SettingActivity;
import activitytest.example.com.dreamlist.ui.TodayPlanActivity;

import static activitytest.example.com.dreamlist.R.id.et_desc;
import static activitytest.example.com.dreamlist.R.id.item_event;
import static activitytest.example.com.dreamlist.R.id.item_history;
import static activitytest.example.com.dreamlist.R.id.item_setting;
import static activitytest.example.com.dreamlist.R.id.toolbar;

public class MainActivity extends BaseActivity implements View.OnClickListener  {

    //初始化导航试图和抽屉菜单
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    //关联菜单按钮
    ImageView menu;
//    PreferenceActivity.Header header;
    ImageView header_icon;
    TextView nick_name;
    TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView header_icon= (ImageView) findViewById(R.id.header_icon);
//        header_icon.setOnClickListener(this);
        TextView nick_name=(TextView)findViewById(R.id.nick_name);
//        nick_name.setOnClickListener(this);
        TextView desc= (TextView) findViewById(R.id.desc);
//        desc.setOnClickListener(this);
        //intent接收数据，触发监听
        SettingActivity.Person person= (SettingActivity.Person) getIntent().getSerializableExtra("person");
//        header_icon=person.getProfile_image();
//        nick_name=person.getEt_username();
//        desc=person.getEt_desc();
//        Log.d("头像","头像->"+person.getProfile_image());
        Log.d("姓名","姓名->"+person.getEt_username());
//        Log.d("简介","简介->"+person.getEt_desc());
        //点击按钮，触发监听事件
        Button dreamlist = (Button) findViewById(R.id.dreamlist);
        Button todayplan = (Button) findViewById(R.id.todayplan);
        Button checkout = (Button) findViewById(R.id.checkout);
        Button memory = (Button) findViewById(R.id.memory);
        Button achievement = (Button) findViewById(R.id.achievement);
        Button encouragement = (Button) findViewById(R.id.encouragement);
        dreamlist.setOnClickListener(this);
        todayplan.setOnClickListener(this);
        checkout.setOnClickListener(this);
        memory.setOnClickListener(this);
        achievement.setOnClickListener(this);
        encouragement.setOnClickListener(this);

        final MenuItem item_history= (MenuItem) findViewById(R.id.item_history);
        MenuItem item_event= (MenuItem) findViewById(R.id.item_event);
        MenuItem item_setting= (MenuItem) findViewById(R.id.item_setting);
//        item_history.setOnMenuItemClickListener(MainActivity.this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //设置主标题颜色
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        //设置导航菜单
//      toolbar.setNavigationIcon(R.drawable.ic_menu);


        //ID与视图关联
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.drawer_navigation);
        //与按的菜单按钮关联
        menu = (ImageView) findViewById(R.id.main_menu);


        //获取头布局
        View headerView = navigationView.getHeaderView(0);
        menu.setOnClickListener(this);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                //item.setChecked(true);
                //写item的点击事件触发了什么
                //Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();

                switch (item.getItemId())
                {
                    case R.id.item_history:
                    {
                        Intent intent1 = new Intent(MainActivity.this, HistoryActivity.class);
                        startActivity(intent1);
                        break;
                    }
                    case R.id.item_event:
                    {
                        Intent intent2 = new Intent(MainActivity.this, EventActivity.class);
                        startActivity(intent2);
                        break;
                    }
                    case R.id.item_setting:
                    {
                        Intent intent3 = new Intent(MainActivity.this, SettingActivity.class);
                        startActivity(intent3);
                        break;
                    }
                }
                //return super.onOptionsItemSelected(item);



                //关闭抽屉菜单
                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });


    }







    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.dreamlist:
                Intent intent1 = new Intent(MainActivity.this, DreamListActivity.class);
                startActivity(intent1);
                break;
            case R.id.todayplan:
                Intent intent2 = new Intent(MainActivity.this, TodayPlanActivity.class);
                startActivity(intent2);
                break;
            case R.id.checkout:
                Intent intent3 = new Intent(MainActivity.this, CheckOutActivity.class);
                startActivity(intent3);
                break;
            case R.id.memory:
                Intent intent4 = new Intent(MainActivity.this, MemoryActivity.class);
                startActivity(intent4);
                break;
            case R.id.achievement:
                Intent intent5 = new Intent(MainActivity.this, AchievementActivity.class);
                startActivity(intent5);
                break;
            case R.id.encouragement:
                Intent intent6 = new Intent(MainActivity.this, EncouragementActivity.class);
                startActivity(intent6);
                break;
            case R.id.main_menu:
                //点击菜单，跳出侧滑菜单
                // DrawerLayout.closeDrawer方法用于隐藏侧边菜单，
                // DrawerLayout.openDrawer方法用于展开侧边菜单
                if (drawerLayout.isDrawerOpen(navigationView)){
                    drawerLayout.closeDrawer(navigationView);
                }else{
                    drawerLayout.openDrawer(navigationView);
                }
                break;
//            case R.id.header_icon:
//                SettingActivity.Person person= (SettingActivity.Person) getIntent().getSerializableExtra("person");
//
//            header_icon=person.getProfile_image();
//                break;
//            case R.id.nick_name:
//                SettingActivity.Person person= (SettingActivity.Person) getIntent().getSerializableExtra("person");
//            nick_name=person.getEt_username();
//                break;
//            case R.id.desc:
//                SettingActivity.Person person= (SettingActivity.Person) getIntent().getSerializableExtra("person");
//            desc=person.getEt_desc();
//                break;
        }

    }
}
