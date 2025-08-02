package com.bugsnag.android;

import c1.j;
import c1.s;
import d1.b;
import d1.e;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class i4 extends d1.a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final j f18772c;

    /* renamed from: d  reason: collision with root package name */
    private final q2 f18773d;

    /* renamed from: e  reason: collision with root package name */
    private final e f18774e;

    public static final class a extends e {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ z f18775e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ i4 f18776f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ y f18777g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ w3 f18778h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ c1.a f18779i;

        public a(z zVar, i4 i4Var, y yVar, w3 w3Var, c1.a aVar) {
            this.f18775e = zVar;
            this.f18776f = i4Var;
            this.f18777g = yVar;
            this.f18778h = w3Var;
            this.f18779i = aVar;
        }

        public Object e() {
            this.f18775e.m();
            return new p3(this.f18776f.f18772c, this.f18777g, this.f18775e, (o3) this.f18778h.f().get(), this.f18776f.f18772c.r(), this.f18779i);
        }
    }

    public i4(b bVar, w3 w3Var, z zVar, c1.a aVar, y yVar) {
        super(aVar, (s) null, 2, (DefaultConstructorMarker) null);
        j a10 = bVar.a();
        this.f18772c = a10;
        this.f18773d = new q2(a10, (ScheduledThreadPoolExecutor) null, 2, (DefaultConstructorMarker) null);
        c1.a aVar2 = this.f21012a;
        s sVar = this.f21013b;
        a aVar3 = new a(zVar, this, yVar, w3Var, aVar);
        aVar2.b(sVar, aVar3);
        this.f18774e = aVar3;
    }

    public final q2 b() {
        return this.f18773d;
    }

    public final e c() {
        return this.f18774e;
    }
}
