package com.google.android.gms.internal.fido;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

public final class zzbg extends n implements NavigableMap {
    public static final /* synthetic */ int zzb = 0;
    private static final Comparator zzc;
    private static final zzbg zzd;
    /* access modifiers changed from: private */
    public final transient t zze;
    /* access modifiers changed from: private */
    public final transient zzaz zzf;
    private final transient zzbg zzg;

    static {
        q qVar = q.f7085a;
        zzc = qVar;
        t zzq = zzbi.zzq(qVar);
        int i10 = zzaz.zzd;
        zzd = new zzbg(zzq, r.f7086c, (zzbg) null);
    }

    zzbg(t tVar, zzaz zzaz, zzbg zzbg) {
        this.zze = tVar;
        this.zzf = zzaz;
        this.zzg = zzbg;
    }

    /* JADX WARNING: type inference failed for: r11v0, types: [java.util.Map, java.util.SortedMap] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.fido.zzbg zzf(java.util.Map r11) {
        /*
            java.util.Comparator r0 = zzc
            java.util.Comparator r1 = r11.comparator()
            r2 = 1
            if (r1 != 0) goto L_0x000b
            r1 = r2
            goto L_0x000f
        L_0x000b:
            boolean r1 = r0.equals(r1)
        L_0x000f:
            java.util.Set r11 = r11.entrySet()
            java.util.Map$Entry[] r3 = com.google.android.gms.internal.fido.zzba.zza
            boolean r4 = r11 instanceof java.util.Collection
            if (r4 != 0) goto L_0x0034
            java.util.Iterator r11 = r11.iterator()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r11.getClass()
        L_0x0025:
            boolean r5 = r11.hasNext()
            if (r5 == 0) goto L_0x0033
            java.lang.Object r5 = r11.next()
            r4.add(r5)
            goto L_0x0025
        L_0x0033:
            r11 = r4
        L_0x0034:
            java.lang.Object[] r11 = r11.toArray(r3)
            java.util.Map$Entry[] r11 = (java.util.Map.Entry[]) r11
            int r3 = r11.length
            if (r3 == 0) goto L_0x0100
            r4 = 0
            r5 = 0
            if (r3 == r2) goto L_0x00df
            java.lang.Object[] r6 = new java.lang.Object[r3]
            java.lang.Object[] r7 = new java.lang.Object[r3]
            if (r1 == 0) goto L_0x0060
        L_0x0047:
            if (r5 >= r3) goto L_0x00cc
            r1 = r11[r5]
            r1.getClass()
            java.lang.Object r2 = r1.getKey()
            java.lang.Object r1 = r1.getValue()
            com.google.android.gms.internal.fido.e.a(r2, r1)
            r6[r5] = r2
            r7[r5] = r1
            int r5 = r5 + 1
            goto L_0x0047
        L_0x0060:
            com.google.android.gms.internal.fido.zzbd r1 = new com.google.android.gms.internal.fido.zzbd
            r1.<init>(r0)
            java.util.Arrays.sort(r11, r5, r3, r1)
            r1 = r11[r5]
            r1.getClass()
            java.lang.Object r8 = r1.getKey()
            r6[r5] = r8
            java.lang.Object r1 = r1.getValue()
            r7[r5] = r1
            r5 = r6[r5]
            com.google.android.gms.internal.fido.e.a(r5, r1)
        L_0x007e:
            if (r2 >= r3) goto L_0x00cc
            int r1 = r2 + -1
            r1 = r11[r1]
            r1.getClass()
            r5 = r11[r2]
            r5.getClass()
            java.lang.Object r9 = r5.getKey()
            java.lang.Object r10 = r5.getValue()
            com.google.android.gms.internal.fido.e.a(r9, r10)
            r6[r2] = r9
            r7[r2] = r10
            int r8 = r0.compare(r8, r9)
            if (r8 == 0) goto L_0x00a5
            int r2 = r2 + 1
            r8 = r9
            goto L_0x007e
        L_0x00a5:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r0 = java.lang.String.valueOf(r1)
            java.lang.String r1 = java.lang.String.valueOf(r5)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Multiple entries with same key: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " and "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            r11.<init>(r0)
            throw r11
        L_0x00cc:
            com.google.android.gms.internal.fido.zzbg r11 = new com.google.android.gms.internal.fido.zzbg
            com.google.android.gms.internal.fido.t r1 = new com.google.android.gms.internal.fido.t
            com.google.android.gms.internal.fido.zzaz r2 = com.google.android.gms.internal.fido.zzaz.zzh(r6, r3)
            r1.<init>(r2, r0)
            com.google.android.gms.internal.fido.zzaz r0 = com.google.android.gms.internal.fido.zzaz.zzh(r7, r3)
            r11.<init>(r1, r0, r4)
            goto L_0x0104
        L_0x00df:
            r11 = r11[r5]
            r11.getClass()
            java.lang.Object r1 = r11.getKey()
            java.lang.Object r11 = r11.getValue()
            com.google.android.gms.internal.fido.zzbg r2 = new com.google.android.gms.internal.fido.zzbg
            com.google.android.gms.internal.fido.t r3 = new com.google.android.gms.internal.fido.t
            com.google.android.gms.internal.fido.zzaz r1 = com.google.android.gms.internal.fido.zzaz.zzj(r1)
            r3.<init>(r1, r0)
            com.google.android.gms.internal.fido.zzaz r11 = com.google.android.gms.internal.fido.zzaz.zzj(r11)
            r2.<init>(r3, r11, r4)
            r11 = r2
            goto L_0x0104
        L_0x0100:
            com.google.android.gms.internal.fido.zzbg r11 = zzg(r0)
        L_0x0104:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzbg.zzf(java.util.Map):com.google.android.gms.internal.fido.zzbg");
    }

    static zzbg zzg(Comparator comparator) {
        if (q.f7085a.equals(comparator)) {
            return zzd;
        }
        t zzq = zzbi.zzq(comparator);
        int i10 = zzaz.zzd;
        return new zzbg(zzq, r.f7086c, (zzbg) null);
    }

    private final zzbg zzl(int i10, int i11) {
        if (i10 == 0) {
            if (i11 == this.zzf.size()) {
                return this;
            }
            i10 = 0;
        }
        if (i10 == i11) {
            return zzg(this.zze.zza);
        }
        return new zzbg(this.zze.d(i10, i11), this.zzf.subList(i10, i11), (zzbg) null);
    }

    public final Map.Entry ceilingEntry(Object obj) {
        return tailMap(obj, true).firstEntry();
    }

    public final Object ceilingKey(Object obj) {
        return zzbn.zza(ceilingEntry(obj));
    }

    public final Comparator comparator() {
        return this.zze.zza;
    }

    public final /* synthetic */ NavigableSet descendingKeySet() {
        return this.zze.descendingSet();
    }

