package com.onesignal;

import com.onesignal.o3;

public abstract class v1 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f11084a = false;

    v1() {
    }

    /* access modifiers changed from: package-private */
    public abstract String a();

    /* access modifiers changed from: package-private */
    public abstract void b(o3.x xVar);

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f11084a;
    }

    /* access modifiers changed from: package-private */
    public void d(boolean z10) {
        this.f11084a = z10;
    }

    public String toString() {
        return "OSInAppMessagePrompt{key=" + a() + " prompted=" + this.f11084a + '}';
    }
}
