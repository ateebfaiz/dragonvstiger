package com.zing.zalo.zalosdk.oauth.model;

import com.zing.zalo.zalosdk.ZaloOAuthResultCode;

public class ErrorResponse {
    private int errorCode;
    private String errorDescription;
    private String errorMsg;
    private String errorReason;
    private int extCode;
    private String fromSource;

    public ErrorResponse(int i10, String str) {
        this.errorCode = ZaloOAuthResultCode.findById(i10);
        this.errorMsg = str;
        this.extCode = i10;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getErrorReason() {
        return this.errorReason;
    }

    public int getExtCode() {
        return this.extCode;
    }

    public String getFromSource() {
        return this.fromSource;
    }

    public ErrorResponse(int i10, String str, String str2, String str3, String str4) {
        this.errorDescription = str3;
        this.errorMsg = str;
        this.fromSource = str4;
        this.errorReason = str2;
        this.errorCode = ZaloOAuthResultCode.findById(i10);
        this.extCode = i10;
    }
}
