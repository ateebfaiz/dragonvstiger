package androidx.webkit.internal;

import android.webkit.ValueCallback;
import androidx.webkit.PrerenderException;
import androidx.webkit.PrerenderOperationCallback;

public final /* synthetic */ class a1 implements ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrerenderOperationCallback f16945a;

    public /* synthetic */ a1(PrerenderOperationCallback prerenderOperationCallback) {
        this.f16945a = prerenderOperationCallback;
    }

    public final void onReceiveValue(Object obj) {
        this.f16945a.onError(new PrerenderException("Prerender operation failed", (Throwable) obj));
    }
}
