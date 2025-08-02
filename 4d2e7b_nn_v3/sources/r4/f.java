package r4;

import c3.a;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final c f23686a;

    /* renamed from: b  reason: collision with root package name */
    private a f23687b;

    /* renamed from: c  reason: collision with root package name */
    private List f23688c;

    /* renamed from: d  reason: collision with root package name */
    private int f23689d;

    /* renamed from: e  reason: collision with root package name */
    private String f23690e;

    f(c cVar) {
        this.f23686a = cVar;
    }

    public e a() {
        try {
            return new e(this);
        } finally {
            a.m(this.f23687b);
            this.f23687b = null;
            a.n(this.f23688c);
            this.f23688c = null;
        }
    }

    public n5.a b() {
        return null;
    }

    public List c() {
        return a.k(this.f23688c);
    }

    public int d() {
        return this.f23689d;
    }

    public c e() {
        return this.f23686a;
    }

    public a f() {
        return a.j(this.f23687b);
    }

    public String g() {
        return this.f23690e;
    }

    public f h(n5.a aVar) {
        return this;
    }

    public f i(List list) {
        this.f23688c = a.k(list);
        return this;
    }

    public f j(int i10) {
        this.f23689d = i10;
        return this;
    }

    public f k(a aVar) {
        this.f23687b = a.j(aVar);
        return this;
    }

    public f l(String str) {
        this.f23690e = str;
        return this;
    }
}
