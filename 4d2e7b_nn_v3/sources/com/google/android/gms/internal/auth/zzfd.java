package com.google.android.gms.internal.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzfd extends l0 implements RandomAccess, zzfe {
    public static final zzfe zza;
    private static final zzfd zzb;
    private final List zzc;

    static {
        zzfd zzfd = new zzfd(10);
        zzb = zzfd;
        zzfd.zzb();
        zza = zzfd;
    }

    public zzfd() {
        this(10);
    }

    private static String zzh(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzee) {
            return ((zzee) obj).zzm(zzez.zzb);
        }
        return zzez.zzh((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i10, Object obj) {
        zza();
        this.zzc.add(i10, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i10, Collection collection) {
        zza();
        if (collection instanceof zzfe) {
            collection = ((zzfe) collection).zzg();
        }
        boolean addAll = this.zzc.addAll(i10, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        zza();
        Object remove = this.zzc.remove(i10);
        this.modCount++;
        return zzh(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        zza();
        return zzh(this.zzc.set(i10, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzey zzd(int i10) {
        if (i10 >= size()) {
            ArrayList arrayList = new ArrayList(i10);
            arrayList.addAll(this.zzc);
            return new zzfd(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzfe zze() {
        if (zzc()) {
            return new zzhd(this);
        }
        return this;
    }

    /* renamed from: zzf */
    public final String get(int i10) {
        Object obj = this.zzc.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzee) {
            zzee zzee = (zzee) obj;
            String zzm = zzee.zzm(zzez.zzb);
            if (zzee.zzh()) {
                this.zzc.set(i10, zzm);
            }
            return zzm;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzez.zzh(bArr);
        if (zzez.zzi(bArr)) {
            this.zzc.set(i10, zzh);
        }
        return zzh;
    }

    public final List zzg() {
        return Collections.unmodifiableList(this.zzc);
    }

    public zzfd(int i10) {
        this.zzc = new ArrayList(i10);
    }

    private zzfd(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
