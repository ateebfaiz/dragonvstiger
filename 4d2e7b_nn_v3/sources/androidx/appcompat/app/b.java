package androidx.appcompat.app;

import android.content.Context;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f13971a;

    public /* synthetic */ b(Context context) {
        this.f13971a = context;
    }

    public final void run() {
        AppCompatDelegate.syncRequestedAndStoredLocales(this.f13971a);
    }
}
