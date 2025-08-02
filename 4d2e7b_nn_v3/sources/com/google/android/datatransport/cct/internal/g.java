package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;

final class g extends NetworkConnectionInfo {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkConnectionInfo.NetworkType f6399a;

    /* renamed from: b  reason: collision with root package name */
    private final NetworkConnectionInfo.MobileSubtype f6400b;

    static final class b extends NetworkConnectionInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        private NetworkConnectionInfo.NetworkType f6401a;

        /* renamed from: b  reason: collision with root package name */
        private NetworkConnectionInfo.MobileSubtype f6402b;

        b() {
        }

        public NetworkConnectionInfo build() {
            return new g(this.f6401a, this.f6402b);
        }

        public NetworkConnectionInfo.Builder setMobileSubtype(NetworkConnectionInfo.MobileSubtype mobileSubtype) {
            this.f6402b = mobileSubtype;
            return this;
        }

        public NetworkConnectionInfo.Builder setNetworkType(NetworkConnectionInfo.NetworkType networkType) {
            this.f6401a = networkType;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkConnectionInfo)) {
            return false;
        }
        NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
        NetworkConnectionInfo.NetworkType networkType = this.f6399a;
        if (networkType != null ? networkType.equals(networkConnectionInfo.getNetworkType()) : networkConnectionInfo.getNetworkType() == null) {
            NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f6400b;
            if (mobileSubtype == null) {
                if (networkConnectionInfo.getMobileSubtype() == null) {
                    return true;
                }
            } else if (mobileSubtype.equals(networkConnectionInfo.getMobileSubtype())) {
                return true;
            }
        }
        return false;
    }

    public NetworkConnectionInfo.MobileSubtype getMobileSubtype() {
        return this.f6400b;
    }

    public NetworkConnectionInfo.NetworkType getNetworkType() {
        return this.f6399a;
    }

    public int hashCode() {
        int i10;
        NetworkConnectionInfo.NetworkType networkType = this.f6399a;
        int i11 = 0;
        if (networkType == null) {
            i10 = 0;
        } else {
            i10 = networkType.hashCode();
        }
        int i12 = (i10 ^ 1000003) * 1000003;
        NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f6400b;
        if (mobileSubtype != null) {
            i11 = mobileSubtype.hashCode();
        }
        return i12 ^ i11;
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f6399a + ", mobileSubtype=" + this.f6400b + "}";
    }

    private g(NetworkConnectionInfo.NetworkType networkType, NetworkConnectionInfo.MobileSubtype mobileSubtype) {
        this.f6399a = networkType;
        this.f6400b = mobileSubtype;
    }
}
