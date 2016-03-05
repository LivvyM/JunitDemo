package com.livvy.junitdemo;

import android.util.Log;

import com.livvy.junitdemo.dialog.LoadingDialog;
import com.livvy.junitdemo.manager.ActivityManager;

/**
 * 默认的dialog的显示和隐藏,当然可以自己重写
 *
 * Created by livvy on 3/5/16.
 */
public interface IDialogView {

   default void showDialog(boolean isShow){
       if(!isShow){
           return;
       }
       DialogHelper.mLoadingDialog = LoadingDialog.create(ActivityManager.getCurrentActivity())
               .setStyle(LoadingDialog.Style.SPIN_INDETERMINATE)
               .setDimAmount(0.5f);
       try{
           DialogHelper.mLoadingDialog.show();
       }catch (Throwable t){
           Log.e("JunitTAG",t.toString());
       }

   }

    default void dismissDialog(){
        if(null == DialogHelper.mLoadingDialog){
            return;
        }
        try{
            if(DialogHelper.mLoadingDialog.isShowing()){
                DialogHelper.mLoadingDialog.dismiss();
            }
        }catch (Throwable t){
            Log.e("JunitTAG",t.toString());
        }
    }
}
