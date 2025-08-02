package com.google.android.gms.internal.p001authapi;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* renamed from: com.google.android.gms.internal.auth-api.q  reason: invalid package */
abstract class q extends BaseImplementation.ApiMethodImpl {
    q(GoogleApiClient googleApiClient) {
        super((Api<?>) Auth.CREDENTIALS_API, googleApiClient);
    }

    /* access modifiers changed from: protected */
    public abstract void a(Context context, zbt zbt);

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        zbo zbo = (zbo) anyClient;
        a(zbo.getContext(), (zbt) zbo.getService());
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }
}
