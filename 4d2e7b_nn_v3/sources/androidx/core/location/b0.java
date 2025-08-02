package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.j f14983a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f14984b;

    public /* synthetic */ b0(LocationManagerCompat.j jVar, Executor executor) {
        this.f14983a = jVar;
        this.f14984b = executor;
    }

    public final void run() {
        this.f14983a.e(this.f14984b);
    }
}
