package r0;

import android.graphics.PointF;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f23592a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f23593b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f23594c;

    public a() {
        this.f23592a = new PointF();
        this.f23593b = new PointF();
        this.f23594c = new PointF();
    }

    public PointF a() {
        return this.f23592a;
    }

    public PointF b() {
        return this.f23593b;
    }

    public PointF c() {
        return this.f23594c;
    }

    public void d(float f10, float f11) {
        this.f23592a.set(f10, f11);
    }

    public void e(float f10, float f11) {
        this.f23593b.set(f10, f11);
    }

    public void f(float f10, float f11) {
        this.f23594c.set(f10, f11);
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", new Object[]{Float.valueOf(this.f23594c.x), Float.valueOf(this.f23594c.y), Float.valueOf(this.f23592a.x), Float.valueOf(this.f23592a.y), Float.valueOf(this.f23593b.x), Float.valueOf(this.f23593b.y)});
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f23592a = pointF;
        this.f23593b = pointF2;
        this.f23594c = pointF3;
    }
}
