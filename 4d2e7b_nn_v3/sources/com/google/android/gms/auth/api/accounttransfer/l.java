package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzan;

final class l extends zzan {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f6625a;

    l(m mVar) {
        this.f6625a = mVar;
    }

    public final void zzd(Status status) {
        this.f6625a.f6624a.setException(new AccountTransferException(status));
    }

    public final void zze() {
        this.f6625a.f6624a.setResult(null);
    }
}
