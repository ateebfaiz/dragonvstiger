package c5;

import android.graphics.ColorSpace;
import android.graphics.Rect;
import e5.e;
import e5.f;
import e5.g;
import e5.j;
import e5.n;
import i5.d;
import java.io.InputStream;
import java.util.Map;
import y2.l;
import y2.o;
import y2.p;
import y4.c;

public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final c f17315a;

    /* renamed from: b  reason: collision with root package name */
    private final c f17316b;

    /* renamed from: c  reason: collision with root package name */
    private final d f17317c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final o f17318d;

    /* renamed from: e  reason: collision with root package name */
    private final c f17319e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f17320f;

    class a implements c {
        a() {
        }

        public e a(j jVar, int i10, e5.o oVar, c cVar) {
            ColorSpace colorSpace;
            q4.c v10 = jVar.v();
            if (((Boolean) b.this.f17318d.get()).booleanValue()) {
                colorSpace = cVar.f24906k;
                if (colorSpace == null) {
                    colorSpace = jVar.n();
                }
            } else {
                colorSpace = cVar.f24906k;
            }
            ColorSpace colorSpace2 = colorSpace;
            if (v10 == q4.b.f23216b) {
                return b.this.e(jVar, i10, oVar, cVar, colorSpace2);
            }
            if (v10 == q4.b.f23218d) {
                return b.this.d(jVar, i10, oVar, cVar);
            }
            if (v10 == q4.b.f23225k) {
                return b.this.c(jVar, i10, oVar, cVar);
            }
            if (v10 != q4.c.f23230d) {
                return b.this.f(jVar, cVar);
            }
            throw new a("unknown image format", jVar);
        }
    }

    public b(c cVar, c cVar2, d dVar) {
        this(cVar, cVar2, dVar, (Map) null);
    }

    public e a(j jVar, int i10, e5.o oVar, c cVar) {
        c cVar2;
        InputStream w10;
        c cVar3 = cVar.f24905j;
        if (cVar3 != null) {
            return cVar3.a(jVar, i10, oVar, cVar);
        }
        q4.c v10 = jVar.v();
        if ((v10 == null || v10 == q4.c.f23230d) && (w10 = jVar.w()) != null) {
            v10 = q4.d.c(w10);
            jVar.R(v10);
        }
        Map map = this.f17320f;
        if (map == null || (cVar2 = (c) map.get(v10)) == null) {
            return this.f17319e.a(jVar, i10, oVar, cVar);
        }
        return cVar2.a(jVar, i10, oVar, cVar);
    }

    public e c(j jVar, int i10, e5.o oVar, c cVar) {
        c cVar2;
        if (cVar.f24902g || (cVar2 = this.f17316b) == null) {
            return f(jVar, cVar);
        }
        return cVar2.a(jVar, i10, oVar, cVar);
    }

    public e d(j jVar, int i10, e5.o oVar, c cVar) {
        c cVar2;
        if (jVar.getWidth() == -1 || jVar.getHeight() == -1) {
            throw new a("image width or height is incorrect", jVar);
        } else if (cVar.f24902g || (cVar2 = this.f17315a) == null) {
            return f(jVar, cVar);
        } else {
            return cVar2.a(jVar, i10, oVar, cVar);
        }
    }

    public g e(j jVar, int i10, e5.o oVar, c cVar, ColorSpace colorSpace) {
        c3.a a10 = this.f17317c.a(jVar, cVar.f24903h, (Rect) null, i10, colorSpace);
        try {
            n5.b.a((n5.a) null, a10);
            l.g(a10);
            g d10 = f.d(a10, oVar, jVar.l(), jVar.F());
            d10.w("is_rounded", false);
            return d10;
        } finally {
            c3.a.m(a10);
        }
    }

    public g f(j jVar, c cVar) {
        c3.a b10 = this.f17317c.b(jVar, cVar.f24903h, (Rect) null, cVar.f24906k);
        try {
            n5.b.a((n5.a) null, b10);
            l.g(b10);
            g d10 = f.d(b10, n.f21287d, jVar.l(), jVar.F());
            d10.w("is_rounded", false);
            return d10;
        } finally {
            c3.a.m(b10);
        }
    }

    public b(c cVar, c cVar2, d dVar, Map map) {
        this.f17319e = new a();
        this.f17315a = cVar;
        this.f17316b = cVar2;
        this.f17317c = dVar;
        this.f17320f = map;
        this.f17318d = p.f24881b;
    }
}
