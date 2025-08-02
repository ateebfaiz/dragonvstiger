package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

final class c extends zaa {

    /* renamed from: a  reason: collision with root package name */
    private final BaseImplementation.ResultHolder f6812a;

    public c(BaseImplementation.ResultHolder resultHolder) {
        this.f6812a = resultHolder;
    }

    public final void zab(int i10) {
        this.f6812a.setResult(new Status(i10));
    }
}
