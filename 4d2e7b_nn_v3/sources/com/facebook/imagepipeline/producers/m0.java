package com.facebook.imagepipeline.producers;

import b3.i;
import com.google.android.gms.common.internal.ImagesContract;
import e5.j;
import java.io.InputStream;
import java.util.concurrent.Executor;

public abstract class m0 implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20167a;

    /* renamed from: b  reason: collision with root package name */
    private final i f20168b;

    class a extends m1 {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ k5.b f20169f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ g1 f20170g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ e1 f20171h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(n nVar, g1 g1Var, e1 e1Var, String str, k5.b bVar, g1 g1Var2, e1 e1Var2) {
            super(nVar, g1Var, e1Var, str);
            this.f20169f = bVar;
            this.f20170g = g1Var2;
            this.f20171h = e1Var2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: j */
        public void b(j jVar) {
            j.h(jVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: k */
        public j c() {
            j e10 = m0.this.e(this.f20169f);
            if (e10 == null) {
                this.f20170g.c(this.f20171h, m0.this.f(), false);
                this.f20171h.k(ImagesContract.LOCAL, "fetch");
                return null;
            }
            e10.K();
            this.f20170g.c(this.f20171h, m0.this.f(), true);
            this.f20171h.k(ImagesContract.LOCAL, "fetch");
            this.f20171h.w("image_color_space", e10.n());
            return e10;
        }
    }

    class b extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m1 f20173a;

        b(m1 m1Var) {
            this.f20173a = m1Var;
        }

        public void a() {
            this.f20173a.a();
        }
    }

    protected m0(Executor executor, i iVar) {
        this.f20167a = executor;
        this.f20168b = iVar;
    }

    public void b(n nVar, e1 e1Var) {
        g1 z10 = e1Var.z();
        k5.b b10 = e1Var.b();
        e1Var.k(ImagesContract.LOCAL, "fetch");
        a aVar = new a(nVar, z10, e1Var, f(), b10, z10, e1Var);
        e1Var.h(new b(aVar));
        this.f20167a.execute(aVar);
    }

    /* access modifiers changed from: protected */
    public j c(InputStream inputStream, int i10) {
        c3.a z10;
        if (i10 <= 0) {
            try {
                z10 = c3.a.z(this.f20168b.c(inputStream));
            } catch (Throwable th) {
                y2.b.b(inputStream);
                c3.a.m((c3.a) null);
                throw th;
            }
        } else {
            z10 = c3.a.z(this.f20168b.d(inputStream, i10));
        }
        c3.a aVar = z10;
        j jVar = new j(aVar);
        y2.b.b(inputStream);
        c3.a.m(aVar);
        return jVar;
    }

    /* access modifiers changed from: protected */
    public j d(InputStream inputStream, int i10) {
        return c(inputStream, i10);
    }

    /* access modifiers changed from: protected */
    public abstract j e(k5.b bVar);

    /* access modifiers changed from: protected */
    public abstract String f();
}
