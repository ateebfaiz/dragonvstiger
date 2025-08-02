package com.appsflyer.internal;

public class AFc1hSDK {
    public final long AFInAppEventType;

    public AFc1hSDK(long j10) {
        this.AFInAppEventType = j10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.AFInAppEventType == ((AFc1hSDK) obj).AFInAppEventType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.AFInAppEventType;
        return (int) (j10 ^ (j10 >>> 32));
    }
}
