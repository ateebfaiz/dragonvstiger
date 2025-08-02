package ab;

import ab.u;
import android.graphics.PointF;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class v extends d {
    public static final a T = new a((DefaultConstructorMarker) null);
    private u N;
    /* access modifiers changed from: private */
    public double O;
    /* access modifiers changed from: private */
    public double P;
    private float Q = Float.NaN;
    private float R = Float.NaN;
    private final u.a S;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements u.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f2454a;

        b(v vVar) {
            this.f2454a = vVar;
        }

        public void a(u uVar) {
            m.f(uVar, "detector");
            this.f2454a.z();
        }

        public boolean b(u uVar) {
            m.f(uVar, "detector");
            double W0 = this.f2454a.W0();
            v vVar = this.f2454a;
            vVar.O = vVar.W0() + uVar.d();
            long e10 = uVar.e();
            if (e10 > 0) {
                v vVar2 = this.f2454a;
                vVar2.P = (vVar2.W0() - W0) / ((double) e10);
            }
            if (Math.abs(this.f2454a.W0()) < 0.08726646259971647d || this.f2454a.Q() != 2) {
                return true;
            }
            this.f2454a.i();
            return true;
        }

        public boolean c(u uVar) {
            m.f(uVar, "detector");
            return true;
        }
    }

    public v() {
        E0(false);
        this.S = new b(this);
    }

    public final float U0() {
        return this.Q;
    }

    public final float V0() {
        return this.R;
    }

    public final double W0() {
        return this.O;
    }

    public final double X0() {
        return this.P;
    }

    /* access modifiers changed from: protected */
    public void h0(MotionEvent motionEvent, MotionEvent motionEvent2) {
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        m.f(motionEvent2, "sourceEvent");
        if (Q() == 0) {
            p0();
            this.N = new u(this.S);
            this.Q = motionEvent.getX();
            this.R = motionEvent.getY();
            n();
        }
        u uVar = this.N;
        if (uVar != null) {
            uVar.f(motionEvent2);
        }
        u uVar2 = this.N;
        if (uVar2 != null) {
            PointF O0 = O0(new PointF(uVar2.b(), uVar2.c()));
            this.Q = O0.x;
            this.R = O0.y;
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
        this.N = null;
        this.Q = Float.NaN;
        this.R = Float.NaN;
        p0();
    }

    public void p0() {
        this.P = 0.0d;
        this.O = 0.0d;
    }
}
