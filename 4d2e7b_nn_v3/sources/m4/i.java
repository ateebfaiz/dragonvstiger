package m4;

import m4.b;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private String f22583a;

    /* renamed from: b  reason: collision with root package name */
    private String f22584b;

    /* renamed from: c  reason: collision with root package name */
    private Object f22585c;

    /* renamed from: d  reason: collision with root package name */
    private Object f22586d;

    /* renamed from: e  reason: collision with root package name */
    private Object f22587e;

    /* renamed from: f  reason: collision with root package name */
    private long f22588f = -1;

    /* renamed from: g  reason: collision with root package name */
    private long f22589g = -1;

    /* renamed from: h  reason: collision with root package name */
    private long f22590h = -1;

    /* renamed from: i  reason: collision with root package name */
    private long f22591i = -1;

    /* renamed from: j  reason: collision with root package name */
    private long f22592j = -1;

    /* renamed from: k  reason: collision with root package name */
    private long f22593k = -1;

    /* renamed from: l  reason: collision with root package name */
    private long f22594l = -1;

    /* renamed from: m  reason: collision with root package name */
    private boolean f22595m;

    /* renamed from: n  reason: collision with root package name */
    private int f22596n = -1;

    /* renamed from: o  reason: collision with root package name */
    private int f22597o = -1;

    /* renamed from: p  reason: collision with root package name */
    private Throwable f22598p;

    /* renamed from: q  reason: collision with root package name */
    private e f22599q = e.UNKNOWN;

    /* renamed from: r  reason: collision with root package name */
    private l f22600r = l.UNKNOWN;

    /* renamed from: s  reason: collision with root package name */
    private long f22601s = -1;

    /* renamed from: t  reason: collision with root package name */
    private long f22602t = -1;

    /* renamed from: u  reason: collision with root package name */
    private long f22603u = -1;

    /* renamed from: v  reason: collision with root package name */
    private b.a f22604v;

    public e a() {
        return this.f22599q;
    }

    public void b() {
        this.f22584b = null;
        this.f22585c = null;
        this.f22586d = null;
        this.f22587e = null;
        this.f22595m = false;
        this.f22596n = -1;
        this.f22597o = -1;
        this.f22598p = null;
        this.f22599q = e.UNKNOWN;
        this.f22600r = l.UNKNOWN;
        this.f22604v = null;
        c();
    }

    public void c() {
        this.f22593k = -1;
        this.f22594l = -1;
        this.f22588f = -1;
        this.f22590h = -1;
        this.f22591i = -1;
        this.f22592j = -1;
        this.f22601s = -1;
        this.f22602t = -1;
        this.f22603u = -1;
    }

    public void d(Object obj) {
        this.f22586d = obj;
    }

    public void e(long j10) {
        this.f22592j = j10;
    }

    public void f(long j10) {
        this.f22591i = j10;
    }

    public void g(long j10) {
        this.f22590h = j10;
    }

    public void h(String str) {
        this.f22583a = str;
    }

    public void i(long j10) {
        this.f22589g = j10;
    }

    public void j(long j10) {
        this.f22588f = j10;
    }

    public void k(Throwable th) {
        this.f22598p = th;
    }

    public void l(b.a aVar) {
        this.f22604v = aVar;
    }

    public void m(Object obj) {
        this.f22587e = obj;
    }

    public void n(e eVar) {
        this.f22599q = eVar;
    }

    public void o(Object obj) {
        this.f22585c = obj;
    }

    public void p(long j10) {
        this.f22594l = j10;
    }

    public void q(long j10) {
        this.f22593k = j10;
    }

    public void r(long j10) {
        this.f22602t = j10;
    }

    public void s(int i10) {
        this.f22597o = i10;
    }

    public void t(int i10) {
        this.f22596n = i10;
    }

    public void u(boolean z10) {
        this.f22595m = z10;
    }

    public void v(String str) {
        this.f22584b = str;
    }

    public void w(long j10) {
        this.f22601s = j10;
    }

    public void x(boolean z10) {
        l lVar;
        if (z10) {
            lVar = l.VISIBLE;
        } else {
            lVar = l.INVISIBLE;
        }
        this.f22600r = lVar;
    }

    public f y() {
        return new f(this.f22583a, this.f22584b, this.f22585c, this.f22586d, this.f22587e, this.f22588f, this.f22589g, this.f22590h, this.f22591i, this.f22592j, this.f22593k, this.f22594l, this.f22595m, this.f22596n, this.f22597o, this.f22598p, this.f22600r, this.f22601s, this.f22602t, this.f22603u, (c) null, this.f22604v);
    }
}
