package com.example.huaming_lin.day29_drawerlayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Step 1 显示HOme的按钮菜单
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
        initDrawerLayout();
    }

    private void initDrawerLayout() {
        dl = (DrawerLayout) findViewById(R.id.dl);
        //创建一个标题栏与抽屉的关联开关
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, dl, toolbar, R.string.drawerOpen, R.string.drawerClose);
        //只有调用这个同步状态之后。状态栏的Home图标才会改变
        actionBarDrawerToggle.syncState();
        //添加抽屉监听者，该监听者内部控制了ActionBar的NavigationIcon图标按钮
        dl.addDrawerListener(actionBarDrawerToggle);


        //添加开发者自己处理的监听者--这里去观察侧滑情况。
        dl.addDrawerListener(new DrawerLayout.DrawerListener() {

            /**
             *  菜单滑动
             * @param drawerView
             * @param slideOffset 相对于自己，滑动的百分比
             */
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                Log.d("TAG", "onDrawerSlide = " + slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Log.d("TAG", "onDrawerOpened = ");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Log.d("TAG", "onDrawerClosed = ");
            }

            /**
             * Called when the drawer motion state changes. The new state will
             *
             * 只有当一种状态改变到另一种状态的时候才会调用
             *
             * be one of {DrawerLayout.STATE_IDLE 停止}, {DrawerLayout.STATE_DRAGGING 手指滑动的时候} or {DrawerLayout.STATE_SETTLING 惯性滑动} .
             *
             * @param newState The new drawer motion state
             */
            @Override
            public void onDrawerStateChanged(int newState) {
                Log.d("TAG", "onDrawerStateChanged = " + newState);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
