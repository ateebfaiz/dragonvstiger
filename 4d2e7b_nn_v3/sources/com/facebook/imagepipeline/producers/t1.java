package com.facebook.imagepipeline.producers;

import e5.j;
import y2.l;
import y4.f;

public class t1 implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final u1[] f20257a;

    private class a extends t {

        /* renamed from: c  reason: collision with root package name */
        private final e1 f20258c;

        /* renamed from: d  reason: collision with root package name */
        private final int f20259d;

        /* renamed from: e  reason: collision with root package name */
        private final f f20260e;

        public a(n nVar, e1 e1Var, int i10) {
            super(nVar);
            this.f20258c = e1Var;
            this.f20259d = i10;
            this.f20260e = e1Var.b().q();
        }

        /* access modifiers changed from: protected */
        public void g(Throwable th) {
            if (!t1.this.e(this.f20259d + 1, o(), this.f20258c)) {
                o().onFailure(th);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: p */
        public void h(j jVar, int i10) {
            if (jVar != null && (c.e(i10) || v1.c(jVar, this.f20260e))) {
                o().c(jVar, i10);
            } else if (c.d(i10)) {
                j.h(jVar);
                if (!t1.this.e(this.f20259d + 1, o(), this.f20258c)) {
                    o().c((Object) null, 1);
                }
            }
        }
    }

    public t1(u1... u1VarArr) {
        u1[] u1VarArr2 = (u1[]) l.g(u1VarArr);
        this.f20257a = u1VarArr2;
        l.e(0, u1VarArr2.length);
    }

    private int d(int i10, f fVar) {
        while (true) {
            u1[] u1VarArr = this.f20257a;
            if (i10 >= u1VarArr.length) {
                return -1;
            }
            if (u1VarArr[i10].a(fVar)) {
                return i10;
            }
            i10++;
        }
    }

    /* access modifiers changed from: private */
    public boolean e(int i10, n nVar, e1 e1Var) {
        int d10 = d(i10, e1Var.b().q());
        if (d10 == -1) {
            return false;
        }
        this.f20257a[d10].b(new a(nVar, e1Var, d10), e1Var);
        return true;
    }

    public void b(n nVar, e1 e1Var) {
        if (e1Var.b().q() == null) {
            nVar.c((Object) null, 1);
        } else if (!e(0, nVar, e1Var)) {
            nVar.c((Object) null, 1);
        }
    }
}
