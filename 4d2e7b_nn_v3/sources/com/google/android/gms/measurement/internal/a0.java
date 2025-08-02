package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;

final class a0 extends LruCache {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzfi f7380a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    a0(zzfi zzfi, int i10) {
        super(20);
        this.f7380a = zzfi;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        return zzfi.zzd(this.f7380a, str);
    }
}
