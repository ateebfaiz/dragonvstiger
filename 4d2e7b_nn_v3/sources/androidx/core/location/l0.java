package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class l0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.n f15007a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f15008b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f15009c;

    public /* synthetic */ l0(LocationManagerCompat.n nVar, Executor executor, int i10) {
        this.f15007a = nVar;
        this.f15008b = executor;
        this.f15009c = i10;
    }

    public final void run() {
        this.f15007a.e(this.f15008b, this.f15009c);
    }
}
