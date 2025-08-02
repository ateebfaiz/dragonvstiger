package ab;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class w {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2455a;

    /* renamed from: b  reason: collision with root package name */
    private final b f2456b;

    /* renamed from: c  reason: collision with root package name */
    private float f2457c;

    /* renamed from: d  reason: collision with root package name */
    private float f2458d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2459e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2460f;

    /* renamed from: g  reason: collision with root package name */
    private float f2461g;

    /* renamed from: h  reason: collision with root package name */
    private float f2462h;

    /* renamed from: i  reason: collision with root package name */
    private float f2463i;

    /* renamed from: j  reason: collision with root package name */
    private float f2464j;

    /* renamed from: k  reason: collision with root package name */
    private float f2465k;

    /* renamed from: l  reason: collision with root package name */
    private float f2466l;

    /* renamed from: m  reason: collision with root package name */
    private float f2467m;

    /* renamed from: n  reason: collision with root package name */
    private long f2468n;

    /* renamed from: o  reason: collision with root package name */
    private long f2469o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f2470p;

    /* renamed from: q  reason: collision with root package name */
    private int f2471q;

    /* renamed from: r  reason: collision with root package name */
    private int f2472r;

    /* renamed from: s  reason: collision with root package name */
    private final Handler f2473s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public float f2474t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public float f2475u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public int f2476v;

    /* renamed from: w  reason: collision with root package name */
    private GestureDetector f2477w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f2478x;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            w.this.f2474t = motionEvent.getX();
            w.this.f2475u = motionEvent.getY();
            w.this.f2476v = 1;
            return true;
        }
    }

    public interface b {
        boolean a(w wVar);

        boolean b(w wVar);

        void c(w wVar);
    }

    public w(Context context, b bVar) {
        this(context, bVar, (Handler) null);
    }

    private boolean j() {
        if (this.f2476v != 0) {
            return true;
        }
        return false;
    }

    public float d() {
        return this.f2461g;
    }

    public float e() {
        return this.f2457c;
    }

    public float f() {
        return this.f2458d;
    }

    public float g() {
        boolean z10;
        if (j()) {
            boolean z11 = this.f2478x;
            if ((!z11 || this.f2461g >= this.f2462h) && (z11 || this.f2461g <= this.f2462h)) {
                z10 = false;
            } else {
                z10 = true;
            }
            float abs = Math.abs(1.0f - (this.f2461g / this.f2462h)) * 0.5f;
            if (this.f2462h <= ((float) this.f2471q)) {
                return 1.0f;
            }
            if (z10) {
                return 1.0f + abs;
            }
            return 1.0f - abs;
        }
        float f10 = this.f2462h;
        if (f10 > 0.0f) {
            return this.f2461g / f10;
        }
        return 1.0f;
    }

    public long h() {
        return this.f2468n - this.f2469o;
    }

    public double i() {
        return ((double) h()) / 1000.0d;
    }

    public boolean k(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i10;
        int i11;
        float f10;
        float f11;
        float f12;
        int i12;
        boolean z15;
        MotionEvent motionEvent2 = motionEvent;
        this.f2468n = motionEvent.getEventTime();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f2459e) {
            this.f2477w.onTouchEvent(motionEvent2);
        }
        int pointerCount = motionEvent.getPointerCount();
        if ((motionEvent.getButtonState() & 32) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f2476v != 2 || z10) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (actionMasked == 1 || actionMasked == 3 || z11) {
            z12 = true;
        } else {
            z12 = false;
        }
        float f13 = 0.0f;
        if (actionMasked == 0 || z12) {
            if (this.f2470p) {
                this.f2456b.c(this);
                this.f2470p = false;
                this.f2463i = 0.0f;
                this.f2476v = 0;
            } else if (j() && z12) {
                this.f2470p = false;
                this.f2463i = 0.0f;
                this.f2476v = 0;
            }
            if (z12) {
                return true;
            }
        }
        if (!this.f2470p && this.f2460f && !j() && !z12 && z10) {
            this.f2474t = motionEvent.getX();
            this.f2475u = motionEvent.getY();
            this.f2476v = 2;
            this.f2463i = 0.0f;
        }
        if (actionMasked == 0 || actionMasked == 6 || actionMasked == 5 || z11) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (actionMasked == 6) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            i10 = motionEvent.getActionIndex();
        } else {
            i10 = -1;
        }
        if (z14) {
            i11 = pointerCount - 1;
        } else {
            i11 = pointerCount;
        }
        if (j()) {
            f11 = this.f2474t;
            f10 = this.f2475u;
            if (motionEvent.getY() < f10) {
                this.f2478x = true;
            } else {
                this.f2478x = false;
            }
        } else {
            float f14 = 0.0f;
            float f15 = 0.0f;
            for (int i13 = 0; i13 < pointerCount; i13++) {
                if (i10 != i13) {
                    f14 += motionEvent2.getX(i13);
                    f15 += motionEvent2.getY(i13);
                }
            }
            float f16 = (float) i11;
            float f17 = f14 / f16;
            f10 = f15 / f16;
            f11 = f17;
        }
        float f18 = 0.0f;
        for (int i14 = 0; i14 < pointerCount; i14++) {
            if (i10 != i14) {
                f13 += Math.abs(motionEvent2.getX(i14) - f11);
                f18 += Math.abs(motionEvent2.getY(i14) - f10);
            }
        }
        float f19 = (float) i11;
        float f20 = (f13 / f19) * 2.0f;
        float f21 = (f18 / f19) * 2.0f;
        if (j()) {
            f12 = f21;
        } else {
            f12 = (float) Math.hypot((double) f20, (double) f21);
        }
        boolean z16 = this.f2470p;
        this.f2457c = f11;
        this.f2458d = f10;
        if (!j() && this.f2470p && (f12 < ((float) this.f2472r) || z13)) {
            this.f2456b.c(this);
            this.f2470p = false;
            this.f2463i = f12;
        }
        if (z13) {
            this.f2464j = f20;
            this.f2466l = f20;
            this.f2465k = f21;
            this.f2467m = f21;
            this.f2461g = f12;
            this.f2462h = f12;
            this.f2463i = f12;
        }
        if (j()) {
            i12 = this.f2471q;
        } else {
            i12 = this.f2472r;
        }
        if (!this.f2470p && f12 >= ((float) i12) && (z16 || Math.abs(f12 - this.f2463i) > ((float) this.f2471q))) {
            this.f2464j = f20;
            this.f2466l = f20;
            this.f2465k = f21;
            this.f2467m = f21;
            this.f2461g = f12;
            this.f2462h = f12;
            this.f2469o = this.f2468n;
            this.f2470p = this.f2456b.a(this);
        }
        if (actionMasked == 2) {
            this.f2464j = f20;
            this.f2465k = f21;
            this.f2461g = f12;
            if (this.f2470p) {
                z15 = this.f2456b.b(this);
            } else {
                z15 = true;
            }
            if (z15) {
                this.f2466l = this.f2464j;
                this.f2467m = this.f2465k;
                this.f2462h = this.f2461g;
                this.f2469o = this.f2468n;
            }
        }
        return true;
    }

    public void l(boolean z10) {
        this.f2459e = z10;
        if (z10 && this.f2477w == null) {
            this.f2477w = new GestureDetector(this.f2455a, new a(), this.f2473s);
        }
    }

    public void m(boolean z10) {
        this.f2460f = z10;
    }

    public w(Context context, b bVar, Handler handler) {
        this.f2476v = 0;
        this.f2455a = context;
        this.f2456b = bVar;
        this.f2471q = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
        this.f2472r = 0;
        this.f2473s = handler;
        int i10 = context.getApplicationInfo().targetSdkVersion;
        if (i10 > 18) {
            l(true);
        }
        if (i10 > 22) {
            m(true);
        }
    }
}
