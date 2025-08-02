package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import java.util.ArrayList;
import java.util.List;

final class a implements j.a {

    /* renamed from: a  reason: collision with root package name */
    private Pools.Pool f16292a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList f16293b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList f16294c;

    /* renamed from: d  reason: collision with root package name */
    final C0207a f16295d;

    /* renamed from: e  reason: collision with root package name */
    Runnable f16296e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f16297f;

    /* renamed from: g  reason: collision with root package name */
    final j f16298g;

    /* renamed from: h  reason: collision with root package name */
    private int f16299h;

    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    interface C0207a {
        void a(int i10, int i11);

        void b(b bVar);

        void c(int i10, int i11, Object obj);

        void d(b bVar);

        RecyclerView.ViewHolder e(int i10);

        void f(int i10, int i11);

        void g(int i10, int i11);

        void h(int i10, int i11);
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f16300a;

        /* renamed from: b  reason: collision with root package name */
        int f16301b;

        /* renamed from: c  reason: collision with root package name */
        Object f16302c;

        /* renamed from: d  reason: collision with root package name */
        int f16303d;

        b(int i10, int i11, int i12, Object obj) {
            this.f16300a = i10;
            this.f16301b = i11;
            this.f16303d = i12;
            this.f16302c = obj;
        }

        /* access modifiers changed from: package-private */
        public String a() {
            int i10 = this.f16300a;
            if (i10 == 1) {
                return "add";
            }
            if (i10 == 2) {
                return "rm";
            }
            if (i10 == 4) {
                return "up";
            }
            if (i10 != 8) {
                return "??";
            }
            return "mv";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i10 = this.f16300a;
            if (i10 != bVar.f16300a) {
                return false;
            }
            if (i10 == 8 && Math.abs(this.f16303d - this.f16301b) == 1 && this.f16303d == bVar.f16301b && this.f16301b == bVar.f16303d) {
                return true;
            }
            if (this.f16303d != bVar.f16303d || this.f16301b != bVar.f16301b) {
                return false;
            }
            Object obj2 = this.f16302c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f16302c)) {
                    return false;
                }
            } else if (bVar.f16302c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f16300a * 31) + this.f16301b) * 31) + this.f16303d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f16301b + "c:" + this.f16303d + ",p:" + this.f16302c + "]";
        }
    }

    a(C0207a aVar) {
        this(aVar, false);
    }

    private void c(b bVar) {
        v(bVar);
    }

    private void d(b bVar) {
        v(bVar);
    }

    private void f(b bVar) {
        char c10;
        boolean z10;
        boolean z11;
        int i10 = bVar.f16301b;
        int i11 = bVar.f16303d + i10;
        char c11 = 65535;
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            if (this.f16295d.e(i12) != null || h(i12)) {
                if (c11 == 0) {
                    k(b(2, i10, i13, (Object) null));
                    z11 = true;
                } else {
                    z11 = false;
                }
                c10 = 1;
            } else {
                if (c11 == 1) {
                    v(b(2, i10, i13, (Object) null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 0;
            }
            if (z10) {
                i12 -= i13;
                i11 -= i13;
                i13 = 1;
            } else {
                i13++;
            }
            i12++;
            c11 = c10;
        }
        if (i13 != bVar.f16303d) {
            a(bVar);
            bVar = b(2, i10, i13, (Object) null);
        }
        if (c11 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private void g(b bVar) {
        int i10 = bVar.f16301b;
        int i11 = bVar.f16303d + i10;
        int i12 = 0;
        boolean z10 = true;
        int i13 = i10;
        while (i10 < i11) {
            if (this.f16295d.e(i10) != null || h(i10)) {
                if (!z10) {
                    k(b(4, i13, i12, bVar.f16302c));
                    i13 = i10;
                    i12 = 0;
                }
                z10 = true;
            } else {
                if (z10) {
                    v(b(4, i13, i12, bVar.f16302c));
                    i13 = i10;
                    i12 = 0;
                }
                z10 = false;
            }
            i12++;
            i10++;
        }
        if (i12 != bVar.f16303d) {
            Object obj = bVar.f16302c;
            a(bVar);
            bVar = b(4, i13, i12, obj);
        }
        if (!z10) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private boolean h(int i10) {
        int size = this.f16294c.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f16294c.get(i11);
            int i12 = bVar.f16300a;
            if (i12 == 8) {
                if (n(bVar.f16303d, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = bVar.f16301b;
                int i14 = bVar.f16303d + i13;
                while (i13 < i14) {
                    if (n(i13, i11 + 1) == i10) {
                        return true;
                    }
                    i13++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i10;
        int i11 = bVar.f16300a;
        if (i11 == 1 || i11 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int z10 = z(bVar.f16301b, i11);
        int i12 = bVar.f16301b;
        int i13 = bVar.f16300a;
        if (i13 == 2) {
            i10 = 0;
        } else if (i13 == 4) {
            i10 = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i14 = 1;
        for (int i15 = 1; i15 < bVar.f16303d; i15++) {
            int z11 = z(bVar.f16301b + (i10 * i15), bVar.f16300a);
            int i16 = bVar.f16300a;
            if (i16 == 2 ? z11 != z10 : !(i16 == 4 && z11 == z10 + 1)) {
                b b10 = b(i16, z10, i14, bVar.f16302c);
                l(b10, i12);
                a(b10);
                if (bVar.f16300a == 4) {
                    i12 += i14;
                }
                i14 = 1;
                z10 = z11;
            } else {
                i14++;
            }
        }
        Object obj = bVar.f16302c;
        a(bVar);
        if (i14 > 0) {
            b b11 = b(bVar.f16300a, z10, i14, obj);
            l(b11, i12);
            a(b11);
        }
    }

    private void v(b bVar) {
        this.f16294c.add(bVar);
        int i10 = bVar.f16300a;
        if (i10 == 1) {
            this.f16295d.g(bVar.f16301b, bVar.f16303d);
        } else if (i10 == 2) {
            this.f16295d.f(bVar.f16301b, bVar.f16303d);
        } else if (i10 == 4) {
            this.f16295d.c(bVar.f16301b, bVar.f16303d, bVar.f16302c);
        } else if (i10 == 8) {
            this.f16295d.a(bVar.f16301b, bVar.f16303d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int z(int i10, int i11) {
        int i12;
        int i13;
        for (int size = this.f16294c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f16294c.get(size);
            int i14 = bVar.f16300a;
            if (i14 == 8) {
                int i15 = bVar.f16301b;
                int i16 = bVar.f16303d;
                if (i15 < i16) {
                    i13 = i15;
                    i12 = i16;
                } else {
                    i12 = i15;
                    i13 = i16;
                }
                if (i10 < i13 || i10 > i12) {
                    if (i10 < i15) {
                        if (i11 == 1) {
                            bVar.f16301b = i15 + 1;
                            bVar.f16303d = i16 + 1;
                        } else if (i11 == 2) {
                            bVar.f16301b = i15 - 1;
                            bVar.f16303d = i16 - 1;
                        }
                    }
                } else if (i13 == i15) {
                    if (i11 == 1) {
                        bVar.f16303d = i16 + 1;
                    } else if (i11 == 2) {
                        bVar.f16303d = i16 - 1;
                    }
                    i10++;
                } else {
                    if (i11 == 1) {
                        bVar.f16301b = i15 + 1;
                    } else if (i11 == 2) {
                        bVar.f16301b = i15 - 1;
                    }
                    i10--;
                }
            } else {
                int i17 = bVar.f16301b;
                if (i17 <= i10) {
                    if (i14 == 1) {
                        i10 -= bVar.f16303d;
                    } else if (i14 == 2) {
                        i10 += bVar.f16303d;
                    }
                } else if (i11 == 1) {
                    bVar.f16301b = i17 + 1;
                } else if (i11 == 2) {
                    bVar.f16301b = i17 - 1;
                }
            }
        }
        for (int size2 = this.f16294c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f16294c.get(size2);
            if (bVar2.f16300a == 8) {
                int i18 = bVar2.f16303d;
                if (i18 == bVar2.f16301b || i18 < 0) {
                    this.f16294c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f16303d <= 0) {
                this.f16294c.remove(size2);
                a(bVar2);
            }
        }
        return i10;
    }

    public void a(b bVar) {
        if (!this.f16297f) {
            bVar.f16302c = null;
            this.f16292a.release(bVar);
        }
    }

    public b b(int i10, int i11, int i12, Object obj) {
        b bVar = (b) this.f16292a.acquire();
        if (bVar == null) {
            return new b(i10, i11, i12, obj);
        }
        bVar.f16300a = i10;
        bVar.f16301b = i11;
        bVar.f16303d = i12;
        bVar.f16302c = obj;
        return bVar;
    }

    public int e(int i10) {
        int size = this.f16293b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f16293b.get(i11);
            int i12 = bVar.f16300a;
            if (i12 != 1) {
                if (i12 == 2) {
                    int i13 = bVar.f16301b;
                    if (i13 <= i10) {
                        int i14 = bVar.f16303d;
                        if (i13 + i14 > i10) {
                            return -1;
                        }
                        i10 -= i14;
                    } else {
                        continue;
                    }
                } else if (i12 == 8) {
                    int i15 = bVar.f16301b;
                    if (i15 == i10) {
                        i10 = bVar.f16303d;
                    } else {
                        if (i15 < i10) {
                            i10--;
                        }
                        if (bVar.f16303d <= i10) {
                            i10++;
                        }
                    }
                }
            } else if (bVar.f16301b <= i10) {
                i10 += bVar.f16303d;
            }
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        int size = this.f16294c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f16295d.d((b) this.f16294c.get(i10));
        }
        x(this.f16294c);
        this.f16299h = 0;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        i();
        int size = this.f16293b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = (b) this.f16293b.get(i10);
            int i11 = bVar.f16300a;
            if (i11 == 1) {
                this.f16295d.d(bVar);
                this.f16295d.g(bVar.f16301b, bVar.f16303d);
            } else if (i11 == 2) {
                this.f16295d.d(bVar);
                this.f16295d.h(bVar.f16301b, bVar.f16303d);
            } else if (i11 == 4) {
                this.f16295d.d(bVar);
                this.f16295d.c(bVar.f16301b, bVar.f16303d, bVar.f16302c);
            } else if (i11 == 8) {
                this.f16295d.d(bVar);
                this.f16295d.a(bVar.f16301b, bVar.f16303d);
            }
            Runnable runnable = this.f16296e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f16293b);
        this.f16299h = 0;
    }

    /* access modifiers changed from: package-private */
    public void l(b bVar, int i10) {
        this.f16295d.b(bVar);
        int i11 = bVar.f16300a;
        if (i11 == 2) {
            this.f16295d.h(i10, bVar.f16303d);
        } else if (i11 == 4) {
            this.f16295d.c(i10, bVar.f16303d, bVar.f16302c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* access modifiers changed from: package-private */
    public int m(int i10) {
        return n(i10, 0);
    }

    /* access modifiers changed from: package-private */
    public int n(int i10, int i11) {
        int size = this.f16294c.size();
        while (i11 < size) {
            b bVar = (b) this.f16294c.get(i11);
            int i12 = bVar.f16300a;
            if (i12 == 8) {
                int i13 = bVar.f16301b;
                if (i13 == i10) {
                    i10 = bVar.f16303d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (bVar.f16303d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = bVar.f16301b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = bVar.f16303d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += bVar.f16303d;
                }
            }
            i11++;
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public boolean o(int i10) {
        if ((i10 & this.f16299h) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        if (this.f16293b.size() > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        if (this.f16294c.isEmpty() || this.f16293b.isEmpty()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean r(int i10, int i11, Object obj) {
        if (i11 < 1) {
            return false;
        }
        this.f16293b.add(b(4, i10, i11, obj));
        this.f16299h |= 4;
        if (this.f16293b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean s(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f16293b.add(b(1, i10, i11, (Object) null));
        this.f16299h |= 1;
        if (this.f16293b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean t(int i10, int i11, int i12) {
        if (i10 == i11) {
            return false;
        }
        if (i12 == 1) {
            this.f16293b.add(b(8, i10, i11, (Object) null));
            this.f16299h |= 8;
            if (this.f16293b.size() == 1) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* access modifiers changed from: package-private */
    public boolean u(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f16293b.add(b(2, i10, i11, (Object) null));
        this.f16299h |= 2;
        if (this.f16293b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void w() {
        this.f16298g.b(this.f16293b);
        int size = this.f16293b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = (b) this.f16293b.get(i10);
            int i11 = bVar.f16300a;
            if (i11 == 1) {
                c(bVar);
            } else if (i11 == 2) {
                f(bVar);
            } else if (i11 == 4) {
                g(bVar);
            } else if (i11 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f16296e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f16293b.clear();
    }

    /* access modifiers changed from: package-private */
    public void x(List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a((b) list.get(i10));
        }
        list.clear();
    }

    /* access modifiers changed from: package-private */
    public void y() {
        x(this.f16293b);
        x(this.f16294c);
        this.f16299h = 0;
    }

    a(C0207a aVar, boolean z10) {
        this.f16292a = new Pools.SimplePool(30);
        this.f16293b = new ArrayList();
        this.f16294c = new ArrayList();
        this.f16299h = 0;
        this.f16295d = aVar;
        this.f16297f = z10;
        this.f16298g = new j(this);
    }
}
