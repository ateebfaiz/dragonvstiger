package ab;

import ab.b0;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class b extends d {
    public static final a V = new a((DefaultConstructorMarker) null);
    private static final double W;
    private static final double X;
    private int N = 1;
    private int O = 1;
    private final long P = 800;
    private final long Q = 2000;
    private Handler R;
    private int S;
    private final Runnable T = new a(this);
    private VelocityTracker U;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        i iVar = i.f2409a;
        W = iVar.a(30.0d);
        X = iVar.a(60.0d);
    }

    private final void T0(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        motionEvent.offsetLocation(rawX, rawY);
        m.c(velocityTracker);
        velocityTracker.addMovement(motionEvent);
        motionEvent.offsetLocation(-rawX, -rawY);
    }

    private final void U0(MotionEvent motionEvent) {
        if (!Z0(motionEvent)) {
            B();
        }
    }

    /* access modifiers changed from: private */
    public static final void V0(b bVar) {
        m.f(bVar, "this$0");
        bVar.B();
    }

    private final void Y0(MotionEvent motionEvent) {
        this.U = VelocityTracker.obtain();
        n();
        this.S = 1;
        Handler handler = this.R;
        if (handler == null) {
            this.R = new Handler(Looper.getMainLooper());
        } else {
            m.c(handler);
            handler.removeCallbacksAndMessages((Object) null);
        }
        Handler handler2 = this.R;
        m.c(handler2);
        handler2.postDelayed(this.T, this.P);
    }

    private final boolean Z0(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        boolean z12;
        T0(this.U, motionEvent);
        b0.a aVar = b0.f2341f;
        VelocityTracker velocityTracker = this.U;
        m.c(velocityTracker);
        b0 b10 = aVar.b(velocityTracker);
        Integer[] numArr = {2, 1, 4, 8};
        ArrayList arrayList = new ArrayList(4);
        for (int i10 = 0; i10 < 4; i10++) {
            arrayList.add(Boolean.valueOf(a1(this, b10, numArr[i10].intValue(), W)));
        }
        Integer[] numArr2 = {5, 9, 6, 10};
        ArrayList arrayList2 = new ArrayList(4);
        for (int i11 = 0; i11 < 4; i11++) {
            arrayList2.add(Boolean.valueOf(a1(this, b10, numArr2[i11].intValue(), X)));
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((Boolean) it.next()).booleanValue()) {
                        z10 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z10 = false;
        if (!arrayList2.isEmpty()) {
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((Boolean) it2.next()).booleanValue()) {
                        z11 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z11 = false;
        boolean z13 = z11 | z10;
        if (b10.k() > ((double) this.Q)) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (this.S != this.N || !z13 || !z12) {
            return false;
        }
        Handler handler = this.R;
        m.c(handler);
        handler.removeCallbacksAndMessages((Object) null);
        i();
        return true;
    }

    private static final boolean a1(b bVar, b0 b0Var, int i10, double d10) {
        if ((bVar.O & i10) != i10 || !b0Var.l(b0.f2341f.a(i10), d10)) {
            return false;
        }
        return true;
    }

    public final void W0(int i10) {
        this.O = i10;
    }

    public final void X0(int i10) {
        this.N = i10;
    }

    /* access modifiers changed from: protected */
    public void g0() {
        Handler handler = this.R;
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
            if (Q2 == 0) {
                Y0(motionEvent2);
            }
            if (Q2 == 2) {
                Z0(motionEvent2);
                if (motionEvent2.getPointerCount() > this.S) {
                    this.S = motionEvent2.getPointerCount();
                }
                if (motionEvent2.getActionMasked() == 1) {
                    U0(motionEvent2);
                }
            }
        }
    }

    public void j(boolean z10) {
        super.j(z10);
        z();
    }

    /* access modifiers changed from: protected */
    public void k0() {
        VelocityTracker velocityTracker = this.U;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.U = null;
        Handler handler = this.R;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void o0() {
        super.o0();
        this.N = 1;
        this.O = 1;
    }
}
