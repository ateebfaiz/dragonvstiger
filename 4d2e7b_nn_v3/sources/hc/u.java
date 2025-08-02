package hc;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import zd.a;

public abstract class u extends r implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    private Vector f428a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f429b;

    protected u() {
        this.f428a = new Vector();
        this.f429b = false;
    }

    private byte[] o(d dVar) {
        try {
            return dVar.c().f("DER");
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    public static u p(w wVar, boolean z10) {
        if (z10) {
            if (wVar.r()) {
                return (u) wVar.p();
            }
            throw new IllegalArgumentException("object implicit - explicit expected.");
        } else if (wVar.r()) {
            if (wVar instanceof h0) {
                return new f0((d) wVar.p());
            }
            return new m1((d) wVar.p());
        } else if (wVar.p() instanceof u) {
            return (u) wVar.p();
        } else {
            if (wVar.p() instanceof s) {
                s sVar = (s) wVar.p();
                if (wVar instanceof h0) {
                    return new f0(sVar.s());
                }
                return new m1(sVar.s());
            }
            throw new IllegalArgumentException("unknown object in getInstance: " + wVar.getClass().getName());
        }
    }

    private d q(Enumeration enumeration) {
        d dVar = (d) enumeration.nextElement();
        if (dVar == null) {
            return t0.f424a;
        }
        return dVar;
    }

    private boolean t(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        int i10 = 0;
        while (i10 != min) {
            byte b10 = bArr[i10];
            byte b11 = bArr2[i10];
            if (b10 == b11) {
                i10++;
            } else if ((b10 & 255) < (b11 & 255)) {
                return true;
            } else {
                return false;
            }
        }
        if (min == bArr.length) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof u)) {
            return false;
        }
        u uVar = (u) rVar;
        if (size() != uVar.size()) {
            return false;
        }
        Enumeration s10 = s();
        Enumeration s11 = uVar.s();
        while (s10.hasMoreElements()) {
            d q10 = q(s10);
            d q11 = q(s11);
            r c10 = q10.c();
            r c11 = q11.c();
            if (c10 != c11 && !c10.equals(c11)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Enumeration s10 = s();
        int size = size();
        while (s10.hasMoreElements()) {
            size = (size * 17) ^ q(s10).hashCode();
        }
        return size;
    }

    public Iterator iterator() {
        return new a.C0038a(v());
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public r m() {
        if (this.f429b) {
            b1 b1Var = new b1();
            b1Var.f428a = this.f428a;
            return b1Var;
        }
        Vector vector = new Vector();
        for (int i10 = 0; i10 != this.f428a.size(); i10++) {
            vector.addElement(this.f428a.elementAt(i10));
        }
        b1 b1Var2 = new b1();
        b1Var2.f428a = vector;
        b1Var2.u();
        return b1Var2;
    }

    /* access modifiers changed from: package-private */
    public r n() {
        m1 m1Var = new m1();
        m1Var.f428a = this.f428a;
        return m1Var;
    }

    public d r(int i10) {
        return (d) this.f428a.elementAt(i10);
    }

    public Enumeration s() {
        return this.f428a.elements();
    }

    public int size() {
        return this.f428a.size();
    }

    public String toString() {
        return this.f428a.toString();
    }

    /* access modifiers changed from: protected */
    public void u() {
        if (!this.f429b) {
            this.f429b = true;
            if (this.f428a.size() > 1) {
                int size = this.f428a.size() - 1;
                boolean z10 = true;
                while (z10) {
                    int i10 = 0;
                    byte[] o10 = o((d) this.f428a.elementAt(0));
                    z10 = false;
                    int i11 = 0;
                    while (i11 != size) {
                        int i12 = i11 + 1;
                        byte[] o11 = o((d) this.f428a.elementAt(i12));
                        if (t(o10, o11)) {
                            o10 = o11;
                        } else {
                            Object elementAt = this.f428a.elementAt(i11);
                            Vector vector = this.f428a;
                            vector.setElementAt(vector.elementAt(i12), i11);
                            this.f428a.setElementAt(elementAt, i12);
                            z10 = true;
                            i10 = i11;
                        }
                        i11 = i12;
                    }
                    size = i10;
                }
            }
        }
    }

    public d[] v() {
        d[] dVarArr = new d[size()];
        for (int i10 = 0; i10 != size(); i10++) {
            dVarArr[i10] = r(i10);
        }
        return dVarArr;
    }

    protected u(d dVar) {
        Vector vector = new Vector();
        this.f428a = vector;
        this.f429b = false;
        vector.addElement(dVar);
    }

    protected u(e eVar, boolean z10) {
        this.f428a = new Vector();
        this.f429b = false;
        for (int i10 = 0; i10 != eVar.c(); i10++) {
            this.f428a.addElement(eVar.b(i10));
        }
        if (z10) {
            u();
        }
    }

    protected u(d[] dVarArr, boolean z10) {
        this.f428a = new Vector();
        this.f429b = false;
        for (int i10 = 0; i10 != dVarArr.length; i10++) {
            this.f428a.addElement(dVarArr[i10]);
        }
        if (z10) {
            u();
        }
    }
}
