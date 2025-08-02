package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import y0.f;
import y0.g;

public class u0 {

    /* renamed from: e  reason: collision with root package name */
    public static Executor f17777e = Executors.newCachedThreadPool(new g());

    /* renamed from: a  reason: collision with root package name */
    private final Set f17778a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f17779b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f17780c;

    /* renamed from: d  reason: collision with root package name */
    private volatile s0 f17781d;

    private static class a extends FutureTask {

        /* renamed from: a  reason: collision with root package name */
        private u0 f17782a;

        a(u0 u0Var, Callable callable) {
            super(callable);
            this.f17782a = u0Var;
        }

        /* access modifiers changed from: protected */
        public void done() {
            try {
                if (isCancelled()) {
                    this.f17782a = null;
                    return;
                }
                this.f17782a.l((s0) get());
                this.f17782a = null;
            } catch (InterruptedException | ExecutionException e10) {
                this.f17782a.l(new s0(e10));
            } catch (Throwable th) {
                this.f17782a = null;
                throw th;
            }
        }
    }

    public u0(Callable callable) {
        this(callable, false);
    }

    private synchronized void f(Throwable th) {
        ArrayList<o0> arrayList = new ArrayList<>(this.f17779b);
        if (arrayList.isEmpty()) {
            f.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (o0 onResult : arrayList) {
            onResult.onResult(th);
        }
    }

    private void g() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            h();
        } else {
            this.f17780c.post(new t0(this));
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        s0 s0Var = this.f17781d;
        if (s0Var != null) {
            if (s0Var.b() != null) {
                i(s0Var.b());
            } else {
                f(s0Var.a());
            }
        }
    }

    private synchronized void i(Object obj) {
        for (o0 onResult : new ArrayList(this.f17778a)) {
            onResult.onResult(obj);
        }
    }

    /* access modifiers changed from: private */
    public void l(s0 s0Var) {
        if (this.f17781d == null) {
            this.f17781d = s0Var;
            g();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized u0 c(o0 o0Var) {
        try {
            s0 s0Var = this.f17781d;
            if (!(s0Var == null || s0Var.a() == null)) {
                o0Var.onResult(s0Var.a());
            }
            this.f17779b.add(o0Var);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized u0 d(o0 o0Var) {
        try {
            s0 s0Var = this.f17781d;
            if (!(s0Var == null || s0Var.b() == null)) {
                o0Var.onResult(s0Var.b());
            }
            this.f17778a.add(o0Var);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public s0 e() {
        return this.f17781d;
    }

    public synchronized u0 j(o0 o0Var) {
        this.f17779b.remove(o0Var);
        return this;
    }

    public synchronized u0 k(o0 o0Var) {
        this.f17778a.remove(o0Var);
        return this;
    }

    public u0(Object obj) {
        this.f17778a = new LinkedHashSet(1);
        this.f17779b = new LinkedHashSet(1);
        this.f17780c = new Handler(Looper.getMainLooper());
        this.f17781d = null;
        l(new s0(obj));
    }

    u0(Callable callable, boolean z10) {
        this.f17778a = new LinkedHashSet(1);
        this.f17779b = new LinkedHashSet(1);
        this.f17780c = new Handler(Looper.getMainLooper());
        this.f17781d = null;
        if (z10) {
            try {
                l((s0) callable.call());
            } catch (Throwable th) {
                l(new s0(th));
            }
        } else {
            f17777e.execute(new a(this, callable));
        }
    }
}
