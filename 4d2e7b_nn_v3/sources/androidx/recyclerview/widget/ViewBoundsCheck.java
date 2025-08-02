package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class ViewBoundsCheck {

    /* renamed from: a  reason: collision with root package name */
    final b f16279a;

    /* renamed from: b  reason: collision with root package name */
    a f16280b = new a();

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f16281a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f16282b;

        /* renamed from: c  reason: collision with root package name */
        int f16283c;

        /* renamed from: d  reason: collision with root package name */
        int f16284d;

        /* renamed from: e  reason: collision with root package name */
        int f16285e;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i10) {
            this.f16281a = i10 | this.f16281a;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            int i10 = this.f16281a;
            if ((i10 & 7) != 0 && (i10 & c(this.f16284d, this.f16282b)) == 0) {
                return false;
            }
            int i11 = this.f16281a;
            if ((i11 & 112) != 0 && (i11 & (c(this.f16284d, this.f16283c) << 4)) == 0) {
                return false;
            }
            int i12 = this.f16281a;
            if ((i12 & 1792) != 0 && (i12 & (c(this.f16285e, this.f16282b) << 8)) == 0) {
                return false;
            }
            int i13 = this.f16281a;
            if ((i13 & 28672) == 0 || (i13 & (c(this.f16285e, this.f16283c) << 12)) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public int c(int i10, int i11) {
            if (i10 > i11) {
                return 1;
            }
            return i10 == i11 ? 2 : 4;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f16281a = 0;
        }

        /* access modifiers changed from: package-private */
        public void e(int i10, int i11, int i12, int i13) {
            this.f16282b = i10;
            this.f16283c = i11;
            this.f16284d = i12;
            this.f16285e = i13;
        }
    }

    interface b {
        View a(int i10);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    ViewBoundsCheck(b bVar) {
        this.f16279a = bVar;
    }

    /* access modifiers changed from: package-private */
    public View a(int i10, int i11, int i12, int i13) {
        int i14;
        int c10 = this.f16279a.c();
        int d10 = this.f16279a.d();
        if (i11 > i10) {
            i14 = 1;
        } else {
            i14 = -1;
        }
        View view = null;
        while (i10 != i11) {
            View a10 = this.f16279a.a(i10);
            this.f16280b.e(c10, d10, this.f16279a.b(a10), this.f16279a.e(a10));
            if (i12 != 0) {
                this.f16280b.d();
                this.f16280b.a(i12);
                if (this.f16280b.b()) {
                    return a10;
                }
            }
            if (i13 != 0) {
                this.f16280b.d();
                this.f16280b.a(i13);
                if (this.f16280b.b()) {
                    view = a10;
                }
            }
            i10 += i14;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public boolean b(View view, int i10) {
        this.f16280b.e(this.f16279a.c(), this.f16279a.d(), this.f16279a.b(view), this.f16279a.e(view));
        if (i10 == 0) {
            return false;
        }
        this.f16280b.d();
        this.f16280b.a(i10);
        return this.f16280b.b();
    }
}
