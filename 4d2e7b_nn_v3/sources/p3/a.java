package p3;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import e5.e;
import e5.g;
import l5.b;
import w3.h;

public class a implements d5.a {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f23110a;

    /* renamed from: b  reason: collision with root package name */
    private final d5.a f23111b;

    public a(Resources resources, d5.a aVar) {
        this.f23110a = resources;
        this.f23111b = aVar;
    }

    private static boolean c(g gVar) {
        if (gVar.F() == 1 || gVar.F() == 0) {
            return false;
        }
        return true;
    }

    private static boolean d(g gVar) {
        if (gVar.l() == 0 || gVar.l() == -1) {
            return false;
        }
        return true;
    }

    public boolean a(e eVar) {
        return true;
    }

    public Drawable b(e eVar) {
        try {
            if (b.d()) {
                b.a("DefaultDrawableFactory#createDrawable");
            }
            if (eVar instanceof g) {
                g gVar = (g) eVar;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f23110a, gVar.x());
                if (d(gVar) || c(gVar)) {
                    h hVar = new h(bitmapDrawable, gVar.l(), gVar.F());
                    if (b.d()) {
                        b.b();
                    }
                    return hVar;
                }
                if (b.d()) {
                    b.b();
                }
                return bitmapDrawable;
            }
            d5.a aVar = this.f23111b;
            if (aVar != null && aVar.a(eVar)) {
                Drawable b10 = this.f23111b.b(eVar);
                if (b.d()) {
                    b.b();
                }
                return b10;
            } else if (!b.d()) {
                return null;
            } else {
                b.b();
                return null;
            }
        } catch (Throwable th) {
            if (b.d()) {
                b.b();
            }
            throw th;
        }
    }
}
