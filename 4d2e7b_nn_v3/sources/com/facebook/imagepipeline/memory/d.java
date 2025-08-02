package com.facebook.imagepipeline.memory;

import c3.h;
import h5.f0;
import h5.g0;
import h5.z;
import y2.l;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final h f19980a;

    /* renamed from: b  reason: collision with root package name */
    final b f19981b;

    class a implements h {
        a() {
        }

        /* renamed from: a */
        public void release(byte[] bArr) {
            d.this.b(bArr);
        }
    }

    static class b extends e {
        public b(b3.d dVar, f0 f0Var, g0 g0Var) {
            super(dVar, f0Var, g0Var);
        }

        /* access modifiers changed from: package-private */
        public b x(int i10) {
            return new h(p(i10), this.f19965c.f21950g, 0);
        }
    }

    public d(b3.d dVar, f0 f0Var) {
        boolean z10;
        if (f0Var.f21950g > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        this.f19981b = new b(dVar, f0Var, z.h());
        this.f19980a = new a();
    }

    public c3.a a(int i10) {
        return c3.a.B((byte[]) this.f19981b.get(i10), this.f19980a);
    }

    public void b(byte[] bArr) {
        this.f19981b.release(bArr);
    }
}
