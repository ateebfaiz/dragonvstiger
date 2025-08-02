package com.geetest.core;

public class k extends RuntimeException {
    public static final int CODE_CANT_PARSE_CERT = -4;
    public static final int CODE_CERT_NOT_TRUSTED = -3;
    public static final int CODE_DEVICEIDS_UNAVAILABLE = -6;
    public static final int CODE_NOT_SUPPORT = -2;
    public static final int CODE_STRONGBOX_UNAVAILABLE = -5;
    public static final int CODE_SYSTEM_TOO_OLD = -7;
    public static final int CODE_UNKNOWN = -1;
    private final int code;

    public k(int i10, Throwable th) {
        super(th);
        this.code = i10;
    }

    public int getCode() {
        return this.code;
    }
}
