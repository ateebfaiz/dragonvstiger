package com.google.firebase.heartbeatinfo;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SdkHeartBeatResult implements Comparable<SdkHeartBeatResult> {
    public static SdkHeartBeatResult create(String str, long j10) {
        return new b(str, j10);
    }

    public abstract long getMillis();

    public abstract String getSdkName();

    public int compareTo(SdkHeartBeatResult sdkHeartBeatResult) {
        return getMillis() < sdkHeartBeatResult.getMillis() ? -1 : 1;
    }
}
