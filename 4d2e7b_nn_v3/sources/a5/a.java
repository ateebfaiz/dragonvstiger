package a5;

import com.facebook.imagepipeline.producers.c;
import com.facebook.imagepipeline.producers.d1;
import com.facebook.imagepipeline.producers.e1;
import com.facebook.imagepipeline.producers.l1;
import com.facebook.imagepipeline.producers.n;
import g5.d;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import l5.b;
import y2.l;

public abstract class a extends i3.a {

    /* renamed from: h  reason: collision with root package name */
    private final l1 f13677h;

    /* renamed from: i  reason: collision with root package name */
    private final d f13678i;

    /* renamed from: a5.a$a  reason: collision with other inner class name */
    public static final class C0172a extends c {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f13679b;

        C0172a(a aVar) {
            this.f13679b = aVar;
        }

        /* access modifiers changed from: protected */
        public void f() {
            this.f13679b.B();
        }

        /* access modifiers changed from: protected */
        public void g(Throwable th) {
            m.f(th, "throwable");
            this.f13679b.C(th);
        }

        /* access modifiers changed from: protected */
        public void h(Object obj, int i10) {
            a aVar = this.f13679b;
            aVar.D(obj, i10, aVar.A());
        }

        /* access modifiers changed from: protected */
        public void i(float f10) {
            boolean unused = this.f13679b.q(f10);
        }
    }

    protected a(d1 d1Var, l1 l1Var, d dVar) {
        m.f(d1Var, "producer");
        m.f(l1Var, "settableProducerContext");
        m.f(dVar, "requestListener");
        this.f13677h = l1Var;
        this.f13678i = dVar;
        if (!b.d()) {
            m(l1Var.getExtras());
            if (!b.d()) {
                dVar.b(l1Var);
            } else {
                b.a("AbstractProducerToDataSourceAdapter()->onRequestStart");
                try {
                    dVar.b(l1Var);
                    Unit unit = Unit.f12577a;
                } finally {
                    b.b();
                }
            }
            if (!b.d()) {
                d1Var.b(y(), l1Var);
                return;
            }
            b.a("AbstractProducerToDataSourceAdapter()->produceResult");
            try {
                d1Var.b(y(), l1Var);
                Unit unit2 = Unit.f12577a;
            } finally {
                b.b();
            }
        } else {
            b.a("AbstractProducerToDataSourceAdapter()");
            try {
                m(l1Var.getExtras());
                if (!b.d()) {
                    dVar.b(l1Var);
                } else {
                    b.a("AbstractProducerToDataSourceAdapter()->onRequestStart");
                    dVar.b(l1Var);
                    Unit unit3 = Unit.f12577a;
                }
                if (!b.d()) {
                    d1Var.b(y(), l1Var);
                } else {
                    b.a("AbstractProducerToDataSourceAdapter()->produceResult");
                    d1Var.b(y(), l1Var);
                    Unit unit4 = Unit.f12577a;
                }
                Unit unit5 = Unit.f12577a;
            } catch (Throwable th) {
                throw th;
            } finally {
                b.b();
            }
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void B() {
        l.i(i());
    }

    /* access modifiers changed from: private */
    public final void C(Throwable th) {
        if (super.o(th, z(this.f13677h))) {
            this.f13678i.h(this.f13677h, th);
        }
    }

    private final n y() {
        return new C0172a(this);
    }

    public final l1 A() {
        return this.f13677h;
    }

    /* access modifiers changed from: protected */
    public void D(Object obj, int i10, e1 e1Var) {
        m.f(e1Var, "producerContext");
        boolean d10 = c.d(i10);
        if (super.s(obj, d10, z(e1Var)) && d10) {
            this.f13678i.f(this.f13677h);
        }
    }

    public boolean close() {
        if (!super.close()) {
            return false;
        }
        if (super.b()) {
            return true;
        }
        this.f13678i.i(this.f13677h);
        this.f13677h.o();
        return true;
    }

    /* access modifiers changed from: protected */
    public final Map z(e1 e1Var) {
        m.f(e1Var, "producerContext");
        return e1Var.getExtras();
    }
}
