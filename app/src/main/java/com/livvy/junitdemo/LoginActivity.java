package com.livvy.junitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.livvy.junitdemo.manager.BaseActivity;

/**
 * 这就是哥简单的龙卢页面.没有错
 * <p>
 * Created by livvy on 3/5/16.
 */
public class LoginActivity extends BaseActivity implements ILoginView {

    protected EditText mEditUserName;
    protected EditText mEditPassWord;
    protected Button mBtnLogin;

    protected LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mPresenter = new LoginPresenter(this);

        initView();
    }

    public void initView() {
        mEditUserName = (EditText) findViewById(R.id.mEditUserName);
        mEditPassWord = (EditText) findViewById(R.id.mEditPassWord);
        mBtnLogin = (Button) findViewById(R.id.mBtnLogin);

        mBtnLogin.setOnClickListener(v -> {
            String mStrUsername = mEditUserName.getText().toString();
            String mStrPassword = mEditPassWord.getText().toString();
            mPresenter.processLogin(mStrUsername, mStrPassword);
        });
    }

    @Override
    public void processLoginResult(DataResult result) {
        showToast(result.message);
        mBtnLogin.setClickable(true);

        if (!result.isHasError && result.status == 0) {
            //登陆成功
            startActivity(new Intent(this, MainActivity.class));
            this.finish();
        }
    }

    @Override
    public void showToast(String msg) {
        //判断是否在UI线程
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
