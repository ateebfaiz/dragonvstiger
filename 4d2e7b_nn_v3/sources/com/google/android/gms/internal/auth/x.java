package com.google.android.gms.internal.auth;

import android.database.ContentObserver;
import android.os.Handler;

final class x extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzcg f7013a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    x(zzcg zzcg, Handler handler) {
        super((Handler) null);
        this.f7013a = zzcg;
    }

    public final void onChange(boolean z10) {
        this.f7013a.zze();
    }
}
