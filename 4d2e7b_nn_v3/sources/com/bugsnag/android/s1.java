package com.bugsnag.android;

import c1.j;
import c1.p;
import c1.u;
import com.bugsnag.android.a4;
import com.bugsnag.android.k2;
import com.bugsnag.android.q0;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.io.File;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class s1 implements k2.a, q0 {

    /* renamed from: g  reason: collision with root package name */
    public static final a f18985g = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private String f18986a;

    /* renamed from: b  reason: collision with root package name */
    private final j f18987b;

    /* renamed from: c  reason: collision with root package name */
    private o1 f18988c;

    /* renamed from: d  reason: collision with root package name */
    private File f18989d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f18990e;

    /* renamed from: f  reason: collision with root package name */
    private final e3 f18991f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public s1(String str, o1 o1Var, e3 e3Var, j jVar) {
        this(str, o1Var, (File) null, e3Var, jVar, 4, (DefaultConstructorMarker) null);
    }

    private final o1 b() {
        o1 o1Var = this.f18988c;
        if (o1Var != null) {
            return o1Var;
        }
        File file = this.f18989d;
        m.c(file);
        String str = this.f18986a;
        if (str == null) {
            str = this.f18987b.a();
        }
        o1 c10 = new v2(file, str, f()).invoke();
        this.f18988c = c10;
        return c10;
    }

    private final s2 f() {
        return this.f18987b.r();
    }

    public static /* synthetic */ s1 i(s1 s1Var, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 999700;
        }
        return s1Var.h(i10);
    }

    public byte[] a() {
        byte[] bArr = this.f18990e;
        if (bArr != null) {
            return bArr;
        }
        byte[] g10 = p.f17266a.g(this);
        this.f18990e = g10;
        return g10;
    }

    public final String c() {
        return this.f18986a;
    }

    public final Set d() {
        Set set;
        r1 i10;
        o1 o1Var = this.f18988c;
        Set set2 = null;
        if (o1Var == null || (i10 = o1Var.i()) == null) {
            set = null;
        } else {
            set = i10.i();
        }
        if (set != null) {
            return set;
        }
        File file = this.f18989d;
        if (file != null) {
            set2 = q1.f18935f.i(file, this.f18987b).d();
        }
        if (set2 == null) {
            return r0.d();
        }
        return set2;
    }

    public String e() {
        return q0.a.a(this);
    }

    public final byte[] g() {
        this.f18990e = null;
        return a();
    }

    public final s1 h(int i10) {
        if (a().length <= i10) {
            return this;
        }
        o1 b10 = b();
        u F = b10.i().F(this.f18987b.w());
        b10.i().k().f(F.a(), F.b());
        int size = b10.l().size();
        int v10 = this.f18987b.v();
        if (size > v10) {
            b10.l().subList(v10, size).clear();
            List l10 = b10.l();
            l10.add(new a4("", '[' + (size - v10) + " threads omitted as the maxReportedThreads limit (" + v10 + ") was exceeded]", ErrorType.UNKNOWN, false, a4.b.UNKNOWN, new u3(new StackTraceElement[]{new StackTraceElement("", "", "-", 0)}, this.f18987b.A(), f()), f()));
        }
        byte[] g10 = g();
        if (g10.length <= i10) {
            return this;
        }
        u E = b10.i().E(g10.length - i10);
        b10.i().k().c(E.d(), E.c());
        g();
        return this;
    }

    public void toStream(k2 k2Var) {
        k2Var.j();
        k2Var.v("apiKey").K(this.f18986a);
        k2Var.v("payloadVersion").K("4.0");
        k2Var.v("notifier").P(this.f18991f);
        k2Var.v(DbParams.TABLE_EVENTS).h();
        o1 o1Var = this.f18988c;
        if (o1Var != null) {
            k2Var.P(o1Var);
        } else {
            File file = this.f18989d;
            if (file != null) {
                k2Var.P(file);
            }
        }
        k2Var.m();
        k2Var.n();
    }

    public s1(String str, o1 o1Var, File file, e3 e3Var, j jVar) {
        this.f18986a = str;
        this.f18987b = jVar;
        this.f18988c = o1Var;
        this.f18989d = file;
        e3 e3Var2 = new e3(e3Var.b(), e3Var.d(), e3Var.c());
        e3Var2.e(r.y0(e3Var.a()));
        this.f18991f = e3Var2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s1(String str, o1 o1Var, File file, e3 e3Var, j jVar, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : o1Var, (i10 & 4) != 0 ? null : file, e3Var, jVar);
    }
}
