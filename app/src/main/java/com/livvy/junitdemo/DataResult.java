package com.livvy.junitdemo;

/**
 * Created by livvy on 3/5/16.
 */
public class DataResult {

    public boolean isHasError = false;//默认false
    public int status = 0;
    public String message = "";

    public boolean isHasError() {
        return isHasError;
    }

    public void setHasError(boolean hasError) {
        isHasError = hasError;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
