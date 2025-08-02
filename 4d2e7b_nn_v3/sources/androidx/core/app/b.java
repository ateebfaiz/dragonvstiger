package androidx.core.app;

import android.app.SharedElementCallback;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;

public final /* synthetic */ class b implements SharedElementCallback.OnSharedElementsReadyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedElementCallback.OnSharedElementsReadyListener f14840a;

    public /* synthetic */ b(SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.f14840a = onSharedElementsReadyListener;
    }

    public final void onSharedElementsReady() {
        ActivityCompat.c.a(this.f14840a);
    }
}
