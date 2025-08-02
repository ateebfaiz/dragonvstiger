package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.j f14987a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f14988b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f14989c;

    public /* synthetic */ d0(LocationManagerCompat.j jVar, Executor executor, int i10) {
        this.f14987a = jVar;
        this.f14988b = executor;
        this.f14989c = i10;
    }

    public final void run() {
        this.f14987a.g(this.f14988b, this.f14989c);
    }
}
