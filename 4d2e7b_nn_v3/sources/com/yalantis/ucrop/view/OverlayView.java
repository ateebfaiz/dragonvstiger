package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import fb.a;
import fb.b;
import fb.h;
import gb.d;
import jb.g;

public class OverlayView extends View {
    private boolean C;
    private boolean N0;
    private int O0;
    private Path P0;
    private Paint Q0;
    private Paint R0;
    private Paint S0;
    private Paint T0;
    private int U0;
    private float V0;
    private float W0;
    private int X0;
    private int Y0;
    private int Z0;

    /* renamed from: a  reason: collision with root package name */
    private final RectF f11813a;

    /* renamed from: a1  reason: collision with root package name */
    private int f11814a1;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f11815b;

    /* renamed from: b1  reason: collision with root package name */
    private d f11816b1;

    /* renamed from: c  reason: collision with root package name */
    protected int f11817c;

    /* renamed from: c1  reason: collision with root package name */
    private boolean f11818c1;

    /* renamed from: d  reason: collision with root package name */
    protected int f11819d;

    /* renamed from: e  reason: collision with root package name */
    protected float[] f11820e;

    /* renamed from: f  reason: collision with root package name */
    protected float[] f11821f;

    /* renamed from: g  reason: collision with root package name */
    private int f11822g;

    /* renamed from: h  reason: collision with root package name */
    private int f11823h;

    /* renamed from: i  reason: collision with root package name */
    private float f11824i;

    /* renamed from: j  reason: collision with root package name */
    private float[] f11825j;

    /* renamed from: w  reason: collision with root package name */
    private boolean f11826w;

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int c(float f10, float f11) {
        double d10 = (double) this.Y0;
        int i10 = -1;
        for (int i11 = 0; i11 < 8; i11 += 2) {
            double sqrt = Math.sqrt(Math.pow((double) (f10 - this.f11820e[i11]), 2.0d) + Math.pow((double) (f11 - this.f11820e[i11 + 1]), 2.0d));
            if (sqrt < d10) {
                i10 = i11 / 2;
                d10 = sqrt;
            }
        }
        if (this.U0 != 1 || i10 >= 0 || !this.f11813a.contains(f10, f11)) {
            return i10;
        }
        return 4;
    }

    private void e(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(h.f12143a0, getResources().getDimensionPixelSize(b.f12095a));
        int color = typedArray.getColor(h.Z, getResources().getColor(a.f12084c));
        this.S0.setStrokeWidth((float) dimensionPixelSize);
        this.S0.setColor(color);
        Paint paint = this.S0;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.T0.setStrokeWidth((float) (dimensionPixelSize * 3));
        this.T0.setColor(color);
        this.T0.setStyle(style);
    }

    private void f(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(h.f12151e0, getResources().getDimensionPixelSize(b.f12096b));
        int color = typedArray.getColor(h.f12145b0, getResources().getColor(a.f12085d));
        this.R0.setStrokeWidth((float) dimensionPixelSize);
        this.R0.setColor(color);
        this.f11822g = typedArray.getInt(h.f12149d0, 2);
        this.f11823h = typedArray.getInt(h.f12147c0, 2);
    }

    private void i(float f10, float f11) {
        boolean z10;
        float f12;
        float f13;
        float f14;
        float f15;
        this.f11815b.set(this.f11813a);
        int i10 = this.X0;
        boolean z11 = true;
        if (i10 == 0) {
            RectF rectF = this.f11815b;
            RectF rectF2 = this.f11813a;
            rectF.set(f10, f11, rectF2.right, rectF2.bottom);
        } else if (i10 == 1) {
            RectF rectF3 = this.f11815b;
            RectF rectF4 = this.f11813a;
            rectF3.set(rectF4.left, f11, f10, rectF4.bottom);
        } else if (i10 == 2) {
            RectF rectF5 = this.f11815b;
            RectF rectF6 = this.f11813a;
            rectF5.set(rectF6.left, rectF6.top, f10, f11);
        } else if (i10 == 3) {
            RectF rectF7 = this.f11815b;
            RectF rectF8 = this.f11813a;
            rectF7.set(f10, rectF8.top, rectF8.right, f11);
        } else if (i10 == 4) {
            this.f11815b.offset(f10 - this.V0, f11 - this.W0);
            if (this.f11815b.left > ((float) getLeft()) && this.f11815b.top > ((float) getTop()) && this.f11815b.right < ((float) getRight()) && this.f11815b.bottom < ((float) getBottom())) {
                this.f11813a.set(this.f11815b);
                j();
                postInvalidate();
                return;
            }
            return;
        }
        if (this.f11815b.height() >= ((float) this.Z0)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f11815b.width() < ((float) this.Z0)) {
            z11 = false;
        }
        RectF rectF9 = this.f11813a;
        if (z11) {
            f12 = this.f11815b.left;
        } else {
            f12 = rectF9.left;
        }
        if (z10) {
            f13 = this.f11815b.top;
        } else {
            f13 = rectF9.top;
        }
        if (z11) {
            f14 = this.f11815b.right;
        } else {
            f14 = rectF9.right;
        }
        if (z10) {
            f15 = this.f11815b.bottom;
        } else {
            f15 = rectF9.bottom;
        }
        rectF9.set(f12, f13, f14, f15);
        if (z10 || z11) {
            j();
            postInvalidate();
        }
    }

