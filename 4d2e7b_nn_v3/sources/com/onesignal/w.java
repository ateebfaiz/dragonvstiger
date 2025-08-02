package com.onesignal;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.m;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11093a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f11094b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11095c;

    public w(Context context, Intent intent, boolean z10) {
        m.f(context, "context");
        this.f11093a = context;
        this.f11094b = intent;
        this.f11095c = z10;
    }

    private final Intent a() {
        Intent launchIntentForPackage;
        if (!this.f11095c || (launchIntentForPackage = this.f11093a.getPackageManager().getLaunchIntentForPackage(this.f11093a.getPackageName())) == null) {
            return null;
        }
        launchIntentForPackage.setPackage((String) null);
        launchIntentForPackage.setFlags(270532608);
        return launchIntentForPackage;
    }

    public final Intent b() {
        Intent intent = this.f11094b;
        if (intent != null) {
            return intent;
        }
        return a();
    }
}
