package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzkt extends g2 implements RandomAccess, zzku {
    public static final zzku zza;
    private static final zzkt zzb;
    private final List zzc;

    static {
        zzkt zzkt = new zzkt(10);
        zzb = zzkt;
        zzkt.zzb();
        zza = zzkt;
    }

    public zzkt() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzje) {
            return ((zzje) obj).zzn(zzkn.zzb);
        }
        return zzkn.zzg((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i10, Object obj) {
        zzbT();
        this.zzc.add(i10, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i10, Collection collection) {
        zzbT();
        if (collection instanceof zzku) {
            collection = ((zzku) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i10, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzbT();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        zzbT();
        Object remove = this.zzc.remove(i10);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        zzbT();
        return zzj(this.zzc.set(i10, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzkm zzd(int i10) {
        if (i10 >= size()) {
            ArrayList arrayList = new ArrayList(i10);
            arrayList.addAll(this.zzc);
            return new zzkt(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzku zze() {
        if (zzc()) {
            return new zzmt(this);
        }
        return this;
    }

    public final Object zzf(int i10) {
        return this.zzc.get(i10);
    }

    /* renamed from: zzg */
    public final String get(int i10) {
        Object obj = this.zzc.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzje) {
            zzje zzje = (zzje) obj;
            String zzn = zzje.zzn(zzkn.zzb);
            if (zzje.zzi()) {
                this.zzc.set(i10, zzn);
            }
            return zzn;
        }
        byte[] bArr = (byte[]) obj;
        String zzg = zzkn.zzg(bArr);
        if (zzkn.zzh(bArr)) {
            this.zzc.set(i10, zzg);
        }
        return zzg;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzje zzje) {
        zzbT();
        this.zzc.add(zzje);
        this.modCount++;
    }

    public zzkt(int i10) {
        this.zzc = new ArrayList(i10);
    }

    private zzkt(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
