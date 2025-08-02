package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.m;

public final class a0 extends OutputStream implements c0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map f19580a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private GraphRequest f19581b;

    /* renamed from: c  reason: collision with root package name */
    private d0 f19582c;

    /* renamed from: d  reason: collision with root package name */
    private int f19583d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f19584e;

    public a0(Handler handler) {
        this.f19584e = handler;
    }

    public void a(GraphRequest graphRequest) {
        d0 d0Var;
        this.f19581b = graphRequest;
        if (graphRequest != null) {
            d0Var = (d0) this.f19580a.get(graphRequest);
        } else {
            d0Var = null;
        }
        this.f19582c = d0Var;
    }

    public final void b(long j10) {
        GraphRequest graphRequest = this.f19581b;
        if (graphRequest != null) {
            if (this.f19582c == null) {
                d0 d0Var = new d0(this.f19584e, graphRequest);
                this.f19582c = d0Var;
                this.f19580a.put(graphRequest, d0Var);
            }
            d0 d0Var2 = this.f19582c;
            if (d0Var2 != null) {
                d0Var2.b(j10);
            }
            this.f19583d += (int) j10;
        }
    }

    public final int h() {
        return this.f19583d;
    }

    public final Map j() {
        return this.f19580a;
    }

    public void write(byte[] bArr) {
        m.f(bArr, "buffer");
        b((long) bArr.length);
    }

    public void write(byte[] bArr, int i10, int i11) {
        m.f(bArr, "buffer");
        b((long) i11);
    }

    public void write(int i10) {
        b(1);
    }
}
