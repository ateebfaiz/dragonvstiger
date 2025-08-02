package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class e0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.j f14990a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f14991b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GnssStatusCompat f14992c;

    public /* synthetic */ e0(LocationManagerCompat.j jVar, Executor executor, GnssStatusCompat gnssStatusCompat) {
        this.f14990a = jVar;
        this.f14991b = executor;
        this.f14992c = gnssStatusCompat;
    }

    public final void run() {
        this.f14990a.h(this.f14991b, this.f14992c);
    }
}
