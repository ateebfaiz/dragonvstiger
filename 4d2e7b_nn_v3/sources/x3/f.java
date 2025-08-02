package x3;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import l5.b;
import w3.c;
import w3.g;
import w3.i;
import w3.j;
import w3.k;
import w3.l;
import w3.n;
import w3.o;
import w3.p;
import x3.e;
import z2.a;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Drawable f24757a = new ColorDrawable(0);

    private static Drawable a(Drawable drawable, e eVar, Resources resources) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            j jVar = new j(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint(), eVar.i());
            b(jVar, eVar);
            return jVar;
        } else if (drawable instanceof NinePatchDrawable) {
            n nVar = new n((NinePatchDrawable) drawable);
            b(nVar, eVar);
            return nVar;
        } else if (drawable instanceof ColorDrawable) {
            k a10 = k.a((ColorDrawable) drawable);
            b(a10, eVar);
            return a10;
        } else {
            a.I("WrappingUtils", "Don't know how to round that drawable: %s", drawable);
            return drawable;
        }
    }

    static void b(i iVar, e eVar) {
        iVar.e(eVar.j());
        iVar.s(eVar.d());
        iVar.b(eVar.b(), eVar.c());
        iVar.m(eVar.g());
        iVar.j(eVar.l());
        iVar.h(eVar.h());
        iVar.d(eVar.i());
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static w3.c c(w3.c r2) {
        /*
        L_0x0000:
            android.graphics.drawable.Drawable r0 = r2.r()
            if (r0 == r2) goto L_0x000f
            boolean r1 = r0 instanceof w3.c
            if (r1 != 0) goto L_0x000b
            goto L_0x000f
        L_0x000b:
            r2 = r0
            w3.c r2 = (w3.c) r2
            goto L_0x0000
        L_0x000f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: x3.f.c(w3.c):w3.c");
    }

    static Drawable d(Drawable drawable, e eVar, Resources resources) {
        try {
            if (b.d()) {
                b.a("WrappingUtils#maybeApplyLeafRounding");
            }
            if (!(drawable == null || eVar == null)) {
                if (eVar.k() == e.a.BITMAP_ONLY) {
                    if (drawable instanceof g) {
                        c c10 = c((g) drawable);
                        c10.setDrawable(a(c10.setDrawable(f24757a), eVar, resources));
                        if (b.d()) {
                            b.b();
                        }
                        return drawable;
                    }
                    Drawable a10 = a(drawable, eVar, resources);
                    if (b.d()) {
                        b.b();
                    }
                    return a10;
                }
            }
            return drawable;
        } finally {
            if (b.d()) {
                b.b();
            }
        }
    }

    static Drawable e(Drawable drawable, e eVar) {
        try {
            if (b.d()) {
                b.a("WrappingUtils#maybeWrapWithRoundedOverlayColor");
            }
            if (!(drawable == null || eVar == null)) {
                if (eVar.k() == e.a.OVERLAY_COLOR) {
                    l lVar = new l(drawable);
                    b(lVar, eVar);
                    lVar.x(eVar.f());
                    if (b.d()) {
                        b.b();
                    }
                    return lVar;
                }
            }
            return drawable;
        } finally {
            if (b.d()) {
                b.b();
            }
        }
    }

    static Drawable f(Drawable drawable, p.b bVar) {
        return g(drawable, bVar, (PointF) null);
    }

    static Drawable g(Drawable drawable, p.b bVar, PointF pointF) {
        if (b.d()) {
            b.a("WrappingUtils#maybeWrapWithScaleType");
        }
        if (drawable == null || bVar == null) {
            if (b.d()) {
                b.b();
            }
            return drawable;
        }
        o oVar = new o(drawable, bVar);
        if (pointF != null) {
            oVar.A(pointF);
        }
        if (b.d()) {
            b.b();
        }
        return oVar;
    }

    static void h(i iVar) {
        iVar.e(false);
        iVar.q(0.0f);
        iVar.b(0, 0.0f);
        iVar.m(0.0f);
        iVar.j(false);
        iVar.h(false);
        iVar.d(j.k());
    }

    static void i(c cVar, e eVar, Resources resources) {
        c c10 = c(cVar);
        Drawable r10 = c10.r();
        if (eVar == null || eVar.k() != e.a.BITMAP_ONLY) {
            if (r10 instanceof i) {
                h((i) r10);
            }
        } else if (r10 instanceof i) {
            b((i) r10, eVar);
        } else if (r10 != null) {
            c10.setDrawable(f24757a);
            c10.setDrawable(a(r10, eVar, resources));
        }
    }

    static void j(c cVar, e eVar) {
        Drawable r10 = cVar.r();
        if (eVar == null || eVar.k() != e.a.OVERLAY_COLOR) {
            if (r10 instanceof l) {
                Drawable drawable = f24757a;
                cVar.setDrawable(((l) r10).u(drawable));
                drawable.setCallback((Drawable.Callback) null);
            }
        } else if (r10 instanceof l) {
            l lVar = (l) r10;
            b(lVar, eVar);
            lVar.x(eVar.f());
        } else {
            cVar.setDrawable(e(cVar.setDrawable(f24757a), eVar));
        }
    }

    static o k(c cVar, p.b bVar) {
        Drawable f10 = f(cVar.setDrawable(f24757a), bVar);
        cVar.setDrawable(f10);
        y2.l.h(f10, "Parent has no child drawable!");
        return (o) f10;
    }
}
