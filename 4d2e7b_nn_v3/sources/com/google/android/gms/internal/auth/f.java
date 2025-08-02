package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

final class f extends h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f6918a;

    f(g gVar) {
        this.f6918a = gVar;
    }

    public final void zzc(boolean z10) {
        Status status;
        g gVar = this.f6918a;
        if (z10) {
            status = Status.RESULT_SUCCESS;
        } else {
            status = zzal.zza;
        }
        gVar.setResult(new k(status));
    }
}
