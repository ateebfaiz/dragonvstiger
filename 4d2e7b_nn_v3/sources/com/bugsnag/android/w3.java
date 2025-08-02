package com.bugsnag.android;

import android.content.Context;
import c1.j;
import c1.s;
import com.bugsnag.android.d2;
import java.io.File;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class w3 extends d1.a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final j f19094c;

    /* renamed from: d  reason: collision with root package name */
    private final d1.e f19095d;

    /* renamed from: e  reason: collision with root package name */
    private final d1.e f19096e;

    /* renamed from: f  reason: collision with root package name */
    private final d1.e f19097f;

    /* renamed from: g  reason: collision with root package name */
    private final d1.e f19098g;

    /* renamed from: h  reason: collision with root package name */
    private final d1.e f19099h;

    /* renamed from: i  reason: collision with root package name */
    private final d1.e f19100i;

    /* renamed from: j  reason: collision with root package name */
    private final d1.e f19101j;

    public static final class a extends d1.e {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ w3 f19102e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ k4 f19103f;

        public a(w3 w3Var, k4 k4Var) {
            this.f19102e = w3Var;
            this.f19103f = k4Var;
        }

        public Object e() {
            m4 b10 = ((o4) this.f19102e.h().get()).b(this.f19103f);
            r3 r3Var = (r3) this.f19102e.g().a();
            if (r3Var != null) {
                r3Var.b();
            }
            return b10;
        }
    }

    public static final class b extends d1.e {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d1.d f19104e;

        public b(d1.d dVar) {
            this.f19104e = dVar;
        }

        public Object e() {
            o2 o2Var = (o2) this.f19104e.get();
            n2 d10 = o2Var.d();
            o2Var.f(new n2(0, false, false));
            return d10;
        }
    }

    public static final class c extends d1.e {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ w3 f19105e;

        public c(w3 w3Var) {
            this.f19105e = w3Var;
        }

        public Object e() {
            return c1.d.a(this.f19105e.f19094c.z());
        }
    }

    public static final class d extends d1.e {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f19106e;

        public d(Context context) {
            this.f19106e = context;
        }

        public Object e() {
            return new r3(this.f19106e);
        }
    }

    public static final class e extends d1.e {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ w3 f19107e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Context f19108f;

        public e(w3 w3Var, Context context) {
            this.f19107e = w3Var;
            this.f19108f = context;
        }

        public Object e() {
            d1.e g10 = this.f19107e.g();
            s2 r10 = this.f19107e.f19094c.r();
            return new g1(this.f19108f, (File) null, (Function0) null, (File) null, (Function0) null, g10, this.f19107e.f19094c, r10, 30, (DefaultConstructorMarker) null);
        }
    }

    public static final class f extends d1.e {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ w3 f19109e;

        public f(w3 w3Var) {
            this.f19109e = w3Var;
        }

        public Object e() {
            boolean y10 = this.f19109e.f19094c.y();
            d1.e b10 = this.f19109e.b();
            w3 w3Var = this.f19109e;
            i iVar = new i(w3Var.c());
            w3Var.f21012a.b(w3Var.f21013b, iVar);
            return new o4(y10, b10, iVar, (File) null, this.f19109e.g(), this.f19109e.f19094c.r(), 8, (DefaultConstructorMarker) null);
        }
    }

    public static final class g extends d1.e {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ w3 f19110e;

        public g(w3 w3Var) {
            this.f19110e = w3Var;
        }

        public Object e() {
            return new o2(this.f19110e.f19094c);
        }
    }

    public static final class h extends d1.e {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ w3 f19111e;

        public h(w3 w3Var) {
            this.f19111e = w3Var;
        }

        public Object e() {
            return new o3((File) this.f19111e.b().get(), this.f19111e.f19094c.u(), this.f19111e.f19094c.a(), this.f19111e.f19094c.r(), (d2.a) null);
        }
    }

    public static final class i extends d1.e {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d1.d f19112e;

        public i(d1.d dVar) {
            this.f19112e = dVar;
        }

        public Object e() {
            return ((g1) this.f19112e.get()).a();
        }
    }

    public w3(Context context, j jVar, c1.a aVar) {
        super(aVar, s.IO);
        this.f19094c = jVar;
        c1.a aVar2 = this.f21012a;
        s sVar = this.f21013b;
        c cVar = new c(this);
        aVar2.b(sVar, cVar);
        this.f19095d = cVar;
        c1.a aVar3 = this.f21012a;
        s sVar2 = this.f21013b;
        d dVar = new d(context);
        aVar3.b(sVar2, dVar);
        this.f19096e = dVar;
        c1.a aVar4 = this.f21012a;
        s sVar3 = this.f21013b;
        e eVar = new e(this, context);
        aVar4.b(sVar3, eVar);
        this.f19097f = eVar;
        c1.a aVar5 = this.f21012a;
        s sVar4 = this.f21013b;
        f fVar = new f(this);
        aVar5.b(sVar4, fVar);
        this.f19098g = fVar;
        c1.a aVar6 = this.f21012a;
        s sVar5 = this.f21013b;
        g gVar = new g(this);
        aVar6.b(sVar5, gVar);
        this.f19099h = gVar;
        c1.a aVar7 = this.f21012a;
        s sVar6 = this.f21013b;
        h hVar = new h(this);
        aVar7.b(sVar6, hVar);
        this.f19100i = hVar;
        b bVar = new b(gVar);
        this.f21012a.b(this.f21013b, bVar);
        this.f19101j = bVar;
    }

    public final d1.e b() {
        return this.f19095d;
    }

    public final d1.e c() {
        return this.f19097f;
    }

    public final d1.e d() {
        return this.f19101j;
    }

    public final d1.e e() {
        return this.f19099h;
    }

    public final d1.e f() {
        return this.f19100i;
    }

    public final d1.e g() {
        return this.f19096e;
    }

    public final d1.e h() {
        return this.f19098g;
    }

    public final d1.d i(k4 k4Var) {
        c1.a aVar = this.f21012a;
        s sVar = this.f21013b;
        a aVar2 = new a(this, k4Var);
        aVar.b(sVar, aVar2);
        return aVar2;
    }
}
