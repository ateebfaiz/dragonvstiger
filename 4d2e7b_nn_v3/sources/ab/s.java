package ab;

import ab.w;
import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.m;

public final class s extends d {
    /* access modifiers changed from: private */
    public double N;
    /* access modifiers changed from: private */
    public double O;
    private float P = Float.NaN;
    private float Q = Float.NaN;
    private w R;
    /* access modifiers changed from: private */
    public float S;
    /* access modifiers changed from: private */
    public float T;
    private final w.b U = new a(this);

    public static final class a implements w.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f2437a;

        a(s sVar) {
            this.f2437a = sVar;
            sVar.E0(false);
        }

        public boolean a(w wVar) {
            m.f(wVar, "detector");
            this.f2437a.S = wVar.d();
            return true;
        }

        public boolean b(w wVar) {
            m.f(wVar, "detector");
            double Z0 = this.f2437a.Z0();
            s sVar = this.f2437a;
            sVar.N = sVar.Z0() * ((double) wVar.g());
            double i10 = wVar.i();
            if (i10 > 0.0d) {
                s sVar2 = this.f2437a;
                sVar2.O = (sVar2.Z0() - Z0) / i10;
            }
            if (Math.abs(this.f2437a.S - wVar.d()) < this.f2437a.T || this.f2437a.Q() != 2) {
                return true;
            }
            this.f2437a.i();
            return true;
        }

        public void c(w wVar) {
            m.f(wVar, "detector");
        }
    }

    public final float X0() {
        return this.P;
    }

    public final float Y0() {
        return this.Q;
    }

    public final double Z0() {
        return this.N;
    }

    public final double a1() {
        return this.O;
    }

    /* access modifiers changed from: protected */
    public void h0(MotionEvent motionEvent, MotionEvent motionEvent2) {
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        m.f(motionEvent2, "sourceEvent");
        if (Q() == 0) {
            View U2 = U();
            m.c(U2);
            Context context = U2.getContext();
            p0();
            this.R = new w(context, this.U);
            this.T = (float) ViewConfiguration.get(context).getScaledTouchSlop();
            this.P = motionEvent.getX();
            this.Q = motionEvent.getY();
            n();
        }
        w wVar = this.R;
        if (wVar != null) {
            wVar.k(motionEvent2);
        }
        w wVar2 = this.R;
        if (wVar2 != null) {
            PointF O0 = O0(new PointF(wVar2.e(), wVar2.f()));
            this.P = O0.x;
            this.Q = O0.y;
        }
        if (motionEvent2.getActionMasked() != 1) {
            return;
        }
        if (Q() == 4) {
            z();
        } else {
            B();
        }
    }

    public void j(boolean z10) {
        if (Q() != 4) {
            p0();
        }
        super.j(z10);
    }

    /* access modifiers changed from: protected */
    public void k0() {
        this.R = null;
        this.P = Float.NaN;
        this.Q = Float.NaN;
        p0();
    }

    public void p0() {
        this.O = 0.0d;
        this.N = 1.0d;
    }
}
