package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

final class d extends BasePendingResult {
    public d(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final Result createFailedResult(Status status) {
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
