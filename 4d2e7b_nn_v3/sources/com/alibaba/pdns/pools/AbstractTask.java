package com.alibaba.pdns.pools;

import com.alibaba.pdns.pools.Callback;
import java.util.concurrent.Executor;

public abstract class AbstractTask<ResultType> implements Callback.a {

    /* renamed from: a  reason: collision with root package name */
    private e f18141a;

    /* renamed from: b  reason: collision with root package name */
    private final Callback.a f18142b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f18143c;

    /* renamed from: d  reason: collision with root package name */
    private volatile State f18144d;

    /* renamed from: e  reason: collision with root package name */
    private ResultType f18145e;

    public enum State {
        IDLE(0),
        WAITING(1),
        STARTED(2),
        SUCCESS(3),
        CANCELLED(4),
        ERROR(5);
        
        private final int value;

        private State(int i10) {
            this.value = i10;
        }

        public int value() {
            return this.value;
        }
    }

    public AbstractTask() {
        this((Callback.a) null);
    }

    private boolean m() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void a(int i10, Object... objArr) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(Object obj);

    /* access modifiers changed from: protected */
    public abstract void a(Throwable th, boolean z10);

    /* access modifiers changed from: protected */
    public final void b(int i10, Object... objArr) {
        e eVar = this.f18141a;
        if (eVar != null) {
            eVar.a(i10, objArr);
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    /* access modifiers changed from: protected */
    public abstract ResultType d() throws Throwable;

    public Executor e() {
        return null;
    }

    public Priority f() {
        return null;
    }

    public final ResultType g() {
        return this.f18145e;
    }

    public final State h() {
        return this.f18144d;
    }

    public final boolean i() {
        if (this.f18144d.value() > State.STARTED.value()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void j() {
    }

    /* access modifiers changed from: protected */
    public void k() {
    }

    /* access modifiers changed from: protected */
    public void l() {
    }

    public AbstractTask(Callback.a aVar) {
        this.f18141a = null;
        this.f18143c = false;
        this.f18144d = State.IDLE;
        this.f18142b = aVar;
    }

    /* access modifiers changed from: protected */
    public void a(Callback.CancelledException cancelledException) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r2.f18142b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r2 = this;
            boolean r0 = r2.f18143c
            if (r0 != 0) goto L_0x0017
            com.alibaba.pdns.pools.AbstractTask$State r0 = r2.f18144d
            com.alibaba.pdns.pools.AbstractTask$State r1 = com.alibaba.pdns.pools.AbstractTask.State.CANCELLED
            if (r0 == r1) goto L_0x0017
            com.alibaba.pdns.pools.Callback$a r0 = r2.f18142b
            if (r0 == 0) goto L_0x0015
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x0018
        L_0x0017:
            r0 = 1
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.pools.AbstractTask.a():boolean");
    }

    public final synchronized void b() {
        try {
            if (!this.f18143c) {
                this.f18143c = true;
                c();
                Callback.a aVar = this.f18142b;
                if (aVar != null && !aVar.a()) {
                    this.f18142b.b();
                }
                if (this.f18144d == State.WAITING || (this.f18144d == State.STARTED && m())) {
                    e eVar = this.f18141a;
                    if (eVar != null) {
                        eVar.a(new Callback.CancelledException("cancelled by user"));
                        this.f18141a.j();
                    } else if (this instanceof e) {
                        a(new Callback.CancelledException("cancelled by user"));
                        j();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(State state) {
        this.f18144d = state;
    }

    /* access modifiers changed from: package-private */
    public final void a(e eVar) {
        this.f18141a = eVar;
    }

    /* access modifiers changed from: package-private */
    public final void b(ResultType resulttype) {
        this.f18145e = resulttype;
    }
}
