package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.h f15032a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f15033b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GnssMeasurementsEvent f15034c;

    public /* synthetic */ z(LocationManagerCompat.h hVar, Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
        this.f15032a = hVar;
        this.f15033b = executor;
        this.f15034c = gnssMeasurementsEvent;
    }

    public final void run() {
        this.f15032a.c(this.f15033b, this.f15034c);
    }
}
