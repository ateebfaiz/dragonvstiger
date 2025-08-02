package w3;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private int f24517a = -1;

    /* renamed from: b  reason: collision with root package name */
    private boolean f24518b = false;

    /* renamed from: c  reason: collision with root package name */
    private ColorFilter f24519c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f24520d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f24521e = -1;

    public void a(Drawable drawable) {
        boolean z10;
        if (drawable != null) {
            int i10 = this.f24517a;
            if (i10 != -1) {
                drawable.setAlpha(i10);
            }
            if (this.f24518b) {
                drawable.setColorFilter(this.f24519c);
            }
            int i11 = this.f24520d;
            boolean z11 = false;
            if (i11 != -1) {
                if (i11 != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                drawable.setDither(z10);
            }
            int i12 = this.f24521e;
            if (i12 != -1) {
                if (i12 != 0) {
                    z11 = true;
                }
                drawable.setFilterBitmap(z11);
            }
        }
    }

    public void b(int i10) {
        this.f24517a = i10;
    }

    public void c(ColorFilter colorFilter) {
        boolean z10;
        this.f24519c = colorFilter;
        if (colorFilter != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f24518b = z10;
    }

    public void d(boolean z10) {
        this.f24520d = z10 ? 1 : 0;
    }

    public void e(boolean z10) {
        this.f24521e = z10 ? 1 : 0;
    }
}
