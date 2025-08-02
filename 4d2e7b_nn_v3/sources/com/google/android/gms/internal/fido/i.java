package com.google.android.gms.internal.fido;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

final class i extends zzaz {

    /* renamed from: a  reason: collision with root package name */
    private final transient zzaz f7067a;

    i(zzaz zzaz) {
        this.f7067a = zzaz;
    }

    private final int a(int i10) {
        return (this.f7067a.size() - 1) - i10;
    }

    public final boolean contains(Object obj) {
        return this.f7067a.contains(obj);
    }

    public final Object get(int i10) {
        zzap.zza(i10, this.f7067a.size(), FirebaseAnalytics.Param.INDEX);
        return this.f7067a.get(a(i10));
    }

    public final int indexOf(Object obj) {
        int lastIndexOf = this.f7067a.lastIndexOf(obj);
        if (lastIndexOf >= 0) {
            return a(lastIndexOf);
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        int indexOf = this.f7067a.indexOf(obj);
        if (indexOf >= 0) {
            return a(indexOf);
        }
        return -1;
    }

    public final int size() {
        return this.f7067a.size();
    }

    public final /* bridge */ /* synthetic */ List subList(int i10, int i11) {
        return subList(i10, i11);
    }

    public final zzaz zzf() {
        return this.f7067a;
    }

    public final zzaz zzg(int i10, int i11) {
        zzap.zze(i10, i11, this.f7067a.size());
        zzaz zzaz = this.f7067a;
        return zzaz.subList(zzaz.size() - i11, this.f7067a.size() - i10).zzf();
    }
}
