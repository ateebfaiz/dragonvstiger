package com.google.android.gms.internal.fido;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class t extends zzbi {

    /* renamed from: b  reason: collision with root package name */
    static final t f7097b = new t(r.f7086c, q.f7085a);

    /* renamed from: a  reason: collision with root package name */
    final transient zzaz f7098a;

    static {
        int i10 = zzaz.zzd;
    }

    t(zzaz zzaz, Comparator comparator) {
        super(comparator);
        this.f7098a = zzaz;
    }

    /* access modifiers changed from: package-private */
    public final int a(Object obj, boolean z10) {
        zzaz zzaz = this.f7098a;
        obj.getClass();
        int binarySearch = Collections.binarySearch(zzaz, obj, this.zza);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        if (z10) {
            return binarySearch + 1;
        }
        return binarySearch;
    }

    /* access modifiers changed from: package-private */
    public final int c(Object obj, boolean z10) {
        zzaz zzaz = this.f7098a;
        obj.getClass();
        int binarySearch = Collections.binarySearch(zzaz, obj, this.zza);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        if (z10) {
            return binarySearch;
        }
        return binarySearch + 1;
    }

    public final Object ceiling(Object obj) {
        int c10 = c(obj, true);
        if (c10 == this.f7098a.size()) {
            return null;
        }
        return this.f7098a.get(c10);
    }

    public final boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.f7098a, obj, this.zza) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public final boolean containsAll(Collection collection) {
        if (collection instanceof zzbo) {
            collection = ((zzbo) collection).zza();
        }
        if (!y.a(this.zza, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        zzcc zzk = this.f7098a.listIterator(0);
        Iterator it = collection.iterator();
        if (!zzk.hasNext()) {
            return false;
        }
        Object next = it.next();
        Object next2 = zzk.next();
        while (true) {
            try {
                int compare = this.zza.compare(next2, next);
                if (compare >= 0) {
                    if (compare != 0) {
                        break;
                    } else if (!it.hasNext()) {
                        return true;
                    } else {
                        next = it.next();
                    }
                } else if (!zzk.hasNext()) {
                    return false;
                } else {
                    next2 = zzk.next();
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final t d(int i10, int i11) {
        if (i10 == 0) {
            if (i11 == this.f7098a.size()) {
                return this;
            }
            i10 = 0;
        }
        if (i10 < i11) {
            return new t(this.f7098a.subList(i10, i11), this.zza);
        }
        return zzbi.zzq(this.zza);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038 A[Catch:{ ClassCastException | NoSuchElementException -> 0x004c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof java.util.Set
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.Set r7 = (java.util.Set) r7
            com.google.android.gms.internal.fido.zzaz r1 = r6.f7098a
            int r1 = r1.size()
            int r3 = r7.size()
            if (r1 == r3) goto L_0x0019
            return r2
        L_0x0019:
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L_0x0020
            return r0
        L_0x0020:
            java.util.Comparator r1 = r6.zza
            boolean r1 = com.google.android.gms.internal.fido.y.a(r1, r7)
            if (r1 == 0) goto L_0x004d
            java.util.Iterator r7 = r7.iterator()
            com.google.android.gms.internal.fido.zzaz r1 = r6.f7098a     // Catch:{ ClassCastException | NoSuchElementException -> 0x004c }
            com.google.android.gms.internal.fido.zzcc r1 = r1.listIterator(r2)     // Catch:{ ClassCastException | NoSuchElementException -> 0x004c }
        L_0x0032:
            boolean r3 = r1.hasNext()     // Catch:{ ClassCastException | NoSuchElementException -> 0x004c }
            if (r3 == 0) goto L_0x004b
            java.lang.Object r3 = r1.next()     // Catch:{ ClassCastException | NoSuchElementException -> 0x004c }
            java.lang.Object r4 = r7.next()     // Catch:{ ClassCastException | NoSuchElementException -> 0x004c }
            if (r4 == 0) goto L_0x004a
            java.util.Comparator r5 = r6.zza     // Catch:{ ClassCastException | NoSuchElementException -> 0x004c }
            int r3 = r5.compare(r3, r4)     // Catch:{ ClassCastException | NoSuchElementException -> 0x004c }
            if (r3 == 0) goto L_0x0032
        L_0x004a:
            return r2
        L_0x004b:
            return r0
        L_0x004c:
            return r2
        L_0x004d:
            boolean r7 = r6.containsAll(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.t.equals(java.lang.Object):boolean");
    }

    public final Object first() {
        if (!isEmpty()) {
            return this.f7098a.get(0);
        }
        throw new NoSuchElementException();
    }

    public final Object floor(Object obj) {
        int a10 = a(obj, true) - 1;
        if (a10 == -1) {
            return null;
        }
        return this.f7098a.get(a10);
    }

    public final Object higher(Object obj) {
        int c10 = c(obj, false);
        if (c10 == this.f7098a.size()) {
            return null;
        }
        return this.f7098a.get(c10);
    }

    public final /* synthetic */ Iterator iterator() {
        return this.f7098a.listIterator(0);
    }

    public final Object last() {
        if (!isEmpty()) {
            zzaz zzaz = this.f7098a;
            return zzaz.get(zzaz.size() - 1);
        }
        throw new NoSuchElementException();
    }

    public final Object lower(Object obj) {
        int a10 = a(obj, false) - 1;
        if (a10 == -1) {
            return null;
        }
        return this.f7098a.get(a10);
    }

    public final int size() {
        return this.f7098a.size();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i10) {
        return this.f7098a.zza(objArr, 0);
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.f7098a.zzb();
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return this.f7098a.zzc();
    }

    public final zzcb zzd() {
        return this.f7098a.listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.f7098a.zze();
    }

    /* access modifiers changed from: package-private */
    public final zzbi zzf() {
        Comparator reverseOrder = Collections.reverseOrder(this.zza);
        if (isEmpty()) {
            return zzbi.zzq(reverseOrder);
        }
        return new t(this.f7098a.zzf(), reverseOrder);
    }

    public final zzaz zzi() {
        return this.f7098a;
    }

    /* access modifiers changed from: package-private */
    public final zzbi zzm(Object obj, boolean z10) {
        return d(0, a(obj, z10));
    }

    /* access modifiers changed from: package-private */
    public final zzbi zzo(Object obj, boolean z10, Object obj2, boolean z11) {
        return zzp(obj, z10).zzm(obj2, z11);
    }

    /* access modifiers changed from: package-private */
    public final zzbi zzp(Object obj, boolean z10) {
        return d(c(obj, z10), this.f7098a.size());
    }

    /* renamed from: zzr */
    public final zzcb descendingIterator() {
        return this.f7098a.zzf().listIterator(0);
    }
}
