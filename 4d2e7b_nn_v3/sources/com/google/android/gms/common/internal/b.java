package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;

final class b extends zag {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f6781a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Fragment f6782b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f6783c;

    b(Intent intent, Fragment fragment, int i10) {
        this.f6781a = intent;
        this.f6782b = fragment;
        this.f6783c = i10;
    }

    public final void zaa() {
        Intent intent = this.f6781a;
        if (intent != null) {
            this.f6782b.startActivityForResult(intent, this.f6783c);
        }
    }
}
