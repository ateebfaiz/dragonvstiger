package androidx.core.location;

import android.os.CancellationSignal;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class s implements CancellationSignal.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.f f15025a;

    public /* synthetic */ s(LocationManagerCompat.f fVar) {
        this.f15025a = fVar;
    }

    public final void onCancel() {
        this.f15025a.c();
    }
}