    private void j() {
        this.f11820e = g.b(this.f11813a);
        this.f11821f = g.a(this.f11813a);
        this.f11825j = null;
        this.P0.reset();
        this.P0.addCircle(this.f11813a.centerX(), this.f11813a.centerY(), Math.min(this.f11813a.width(), this.f11813a.height()) / 2.0f, Path.Direction.CW);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas) {
        if (this.C) {
            if (this.f11825j == null && !this.f11813a.isEmpty()) {
                this.f11825j = new float[((this.f11822g * 4) + (this.f11823h * 4))];
                int i10 = 0;
                for (int i11 = 0; i11 < this.f11822g; i11++) {
                    float[] fArr = this.f11825j;
                    RectF rectF = this.f11813a;
                    fArr[i10] = rectF.left;
                    float f10 = ((float) i11) + 1.0f;
                    float height = rectF.height() * (f10 / ((float) (this.f11822g + 1)));
                    RectF rectF2 = this.f11813a;
                    fArr[i10 + 1] = height + rectF2.top;
                    float[] fArr2 = this.f11825j;
                    int i12 = i10 + 3;
                    fArr2[i10 + 2] = rectF2.right;
                    i10 += 4;
                    fArr2[i12] = (rectF2.height() * (f10 / ((float) (this.f11822g + 1)))) + this.f11813a.top;
                }
                for (int i13 = 0; i13 < this.f11823h; i13++) {
                    float[] fArr3 = this.f11825j;
                    float f11 = ((float) i13) + 1.0f;
                    float width = this.f11813a.width() * (f11 / ((float) (this.f11823h + 1)));
                    RectF rectF3 = this.f11813a;
                    fArr3[i10] = width + rectF3.left;
                    float[] fArr4 = this.f11825j;
                    fArr4[i10 + 1] = rectF3.top;
                    int i14 = i10 + 3;
                    float width2 = rectF3.width() * (f11 / ((float) (this.f11823h + 1)));
                    RectF rectF4 = this.f11813a;
                    fArr4[i10 + 2] = width2 + rectF4.left;
                    i10 += 4;
                    this.f11825j[i14] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.f11825j;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.R0);
            }
        }
        if (this.f11826w) {
            canvas.drawRect(this.f11813a, this.S0);
        }
        if (this.U0 != 0) {
            canvas.save();
            this.f11815b.set(this.f11813a);
            RectF rectF5 = this.f11815b;
            int i15 = this.f11814a1;
            rectF5.inset((float) i15, (float) (-i15));
            RectF rectF6 = this.f11815b;
            Region.Op op = Region.Op.DIFFERENCE;
            canvas.clipRect(rectF6, op);
            this.f11815b.set(this.f11813a);
            RectF rectF7 = this.f11815b;
            int i16 = this.f11814a1;
            rectF7.inset((float) (-i16), (float) i16);
            canvas.clipRect(this.f11815b, op);
            canvas.drawRect(this.f11813a, this.T0);
            canvas.restore();
        }
    }

