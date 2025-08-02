package com.facebook.imagepipeline.producers;

import android.os.Looper;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class o1 implements d1 {

    /* renamed from: c  reason: collision with root package name */
    public static final a f20184c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final d1 f20185a;

    /* renamed from: b  reason: collision with root package name */
    private final p1 f20186b;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final String c(e1 e1Var) {
            if (!f5.a.b()) {
                return null;
            }
            String id2 = e1Var.getId();
            return "ThreadHandoffProducer_produceResults_" + id2;
        }

        /* access modifiers changed from: private */
        public final boolean d(e1 e1Var) {
            if (e1Var.j().F().j() && Looper.getMainLooper().getThread() != Thread.currentThread()) {
                return true;
            }
            return false;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m1 f20187a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o1 f20188b;

        b(m1 m1Var, o1 o1Var) {
            this.f20187a = m1Var;
            this.f20188b = o1Var;
        }

        public void a() {
            this.f20187a.a();
            this.f20188b.d().a(this.f20187a);
        }
    }

    public static final class c extends m1 {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ n f20189f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ g1 f20190g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ e1 f20191h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ o1 f20192i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(n nVar, g1 g1Var, e1 e1Var, o1 o1Var) {
            super(nVar, g1Var, e1Var, "BackgroundThreadHandoffProducer");
            this.f20189f = nVar;
            this.f20190g = g1Var;
            this.f20191h = e1Var;
            this.f20192i = o1Var;
        }

        /* access modifiers changed from: protected */
        public void b(Object obj) {
        }

        /* access modifiers changed from: protected */
        public Object c() {
            return null;
        }

        /* access modifiers changed from: protected */
        public void f(Object obj) {
            this.f20190g.j(this.f20191h, "BackgroundThreadHandoffProducer", (Map) null);
            this.f20192i.c().b(this.f20189f, this.f20191h);
        }
    }

    public o1(d1 d1Var, p1 p1Var) {
        m.f(d1Var, "inputProducer");
        m.f(p1Var, "threadHandoffProducerQueue");
        this.f20185a = d1Var;
        this.f20186b = p1Var;
    }

    public void b(n nVar, e1 e1Var) {
        m.f(nVar, "consumer");
        m.f(e1Var, "context");
        if (!l5.b.d()) {
            g1 z10 = e1Var.z();
            a aVar = f20184c;
            if (aVar.d(e1Var)) {
                z10.e(e1Var, "BackgroundThreadHandoffProducer");
                z10.j(e1Var, "BackgroundThreadHandoffProducer", (Map) null);
                this.f20185a.b(nVar, e1Var);
                return;
            }
            c cVar = new c(nVar, z10, e1Var, this);
            e1Var.h(new b(cVar, this));
            this.f20186b.b(f5.a.a(cVar, aVar.c(e1Var)));
            return;
        }
        l5.b.a("ThreadHandoffProducer#produceResults");
        try {
            g1 z11 = e1Var.z();
            a aVar2 = f20184c;
            if (aVar2.d(e1Var)) {
                z11.e(e1Var, "BackgroundThreadHandoffProducer");
                z11.j(e1Var, "BackgroundThreadHandoffProducer", (Map) null);
                this.f20185a.b(nVar, e1Var);
                return;
            }
            c cVar2 = new c(nVar, z11, e1Var, this);
            e1Var.h(new b(cVar2, this));
            this.f20186b.b(f5.a.a(cVar2, aVar2.c(e1Var)));
            Unit unit = Unit.f12577a;
            l5.b.b();
        } finally {
            l5.b.b();
        }
    }

    public final d1 c() {
        return this.f20185a;
    }

    public final p1 d() {
        return this.f20186b;
    }
}
