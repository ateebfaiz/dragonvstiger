package com.google.firebase.installations;

import com.google.firebase.installations.InstallationTokenResult;

final class a extends InstallationTokenResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f9123a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9124b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9125c;

    static final class b extends InstallationTokenResult.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f9126a;

        /* renamed from: b  reason: collision with root package name */
        private Long f9127b;

        /* renamed from: c  reason: collision with root package name */
        private Long f9128c;

        public InstallationTokenResult build() {
            String str = "";
            if (this.f9126a == null) {
                str = str + " token";
            }
            if (this.f9127b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f9128c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new a(this.f9126a, this.f9127b.longValue(), this.f9128c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public InstallationTokenResult.Builder setToken(String str) {
            if (str != null) {
                this.f9126a = str;
                return this;
            }
            throw new NullPointerException("Null token");
        }

        public InstallationTokenResult.Builder setTokenCreationTimestamp(long j10) {
            this.f9128c = Long.valueOf(j10);
            return this;
        }

        public InstallationTokenResult.Builder setTokenExpirationTimestamp(long j10) {
            this.f9127b = Long.valueOf(j10);
            return this;
        }

        b() {
        }

        private b(InstallationTokenResult installationTokenResult) {
            this.f9126a = installationTokenResult.getToken();
            this.f9127b = Long.valueOf(installationTokenResult.getTokenExpirationTimestamp());
            this.f9128c = Long.valueOf(installationTokenResult.getTokenCreationTimestamp());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationTokenResult)) {
            return false;
        }
        InstallationTokenResult installationTokenResult = (InstallationTokenResult) obj;
        if (this.f9123a.equals(installationTokenResult.getToken()) && this.f9124b == installationTokenResult.getTokenExpirationTimestamp() && this.f9125c == installationTokenResult.getTokenCreationTimestamp()) {
            return true;
        }
        return false;
    }

    public String getToken() {
        return this.f9123a;
    }

    public long getTokenCreationTimestamp() {
        return this.f9125c;
    }

    public long getTokenExpirationTimestamp() {
        return this.f9124b;
    }

    public int hashCode() {
        long j10 = this.f9124b;
        long j11 = this.f9125c;
        return ((((this.f9123a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public InstallationTokenResult.Builder toBuilder() {
        return new b(this);
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f9123a + ", tokenExpirationTimestamp=" + this.f9124b + ", tokenCreationTimestamp=" + this.f9125c + "}";
    }

    private a(String str, long j10, long j11) {
        this.f9123a = str;
        this.f9124b = j10;
        this.f9125c = j11;
    }
}
