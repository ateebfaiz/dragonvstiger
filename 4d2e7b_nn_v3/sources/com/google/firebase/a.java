package com.google.firebase;

final class a extends StartupTime {

    /* renamed from: a  reason: collision with root package name */
    private final long f8961a;

    /* renamed from: b  reason: collision with root package name */
    private final long f8962b;

    /* renamed from: c  reason: collision with root package name */
    private final long f8963c;

    a(long j10, long j11, long j12) {
        this.f8961a = j10;
        this.f8962b = j11;
        this.f8963c = j12;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StartupTime)) {
            return false;
        }
        StartupTime startupTime = (StartupTime) obj;
        if (this.f8961a == startupTime.getEpochMillis() && this.f8962b == startupTime.getElapsedRealtime() && this.f8963c == startupTime.getUptimeMillis()) {
            return true;
        }
        return false;
    }

    public long getElapsedRealtime() {
        return this.f8962b;
    }

    public long getEpochMillis() {
        return this.f8961a;
    }

    public long getUptimeMillis() {
        return this.f8963c;
    }

    public int hashCode() {
        long j10 = this.f8961a;
        long j11 = this.f8962b;
        long j12 = this.f8963c;
        return ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12));
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f8961a + ", elapsedRealtime=" + this.f8962b + ", uptimeMillis=" + this.f8963c + "}";
    }
}
