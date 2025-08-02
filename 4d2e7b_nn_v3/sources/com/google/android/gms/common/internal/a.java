package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class a extends zag {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f6778a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f6779b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f6780c;

    a(Intent intent, Activity activity, int i10) {
        this.f6778a = intent;
        this.f6779b = activity;
        this.f6780c = i10;
    }

    public final void zaa() {
        Intent intent = this.f6778a;
        if (intent != null) {
            this.f6779b.startActivityForResult(intent, this.f6780c);
        }
    }
}
