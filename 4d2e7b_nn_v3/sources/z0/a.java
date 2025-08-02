package z0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.j;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final j f24969a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f24970b;

    /* renamed from: c  reason: collision with root package name */
    public Object f24971c;

    /* renamed from: d  reason: collision with root package name */
    public final Interpolator f24972d;

    /* renamed from: e  reason: collision with root package name */
    public final Interpolator f24973e;

    /* renamed from: f  reason: collision with root package name */
    public final Interpolator f24974f;

    /* renamed from: g  reason: collision with root package name */
    public final float f24975g;

    /* renamed from: h  reason: collision with root package name */
    public Float f24976h;

    /* renamed from: i  reason: collision with root package name */
    private float f24977i;

    /* renamed from: j  reason: collision with root package name */
    private float f24978j;

    /* renamed from: k  reason: collision with root package name */
    private int f24979k;

    /* renamed from: l  reason: collision with root package name */
    private int f24980l;

    /* renamed from: m  reason: collision with root package name */
    private float f24981m;

    /* renamed from: n  reason: collision with root package name */
    private float f24982n;

    /* renamed from: o  reason: collision with root package name */
    public PointF f24983o;

    /* renamed from: p  reason: collision with root package name */
    public PointF f24984p;

    public a(j jVar, Object obj, Object obj2, Interpolator interpolator, float f10, Float f11) {
        this.f24977i = -3987645.8f;
        this.f24978j = -3987645.8f;
        this.f24979k = 784923401;
        this.f24980l = 784923401;
        this.f24981m = Float.MIN_VALUE;
        this.f24982n = Float.MIN_VALUE;
        this.f24983o = null;
        this.f24984p = null;
        this.f24969a = jVar;
        this.f24970b = obj;
        this.f24971c = obj2;
        this.f24972d = interpolator;
        this.f24973e = null;
        this.f24974f = null;
        this.f24975g = f10;
        this.f24976h = f11;
    }

    public boolean a(float f10) {
        if (f10 < f() || f10 >= c()) {
            return false;
        }
        return true;
    }

    public a b(Object obj, Object obj2) {
        return new a(obj, obj2);
    }

    public float c() {
        if (this.f24969a == null) {
            return 1.0f;
        }
        if (this.f24982n == Float.MIN_VALUE) {
            if (this.f24976h == null) {
                this.f24982n = 1.0f;
            } else {
                this.f24982n = f() + ((this.f24976h.floatValue() - this.f24975g) / this.f24969a.e());
            }
        }
        return this.f24982n;
    }

    public float d() {
        if (this.f24978j == -3987645.8f) {
            this.f24978j = ((Float) this.f24971c).floatValue();
        }
        return this.f24978j;
    }

    public int e() {
        if (this.f24980l == 784923401) {
            this.f24980l = ((Integer) this.f24971c).intValue();
        }
        return this.f24980l;
    }

    public float f() {
        j jVar = this.f24969a;
        if (jVar == null) {
            return 0.0f;
        }
        if (this.f24981m == Float.MIN_VALUE) {
            this.f24981m = (this.f24975g - jVar.p()) / this.f24969a.e();
        }
        return this.f24981m;
    }

    public float g() {
        if (this.f24977i == -3987645.8f) {
            this.f24977i = ((Float) this.f24970b).floatValue();
        }
        return this.f24977i;
    }

    public int h() {
        if (this.f24979k == 784923401) {
            this.f24979k = ((Integer) this.f24970b).intValue();
        }
        return this.f24979k;
    }

    public boolean i() {
        if (this.f24972d == null && this.f24973e == null && this.f24974f == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f24970b + ", endValue=" + this.f24971c + ", startFrame=" + this.f24975g + ", endFrame=" + this.f24976h + ", interpolator=" + this.f24972d + '}';
    }

    public a(j jVar, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, float f10, Float f11) {
        this.f24977i = -3987645.8f;
        this.f24978j = -3987645.8f;
        this.f24979k = 784923401;
        this.f24980l = 784923401;
        this.f24981m = Float.MIN_VALUE;
        this.f24982n = Float.MIN_VALUE;
        this.f24983o = null;
        this.f24984p = null;
        this.f24969a = jVar;
        this.f24970b = obj;
        this.f24971c = obj2;
        this.f24972d = null;
        this.f24973e = interpolator;
        this.f24974f = interpolator2;
        this.f24975g = f10;
        this.f24976h = f11;
    }

    protected a(j jVar, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f10, Float f11) {
        this.f24977i = -3987645.8f;
        this.f24978j = -3987645.8f;
        this.f24979k = 784923401;
        this.f24980l = 784923401;
        this.f24981m = Float.MIN_VALUE;
        this.f24982n = Float.MIN_VALUE;
        this.f24983o = null;
        this.f24984p = null;
        this.f24969a = jVar;
        this.f24970b = obj;
        this.f24971c = obj2;
        this.f24972d = interpolator;
        this.f24973e = interpolator2;
        this.f24974f = interpolator3;
        this.f24975g = f10;
        this.f24976h = f11;
    }

    public a(Object obj) {
        this.f24977i = -3987645.8f;
        this.f24978j = -3987645.8f;
        this.f24979k = 784923401;
        this.f24980l = 784923401;
        this.f24981m = Float.MIN_VALUE;
        this.f24982n = Float.MIN_VALUE;
        this.f24983o = null;
        this.f24984p = null;
        this.f24969a = null;
        this.f24970b = obj;
        this.f24971c = obj;
        this.f24972d = null;
        this.f24973e = null;
        this.f24974f = null;
        this.f24975g = Float.MIN_VALUE;
        this.f24976h = Float.valueOf(Float.MAX_VALUE);
    }

    private a(Object obj, Object obj2) {
        this.f24977i = -3987645.8f;
        this.f24978j = -3987645.8f;
        this.f24979k = 784923401;
        this.f24980l = 784923401;
        this.f24981m = Float.MIN_VALUE;
        this.f24982n = Float.MIN_VALUE;
        this.f24983o = null;
        this.f24984p = null;
        this.f24969a = null;
        this.f24970b = obj;
        this.f24971c = obj2;
        this.f24972d = null;
        this.f24973e = null;
        this.f24974f = null;
        this.f24975g = Float.MIN_VALUE;
        this.f24976h = Float.valueOf(Float.MAX_VALUE);
    }
}
