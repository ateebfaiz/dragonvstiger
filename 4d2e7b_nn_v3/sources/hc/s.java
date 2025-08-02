package hc;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import zd.a;

public abstract class s extends r implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    protected Vector f421a = new Vector();

    protected s() {
    }

    public static s o(Object obj) {
        if (obj == null || (obj instanceof s)) {
            return (s) obj;
        }
        if (obj instanceof t) {
            return o(((t) obj).c());
        }
        if (obj instanceof byte[]) {
            try {
                return o(r.k((byte[]) obj));
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e10.getMessage());
            }
        } else {
            if (obj instanceof d) {
                r c10 = ((d) obj).c();
                if (c10 instanceof s) {
                    return (s) c10;
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
    }

    private d p(Enumeration enumeration) {
        return (d) enumeration.nextElement();
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof s)) {
            return false;
        }
        s sVar = (s) rVar;
        if (size() != sVar.size()) {
            return false;
        }
        Enumeration r10 = r();
        Enumeration r11 = sVar.r();
        while (r10.hasMoreElements()) {
            d p10 = p(r10);
            d p11 = p(r11);
            r c10 = p10.c();
            r c11 = p11.c();
            if (c10 != c11 && !c10.equals(c11)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Enumeration r10 = r();
        int size = size();
        while (r10.hasMoreElements()) {
            size = (size * 17) ^ p(r10).hashCode();
        }
        return size;
    }

    public Iterator iterator() {
        return new a.C0038a(s());
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public r m() {
        z0 z0Var = new z0();
        z0Var.f421a = this.f421a;
        return z0Var;
    }

    /* access modifiers changed from: package-private */
    public r n() {
        l1 l1Var = new l1();
        l1Var.f421a = this.f421a;
        return l1Var;
    }

    public d q(int i10) {
        return (d) this.f421a.elementAt(i10);
    }

    public Enumeration r() {
        return this.f421a.elements();
    }

    public d[] s() {
        d[] dVarArr = new d[size()];
        for (int i10 = 0; i10 != size(); i10++) {
            dVarArr[i10] = q(i10);
        }
        return dVarArr;
    }

    public int size() {
        return this.f421a.size();
    }

    public String toString() {
        return this.f421a.toString();
    }

    protected s(e eVar) {
        for (int i10 = 0; i10 != eVar.c(); i10++) {
            this.f421a.addElement(eVar.b(i10));
        }
    }
}
