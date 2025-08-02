package androidx.core.location;

import android.location.LocationManager;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Callable;

public final /* synthetic */ class t implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManager f15026a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.j f15027b;

    public /* synthetic */ t(LocationManager locationManager, LocationManagerCompat.j jVar) {
        this.f15026a = locationManager;
        this.f15027b = jVar;
    }

    public final Object call() {
        return Boolean.valueOf(this.f15026a.addGpsStatusListener(this.f15027b));
    }
}
