package ab;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.collections.g0;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;

public final class m extends d {
    public static final a X = new a((DefaultConstructorMarker) null);
    private long N = 500;
    private final float O;
    private float P;
    private int Q;
    private float R;
    private float S;
    private long T;
    private long U;
    private Handler V;
    private int W;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public m(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        E0(true);
        float f10 = context.getResources().getDisplayMetrics().density * 10.0f;
        float f11 = f10 * f10;
        this.O = f11;
        this.P = f11;
        this.Q = 1;
    }

    private final Pair T0(MotionEvent motionEvent, boolean z10) {
        if (!z10) {
            IntRange l10 = l.l(0, motionEvent.getPointerCount());
            ArrayList arrayList = new ArrayList(r.v(l10, 10));
            Iterator it = l10.iterator();
            while (it.hasNext()) {
                arrayList.add(Float.valueOf(motionEvent.getX(((g0) it).nextInt())));
            }
            float R2 = (float) r.R(arrayList);
            IntRange l11 = l.l(0, motionEvent.getPointerCount());
            ArrayList arrayList2 = new ArrayList(r.v(l11, 10));
            Iterator it2 = l11.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Float.valueOf(motionEvent.getY(((g0) it2).nextInt())));
            }
            return new Pair(Float.valueOf(R2), Float.valueOf((float) r.R(arrayList2)));
        }
        int pointerCount = motionEvent.getPointerCount();
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i10 = 0; i10 < pointerCount; i10++) {
            if (i10 != motionEvent.getActionIndex()) {
                f10 += motionEvent.getX(i10);
                f11 += motionEvent.getY(i10);
            }
        }
        return new Pair(Float.valueOf(f10 / ((float) (motionEvent.getPointerCount() - 1))), Float.valueOf(f11 / ((float) (motionEvent.getPointerCount() - 1))));
    }

    static /* synthetic */ Pair U0(m mVar, MotionEvent motionEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return mVar.T0(motionEvent, z10);
    }

    /* access modifiers changed from: private */
    public static final void W0(m mVar) {
        kotlin.jvm.internal.m.f(mVar, "this$0");
        mVar.i();
    }

    public final int V0() {
        return (int) (this.U - this.T);
    }

    public final m X0(float f10) {
        this.P = f10 * f10;
        return this;
    }

    public final void Y0(long j10) {
        this.N = j10;
    }

    public final m Z0(int i10) {
        this.Q = i10;
        return this;
    }

    /* access modifiers changed from: protected */
    public void h0(MotionEvent motionEvent, MotionEvent motionEvent2) {
        kotlin.jvm.internal.m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.m.f(motionEvent2, "sourceEvent");
        if (H0(motionEvent2)) {
            if (Q() == 0) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.U = uptimeMillis;
                this.T = uptimeMillis;
                n();
                Pair U0 = U0(this, motionEvent2, false, 2, (Object) null);
                float floatValue = ((Number) U0.a()).floatValue();
                float floatValue2 = ((Number) U0.b()).floatValue();
                this.R = floatValue;
                this.S = floatValue2;
                this.W++;
            }
            if (motionEvent2.getActionMasked() == 5) {
                this.W++;
                Pair U02 = U0(this, motionEvent2, false, 2, (Object) null);
                float floatValue3 = ((Number) U02.a()).floatValue();
                float floatValue4 = ((Number) U02.b()).floatValue();
                this.R = floatValue3;
                this.S = floatValue4;
                if (this.W > this.Q) {
                    B();
                    this.W = 0;
                }
            }
            if (Q() == 2 && this.W == this.Q && (motionEvent2.getActionMasked() == 0 || motionEvent2.getActionMasked() == 5)) {
                Handler handler = new Handler(Looper.getMainLooper());
                this.V = handler;
                long j10 = this.N;
                if (j10 > 0) {
                    kotlin.jvm.internal.m.c(handler);
                    handler.postDelayed(new l(this), this.N);
                } else if (j10 == 0) {
                    i();
                }
            }
            if (motionEvent2.getActionMasked() == 1 || motionEvent2.getActionMasked() == 12) {
                this.W--;
                Handler handler2 = this.V;
                if (handler2 != null) {
                    handler2.removeCallbacksAndMessages((Object) null);
                    this.V = null;
                }
                if (Q() == 4) {
                    z();
                } else {
                    B();
                }
            } else if (motionEvent2.getActionMasked() == 6) {
                int i10 = this.W - 1;
                this.W = i10;
                if (i10 >= this.Q || Q() == 4) {
                    Pair T0 = T0(motionEvent2, true);
                    float floatValue5 = ((Number) T0.a()).floatValue();
                    float floatValue6 = ((Number) T0.b()).floatValue();
                    this.R = floatValue5;
                    this.S = floatValue6;
                    return;
                }
                B();
                this.W = 0;
            } else {
                Pair U03 = U0(this, motionEvent2, false, 2, (Object) null);
                float floatValue7 = ((Number) U03.a()).floatValue();
                float floatValue8 = ((Number) U03.b()).floatValue();
                float f10 = floatValue7 - this.R;
                float f11 = floatValue8 - this.S;
                if ((f10 * f10) + (f11 * f11) <= this.P) {
                    return;
                }
                if (Q() == 4) {
                    o();
                } else {
                    B();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k0() {
        super.k0();
        this.W = 0;
    }

    /* access modifiers changed from: protected */
    public void l0(int i10, int i11) {
        Handler handler = this.V;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.V = null;
        }
    }

    public void o0() {
        super.o0();
        this.N = 500;
        this.P = this.O;
    }

    public void t(MotionEvent motionEvent) {
        kotlin.jvm.internal.m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        this.U = SystemClock.uptimeMillis();
        super.t(motionEvent);
    }

    public void u(int i10, int i11) {
        this.U = SystemClock.uptimeMillis();
        super.u(i10, i11);
    }
}
