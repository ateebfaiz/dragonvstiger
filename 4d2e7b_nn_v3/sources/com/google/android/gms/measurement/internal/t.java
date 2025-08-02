package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final s f7708a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7709b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f7710c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f7711d;

    /* renamed from: e  reason: collision with root package name */
    private final String f7712e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f7713f;

    /* synthetic */ t(String str, s sVar, int i10, Throwable th, byte[] bArr, Map map, zzek zzek) {
        Preconditions.checkNotNull(sVar);
        this.f7708a = sVar;
        this.f7709b = i10;
        this.f7710c = th;
        this.f7711d = bArr;
        this.f7712e = str;
        this.f7713f = map;
    }

    public final void run() {
        this.f7708a.a(this.f7712e, this.f7709b, this.f7710c, this.f7711d, this.f7713f);
    }
}
