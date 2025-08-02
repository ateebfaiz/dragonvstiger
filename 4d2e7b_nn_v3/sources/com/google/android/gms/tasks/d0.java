package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

final class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c0 f7838a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Callable f7839b;

    d0(c0 c0Var, Callable callable) {
        this.f7838a = c0Var;
        this.f7839b = callable;
    }

    public final void run() {
        try {
            this.f7838a.b(this.f7839b.call());
        } catch (Exception e10) {
            this.f7838a.a(e10);
        } catch (Throwable th) {
            this.f7838a.a(new RuntimeException(th));
        }
    }
}
