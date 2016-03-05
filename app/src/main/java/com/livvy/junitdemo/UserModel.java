package com.livvy.junitdemo;

import com.livvy.junitdemo.handler.ToolKit;

/**
 * 用户模块
 * 模拟登陆方法
 * Created by livvy on 3/5/16.
 */
public class UserModel {

    public UserModel(){}

    public void login(String username,String password,OnHttpCallback<DataResult> callback){
        //模拟网络加载过程
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (Throwable e) {
            }

            DataResult result = new DataResult();
            if("123456".equals(username) && "123456".equals(password)){
                result.isHasError = false;
                result.status = 0;
                result.message = "我也不知道写点啥 ^_^";
            }else{
                result.isHasError = false;
                result.status = 1001;
                result.message = "用户和密码都是123456都记不住嘛!!!!!!";
            }
            //回到ui线程
            ToolKit.runOnMainThreadSync(()-> callback.onSuccess(result));
        }).start();
    }
}
