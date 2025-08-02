package com.facebook.react.bridge;

import androidx.annotation.GuardedBy;

public class JavaScriptContextHolder {
    @GuardedBy("this")
    private long mContext;

    public JavaScriptContextHolder(long j10) {
        this.mContext = j10;
    }

    public synchronized void clear() {
        this.mContext = 0;
    }

    @GuardedBy("this")
    public long get() {
        return this.mContext;
    }
}
