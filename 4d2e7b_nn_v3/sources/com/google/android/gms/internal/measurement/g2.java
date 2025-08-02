package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class g2 extends AbstractList implements zzkm {
    private boolean zza = true;

    g2() {
    }

    public boolean add(Object obj) {
        zzbT();
        return super.add(obj);
    }

    public boolean addAll(int i10, Collection collection) {
        zzbT();
        return super.addAll(i10, collection);
    }

    public void clear() {
        zzbT();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (!get(i10).equals(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = (i10 * 31) + get(i11).hashCode();
        }
        return i10;
    }

    public abstract Object remove(int i10);

    public final boolean remove(Object obj) {
        zzbT();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    public final boolean removeAll(Collection collection) {
        zzbT();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        zzbT();
        return super.retainAll(collection);
    }

    public final void zzb() {
        this.zza = false;
    }

    /* access modifiers changed from: protected */
    public final void zzbT() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean zzc() {
        return this.zza;
    }

    public boolean addAll(Collection collection) {
        zzbT();
        return super.addAll(collection);
    }
}
