package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f16099a;

    public /* synthetic */ i(Context context) {
        this.f16099a = context;
    }

    public final void run() {
        ProfileInstallerInitializer.writeInBackground(this.f16099a);
    }
}
