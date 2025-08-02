package ab;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class a0 extends d {

    /* renamed from: e0  reason: collision with root package name */
    public static final a f2336e0 = new a((DefaultConstructorMarker) null);
    private float N = Float.MIN_VALUE;
    private float O = Float.MIN_VALUE;
    private float P = Float.MIN_VALUE;
    private long Q = 500;
    private long R = 200;
    private int S = 1;
    private int T = 1;
    private int U = 1;
    private float V;
    private float W;
    private float X;
    private float Y;
    private float Z;

    /* renamed from: a0  reason: collision with root package name */
    private float f2337a0;

    /* renamed from: b0  reason: collision with root package name */
    private Handler f2338b0;

    /* renamed from: c0  reason: collision with root package name */
    private int f2339c0;

    /* renamed from: d0  reason: collision with root package name */
    private final Runnable f2340d0 = new z(this);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a0() {
        E0(true);
    }

    private final void T0() {
        Handler handler = this.f2338b0;
        if (handler == null) {
            this.f2338b0 = new Handler(Looper.getMainLooper());
        } else {
            m.c(handler);
            handler.removeCallbacksAndMessages((Object) null);
        }
        int i10 = this.f2339c0 + 1;
        this.f2339c0 = i10;
        if (i10 != this.S || this.U < this.T) {
            Handler handler2 = this.f2338b0;
            m.c(handler2);
            handler2.postDelayed(this.f2340d0, this.R);
            return;
        }
        i();
    }

    /* access modifiers changed from: private */
    public static final void U0(a0 a0Var) {
        m.f(a0Var, "this$0");
        a0Var.B();
    }

    private final boolean c1() {
        float f10 = (this.Z - this.V) + this.X;
        if (this.N != Float.MIN_VALUE && Math.abs(f10) > this.N) {
            return true;
        }
        float f11 = (this.f2337a0 - this.W) + this.Y;
        if (this.O != Float.MIN_VALUE && Math.abs(f11) > this.O) {
            return true;
        }
        float f12 = (f11 * f11) + (f10 * f10);
        float f13 = this.P;
        if (f13 != Float.MIN_VALUE && f12 > f13) {
            return true;
        }
        return false;
    }

    private final void d1() {
        Handler handler = this.f2338b0;
        if (handler == null) {
            this.f2338b0 = new Handler(Looper.getMainLooper());
        } else {
            m.c(handler);
            handler.removeCallbacksAndMessages((Object) null);
        }
        Handler handler2 = this.f2338b0;
        m.c(handler2);
        handler2.postDelayed(this.f2340d0, this.Q);
    }

    public final a0 V0(long j10) {
        this.R = j10;
        return this;
    }

    public final a0 W0(float f10) {
        this.P = f10 * f10;
        return this;
    }

    public final a0 X0(long j10) {
        this.Q = j10;
        return this;
    }

    public final a0 Y0(float f10) {
        this.N = f10;
        return this;
    }

    public final a0 Z0(float f10) {
        this.O = f10;
        return this;
    }

    public final a0 a1(int i10) {
        this.T = i10;
        return this;
    }

    public final a0 b1(int i10) {
        this.S = i10;
        return this;
    }

    /* access modifiers changed from: protected */
    public void g0() {
        Handler handler = this.f2338b0;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void h0(MotionEvent motionEvent, MotionEvent motionEvent2) {
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        m.f(motionEvent2, "sourceEvent");
        if (H0(motionEvent2)) {
            int Q2 = Q();
            int actionMasked = motionEvent2.getActionMasked();
            if (Q2 == 0) {
                this.X = 0.0f;
                this.Y = 0.0f;
                i iVar = i.f2409a;
                this.V = iVar.b(motionEvent2, true);
                this.W = iVar.c(motionEvent2, true);
            }
            if (actionMasked == 5 || actionMasked == 6) {
                this.X += this.Z - this.V;
                this.Y += this.f2337a0 - this.W;
                i iVar2 = i.f2409a;
                this.Z = iVar2.b(motionEvent2, true);
                float c10 = iVar2.c(motionEvent2, true);
                this.f2337a0 = c10;
                this.V = this.Z;
                this.W = c10;
            } else {
                i iVar3 = i.f2409a;
                this.Z = iVar3.b(motionEvent2, true);
                this.f2337a0 = iVar3.c(motionEvent2, true);
            }
            if (this.U < motionEvent2.getPointerCount()) {
                this.U = motionEvent2.getPointerCount();
            }
            if (c1()) {
                B();
            } else if (Q2 == 0) {
                if (actionMasked == 0 || actionMasked == 11) {
                    n();
                }
                d1();
            } else if (Q2 == 2) {
                if (actionMasked != 0) {
                    if (actionMasked != 1) {
                        if (actionMasked != 11) {
                            if (actionMasked != 12) {
                                return;
                            }
                        }
                    }
                    T0();
                    return;
                }
                d1();
            }
        }
    }

    public void j(boolean z10) {
        super.j(z10);
        z();
    }

    /* access modifiers changed from: protected */
    public void k0() {
        this.f2339c0 = 0;
        this.U = 0;
        Handler handler = this.f2338b0;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void o0() {
        super.o0();
        this.N = Float.MIN_VALUE;
        this.O = Float.MIN_VALUE;
        this.P = Float.MIN_VALUE;
        this.Q = 500;
        this.R = 200;
        this.S = 1;
        this.T = 1;
    }
}
