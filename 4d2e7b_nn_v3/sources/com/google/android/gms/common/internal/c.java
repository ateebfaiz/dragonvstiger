package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

final class c extends zag {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f6784a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LifecycleFragment f6785b;

    c(Intent intent, LifecycleFragment lifecycleFragment, int i10) {
        this.f6784a = intent;
        this.f6785b = lifecycleFragment;
    }

    public final void zaa() {
        Intent intent = this.f6784a;
        if (intent != null) {
            this.f6785b.startActivityForResult(intent, 2);
        }
    }
}
