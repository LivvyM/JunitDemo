package com.livvy.junitdemo.handler;

/**
 * 继承了RuntimeException的异常
 *
 * Created by livvy on 3/5/16.
 */
public class HandlerException extends RuntimeException {
    private static final long serialVersionUID = -1L;

    public HandlerException(String detailMessage) {
        super(detailMessage);
    }

    public HandlerException(Throwable throwable) {
        super(throwable);
    }

    public HandlerException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

}
