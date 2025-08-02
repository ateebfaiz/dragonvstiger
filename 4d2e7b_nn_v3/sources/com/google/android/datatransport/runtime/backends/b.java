package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;

final class b extends BackendResponse {

    /* renamed from: a  reason: collision with root package name */
    private final BackendResponse.Status f6451a;

    /* renamed from: b  reason: collision with root package name */
    private final long f6452b;

    b(BackendResponse.Status status, long j10) {
        if (status != null) {
            this.f6451a = status;
            this.f6452b = j10;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        if (!this.f6451a.equals(backendResponse.getStatus()) || this.f6452b != backendResponse.getNextRequestWaitMillis()) {
            return false;
        }
        return true;
    }

    public long getNextRequestWaitMillis() {
        return this.f6452b;
    }

    public BackendResponse.Status getStatus() {
        return this.f6451a;
    }

    public int hashCode() {
        long j10 = this.f6452b;
        return ((this.f6451a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f6451a + ", nextRequestWaitMillis=" + this.f6452b + "}";
    }
}
