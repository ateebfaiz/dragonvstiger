package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AFd1zSDK<Body> implements ResponseNetwork<Body> {
    final int AFInAppEventParameterName;
    final boolean AFInAppEventType;
    @NonNull
    private final Body AFKeystoreWrapper;
    @NonNull
    public final AFc1hSDK valueOf;
    @NonNull
    final Map<String, List<String>> values;

    public AFd1zSDK(@NonNull Body body, int i10, boolean z10, Map<String, List<String>> map, @NonNull AFc1hSDK aFc1hSDK) {
        this.AFKeystoreWrapper = body;
        this.AFInAppEventParameterName = i10;
        this.AFInAppEventType = z10;
        this.values = new HashMap(map);
        this.valueOf = aFc1hSDK;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFd1zSDK aFd1zSDK = (AFd1zSDK) obj;
        if (this.AFInAppEventParameterName == aFd1zSDK.AFInAppEventParameterName && this.AFInAppEventType == aFd1zSDK.AFInAppEventType && this.AFKeystoreWrapper.equals(aFd1zSDK.AFKeystoreWrapper) && this.values.equals(aFd1zSDK.values)) {
            return this.valueOf.equals(aFd1zSDK.valueOf);
        }
        return false;
    }

    @NonNull
    public Body getBody() {
        return this.AFKeystoreWrapper;
    }

    @Nullable
    public List<String> getHeaderField(@NonNull String str) {
        for (String next : this.values.keySet()) {
            if (next != null && next.equalsIgnoreCase(str)) {
                return this.values.get(next);
            }
        }
        return null;
    }

    public int getStatusCode() {
        return this.AFInAppEventParameterName;
    }

    public int hashCode() {
        return (((((((this.AFKeystoreWrapper.hashCode() * 31) + this.AFInAppEventParameterName) * 31) + (this.AFInAppEventType ? 1 : 0)) * 31) + this.values.hashCode()) * 31) + this.valueOf.hashCode();
    }

    public boolean isSuccessful() {
        return this.AFInAppEventType;
    }

    @Nullable
    public final String values(@NonNull String str) {
        List<String> headerField = getHeaderField(str);
        if (headerField == null || headerField.isEmpty()) {
            return null;
        }
        Iterator<String> it = headerField.iterator();
        StringBuilder sb2 = new StringBuilder(it.next());
        while (it.hasNext()) {
            sb2.append(", ");
            sb2.append(it.next());
        }
        return sb2.toString();
    }
}
