package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

final class t implements ProxyApi.ProxyResult {

    /* renamed from: a  reason: collision with root package name */
    private final Status f6996a;

    /* renamed from: b  reason: collision with root package name */
    private ProxyResponse f6997b;

    public t(Status status) {
        this.f6996a = status;
    }

    public final ProxyResponse getResponse() {
        return this.f6997b;
    }

    public final Status getStatus() {
        return this.f6996a;
    }

    public t(ProxyResponse proxyResponse) {
        this.f6997b = proxyResponse;
        this.f6996a = Status.RESULT_SUCCESS;
    }
}
