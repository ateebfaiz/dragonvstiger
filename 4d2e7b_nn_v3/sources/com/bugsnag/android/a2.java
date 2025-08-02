package com.bugsnag.android;

import java.util.Map;

public final class a2 implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    private final String f18608a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18609b;

    public a2(String str, String str2) {
        if (str != null) {
            this.f18608a = str;
            this.f18609b = str2;
            return;
        }
        throw new NullPointerException("FeatureFlags cannot have null name");
    }

    /* renamed from: a */
    public String getKey() {
        return this.f18608a;
    }

    public String b() {
        return this.f18608a;
    }

    /* renamed from: c */
    public String getValue() {
        return this.f18609b;
    }

    public String d() {
        return this.f18609b;
    }

    /* renamed from: e */
    public String setValue(String str) {
        throw new UnsupportedOperationException("FeatureFlag is immutable");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (getKey().equals(entry.getKey())) {
            if (getValue() == null) {
                if (entry.getValue() == null) {
                    return true;
                }
            } else if (getValue().equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = getKey().hashCode();
        if (getValue() == null) {
            i10 = 0;
        } else {
            i10 = getValue().hashCode();
        }
        return hashCode ^ i10;
    }

    public String toString() {
        return "FeatureFlag{name='" + this.f18608a + '\'' + ", variant='" + this.f18609b + '\'' + '}';
    }
}
