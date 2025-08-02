package w3;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import y2.l;

public class b extends g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    private int f24513e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f24514f;

    /* renamed from: g  reason: collision with root package name */
    float f24515g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f24516h;

    public b(Drawable drawable, int i10) {
        this(drawable, i10, true);
    }

    private int w() {
        return (int) ((20.0f / ((float) this.f24513e)) * 360.0f);
    }

    private void x() {
        if (!this.f24516h) {
            this.f24516h = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i10 = bounds.right;
        int i11 = bounds.left;
        int i12 = i10 - i11;
        int i13 = bounds.bottom;
        int i14 = bounds.top;
        int i15 = i13 - i14;
        float f10 = this.f24515g;
        if (!this.f24514f) {
            f10 = 360.0f - f10;
        }
        canvas.rotate(f10, (float) (i11 + (i12 / 2)), (float) (i14 + (i15 / 2)));
        super.draw(canvas);
        canvas.restoreToCount(save);
        x();
    }

    public void run() {
        this.f24516h = false;
        this.f24515g += (float) w();
        invalidateSelf();
    }

    public b(Drawable drawable, int i10, boolean z10) {
        super((Drawable) l.g(drawable));
        this.f24515g = 0.0f;
        this.f24516h = false;
        this.f24513e = i10;
        this.f24514f = z10;
    }
}
