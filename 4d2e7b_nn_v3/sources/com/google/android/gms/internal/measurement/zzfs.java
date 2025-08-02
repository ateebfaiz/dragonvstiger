package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzfs extends zzkb implements zzln {
    private zzfs() {
        super(zzft.zza);
    }

    public final int zza() {
        return ((zzft) this.zza).zzb();
    }

    public final long zzb() {
        return ((zzft) this.zza).zzc();
    }

    public final long zzc() {
        return ((zzft) this.zza).zzd();
    }

    public final zzfs zzd(Iterable iterable) {
        zzaG();
        zzft.zzm((zzft) this.zza, iterable);
        return this;
    }

    public final zzfs zze(zzfw zzfw) {
        zzaG();
        zzft.zzk((zzft) this.zza, (zzfx) zzfw.zzaC());
        return this;
    }

    public final zzfs zzf(zzfx zzfx) {
        zzaG();
        zzft.zzk((zzft) this.zza, zzfx);
        return this;
    }

    public final zzfs zzg() {
        zzaG();
        ((zzft) this.zza).zze = zzkf.zzbE();
        return this;
    }

    public final zzfs zzh(int i10) {
        zzaG();
        zzft.zzo((zzft) this.zza, i10);
        return this;
    }

    public final zzfs zzi(String str) {
        zzaG();
        zzft.zzp((zzft) this.zza, str);
        return this;
    }

    public final zzfs zzj(int i10, zzfw zzfw) {
        zzaG();
        zzft.zzj((zzft) this.zza, i10, (zzfx) zzfw.zzaC());
        return this;
    }

    public final zzfs zzk(int i10, zzfx zzfx) {
        zzaG();
        zzft.zzj((zzft) this.zza, i10, zzfx);
        return this;
    }

    public final zzfs zzl(long j10) {
        zzaG();
        zzft.zzr((zzft) this.zza, j10);
        return this;
    }

    public final zzfs zzm(long j10) {
        zzaG();
        zzft.zzq((zzft) this.zza, j10);
        return this;
    }

    public final zzfx zzn(int i10) {
        return ((zzft) this.zza).zzg(i10);
    }

    public final String zzo() {
        return ((zzft) this.zza).zzh();
    }

    public final List zzp() {
        return Collections.unmodifiableList(((zzft) this.zza).zzi());
    }

    public final boolean zzq() {
        return ((zzft) this.zza).zzu();
    }

    /* synthetic */ zzfs(k1 k1Var) {
        super(zzft.zza);
    }
}
