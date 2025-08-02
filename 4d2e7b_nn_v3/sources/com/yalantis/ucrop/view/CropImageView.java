package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.view.TransformImageView;
import fb.h;
import gb.c;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import jb.g;

public class CropImageView extends TransformImageView {
    /* access modifiers changed from: private */
    public final RectF Q0;
    private final Matrix R0;
    private float S0;
    private float T0;
    private c U0;
    private Runnable V0;
    private Runnable W0;
    private float X0;
    private float Y0;
    private int Z0;

    /* renamed from: a1  reason: collision with root package name */
    private int f11783a1;

    /* renamed from: b1  reason: collision with root package name */
    private long f11784b1;

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference f11785a;

        /* renamed from: b  reason: collision with root package name */
        private final long f11786b;

        /* renamed from: c  reason: collision with root package name */
        private final long f11787c = System.currentTimeMillis();

        /* renamed from: d  reason: collision with root package name */
        private final float f11788d;

        /* renamed from: e  reason: collision with root package name */
        private final float f11789e;

        /* renamed from: f  reason: collision with root package name */
        private final float f11790f;

        /* renamed from: g  reason: collision with root package name */
        private final float f11791g;

        /* renamed from: h  reason: collision with root package name */
        private final float f11792h;

        /* renamed from: i  reason: collision with root package name */
        private final float f11793i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f11794j;

        public a(CropImageView cropImageView, long j10, float f10, float f11, float f12, float f13, float f14, float f15, boolean z10) {
            this.f11785a = new WeakReference(cropImageView);
            this.f11786b = j10;
            this.f11788d = f10;
            this.f11789e = f11;
            this.f11790f = f12;
            this.f11791g = f13;
            this.f11792h = f14;
            this.f11793i = f15;
            this.f11794j = z10;
        }

