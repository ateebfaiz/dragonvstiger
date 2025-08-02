package ab;

import android.view.VelocityTracker;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class b0 {

    /* renamed from: f  reason: collision with root package name */
    public static final a f2341f = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final b0 f2342g = new b0(-1.0d, 0.0d);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final b0 f2343h = new b0(1.0d, 0.0d);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final b0 f2344i = new b0(0.0d, -1.0d);
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final b0 f2345j = new b0(0.0d, 1.0d);
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final b0 f2346k = new b0(1.0d, -1.0d);
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final b0 f2347l = new b0(1.0d, 1.0d);
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final b0 f2348m = new b0(-1.0d, -1.0d);
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static final b0 f2349n = new b0(-1.0d, 1.0d);
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static final b0 f2350o = new b0(0.0d, 0.0d);

    /* renamed from: a  reason: collision with root package name */
    private final double f2351a;

    /* renamed from: b  reason: collision with root package name */
    private final double f2352b;

    /* renamed from: c  reason: collision with root package name */
    private final double f2353c;

    /* renamed from: d  reason: collision with root package name */
    private final double f2354d;

    /* renamed from: e  reason: collision with root package name */
    private final double f2355e;

    public static final class a {
        private a() {
        }

        public final b0 a(int i10) {
            switch (i10) {
                case 1:
                    return b0.f2343h;
                case 2:
                    return b0.f2342g;
                case 4:
                    return b0.f2344i;
                case 5:
                    return b0.f2346k;
                case 6:
                    return b0.f2348m;
                case 8:
                    return b0.f2345j;
                case 9:
                    return b0.f2347l;
                case 10:
                    return b0.f2349n;
                default:
                    return b0.f2350o;
            }
        }

        public final b0 b(VelocityTracker velocityTracker) {
            m.f(velocityTracker, "tracker");
            velocityTracker.computeCurrentVelocity(1000);
            return new b0((double) velocityTracker.getXVelocity(), (double) velocityTracker.getYVelocity());
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b0(double d10, double d11) {
        boolean z10;
        double d12;
        this.f2351a = d10;
        this.f2352b = d11;
        double hypot = Math.hypot(d10, d11);
        this.f2355e = hypot;
        if (hypot > 0.1d) {
            z10 = true;
        } else {
            z10 = false;
        }
        double d13 = 0.0d;
        if (z10) {
            d12 = d10 / hypot;
        } else {
            d12 = 0.0d;
        }
        this.f2353c = d12;
        this.f2354d = z10 ? d11 / hypot : d13;
    }

    private final double j(b0 b0Var) {
        return (this.f2353c * b0Var.f2353c) + (this.f2354d * b0Var.f2354d);
    }

    public final double k() {
        return this.f2355e;
    }

    public final boolean l(b0 b0Var, double d10) {
        m.f(b0Var, "vector");
        if (j(b0Var) > d10) {
            return true;
        }
        return false;
    }
}
