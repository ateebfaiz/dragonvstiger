package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzgr;

final class u0 extends zzch {

    /* renamed from: a  reason: collision with root package name */
    private final zzgr f7324a;

    u0(zzgr zzgr) {
        this.f7324a = zzgr;
    }

    public final int zzd() {
        return System.identityHashCode(this.f7324a);
    }

    public final void zze(String str, String str2, Bundle bundle, long j10) {
        this.f7324a.interceptEvent(str, str2, bundle, j10);
    }
}
