package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

abstract class f {

    /* renamed from: a  reason: collision with root package name */
    TextInputLayout f8618a;

    /* renamed from: b  reason: collision with root package name */
    Context f8619b;

    /* renamed from: c  reason: collision with root package name */
    CheckableImageButton f8620c;

    /* renamed from: d  reason: collision with root package name */
    final int f8621d;

    f(TextInputLayout textInputLayout, int i10) {
        this.f8618a = textInputLayout;
        this.f8619b = textInputLayout.getContext();
        this.f8620c = textInputLayout.getEndIconView();
        this.f8621d = i10;
    }

    /* access modifiers changed from: package-private */
    public abstract void a();

    /* access modifiers changed from: package-private */
    public boolean b(int i10) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c(boolean z10) {
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return false;
    }
}
