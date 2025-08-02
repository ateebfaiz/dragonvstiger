package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;

final class c extends ClientInfo {

    /* renamed from: a  reason: collision with root package name */
    private final ClientInfo.ClientType f6366a;

    /* renamed from: b  reason: collision with root package name */
    private final AndroidClientInfo f6367b;

    static final class b extends ClientInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        private ClientInfo.ClientType f6368a;

        /* renamed from: b  reason: collision with root package name */
        private AndroidClientInfo f6369b;

        b() {
        }

        public ClientInfo build() {
            return new c(this.f6368a, this.f6369b);
        }

        public ClientInfo.Builder setAndroidClientInfo(AndroidClientInfo androidClientInfo) {
            this.f6369b = androidClientInfo;
            return this;
        }

        public ClientInfo.Builder setClientType(ClientInfo.ClientType clientType) {
            this.f6368a = clientType;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType = this.f6366a;
        if (clientType != null ? clientType.equals(clientInfo.getClientType()) : clientInfo.getClientType() == null) {
            AndroidClientInfo androidClientInfo = this.f6367b;
            if (androidClientInfo == null) {
                if (clientInfo.getAndroidClientInfo() == null) {
                    return true;
                }
            } else if (androidClientInfo.equals(clientInfo.getAndroidClientInfo())) {
                return true;
            }
        }
        return false;
    }

    public AndroidClientInfo getAndroidClientInfo() {
        return this.f6367b;
    }

    public ClientInfo.ClientType getClientType() {
        return this.f6366a;
    }

    public int hashCode() {
        int i10;
        ClientInfo.ClientType clientType = this.f6366a;
        int i11 = 0;
        if (clientType == null) {
            i10 = 0;
        } else {
            i10 = clientType.hashCode();
        }
        int i12 = (i10 ^ 1000003) * 1000003;
        AndroidClientInfo androidClientInfo = this.f6367b;
        if (androidClientInfo != null) {
            i11 = androidClientInfo.hashCode();
        }
        return i12 ^ i11;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f6366a + ", androidClientInfo=" + this.f6367b + "}";
    }

    private c(ClientInfo.ClientType clientType, AndroidClientInfo androidClientInfo) {
        this.f6366a = clientType;
        this.f6367b = androidClientInfo;
    }
}
