package androidx.webkit.internal;

import android.webkit.ValueCallback;
import androidx.webkit.PrerenderOperationCallback;

public final /* synthetic */ class x0 implements ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrerenderOperationCallback f16954a;

    public /* synthetic */ x0(PrerenderOperationCallback prerenderOperationCallback) {
        this.f16954a = prerenderOperationCallback;
    }

    public final void onReceiveValue(Object obj) {
        this.f16954a.onPrerenderActivated();
    }
}
