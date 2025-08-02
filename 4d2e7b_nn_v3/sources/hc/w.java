package hc;

import java.io.IOException;

public abstract class w extends r implements d, p1 {

    /* renamed from: a  reason: collision with root package name */
    int f437a;

    /* renamed from: b  reason: collision with root package name */
    boolean f438b = false;

    /* renamed from: c  reason: collision with root package name */
    boolean f439c;

    /* renamed from: d  reason: collision with root package name */
    d f440d = null;

    public w(boolean z10, int i10, d dVar) {
        this.f439c = z10;
        this.f437a = i10;
        if (z10) {
            this.f440d = dVar;
            return;
        }
        boolean z11 = dVar.c() instanceof u;
        this.f440d = dVar;
    }

    public static w o(Object obj) {
        if (obj == null || (obj instanceof w)) {
            return (w) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return o(r.k((byte[]) obj));
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct tagged object from byte[]: " + e10.getMessage());
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
    }

    public r d() {
        return c();
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof w)) {
            return false;
        }
        w wVar = (w) rVar;
        if (this.f437a != wVar.f437a || this.f438b != wVar.f438b || this.f439c != wVar.f439c) {
            return false;
        }
        d dVar = this.f440d;
        if (dVar == null) {
            if (wVar.f440d != null) {
                return false;
            }
            return true;
        } else if (!dVar.c().equals(wVar.f440d.c())) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        int i10 = this.f437a;
        d dVar = this.f440d;
        if (dVar != null) {
            return i10 ^ dVar.hashCode();
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public r m() {
        return new e1(this.f439c, this.f437a, this.f440d);
    }

    /* access modifiers changed from: package-private */
    public r n() {
        return new n1(this.f439c, this.f437a, this.f440d);
    }

    public r p() {
        d dVar = this.f440d;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public int q() {
        return this.f437a;
    }

    public boolean r() {
        return this.f439c;
    }

    public String toString() {
        return "[" + this.f437a + "]" + this.f440d;
    }
}
