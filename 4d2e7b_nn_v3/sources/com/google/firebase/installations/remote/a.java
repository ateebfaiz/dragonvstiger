package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.InstallationResponse;

final class a extends InstallationResponse {

    /* renamed from: a  reason: collision with root package name */
    private final String f9155a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9156b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9157c;

    /* renamed from: d  reason: collision with root package name */
    private final TokenResult f9158d;

    /* renamed from: e  reason: collision with root package name */
    private final InstallationResponse.ResponseCode f9159e;

    static final class b extends InstallationResponse.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f9160a;

        /* renamed from: b  reason: collision with root package name */
        private String f9161b;

        /* renamed from: c  reason: collision with root package name */
        private String f9162c;

        /* renamed from: d  reason: collision with root package name */
        private TokenResult f9163d;

        /* renamed from: e  reason: collision with root package name */
        private InstallationResponse.ResponseCode f9164e;

        public InstallationResponse build() {
            return new a(this.f9160a, this.f9161b, this.f9162c, this.f9163d, this.f9164e);
        }

        public InstallationResponse.Builder setAuthToken(TokenResult tokenResult) {
            this.f9163d = tokenResult;
            return this;
        }

        public InstallationResponse.Builder setFid(String str) {
            this.f9161b = str;
            return this;
        }

        public InstallationResponse.Builder setRefreshToken(String str) {
            this.f9162c = str;
            return this;
        }

        public InstallationResponse.Builder setResponseCode(InstallationResponse.ResponseCode responseCode) {
            this.f9164e = responseCode;
            return this;
        }

        public InstallationResponse.Builder setUri(String str) {
            this.f9160a = str;
            return this;
        }

        b() {
        }

        private b(InstallationResponse installationResponse) {
            this.f9160a = installationResponse.getUri();
            this.f9161b = installationResponse.getFid();
            this.f9162c = installationResponse.getRefreshToken();
            this.f9163d = installationResponse.getAuthToken();
            this.f9164e = installationResponse.getResponseCode();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.f9155a;
        if (str != null ? str.equals(installationResponse.getUri()) : installationResponse.getUri() == null) {
            String str2 = this.f9156b;
            if (str2 != null ? str2.equals(installationResponse.getFid()) : installationResponse.getFid() == null) {
                String str3 = this.f9157c;
                if (str3 != null ? str3.equals(installationResponse.getRefreshToken()) : installationResponse.getRefreshToken() == null) {
                    TokenResult tokenResult = this.f9158d;
                    if (tokenResult != null ? tokenResult.equals(installationResponse.getAuthToken()) : installationResponse.getAuthToken() == null) {
                        InstallationResponse.ResponseCode responseCode = this.f9159e;
                        if (responseCode == null) {
                            if (installationResponse.getResponseCode() == null) {
                                return true;
                            }
                        } else if (responseCode.equals(installationResponse.getResponseCode())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public TokenResult getAuthToken() {
        return this.f9158d;
    }

    public String getFid() {
        return this.f9156b;
    }

    public String getRefreshToken() {
        return this.f9157c;
    }

    public InstallationResponse.ResponseCode getResponseCode() {
        return this.f9159e;
    }

    public String getUri() {
        return this.f9155a;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        String str = this.f9155a;
        int i14 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        int i15 = (i10 ^ 1000003) * 1000003;
        String str2 = this.f9156b;
        if (str2 == null) {
            i11 = 0;
        } else {
            i11 = str2.hashCode();
        }
        int i16 = (i15 ^ i11) * 1000003;
        String str3 = this.f9157c;
        if (str3 == null) {
            i12 = 0;
        } else {
            i12 = str3.hashCode();
        }
        int i17 = (i16 ^ i12) * 1000003;
        TokenResult tokenResult = this.f9158d;
        if (tokenResult == null) {
            i13 = 0;
        } else {
            i13 = tokenResult.hashCode();
        }
        int i18 = (i17 ^ i13) * 1000003;
        InstallationResponse.ResponseCode responseCode = this.f9159e;
        if (responseCode != null) {
            i14 = responseCode.hashCode();
        }
        return i18 ^ i14;
    }

    public InstallationResponse.Builder toBuilder() {
        return new b(this);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f9155a + ", fid=" + this.f9156b + ", refreshToken=" + this.f9157c + ", authToken=" + this.f9158d + ", responseCode=" + this.f9159e + "}";
    }

    private a(String str, String str2, String str3, TokenResult tokenResult, InstallationResponse.ResponseCode responseCode) {
        this.f9155a = str;
        this.f9156b = str2;
        this.f9157c = str3;
        this.f9158d = tokenResult;
        this.f9159e = responseCode;
    }
}
