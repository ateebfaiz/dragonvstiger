package g8;

import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.j;

public class c extends j {

    /* renamed from: c  reason: collision with root package name */
    protected final c f12222c;

    /* renamed from: d  reason: collision with root package name */
    protected a f12223d;

    /* renamed from: e  reason: collision with root package name */
    protected c f12224e;

    /* renamed from: f  reason: collision with root package name */
    protected String f12225f;

    /* renamed from: g  reason: collision with root package name */
    protected Object f12226g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f12227h;

    protected c(int i10, c cVar, a aVar) {
        this.f5169a = i10;
        this.f12222c = cVar;
        this.f12223d = aVar;
        this.f5170b = -1;
    }

    private final void g(a aVar, String str) {
        f fVar;
        if (aVar.c(str)) {
            Object b10 = aVar.b();
            String str2 = "Duplicate field '" + str + "'";
            if (b10 instanceof f) {
                fVar = (f) b10;
            } else {
                fVar = null;
            }
            throw new e(str2, fVar);
        }
    }

    public static c m(a aVar) {
        return new c(0, (c) null, aVar);
    }

    public final String b() {
        return this.f12225f;
    }

    public c h() {
        this.f12226g = null;
        return this.f12222c;
    }

    public c i() {
        a aVar;
        c cVar = this.f12224e;
        if (cVar != null) {
            return cVar.o(1);
        }
        a aVar2 = this.f12223d;
        if (aVar2 == null) {
            aVar = null;
        } else {
            aVar = aVar2.a();
        }
        c cVar2 = new c(1, this, aVar);
        this.f12224e = cVar2;
        return cVar2;
    }

    public c j(Object obj) {
        a aVar;
        c cVar = this.f12224e;
        if (cVar != null) {
            return cVar.p(1, obj);
        }
        a aVar2 = this.f12223d;
        if (aVar2 == null) {
            aVar = null;
        } else {
            aVar = aVar2.a();
        }
        c cVar2 = new c(1, this, aVar, obj);
        this.f12224e = cVar2;
        return cVar2;
    }

    public c k() {
        a aVar;
        c cVar = this.f12224e;
        if (cVar != null) {
            return cVar.o(2);
        }
        a aVar2 = this.f12223d;
        if (aVar2 == null) {
            aVar = null;
        } else {
            aVar = aVar2.a();
        }
        c cVar2 = new c(2, this, aVar);
        this.f12224e = cVar2;
        return cVar2;
    }

    public c l(Object obj) {
        a aVar;
        c cVar = this.f12224e;
        if (cVar != null) {
            return cVar.p(2, obj);
        }
        a aVar2 = this.f12223d;
        if (aVar2 == null) {
            aVar = null;
        } else {
            aVar = aVar2.a();
        }
        c cVar2 = new c(2, this, aVar, obj);
        this.f12224e = cVar2;
        return cVar2;
    }

    public a n() {
        return this.f12223d;
    }

    public c o(int i10) {
        this.f5169a = i10;
        this.f5170b = -1;
        this.f12225f = null;
        this.f12227h = false;
        this.f12226g = null;
        a aVar = this.f12223d;
        if (aVar != null) {
            aVar.d();
        }
        return this;
    }

    public c p(int i10, Object obj) {
        this.f5169a = i10;
        this.f5170b = -1;
        this.f12225f = null;
        this.f12227h = false;
        this.f12226g = obj;
        a aVar = this.f12223d;
        if (aVar != null) {
            aVar.d();
        }
        return this;
    }

    public void q(Object obj) {
        this.f12226g = obj;
    }

    public c r(a aVar) {
        this.f12223d = aVar;
        return this;
    }

    public int s(String str) {
        if (this.f5169a != 2 || this.f12227h) {
            return 4;
        }
        this.f12227h = true;
        this.f12225f = str;
        a aVar = this.f12223d;
        if (aVar != null) {
            g(aVar, str);
        }
        if (this.f5170b < 0) {
            return 0;
        }
        return 1;
    }

    public int t() {
        int i10 = this.f5169a;
        if (i10 == 2) {
            if (!this.f12227h) {
                return 5;
            }
            this.f12227h = false;
            this.f5170b++;
            return 2;
        } else if (i10 == 1) {
            int i11 = this.f5170b;
            this.f5170b = i11 + 1;
            if (i11 < 0) {
                return 0;
            }
            return 1;
        } else {
            int i12 = this.f5170b + 1;
            this.f5170b = i12;
            if (i12 == 0) {
                return 0;
            }
            return 3;
        }
    }

    protected c(int i10, c cVar, a aVar, Object obj) {
        this.f5169a = i10;
        this.f12222c = cVar;
        this.f12223d = aVar;
        this.f5170b = -1;
        this.f12226g = obj;
    }
}
