package com.google.android.datatransport.cct.internal;

final class f extends LogResponse {

    /* renamed from: a  reason: collision with root package name */
    private final long f6398a;

    f(long j10) {
        this.f6398a = j10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogResponse)) {
            return false;
        }
        if (this.f6398a == ((LogResponse) obj).getNextRequestWaitMillis()) {
            return true;
        }
        return false;
    }

    public long getNextRequestWaitMillis() {
        return this.f6398a;
    }

    public int hashCode() {
        long j10 = this.f6398a;
        return ((int) (j10 ^ (j10 >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f6398a + "}";
    }
}
