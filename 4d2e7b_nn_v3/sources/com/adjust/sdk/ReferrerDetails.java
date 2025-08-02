package com.adjust.sdk;

public class ReferrerDetails {
    public Boolean googlePlayInstant;
    public long installBeginTimestampSeconds;
    public long installBeginTimestampServerSeconds;
    public String installReferrer;
    public String installVersion;
    public long referrerClickTimestampSeconds;
    public long referrerClickTimestampServerSeconds;

    public ReferrerDetails(String str, long j10, long j11) {
        this(str, j10, j11, -1, -1, (String) null, (Boolean) null);
    }

    public ReferrerDetails(String str, long j10, long j11, long j12, long j13, String str2, Boolean bool) {
        this.installReferrer = str;
        this.referrerClickTimestampSeconds = j10;
        this.installBeginTimestampSeconds = j11;
        this.referrerClickTimestampServerSeconds = j12;
        this.installBeginTimestampServerSeconds = j13;
        this.installVersion = str2;
        this.googlePlayInstant = bool;
    }
}
