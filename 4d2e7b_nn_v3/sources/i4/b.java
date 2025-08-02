package i4;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import b4.a;
import w3.d;

public class b extends Drawable implements Animatable, n3.a {
    private static final Class P0 = b.class;
    private static final d Q0 = new e();
    private long C = 0;
    private d N0;
    /* access modifiers changed from: private */
    public final Runnable O0;
    private int X;
    private volatile d Y = Q0;
    private final a.C0221a Z;

    /* renamed from: a  reason: collision with root package name */
    private b4.a f22090a;

    /* renamed from: b  reason: collision with root package name */
    private k4.b f22091b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f22092c;

    /* renamed from: d  reason: collision with root package name */
    private long f22093d;

    /* renamed from: e  reason: collision with root package name */
    private long f22094e;

    /* renamed from: f  reason: collision with root package name */
    private long f22095f;

    /* renamed from: g  reason: collision with root package name */
    private int f22096g;

    /* renamed from: h  reason: collision with root package name */
    private long f22097h;

    /* renamed from: i  reason: collision with root package name */
    private long f22098i;

    /* renamed from: j  reason: collision with root package name */
    private int f22099j;

    /* renamed from: w  reason: collision with root package name */
    private long f22100w = 8;

    class a implements Runnable {
        a() {
        }

        public void run() {
            b bVar = b.this;
            bVar.unscheduleSelf(bVar.O0);
            b.this.invalidateSelf();
        }
    }

    public b(b4.a aVar) {
        a aVar2 = new a(this);
        this.Z = aVar2;
        this.O0 = new a();
        this.f22090a = aVar;
        this.f22091b = c(aVar);
        if (aVar != null) {
            aVar.h(aVar2);
        }
    }

    private static k4.b c(b4.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new k4.a(aVar);
    }

    private long d() {
        return SystemClock.uptimeMillis();
    }

    private void e() {
        this.X++;
        if (z2.a.u(2)) {
            z2.a.w(P0, "Dropped a frame. Count: %s", Integer.valueOf(this.X));
        }
    }

    private void f(long j10) {
        long j11 = this.f22093d + j10;
        this.f22095f = j11;
        scheduleSelf(this.O0, j11);
    }

    public void a() {
        b4.a aVar = this.f22090a;
        if (aVar != null) {
            aVar.clear();
        }
    }

    public void draw(Canvas canvas) {
        long j10;
        if (this.f22090a != null && this.f22091b != null) {
            long d10 = d();
            if (this.f22092c) {
                j10 = (d10 - this.f22093d) + this.C;
            } else {
                j10 = Math.max(this.f22094e, 0);
            }
            int b10 = this.f22091b.b(j10, this.f22094e);
            if (b10 == -1) {
                b10 = this.f22090a.getFrameCount() - 1;
                this.Y.c(this);
                this.f22092c = false;
            } else if (b10 == 0 && this.f22096g != -1 && d10 >= this.f22095f) {
                this.Y.a(this);
            }
            boolean l10 = this.f22090a.l(this, canvas, b10);
            if (l10) {
                this.Y.d(this, b10);
                this.f22096g = b10;
            }
            if (!l10) {
                e();
            }
            long d11 = d();
            if (this.f22092c) {
                long a10 = this.f22091b.a(d11 - this.f22093d);
                if (a10 != -1) {
                    f(a10 + this.f22100w);
                } else {
                    this.Y.c(this);
                    this.f22092c = false;
                }
            }
            this.f22094e = j10;
        }
    }

    public int getIntrinsicHeight() {
        b4.a aVar = this.f22090a;
        if (aVar == null) {
            return super.getIntrinsicHeight();
        }
        return aVar.a();
    }

    public int getIntrinsicWidth() {
        b4.a aVar = this.f22090a;
        if (aVar == null) {
            return super.getIntrinsicWidth();
        }
        return aVar.c();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.f22092c;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        b4.a aVar = this.f22090a;
        if (aVar != null) {
            aVar.b(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i10) {
        if (this.f22092c) {
            return false;
        }
        long j10 = (long) i10;
        if (this.f22094e == j10) {
            return false;
        }
        this.f22094e = j10;
        invalidateSelf();
        return true;
    }

    public void setAlpha(int i10) {
        if (this.N0 == null) {
            this.N0 = new d();
        }
        this.N0.b(i10);
        b4.a aVar = this.f22090a;
        if (aVar != null) {
            aVar.j(i10);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.N0 == null) {
            this.N0 = new d();
        }
        this.N0.c(colorFilter);
        b4.a aVar = this.f22090a;
        if (aVar != null) {
            aVar.e(colorFilter);
        }
    }

    public void start() {
        b4.a aVar;
        if (!this.f22092c && (aVar = this.f22090a) != null && aVar.getFrameCount() > 1) {
            this.f22092c = true;
            long d10 = d();
            long j10 = d10 - this.f22097h;
            this.f22093d = j10;
            this.f22095f = j10;
            this.f22094e = d10 - this.f22098i;
            this.f22096g = this.f22099j;
            invalidateSelf();
            this.Y.b(this);
        }
    }

    public void stop() {
        if (this.f22092c) {
            long d10 = d();
            this.f22097h = d10 - this.f22093d;
            this.f22098i = d10 - this.f22094e;
            this.f22099j = this.f22096g;
            this.f22092c = false;
            this.f22093d = 0;
            this.f22095f = 0;
            this.f22094e = -1;
            this.f22096g = -1;
            unscheduleSelf(this.O0);
            this.Y.c(this);
        }
    }
}
