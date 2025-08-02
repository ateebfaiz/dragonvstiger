package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import y2.l;

public class r1 implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final d1 f20229a;

    /* renamed from: b  reason: collision with root package name */
    private final int f20230b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f20231c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentLinkedQueue f20232d = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Executor f20233e;

    private class a extends t {

        /* renamed from: com.facebook.imagepipeline.producers.r1$a$a  reason: collision with other inner class name */
        class C0254a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Pair f20235a;

            C0254a(Pair pair) {
                this.f20235a = pair;
            }

            public void run() {
                r1 r1Var = r1.this;
                Pair pair = this.f20235a;
                r1Var.g((n) pair.first, (e1) pair.second);
            }
        }

        private void p() {
            Pair pair;
            synchronized (r1.this) {
                try {
                    pair = (Pair) r1.this.f20232d.poll();
                    if (pair == null) {
                        r1 r1Var = r1.this;
                        r1Var.f20231c = r1Var.f20231c - 1;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (pair != null) {
                r1.this.f20233e.execute(new C0254a(pair));
            }
        }

        /* access modifiers changed from: protected */
        public void f() {
            o().a();
            p();
        }

        /* access modifiers changed from: protected */
        public void g(Throwable th) {
            o().onFailure(th);
            p();
        }

        /* access modifiers changed from: protected */
        public void h(Object obj, int i10) {
            o().c(obj, i10);
            if (c.d(i10)) {
                p();
            }
        }

        private a(n nVar) {
            super(nVar);
        }
    }

    public r1(int i10, Executor executor, d1 d1Var) {
        this.f20230b = i10;
        this.f20233e = (Executor) l.g(executor);
        this.f20229a = (d1) l.g(d1Var);
    }

    public void b(n nVar, e1 e1Var) {
        boolean z10;
        e1Var.z().e(e1Var, "ThrottlingProducer");
        synchronized (this) {
            try {
                int i10 = this.f20231c;
                z10 = true;
                if (i10 >= this.f20230b) {
                    this.f20232d.add(Pair.create(nVar, e1Var));
                } else {
                    this.f20231c = i10 + 1;
                    z10 = false;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (!z10) {
            g(nVar, e1Var);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(n nVar, e1 e1Var) {
        e1Var.z().j(e1Var, "ThrottlingProducer", (Map) null);
        this.f20229a.b(new a(nVar), e1Var);
    }
}
