package w3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class h extends g {

    /* renamed from: e  reason: collision with root package name */
    final Matrix f24529e = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    private int f24530f;

    /* renamed from: g  reason: collision with root package name */
    private int f24531g;

    /* renamed from: h  reason: collision with root package name */
    private final Matrix f24532h = new Matrix();

    /* renamed from: i  reason: collision with root package name */
    private final RectF f24533i = new RectF();

    public h(Drawable drawable, int i10, int i11) {
        super(drawable);
        this.f24530f = i10 - (i10 % 90);
        this.f24531g = (i11 < 0 || i11 > 8) ? 0 : i11;
    }

    public void draw(Canvas canvas) {
        int i10;
        if (this.f24530f > 0 || !((i10 = this.f24531g) == 0 || i10 == 1)) {
            int save = canvas.save();
            canvas.concat(this.f24529e);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    public void g(Matrix matrix) {
        t(matrix);
        if (!this.f24529e.isIdentity()) {
            matrix.preConcat(this.f24529e);
        }
    }

    public int getIntrinsicHeight() {
        int i10 = this.f24531g;
        if (i10 == 5 || i10 == 7 || this.f24530f % 180 != 0) {
            return super.getIntrinsicWidth();
        }
        return super.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        int i10 = this.f24531g;
        if (i10 == 5 || i10 == 7 || this.f24530f % 180 != 0) {
            return super.getIntrinsicHeight();
        }
        return super.getIntrinsicWidth();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        int i10;
        Drawable current = getCurrent();
        int i11 = this.f24530f;
        if (i11 > 0 || !((i10 = this.f24531g) == 0 || i10 == 1)) {
            int i12 = this.f24531g;
            if (i12 == 2) {
                this.f24529e.setScale(-1.0f, 1.0f);
            } else if (i12 == 7) {
                this.f24529e.setRotate(270.0f, (float) rect.centerX(), (float) rect.centerY());
                this.f24529e.postScale(-1.0f, 1.0f);
            } else if (i12 == 4) {
                this.f24529e.setScale(1.0f, -1.0f);
            } else if (i12 != 5) {
                this.f24529e.setRotate((float) i11, (float) rect.centerX(), (float) rect.centerY());
            } else {
                this.f24529e.setRotate(270.0f, (float) rect.centerX(), (float) rect.centerY());
                this.f24529e.postScale(1.0f, -1.0f);
            }
            this.f24532h.reset();
            this.f24529e.invert(this.f24532h);
            this.f24533i.set(rect);
            this.f24532h.mapRect(this.f24533i);
            RectF rectF = this.f24533i;
            current.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            return;
        }
        current.setBounds(rect);
    }
}
