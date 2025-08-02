package com.facebook;

import android.os.Handler;
import kotlin.jvm.internal.m;

public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    private final long f19645a = o.v();

    /* renamed from: b  reason: collision with root package name */
    private long f19646b;

    /* renamed from: c  reason: collision with root package name */
    private long f19647c;

    /* renamed from: d  reason: collision with root package name */
    private long f19648d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f19649e;

    /* renamed from: f  reason: collision with root package name */
    private final GraphRequest f19650f;

    public d0(Handler handler, GraphRequest graphRequest) {
        m.f(graphRequest, "request");
        this.f19649e = handler;
        this.f19650f = graphRequest;
    }

    public final void a(long j10) {
        long j11 = this.f19646b + j10;
        this.f19646b = j11;
        if (j11 >= this.f19647c + this.f19645a || j11 >= this.f19648d) {
            c();
        }
    }

    public final void b(long j10) {
        this.f19648d += j10;
    }

    public final void c() {
        if (this.f19646b > this.f19647c) {
            this.f19650f.m();
        }
    }
}
