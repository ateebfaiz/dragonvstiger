package androidx.webkit.internal;

import android.webkit.ValueCallback;
import androidx.webkit.PrerenderException;
import androidx.webkit.PrerenderOperationCallback;

public final /* synthetic */ class y0 implements ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrerenderOperationCallback f16955a;

    public /* synthetic */ y0(PrerenderOperationCallback prerenderOperationCallback) {
        this.f16955a = prerenderOperationCallback;
    }

    public final void onReceiveValue(Object obj) {
        this.f16955a.onError(new PrerenderException("Prerender operation failed", (Throwable) obj));
    }
}
