package ab;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.app.NotificationCompat;
import com.swmansion.gesturehandler.react.i;
import com.swmansion.gesturehandler.react.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class k extends d {
    public static final a Q = new a((DefaultConstructorMarker) null);
    private static final l R = new l();
    private Handler N;
    private Runnable O = new j(this);
    private y P = new y(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 31, (DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void T0() {
        int Q2 = Q();
        if (Q2 == 0) {
            o();
        } else if (Q2 == 2) {
            B();
        } else if (Q2 == 4) {
            z();
        }
    }

    /* access modifiers changed from: private */
    public static final void U0(k kVar) {
        m.f(kVar, "this$0");
        kVar.T0();
    }

    private final boolean W0(d dVar) {
        View U = dVar.U();
        while (U != null) {
            if (m.b(U, U())) {
                return true;
            }
            ViewParent parent = U.getParent();
            if (parent instanceof View) {
                U = (View) parent;
            } else {
                U = null;
            }
        }
        return false;
    }

    private final Boolean X0(View view, View view2, View view3) {
        if (m.b(view3, view2)) {
            return Boolean.TRUE;
        }
        if (m.b(view3, view)) {
            return Boolean.FALSE;
        }
        if (!(view3 instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view3;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            Boolean X0 = X0(view, view2, R.c(viewGroup, i10));
            if (X0 != null) {
                return X0;
            }
        }
        return null;
    }

    static /* synthetic */ Boolean Y0(k kVar, View view, View view2, View view3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            view3 = view.getRootView();
            m.e(view3, "getRootView(...)");
        }
        return kVar.X0(view, view2, view3);
    }

    public boolean I0(d dVar) {
        m.f(dVar, "handler");
        if (!(dVar instanceof k) || ((k) dVar).W0(this)) {
            return super.I0(dVar);
        }
        View U = dVar.U();
        m.c(U);
        View U2 = U();
        m.c(U2);
        Boolean Y0 = Y0(this, U, U2, (View) null, 4, (Object) null);
        m.c(Y0);
        return Y0.booleanValue();
    }

    public boolean J0(d dVar) {
        m.f(dVar, "handler");
        if ((!(dVar instanceof k) || (!W0(dVar) && !((k) dVar).W0(this))) && !(dVar instanceof i.b)) {
            return super.J0(dVar);
        }
        return true;
    }

    public boolean K0(d dVar) {
        m.f(dVar, "handler");
        if ((dVar instanceof k) && !W0(dVar) && !((k) dVar).W0(this)) {
            View U = U();
            m.c(U);
            View U2 = dVar.U();
            m.c(U2);
            Boolean Y0 = Y0(this, U, U2, (View) null, 4, (Object) null);
            if (Y0 != null) {
                return Y0.booleanValue();
            }
        }
        return super.K0(dVar);
    }

    public final y V0() {
        return this.P;
    }

    /* access modifiers changed from: protected */
    public void h0(MotionEvent motionEvent, MotionEvent motionEvent2) {
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        m.f(motionEvent2, "sourceEvent");
        if (motionEvent.getAction() == 0) {
            Handler handler = this.N;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            this.N = null;
        } else if (motionEvent.getAction() == 1 && !c0()) {
            T0();
        }
    }

    /* access modifiers changed from: protected */
    public void i0(MotionEvent motionEvent, MotionEvent motionEvent2) {
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        m.f(motionEvent2, "sourceEvent");
        if (motionEvent.getAction() == 10) {
            if (this.N == null) {
                this.N = new Handler(Looper.getMainLooper());
            }
            Handler handler = this.N;
            m.c(handler);
            handler.postDelayed(this.O, 4);
        } else if (!c0()) {
            T0();
        } else if (Q() == 4 && motionEvent.getToolType(0) == 2) {
            this.P = y.f2480f.a(motionEvent);
        } else if (Q() != 0) {
        } else {
            if (motionEvent.getAction() == 7 || motionEvent.getAction() == 9) {
                n();
                i();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k0() {
        super.k0();
        this.P = new y(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 31, (DefaultConstructorMarker) null);
    }
}
