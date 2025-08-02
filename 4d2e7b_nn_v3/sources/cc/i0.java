package cc;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.m;

public class i0 {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f76b = AtomicIntegerFieldUpdater.newUpdater(i0.class, "_size");
    private volatile int _size;

    /* renamed from: a  reason: collision with root package name */
    private j0[] f77a;

    private final j0[] f() {
        j0[] j0VarArr = this.f77a;
        if (j0VarArr == null) {
            j0[] j0VarArr2 = new j0[4];
            this.f77a = j0VarArr2;
            return j0VarArr2;
        } else if (c() < j0VarArr.length) {
            return j0VarArr;
        } else {
            Object[] copyOf = Arrays.copyOf(j0VarArr, c() * 2);
            m.e(copyOf, "copyOf(this, newSize)");
            j0[] j0VarArr3 = (j0[]) copyOf;
            this.f77a = j0VarArr3;
            return j0VarArr3;
        }
    }

    private final void j(int i10) {
        f76b.set(this, i10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        if (((java.lang.Comparable) r3).compareTo(r4) < 0) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void k(int r6) {
        /*
            r5 = this;
        L_0x0000:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.c()
            if (r1 < r2) goto L_0x000b
            return
        L_0x000b:
            cc.j0[] r2 = r5.f77a
            kotlin.jvm.internal.m.c(r2)
            int r0 = r0 + 2
            int r3 = r5.c()
            if (r0 >= r3) goto L_0x002b
            r3 = r2[r0]
            kotlin.jvm.internal.m.c(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            kotlin.jvm.internal.m.c(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r0 = r1
        L_0x002c:
            r1 = r2[r6]
            kotlin.jvm.internal.m.c(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            kotlin.jvm.internal.m.c(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L_0x003f
            return
        L_0x003f:
            r5.m(r6, r0)
            r6 = r0
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.i0.k(int):void");
    }

    private final void l(int i10) {
        while (i10 > 0) {
            j0[] j0VarArr = this.f77a;
            m.c(j0VarArr);
            int i11 = (i10 - 1) / 2;
            j0 j0Var = j0VarArr[i11];
            m.c(j0Var);
            j0 j0Var2 = j0VarArr[i10];
            m.c(j0Var2);
            if (((Comparable) j0Var).compareTo(j0Var2) > 0) {
                m(i10, i11);
                i10 = i11;
            } else {
                return;
            }
        }
    }

    private final void m(int i10, int i11) {
        j0[] j0VarArr = this.f77a;
        m.c(j0VarArr);
        j0 j0Var = j0VarArr[i11];
        m.c(j0Var);
        j0 j0Var2 = j0VarArr[i10];
        m.c(j0Var2);
        j0VarArr[i10] = j0Var;
        j0VarArr[i11] = j0Var2;
        j0Var.d(i10);
        j0Var2.d(i11);
    }

    public final void a(j0 j0Var) {
        j0Var.c(this);
        j0[] f10 = f();
        int c10 = c();
        j(c10 + 1);
        f10[c10] = j0Var;
        j0Var.d(c10);
        l(c10);
    }

    public final j0 b() {
        j0[] j0VarArr = this.f77a;
        if (j0VarArr != null) {
            return j0VarArr[0];
        }
        return null;
    }

    public final int c() {
        return f76b.get(this);
    }

    public final boolean d() {
        if (c() == 0) {
            return true;
        }
        return false;
    }

    public final j0 e() {
        j0 b10;
        synchronized (this) {
            b10 = b();
        }
        return b10;
    }

    public final boolean g(j0 j0Var) {
        boolean z10;
        synchronized (this) {
            if (j0Var.a() == null) {
                z10 = false;
            } else {
                h(j0Var.getIndex());
                z10 = true;
            }
        }
        return z10;
    }

    public final j0 h(int i10) {
        j0[] j0VarArr = this.f77a;
        m.c(j0VarArr);
        j(c() - 1);
        if (i10 < c()) {
            m(i10, c());
            int i11 = (i10 - 1) / 2;
            if (i10 > 0) {
                j0 j0Var = j0VarArr[i10];
                m.c(j0Var);
                j0 j0Var2 = j0VarArr[i11];
                m.c(j0Var2);
                if (((Comparable) j0Var).compareTo(j0Var2) < 0) {
                    m(i10, i11);
                    l(i11);
                }
            }
            k(i10);
        }
        j0 j0Var3 = j0VarArr[c()];
        m.c(j0Var3);
        j0Var3.c((i0) null);
        j0Var3.d(-1);
        j0VarArr[c()] = null;
        return j0Var3;
    }

    public final j0 i() {
        j0 j0Var;
        synchronized (this) {
            if (c() > 0) {
                j0Var = h(0);
            } else {
                j0Var = null;
            }
        }
        return j0Var;
    }
}
