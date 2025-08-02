package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.h f14980a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f14981b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f14982c;

    public /* synthetic */ a0(LocationManagerCompat.h hVar, Executor executor, int i10) {
        this.f14980a = hVar;
        this.f14981b = executor;
        this.f14982c = i10;
    }

    public final void run() {
        this.f14980a.d(this.f14981b, this.f14982c);
    }
}
