package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileInstallerInitializer f16100a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f16101b;

    public /* synthetic */ j(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f16100a = profileInstallerInitializer;
        this.f16101b = context;
    }

    public final void run() {
        this.f16100a.lambda$delayAfterFirstFrame$0(this.f16101b);
    }
}
