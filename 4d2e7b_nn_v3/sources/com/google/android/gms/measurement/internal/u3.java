package com.google.android.gms.measurement.internal;

abstract class u3 extends t3 {
    private boolean zza;

    u3(zzkt zzkt) {
        super(zzkt);
        this.zzf.zzM();
    }

    /* access modifiers changed from: protected */
    public final void zzW() {
        if (!zzY()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzX() {
        if (!this.zza) {
            zzb();
            this.zzf.zzH();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzY() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzb();
}
