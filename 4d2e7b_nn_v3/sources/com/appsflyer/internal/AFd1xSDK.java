package com.appsflyer.internal;

import kotlin.jvm.internal.m;

public final class AFd1xSDK {
    public final AFd1vSDK AFInAppEventParameterName;
    public final String valueOf;
    public final String values;

    public AFd1xSDK(String str, String str2, AFd1vSDK aFd1vSDK) {
        m.f(str, "");
        m.f(aFd1vSDK, "");
        this.valueOf = str;
        this.values = str2;
        this.AFInAppEventParameterName = aFd1vSDK;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFd1xSDK)) {
            return false;
        }
        AFd1xSDK aFd1xSDK = (AFd1xSDK) obj;
        return m.b(this.valueOf, aFd1xSDK.valueOf) && m.b(this.values, aFd1xSDK.values) && this.AFInAppEventParameterName == aFd1xSDK.AFInAppEventParameterName;
    }

    public final int hashCode() {
        int hashCode = this.valueOf.hashCode() * 31;
        String str = this.values;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.AFInAppEventParameterName.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AFd1xSDK(AFInAppEventType=");
        sb2.append(this.valueOf);
        sb2.append(", values=");
        sb2.append(this.values);
        sb2.append(", AFKeystoreWrapper=");
        sb2.append(this.AFInAppEventParameterName);
        sb2.append(')');
        return sb2.toString();
    }
}
