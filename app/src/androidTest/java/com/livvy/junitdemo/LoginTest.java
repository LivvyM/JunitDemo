package com.livvy.junitdemo;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import android.widget.EditText;

import cc.livvy.demo.R;

/**
 * Login页面的Junit
 *
 * Created by livvy on 3/5/16.
 */
public class LoginTest extends ActivityInstrumentationTestCase2<LoginActivity>{

    protected EditText mEditUserName;
    protected EditText mEditPassWord;
    protected Button mBtnLogin;


    public LoginTest() {
        super(LoginActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mEditUserName = (EditText)getActivity().findViewById(R.id.mEditUserName);
        mEditPassWord = (EditText) getActivity().findViewById(R.id.mEditPassWord);
        mBtnLogin = (Button) getActivity().findViewById(R.id.mBtnLogin);
    }

    /**
     * 用户名为空
     */
    @UiThreadTest
    public void testLoginUserNameEmpty(){
        mEditUserName.setText("");
        mEditPassWord.setText("123456");
        assertTrue("testLoginUserNameEmpty",mBtnLogin.performClick());

    }

    /**
     * 用户名correct的情况,密码为空
     */
    @UiThreadTest
    public void testLoginPasswordEmpty(){
        mEditUserName.setText("123456");
        mEditPassWord.setText("");
        assertTrue("testLoginUserNameEmpty",mBtnLogin.performClick());
    }

    /**
     * 用户名长度短
     */
    @UiThreadTest
    public void testLoginUserNameShort(){
        mEditUserName.setText("1");
        mEditPassWord.setText("123456");
        assertTrue("testLoginUserNameEmpty",mBtnLogin.performClick());
    }

    /**
     *  用户名过长
     */
    @UiThreadTest
    public void testLoginUserNameLong(){
        mEditUserName.setText("123123123123123123123123");
        mEditPassWord.setText("123456");
        assertTrue("testLoginUserNameEmpty",mBtnLogin.performClick());
    }

    /**
     * correct-用户名错误
     */
    @UiThreadTest
    public void testLoginCorrectUserNameError(){
        mEditUserName.setText("1234567");
        mEditPassWord.setText("123456");
        assertTrue("testLoginUserNameEmpty",mBtnLogin.performClick());
    }

    /**
     * correct-密码错误
     */
    @UiThreadTest
    public void testLoginCorrectPasswordError(){
        mEditUserName.setText("123456");
        mEditPassWord.setText("1234567");
        assertTrue("testLoginUserNameEmpty",mBtnLogin.performClick());
    }

    /**
     * correct-正确的用户名和密码
     */
    @UiThreadTest
    public void testLoginCorrectSuccess(){
        mEditUserName.setText("123456");
        mEditPassWord.setText("123456");
        assertTrue("testLoginUserNameEmpty",mBtnLogin.performClick());
    }

}
