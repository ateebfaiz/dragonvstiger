package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableMap;

public class v0 {

    /* renamed from: a  reason: collision with root package name */
    final ReadableMap f3960a;

    public v0(ReadableMap readableMap) {
        this.f3960a = readableMap;
    }

    public boolean a(String str, boolean z10) {
        if (this.f3960a.isNull(str)) {
            return z10;
        }
        return this.f3960a.getBoolean(str);
    }

    public String b(String str) {
        return this.f3960a.getString(str);
    }

    public boolean c(String str) {
        return this.f3960a.hasKey(str);
    }

    public String toString() {
        return "{ " + getClass().getSimpleName() + ": " + this.f3960a.toString() + " }";
    }
}
