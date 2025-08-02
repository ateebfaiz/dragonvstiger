package q0;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.b;
import java.util.HashMap;
import java.util.Map;
import r0.c;
import r0.i;
import y0.f;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final i f23172a = new i();

    /* renamed from: b  reason: collision with root package name */
    private final Map f23173b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map f23174c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final AssetManager f23175d;

    /* renamed from: e  reason: collision with root package name */
    private b f23176e;

    /* renamed from: f  reason: collision with root package name */
    private String f23177f = ".ttf";

    public a(Drawable.Callback callback, b bVar) {
        this.f23176e = bVar;
        if (!(callback instanceof View)) {
            f.c("LottieDrawable must be inside of a view for images to work.");
            this.f23175d = null;
            return;
        }
        this.f23175d = ((View) callback).getContext().getAssets();
    }

    private Typeface a(c cVar) {
        Typeface typeface;
        String a10 = cVar.a();
        Typeface typeface2 = (Typeface) this.f23174c.get(a10);
        if (typeface2 != null) {
            return typeface2;
        }
        String c10 = cVar.c();
        String b10 = cVar.b();
        b bVar = this.f23176e;
        if (bVar != null) {
            typeface = bVar.b(a10, c10, b10);
            if (typeface == null) {
                typeface = this.f23176e.a(a10);
            }
        } else {
            typeface = null;
        }
        b bVar2 = this.f23176e;
        if (bVar2 != null && typeface == null) {
            String d10 = bVar2.d(a10, c10, b10);
            if (d10 == null) {
                d10 = this.f23176e.c(a10);
            }
            if (d10 != null) {
                typeface = Typeface.createFromAsset(this.f23175d, d10);
            }
        }
        if (cVar.d() != null) {
            return cVar.d();
        }
        if (typeface == null) {
            typeface = Typeface.createFromAsset(this.f23175d, "fonts/" + a10 + this.f23177f);
        }
        this.f23174c.put(a10, typeface);
        return typeface;
    }

    private Typeface e(Typeface typeface, String str) {
        int i10;
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        if (contains && contains2) {
            i10 = 3;
        } else if (contains) {
            i10 = 2;
        } else if (contains2) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (typeface.getStyle() == i10) {
            return typeface;
        }
        return Typeface.create(typeface, i10);
    }

    public Typeface b(c cVar) {
        this.f23172a.b(cVar.a(), cVar.c());
        Typeface typeface = (Typeface) this.f23173b.get(this.f23172a);
        if (typeface != null) {
            return typeface;
        }
        Typeface e10 = e(a(cVar), cVar.c());
        this.f23173b.put(this.f23172a, e10);
        return e10;
    }

    public void c(String str) {
        this.f23177f = str;
    }

    public void d(b bVar) {
        this.f23176e = bVar;
    }
}
