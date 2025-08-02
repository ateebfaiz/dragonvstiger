package com.google.android.gms.internal.p001authapi;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.o  reason: invalid package */
final class o extends q {
    o(zbl zbl, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, zbt zbt) {
        zbt.zbf(new p(this));
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
