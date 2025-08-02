package com.facebook;

import com.facebook.s;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Map;
import kotlin.jvm.internal.m;

public final class b0 extends FilterOutputStream implements c0 {

    /* renamed from: a  reason: collision with root package name */
    private final long f19592a = o.v();

    /* renamed from: b  reason: collision with root package name */
    private long f19593b;

    /* renamed from: c  reason: collision with root package name */
    private long f19594c;

    /* renamed from: d  reason: collision with root package name */
    private d0 f19595d;

    /* renamed from: e  reason: collision with root package name */
    private final s f19596e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f19597f;

    /* renamed from: g  reason: collision with root package name */
    private final long f19598g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b0(OutputStream outputStream, s sVar, Map map, long j10) {
        super(outputStream);
        m.f(outputStream, "out");
        m.f(sVar, "requests");
        m.f(map, "progressMap");
        this.f19596e = sVar;
        this.f19597f = map;
        this.f19598g = j10;
    }

    private final void b(long j10) {
        d0 d0Var = this.f19595d;
        if (d0Var != null) {
            d0Var.a(j10);
        }
        long j11 = this.f19593b + j10;
        this.f19593b = j11;
        if (j11 >= this.f19594c + this.f19592a || j11 >= this.f19598g) {
            h();
        }
    }

    private final void h() {
        if (this.f19593b > this.f19594c) {
            for (s.a aVar : this.f19596e.n()) {
            }
            this.f19594c = this.f19593b;
        }
    }

    public void a(GraphRequest graphRequest) {
        d0 d0Var;
        if (graphRequest != null) {
            d0Var = (d0) this.f19597f.get(graphRequest);
        } else {
            d0Var = null;
        }
        this.f19595d = d0Var;
    }

    public void close() {
        super.close();
        for (d0 c10 : this.f19597f.values()) {
            c10.c();
        }
        h();
    }

    public void write(byte[] bArr) {
        m.f(bArr, "buffer");
        this.out.write(bArr);
        b((long) bArr.length);
    }

    public void write(byte[] bArr, int i10, int i11) {
        m.f(bArr, "buffer");
        this.out.write(bArr, i10, i11);
        b((long) i11);
    }

    public void write(int i10) {
        this.out.write(i10);
        b(1);
    }
}
