package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class j0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.m f15001a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f15002b;

    public /* synthetic */ j0(LocationManagerCompat.m mVar, int i10) {
        this.f15001a = mVar;
        this.f15002b = i10;
    }

    public final void run() {
        this.f15001a.h(this.f15002b);
    }
}
