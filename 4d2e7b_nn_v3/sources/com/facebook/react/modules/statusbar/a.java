package com.facebook.react.modules.statusbar;

import android.app.Activity;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f3354a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f3355b;

    public /* synthetic */ a(Activity activity, boolean z10) {
        this.f3354a = activity;
        this.f3355b = z10;
    }

    public final void run() {
        StatusBarModule.setHidden$lambda$1(this.f3354a, this.f3355b);
    }
}
