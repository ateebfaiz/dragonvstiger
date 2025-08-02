package o0;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import o0.a;
import u0.b;
import w0.j;

public class c implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final b f22892a;

    /* renamed from: b  reason: collision with root package name */
    private final a.b f22893b;

    /* renamed from: c  reason: collision with root package name */
    private final a f22894c;

    /* renamed from: d  reason: collision with root package name */
    private final d f22895d;

    /* renamed from: e  reason: collision with root package name */
    private final d f22896e;

    /* renamed from: f  reason: collision with root package name */
    private final d f22897f;

    /* renamed from: g  reason: collision with root package name */
    private final d f22898g;

    /* renamed from: h  reason: collision with root package name */
    private float f22899h = Float.NaN;

    /* renamed from: i  reason: collision with root package name */
    private float f22900i = Float.NaN;

    /* renamed from: j  reason: collision with root package name */
    private float f22901j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    private int f22902k = 0;

    /* renamed from: l  reason: collision with root package name */
    private final float[] f22903l = new float[9];

    class a extends z0.c {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ z0.c f22904d;

        a(z0.c cVar) {
            this.f22904d = cVar;
        }

        /* renamed from: d */
        public Float a(z0.b bVar) {
            Float f10 = (Float) this.f22904d.a(bVar);
            if (f10 == null) {
                return null;
            }
            return Float.valueOf(f10.floatValue() * 2.55f);
        }
    }

    public c(a.b bVar, b bVar2, j jVar) {
        this.f22893b = bVar;
        this.f22892a = bVar2;
        a a10 = jVar.a().a();
        this.f22894c = a10;
        a10.a(this);
        bVar2.i(a10);
        d d10 = jVar.d().a();
        this.f22895d = d10;
        d10.a(this);
        bVar2.i(d10);
        d d11 = jVar.b().a();
        this.f22896e = d11;
        d11.a(this);
        bVar2.i(d11);
        d d12 = jVar.c().a();
        this.f22897f = d12;
        d12.a(this);
        bVar2.i(d12);
        d d13 = jVar.e().a();
        this.f22898g = d13;
        d13.a(this);
        bVar2.i(d13);
    }

    public void a() {
        this.f22893b.a();
    }

    public void b(Paint paint, Matrix matrix, int i10) {
        float floatValue = ((Float) this.f22897f.h()).floatValue();
        double q10 = (double) (this.f22896e.q() * 0.017453292f);
        float sin = ((float) Math.sin(q10)) * floatValue;
        float cos = ((float) Math.cos(q10 + 3.141592653589793d)) * floatValue;
        this.f22892a.f24198x.f().getValues(this.f22903l);
        float[] fArr = this.f22903l;
        float f10 = fArr[0];
        float f11 = fArr[4];
        matrix.getValues(fArr);
        float[] fArr2 = this.f22903l;
        float f12 = fArr2[0] / f10;
        float f13 = sin * f12;
        float f14 = cos * (fArr2[4] / f11);
        int intValue = ((Integer) this.f22894c.h()).intValue();
        int argb = Color.argb(Math.round((((Float) this.f22895d.h()).floatValue() * ((float) i10)) / 255.0f), Color.red(intValue), Color.green(intValue), Color.blue(intValue));
        float max = Math.max(((Float) this.f22898g.h()).floatValue() * f12 * 0.33f, Float.MIN_VALUE);
        if (this.f22899h != max || this.f22900i != f13 || this.f22901j != f14 || this.f22902k != argb) {
            this.f22899h = max;
            this.f22900i = f13;
            this.f22901j = f14;
            this.f22902k = argb;
            paint.setShadowLayer(max, f13, f14, argb);
        }
    }

    public void c(z0.c cVar) {
        this.f22894c.o(cVar);
    }

    public void d(z0.c cVar) {
        this.f22896e.o(cVar);
    }

    public void e(z0.c cVar) {
        this.f22897f.o(cVar);
    }

    public void f(z0.c cVar) {
        if (cVar == null) {
            this.f22895d.o((z0.c) null);
        } else {
            this.f22895d.o(new a(cVar));
        }
    }

    public void g(z0.c cVar) {
        this.f22898g.o(cVar);
    }
}
