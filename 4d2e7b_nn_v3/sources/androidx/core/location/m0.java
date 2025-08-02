package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class m0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.n f15011a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f15012b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GnssStatus f15013c;

    public /* synthetic */ m0(LocationManagerCompat.n nVar, Executor executor, GnssStatus gnssStatus) {
        this.f15011a = nVar;
        this.f15012b = executor;
        this.f15013c = gnssStatus;
    }

    public final void run() {
        this.f15011a.f(this.f15012b, this.f15013c);
    }
}
