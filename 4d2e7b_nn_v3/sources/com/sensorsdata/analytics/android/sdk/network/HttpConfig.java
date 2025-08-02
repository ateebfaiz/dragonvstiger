package com.sensorsdata.analytics.android.sdk.network;

import com.sensorsdata.analytics.android.sdk.SALog;
import java.io.Serializable;

public class HttpConfig implements Serializable {
    private static final String TAG = ("SA." + HttpConfig.class.getSimpleName());
    private int connectionTimeout = 30000;
    private int readTimeout = 30000;

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public void setConnectionTimeout(int i10) {
        if (i10 < 1000) {
            SALog.i(TAG, "connectionTimeout minimum value is 1000ms");
            this.connectionTimeout = 1000;
            return;
        }
        this.connectionTimeout = i10;
    }

    public void setReadTimeout(int i10) {
        if (i10 < 1000) {
            SALog.i(TAG, "readTimeout minimum value is 1000ms");
            this.readTimeout = 1000;
            return;
        }
        this.readTimeout = i10;
    }
}
