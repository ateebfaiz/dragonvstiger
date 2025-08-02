package com.sensorsdata.analytics.android.sdk.network;

import java.util.Locale;

public class RealResponse {
    public int code;
    public long contentLength;
    public String errorMsg;
    public Exception exception;
    public String location;
    public String result;

    public String toString() {
        String str;
        Locale locale = Locale.getDefault();
        Integer valueOf = Integer.valueOf(this.code);
        String str2 = this.result;
        String str3 = this.location;
        String str4 = this.errorMsg;
        Exception exc = this.exception;
        if (exc == null) {
            str = "";
        } else {
            str = exc.getMessage();
        }
        return String.format(locale, "code:%d\nresult:%s\nlocation:%s\nerrorMsg:%s\nexception:%s", new Object[]{valueOf, str2, str3, str4, str});
    }
}
