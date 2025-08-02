package androidx.webkit;

import android.os.Handler;
import android.os.Looper;
import androidx.webkit.WebViewCompat;

public final /* synthetic */ class e implements WebViewCompat.WebViewStartUpCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewCompat.WebViewStartUpCallback f16927a;

    public /* synthetic */ e(WebViewCompat.WebViewStartUpCallback webViewStartUpCallback) {
        this.f16927a = webViewStartUpCallback;
    }

    public final void onSuccess(WebViewStartUpResult webViewStartUpResult) {
        new Handler(Looper.getMainLooper()).post(new g(this.f16927a, webViewStartUpResult));
    }
}