    public final /* bridge */ /* synthetic */ NavigableMap descendingMap() {
        zzbr zzbr;
        zzbg zzbg = this.zzg;
        if (zzbg != null) {
            return zzbg;
        }
        if (!isEmpty()) {
            return new zzbg((t) this.zze.descendingSet(), this.zzf.zzf(), this);
        }
        Comparator comparator = this.zze.zza;
        if (comparator instanceof zzbr) {
            zzbr = (zzbr) comparator;
        } else {
            zzbr = new f(comparator);
        }
        return zzg(zzbr.zza());
    }

    public final /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    public final Map.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().zzi().get(0);
    }

    public final Object firstKey() {
        return this.zze.first();
    }

    public final Map.Entry floorEntry(Object obj) {
        return headMap(obj, true).lastEntry();
    }

    public final Object floorKey(Object obj) {
        return zzbn.zza(floorEntry(obj));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r4 < 0) goto L_0x0005;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(java.lang.Object r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.fido.t r0 = r3.zze
            r1 = -1
            if (r4 != 0) goto L_0x0007
        L_0x0005:
            r4 = r1
            goto L_0x0012
        L_0x0007:
            com.google.android.gms.internal.fido.zzaz r2 = r0.f7098a     // Catch:{ ClassCastException -> 0x0005 }
            java.util.Comparator r0 = r0.zza     // Catch:{ ClassCastException -> 0x0005 }
            int r4 = java.util.Collections.binarySearch(r2, r4, r0)     // Catch:{ ClassCastException -> 0x0005 }
            if (r4 >= 0) goto L_0x0012
            goto L_0x0005
        L_0x0012:
            if (r4 != r1) goto L_0x0016
            r4 = 0
            return r4
        L_0x0016:
            com.google.android.gms.internal.fido.zzaz r0 = r3.zzf
            java.lang.Object r4 = r0.get(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzbg.get(java.lang.Object):java.lang.Object");
    }

    public final /* synthetic */ SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    public final Map.Entry higherEntry(Object obj) {
        return tailMap(obj, false).firstEntry();
    }

    public final Object higherKey(Object obj) {
        return zzbn.zza(higherEntry(obj));
    }

    public final /* synthetic */ Set keySet() {
        return this.zze;
    }

    public final Map.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().zzi().get(this.zzf.size() - 1);
    }

    public final Object lastKey() {
        return this.zze.last();
    }

    public final Map.Entry lowerEntry(Object obj) {
        return headMap(obj, false).lastEntry();
    }

    public final Object lowerKey(Object obj) {
        return zzbn.zza(lowerEntry(obj));
    }

    public final /* synthetic */ NavigableSet navigableKeySet() {
        return this.zze;
    }

    @Deprecated
    public final Map.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Map.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        return this.zzf.size();
    }

    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    public final /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    public final /* synthetic */ Collection values() {
        return this.zzf;
    }

    public final zzav zza() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final zzbc zzb() {
        if (isEmpty()) {
            return s.f7090g;
        }
        return new m(this);
    }

    public final /* synthetic */ zzbc zzd() {
        return this.zze;
    }

    /* renamed from: zzh */
    public final zzbg headMap(Object obj, boolean z10) {
        t tVar = this.zze;
        obj.getClass();
        return zzl(0, tVar.a(obj, z10));
    }

    /* renamed from: zzi */
    public final zzbg subMap(Object obj, boolean z10, Object obj2, boolean z11) {
        obj.getClass();
        obj2.getClass();
        if (this.zze.zza.compare(obj, obj2) <= 0) {
            return headMap(obj2, z11).tailMap(obj, z10);
        }
        throw new IllegalArgumentException(zzaq.zza("expected fromKey <= toKey but %s > %s", obj, obj2));
    }

    /* renamed from: zzj */
    public final zzbg tailMap(Object obj, boolean z10) {
        t tVar = this.zze;
        obj.getClass();
        return zzl(tVar.c(obj, z10), this.zzf.size());
    }
}
