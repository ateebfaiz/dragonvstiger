package r8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.d;
import i8.b;
import q8.e;
import q8.g;

public abstract class m extends g {

    /* renamed from: a  reason: collision with root package name */
    protected final e f12967a;

    /* renamed from: b  reason: collision with root package name */
    protected final d f12968b;

    protected m(e eVar, d dVar) {
        this.f12967a = eVar;
        this.f12968b = dVar;
    }

    public String b() {
        return null;
    }

    public b g(f fVar, b bVar) {
        i(bVar);
        return fVar.w0(bVar);
    }

    public b h(f fVar, b bVar) {
        return fVar.x0(bVar);
    }

    /* access modifiers changed from: protected */
    public void i(b bVar) {
        String str;
        if (bVar.f12332c == null) {
            Object obj = bVar.f12330a;
            Class cls = bVar.f12331b;
            if (cls == null) {
                str = k(obj);
            } else {
                str = l(obj, cls);
            }
            bVar.f12332c = str;
        }
    }

    /* access modifiers changed from: protected */
    public void j(Object obj) {
    }

    /* access modifiers changed from: protected */
    public String k(Object obj) {
        String a10 = this.f12967a.a(obj);
        if (a10 == null) {
            j(obj);
        }
        return a10;
    }

    /* access modifiers changed from: protected */
    public String l(Object obj, Class cls) {
        String c10 = this.f12967a.c(obj, cls);
        if (c10 == null) {
            j(obj);
        }
        return c10;
    }
}
