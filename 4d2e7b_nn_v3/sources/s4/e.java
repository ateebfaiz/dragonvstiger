package s4;

import android.graphics.Bitmap;
import android.graphics.Rect;
import b3.h;
import e5.f;
import e5.g;
import e5.j;
import e5.n;
import java.util.ArrayList;
import java.util.List;
import r4.c;
import t4.d;
import w4.d;
import y2.l;

public class e implements d {

    /* renamed from: e  reason: collision with root package name */
    static c f23874e = g("com.facebook.animated.gif.GifImage");

    /* renamed from: f  reason: collision with root package name */
    static c f23875f = g("com.facebook.animated.webp.WebPImage");

    /* renamed from: a  reason: collision with root package name */
    private final t4.b f23876a;

    /* renamed from: b  reason: collision with root package name */
    private final d f23877b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f23878c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f23879d;

    class a implements d.b {
        a() {
        }

        public void a(int i10, Bitmap bitmap) {
        }

        public c3.a b(int i10) {
            return null;
        }
    }

    class b implements d.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f23881a;

        b(List list) {
            this.f23881a = list;
        }

        public void a(int i10, Bitmap bitmap) {
        }

        public c3.a b(int i10) {
            return c3.a.j((c3.a) this.f23881a.get(i10));
        }
    }

    public e(t4.b bVar, w4.d dVar, boolean z10) {
        this(bVar, dVar, z10, true);
    }

    private c3.a c(int i10, int i11, Bitmap.Config config) {
        c3.a d10 = this.f23877b.d(i10, i11, config);
        ((Bitmap) d10.p()).eraseColor(0);
        ((Bitmap) d10.p()).setHasAlpha(true);
        return d10;
    }

    private c3.a d(c cVar, Bitmap.Config config, int i10) {
        c3.a c10 = c(cVar.getWidth(), cVar.getHeight(), config);
        new t4.d(this.f23876a.a(r4.e.b(cVar), (Rect) null), this.f23878c, new a()).h(i10, (Bitmap) c10.p());
        return c10;
    }

    private List e(c cVar, Bitmap.Config config) {
        r4.a a10 = this.f23876a.a(r4.e.b(cVar), (Rect) null);
        ArrayList arrayList = new ArrayList(a10.getFrameCount());
        t4.d dVar = new t4.d(a10, this.f23878c, new b(arrayList));
        for (int i10 = 0; i10 < a10.getFrameCount(); i10++) {
            c3.a c10 = c(a10.getWidth(), a10.getHeight(), config);
            dVar.h(i10, (Bitmap) c10.p());
            arrayList.add(c10);
        }
        return arrayList;
    }

    private e5.e f(String str, y4.c cVar, c cVar2, Bitmap.Config config) {
        List list;
        int i10;
        c3.a aVar;
        c3.a aVar2 = null;
        try {
            if (cVar.f24899d) {
                i10 = cVar2.getFrameCount() - 1;
            } else {
                i10 = 0;
            }
            if (cVar.f24902g) {
                g c10 = f.c(d(cVar2, config, i10), n.f21287d, 0);
                c3.a.m((c3.a) null);
                c3.a.n((Iterable) null);
                return c10;
            }
            if (cVar.f24901f) {
                list = e(cVar2, config);
                try {
                    aVar = c3.a.j((c3.a) list.get(i10));
                } catch (Throwable th) {
                    th = th;
                    c3.a.m(aVar2);
                    c3.a.n(list);
                    throw th;
                }
            } else {
                list = null;
                aVar = null;
            }
            try {
                if (cVar.f24898c && aVar == null) {
                    aVar = d(cVar2, config, i10);
                }
                e5.c cVar3 = new e5.c(r4.e.f(cVar2).k(aVar).j(i10).i(list).h((n5.a) null).l(str).a(), this.f23879d);
                c3.a.m(aVar);
                c3.a.n(list);
                return cVar3;
            } catch (Throwable th2) {
                th = th2;
                aVar2 = aVar;
                c3.a.m(aVar2);
                c3.a.n(list);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            list = null;
            c3.a.m(aVar2);
            c3.a.n(list);
            throw th;
        }
    }

    private static c g(String str) {
        try {
            return (c) Class.forName(str).newInstance();
        } catch (Throwable unused) {
            return null;
        }
    }

    public e5.e a(j jVar, y4.c cVar, Bitmap.Config config) {
        c cVar2;
        if (f23875f != null) {
            c3.a k10 = jVar.k();
            l.g(k10);
            try {
                h hVar = (h) k10.p();
                if (hVar.e() != null) {
                    cVar2 = f23875f.c(hVar.e(), cVar);
                } else {
                    cVar2 = f23875f.b(hVar.f(), hVar.size(), cVar);
                }
                e5.e f10 = f(jVar.B(), cVar, cVar2, config);
                c3.a.m(k10);
                return f10;
            } catch (Throwable th) {
                c3.a.m(k10);
                throw th;
            }
        } else {
            throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
        }
    }

    public e5.e b(j jVar, y4.c cVar, Bitmap.Config config) {
        c cVar2;
        if (f23874e != null) {
            c3.a k10 = jVar.k();
            l.g(k10);
            try {
                h hVar = (h) k10.p();
                if (hVar.e() != null) {
                    cVar2 = f23874e.c(hVar.e(), cVar);
                } else {
                    cVar2 = f23874e.b(hVar.f(), hVar.size(), cVar);
                }
                e5.e f10 = f(jVar.B(), cVar, cVar2, config);
                c3.a.m(k10);
                return f10;
            } catch (Throwable th) {
                c3.a.m(k10);
                throw th;
            }
        } else {
            throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
        }
    }

    public e(t4.b bVar, w4.d dVar, boolean z10, boolean z11) {
        this.f23876a = bVar;
        this.f23877b = dVar;
        this.f23878c = z10;
        this.f23879d = z11;
    }
}
