package com.google.android.gms.internal.auth;

final class d1 extends e1 {
    /* synthetic */ d1(zzfh zzfh) {
        super((zzfj) null);
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj, long j10) {
        ((zzey) p2.f(obj, j10)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void b(Object obj, Object obj2, long j10) {
        zzey zzey = (zzey) p2.f(obj, j10);
        zzey zzey2 = (zzey) p2.f(obj2, j10);
        int size = zzey.size();
        int size2 = zzey2.size();
        if (size > 0 && size2 > 0) {
            if (!zzey.zzc()) {
                zzey = zzey.zzd(size2 + size);
            }
            zzey.addAll(zzey2);
        }
        if (size > 0) {
            zzey2 = zzey;
        }
        p2.p(obj, j10, zzey2);
    }
}
