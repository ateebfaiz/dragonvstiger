package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class j implements Result {

    /* renamed from: a  reason: collision with root package name */
    private final Status f6937a;

    public j(Status status) {
        this.f6937a = status;
    }

    public final Status getStatus() {
        return this.f6937a;
    }
}