        public void run() {
            CropImageView cropImageView = (CropImageView) this.f11785a.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.f11786b, System.currentTimeMillis() - this.f11787c);
                float b10 = jb.b.b(min, 0.0f, this.f11790f, (float) this.f11786b);
                float b11 = jb.b.b(min, 0.0f, this.f11791g, (float) this.f11786b);
                float a10 = jb.b.a(min, 0.0f, this.f11793i, (float) this.f11786b);
                if (min < ((float) this.f11786b)) {
                    float[] fArr = cropImageView.f11828b;
                    cropImageView.k(b10 - (fArr[0] - this.f11788d), b11 - (fArr[1] - this.f11789e));
                    if (!this.f11794j) {
                        cropImageView.B(this.f11792h + a10, cropImageView.Q0.centerX(), cropImageView.Q0.centerY());
                    }
                    if (!cropImageView.t()) {
                        cropImageView.post(this);
                    }
                }
            }
        }
    }

    private static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference f11795a;

        /* renamed from: b  reason: collision with root package name */
        private final long f11796b;

        /* renamed from: c  reason: collision with root package name */
        private final long f11797c = System.currentTimeMillis();

        /* renamed from: d  reason: collision with root package name */
        private final float f11798d;

        /* renamed from: e  reason: collision with root package name */
        private final float f11799e;

        /* renamed from: f  reason: collision with root package name */
        private final float f11800f;

        /* renamed from: g  reason: collision with root package name */
        private final float f11801g;

        public b(CropImageView cropImageView, long j10, float f10, float f11, float f12, float f13) {
            this.f11795a = new WeakReference(cropImageView);
            this.f11796b = j10;
            this.f11798d = f10;
            this.f11799e = f11;
            this.f11800f = f12;
            this.f11801g = f13;
        }

        public void run() {
            CropImageView cropImageView = (CropImageView) this.f11795a.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.f11796b, System.currentTimeMillis() - this.f11797c);
                float a10 = jb.b.a(min, 0.0f, this.f11799e, (float) this.f11796b);
                if (min < ((float) this.f11796b)) {
                    cropImageView.B(this.f11798d + a10, this.f11800f, this.f11801g);
                    cropImageView.post(this);
                    return;
                }
                cropImageView.x();
            }
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private float[] o() {
        this.R0.reset();
        this.R0.setRotate(-getCurrentAngle());
        float[] fArr = this.f11827a;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        float[] b10 = g.b(this.Q0);
        this.R0.mapPoints(copyOf);
        this.R0.mapPoints(b10);
        RectF d10 = g.d(copyOf);
        RectF d11 = g.d(b10);
        float f10 = d10.left - d11.left;
        float f11 = d10.top - d11.top;
        float f12 = d10.right - d11.right;
        float f13 = d10.bottom - d11.bottom;
        if (f10 <= 0.0f) {
            f10 = 0.0f;
        }
        if (f11 <= 0.0f) {
            f11 = 0.0f;
        }
        if (f12 >= 0.0f) {
            f12 = 0.0f;
        }
        if (f13 >= 0.0f) {
            f13 = 0.0f;
        }
        float[] fArr2 = {f10, f11, f12, f13};
        this.R0.reset();
        this.R0.setRotate(getCurrentAngle());
        this.R0.mapPoints(fArr2);
        return fArr2;
    }

    private void p() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            q((float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        }
    }

    private void q(float f10, float f11) {
        float min = Math.min(Math.min(this.Q0.width() / f10, this.Q0.width() / f11), Math.min(this.Q0.height() / f11, this.Q0.height() / f10));
        this.Y0 = min;
        this.X0 = min * this.T0;
    }

    private void y(float f10, float f11) {
        float width = this.Q0.width();
        float height = this.Q0.height();
        float max = Math.max(this.Q0.width() / f10, this.Q0.height() / f11);
        RectF rectF = this.Q0;
        float f12 = ((height - (f11 * max)) / 2.0f) + rectF.top;
        this.f11830d.reset();
        this.f11830d.postScale(max, max);
        this.f11830d.postTranslate(((width - (f10 * max)) / 2.0f) + rectF.left, f12);
        setImageMatrix(this.f11830d);
    }

    public void A(float f10) {
        B(f10, this.Q0.centerX(), this.Q0.centerY());
    }

    public void B(float f10, float f11, float f12) {
        if (f10 <= getMaxScale()) {
            j(f10 / getCurrentScale(), f11, f12);
        }
    }

    public void C(float f10) {
        D(f10, this.Q0.centerX(), this.Q0.centerY());
    }

    public void D(float f10, float f11, float f12) {
        if (f10 >= getMinScale()) {
            j(f10 / getCurrentScale(), f11, f12);
        }
    }

    @Nullable
    public c getCropBoundsChangeListener() {
        return this.U0;
    }

    public float getMaxScale() {
        return this.X0;
    }

    public float getMinScale() {
        return this.Y0;
    }

    public float getTargetAspectRatio() {
        return this.S0;
    }

    /* access modifiers changed from: protected */
    public void h() {
        super.h();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            if (this.S0 == 0.0f) {
                this.S0 = intrinsicWidth / intrinsicHeight;
            }
            int i10 = this.f11831e;
            float f10 = this.S0;
            int i11 = (int) (((float) i10) / f10);
            int i12 = this.f11832f;
            if (i11 > i12) {
                int i13 = (int) (((float) i12) * f10);
                int i14 = (i10 - i13) / 2;
                this.Q0.set((float) i14, 0.0f, (float) (i13 + i14), (float) i12);
            } else {
                int i15 = (i12 - i11) / 2;
                this.Q0.set(0.0f, (float) i15, (float) i10, (float) (i11 + i15));
            }
            q(intrinsicWidth, intrinsicHeight);
            y(intrinsicWidth, intrinsicHeight);
            c cVar = this.U0;
            if (cVar != null) {
                cVar.a(this.S0);
            }
            TransformImageView.b bVar = this.f11833g;
            if (bVar != null) {
                bVar.d(getCurrentScale());
                this.f11833g.a(getCurrentAngle());
            }
        }
    }

    public void j(float f10, float f11, float f12) {
        if (f10 > 1.0f && getCurrentScale() * f10 <= getMaxScale()) {
            super.j(f10, f11, f12);
        } else if (f10 < 1.0f && getCurrentScale() * f10 >= getMinScale()) {
            super.j(f10, f11, f12);
        }
    }

    public void r() {
        removeCallbacks(this.V0);
        removeCallbacks(this.W0);
    }

    public void s(Bitmap.CompressFormat compressFormat, int i10, gb.a aVar) {
        r();
        setImageToWrapCropBounds(false);
        new BitmapCropTask(getViewBitmap(), new hb.c(this.Q0, g.d(this.f11827a), getCurrentScale(), getCurrentAngle()), new hb.a(this.Z0, this.f11783a1, compressFormat, i10, getImageInputPath(), getImageOutputPath(), getExifInfo()), aVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void setCropBoundsChangeListener(@Nullable c cVar) {
        this.U0 = cVar;
    }

    public void setCropRect(RectF rectF) {
        this.S0 = rectF.width() / rectF.height();
        this.Q0.set(rectF.left - ((float) getPaddingLeft()), rectF.top - ((float) getPaddingTop()), rectF.right - ((float) getPaddingRight()), rectF.bottom - ((float) getPaddingBottom()));
        p();
        x();
    }

    public void setImageToWrapCropBounds(boolean z10) {
        float f10;
        float f11;
        float f12;
        if (this.f11837w && !t()) {
            float[] fArr = this.f11828b;
            float f13 = fArr[0];
            float f14 = fArr[1];
            float currentScale = getCurrentScale();
            float centerX = this.Q0.centerX() - f13;
            float centerY = this.Q0.centerY() - f14;
            this.R0.reset();
            this.R0.setTranslate(centerX, centerY);
            float[] fArr2 = this.f11827a;
            float[] copyOf = Arrays.copyOf(fArr2, fArr2.length);
            this.R0.mapPoints(copyOf);
            boolean u10 = u(copyOf);
            if (u10) {
                float[] o10 = o();
                f11 = -(o10[1] + o10[3]);
                f12 = -(o10[0] + o10[2]);
                f10 = 0.0f;
            } else {
                RectF rectF = new RectF(this.Q0);
                this.R0.reset();
                this.R0.setRotate(getCurrentAngle());
                this.R0.mapRect(rectF);
                float[] c10 = g.c(this.f11827a);
                f12 = centerX;
                f10 = (Math.max(rectF.width() / c10[0], rectF.height() / c10[1]) * currentScale) - currentScale;
                f11 = centerY;
            }
            if (z10) {
                a aVar = new a(this, this.f11784b1, f13, f14, f12, f11, currentScale, f10, u10);
                this.V0 = aVar;
                post(aVar);
                return;
            }
            k(f12, f11);
            if (!u10) {
                B(currentScale + f10, this.Q0.centerX(), this.Q0.centerY());
            }
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(@IntRange(from = 100) long j10) {
        if (j10 > 0) {
            this.f11784b1 = j10;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxResultImageSizeX(@IntRange(from = 10) int i10) {
        this.Z0 = i10;
    }

    public void setMaxResultImageSizeY(@IntRange(from = 10) int i10) {
        this.f11783a1 = i10;
    }

    public void setMaxScaleMultiplier(float f10) {
        this.T0 = f10;
    }

    public void setTargetAspectRatio(float f10) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.S0 = f10;
            return;
        }
        if (f10 == 0.0f) {
            this.S0 = ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
        } else {
            this.S0 = f10;
        }
        c cVar = this.U0;
        if (cVar != null) {
            cVar.a(this.S0);
        }
    }

    /* access modifiers changed from: protected */
    public boolean t() {
        return u(this.f11827a);
    }

    /* access modifiers changed from: protected */
    public boolean u(float[] fArr) {
        this.R0.reset();
        this.R0.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        this.R0.mapPoints(copyOf);
        float[] b10 = g.b(this.Q0);
        this.R0.mapPoints(b10);
        return g.d(copyOf).contains(g.d(b10));
    }

    public void v(float f10) {
        i(f10, this.Q0.centerX(), this.Q0.centerY());
    }

    /* access modifiers changed from: protected */
    public void w(TypedArray typedArray) {
        float abs = Math.abs(typedArray.getFloat(h.V, 0.0f));
        float abs2 = Math.abs(typedArray.getFloat(h.W, 0.0f));
        if (abs == 0.0f || abs2 == 0.0f) {
            this.S0 = 0.0f;
        } else {
            this.S0 = abs / abs2;
        }
    }

    public void x() {
        setImageToWrapCropBounds(true);
    }

    /* access modifiers changed from: protected */
    public void z(float f10, float f11, float f12, long j10) {
        if (f10 > getMaxScale()) {
            f10 = getMaxScale();
        }
        float currentScale = getCurrentScale();
        b bVar = new b(this, j10, currentScale, f10 - currentScale, f11, f12);
        this.W0 = bVar;
        post(bVar);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.Q0 = new RectF();
        this.R0 = new Matrix();
        this.T0 = 10.0f;
        this.W0 = null;
        this.Z0 = 0;
        this.f11783a1 = 0;
        this.f11784b1 = 500;
    }
}
