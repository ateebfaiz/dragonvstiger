package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class c0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.j f14985a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f14986b;

    public /* synthetic */ c0(LocationManagerCompat.j jVar, Executor executor) {
        this.f14985a = jVar;
        this.f14986b = executor;
    }

    public final void run() {
        this.f14985a.f(this.f14986b);
    }
}
