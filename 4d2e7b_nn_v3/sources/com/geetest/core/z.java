package com.geetest.core;

import java.io.IOException;

public abstract class z extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public k0 f6221a;

    /* renamed from: b  reason: collision with root package name */
    public f0 f6222b;

    /* renamed from: c  reason: collision with root package name */
    public p0 f6223c;

    /* renamed from: d  reason: collision with root package name */
    public int f6224d;

    /* renamed from: e  reason: collision with root package name */
    public p0 f6225e;

    public z(s0 s0Var) {
        int i10 = 0;
        p0 a10 = a(s0Var, 0);
        if (a10 instanceof k0) {
            this.f6221a = (k0) a10;
            a10 = a(s0Var, 1);
            i10 = 1;
        }
        if (a10 instanceof f0) {
            this.f6222b = (f0) a10;
            i10++;
            a10 = a(s0Var, i10);
        }
        if (!(a10 instanceof z0)) {
            this.f6223c = a10;
            i10++;
            a10 = a(s0Var, i10);
        }
        if (s0Var.m() != i10 + 1) {
            throw new IllegalArgumentException("input sequence too large");
        } else if (a10 instanceof z0) {
            z0 z0Var = (z0) a10;
            this.f6224d = a(z0Var.k());
            this.f6225e = a(z0Var);
        } else {
            throw new IllegalArgumentException("No tagged object found in sequence. Structure doesn't seem to be of type External");
        }
    }

    public int a(boolean z10) throws IOException {
        return j().a(z10);
    }

    public boolean g() {
        return true;
    }

    public p0 h() {
        return new v1(this.f6221a, this.f6222b, this.f6223c, this.f6224d, this.f6225e);
    }

    public int hashCode() {
        return (((c.a((Object) this.f6221a) ^ c.a((Object) this.f6222b)) ^ c.a((Object) this.f6223c)) ^ this.f6224d) ^ this.f6225e.hashCode();
    }

    public p0 i() {
        return new r2(this.f6221a, this.f6222b, this.f6223c, this.f6224d, this.f6225e);
    }

    public abstract s0 j();

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.b(z10, 40);
        j().a(n0Var, false);
    }

    public boolean a(p0 p0Var) {
        if (this == p0Var) {
            return true;
        }
        if (!(p0Var instanceof z)) {
            return false;
        }
        z zVar = (z) p0Var;
        if (!c.a((Object) this.f6221a, (Object) zVar.f6221a) || !c.a((Object) this.f6222b, (Object) zVar.f6222b) || !c.a((Object) this.f6223c, (Object) zVar.f6223c) || this.f6224d != zVar.f6224d || !this.f6225e.b(zVar.f6225e)) {
            return false;
        }
        return true;
    }

    public static int a(int i10) {
        if (i10 >= 0 && i10 <= 2) {
            return i10;
        }
        throw new IllegalArgumentException("invalid encoding value: " + i10);
    }

    public static p0 a(int i10, p0 p0Var) {
        if (i10 != 1) {
            return i10 != 2 ? p0Var : s.f6167a.a(p0Var);
        }
        return l0.f6064a.a(p0Var);
    }

    public static p0 a(z0 z0Var) {
        c.a(z0Var);
        int i10 = z0Var.f6228c;
        if (i10 != 0) {
            if (i10 == 1) {
                return (l0) l0.f6064a.a(z0Var, false);
            }
            if (i10 == 2) {
                return (s) s.f6167a.a(z0Var, false);
            }
            throw new IllegalArgumentException("invalid tag: " + c.a(z0Var.f6227b, z0Var.f6228c));
        } else if (z0Var.l()) {
            v vVar = z0Var.f6229d;
            return (vVar instanceof i0 ? (i0) vVar : vVar.d()).d();
        } else {
            throw new IllegalStateException("object implicit - explicit expected.");
        }
    }

    public z(k0 k0Var, f0 f0Var, p0 p0Var, int i10, p0 p0Var2) {
        this.f6221a = k0Var;
        this.f6222b = f0Var;
        this.f6223c = p0Var;
        this.f6224d = a(i10);
        this.f6225e = a(i10, p0Var2);
    }

    public static p0 a(s0 s0Var, int i10) {
        if (s0Var.m() > i10) {
            return s0Var.a(i10).d();
        }
        throw new IllegalArgumentException("too few objects in input sequence");
    }
}
