package com.adjust.sdk;

public enum LogLevel {
    VERBOSE(2),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6),
    ASSERT(7),
    SUPRESS(8);
    
    public final int androidLogLevel;

    private LogLevel(int i10) {
        this.androidLogLevel = i10;
    }

    public int getAndroidLogLevel() {
        return this.androidLogLevel;
    }
}
