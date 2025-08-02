package com.google.android.gms.internal.fido;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class zzaz extends zzav implements List, RandomAccess {
    private static final zzcc zza = new h(r.f7086c, 0);
    public static final /* synthetic */ int zzd = 0;

    zzaz() {
    }

    static zzaz zzh(Object[] objArr, int i10) {
        if (i10 == 0) {
            return r.f7086c;
        }
        return new r(objArr, i10);
    }

    public static zzaz zzi(Object[] objArr) {
        if (objArr.length == 0) {
            return r.f7086c;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        int length = objArr2.length;
        zzbq.zzb(objArr2, length);
        return zzh(objArr2, length);
    }

    public static zzaz zzj(Object obj) {
        Object[] objArr = {obj};
        zzbq.zzb(objArr, 1);
        return zzh(objArr, 1);
    }

    @Deprecated
    public final void add(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i10, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i10 = 0;
                    while (i10 < size) {
                        if (zzao.zza(get(i10), list.get(i10))) {
                            i10++;
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it2.hasNext()) {
                            if (!zzao.zza(it.next(), it2.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = (i10 * 31) + get(i11).hashCode();
        }
        return i10;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (obj.equals(get(i10))) {
                return i10;
            }
        }
        return -1;
    }

    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Deprecated
    public final Object remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object set(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i11] = get(i11);
        }
        return size;
    }

    public final zzcb zzd() {
        return listIterator(0);
    }

    public zzaz zzf() {
        if (size() <= 1) {
            return this;
        }
        return new i(this);
    }

    /* renamed from: zzg */
    public zzaz subList(int i10, int i11) {
        zzap.zze(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == size()) {
            return this;
        }
        if (i12 == 0) {
            return r.f7086c;
        }
        return new j(this, i10, i12);
    }

    /* renamed from: zzk */
    public final zzcc listIterator(int i10) {
        zzap.zzb(i10, size(), FirebaseAnalytics.Param.INDEX);
        if (isEmpty()) {
            return zza;
        }
        return new h(this, i10);
    }
}
