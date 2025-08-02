package com.facebook.react.modules.statusbar;

import android.app.Activity;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f3356a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3357b;

    public /* synthetic */ b(Activity activity, String str) {
        this.f3356a = activity;
        this.f3357b = str;
    }

    public final void run() {
        StatusBarModule.setStyle$lambda$2(this.f3356a, this.f3357b);
    }
}
