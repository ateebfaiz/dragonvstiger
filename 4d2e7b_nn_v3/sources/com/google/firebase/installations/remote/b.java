package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.TokenResult;

final class b extends TokenResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f9165a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9166b;

    /* renamed from: c  reason: collision with root package name */
    private final TokenResult.ResponseCode f9167c;

    /* renamed from: com.google.firebase.installations.remote.b$b  reason: collision with other inner class name */
    static final class C0107b extends TokenResult.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f9168a;

        /* renamed from: b  reason: collision with root package name */
        private Long f9169b;

        /* renamed from: c  reason: collision with root package name */
        private TokenResult.ResponseCode f9170c;

        public TokenResult build() {
            String str = "";
            if (this.f9169b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.f9168a, this.f9169b.longValue(), this.f9170c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public TokenResult.Builder setResponseCode(TokenResult.ResponseCode responseCode) {
            this.f9170c = responseCode;
            return this;
        }

        public TokenResult.Builder setToken(String str) {
            this.f9168a = str;
            return this;
        }

        public TokenResult.Builder setTokenExpirationTimestamp(long j10) {
            this.f9169b = Long.valueOf(j10);
            return this;
        }

        C0107b() {
        }

        private C0107b(TokenResult tokenResult) {
            this.f9168a = tokenResult.getToken();
            this.f9169b = Long.valueOf(tokenResult.getTokenExpirationTimestamp());
            this.f9170c = tokenResult.getResponseCode();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.f9165a;
        if (str != null ? str.equals(tokenResult.getToken()) : tokenResult.getToken() == null) {
            if (this.f9166b == tokenResult.getTokenExpirationTimestamp()) {
                TokenResult.ResponseCode responseCode = this.f9167c;
                if (responseCode == null) {
                    if (tokenResult.getResponseCode() == null) {
                        return true;
                    }
                } else if (responseCode.equals(tokenResult.getResponseCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    public TokenResult.ResponseCode getResponseCode() {
        return this.f9167c;
    }

    public String getToken() {
        return this.f9165a;
    }

    public long getTokenExpirationTimestamp() {
        return this.f9166b;
    }

    public int hashCode() {
        int i10;
        String str = this.f9165a;
        int i11 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        long j10 = this.f9166b;
        int i12 = (((i10 ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        TokenResult.ResponseCode responseCode = this.f9167c;
        if (responseCode != null) {
            i11 = responseCode.hashCode();
        }
        return i12 ^ i11;
    }

    public TokenResult.Builder toBuilder() {
        return new C0107b(this);
    }

    public String toString() {
        return "TokenResult{token=" + this.f9165a + ", tokenExpirationTimestamp=" + this.f9166b + ", responseCode=" + this.f9167c + "}";
    }

    private b(String str, long j10, TokenResult.ResponseCode responseCode) {
        this.f9165a = str;
        this.f9166b = j10;
        this.f9167c = responseCode;
    }
}