    /* access modifiers changed from: protected */
    public void b(Canvas canvas) {
        canvas.save();
        if (this.N0) {
            canvas.clipPath(this.P0, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.f11813a, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.O0);
        canvas.restore();
        if (this.N0) {
            canvas.drawCircle(this.f11813a.centerX(), this.f11813a.centerY(), Math.min(this.f11813a.width(), this.f11813a.height()) / 2.0f, this.Q0);
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
    }

    /* access modifiers changed from: protected */
    public void g(TypedArray typedArray) {
        this.N0 = typedArray.getBoolean(h.X, false);
        int color = typedArray.getColor(h.Y, getResources().getColor(a.f12086e));
        this.O0 = color;
        this.Q0.setColor(color);
        this.Q0.setStyle(Paint.Style.STROKE);
        this.Q0.setStrokeWidth(1.0f);
        e(typedArray);
        this.f11826w = typedArray.getBoolean(h.f12153f0, true);
        f(typedArray);
        this.C = typedArray.getBoolean(h.f12155g0, true);
    }

    @NonNull
    public RectF getCropViewRect() {
        return this.f11813a;
    }

    public int getFreestyleCropMode() {
        return this.U0;
    }

    public d getOverlayViewChangeListener() {
        return this.f11816b1;
    }

    public void h() {
        int i10 = this.f11817c;
        float f10 = this.f11824i;
        int i11 = (int) (((float) i10) / f10);
        int i12 = this.f11819d;
        if (i11 > i12) {
            int i13 = (int) (((float) i12) * f10);
            int i14 = (i10 - i13) / 2;
            this.f11813a.set((float) (getPaddingLeft() + i14), (float) getPaddingTop(), (float) (getPaddingLeft() + i13 + i14), (float) (getPaddingTop() + this.f11819d));
        } else {
            int i15 = (i12 - i11) / 2;
            this.f11813a.set((float) getPaddingLeft(), (float) (getPaddingTop() + i15), (float) (getPaddingLeft() + this.f11817c), (float) (getPaddingTop() + i11 + i15));
        }
        d dVar = this.f11816b1;
        if (dVar != null) {
            dVar.a(this.f11813a);
        }
        j();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b(canvas);
        a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f11817c = (getWidth() - getPaddingRight()) - paddingLeft;
            this.f11819d = (getHeight() - getPaddingBottom()) - paddingTop;
            if (this.f11818c1) {
                this.f11818c1 = false;
                setTargetAspectRatio(this.f11824i);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10 = false;
        if (!this.f11813a.isEmpty() && this.U0 != 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                int c10 = c(x10, y10);
                this.X0 = c10;
                if (c10 != -1) {
                    z10 = true;
                }
                if (!z10) {
                    this.V0 = -1.0f;
                    this.W0 = -1.0f;
                } else if (this.V0 < 0.0f) {
                    this.V0 = x10;
                    this.W0 = y10;
                }
                return z10;
            } else if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.X0 != -1) {
                float min = Math.min(Math.max(x10, (float) getPaddingLeft()), (float) (getWidth() - getPaddingRight()));
                float min2 = Math.min(Math.max(y10, (float) getPaddingTop()), (float) (getHeight() - getPaddingBottom()));
                i(min, min2);
                this.V0 = min;
                this.W0 = min2;
                return true;
            } else if ((motionEvent.getAction() & 255) == 1) {
                this.V0 = -1.0f;
                this.W0 = -1.0f;
                this.X0 = -1;
                d dVar = this.f11816b1;
                if (dVar != null) {
                    dVar.a(this.f11813a);
                }
            }
        }
        return false;
    }

    public void setCircleDimmedLayer(boolean z10) {
        this.N0 = z10;
    }

    public void setCropFrameColor(@ColorInt int i10) {
        this.S0.setColor(i10);
    }

    public void setCropFrameStrokeWidth(@IntRange(from = 0) int i10) {
        this.S0.setStrokeWidth((float) i10);
    }

    public void setCropGridColor(@ColorInt int i10) {
        this.R0.setColor(i10);
    }

    public void setCropGridColumnCount(@IntRange(from = 0) int i10) {
        this.f11823h = i10;
        this.f11825j = null;
    }

    public void setCropGridCornerColor(@ColorInt int i10) {
        this.T0.setColor(i10);
    }

    public void setCropGridRowCount(@IntRange(from = 0) int i10) {
        this.f11822g = i10;
        this.f11825j = null;
    }

    public void setCropGridStrokeWidth(@IntRange(from = 0) int i10) {
        this.R0.setStrokeWidth((float) i10);
    }

    public void setDimmedColor(@ColorInt int i10) {
        this.O0 = i10;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z10) {
        this.U0 = z10 ? 1 : 0;
    }

    public void setFreestyleCropMode(int i10) {
        this.U0 = i10;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(d dVar) {
        this.f11816b1 = dVar;
    }

    public void setShowCropFrame(boolean z10) {
        this.f11826w = z10;
    }

    public void setShowCropGrid(boolean z10) {
        this.C = z10;
    }

    public void setTargetAspectRatio(float f10) {
        this.f11824i = f10;
        if (this.f11817c > 0) {
            h();
            postInvalidate();
            return;
        }
        this.f11818c1 = true;
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11813a = new RectF();
        this.f11815b = new RectF();
        this.f11825j = null;
        this.P0 = new Path();
        this.Q0 = new Paint(1);
        this.R0 = new Paint(1);
        this.S0 = new Paint(1);
        this.T0 = new Paint(1);
        this.U0 = 0;
        this.V0 = -1.0f;
        this.W0 = -1.0f;
        this.X0 = -1;
        this.Y0 = getResources().getDimensionPixelSize(b.f12098d);
        this.Z0 = getResources().getDimensionPixelSize(b.f12099e);
        this.f11814a1 = getResources().getDimensionPixelSize(b.f12097c);
        d();
    }
}
