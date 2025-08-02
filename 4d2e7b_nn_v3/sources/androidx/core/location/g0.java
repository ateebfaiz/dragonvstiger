package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class g0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.m f14995a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f14996b;

    public /* synthetic */ g0(LocationManagerCompat.m mVar, String str) {
        this.f14995a = mVar;
        this.f14996b = str;
    }

    public final void run() {
        this.f14995a.k(this.f14996b);
    }
}
