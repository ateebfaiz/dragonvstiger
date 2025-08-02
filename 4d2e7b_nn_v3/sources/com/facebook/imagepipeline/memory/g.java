package com.facebook.imagepipeline.memory;

import b3.k;
import h5.v;
import h5.x;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class g extends k {

    /* renamed from: a  reason: collision with root package name */
    private final f f19985a;

    /* renamed from: b  reason: collision with root package name */
    private c3.a f19986b;

    /* renamed from: c  reason: collision with root package name */
    private int f19987c;

    public static final class a extends RuntimeException {
        public a() {
            super("OutputStream no longer valid");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(f fVar, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(fVar, (i11 & 2) != 0 ? fVar.C() : i10);
    }

    private final void b() {
        if (!c3.a.y(this.f19986b)) {
            throw new a();
        }
    }

    public void close() {
        c3.a.m(this.f19986b);
        this.f19986b = null;
        this.f19987c = -1;
        super.close();
    }

    public final void h(int i10) {
        b();
        c3.a aVar = this.f19986b;
        if (aVar != null) {
            m.c(aVar);
            if (i10 > ((v) aVar.p()).getSize()) {
                Object obj = this.f19985a.get(i10);
                m.e(obj, "this.pool[newLength]");
                v vVar = (v) obj;
                c3.a aVar2 = this.f19986b;
                if (aVar2 != null) {
                    m.c(aVar2);
                    ((v) aVar2.p()).h(0, vVar, 0, this.f19987c);
                    c3.a aVar3 = this.f19986b;
                    m.c(aVar3);
                    aVar3.close();
                    this.f19986b = c3.a.B(vVar, this.f19985a);
                    return;
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* renamed from: j */
    public x a() {
        b();
        c3.a aVar = this.f19986b;
        if (aVar != null) {
            return new x(aVar, this.f19987c);
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public int size() {
        return this.f19987c;
    }

    public void write(int i10) {
        write(new byte[]{(byte) i10});
    }

    public g(f fVar, int i10) {
        m.f(fVar, "pool");
        if (i10 > 0) {
            this.f19985a = fVar;
            this.f19987c = 0;
            this.f19986b = c3.a.B(fVar.get(i10), fVar);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public void write(byte[] bArr, int i10, int i11) {
        m.f(bArr, "buffer");
        if (i10 < 0 || i11 < 0 || i10 + i11 > bArr.length) {
            throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i10 + "; regionLength=" + i11);
        }
        b();
        h(this.f19987c + i11);
        c3.a aVar = this.f19986b;
        if (aVar != null) {
            ((v) aVar.p()).b(this.f19987c, bArr, i10, i11);
            this.f19987c += i11;
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
