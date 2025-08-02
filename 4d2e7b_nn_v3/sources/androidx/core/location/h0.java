package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.List;

public final /* synthetic */ class h0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.m f14997a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f14998b;

    public /* synthetic */ h0(LocationManagerCompat.m mVar, List list) {
        this.f14997a = mVar;
        this.f14998b = list;
    }

    public final void run() {
        this.f14997a.j(this.f14998b);
    }
}
