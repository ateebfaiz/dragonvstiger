package com.google.android.gms.internal.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jspecify.nullness.NullMarked;

@NullMarked
public final class zzx {
    /* access modifiers changed from: private */
    public final zzo zza;
    /* access modifiers changed from: private */
    public final boolean zzb;
    private final m zzc;

    private zzx(m mVar, boolean z10, zzo zzo, int i10) {
        this.zzc = mVar;
        this.zzb = z10;
        this.zza = zzo;
    }

    public static zzx zzc(zzo zzo) {
        return new zzx(new m(zzo), false, j.f7038b, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: private */
    public final Iterator zzh(CharSequence charSequence) {
        return new l(this.zzc, this, charSequence);
    }

    public final zzx zzb() {
        return new zzx(this.zzc, true, this.zza, Integer.MAX_VALUE);
    }

    public final Iterable zzd(CharSequence charSequence) {
        return new n(this, charSequence);
    }

    public final List zzf(CharSequence charSequence) {
        charSequence.getClass();
        Iterator zzh = zzh(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzh.hasNext()) {
            arrayList.add((String) zzh.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
