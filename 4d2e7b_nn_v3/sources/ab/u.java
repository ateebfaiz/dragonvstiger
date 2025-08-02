package ab;

import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.m;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    private final a f2444a;

    /* renamed from: b  reason: collision with root package name */
    private long f2445b;

    /* renamed from: c  reason: collision with root package name */
    private long f2446c;

    /* renamed from: d  reason: collision with root package name */
    private double f2447d;

    /* renamed from: e  reason: collision with root package name */
    private double f2448e;

    /* renamed from: f  reason: collision with root package name */
    private float f2449f;

    /* renamed from: g  reason: collision with root package name */
    private float f2450g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2451h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f2452i = new int[2];

    /* renamed from: j  reason: collision with root package name */
    private boolean f2453j;

    public interface a {
        void a(u uVar);

        boolean b(u uVar);

        boolean c(u uVar);
    }

    public u(a aVar) {
        this.f2444a = aVar;
    }

    private final void a() {
        if (this.f2451h) {
            this.f2453j = false;
            this.f2451h = false;
            a aVar = this.f2444a;
            if (aVar != null) {
                aVar.a(this);
            }
        }
    }

    private final void g() {
        if (!this.f2453j) {
            this.f2453j = true;
        }
    }

    private final void h(double d10) {
        if (this.f2453j) {
            this.f2447d = d10;
            this.f2453j = false;
        }
    }

    private final void i(MotionEvent motionEvent) {
        double d10;
        this.f2446c = this.f2445b;
        this.f2445b = motionEvent.getEventTime();
        int findPointerIndex = motionEvent.findPointerIndex(this.f2452i[0]);
        int findPointerIndex2 = motionEvent.findPointerIndex(this.f2452i[1]);
        if (findPointerIndex != -1 && findPointerIndex2 != -1) {
            float x10 = motionEvent.getX(findPointerIndex);
            float y10 = motionEvent.getY(findPointerIndex);
            float x11 = motionEvent.getX(findPointerIndex2);
            float y11 = motionEvent.getY(findPointerIndex2);
            float f10 = y11 - y10;
            this.f2449f = (x10 + x11) * 0.5f;
            this.f2450g = (y10 + y11) * 0.5f;
            double d11 = -Math.atan2((double) f10, (double) (x11 - x10));
            h(d11);
            if (Double.isNaN(this.f2447d)) {
                d10 = 0.0d;
            } else {
                d10 = this.f2447d - d11;
            }
            this.f2448e = d10;
            this.f2447d = d11;
            if (d10 > 3.141592653589793d) {
                this.f2448e = d10 - 3.141592653589793d;
            } else if (d10 < -3.141592653589793d) {
                this.f2448e = d10 + 3.141592653589793d;
            }
            double d12 = this.f2448e;
            if (d12 > 1.5707963267948966d) {
                this.f2448e = d12 - 3.141592653589793d;
            } else if (d12 < -1.5707963267948966d) {
                this.f2448e = d12 + 3.141592653589793d;
            }
        }
    }

    public final float b() {
        return this.f2449f;
    }

    public final float c() {
        return this.f2450g;
    }

    public final double d() {
        return this.f2448e;
    }

    public final long e() {
        return this.f2445b - this.f2446c;
    }

    public final boolean f(MotionEvent motionEvent) {
        a aVar;
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2451h = false;
            this.f2452i[0] = motionEvent.getPointerId(motionEvent.getActionIndex());
            this.f2452i[1] = -1;
        } else if (actionMasked == 1) {
            a();
        } else if (actionMasked != 2) {
            if (actionMasked == 5) {
                if (!this.f2451h || this.f2453j) {
                    this.f2452i[1] = motionEvent.getPointerId(motionEvent.getActionIndex());
                    i(motionEvent);
                }
                if (!this.f2451h) {
                    this.f2451h = true;
                    this.f2446c = motionEvent.getEventTime();
                    this.f2447d = Double.NaN;
                    a aVar2 = this.f2444a;
                    if (aVar2 != null) {
                        aVar2.c(this);
                    }
                }
            } else if (actionMasked == 6 && this.f2451h) {
                int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                int[] iArr = this.f2452i;
                if (pointerId == iArr[0]) {
                    iArr[0] = iArr[1];
                    iArr[1] = -1;
                    g();
                } else if (pointerId == iArr[1]) {
                    iArr[1] = -1;
                    g();
                }
            }
        } else if (this.f2451h) {
            i(motionEvent);
            if (!this.f2453j && (aVar = this.f2444a) != null) {
                aVar.b(this);
            }
        }
        return true;
    }
}
