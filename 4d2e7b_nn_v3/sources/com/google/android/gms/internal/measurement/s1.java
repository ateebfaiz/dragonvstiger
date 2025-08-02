package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class s1 extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzhf f7309a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    s1(zzhf zzhf, Handler handler) {
        super((Handler) null);
        this.f7309a = zzhf;
    }

    public final void onChange(boolean z10) {
        this.f7309a.zzf();
    }
}
