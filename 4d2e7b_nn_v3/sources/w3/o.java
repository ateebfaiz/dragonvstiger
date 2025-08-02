package w3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import w3.p;
import y2.j;

public class o extends g {

    /* renamed from: e  reason: collision with root package name */
    p.b f24575e;

    /* renamed from: f  reason: collision with root package name */
    Object f24576f;

    /* renamed from: g  reason: collision with root package name */
    PointF f24577g = null;

    /* renamed from: h  reason: collision with root package name */
    int f24578h = 0;

    /* renamed from: i  reason: collision with root package name */
    int f24579i = 0;

    /* renamed from: j  reason: collision with root package name */
    Matrix f24580j;

    /* renamed from: w  reason: collision with root package name */
    private Matrix f24581w = new Matrix();

    public o(Drawable drawable, p.b bVar) {
        super(drawable);
        this.f24575e = bVar;
    }

    private void x() {
        Drawable current = getCurrent();
        if (current != null) {
            if (this.f24578h != current.getIntrinsicWidth() || this.f24579i != current.getIntrinsicHeight()) {
                w();
            }
        }
    }

    public void A(PointF pointF) {
        if (!j.a(this.f24577g, pointF)) {
            if (pointF == null) {
                this.f24577g = null;
            } else {
                if (this.f24577g == null) {
                    this.f24577g = new PointF();
                }
                this.f24577g.set(pointF);
            }
            w();
            invalidateSelf();
        }
    }

    public void B(p.b bVar) {
        if (!j.a(this.f24575e, bVar)) {
            this.f24575e = bVar;
            this.f24576f = null;
            w();
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        x();
        if (this.f24580j != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.f24580j);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    public void g(Matrix matrix) {
        t(matrix);
        x();
        Matrix matrix2 = this.f24580j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        w();
    }

    public Drawable u(Drawable drawable) {
        Drawable u10 = super.u(drawable);
        w();
        return u10;
    }

    /* access modifiers changed from: package-private */
    public void w() {
        float f10;
        float f11;
        Drawable current = getCurrent();
        if (current == null) {
            this.f24579i = 0;
            this.f24578h = 0;
            this.f24580j = null;
            return;
        }
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.f24578h = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.f24579i = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.f24580j = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.f24580j = null;
        } else if (this.f24575e == p.b.f24582a) {
            current.setBounds(bounds);
            this.f24580j = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            p.b bVar = this.f24575e;
            Matrix matrix = this.f24581w;
            PointF pointF = this.f24577g;
            if (pointF != null) {
                f10 = pointF.x;
            } else {
                f10 = 0.5f;
            }
            if (pointF != null) {
                f11 = pointF.y;
            } else {
                f11 = 0.5f;
            }
            bVar.a(matrix, bounds, intrinsicWidth, intrinsicHeight, f10, f11);
            this.f24580j = this.f24581w;
        }
    }

    public PointF y() {
        return this.f24577g;
    }

    public p.b z() {
        return this.f24575e;
    }
}
