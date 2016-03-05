package com.livvy.junitdemo.manager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.livvy.junitdemo.AppClient;

/**
 *
 * Created by livvy on 3/5/16.
 */
public class BaseActivity extends AppCompatActivity{

    public static AppClient app;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //后台恢复
        app = (AppClient) this.getApplication();
        // 设置当前活跃的Activity
        if (null == ActivityManager.getCurrentActivity()) {
            ActivityManager.setCurrentActivity(this);
        }
        // 把当前Activity压入栈中
        ActivityManager.pushActivity(this);
    }

    @Override
    protected void onDestroy() {
        // 销毁时 Activity 从栈中移除
        ActivityManager.removeActivity(this);
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        // 下面两行代码主要正对 TabHost 类的 Activity
        ActivityManager.setCurrentActivity(this);
        ActivityManager.pushActivity(this);
        super.onResume();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //恢复页面入口 测试方法--开发者选项-不保留活动
    }
}
