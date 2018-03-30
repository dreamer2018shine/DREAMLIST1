package activitytest.example.com.dreamlist;

import android.content.ClipData;
import android.content.Intent;
import android.support.annotation.NonNull;
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
import android.widget.ImageView;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //获得抽屉布局
//                drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        //在布局文件中生命DrawerLayout后，即可从边缘滑出抽屉了
//
//        //ActionBarDrawerToggle作用是在toolbar上创建一个点击弹出drawer的按钮而已
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawerLayout.addDrawerListener(toggle);
//        //不写这句话，是没有按钮显示的
//        toggle.syncState();


//        NavigationView navigationView = (NavigationView) findViewById(R.id.drawer_navigation);
//        navigationView.setNavigationItemSelectedListener(this);

    }


//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        super.onCreateOptionsMenu(menu);
////        menu.add(0,ITEM0,0,"button1");
////        menu.add(0,ITEM1,0,"button2");
////        menu.findItem(ITEM1);
//        return true;
//    }
//    public boolean onOptionsItemSelected(MenuItem item)
//    {
//        switch (item.getItemId())
//        {
//            case item_history:
//            {
//                Intent intent1 = new Intent(MainActivity.this, MemoryActivity.class);
//                startActivity(intent1);
//                break;
//            }
//            case item_event:
//            {
//                Intent intent2 = new Intent(MainActivity.this, AchievementActivity.class);
//                startActivity(intent2);
//                break;
//            }
//            case item_setting:
//            {
//                Intent intent3 = new Intent(MainActivity.this, SettingActivity.class);
//                startActivity(intent3);
//                break;
//            }
//        }
//        return super.onOptionsItemSelected(item);
//    }


        //初始化ActionBarDrawerToggle(ActionBarDrawerToggle就是一个开关一样用来打开或者关闭drawer)
//        drawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.openString,R.string.closeString){
            /*
            * 抽屉菜单打开监听
            * */
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                Toast.makeText(MainActivity.this,"菜单打开了",Toast.LENGTH_SHORT).show();
//                super.onDrawerOpened(drawerView);
//            }
//            /*
//            * 抽屉菜单关闭监听
//            * */
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                Toast.makeText(MainActivity.this,"菜单关闭了",Toast.LENGTH_SHORT).show();
//                super.onDrawerClosed(drawerView);
//            }
//        };
        /*
        * NavigationView设置点击监听
        * */

        // navigation这个对象为null 因为你没有写fvb()!
//        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//
//        public boolean onNavigationItemSelected(MenuItem menuItem) {
//                Toast.makeText(MainActivity.this,menuItem.getTitle(), Toast.LENGTH_SHORT).show();
//                menuItem.setChecked(true);
//                drawerLayout.closeDrawers();
//                return false;
//            }
//        };
//        drawerToggle.syncState();
        //设置DrawerLayout的抽屉开关监听
//        drawerLayout.setDrawerListener(drawerToggle);





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
        }

    }
}
