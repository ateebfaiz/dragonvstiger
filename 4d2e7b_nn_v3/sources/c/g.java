package c;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public abstract class g {
    public String OooO00o;
    public boolean OooO0O0;
    public Hashtable OooO0OO;

    public g(boolean z10) {
        this.OooO0O0 = true;
    }

    public abstract void OooO00o(b bVar);

    public void OooO00o(InputStream inputStream) throws IOException {
        OooO00o(new b(inputStream));
    }

    public abstract void OooO0O0(c cVar);

    public boolean OooO0O0(b bVar, int i10) throws IOException {
        f.a(OooO0o0(), i10 >>> 3);
        return bVar.j(i10);
    }

    public Object OooO0OO(f fVar) {
        f.c(OooO0o0(), fVar);
        OooO00o(fVar);
        Object obj = this.OooO0OO.get(fVar);
        obj.getClass();
        return obj;
    }

    public int OooO0Oo(f fVar) {
        Vector OooO0o = OooO0o(fVar);
        if (OooO0o != null) {
            return OooO0o.size();
        }
        return 0;
    }

    public abstract int OooO0o();

    public final Vector OooO0o(f fVar) {
        f.c(OooO0o0(), fVar);
        throw null;
    }

    public String OooO0o0() {
        return this.OooO00o;
    }

    public void OooO0oO() {
        this.OooO0OO = new Hashtable();
    }

    public boolean OooO0oo(f fVar) {
        f.c(OooO0o0(), fVar);
        OooO00o(fVar);
        return this.OooO0OO.contains(fVar);
    }

    public a OooOO0() {
        byte[] bArr = new byte[OooO0o()];
        c f10 = c.f(bArr);
        try {
            OooO0O0(f10);
            f10.h();
            return new a(bArr);
        } catch (IOException e10) {
            throw new RuntimeException(e10.getMessage());
        }
    }

    public Enumeration OooO0o0(f fVar) {
        Vector OooO0o = OooO0o(fVar);
        if (OooO0o != null) {
            return OooO0o.elements();
        }
        return new Vector(0).elements();
    }

    public final Vector OooO0oO(f fVar) {
        Vector OooO0o = OooO0o(fVar);
        if (OooO0o != null) {
            return OooO0o;
        }
        Vector vector = new Vector(1);
        this.OooO0OO.put(fVar, vector);
        return vector;
    }

    public g(String str) {
        this.OooO00o = str;
    }

    public void OooO00o() {
        if (this.OooO0O0) {
            throw new RuntimeException("Read only message!");
        }
    }

    public void OooO0O0(f fVar, Object obj) {
        OooO00o();
        f.c(OooO0o0(), fVar);
        OooO00o(fVar);
        this.OooO0OO.put(fVar, obj);
    }

    public int OooO0Oo() {
        Enumeration keys = this.OooO0OO.keys();
        if (!keys.hasMoreElements()) {
            return 0;
        }
        d.a(keys.nextElement());
        this.OooO0OO.get((Object) null);
        throw null;
    }

    public void OooO00o(OutputStream outputStream) throws IOException {
        c e10 = c.e(outputStream);
        OooO0O0(e10);
        e10.h();
    }

    public int OooO0OO() {
        Enumeration keys = this.OooO0OO.keys();
        if (!keys.hasMoreElements()) {
            return 0;
        }
        d.a(keys.nextElement());
        this.OooO0OO.get((Object) null);
        throw null;
    }

    public void OooO0O0(f fVar) {
        OooO00o();
        this.OooO0OO.remove(fVar);
    }

    public static int OooO00o(h hVar, boolean z10) {
        if (z10) {
            return 2;
        }
        return hVar.a();
    }

    public boolean OooO00o(b bVar, int i10) throws IOException {
        return bVar.j(i10);
    }

    public boolean OooO0O0() {
        Enumeration keys = this.OooO0OO.keys();
        if (!keys.hasMoreElements()) {
            return true;
        }
        d.a(keys.nextElement());
        this.OooO0OO.get((Object) null);
        throw null;
    }

    public void OooO00o(a aVar) throws IOException {
        OooO00o(b.c(aVar.f17188a));
    }

    public final void OooO00o(f fVar) {
        throw null;
    }

    public Object OooO00o(f fVar, int i10) {
        Vector OooO0o = OooO0o(fVar);
        if (OooO0o != null) {
            return OooO0o.elementAt(i10);
        }
        throw new ArrayIndexOutOfBoundsException(i10);
    }

    public void OooO00o(f fVar, int i10, Object obj) {
        OooO00o();
        OooO0oO(fVar).setElementAt(obj, i10);
    }

    public void OooO00o(f fVar, Object obj) {
        OooO00o();
        OooO0oO(fVar).addElement(obj);
    }

    public boolean OooO00o(g gVar) {
        if (OooO0o0().equals(gVar.OooO0o0())) {
            Enumeration keys = this.OooO0OO.keys();
            while (keys.hasMoreElements()) {
                d.a(keys.nextElement());
                Object obj = this.OooO0OO.get((Object) null);
                Object obj2 = gVar.OooO0OO.get((Object) null);
                if (obj == null || obj2 == null) {
                    if (obj != null || obj2 != null) {
                        return false;
                    }
                } else if (!obj.equals(obj2)) {
                    return false;
                }
            }
            return true;
        }
        throw new RuntimeException("Type mismtach.");
    }

    public void OooO00o(c cVar) throws IOException {
        Enumeration keys = this.OooO0OO.keys();
        if (keys.hasMoreElements()) {
            d.a(keys.nextElement());
            this.OooO0OO.get((Object) null);
            throw null;
        }
    }
}
