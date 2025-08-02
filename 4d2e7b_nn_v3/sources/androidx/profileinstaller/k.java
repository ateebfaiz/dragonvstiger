package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f16102a;

    public /* synthetic */ k(Context context) {
        this.f16102a = context;
    }

    public final void run() {
        ProfileInstaller.writeProfile(this.f16102a);
    }
}
