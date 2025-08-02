package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private final ApiKey f6683a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource f6684b = new TaskCompletionSource();

    public e(ApiKey apiKey) {
        this.f6683a = apiKey;
    }

    public final ApiKey a() {
        return this.f6683a;
    }

    public final TaskCompletionSource b() {
        return this.f6684b;
    }
}
