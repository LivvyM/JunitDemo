package cc.livvy.demo.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import cc.livvy.demo.CcApplication;
import cc.livvy.demo.R;
import cc.livvy.demo.base.AppClientActivity;
import cc.livvy.demo.inject.component.AppComponent;
import cc.livvy.demo.inject.component.DaggerLoginComponent;
import cc.livvy.demo.inject.component.LoginComponent;
import cc.livvy.demo.inject.module.ActivityModule;
import cc.livvy.demo.inject.module.LoginModule;
import cc.livvy.demo.presenter.LoginPresenter;
import cc.livvy.demo.view.ILoginView;
import cc.livvy.fragment.data.model.DataResult;

/**
 *
 * Created by livvym on 16-3-9.
 */
public class LoginActivity extends AppClientActivity implements ILoginView {

    protected EditText mEditUserName;
    protected EditText mEditPassWord;
    protected Button mBtnLogin;

    @Inject
    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initInject();
        initView();
        mBtnLogin.setOnClickListener(v -> {
            String mStrUsername = mEditUserName.getText().toString();
            String mStrPassword = mEditPassWord.getText().toString();
            mLoginPresenter.login(mStrUsername, mStrPassword);
        });
    }

    private void initView() {
        mLoginPresenter.attachView(this);
        mEditUserName = (EditText) findViewById(R.id.mEditUserName);
        mEditPassWord = (EditText) findViewById(R.id.mEditPassWord);
        mBtnLogin = (Button) findViewById(R.id.mBtnLogin);
    }

    private void initInject() {
        DaggerLoginComponent.builder().appComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .loginModule(new LoginModule())
                .build()
                .inject(this);
    }

    protected AppComponent getApplicationComponent() {
        return ((CcApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    public void processLoginComplete(DataResult result) {
    }

    @Override
    public void showToast(String msg) {
        toast(msg);
    }
}
