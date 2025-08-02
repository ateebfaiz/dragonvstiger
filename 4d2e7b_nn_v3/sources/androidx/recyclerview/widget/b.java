package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class b {

    /* renamed from: a  reason: collision with root package name */
    final C0208b f16304a;

    /* renamed from: b  reason: collision with root package name */
    final a f16305b = new a();

    /* renamed from: c  reason: collision with root package name */
    final List f16306c = new ArrayList();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        long f16307a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f16308b;

        a() {
        }

        private void c() {
            if (this.f16308b == null) {
                this.f16308b = new a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i10) {
            if (i10 >= 64) {
                a aVar = this.f16308b;
                if (aVar != null) {
                    aVar.a(i10 - 64);
                    return;
                }
                return;
            }
            this.f16307a &= ~(1 << i10);
        }

        /* access modifiers changed from: package-private */
        public int b(int i10) {
            a aVar = this.f16308b;
            if (aVar == null) {
                if (i10 >= 64) {
                    return Long.bitCount(this.f16307a);
                }
                return Long.bitCount(this.f16307a & ((1 << i10) - 1));
            } else if (i10 < 64) {
                return Long.bitCount(this.f16307a & ((1 << i10) - 1));
            } else {
                return aVar.b(i10 - 64) + Long.bitCount(this.f16307a);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i10) {
            if (i10 >= 64) {
                c();
                return this.f16308b.d(i10 - 64);
            } else if ((this.f16307a & (1 << i10)) != 0) {
                return true;
            } else {
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public void e(int i10, boolean z10) {
            boolean z11;
            if (i10 >= 64) {
                c();
                this.f16308b.e(i10 - 64, z10);
                return;
            }
            long j10 = this.f16307a;
            if ((Long.MIN_VALUE & j10) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            long j11 = (1 << i10) - 1;
            this.f16307a = ((j10 & (~j11)) << 1) | (j10 & j11);
            if (z10) {
                h(i10);
            } else {
                a(i10);
            }
            if (z11 || this.f16308b != null) {
                c();
                this.f16308b.e(0, z11);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean f(int i10) {
            boolean z10;
            if (i10 >= 64) {
                c();
                return this.f16308b.f(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.f16307a;
            if ((j11 & j10) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            long j12 = j11 & (~j10);
            this.f16307a = j12;
            long j13 = j10 - 1;
            this.f16307a = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
            a aVar = this.f16308b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f16308b.f(0);
            }
            return z10;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            this.f16307a = 0;
            a aVar = this.f16308b;
            if (aVar != null) {
                aVar.g();
            }
        }

        /* access modifiers changed from: package-private */
        public void h(int i10) {
            if (i10 >= 64) {
                c();
                this.f16308b.h(i10 - 64);
                return;
            }
            this.f16307a |= 1 << i10;
        }

        public String toString() {
            if (this.f16308b == null) {
                return Long.toBinaryString(this.f16307a);
            }
            return this.f16308b.toString() + "xx" + Long.toBinaryString(this.f16307a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.b$b  reason: collision with other inner class name */
    interface C0208b {
        View a(int i10);

        int b();

        void c(View view);

        void d();

        int e(View view);

        RecyclerView.ViewHolder f(View view);

        void g(int i10);

        void h(View view);

        void i(View view, int i10);

        void j(int i10);

        void k(View view, int i10, ViewGroup.LayoutParams layoutParams);
    }

    b(C0208b bVar) {
        this.f16304a = bVar;
    }

    private int h(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int b10 = this.f16304a.b();
        int i11 = i10;
        while (i11 < b10) {
            int b11 = i10 - (i11 - this.f16305b.b(i11));
            if (b11 == 0) {
                while (this.f16305b.d(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += b11;
        }
        return -1;
    }

    private void l(View view) {
        this.f16306c.add(view);
        this.f16304a.c(view);
    }

    private boolean t(View view) {
        if (!this.f16306c.remove(view)) {
            return false;
        }
        this.f16304a.h(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i10, boolean z10) {
        int i11;
        if (i10 < 0) {
            i11 = this.f16304a.b();
        } else {
            i11 = h(i10);
        }
        this.f16305b.e(i11, z10);
        if (z10) {
            l(view);
        }
        this.f16304a.i(view, i11);
    }

    /* access modifiers changed from: package-private */
    public void b(View view, boolean z10) {
        a(view, -1, z10);
    }

    /* access modifiers changed from: package-private */
    public void c(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int i11;
        if (i10 < 0) {
            i11 = this.f16304a.b();
        } else {
            i11 = h(i10);
        }
        this.f16305b.e(i11, z10);
        if (z10) {
            l(view);
        }
        this.f16304a.k(view, i11, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void d(int i10) {
        int h10 = h(i10);
        this.f16305b.f(h10);
        this.f16304a.g(h10);
    }

    /* access modifiers changed from: package-private */
    public View e(int i10) {
        int size = this.f16306c.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = (View) this.f16306c.get(i11);
            RecyclerView.ViewHolder f10 = this.f16304a.f(view);
            if (f10.getLayoutPosition() == i10 && !f10.isInvalid() && !f10.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View f(int i10) {
        return this.f16304a.a(h(i10));
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f16304a.b() - this.f16306c.size();
    }

    /* access modifiers changed from: package-private */
    public View i(int i10) {
        return this.f16304a.a(i10);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f16304a.b();
    }

    /* access modifiers changed from: package-private */
    public void k(View view) {
        int e10 = this.f16304a.e(view);
        if (e10 >= 0) {
            this.f16305b.h(e10);
            l(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* access modifiers changed from: package-private */
    public int m(View view) {
        int e10 = this.f16304a.e(view);
        if (e10 != -1 && !this.f16305b.d(e10)) {
            return e10 - this.f16305b.b(e10);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean n(View view) {
        return this.f16306c.contains(view);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.f16305b.g();
        for (int size = this.f16306c.size() - 1; size >= 0; size--) {
            this.f16304a.h((View) this.f16306c.get(size));
            this.f16306c.remove(size);
        }
        this.f16304a.d();
    }

    /* access modifiers changed from: package-private */
    public void p(View view) {
        int e10 = this.f16304a.e(view);
        if (e10 >= 0) {
            if (this.f16305b.f(e10)) {
                t(view);
            }
            this.f16304a.j(e10);
        }
    }

    /* access modifiers changed from: package-private */
    public void q(int i10) {
        int h10 = h(i10);
        View a10 = this.f16304a.a(h10);
        if (a10 != null) {
            if (this.f16305b.f(h10)) {
                t(a10);
            }
            this.f16304a.j(h10);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean r(View view) {
        int e10 = this.f16304a.e(view);
        if (e10 == -1) {
            t(view);
            return true;
        } else if (!this.f16305b.d(e10)) {
            return false;
        } else {
            this.f16305b.f(e10);
            t(view);
            this.f16304a.j(e10);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void s(View view) {
        int e10 = this.f16304a.e(view);
        if (e10 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f16305b.d(e10)) {
            this.f16305b.a(e10);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f16305b.toString() + ", hidden list:" + this.f16306c.size();
    }
}
