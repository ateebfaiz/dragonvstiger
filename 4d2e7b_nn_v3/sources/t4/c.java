package t4;

import android.net.Uri;
import androidx.core.view.PointerIconCompat;
import java.util.Iterator;
import java.util.LinkedHashSet;
import r2.d;
import x4.n;
import y2.j;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final d f24142a;

    /* renamed from: b  reason: collision with root package name */
    private final n f24143b;

    /* renamed from: c  reason: collision with root package name */
    private final n.b f24144c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final LinkedHashSet f24145d = new LinkedHashSet();

    class a implements n.b {
        a() {
        }

        /* renamed from: b */
        public void a(d dVar, boolean z10) {
            c.this.f(dVar, z10);
        }
    }

    static class b implements d {

        /* renamed from: a  reason: collision with root package name */
        private final d f24147a;

        /* renamed from: b  reason: collision with root package name */
        private final int f24148b;

        public b(d dVar, int i10) {
            this.f24147a = dVar;
            this.f24148b = i10;
        }

        public boolean a(Uri uri) {
            return this.f24147a.a(uri);
        }

        public boolean b() {
            return false;
        }

        public String c() {
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f24148b != bVar.f24148b || !this.f24147a.equals(bVar.f24147a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f24147a.hashCode() * PointerIconCompat.TYPE_ALL_SCROLL) + this.f24148b;
        }

        public String toString() {
            return j.c(this).b("imageCacheKey", this.f24147a).a("frameIndex", this.f24148b).toString();
        }
    }

    public c(d dVar, n nVar) {
        this.f24142a = dVar;
        this.f24143b = nVar;
    }

    private b e(int i10) {
        return new b(this.f24142a, i10);
    }

    private synchronized d g() {
        d dVar;
        Iterator it = this.f24145d.iterator();
        if (it.hasNext()) {
            dVar = (d) it.next();
            it.remove();
        } else {
            dVar = null;
        }
        return dVar;
    }

    public c3.a a(int i10, c3.a aVar) {
        return this.f24143b.e(e(i10), aVar, this.f24144c);
    }

    public boolean b(int i10) {
        return this.f24143b.contains(e(i10));
    }

    public c3.a c(int i10) {
        return this.f24143b.get(e(i10));
    }

    public c3.a d() {
        c3.a d10;
        do {
            d g10 = g();
            if (g10 == null) {
                return null;
            }
            d10 = this.f24143b.d(g10);
        } while (d10 == null);
        return d10;
    }

    public synchronized void f(d dVar, boolean z10) {
        if (z10) {
            try {
                this.f24145d.add(dVar);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            this.f24145d.remove(dVar);
        }
    }
}
