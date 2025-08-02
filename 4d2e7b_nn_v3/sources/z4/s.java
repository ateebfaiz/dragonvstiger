package z4;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import b3.a;
import b3.i;
import c5.c;
import c5.e;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.producers.a0;
import com.facebook.imagepipeline.producers.a1;
import com.facebook.imagepipeline.producers.b;
import com.facebook.imagepipeline.producers.b1;
import com.facebook.imagepipeline.producers.d1;
import com.facebook.imagepipeline.producers.g;
import com.facebook.imagepipeline.producers.h;
import com.facebook.imagepipeline.producers.h0;
import com.facebook.imagepipeline.producers.i0;
import com.facebook.imagepipeline.producers.i1;
import com.facebook.imagepipeline.producers.j0;
import com.facebook.imagepipeline.producers.k1;
import com.facebook.imagepipeline.producers.m;
import com.facebook.imagepipeline.producers.n0;
import com.facebook.imagepipeline.producers.n1;
import com.facebook.imagepipeline.producers.o;
import com.facebook.imagepipeline.producers.o0;
import com.facebook.imagepipeline.producers.o1;
import com.facebook.imagepipeline.producers.p;
import com.facebook.imagepipeline.producers.p1;
import com.facebook.imagepipeline.producers.r1;
import com.facebook.imagepipeline.producers.s0;
import com.facebook.imagepipeline.producers.t0;
import com.facebook.imagepipeline.producers.t1;
import com.facebook.imagepipeline.producers.u1;
import com.facebook.imagepipeline.producers.v;
import com.facebook.imagepipeline.producers.w0;
import com.facebook.imagepipeline.producers.x0;
import com.facebook.imagepipeline.producers.y;
import com.facebook.imagepipeline.producers.y0;
import com.facebook.imagepipeline.producers.z;
import java.util.Map;
import x4.d;
import x4.j;
import x4.k;
import x4.x;

public class s {

    /* renamed from: a  reason: collision with root package name */
    protected ContentResolver f25180a;

    /* renamed from: b  reason: collision with root package name */
    protected Resources f25181b;

    /* renamed from: c  reason: collision with root package name */
    protected AssetManager f25182c;

    /* renamed from: d  reason: collision with root package name */
    protected final a f25183d;

    /* renamed from: e  reason: collision with root package name */
    protected final c f25184e;

    /* renamed from: f  reason: collision with root package name */
    protected final e f25185f;

    /* renamed from: g  reason: collision with root package name */
    protected final e f25186g;

    /* renamed from: h  reason: collision with root package name */
    protected final boolean f25187h;

    /* renamed from: i  reason: collision with root package name */
    protected final boolean f25188i;

    /* renamed from: j  reason: collision with root package name */
    protected final g f25189j;

    /* renamed from: k  reason: collision with root package name */
    protected final i f25190k;

    /* renamed from: l  reason: collision with root package name */
    protected final j f25191l;

    /* renamed from: m  reason: collision with root package name */
    protected final j f25192m;

    /* renamed from: n  reason: collision with root package name */
    protected final x f25193n;

    /* renamed from: o  reason: collision with root package name */
    protected final x f25194o;

    /* renamed from: p  reason: collision with root package name */
    protected final k f25195p;

    /* renamed from: q  reason: collision with root package name */
    protected final d f25196q;

    /* renamed from: r  reason: collision with root package name */
    protected final d f25197r;

    /* renamed from: s  reason: collision with root package name */
    protected final w4.d f25198s;

    /* renamed from: t  reason: collision with root package name */
    protected final int f25199t;

    /* renamed from: u  reason: collision with root package name */
    protected final int f25200u;

    /* renamed from: v  reason: collision with root package name */
    protected boolean f25201v;

    /* renamed from: w  reason: collision with root package name */
    protected final a f25202w;

    /* renamed from: x  reason: collision with root package name */
    protected final int f25203x;

    /* renamed from: y  reason: collision with root package name */
    protected final boolean f25204y;

    /* renamed from: z  reason: collision with root package name */
    protected final Map f25205z;

    public s(Context context, a aVar, c cVar, e eVar, e eVar2, boolean z10, boolean z11, g gVar, i iVar, x xVar, x xVar2, j jVar, j jVar2, Map map, k kVar, w4.d dVar, int i10, int i11, boolean z12, int i12, a aVar2, boolean z13, int i13) {
        int i14 = i13;
        this.f25180a = context.getApplicationContext().getContentResolver();
        this.f25181b = context.getApplicationContext().getResources();
        this.f25182c = context.getApplicationContext().getAssets();
        this.f25183d = aVar;
        this.f25184e = cVar;
        this.f25185f = eVar;
        this.f25186g = eVar2;
        this.f25187h = z10;
        this.f25188i = z11;
        this.f25189j = gVar;
        this.f25190k = iVar;
        this.f25194o = xVar;
        this.f25193n = xVar2;
        this.f25191l = jVar;
        this.f25192m = jVar2;
        this.f25205z = map;
        this.f25195p = kVar;
        this.f25198s = dVar;
        this.f25196q = new d(i14);
        this.f25197r = new d(i14);
        this.f25199t = i10;
        this.f25200u = i11;
        this.f25201v = z12;
        this.f25203x = i12;
        this.f25202w = aVar2;
        this.f25204y = z13;
    }

