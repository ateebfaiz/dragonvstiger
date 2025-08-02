package com.google.firebase.heartbeatinfo;

final class b extends SdkHeartBeatResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f9110a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9111b;

    b(String str, long j10) {
        if (str != null) {
            this.f9110a = str;
            this.f9111b = j10;
            return;
        }
        throw new NullPointerException("Null sdkName");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SdkHeartBeatResult)) {
            return false;
        }
        SdkHeartBeatResult sdkHeartBeatResult = (SdkHeartBeatResult) obj;
        if (!this.f9110a.equals(sdkHeartBeatResult.getSdkName()) || this.f9111b != sdkHeartBeatResult.getMillis()) {
            return false;
        }
        return true;
    }

    public long getMillis() {
        return this.f9111b;
    }

    public String getSdkName() {
        return this.f9110a;
    }

    public int hashCode() {
        long j10 = this.f9111b;
        return ((this.f9110a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "SdkHeartBeatResult{sdkName=" + this.f9110a + ", millis=" + this.f9111b + "}";
    }
}
