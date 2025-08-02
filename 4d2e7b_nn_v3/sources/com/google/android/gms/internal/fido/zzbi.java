package com.google.android.gms.internal.fido;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;

public abstract class zzbi extends o implements NavigableSet, x {
    final transient Comparator zza;
    transient zzbi zzb;

    zzbi(Comparator comparator) {
        this.zza = comparator;
    }

    static t zzq(Comparator comparator) {
        if (q.f7085a.equals(comparator)) {
            return t.f7097b;
        }
        int i10 = zzaz.zzd;
        return new t(r.f7086c, comparator);
    }

    public Object ceiling(Object obj) {
        obj.getClass();
        return zzbk.zza(zzp(obj, true), (Object) null);
    }

    public final Comparator comparator() {
        return this.zza;
    }

    public Object first() {
        return iterator().next();
    }

    public Object floor(Object obj) {
        obj.getClass();
        return zzbm.zza(zzm(obj, true).descendingIterator(), (Object) null);
    }

    public final /* synthetic */ SortedSet headSet(Object obj) {
        obj.getClass();
        return zzm(obj, false);
    }

    public Object higher(Object obj) {
        obj.getClass();
        return zzbk.zza(zzp(obj, false), (Object) null);
    }

    public Object last() {
        return descendingIterator().next();
    }

    public Object lower(Object obj) {
        obj.getClass();
        return zzbm.zza(zzm(obj, false).descendingIterator(), (Object) null);
    }

    @Deprecated
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    public final /* synthetic */ SortedSet tailSet(Object obj) {
        obj.getClass();
        return zzp(obj, true);
    }

    /* renamed from: zzd */
    public abstract zzcb iterator();

    /* access modifiers changed from: package-private */
    public abstract zzbi zzf();

    /* renamed from: zzl */
    public final zzbi descendingSet() {
        zzbi zzbi = this.zzb;
        if (zzbi != null) {
            return zzbi;
        }
        zzbi zzf = zzf();
        this.zzb = zzf;
        zzf.zzb = this;
        return zzf;
    }

    /* access modifiers changed from: package-private */
    public abstract zzbi zzm(Object obj, boolean z10);

    /* renamed from: zzn */
    public final zzbi subSet(Object obj, boolean z10, Object obj2, boolean z11) {
        boolean z12;
        obj.getClass();
        obj2.getClass();
        if (this.zza.compare(obj, obj2) <= 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        zzap.zzc(z12);
        return zzo(obj, z10, obj2, z11);
    }

    /* access modifiers changed from: package-private */
    public abstract zzbi zzo(Object obj, boolean z10, Object obj2, boolean z11);

    /* access modifiers changed from: package-private */
    public abstract zzbi zzp(Object obj, boolean z10);

    /* renamed from: zzr */
    public abstract zzcb descendingIterator();

    public final /* synthetic */ NavigableSet headSet(Object obj, boolean z10) {
        obj.getClass();
        return zzm(obj, z10);
    }

    public final /* synthetic */ NavigableSet tailSet(Object obj, boolean z10) {
        obj.getClass();
        return zzp(obj, z10);
    }
}
