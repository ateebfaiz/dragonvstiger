package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.m f14993a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f14994b;

    public /* synthetic */ f0(LocationManagerCompat.m mVar, String str) {
        this.f14993a = mVar;
        this.f14994b = str;
    }

    public final void run() {
        this.f14993a.l(this.f14994b);
    }
}
