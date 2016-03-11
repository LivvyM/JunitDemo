package com.livvy.junitdemo;

import android.os.Bundle;
import android.widget.TextView;

import com.livvy.junitdemo.manager.BaseActivity;

import cc.livvy.demo.R;

public class MainActivity extends BaseActivity implements ILoginView{

    protected TextView mTextStatus;

    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoginPresenter = new LoginPresenter(this);//null

        mTextStatus = (TextView)findViewById(R.id.mTextStatus);
        findViewById(R.id.mBtnLogin).setOnClickListener(v -> mLoginPresenter.processLogin("123456","123456"));
    }

    @Override
    public void processLoginResult(DataResult result) {
        showToast(result.message);
        if(!result.isHasError && result.status == 0){
            mTextStatus.setText("再次登陆成功啦,接下来干什么好呢!");
        }
    }

    @Override
    public void showToast(String msg) {
        //用于处理登陆失败的情况,一般情况为内存中的数据出错,需要重新登陆
        mTextStatus.setText(msg);
    }
}
