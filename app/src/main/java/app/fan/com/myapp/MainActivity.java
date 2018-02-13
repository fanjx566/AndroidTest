package app.fan.com.myapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fan.adapter.MainFragementPagerAdapter;
import com.fan.fragment.MainFragmentFive;
import com.fan.fragment.MainFragmentFour;
import com.fan.fragment.MainFragmentOne;
import com.fan.fragment.MainFragmentThree;
import com.fan.fragment.MainFragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();
        initTab();

    }

    public void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_toolbar);
        //        setNavigationIcon
        //        即设定 up button 的图标，因为 Material 的介面，
        //        \在 Toolbar这里的 up button样式也就有別于过去的 ActionBar 哦。
        //        边要留意的是setNavigationIcon需要放在 setSupportActionBar之后才会生效。
        setTitle("这是我的项目");
        setSupportActionBar(toolbar);
        //                toolbar.setLogo(R.drawable.ic_menu_manage) ;
        //                toolbar.setNavigationIcon(R.drawable.icon_channel_sel);
        //                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        Toast.makeText(MainActivity.this, "hahah", Toast.LENGTH_LONG).show();
        //                    }
        //                });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.DL_main);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        toggle.setDrawerIndicatorEnabled(false);//改变导航的提示图标也可在XML中
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            //重写了监听才能使抽屉正常和父类中一样
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.DL_main);
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        toggle.setHomeAsUpIndicator(R.drawable.ic_menu_camera);//导航图标
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.CD_main_appBar);
        //        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.ABL_main_appBar);


    }

    public void initTab() {
        TabLayout mTabLayout;
        final ViewPager mViewPager;

        LayoutInflater mInflater;
        mInflater = LayoutInflater.from(this);
        List<String> mTitleList = new ArrayList<>();//页卡标题集合




        mViewPager = (ViewPager) findViewById(R.id.vp_main_appbar);
        mTabLayout = (TabLayout) findViewById(R.id.TB_main_appbar);
//        mViewPager.setNestedpParent((ViewGroup)mViewPager.getParent());
        //添加页卡标题
        String[] tabs = getResources().getStringArray(R.array.main_tab_name);
        for (int i = 0; i < tabs.length; i++) {
            mTitleList.add(tabs[i]);
        }

        //添加页卡视图
        //        List<View> mViewList = new ArrayList<>();//页卡视图集合
//        for (int i = 0; i < mTitleList.size(); i++) {
//            View temp_view = mInflater.inflate(R.layout.content_main, null);
//            TextView textView = (TextView) temp_view.findViewById(R.id.tv_maincontent);
//            textView.setText("this is ....."+i);
//            mViewList.add(temp_view);
//        }
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
//        MainViewPagerAdapter mAdapter = new MainViewPagerAdapter(mViewList);
//        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器


        List<Fragment> mViewList = new ArrayList<Fragment>();//fragment视图集合

        Fragment fragmentone = new MainFragmentOne(this,mViewPager);
        Fragment fragmenttwo = new MainFragmentTwo();
        Fragment fragmentthree = new MainFragmentThree();
        Fragment fragmentfour = new MainFragmentFour();
        Fragment fragmentfive = new MainFragmentFive();

        mViewList.add(fragmentone);
        mViewList.add(fragmenttwo);
        mViewList.add(fragmentthree);
        mViewList.add(fragmentfour);
        mViewList.add(fragmentfive);

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        MainFragementPagerAdapter mAdapter = new MainFragementPagerAdapter(fragmentManager,mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器

        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition(),false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            //添加tab选项卡
            mTabLayout.getTabAt(i).setText(mTitleList.get(i));
//            mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(i)));
        }
//        mTabLayout.setTabTextColors(0x0B0A0A,0xEA0C3C);
//        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置title
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.DL_main);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
























