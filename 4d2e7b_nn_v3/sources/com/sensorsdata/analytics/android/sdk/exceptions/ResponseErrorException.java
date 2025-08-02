package com.sensorsdata.analytics.android.sdk.exceptions;

public class ResponseErrorException extends Exception {
    private int httpCode;

    public ResponseErrorException(String str, int i10) {
        super(str);
        this.httpCode = i10;
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    public ResponseErrorException(Throwable th, int i10) {
        super(th);
        this.httpCode = i10;
    }
}
