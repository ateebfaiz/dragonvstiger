package w3;

import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import y2.l;

public abstract class a extends Drawable implements Drawable.Callback, r, q {

    /* renamed from: a  reason: collision with root package name */
    private r f24503a;

    /* renamed from: b  reason: collision with root package name */
    private final d f24504b = new d();

    /* renamed from: c  reason: collision with root package name */
    private final Drawable[] f24505c;

    /* renamed from: d  reason: collision with root package name */
    private final c[] f24506d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f24507e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private boolean f24508f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f24509g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f24510h;

    /* renamed from: w3.a$a  reason: collision with other inner class name */
    class C0349a implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f24511a;

        C0349a(int i10) {
            this.f24511a = i10;
        }

        public Drawable r() {
            return a.this.b(this.f24511a);
        }

        public Drawable setDrawable(Drawable drawable) {
            return a.this.f(this.f24511a, drawable);
        }
    }

    public a(Drawable[] drawableArr) {
        int i10 = 0;
        this.f24508f = false;
        this.f24509g = false;
        this.f24510h = false;
        l.g(drawableArr);
        this.f24505c = drawableArr;
        while (true) {
            Drawable[] drawableArr2 = this.f24505c;
            if (i10 < drawableArr2.length) {
                e.d(drawableArr2[i10], this, this);
                i10++;
            } else {
                this.f24506d = new c[drawableArr2.length];
                return;
            }
        }
    }

    private c a(int i10) {
        return new C0349a(i10);
    }

    public Drawable b(int i10) {
        boolean z10;
        boolean z11 = false;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        if (i10 < this.f24505c.length) {
            z11 = true;
        }
        l.b(Boolean.valueOf(z11));
        return this.f24505c[i10];
    }

    public void c(r rVar) {
        this.f24503a = rVar;
    }

    public c d(int i10) {
        boolean z10;
        boolean z11 = false;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        if (i10 < this.f24506d.length) {
            z11 = true;
        }
        l.b(Boolean.valueOf(z11));
        c[] cVarArr = this.f24506d;
        if (cVarArr[i10] == null) {
            cVarArr[i10] = a(i10);
        }
        return this.f24506d[i10];
    }

    public int e() {
        return this.f24505c.length;
    }

    public Drawable f(int i10, Drawable drawable) {
        boolean z10;
        boolean z11 = true;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        if (i10 >= this.f24505c.length) {
            z11 = false;
        }
        l.b(Boolean.valueOf(z11));
        Drawable drawable2 = this.f24505c[i10];
        if (drawable != drawable2) {
            if (drawable != null && this.f24510h) {
                drawable.mutate();
            }
            e.d(this.f24505c[i10], (Drawable.Callback) null, (r) null);
            e.d(drawable, (Drawable.Callback) null, (r) null);
            e.e(drawable, this.f24504b);
            e.a(drawable, this);
            e.d(drawable, this, this);
            this.f24509g = false;
            this.f24505c[i10] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    public void g(Matrix matrix) {
        r rVar = this.f24503a;
        if (rVar != null) {
            rVar.g(matrix);
        } else {
            matrix.reset();
        }
    }

    public int getIntrinsicHeight() {
        int i10 = 0;
        int i11 = -1;
        while (true) {
            Drawable[] drawableArr = this.f24505c;
            if (i10 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i10];
            if (drawable != null) {
                i11 = Math.max(i11, drawable.getIntrinsicHeight());
            }
            i10++;
        }
        if (i11 > 0) {
            return i11;
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        int i10 = 0;
        int i11 = -1;
        while (true) {
            Drawable[] drawableArr = this.f24505c;
            if (i10 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i10];
            if (drawable != null) {
                i11 = Math.max(i11, drawable.getIntrinsicWidth());
            }
            i10++;
        }
        if (i11 > 0) {
            return i11;
        }
        return -1;
    }

    public int getOpacity() {
        if (this.f24505c.length == 0) {
            return -2;
        }
        int i10 = 1;
        int i11 = -1;
        while (true) {
            Drawable[] drawableArr = this.f24505c;
            if (i10 >= drawableArr.length) {
                return i11;
            }
            Drawable drawable = drawableArr[i10];
            if (drawable != null) {
                i11 = Drawable.resolveOpacity(i11, drawable.getOpacity());
            }
            i10++;
        }
    }

    public boolean getPadding(Rect rect) {
        int i10 = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        Rect rect2 = this.f24507e;
        while (true) {
            Drawable[] drawableArr = this.f24505c;
            if (i10 >= drawableArr.length) {
                return true;
            }
            Drawable drawable = drawableArr[i10];
            if (drawable != null) {
                drawable.getPadding(rect2);
                rect.left = Math.max(rect.left, rect2.left);
                rect.top = Math.max(rect.top, rect2.top);
                rect.right = Math.max(rect.right, rect2.right);
                rect.bottom = Math.max(rect.bottom, rect2.bottom);
            }
            i10++;
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isStateful() {
        if (!this.f24509g) {
            this.f24508f = false;
            int i10 = 0;
            while (true) {
                Drawable[] drawableArr = this.f24505c;
                boolean z10 = true;
                if (i10 >= drawableArr.length) {
                    break;
                }
                Drawable drawable = drawableArr[i10];
                boolean z11 = this.f24508f;
                if (drawable == null || !drawable.isStateful()) {
                    z10 = false;
                }
                this.f24508f = z11 | z10;
                i10++;
            }
            this.f24509g = true;
        }
        return this.f24508f;
    }

    public void l(RectF rectF) {
        r rVar = this.f24503a;
        if (rVar != null) {
            rVar.l(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    public Drawable mutate() {
        int i10 = 0;
        while (true) {
            Drawable[] drawableArr = this.f24505c;
            if (i10 < drawableArr.length) {
                Drawable drawable = drawableArr[i10];
                if (drawable != null) {
                    drawable.mutate();
                }
                i10++;
            } else {
                this.f24510h = true;
                return this;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        int i10 = 0;
        while (true) {
            Drawable[] drawableArr = this.f24505c;
            if (i10 < drawableArr.length) {
                Drawable drawable = drawableArr[i10];
                if (drawable != null) {
                    drawable.setBounds(rect);
                }
                i10++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i10) {
        int i11 = 0;
        boolean z10 = false;
        while (true) {
            Drawable[] drawableArr = this.f24505c;
            if (i11 >= drawableArr.length) {
                return z10;
            }
            Drawable drawable = drawableArr[i11];
            if (drawable != null && drawable.setLevel(i10)) {
                z10 = true;
            }
            i11++;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int i10 = 0;
        boolean z10 = false;
        while (true) {
            Drawable[] drawableArr = this.f24505c;
            if (i10 >= drawableArr.length) {
                return z10;
            }
            Drawable drawable = drawableArr[i10];
            if (drawable != null && drawable.setState(iArr)) {
                z10 = true;
            }
            i10++;
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f24504b.c(colorFilter);
        int i10 = 0;
        while (true) {
            Drawable[] drawableArr = this.f24505c;
            if (i10 < drawableArr.length) {
                Drawable drawable = drawableArr[i10];
                if (drawable != null) {
                    drawable.setColorFilter(colorFilter);
                }
                i10++;
            } else {
                return;
            }
        }
    }

    public void setDither(boolean z10) {
        this.f24504b.d(z10);
        int i10 = 0;
        while (true) {
            Drawable[] drawableArr = this.f24505c;
            if (i10 < drawableArr.length) {
                Drawable drawable = drawableArr[i10];
                if (drawable != null) {
                    drawable.setDither(z10);
                }
                i10++;
            } else {
                return;
            }
        }
    }

    public void setFilterBitmap(boolean z10) {
        this.f24504b.e(z10);
        int i10 = 0;
        while (true) {
            Drawable[] drawableArr = this.f24505c;
            if (i10 < drawableArr.length) {
                Drawable drawable = drawableArr[i10];
                if (drawable != null) {
                    drawable.setFilterBitmap(z10);
                }
                i10++;
            } else {
                return;
            }
        }
    }

    public void setHotspot(float f10, float f11) {
        int i10 = 0;
        while (true) {
            Drawable[] drawableArr = this.f24505c;
            if (i10 < drawableArr.length) {
                Drawable drawable = drawableArr[i10];
                if (drawable != null) {
                    drawable.setHotspot(f10, f11);
                }
                i10++;
            } else {
                return;
            }
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        int i10 = 0;
        while (true) {
            Drawable[] drawableArr = this.f24505c;
            if (i10 >= drawableArr.length) {
                return visible;
            }
            Drawable drawable = drawableArr[i10];
            if (drawable != null) {
                drawable.setVisible(z10, z11);
            }
            i10++;
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
