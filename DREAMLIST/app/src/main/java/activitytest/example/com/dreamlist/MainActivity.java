package activitytest.example.com.dreamlist;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import activitytest.example.com.dreamlist.ui.AchievementActivity;
import activitytest.example.com.dreamlist.ui.BaseActivity;
import activitytest.example.com.dreamlist.ui.CheckOutActivity;
import activitytest.example.com.dreamlist.ui.DreamListActivity;
import activitytest.example.com.dreamlist.ui.EncouragementActivity;
import activitytest.example.com.dreamlist.ui.MemoryActivity;
import activitytest.example.com.dreamlist.ui.TodayPlanActivity;

import static activitytest.example.com.dreamlist.R.id.toolbar;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigation;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout_main);
        //点击按钮，触发监听事件
        Button dreamlist= (Button) findViewById(R.id.dreamlist);
        Button todayplan= (Button) findViewById(R.id.todayplan);
        Button checkout= (Button) findViewById(R.id.checkout);
        Button memory= (Button) findViewById(R.id.memory);
        Button achievement= (Button) findViewById(R.id.achievement);
        Button encouragement= (Button) findViewById(R.id.encouragement);
        dreamlist.setOnClickListener(this);
        todayplan.setOnClickListener(this);
        checkout.setOnClickListener(this);
        memory.setOnClickListener(this);
        achievement.setOnClickListener(this);
        encouragement.setOnClickListener(this);

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //设置主标题颜色
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        //设置导航菜单
        toolbar.setNavigationIcon(R.drawable.ic_menu);
//        对NavigationIcon添加点击
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //初始化ActionBarDrawerToggle(ActionBarDrawerToggle就是一个开关一样用来打开或者关闭drawer)
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.openString,R.string.closeString){
            /*
            * 抽屉菜单打开监听
            * */
            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(MainActivity.this,"菜单打开了",Toast.LENGTH_SHORT).show();
                super.onDrawerOpened(drawerView);
            }
            /*
            * 抽屉菜单关闭监听
            * */
            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(MainActivity.this,"菜单关闭了",Toast.LENGTH_SHORT).show();
                super.onDrawerClosed(drawerView);
            }
        };
        /*
        * NavigationView设置点击监听
        * */

        // navigation这个对象为null 因为你没有写fvb()!
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Toast.makeText(MainActivity.this,menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return false;
            }
        });
        drawerToggle.syncState();
        //设置DrawerLayout的抽屉开关监听
        drawerLayout.setDrawerListener(drawerToggle);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*
        * 初始化布局控件
        * */
    private void initView() {
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigation = (NavigationView) findViewById(R.id.drawer_navigation);
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
        }

    }
}
