package ld;

import yd.a;
import yd.c;
import yd.h;
import yd.i;
import yd.k;

public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    private int f1254c;

    /* renamed from: d  reason: collision with root package name */
    private int f1255d;

    /* renamed from: e  reason: collision with root package name */
    private yd.b f1256e;

    /* renamed from: f  reason: collision with root package name */
    private i f1257f;

    /* renamed from: g  reason: collision with root package name */
    private h f1258g;

    /* renamed from: h  reason: collision with root package name */
    private a f1259h;

    /* renamed from: i  reason: collision with root package name */
    private i[] f1260i;

    public b(int i10, int i11, yd.b bVar, i iVar, h hVar, String str) {
        this(i10, i11, bVar, iVar, c.a(bVar, iVar), hVar, str);
    }

    public yd.b b() {
        return this.f1256e;
    }

    public i c() {
        return this.f1257f;
    }

    public a d() {
        return this.f1259h;
    }

    public int e() {
        return this.f1255d;
    }

    public int f() {
        return this.f1254c;
    }

    public h g() {
        return this.f1258g;
    }

    public b(int i10, int i11, yd.b bVar, i iVar, a aVar, h hVar, String str) {
        super(true, str);
        this.f1254c = i10;
        this.f1255d = i11;
        this.f1256e = bVar;
        this.f1257f = iVar;
        this.f1259h = aVar;
        this.f1258g = hVar;
        this.f1260i = new k(bVar, iVar).c();
    }
}
