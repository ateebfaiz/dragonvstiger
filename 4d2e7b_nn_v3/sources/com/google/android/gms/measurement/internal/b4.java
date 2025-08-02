package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzgd;
import java.util.ArrayList;
import java.util.List;

final class b4 {

    /* renamed from: a  reason: collision with root package name */
    zzgd f7405a;

    /* renamed from: b  reason: collision with root package name */
    List f7406b;

    /* renamed from: c  reason: collision with root package name */
    List f7407c;

    /* renamed from: d  reason: collision with root package name */
    long f7408d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzkt f7409e;

    /* synthetic */ b4(zzkt zzkt, zzkp zzkp) {
        this.f7409e = zzkt;
    }

    private static final long b(zzft zzft) {
        return ((zzft.zzd() / 1000) / 60) / 60;
    }

    public final boolean a(long j10, zzft zzft) {
        Preconditions.checkNotNull(zzft);
        if (this.f7407c == null) {
            this.f7407c = new ArrayList();
        }
        if (this.f7406b == null) {
            this.f7406b = new ArrayList();
        }
        if (!this.f7407c.isEmpty() && b((zzft) this.f7407c.get(0)) != b(zzft)) {
            return false;
        }
        long zzbw = this.f7408d + ((long) zzft.zzbw());
        this.f7409e.zzg();
        if (zzbw >= ((long) Math.max(0, ((Integer) zzdu.zzh.zza((Object) null)).intValue()))) {
            return false;
        }
        this.f7408d = zzbw;
        this.f7407c.add(zzft);
        this.f7406b.add(Long.valueOf(j10));
        int size = this.f7407c.size();
        this.f7409e.zzg();
        if (size >= Math.max(1, ((Integer) zzdu.zzi.zza((Object) null)).intValue())) {
            return false;
        }
        return true;
    }
}
