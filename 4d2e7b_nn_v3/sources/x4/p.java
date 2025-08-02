package x4;

import android.net.Uri;
import k5.b;
import r2.d;
import r2.i;

public class p implements k {

    /* renamed from: a  reason: collision with root package name */
    private static p f24810a;

    protected p() {
    }

    public static synchronized p f() {
        p pVar;
        synchronized (p.class) {
            try {
                if (f24810a == null) {
                    f24810a = new p();
                }
                pVar = f24810a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pVar;
    }

    public d a(b bVar, Uri uri, Object obj) {
        return new i(e(uri).toString());
    }

    public d b(b bVar, Object obj) {
        String str;
        d dVar;
        k5.d k10 = bVar.k();
        if (k10 != null) {
            d b10 = k10.b();
            str = k10.getClass().getName();
            dVar = b10;
        } else {
            dVar = null;
            str = null;
        }
        b bVar2 = new b(e(bVar.u()).toString(), bVar.q(), bVar.s(), bVar.g(), dVar, str);
        bVar2.d(obj);
        return bVar2;
    }

    public d c(b bVar, Object obj) {
        return a(bVar, bVar.u(), obj);
    }

    public d d(b bVar, Object obj) {
        b bVar2 = new b(e(bVar.u()).toString(), bVar.q(), bVar.s(), bVar.g(), (d) null, (String) null);
        bVar2.d(obj);
        return bVar2;
    }

    /* access modifiers changed from: protected */
    public Uri e(Uri uri) {
        return uri;
    }
}
