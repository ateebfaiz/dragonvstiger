package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;

class d extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    private static final int[] D = {16842919};
    private static final int[] E = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.OnScrollListener C;

    /* renamed from: a  reason: collision with root package name */
    private final int f16320a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16321b;

    /* renamed from: c  reason: collision with root package name */
    final StateListDrawable f16322c;

    /* renamed from: d  reason: collision with root package name */
    final Drawable f16323d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16324e;

    /* renamed from: f  reason: collision with root package name */
    private final int f16325f;

    /* renamed from: g  reason: collision with root package name */
    private final StateListDrawable f16326g;

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f16327h;

    /* renamed from: i  reason: collision with root package name */
    private final int f16328i;

    /* renamed from: j  reason: collision with root package name */
    private final int f16329j;

    /* renamed from: k  reason: collision with root package name */
    int f16330k;

    /* renamed from: l  reason: collision with root package name */
    int f16331l;

    /* renamed from: m  reason: collision with root package name */
    float f16332m;

    /* renamed from: n  reason: collision with root package name */
    int f16333n;

    /* renamed from: o  reason: collision with root package name */
    int f16334o;

    /* renamed from: p  reason: collision with root package name */
    float f16335p;

    /* renamed from: q  reason: collision with root package name */
    private int f16336q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f16337r = 0;

    /* renamed from: s  reason: collision with root package name */
    private RecyclerView f16338s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f16339t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f16340u = false;

    /* renamed from: v  reason: collision with root package name */
    private int f16341v = 0;

    /* renamed from: w  reason: collision with root package name */
    private int f16342w = 0;

    /* renamed from: x  reason: collision with root package name */
    private final int[] f16343x = new int[2];

    /* renamed from: y  reason: collision with root package name */
    private final int[] f16344y = new int[2];

    /* renamed from: z  reason: collision with root package name */
    final ValueAnimator f16345z;

    class a implements Runnable {
        a() {
        }

        public void run() {
            d.this.f(500);
        }
    }

    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            d.this.p(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    private class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f16348a = false;

        c() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f16348a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f16348a) {
                this.f16348a = false;
            } else if (((Float) d.this.f16345z.getAnimatedValue()).floatValue() == 0.0f) {
                d dVar = d.this;
                dVar.A = 0;
                dVar.n(0);
            } else {
                d dVar2 = d.this;
                dVar2.A = 2;
                dVar2.k();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$d  reason: collision with other inner class name */
    private class C0209d implements ValueAnimator.AnimatorUpdateListener {
        C0209d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.f16322c.setAlpha(floatValue);
            d.this.f16323d.setAlpha(floatValue);
            d.this.k();
        }
    }

    d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f16345z = ofFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f16322c = stateListDrawable;
        this.f16323d = drawable;
        this.f16326g = stateListDrawable2;
        this.f16327h = drawable2;
        this.f16324e = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f16325f = Math.max(i10, drawable.getIntrinsicWidth());
        this.f16328i = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f16329j = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f16320a = i11;
        this.f16321b = i12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new C0209d());
        attachToRecyclerView(recyclerView);
    }

    private void a() {
        this.f16338s.removeCallbacks(this.B);
    }

    private void b(Canvas canvas) {
        int i10 = this.f16337r;
        int i11 = this.f16328i;
        int i12 = i10 - i11;
        int i13 = this.f16334o;
        int i14 = this.f16333n;
        int i15 = i13 - (i14 / 2);
        this.f16326g.setBounds(0, 0, i14, i11);
        this.f16327h.setBounds(0, 0, this.f16336q, this.f16329j);
        canvas.translate(0.0f, (float) i12);
        this.f16327h.draw(canvas);
        canvas.translate((float) i15, 0.0f);
        this.f16326g.draw(canvas);
        canvas.translate((float) (-i15), (float) (-i12));
    }

    private void c(Canvas canvas) {
        int i10 = this.f16336q;
        int i11 = this.f16324e;
        int i12 = i10 - i11;
        int i13 = this.f16331l;
        int i14 = this.f16330k;
        int i15 = i13 - (i14 / 2);
        this.f16322c.setBounds(0, 0, i11, i14);
        this.f16323d.setBounds(0, 0, this.f16325f, this.f16337r);
        if (h()) {
            this.f16323d.draw(canvas);
            canvas.translate((float) this.f16324e, (float) i15);
            canvas.scale(-1.0f, 1.0f);
            this.f16322c.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            canvas.translate((float) (-this.f16324e), (float) (-i15));
            return;
        }
        canvas.translate((float) i12, 0.0f);
        this.f16323d.draw(canvas);
        canvas.translate(0.0f, (float) i15);
        this.f16322c.draw(canvas);
        canvas.translate((float) (-i12), (float) (-i15));
    }

    private int[] d() {
        int[] iArr = this.f16344y;
        int i10 = this.f16321b;
        iArr[0] = i10;
        iArr[1] = this.f16336q - i10;
        return iArr;
    }

    private void destroyCallbacks() {
        this.f16338s.removeItemDecoration(this);
        this.f16338s.removeOnItemTouchListener(this);
        this.f16338s.removeOnScrollListener(this.C);
        a();
    }

    private int[] e() {
        int[] iArr = this.f16343x;
        int i10 = this.f16321b;
        iArr[0] = i10;
        iArr[1] = this.f16337r - i10;
        return iArr;
    }

    private void g(float f10) {
        int[] d10 = d();
        float max = Math.max((float) d10[0], Math.min((float) d10[1], f10));
        if (Math.abs(((float) this.f16334o) - max) >= 2.0f) {
            int m10 = m(this.f16335p, max, d10, this.f16338s.computeHorizontalScrollRange(), this.f16338s.computeHorizontalScrollOffset(), this.f16336q);
            if (m10 != 0) {
                this.f16338s.scrollBy(m10, 0);
            }
            this.f16335p = max;
        }
    }

    private boolean h() {
        if (ViewCompat.getLayoutDirection(this.f16338s) == 1) {
            return true;
        }
        return false;
    }

    private void l(int i10) {
        a();
        this.f16338s.postDelayed(this.B, (long) i10);
    }

    private int m(float f10, float f11, int[] iArr, int i10, int i11, int i12) {
        int i13 = iArr[1] - iArr[0];
        if (i13 == 0) {
            return 0;
        }
        int i14 = i10 - i12;
        int i15 = (int) (((f11 - f10) / ((float) i13)) * ((float) i14));
        int i16 = i11 + i15;
        if (i16 >= i14 || i16 < 0) {
            return 0;
        }
        return i15;
    }

    private void q(float f10) {
        int[] e10 = e();
        float max = Math.max((float) e10[0], Math.min((float) e10[1], f10));
        if (Math.abs(((float) this.f16331l) - max) >= 2.0f) {
            int m10 = m(this.f16332m, max, e10, this.f16338s.computeVerticalScrollRange(), this.f16338s.computeVerticalScrollOffset(), this.f16337r);
            if (m10 != 0) {
                this.f16338s.scrollBy(0, m10);
            }
            this.f16332m = max;
        }
    }

    private void setupCallbacks() {
        this.f16338s.addItemDecoration(this);
        this.f16338s.addOnItemTouchListener(this);
        this.f16338s.addOnScrollListener(this.C);
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f16338s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                destroyCallbacks();
            }
            this.f16338s = recyclerView;
            if (recyclerView != null) {
                setupCallbacks();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(int i10) {
        int i11 = this.A;
        if (i11 == 1) {
            this.f16345z.cancel();
        } else if (i11 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f16345z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
        this.f16345z.setDuration((long) i10);
        this.f16345z.start();
    }

    /* access modifiers changed from: package-private */
    public boolean i(float f10, float f11) {
        if (f11 >= ((float) (this.f16337r - this.f16328i))) {
            int i10 = this.f16334o;
            int i11 = this.f16333n;
            if (f10 < ((float) (i10 - (i11 / 2))) || f10 > ((float) (i10 + (i11 / 2)))) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean j(float f10, float f11) {
        if (!h() ? f10 >= ((float) (this.f16336q - this.f16324e)) : f10 <= ((float) this.f16324e)) {
            int i10 = this.f16331l;
            int i11 = this.f16330k;
            if (f11 < ((float) (i10 - (i11 / 2))) || f11 > ((float) (i10 + (i11 / 2)))) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.f16338s.invalidate();
    }

    /* access modifiers changed from: package-private */
    public void n(int i10) {
        if (i10 == 2 && this.f16341v != 2) {
            this.f16322c.setState(D);
            a();
        }
        if (i10 == 0) {
            k();
        } else {
            o();
        }
        if (this.f16341v == 2 && i10 != 2) {
            this.f16322c.setState(E);
            l(1200);
        } else if (i10 == 1) {
            l(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        this.f16341v = i10;
    }

    public void o() {
        int i10 = this.A;
        if (i10 != 0) {
            if (i10 == 3) {
                this.f16345z.cancel();
            } else {
                return;
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f16345z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.f16345z.setDuration(500);
        this.f16345z.setStartDelay(0);
        this.f16345z.start();
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.f16336q != this.f16338s.getWidth() || this.f16337r != this.f16338s.getHeight()) {
            this.f16336q = this.f16338s.getWidth();
            this.f16337r = this.f16338s.getHeight();
            n(0);
        } else if (this.A != 0) {
            if (this.f16339t) {
                c(canvas);
            }
            if (this.f16340u) {
                b(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i10 = this.f16341v;
        if (i10 == 1) {
            boolean j10 = j(motionEvent.getX(), motionEvent.getY());
            boolean i11 = i(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!j10 && !i11) {
                return false;
            }
            if (i11) {
                this.f16342w = 1;
                this.f16335p = (float) ((int) motionEvent.getX());
            } else if (j10) {
                this.f16342w = 2;
                this.f16332m = (float) ((int) motionEvent.getY());
            }
            n(2);
        } else if (i10 != 2) {
            return false;
        }
        return true;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z10) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f16341v != 0) {
            if (motionEvent.getAction() == 0) {
                boolean j10 = j(motionEvent.getX(), motionEvent.getY());
                boolean i10 = i(motionEvent.getX(), motionEvent.getY());
                if (j10 || i10) {
                    if (i10) {
                        this.f16342w = 1;
                        this.f16335p = (float) ((int) motionEvent.getX());
                    } else if (j10) {
                        this.f16342w = 2;
                        this.f16332m = (float) ((int) motionEvent.getY());
                    }
                    n(2);
                }
            } else if (motionEvent.getAction() == 1 && this.f16341v == 2) {
                this.f16332m = 0.0f;
                this.f16335p = 0.0f;
                n(1);
                this.f16342w = 0;
            } else if (motionEvent.getAction() == 2 && this.f16341v == 2) {
                o();
                if (this.f16342w == 1) {
                    g(motionEvent.getX());
                }
                if (this.f16342w == 2) {
                    q(motionEvent.getY());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void p(int i10, int i11) {
        boolean z10;
        boolean z11;
        int computeVerticalScrollRange = this.f16338s.computeVerticalScrollRange();
        int i12 = this.f16337r;
        if (computeVerticalScrollRange - i12 <= 0 || i12 < this.f16320a) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f16339t = z10;
        int computeHorizontalScrollRange = this.f16338s.computeHorizontalScrollRange();
        int i13 = this.f16336q;
        if (computeHorizontalScrollRange - i13 <= 0 || i13 < this.f16320a) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.f16340u = z11;
        boolean z12 = this.f16339t;
        if (z12 || z11) {
            if (z12) {
                float f10 = (float) i12;
                this.f16331l = (int) ((f10 * (((float) i11) + (f10 / 2.0f))) / ((float) computeVerticalScrollRange));
                this.f16330k = Math.min(i12, (i12 * i12) / computeVerticalScrollRange);
            }
            if (this.f16340u) {
                float f11 = (float) i13;
                this.f16334o = (int) ((f11 * (((float) i10) + (f11 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.f16333n = Math.min(i13, (i13 * i13) / computeHorizontalScrollRange);
            }
            int i14 = this.f16341v;
            if (i14 == 0 || i14 == 1) {
                n(1);
            }
        } else if (this.f16341v != 0) {
            n(0);
        }
    }
}
