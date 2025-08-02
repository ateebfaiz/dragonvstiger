package com.onesignal;

class OSPermissionChangedInternalObserver {
    OSPermissionChangedInternalObserver() {
    }

    static void a(r2 r2Var) {
        if (o3.h0().c(new s2(o3.W, (r2) r2Var.clone()))) {
            r2 r2Var2 = (r2) r2Var.clone();
            o3.W = r2Var2;
            r2Var2.c();
        }
    }

    static void b(r2 r2Var) {
        if (!r2Var.a()) {
            l.d(0, o3.f10882b);
        }
        e4.t(o3.A());
    }

    /* access modifiers changed from: package-private */
    public void changed(r2 r2Var) {
        b(r2Var);
        a(r2Var);
    }
}
