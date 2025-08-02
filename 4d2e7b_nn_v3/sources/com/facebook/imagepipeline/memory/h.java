package com.facebook.imagepipeline.memory;

import c3.f;
import java.util.LinkedList;
import y2.l;

class h extends b {

    /* renamed from: f  reason: collision with root package name */
    private LinkedList f19988f = new LinkedList();

    public h(int i10, int i11, int i12) {
        super(i10, i11, i12, false);
    }

    /* access modifiers changed from: package-private */
    public void a(Object obj) {
        f fVar = (f) this.f19988f.poll();
        if (fVar == null) {
            fVar = new f();
        }
        fVar.c(obj);
        this.f19977c.add(fVar);
    }

    public Object g() {
        f fVar = (f) this.f19977c.poll();
        l.g(fVar);
        Object b10 = fVar.b();
        fVar.a();
        this.f19988f.add(fVar);
        return b10;
    }
}
