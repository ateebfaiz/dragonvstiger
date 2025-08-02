package t4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import r4.b;
import r4.c;
import r4.d;
import r4.e;

public class a implements r4.a {

    /* renamed from: a  reason: collision with root package name */
    private final u4.a f24129a;

    /* renamed from: b  reason: collision with root package name */
    private final e f24130b;

    /* renamed from: c  reason: collision with root package name */
    private final c f24131c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f24132d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f24133e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f24134f;

    /* renamed from: g  reason: collision with root package name */
    private final int f24135g;

    /* renamed from: h  reason: collision with root package name */
    private final b[] f24136h;

    /* renamed from: i  reason: collision with root package name */
    private final Rect f24137i = new Rect();

    /* renamed from: j  reason: collision with root package name */
    private final Rect f24138j = new Rect();

    /* renamed from: k  reason: collision with root package name */
    private final boolean f24139k;

    /* renamed from: l  reason: collision with root package name */
    private final Paint f24140l;

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f24141m;

    public a(u4.a aVar, e eVar, Rect rect, boolean z10) {
        this.f24129a = aVar;
        this.f24130b = eVar;
        c d10 = eVar.d();
        this.f24131c = d10;
        int[] h10 = d10.h();
        this.f24133e = h10;
        aVar.a(h10);
        this.f24135g = aVar.c(h10);
        this.f24134f = aVar.b(h10);
        this.f24132d = k(d10, rect);
        this.f24139k = z10;
        this.f24136h = new b[d10.getFrameCount()];
        for (int i10 = 0; i10 < this.f24131c.getFrameCount(); i10++) {
            this.f24136h[i10] = this.f24131c.a(i10);
        }
        Paint paint = new Paint();
        this.f24140l = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    private synchronized void j() {
        Bitmap bitmap = this.f24141m;
        if (bitmap != null) {
            bitmap.recycle();
            this.f24141m = null;
        }
    }

    private static Rect k(c cVar, Rect rect) {
        if (rect == null) {
            return new Rect(0, 0, cVar.getWidth(), cVar.getHeight());
        }
        return new Rect(0, 0, Math.min(rect.width(), cVar.getWidth()), Math.min(rect.height(), cVar.getHeight()));
    }

    private void l(Canvas canvas, float f10, float f11, b bVar) {
        if (bVar.f23673g == b.C0328b.DISPOSE_TO_BACKGROUND) {
            int ceil = (int) Math.ceil((double) (((float) bVar.f23668b) * f10));
            int ceil2 = (int) Math.ceil((double) (((float) bVar.f23669c) * f11));
            canvas.drawRect(new Rect(ceil, ceil2, ((int) Math.ceil((double) (((float) bVar.f23670d) * f10))) + ceil, ((int) Math.ceil((double) (((float) bVar.f23671e) * f11))) + ceil2), this.f24140l);
        }
    }

    private synchronized Bitmap m(int i10, int i11) {
        try {
            Bitmap bitmap = this.f24141m;
            if (bitmap != null) {
                if (bitmap.getWidth() >= i10) {
                    if (this.f24141m.getHeight() < i11) {
                    }
                }
                j();
            }
            if (this.f24141m == null) {
                this.f24141m = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
            }
            this.f24141m.eraseColor(0);
        } catch (Throwable th) {
            throw th;
        }
        return this.f24141m;
    }

    private void n(Canvas canvas, d dVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        if (this.f24139k) {
            float max = Math.max(((float) dVar.getWidth()) / ((float) Math.min(dVar.getWidth(), canvas.getWidth())), ((float) dVar.getHeight()) / ((float) Math.min(dVar.getHeight(), canvas.getHeight())));
            i12 = (int) (((float) dVar.getWidth()) / max);
            i11 = (int) (((float) dVar.getHeight()) / max);
            i10 = (int) (((float) dVar.b()) / max);
            i13 = (int) (((float) dVar.c()) / max);
        } else {
            i12 = dVar.getWidth();
            i11 = dVar.getHeight();
            i10 = dVar.b();
            i13 = dVar.c();
        }
        synchronized (this) {
            Bitmap m10 = m(i12, i11);
            this.f24141m = m10;
            dVar.a(i12, i11, m10);
            canvas.save();
            canvas.translate((float) i10, (float) i13);
            canvas.drawBitmap(this.f24141m, 0.0f, 0.0f, (Paint) null);
            canvas.restore();
        }
    }

    private void o(Canvas canvas, d dVar) {
        double width = ((double) this.f24132d.width()) / ((double) this.f24131c.getWidth());
        double height = ((double) this.f24132d.height()) / ((double) this.f24131c.getHeight());
        int round = (int) Math.round(((double) dVar.getWidth()) * width);
        int round2 = (int) Math.round(((double) dVar.getHeight()) * height);
        int b10 = (int) (((double) dVar.b()) * width);
        int c10 = (int) (((double) dVar.c()) * height);
        synchronized (this) {
            try {
                int width2 = this.f24132d.width();
                int height2 = this.f24132d.height();
                m(width2, height2);
                Bitmap bitmap = this.f24141m;
                if (bitmap != null) {
                    dVar.a(round, round2, bitmap);
                }
                this.f24137i.set(0, 0, width2, height2);
                this.f24138j.set(b10, c10, width2 + b10, height2 + c10);
                Bitmap bitmap2 = this.f24141m;
                if (bitmap2 != null) {
                    canvas.drawBitmap(bitmap2, this.f24137i, this.f24138j, (Paint) null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void p(Canvas canvas, d dVar, b bVar, b bVar2) {
        Rect rect = this.f24132d;
        if (rect != null && rect.width() > 0 && this.f24132d.height() > 0) {
            float width = ((float) canvas.getWidth()) / ((float) this.f24132d.width());
            if (bVar2 != null) {
                l(canvas, width, width, bVar2);
            }
            int width2 = dVar.getWidth();
            int height = dVar.getHeight();
            Rect rect2 = new Rect(0, 0, width2, height);
            int b10 = (int) (((float) dVar.b()) * width);
            int c10 = (int) (((float) dVar.c()) * width);
            Rect rect3 = new Rect(b10, c10, ((int) (((float) width2) * width)) + b10, ((int) (((float) height) * width)) + c10);
            if (bVar.f23672f == b.a.NO_BLEND) {
                canvas.drawRect(rect3, this.f24140l);
            }
            synchronized (this) {
                Bitmap m10 = m(width2, height);
                dVar.a(width2, height, m10);
                canvas.drawBitmap(m10, rect2, rect3, (Paint) null);
            }
        }
    }

    private void q(Canvas canvas, d dVar, b bVar, b bVar2) {
        float f10;
        float f11;
        float f12;
        float f13;
        int width = this.f24131c.getWidth();
        int height = this.f24131c.getHeight();
        float f14 = (float) width;
        float f15 = (float) height;
        int width2 = dVar.getWidth();
        int height2 = dVar.getHeight();
        int b10 = dVar.b();
        int c10 = dVar.c();
        if (f14 > ((float) canvas.getWidth()) || f15 > ((float) canvas.getHeight())) {
            int min = Math.min(canvas.getWidth(), width);
            int min2 = Math.min(canvas.getHeight(), height);
            float f16 = f14 / f15;
            if (min > min2) {
                f13 = (float) min;
                f12 = f13 / f16;
            } else {
                f12 = (float) min2;
                f13 = f12 * f16;
            }
            f11 = f13 / f14;
            f10 = f12 / f15;
            width2 = (int) Math.ceil((double) (((float) dVar.getWidth()) * f11));
            height2 = (int) Math.ceil((double) (((float) dVar.getHeight()) * f10));
            b10 = (int) Math.ceil((double) (((float) dVar.b()) * f11));
            c10 = (int) Math.ceil((double) (((float) dVar.c()) * f10));
        } else {
            f11 = 1.0f;
            f10 = 1.0f;
        }
        Rect rect = new Rect(0, 0, width2, height2);
        Rect rect2 = new Rect(b10, c10, b10 + width2, c10 + height2);
        if (bVar2 != null) {
            l(canvas, f11, f10, bVar2);
        }
        if (bVar.f23672f == b.a.NO_BLEND) {
            canvas.drawRect(rect2, this.f24140l);
        }
        synchronized (this) {
            Bitmap m10 = m(width2, height2);
            dVar.a(width2, height2, m10);
            canvas.drawBitmap(m10, rect, rect2, (Paint) null);
        }
    }

    public b a(int i10) {
        return this.f24136h[i10];
    }

    public int b() {
        return this.f24135g;
    }

    public void c(int i10, Canvas canvas) {
        d e10 = this.f24131c.e(i10);
        try {
            if (e10.getWidth() > 0) {
                if (e10.getHeight() > 0) {
                    if (this.f24131c.f()) {
                        o(canvas, e10);
                    } else {
                        n(canvas, e10);
                    }
                    e10.dispose();
                }
            }
        } finally {
            e10.dispose();
        }
    }

    public int d(int i10) {
        return this.f24133e[i10];
    }

    public r4.a e(Rect rect) {
        if (k(this.f24131c, rect).equals(this.f24132d)) {
            return this;
        }
        return new a(this.f24129a, this.f24130b, rect, this.f24139k);
    }

    public int f() {
        return this.f24132d.height();
    }

    public void g(int i10, Canvas canvas) {
        b bVar;
        d e10 = this.f24131c.e(i10);
        b a10 = this.f24131c.a(i10);
        if (i10 == 0) {
            bVar = null;
        } else {
            bVar = this.f24131c.a(i10 - 1);
        }
        try {
            if (e10.getWidth() > 0) {
                if (e10.getHeight() > 0) {
                    if (this.f24131c.f()) {
                        q(canvas, e10, a10, bVar);
                    } else {
                        p(canvas, e10, a10, bVar);
                    }
                    e10.dispose();
                }
            }
        } finally {
            e10.dispose();
        }
    }

    public int getFrameCount() {
        return this.f24131c.getFrameCount();
    }

    public int getHeight() {
        return this.f24131c.getHeight();
    }

    public int getLoopCount() {
        return this.f24131c.getLoopCount();
    }

    public int getWidth() {
        return this.f24131c.getWidth();
    }

    public int h() {
        return this.f24132d.width();
    }

    public e i() {
        return this.f24130b;
    }
}
