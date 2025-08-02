package com.google.android.gms.measurement.internal;

abstract class y0 extends x0 {
    private boolean zza;

    y0(zzfr zzfr) {
        super(zzfr);
        this.zzt.zzD();
    }

    /* access modifiers changed from: protected */
    public void zzaA() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzf();

    /* access modifiers changed from: protected */
    public final void zzu() {
        if (!zzx()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzv() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzf()) {
            this.zzt.zzB();
            this.zza = true;
        }
    }

    public final void zzw() {
        if (!this.zza) {
            zzaA();
            this.zzt.zzB();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzx() {
        return this.zza;
    }
}
