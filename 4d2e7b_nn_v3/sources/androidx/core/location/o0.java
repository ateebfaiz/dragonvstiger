package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class o0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.n f15021a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f15022b;

    public /* synthetic */ o0(LocationManagerCompat.n nVar, Executor executor) {
        this.f15021a = nVar;
        this.f15022b = executor;
    }

    public final void run() {
        this.f15021a.g(this.f15022b);
    }
}
