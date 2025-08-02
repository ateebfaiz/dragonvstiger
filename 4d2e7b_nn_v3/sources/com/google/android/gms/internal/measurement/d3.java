package com.google.android.gms.internal.measurement;

final class d3 extends e3 {
    /* synthetic */ d3(zzkx zzkx) {
        super((zzkz) null);
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj, long j10) {
        ((zzkm) r4.k(obj, j10)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void b(Object obj, Object obj2, long j10) {
        zzkm zzkm = (zzkm) r4.k(obj, j10);
        zzkm zzkm2 = (zzkm) r4.k(obj2, j10);
        int size = zzkm.size();
        int size2 = zzkm2.size();
        if (size > 0 && size2 > 0) {
            if (!zzkm.zzc()) {
                zzkm = zzkm.zzd(size2 + size);
            }
            zzkm.addAll(zzkm2);
        }
        if (size > 0) {
            zzkm2 = zzkm;
        }
        r4.x(obj, j10, zzkm2);
    }
}
