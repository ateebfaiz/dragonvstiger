package com.google.firebase.heartbeatinfo;

import java.util.List;

final class a extends HeartBeatResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f9108a;

    /* renamed from: b  reason: collision with root package name */
    private final List f9109b;

    a(String str, List list) {
        if (str != null) {
            this.f9108a = str;
            if (list != null) {
                this.f9109b = list;
                return;
            }
            throw new NullPointerException("Null usedDates");
        }
        throw new NullPointerException("Null userAgent");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HeartBeatResult)) {
            return false;
        }
        HeartBeatResult heartBeatResult = (HeartBeatResult) obj;
        if (!this.f9108a.equals(heartBeatResult.getUserAgent()) || !this.f9109b.equals(heartBeatResult.getUsedDates())) {
            return false;
        }
        return true;
    }

    public List getUsedDates() {
        return this.f9109b;
    }

    public String getUserAgent() {
        return this.f9108a;
    }

    public int hashCode() {
        return ((this.f9108a.hashCode() ^ 1000003) * 1000003) ^ this.f9109b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f9108a + ", usedDates=" + this.f9109b + "}";
    }
}
