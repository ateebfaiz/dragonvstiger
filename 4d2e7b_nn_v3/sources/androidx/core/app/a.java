package androidx.core.app;

import android.app.Activity;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f14839a;

    public /* synthetic */ a(Activity activity) {
        this.f14839a = activity;
    }

    public final void run() {
        ActivityCompat.lambda$recreate$0(this.f14839a);
    }
}
