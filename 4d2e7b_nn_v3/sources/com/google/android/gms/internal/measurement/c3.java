package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

final class c3 extends e3 {

    /* renamed from: c  reason: collision with root package name */
    private static final Class f7136c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* synthetic */ c3(zzkv zzkv) {
        super((zzkz) null);
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj, long j10) {
        Object obj2;
        List list = (List) r4.k(obj, j10);
        if (list instanceof zzku) {
            obj2 = ((zzku) list).zze();
        } else if (!f7136c.isAssignableFrom(list.getClass())) {
            if (!(list instanceof s3) || !(list instanceof zzkm)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzkm zzkm = (zzkm) list;
                if (zzkm.zzc()) {
                    zzkm.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        r4.x(obj, j10, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.google.android.gms.internal.measurement.zzkt} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: com.google.android.gms.internal.measurement.zzkt} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: com.google.android.gms.internal.measurement.zzkt} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.Object r5, java.lang.Object r6, long r7) {
        /*
            r4 = this;
            java.lang.Object r6 = com.google.android.gms.internal.measurement.r4.k(r6, r7)
            java.util.List r6 = (java.util.List) r6
            int r0 = r6.size()
            java.lang.Object r1 = com.google.android.gms.internal.measurement.r4.k(r5, r7)
            java.util.List r1 = (java.util.List) r1
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0039
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzku
            if (r2 == 0) goto L_0x0020
            com.google.android.gms.internal.measurement.zzkt r1 = new com.google.android.gms.internal.measurement.zzkt
            r1.<init>((int) r0)
            goto L_0x0035
        L_0x0020:
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.s3
            if (r2 == 0) goto L_0x0030
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzkm
            if (r2 == 0) goto L_0x0030
            com.google.android.gms.internal.measurement.zzkm r1 = (com.google.android.gms.internal.measurement.zzkm) r1
            com.google.android.gms.internal.measurement.zzkm r0 = r1.zzd(r0)
            r1 = r0
            goto L_0x0035
        L_0x0030:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
        L_0x0035:
            com.google.android.gms.internal.measurement.r4.x(r5, r7, r1)
            goto L_0x008f
        L_0x0039:
            java.lang.Class r2 = f7136c
            java.lang.Class r3 = r1.getClass()
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto L_0x0057
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            r2.addAll(r1)
            com.google.android.gms.internal.measurement.r4.x(r5, r7, r2)
        L_0x0055:
            r1 = r2
            goto L_0x008f
        L_0x0057:
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzmt
            if (r2 == 0) goto L_0x0072
            com.google.android.gms.internal.measurement.zzkt r2 = new com.google.android.gms.internal.measurement.zzkt
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>((int) r3)
            com.google.android.gms.internal.measurement.zzmt r1 = (com.google.android.gms.internal.measurement.zzmt) r1
            int r0 = r2.size()
            r2.addAll(r0, r1)
            com.google.android.gms.internal.measurement.r4.x(r5, r7, r2)
            goto L_0x0055
        L_0x0072:
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.s3
            if (r2 == 0) goto L_0x008f
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzkm
            if (r2 == 0) goto L_0x008f
            r2 = r1
            com.google.android.gms.internal.measurement.zzkm r2 = (com.google.android.gms.internal.measurement.zzkm) r2
            boolean r3 = r2.zzc()
            if (r3 != 0) goto L_0x008f
            int r1 = r1.size()
            int r1 = r1 + r0
            com.google.android.gms.internal.measurement.zzkm r1 = r2.zzd(r1)
            com.google.android.gms.internal.measurement.r4.x(r5, r7, r1)
        L_0x008f:
            int r0 = r1.size()
            int r2 = r6.size()
            if (r0 <= 0) goto L_0x009e
            if (r2 <= 0) goto L_0x009e
            r1.addAll(r6)
        L_0x009e:
            if (r0 > 0) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            r6 = r1
        L_0x00a2:
            com.google.android.gms.internal.measurement.r4.x(r5, r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.c3.b(java.lang.Object, java.lang.Object, long):void");
    }
}
