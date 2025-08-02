package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private final ViewPager2 f16894a;

    /* renamed from: b  reason: collision with root package name */
    private final e f16895b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f16896c;

    /* renamed from: d  reason: collision with root package name */
    private VelocityTracker f16897d;

    /* renamed from: e  reason: collision with root package name */
    private int f16898e;

    /* renamed from: f  reason: collision with root package name */
    private float f16899f;

    /* renamed from: g  reason: collision with root package name */
    private int f16900g;

    /* renamed from: h  reason: collision with root package name */
    private long f16901h;

    c(ViewPager2 viewPager2, e eVar, RecyclerView recyclerView) {
        this.f16894a = viewPager2;
        this.f16895b = eVar;
        this.f16896c = recyclerView;
    }

    private void a(long j10, int i10, float f10, float f11) {
        MotionEvent obtain = MotionEvent.obtain(this.f16901h, j10, i10, f10, f11, 0);
        this.f16897d.addMovement(obtain);
        obtain.recycle();
    }

    private void c() {
        VelocityTracker velocityTracker = this.f16897d;
        if (velocityTracker == null) {
            this.f16897d = VelocityTracker.obtain();
            this.f16898e = ViewConfiguration.get(this.f16894a.getContext()).getScaledMaximumFlingVelocity();
            return;
        }
        velocityTracker.clear();
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        if (this.f16895b.g()) {
            return false;
        }
        this.f16900g = 0;
        this.f16899f = (float) 0;
        this.f16901h = SystemClock.uptimeMillis();
        c();
        this.f16895b.k();
        if (!this.f16895b.i()) {
            this.f16896c.stopScroll();
        }
        a(this.f16901h, 0, 0.0f, 0.0f);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        if (!this.f16895b.h()) {
            return false;
        }
        this.f16895b.m();
        VelocityTracker velocityTracker = this.f16897d;
        velocityTracker.computeCurrentVelocity(1000, (float) this.f16898e);
        if (this.f16896c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.f16894a.snapToPage();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean e(float f10) {
        boolean z10;
        int i10;
        float f11;
        int i11 = 0;
        if (!this.f16895b.h()) {
            return false;
        }
        float f12 = this.f16899f - f10;
        this.f16899f = f12;
        int round = Math.round(f12 - ((float) this.f16900g));
        this.f16900g += round;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f16894a.getOrientation() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i10 = round;
        } else {
            i10 = 0;
        }
        if (!z10) {
            i11 = round;
        }
        float f13 = 0.0f;
        if (z10) {
            f11 = this.f16899f;
        } else {
            f11 = 0.0f;
        }
        if (!z10) {
            f13 = this.f16899f;
        }
        float f14 = f13;
        this.f16896c.scrollBy(i10, i11);
        a(uptimeMillis, 2, f11, f14);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.f16895b.h();
    }
}
