package com.bugsnag.android;

import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import c1.j;
import c1.s;
import d1.e;
import d1.f;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class n0 extends d1.a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f18859c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final j f18860d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final s2 f18861e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final x0 f18862f = x0.f19119j.a();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final File f18863g = Environment.getDataDirectory();

    /* renamed from: h  reason: collision with root package name */
    private final e f18864h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final e f18865i;

    /* renamed from: j  reason: collision with root package name */
    private final e f18866j;

    public static final class a extends e {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d1.d f18867e;

        public a(d1.d dVar) {
            this.f18867e = dVar;
        }

        public Object e() {
            return ((g1) this.f18867e.get()).a();
        }
    }

    public static final class b extends e {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ n0 f18868e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ i4 f18869f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ f f18870g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ w2 f18871h;

        public b(n0 n0Var, i4 i4Var, f fVar, w2 w2Var) {
            this.f18868e = n0Var;
            this.f18869f = i4Var;
            this.f18870g = fVar;
            this.f18871h = w2Var;
        }

        public Object e() {
            return new j(this.f18868e.f18859c, this.f18868e.f18859c.getPackageManager(), this.f18868e.f18860d, (p3) this.f18869f.c().get(), this.f18870g.a(), this.f18869f.b(), this.f18871h);
        }
    }

    public static final class c extends e {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ n0 f18872e;

        public c(n0 n0Var) {
            this.f18872e = n0Var;
        }

        public Object e() {
            return Boolean.valueOf(new RootDetector(this.f18872e.f18862f, (List) null, (File) null, this.f18872e.f18861e, 6, (DefaultConstructorMarker) null).g());
        }
    }

    public static final class d extends e {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ g0 f18873e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ n0 f18874f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ d1.d f18875g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ c1.a f18876h;

        public d(g0 g0Var, n0 n0Var, d1.d dVar, c1.a aVar) {
            this.f18873e = g0Var;
            this.f18874f = n0Var;
            this.f18875g = dVar;
            this.f18876h = aVar;
        }

        public Object e() {
            g0 g0Var = this.f18873e;
            Context b10 = this.f18874f.f18859c;
            Resources resources = this.f18874f.f18859c.getResources();
            n0 n0Var = this.f18874f;
            a aVar = new a(this.f18875g);
            n0Var.f21012a.b(n0Var.f21013b, aVar);
            return new b1(g0Var, b10, resources, aVar, this.f18874f.f18862f, this.f18874f.f18863g, this.f18874f.f18865i, this.f18876h, this.f18874f.f18861e);
        }
    }

    public n0(d1.c cVar, d1.b bVar, f fVar, i4 i4Var, c1.a aVar, g0 g0Var, d1.d dVar, w2 w2Var) {
        super(aVar, (s) null, 2, (DefaultConstructorMarker) null);
        this.f18859c = cVar.a();
        j a10 = bVar.a();
        this.f18860d = a10;
        this.f18861e = a10.r();
        c1.a aVar2 = this.f21012a;
        s sVar = this.f21013b;
        b bVar2 = new b(this, i4Var, fVar, w2Var);
        aVar2.b(sVar, bVar2);
        this.f18864h = bVar2;
        c1.a aVar3 = this.f21012a;
        s sVar2 = this.f21013b;
        c cVar2 = new c(this);
        aVar3.b(sVar2, cVar2);
        this.f18865i = cVar2;
        c1.a aVar4 = this.f21012a;
        s sVar3 = this.f21013b;
        d dVar2 = new d(g0Var, this, dVar, aVar);
        aVar4.b(sVar3, dVar2);
        this.f18866j = dVar2;
    }

    public final e g() {
        return this.f18864h;
    }

    public final e h() {
        return this.f18866j;
    }
}
