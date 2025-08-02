package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* renamed from: com.google.android.gms.internal.auth-api.p  reason: invalid package */
final class p extends zbd {

    /* renamed from: a  reason: collision with root package name */
    private final BaseImplementation.ResultHolder f6885a;

    p(BaseImplementation.ResultHolder resultHolder) {
        this.f6885a = resultHolder;
    }

    public final void zbc(Status status) {
        this.f6885a.setResult(status);
    }
}
