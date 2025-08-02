package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class b extends BasePendingResult {

    /* renamed from: a  reason: collision with root package name */
    private final Result f6649a;

    public b(Result result) {
        super(Looper.getMainLooper());
        this.f6649a = result;
    }

    /* access modifiers changed from: protected */
    public final Result createFailedResult(Status status) {
        if (status.getStatusCode() == this.f6649a.getStatus().getStatusCode()) {
            return this.f6649a;
        }
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
