package o0;

import android.graphics.PointF;
import java.util.Collections;
import o0.a;
import z0.c;

public class n extends a {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f22924i = new PointF();

    /* renamed from: j  reason: collision with root package name */
    private final PointF f22925j = new PointF();

    /* renamed from: k  reason: collision with root package name */
    private final a f22926k;

    /* renamed from: l  reason: collision with root package name */
    private final a f22927l;

    /* renamed from: m  reason: collision with root package name */
    protected c f22928m;

    /* renamed from: n  reason: collision with root package name */
    protected c f22929n;

    public n(a aVar, a aVar2) {
        super(Collections.emptyList());
        this.f22926k = aVar;
        this.f22927l = aVar2;
        n(f());
    }

    public void n(float f10) {
        this.f22926k.n(f10);
        this.f22927l.n(f10);
        this.f22924i.set(((Float) this.f22926k.h()).floatValue(), ((Float) this.f22927l.h()).floatValue());
        for (int i10 = 0; i10 < this.f22878a.size(); i10++) {
            ((a.b) this.f22878a.get(i10)).a();
        }
    }

    /* renamed from: q */
    public PointF h() {
        return i((z0.a) null, 0.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public PointF i(z0.a aVar, float f10) {
        Float f11;
        z0.a b10;
        float f12;
        z0.a b11;
        float f13;
        Float f14 = null;
        if (this.f22928m == null || (b11 = this.f22926k.b()) == null) {
            f11 = null;
        } else {
            Float f15 = b11.f24976h;
            c cVar = this.f22928m;
            float f16 = b11.f24975g;
            if (f15 == null) {
                f13 = f16;
            } else {
                f13 = f15.floatValue();
            }
            f11 = (Float) cVar.b(f16, f13, (Float) b11.f24970b, (Float) b11.f24971c, this.f22926k.d(), this.f22926k.e(), this.f22926k.f());
        }
        if (!(this.f22929n == null || (b10 = this.f22927l.b()) == null)) {
            Float f17 = b10.f24976h;
            c cVar2 = this.f22929n;
            float f18 = b10.f24975g;
            if (f17 == null) {
                f12 = f18;
            } else {
                f12 = f17.floatValue();
            }
            f14 = (Float) cVar2.b(f18, f12, (Float) b10.f24970b, (Float) b10.f24971c, this.f22927l.d(), this.f22927l.e(), this.f22927l.f());
        }
        if (f11 == null) {
            this.f22925j.set(this.f22924i.x, 0.0f);
        } else {
            this.f22925j.set(f11.floatValue(), 0.0f);
        }
        if (f14 == null) {
            PointF pointF = this.f22925j;
            pointF.set(pointF.x, this.f22924i.y);
        } else {
            PointF pointF2 = this.f22925j;
            pointF2.set(pointF2.x, f14.floatValue());
        }
        return this.f22925j;
    }

    public void s(c cVar) {
        c cVar2 = this.f22928m;
        if (cVar2 != null) {
            cVar2.c((a) null);
        }
        this.f22928m = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    public void t(c cVar) {
        c cVar2 = this.f22929n;
        if (cVar2 != null) {
            cVar2.c((a) null);
        }
        this.f22929n = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
