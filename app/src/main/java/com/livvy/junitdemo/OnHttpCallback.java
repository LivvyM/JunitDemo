package com.livvy.junitdemo;

/**
 * M+P的回调
 * Created by livvy on 3/5/16.
 */
public interface OnHttpCallback<T> {

    void onSuccess(T entity);

//    void onFailure(int Status);
}
