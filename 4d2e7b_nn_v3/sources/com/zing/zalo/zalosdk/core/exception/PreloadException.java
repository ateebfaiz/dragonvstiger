package com.zing.zalo.zalosdk.core.exception;

public class PreloadException extends Exception {
    private String msg;

    public PreloadException(String str) {
        this.msg = str;
    }

    public String getMessage() {
        return this.msg;
    }
}
