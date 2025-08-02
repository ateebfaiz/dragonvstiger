package androidx.core.location;

import android.os.Bundle;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class k0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.m f15003a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f15004b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f15005c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Bundle f15006d;

    public /* synthetic */ k0(LocationManagerCompat.m mVar, String str, int i10, Bundle bundle) {
        this.f15003a = mVar;
        this.f15004b = str;
        this.f15005c = i10;
        this.f15006d = bundle;
    }

    public final void run() {
        this.f15003a.m(this.f15004b, this.f15005c, this.f15006d);
    }
}
