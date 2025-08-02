package androidx.webkit.internal;

import android.webkit.ValueCallback;
import androidx.webkit.PrerenderOperationCallback;

public final /* synthetic */ class z0 implements ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrerenderOperationCallback f16956a;

    public /* synthetic */ z0(PrerenderOperationCallback prerenderOperationCallback) {
        this.f16956a = prerenderOperationCallback;
    }

    public final void onReceiveValue(Object obj) {
        this.f16956a.onPrerenderActivated();
    }
}
