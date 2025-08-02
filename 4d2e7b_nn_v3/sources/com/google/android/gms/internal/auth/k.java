package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class k implements Result {

    /* renamed from: a  reason: collision with root package name */
    private final Status f6946a;

    public k(Status status) {
        this.f6946a = status;
    }

    public final Status getStatus() {
        return this.f6946a;
    }
}
