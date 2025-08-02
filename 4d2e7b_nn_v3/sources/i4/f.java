package i4;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.m;
import w3.d;

public final class f extends Drawable implements Animatable, n3.a {

    /* renamed from: a  reason: collision with root package name */
    private b4.a f22114a;

    /* renamed from: b  reason: collision with root package name */
    private final c f22115b = new c(new k4.a(this.f22114a));

    /* renamed from: c  reason: collision with root package name */
    private d f22116c = new e();

    /* renamed from: d  reason: collision with root package name */
    private final d f22117d;

    /* renamed from: e  reason: collision with root package name */
    private final a f22118e;

    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f22119a;

        a(f fVar) {
            this.f22119a = fVar;
        }

        public void run() {
            this.f22119a.unscheduleSelf(this);
            this.f22119a.invalidateSelf();
        }
    }

    public f(b4.a aVar) {
        m.f(aVar, "animationBackend");
        this.f22114a = aVar;
        d dVar = new d();
        dVar.a(this);
        this.f22117d = dVar;
        this.f22118e = new a(this);
    }

    public void a() {
        this.f22114a.clear();
    }

    public void draw(Canvas canvas) {
        m.f(canvas, "canvas");
        int a10 = this.f22115b.a();
        if (a10 == -1) {
            a10 = this.f22114a.getFrameCount() - 1;
            this.f22115b.g(false);
            this.f22116c.c(this);
        } else if (a10 == 0 && this.f22115b.h()) {
            this.f22116c.a(this);
        }
        if (this.f22114a.l(this, canvas, a10)) {
            this.f22116c.d(this, a10);
            this.f22115b.f(a10);
        } else {
            this.f22115b.e();
        }
        long c10 = this.f22115b.c();
        if (c10 != -1) {
            scheduleSelf(this.f22118e, c10);
            return;
        }
        this.f22116c.c(this);
        this.f22115b.g(false);
    }

    public int getIntrinsicHeight() {
        return this.f22114a.a();
    }

    public int getIntrinsicWidth() {
        return this.f22114a.c();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.f22115b.b();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        m.f(rect, "bounds");
        this.f22114a.b(rect);
    }

    public void setAlpha(int i10) {
        this.f22117d.b(i10);
        this.f22114a.j(i10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f22117d.c(colorFilter);
        this.f22114a.e(colorFilter);
    }

    public void start() {
        if (this.f22114a.getFrameCount() > 0) {
            this.f22115b.i();
            this.f22116c.b(this);
            invalidateSelf();
        }
    }

    public void stop() {
        this.f22115b.j();
        this.f22116c.c(this);
        unscheduleSelf(this.f22118e);
    }
}
