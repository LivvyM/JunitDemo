package com.livvy.junitdemo;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import cc.livvy.demo.R;

/**
 * 登陆的逻辑处理的presenter层
 *
 * Created by livvy on 3/5/16.
 */
public class LoginPresenter {

    private UserModel model;
    private ILoginView view;

    private boolean isShowLoading = true;

    public LoginPresenter(@Nullable ILoginView view){
        if(null != view){
            isShowLoading = true;
        }else{
            isShowLoading = false;
        }
        this.view = view;
        model = new UserModel();
    }

    public void processLogin(@NonNull String username, @NonNull String password){
        view.showDialog(isShowLoading);
        if("".equals(username)){
            view.showToast(getResourcesString(R.string.login_username_empty));
            view.dismissDialog();
            return;
        }
        if(username.length() < 5){
            view.showToast(getResourcesString(R.string.login_username_length_short));
            view.dismissDialog();
            return;
        }
        if(username.length() > 15){
            view.showToast(getResourcesString(R.string.login_username_length_long));
            view.dismissDialog();
            return;
        }
        if("".equals(password)){
            view.showToast(getResourcesString(R.string.login_password_empty));
            view.dismissDialog();
            return;
        }
        model.login(username,password,entity -> {
            view.dismissDialog();
            view.processLoginResult(entity);
        });

    }

    private String getResourcesString(int Res){
        try{
            return AppClient.getAppContext().getResources().getString(Res);
        }catch (Resources.NotFoundException  e){
            return "NotFoundResourcesString...";
        }
    }

}