    public static b a(d1 d1Var) {
        return new b(d1Var);
    }

    public static m h(d1 d1Var, d1 d1Var2) {
        return new m(d1Var, d1Var2);
    }

    public a1 A(d1 d1Var) {
        return new a1(this.f25194o, this.f25195p, d1Var);
    }

    public b1 B(d1 d1Var) {
        return new b1(d1Var, this.f25198s, this.f25189j.c());
    }

    public i1 C() {
        return new i1(this.f25189j.e(), this.f25190k, this.f25180a);
    }

    public k1 D(d1 d1Var, boolean z10, m5.d dVar) {
        return new k1(this.f25189j.c(), this.f25190k, d1Var, z10, dVar);
    }

    public n1 E(d1 d1Var) {
        return new n1(d1Var);
    }

    public r1 F(d1 d1Var) {
        return new r1(5, this.f25189j.b(), d1Var);
    }

    public t1 G(u1[] u1VarArr) {
        return new t1(u1VarArr);
    }

    public d1 b(d1 d1Var, p1 p1Var) {
        return new o1(d1Var, p1Var);
    }

    public g c(d1 d1Var) {
        return new g(this.f25194o, this.f25195p, d1Var);
    }

    public h d(d1 d1Var) {
        return new h(this.f25195p, d1Var);
    }

    public com.facebook.imagepipeline.producers.i e(d1 d1Var) {
        return new com.facebook.imagepipeline.producers.i(this.f25194o, this.f25195p, d1Var);
    }

    public com.facebook.imagepipeline.producers.j f(d1 d1Var) {
        return new com.facebook.imagepipeline.producers.j(d1Var, this.f25199t, this.f25200u, this.f25201v);
    }

    public com.facebook.imagepipeline.producers.k g(d1 d1Var) {
        return new com.facebook.imagepipeline.producers.k(this.f25193n, this.f25191l, this.f25192m, this.f25195p, this.f25196q, this.f25197r, d1Var);
    }

    public o i() {
        return new o(this.f25190k);
    }

    public p j(d1 d1Var) {
        return new p(this.f25183d, this.f25189j.a(), this.f25184e, this.f25185f, this.f25186g, this.f25187h, this.f25188i, d1Var, this.f25203x, this.f25202w, (Runnable) null, y2.p.f24881b);
    }

    public com.facebook.imagepipeline.producers.s k(d1 d1Var) {
        return new com.facebook.imagepipeline.producers.s(d1Var, this.f25189j.g());
    }

    public v l(d1 d1Var) {
        return new v(this.f25191l, this.f25192m, this.f25205z, this.f25195p, d1Var);
    }

    public com.facebook.imagepipeline.producers.x m(d1 d1Var) {
        return new com.facebook.imagepipeline.producers.x(this.f25191l, this.f25192m, this.f25205z, this.f25195p, d1Var);
    }

    public y n(d1 d1Var) {
        return new y(this.f25195p, this.f25204y, d1Var);
    }

    public d1 o(d1 d1Var) {
        return new z(this.f25193n, this.f25195p, d1Var);
    }

    public a0 p(d1 d1Var) {
        return new a0(this.f25191l, this.f25192m, this.f25195p, this.f25196q, this.f25197r, d1Var);
    }

    public h0 q() {
        return new h0(this.f25189j.e(), this.f25190k, this.f25182c);
    }

    public i0 r() {
        return new i0(this.f25189j.e(), this.f25190k, this.f25180a);
    }

    public j0 s() {
        return new j0(this.f25189j.e(), this.f25190k, this.f25180a);
    }

    public LocalExifThumbnailProducer t() {
        return new LocalExifThumbnailProducer(this.f25189j.f(), this.f25190k, this.f25180a);
    }

    public n0 u() {
        return new n0(this.f25189j.e(), this.f25190k);
    }

    public o0 v() {
        return new o0(this.f25189j.e(), this.f25190k, this.f25181b);
    }

    public s0 w() {
        return new s0(this.f25189j.c(), this.f25180a);
    }

    public t0 x() {
        return new t0(this.f25189j.e(), this.f25180a);
    }

    public d1 y(x0 x0Var) {
        return new w0(this.f25190k, this.f25183d, x0Var);
    }

    public y0 z(d1 d1Var) {
        return new y0(this.f25191l, this.f25195p, this.f25190k, this.f25183d, d1Var);
    }
}
