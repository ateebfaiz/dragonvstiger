package androidx.appcompat.widget;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class v implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f14376a;

    public /* synthetic */ v(Runnable runnable) {
        this.f14376a = runnable;
    }

    public final void onBackInvoked() {
        this.f14376a.run();
    }
}
