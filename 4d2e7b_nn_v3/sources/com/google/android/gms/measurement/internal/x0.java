package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import org.checkerframework.dataflow.qual.Pure;

abstract class x0 implements z0 {
    protected final zzfr zzt;

    x0(zzfr zzfr) {
        Preconditions.checkNotNull(zzfr);
        this.zzt = zzfr;
    }

    @Pure
    public final Context zzau() {
        throw null;
    }

    @Pure
    public final Clock zzav() {
        throw null;
    }

    @Pure
    public final zzab zzaw() {
        throw null;
    }

    public void zzax() {
        this.zzt.zzaz().zzax();
    }

    @Pure
    public final zzeh zzay() {
        throw null;
    }

    @Pure
    public final zzfo zzaz() {
        throw null;
    }

    public void zzg() {
        this.zzt.zzaz().zzg();
    }
}
