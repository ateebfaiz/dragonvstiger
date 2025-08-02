package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.InlineMe;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.jspecify.nullness.NullMarked;

@NullMarked
public abstract class zzag extends zzac implements List, RandomAccess {
    private static final zzak zza = new b(d.f7031c, 0);

    zzag() {
    }

    static zzag zzi(Object[] objArr, int i10) {
        if (i10 == 0) {
            return d.f7031c;
        }
        return new d(objArr, i10);
    }

    public static zzag zzj(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return zzk((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return d.f7031c;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return zzm(next);
        }
        zzad zzad = new zzad(4);
        zzad.zzb(next);
        zzad.zzc(it);
        zzad.zzc = true;
        return zzi(zzad.zza, zzad.zzb);
    }

    public static zzag zzk(Collection collection) {
        if (collection instanceof zzac) {
            zzag zzd = ((zzac) collection).zzd();
            if (!zzd.zzf()) {
                return zzd;
            }
            Object[] array = zzd.toArray();
            return zzi(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzah.zza(array2, length);
        return zzi(array2, length);
    }

    public static zzag zzl() {
        return d.f7031c;
    }

    public static zzag zzm(Object obj) {
        Object[] objArr = {obj};
        zzah.zza(objArr, 1);
        return zzi(objArr, 1);
    }

    public static zzag zzn(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzah.zza(objArr, 2);
        return zzi(objArr, 2);
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void add(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean addAll(int i10, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(Object obj) {
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
                        if (zzr.zza(get(i10), list.get(i10))) {
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
                            if (!zzr.zza(it.next(), it2.next())) {
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

    public final int indexOf(Object obj) {
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

    public final int lastIndexOf(Object obj) {
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

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final Object remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
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

    @InlineMe(replacement = "this")
    @Deprecated
    public final zzag zzd() {
        return this;
    }

    public final zzaj zze() {
        return listIterator(0);
    }

    /* renamed from: zzh */
    public zzag subList(int i10, int i11) {
        zzs.zzc(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == size()) {
            return this;
        }
        if (i12 == 0) {
            return d.f7031c;
        }
        return new c(this, i10, i12);
    }

    /* renamed from: zzo */
    public final zzak listIterator(int i10) {
        zzs.zzb(i10, size(), FirebaseAnalytics.Param.INDEX);
        if (isEmpty()) {
            return zza;
        }
        return new b(this, i10);
    }
}
