package com.mah.sdk;

import android.util.Log;
import com.mah.sdk.MahProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MahProxyOptions {
    public final boolean OooO;
    public final boolean OooO00o;
    public final String OooO0O0;
    public final boolean OooO0OO;
    public final List<String> OooO0Oo;
    public final boolean OooO0o;

    /* renamed from: OooO0o0  reason: collision with root package name */
    public final String f10168OooO0o0;
    public final boolean OooO0oO;
    public final MahProxy.ProxyListener OooO0oo;
    public final int OooOO0;
    public final boolean OooOO0O;
    public final List<String> OooOO0o;
    public final boolean OooOOO;
    public final List<String> OooOOO0;

    public static class Builder {
        /* access modifiers changed from: private */
        public int authTimeoutMillis = 0;
        /* access modifiers changed from: private */
        public final List<String> blacklistDomains = new ArrayList();
        /* access modifiers changed from: private */
        public boolean crashCollectEnabled = true;
        /* access modifiers changed from: private */
        public boolean enableReturnNodeIp = false;
        /* access modifiers changed from: private */
        public MahProxy.ProxyListener proxyListener;
        /* access modifiers changed from: private */
        public boolean sdkErrorDirectResponse = false;
        private final boolean startUseAsync = false;
        /* access modifiers changed from: private */
        public String userID = "";
        /* access modifiers changed from: private */
        public boolean waitForAuthEnabled = false;
        /* access modifiers changed from: private */
        public final List<String> whitelistDomains = new ArrayList();

        public MahProxyOptions build() {
            return new MahProxyOptions(this);
        }

        public Builder enableReturnNodeIp() {
            this.enableReturnNodeIp = true;
            return this;
        }

        public Builder setBlacklist(List<String> list) {
            if (list != null) {
                this.blacklistDomains.addAll(list);
                return this;
            }
            throw new NullPointerException("blacklist must not null");
        }

        public Builder setCrashCollectEnabled(boolean z10) {
            this.crashCollectEnabled = z10;
            return this;
        }

        public Builder setProxyListener(MahProxy.ProxyListener proxyListener2) {
            this.proxyListener = proxyListener2;
            return this;
        }

        public Builder setSdkErrorDirectResponse(boolean z10) {
            this.sdkErrorDirectResponse = z10;
            return this;
        }

        public Builder setUserID(String str) {
            this.userID = str;
            return this;
        }

        public Builder setWaitForAuthEnabled(int i10) {
            this.waitForAuthEnabled = true;
            if (i10 < 1000) {
                Log.d("MAH", "timeoutMillis must >= 1000");
                i10 = 1000;
            }
            this.authTimeoutMillis = i10;
            return this;
        }

        public Builder setWhitelist(List<String> list) {
            if (list != null) {
                this.whitelistDomains.addAll(list);
                return this;
            }
            throw new NullPointerException("whitelist must not null");
        }
    }

    public void OooO00o() {
        this.OooOO0o.size();
        this.OooOOO0.size();
    }

    public MahProxyOptions() {
        this(new Builder());
    }

    public MahProxyOptions(Builder builder) {
        this.OooO0O0 = "";
        this.OooO0o = false;
        this.OooO0oO = true;
        this.OooO0Oo = Collections.emptyList();
        this.OooO00o = builder.crashCollectEnabled;
        this.OooO0OO = false;
        this.f10168OooO0o0 = builder.userID;
        this.OooO0oo = builder.proxyListener;
        this.OooO = builder.waitForAuthEnabled;
        this.OooOO0 = builder.authTimeoutMillis;
        this.OooOO0O = builder.enableReturnNodeIp;
        this.OooOO0o = builder.whitelistDomains;
        this.OooOOO0 = builder.blacklistDomains;
        this.OooOOO = builder.sdkErrorDirectResponse;
    }
}
