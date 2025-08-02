package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzgs;

final class v0 extends zzch {

    /* renamed from: a  reason: collision with root package name */
    private final zzgs f7332a;

    v0(zzgs zzgs) {
        this.f7332a = zzgs;
    }

    public final int zzd() {
        return System.identityHashCode(this.f7332a);
    }

    public final void zze(String str, String str2, Bundle bundle, long j10) {
        this.f7332a.onEvent(str, str2, bundle, j10);
    }
}
