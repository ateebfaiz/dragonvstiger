package y0;

import android.view.Choreographer;
import com.airbnb.lottie.e;
import com.airbnb.lottie.j;

public class i extends c implements Choreographer.FrameCallback {
    private j C;
    protected boolean X = false;
    private boolean Y = false;

    /* renamed from: d  reason: collision with root package name */
    private float f24854d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24855e = false;

    /* renamed from: f  reason: collision with root package name */
    private long f24856f = 0;

    /* renamed from: g  reason: collision with root package name */
    private float f24857g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f24858h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private int f24859i = 0;

    /* renamed from: j  reason: collision with root package name */
    private float f24860j = -2.14748365E9f;

    /* renamed from: w  reason: collision with root package name */
    private float f24861w = 2.14748365E9f;

    private void E() {
        if (this.C != null) {
            float f10 = this.f24858h;
            if (f10 < this.f24860j || f10 > this.f24861w) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.f24860j), Float.valueOf(this.f24861w), Float.valueOf(this.f24858h)}));
            }
        }
    }

    private float l() {
        j jVar = this.C;
        if (jVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / jVar.i()) / Math.abs(this.f24854d);
    }

    private boolean p() {
        if (o() < 0.0f) {
            return true;
        }
        return false;
    }

    public void A(float f10, float f11) {
        float f12;
        float f13;
        if (f10 <= f11) {
            j jVar = this.C;
            if (jVar == null) {
                f12 = -3.4028235E38f;
            } else {
                f12 = jVar.p();
            }
            j jVar2 = this.C;
            if (jVar2 == null) {
                f13 = Float.MAX_VALUE;
            } else {
                f13 = jVar2.f();
            }
            float b10 = k.b(f10, f12, f13);
            float b11 = k.b(f11, f12, f13);
            if (b10 != this.f24860j || b11 != this.f24861w) {
                this.f24860j = b10;
                this.f24861w = b11;
                y((float) ((int) k.b(this.f24858h, b10, b11)));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[]{Float.valueOf(f10), Float.valueOf(f11)}));
    }

    public void B(int i10) {
        A((float) i10, (float) ((int) this.f24861w));
    }

    public void C(float f10) {
        this.f24854d = f10;
    }

    public void D(boolean z10) {
        this.Y = z10;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        super.a();
        b(p());
    }

    public void cancel() {
        a();
        t();
    }

    public void doFrame(long j10) {
        float f10;
        float f11;
        s();
        if (this.C != null && isRunning()) {
            if (e.h()) {
                e.b("LottieValueAnimator#doFrame");
            }
            long j11 = this.f24856f;
            long j12 = 0;
            if (j11 != 0) {
                j12 = j10 - j11;
            }
            float l10 = ((float) j12) / l();
            float f12 = this.f24857g;
            if (p()) {
                l10 = -l10;
            }
            float f13 = f12 + l10;
            boolean z10 = !k.d(f13, n(), m());
            float f14 = this.f24857g;
            float b10 = k.b(f13, n(), m());
            this.f24857g = b10;
            if (this.Y) {
                b10 = (float) Math.floor((double) b10);
            }
            this.f24858h = b10;
            this.f24856f = j10;
            if (!this.Y || this.f24857g != f14) {
                g();
            }
            if (z10) {
                if (getRepeatCount() == -1 || this.f24859i < getRepeatCount()) {
                    d();
                    this.f24859i++;
                    if (getRepeatMode() == 2) {
                        this.f24855e = !this.f24855e;
                        w();
                    } else {
                        if (p()) {
                            f10 = m();
                        } else {
                            f10 = n();
                        }
                        this.f24857g = f10;
                        this.f24858h = f10;
                    }
                    this.f24856f = j10;
                } else {
                    if (this.f24854d < 0.0f) {
                        f11 = n();
                    } else {
                        f11 = m();
                    }
                    this.f24857g = f11;
                    this.f24858h = f11;
                    t();
                    b(p());
                }
            }
            E();
            if (e.h()) {
                e.c("LottieValueAnimator#doFrame");
            }
        }
    }

    public float getAnimatedFraction() {
        float n10;
        float m10;
        float n11;
        if (this.C == null) {
            return 0.0f;
        }
        if (p()) {
            n10 = m() - this.f24858h;
            m10 = m();
            n11 = n();
        } else {
            n10 = this.f24858h - n();
            m10 = m();
            n11 = n();
        }
        return n10 / (m10 - n11);
    }

    public Object getAnimatedValue() {
        return Float.valueOf(j());
    }

    public long getDuration() {
        j jVar = this.C;
        if (jVar == null) {
            return 0;
        }
        return (long) jVar.d();
    }

    public void h() {
        this.C = null;
        this.f24860j = -2.14748365E9f;
        this.f24861w = 2.14748365E9f;
    }

    public void i() {
        t();
        b(p());
    }

    public boolean isRunning() {
        return this.X;
    }

    public float j() {
        j jVar = this.C;
        if (jVar == null) {
            return 0.0f;
        }
        return (this.f24858h - jVar.p()) / (this.C.f() - this.C.p());
    }

    public float k() {
        return this.f24858h;
    }

    public float m() {
        j jVar = this.C;
        if (jVar == null) {
            return 0.0f;
        }
        float f10 = this.f24861w;
        if (f10 == 2.14748365E9f) {
            return jVar.f();
        }
        return f10;
    }

    public float n() {
        j jVar = this.C;
        if (jVar == null) {
            return 0.0f;
        }
        float f10 = this.f24860j;
        if (f10 == -2.14748365E9f) {
            return jVar.p();
        }
        return f10;
    }

    public float o() {
        return this.f24854d;
    }

    public void q() {
        t();
        c();
    }

    public void r() {
        float f10;
        this.X = true;
        f(p());
        if (p()) {
            f10 = m();
        } else {
            f10 = n();
        }
        y((float) ((int) f10));
        this.f24856f = 0;
        this.f24859i = 0;
        s();
    }

    /* access modifiers changed from: protected */
    public void s() {
        if (isRunning()) {
            u(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void setRepeatMode(int i10) {
        super.setRepeatMode(i10);
        if (i10 != 2 && this.f24855e) {
            this.f24855e = false;
            w();
        }
    }

    /* access modifiers changed from: protected */
    public void t() {
        u(true);
    }

    /* access modifiers changed from: protected */
    public void u(boolean z10) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z10) {
            this.X = false;
        }
    }

    public void v() {
        this.X = true;
        s();
        this.f24856f = 0;
        if (p() && k() == n()) {
            y(m());
        } else if (!p() && k() == m()) {
            y(n());
        }
        e();
    }

    public void w() {
        C(-o());
    }

    public void x(j jVar) {
        boolean z10;
        if (this.C == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.C = jVar;
        if (z10) {
            A(Math.max(this.f24860j, jVar.p()), Math.min(this.f24861w, jVar.f()));
        } else {
            A((float) ((int) jVar.p()), (float) ((int) jVar.f()));
        }
        float f10 = this.f24858h;
        this.f24858h = 0.0f;
        this.f24857g = 0.0f;
        y((float) ((int) f10));
        g();
    }

    public void y(float f10) {
        if (this.f24857g != f10) {
            float b10 = k.b(f10, n(), m());
            this.f24857g = b10;
            if (this.Y) {
                b10 = (float) Math.floor((double) b10);
            }
            this.f24858h = b10;
            this.f24856f = 0;
            g();
        }
    }

    public void z(float f10) {
        A(this.f24860j, f10);
    }
}
