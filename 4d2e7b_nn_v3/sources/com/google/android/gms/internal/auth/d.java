package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;

final class d extends h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f6908a;

    d(e eVar) {
        this.f6908a = eVar;
    }

    public final void zzb(Account account) {
        Status status;
        e eVar = this.f6908a;
        if (account != null) {
            status = Status.RESULT_SUCCESS;
        } else {
            status = zzal.zza;
        }
        eVar.setResult(new i(status, account));
    }
}
