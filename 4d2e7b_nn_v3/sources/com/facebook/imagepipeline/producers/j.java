package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import e5.e;
import e5.g;
import y2.l;

public class j implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final d1 f20119a;

    /* renamed from: b  reason: collision with root package name */
    private final int f20120b;

    /* renamed from: c  reason: collision with root package name */
    private final int f20121c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f20122d;

    private static class a extends t {

        /* renamed from: c  reason: collision with root package name */
        private final int f20123c;

        /* renamed from: d  reason: collision with root package name */
        private final int f20124d;

        a(n nVar, int i10, int i11) {
            super(nVar);
            this.f20123c = i10;
            this.f20124d = i11;
        }

        private void p(c3.a aVar) {
            e eVar;
            Bitmap x10;
            int rowBytes;
            if (aVar != null && aVar.w() && (eVar = (e) aVar.p()) != null && !eVar.isClosed() && (eVar instanceof g) && (x10 = ((g) eVar).x()) != null && (rowBytes = x10.getRowBytes() * x10.getHeight()) >= this.f20123c && rowBytes <= this.f20124d) {
                x10.prepareToDraw();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: q */
        public void h(c3.a aVar, int i10) {
            p(aVar);
            o().c(aVar, i10);
        }
    }

    public j(d1 d1Var, int i10, int i11, boolean z10) {
        boolean z11;
        if (i10 <= i11) {
            z11 = true;
        } else {
            z11 = false;
        }
        l.b(Boolean.valueOf(z11));
        this.f20119a = (d1) l.g(d1Var);
        this.f20120b = i10;
        this.f20121c = i11;
        this.f20122d = z10;
    }

    public void b(n nVar, e1 e1Var) {
        if (!e1Var.n() || this.f20122d) {
            this.f20119a.b(new a(nVar, this.f20120b, this.f20121c), e1Var);
        } else {
            this.f20119a.b(nVar, e1Var);
        }
    }
}
