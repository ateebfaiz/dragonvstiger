package com.appsflyer.internal;

import kotlin.jvm.internal.m;

public final class AFc1aSDK {
    final String AFInAppEventParameterName;
    final String valueOf;

    public AFc1aSDK(String str, String str2) {
        m.f(str, "");
        m.f(str2, "");
        this.AFInAppEventParameterName = str;
        this.valueOf = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFc1aSDK)) {
            return false;
        }
        AFc1aSDK aFc1aSDK = (AFc1aSDK) obj;
        return m.b(this.AFInAppEventParameterName, aFc1aSDK.AFInAppEventParameterName) && m.b(this.valueOf, aFc1aSDK.valueOf);
    }

    public final int hashCode() {
        return (this.AFInAppEventParameterName.hashCode() * 31) + this.valueOf.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("HostConfig(prefix=");
        sb2.append(this.AFInAppEventParameterName);
        sb2.append(", host=");
        sb2.append(this.valueOf);
        sb2.append(')');
        return sb2.toString();
    }
}
