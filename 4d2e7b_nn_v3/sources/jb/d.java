package jb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class d extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f12446a = new Paint(2);

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f12447b;

    /* renamed from: c  reason: collision with root package name */
    private int f12448c = 255;

    /* renamed from: d  reason: collision with root package name */
    private int f12449d;

    /* renamed from: e  reason: collision with root package name */
    private int f12450e;

    public d(Bitmap bitmap) {
        b(bitmap);
    }

    public Bitmap a() {
        return this.f12447b;
    }

    public void b(Bitmap bitmap) {
        this.f12447b = bitmap;
        if (bitmap != null) {
            this.f12449d = bitmap.getWidth();
            this.f12450e = this.f12447b.getHeight();
            return;
        }
        this.f12450e = 0;
        this.f12449d = 0;
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f12447b;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.f12447b, (Rect) null, getBounds(), this.f12446a);
        }
    }

    public int getAlpha() {
        return this.f12448c;
    }

    public int getIntrinsicHeight() {
        return this.f12450e;
    }

    public int getIntrinsicWidth() {
        return this.f12449d;
    }

    public int getMinimumHeight() {
        return this.f12450e;
    }

    public int getMinimumWidth() {
        return this.f12449d;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i10) {
        this.f12448c = i10;
        this.f12446a.setAlpha(i10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f12446a.setColorFilter(colorFilter);
    }

    public void setFilterBitmap(boolean z10) {
        this.f12446a.setFilterBitmap(z10);
    }
}
