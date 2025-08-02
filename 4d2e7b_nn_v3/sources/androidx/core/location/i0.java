package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class i0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.m f14999a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Location f15000b;

    public /* synthetic */ i0(LocationManagerCompat.m mVar, Location location) {
        this.f14999a = mVar;
        this.f15000b = location;
    }

    public final void run() {
        this.f14999a.i(this.f15000b);
    }
}
