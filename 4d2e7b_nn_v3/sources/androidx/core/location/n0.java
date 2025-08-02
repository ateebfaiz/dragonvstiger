package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class n0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.n f15019a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f15020b;

    public /* synthetic */ n0(LocationManagerCompat.n nVar, Executor executor) {
        this.f15019a = nVar;
        this.f15020b = executor;
    }

    public final void run() {
        this.f15019a.h(this.f15020b);
    }
}
