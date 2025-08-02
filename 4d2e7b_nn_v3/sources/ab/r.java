package ab;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class r extends d {

    /* renamed from: q0  reason: collision with root package name */
    public static final a f2420q0 = new a((DefaultConstructorMarker) null);
    private float N;
    private float O;
    private final float P;
    private float Q = Float.MIN_VALUE;
    private float R = Float.MAX_VALUE;
    private float S = Float.MIN_VALUE;
    private float T = Float.MIN_VALUE;
    private float U = Float.MAX_VALUE;
    private float V = Float.MAX_VALUE;
    private float W = Float.MIN_VALUE;
    private float X = Float.MIN_VALUE;
    private float Y = Float.MAX_VALUE;
    private float Z = Float.MAX_VALUE;

    /* renamed from: a0  reason: collision with root package name */
    private float f2421a0 = Float.MAX_VALUE;

    /* renamed from: b0  reason: collision with root package name */
    private float f2422b0 = Float.MAX_VALUE;

    /* renamed from: c0  reason: collision with root package name */
    private int f2423c0 = 1;

    /* renamed from: d0  reason: collision with root package name */
    private int f2424d0 = 10;

    /* renamed from: e0  reason: collision with root package name */
    private float f2425e0;

    /* renamed from: f0  reason: collision with root package name */
    private float f2426f0;

    /* renamed from: g0  reason: collision with root package name */
    private float f2427g0;

    /* renamed from: h0  reason: collision with root package name */
    private float f2428h0;

    /* renamed from: i0  reason: collision with root package name */
    private float f2429i0;

    /* renamed from: j0  reason: collision with root package name */
    private float f2430j0;

    /* renamed from: k0  reason: collision with root package name */
    private VelocityTracker f2431k0;

    /* renamed from: l0  reason: collision with root package name */
    private boolean f2432l0;

    /* renamed from: m0  reason: collision with root package name */
    private long f2433m0;

    /* renamed from: n0  reason: collision with root package name */
    private final Runnable f2434n0 = new q(this);

    /* renamed from: o0  reason: collision with root package name */
    private Handler f2435o0;

    /* renamed from: p0  reason: collision with root package name */
    private y f2436p0 = new y(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 31, (DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final void b(VelocityTracker velocityTracker, MotionEvent motionEvent) {
            float rawX = motionEvent.getRawX() - motionEvent.getX();
            float rawY = motionEvent.getRawY() - motionEvent.getY();
            motionEvent.offsetLocation(rawX, rawY);
            m.c(velocityTracker);
            velocityTracker.addMovement(motionEvent);
            motionEvent.offsetLocation(-rawX, -rawY);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public r(Context context) {
        m.c(context);
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        float f10 = (float) (scaledTouchSlop * scaledTouchSlop);
        this.P = f10;
        this.Q = f10;
    }

    /* access modifiers changed from: private */
    public static final void T0(r rVar) {
        m.f(rVar, "this$0");
        rVar.i();
    }

    private final boolean p1() {
        float f10 = (this.f2429i0 - this.f2425e0) + this.f2427g0;
        float f11 = this.R;
        if (f11 != Float.MAX_VALUE && f10 < f11) {
            return true;
        }
        float f12 = this.S;
        if (f12 != Float.MIN_VALUE && f10 > f12) {
            return true;
        }
        float f13 = (this.f2430j0 - this.f2426f0) + this.f2428h0;
        float f14 = this.V;
        if (f14 != Float.MAX_VALUE && f13 < f14) {
            return true;
        }
        float f15 = this.W;
        if (f15 != Float.MIN_VALUE && f13 > f15) {
            return true;
        }
        float f16 = (f10 * f10) + (f13 * f13);
        float f17 = this.Q;
        if (f17 != Float.MAX_VALUE && f16 >= f17) {
            return true;
        }
        float f18 = this.N;
        float f19 = this.Z;
        if (f19 != Float.MAX_VALUE && ((f19 < 0.0f && f18 <= f19) || (0.0f <= f19 && f19 <= f18))) {
            return true;
        }
        float f20 = this.O;
        float f21 = this.f2421a0;
        if (f21 != Float.MAX_VALUE && ((f21 < 0.0f && f18 <= f21) || (0.0f <= f21 && f21 <= f18))) {
            return true;
        }
        float f22 = (f18 * f18) + (f20 * f20);
        float f23 = this.f2422b0;
        if (f23 != Float.MAX_VALUE && f22 >= f23) {
            return true;
        }
        return false;
    }

    private final boolean q1() {
        float f10 = (this.f2429i0 - this.f2425e0) + this.f2427g0;
        float f11 = (this.f2430j0 - this.f2426f0) + this.f2428h0;
        if (this.f2433m0 <= 0 || (f10 * f10) + (f11 * f11) <= this.P) {
            float f12 = this.T;
            if (f12 != Float.MIN_VALUE && f10 < f12) {
                return true;
            }
            float f13 = this.U;
            if (f13 != Float.MAX_VALUE && f10 > f13) {
                return true;
            }
            float f14 = this.X;
            if (f14 != Float.MIN_VALUE && f11 < f14) {
                return true;
            }
            float f15 = this.Y;
            if (f15 != Float.MAX_VALUE && f11 > f15) {
                return true;
            }
            return false;
        }
        Handler handler = this.f2435o0;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        return true;
    }

    public final y U0() {
        return this.f2436p0;
    }

    public final float V0() {
        return (this.f2429i0 - this.f2425e0) + this.f2427g0;
    }

    public final float W0() {
        return (this.f2430j0 - this.f2426f0) + this.f2428h0;
    }

    public final float X0() {
        return this.N;
    }

    public final float Y0() {
        return this.O;
    }

    public final r Z0(long j10) {
        this.f2433m0 = j10;
        return this;
    }

    public final r a1(float f10) {
        this.S = f10;
        return this;
    }

    public final r b1(float f10) {
        this.R = f10;
        return this;
    }

    public final r c1(float f10) {
        this.W = f10;
        return this;
    }

    public final r d1(float f10) {
        this.V = f10;
        return this;
    }

    public final r e1(boolean z10) {
        this.f2432l0 = z10;
        return this;
    }

    public final r f1(float f10) {
        this.U = f10;
        return this;
    }

    /* access modifiers changed from: protected */
    public void g0() {
        Handler handler = this.f2435o0;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public final r g1(float f10) {
        this.T = f10;
        return this;
    }

    /* access modifiers changed from: protected */
    public void h0(MotionEvent motionEvent, MotionEvent motionEvent2) {
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        m.f(motionEvent2, "sourceEvent");
        if (H0(motionEvent2)) {
            if (motionEvent.getToolType(0) == 2) {
                this.f2436p0 = y.f2480f.a(motionEvent);
            }
            int Q2 = Q();
            int actionMasked = motionEvent2.getActionMasked();
            if (actionMasked == 5 || actionMasked == 6) {
                this.f2427g0 += this.f2429i0 - this.f2425e0;
                this.f2428h0 += this.f2430j0 - this.f2426f0;
                i iVar = i.f2409a;
                this.f2429i0 = iVar.b(motionEvent2, this.f2432l0);
                float c10 = iVar.c(motionEvent2, this.f2432l0);
                this.f2430j0 = c10;
                this.f2425e0 = this.f2429i0;
                this.f2426f0 = c10;
            } else {
                i iVar2 = i.f2409a;
                this.f2429i0 = iVar2.b(motionEvent2, this.f2432l0);
                this.f2430j0 = iVar2.c(motionEvent2, this.f2432l0);
            }
            if (Q2 != 0 || motionEvent2.getPointerCount() < this.f2423c0) {
                VelocityTracker velocityTracker = this.f2431k0;
                if (velocityTracker != null) {
                    f2420q0.b(velocityTracker, motionEvent2);
                    VelocityTracker velocityTracker2 = this.f2431k0;
                    m.c(velocityTracker2);
                    velocityTracker2.computeCurrentVelocity(1000);
                    VelocityTracker velocityTracker3 = this.f2431k0;
                    m.c(velocityTracker3);
                    this.N = velocityTracker3.getXVelocity();
                    VelocityTracker velocityTracker4 = this.f2431k0;
                    m.c(velocityTracker4);
                    this.O = velocityTracker4.getYVelocity();
                }
            } else {
                p0();
                this.f2427g0 = 0.0f;
                this.f2428h0 = 0.0f;
                this.N = 0.0f;
                this.O = 0.0f;
                VelocityTracker obtain = VelocityTracker.obtain();
                this.f2431k0 = obtain;
                f2420q0.b(obtain, motionEvent2);
                n();
                if (this.f2433m0 > 0) {
                    if (this.f2435o0 == null) {
                        this.f2435o0 = new Handler(Looper.getMainLooper());
                    }
                    Handler handler = this.f2435o0;
                    m.c(handler);
                    handler.postDelayed(this.f2434n0, this.f2433m0);
                }
            }
            if (actionMasked == 1 || actionMasked == 12) {
                if (Q2 == 4) {
                    z();
                } else {
                    B();
                }
            } else if (actionMasked != 5 || motionEvent2.getPointerCount() <= this.f2424d0) {
                if (actionMasked == 6 && Q2 == 4 && motionEvent2.getPointerCount() < this.f2423c0) {
                    B();
                } else if (Q2 != 2) {
                } else {
                    if (q1()) {
                        B();
                    } else if (p1()) {
                        i();
                    }
                }
            } else if (Q2 == 4) {
                o();
            } else {
                B();
            }
        }
    }

    public final r h1(float f10) {
        this.Y = f10;
        return this;
    }

    public final r i1(float f10) {
        this.X = f10;
        return this;
    }

    public void j(boolean z10) {
        if (Q() != 4) {
            p0();
        }
        super.j(z10);
    }

    public final r j1(int i10) {
        this.f2424d0 = i10;
        return this;
    }

    /* access modifiers changed from: protected */
    public void k0() {
        Handler handler = this.f2435o0;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        VelocityTracker velocityTracker = this.f2431k0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2431k0 = null;
        }
        this.f2436p0 = new y(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 31, (DefaultConstructorMarker) null);
    }

    public final r k1(float f10) {
        this.Q = f10 * f10;
        return this;
    }

    public final r l1(int i10) {
        this.f2423c0 = i10;
        return this;
    }

    public final r m1(float f10) {
        this.f2422b0 = f10 * f10;
        return this;
    }

    public final r n1(float f10) {
        this.Z = f10;
        return this;
    }

    public void o0() {
        super.o0();
        this.R = Float.MAX_VALUE;
        this.S = Float.MIN_VALUE;
        this.T = Float.MIN_VALUE;
        this.U = Float.MAX_VALUE;
        this.V = Float.MAX_VALUE;
        this.W = Float.MIN_VALUE;
        this.X = Float.MIN_VALUE;
        this.Y = Float.MAX_VALUE;
        this.Z = Float.MAX_VALUE;
        this.f2421a0 = Float.MAX_VALUE;
        this.f2422b0 = Float.MAX_VALUE;
        this.Q = this.P;
        this.f2423c0 = 1;
        this.f2424d0 = 10;
        this.f2433m0 = 0;
        this.f2432l0 = false;
    }

    public final r o1(float f10) {
        this.f2421a0 = f10;
        return this;
    }

    public void p0() {
        this.f2425e0 = this.f2429i0;
        this.f2426f0 = this.f2430j0;
    }
}
