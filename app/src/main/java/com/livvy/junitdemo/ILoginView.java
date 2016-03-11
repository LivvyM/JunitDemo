package com.livvy.junitdemo;

/**
 * 负责登陆相关处理的额View层.
 * 包括登陆后的处理
 * 显示toast
 * 设置登陆需要的用户名和密码
 * 显示正在登陆的dialog
 *
 * 还有刚发现接口还可以写默认实现的方法,突然好惊喜啊.foo测试一下
 *
 * Created by livvy on 3/5/16.
 */
public interface ILoginView extends IDialogView{

    void processLoginResult(DataResult result);

    default void showToast(String msg){}
}
