package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

final class c extends BasePendingResult {

    /* renamed from: a  reason: collision with root package name */
    private final Result f6650a;

    public c(GoogleApiClient googleApiClient, Result result) {
        super(googleApiClient);
        this.f6650a = result;
    }

    /* access modifiers changed from: protected */
    public final Result createFailedResult(Status status) {
        return this.f6650a;
    }
}
