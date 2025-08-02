package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import jb.d;
import jb.g;

public class TransformImageView extends AppCompatImageView {
    private int C;
    /* access modifiers changed from: private */
    public String N0;
    /* access modifiers changed from: private */
    public String O0;
    /* access modifiers changed from: private */
    public hb.b P0;

    /* renamed from: a  reason: collision with root package name */
    protected final float[] f11827a;

    /* renamed from: b  reason: collision with root package name */
    protected final float[] f11828b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f11829c;

    /* renamed from: d  reason: collision with root package name */
    protected Matrix f11830d;

    /* renamed from: e  reason: collision with root package name */
    protected int f11831e;

    /* renamed from: f  reason: collision with root package name */
    protected int f11832f;

    /* renamed from: g  reason: collision with root package name */
    protected b f11833g;

    /* renamed from: h  reason: collision with root package name */
    private float[] f11834h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f11835i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f11836j;

    /* renamed from: w  reason: collision with root package name */
    protected boolean f11837w;

    class a implements gb.b {
        a() {
        }

        public void a(Bitmap bitmap, hb.b bVar, String str, String str2) {
            String unused = TransformImageView.this.N0 = str;
            String unused2 = TransformImageView.this.O0 = str2;
            hb.b unused3 = TransformImageView.this.P0 = bVar;
            TransformImageView transformImageView = TransformImageView.this;
            transformImageView.f11836j = true;
            transformImageView.setImageBitmap(bitmap);
        }

        public void onFailure(Exception exc) {
            Log.e("TransformImageView", "onFailure: setImageUri", exc);
            b bVar = TransformImageView.this.f11833g;
            if (bVar != null) {
                bVar.c(exc);
            }
        }
    }

    public interface b {
        void a(float f10);

        void b();

        void c(Exception exc);

        void d(float f10);
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void m() {
        this.f11830d.mapPoints(this.f11827a, this.f11834h);
        this.f11830d.mapPoints(this.f11828b, this.f11835i);
    }

    public float d(Matrix matrix) {
        return (float) (-(Math.atan2((double) f(matrix, 1), (double) f(matrix, 0)) * 57.29577951308232d));
    }

    public float e(Matrix matrix) {
        return (float) Math.sqrt(Math.pow((double) f(matrix, 0), 2.0d) + Math.pow((double) f(matrix, 3), 2.0d));
    }

    /* access modifiers changed from: protected */
    public float f(Matrix matrix, int i10) {
        matrix.getValues(this.f11829c);
        return this.f11829c[i10];
    }

    /* access modifiers changed from: protected */
    public void g() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public float getCurrentAngle() {
        return d(this.f11830d);
    }

    public float getCurrentScale() {
        return e(this.f11830d);
    }

    public hb.b getExifInfo() {
        return this.P0;
    }

    public String getImageInputPath() {
        return this.N0;
    }

    public String getImageOutputPath() {
        return this.O0;
    }

    public int getMaxBitmapSize() {
        if (this.C <= 0) {
            this.C = jb.a.b(getContext());
        }
        return this.C;
    }

    @Nullable
    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof d)) {
            return null;
        }
        return ((d) getDrawable()).a();
    }

    /* access modifiers changed from: protected */
    public void h() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            Log.d("TransformImageView", String.format("Image size: [%d:%d]", new Object[]{Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)}));
            RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
            this.f11834h = g.b(rectF);
            this.f11835i = g.a(rectF);
            this.f11837w = true;
            b bVar = this.f11833g;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    public void i(float f10, float f11, float f12) {
        if (f10 != 0.0f) {
            this.f11830d.postRotate(f10, f11, f12);
            setImageMatrix(this.f11830d);
            b bVar = this.f11833g;
            if (bVar != null) {
                bVar.a(d(this.f11830d));
            }
        }
    }

    public void j(float f10, float f11, float f12) {
        if (f10 != 0.0f) {
            this.f11830d.postScale(f10, f10, f11, f12);
            setImageMatrix(this.f11830d);
            b bVar = this.f11833g;
            if (bVar != null) {
                bVar.d(e(this.f11830d));
            }
        }
    }

    public void k(float f10, float f11) {
        if (f10 != 0.0f || f11 != 0.0f) {
            this.f11830d.postTranslate(f10, f11);
            setImageMatrix(this.f11830d);
        }
    }

    public void l(Uri uri, Uri uri2) {
        int maxBitmapSize = getMaxBitmapSize();
        jb.a.d(getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, new a());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10 || (this.f11836j && !this.f11837w)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f11831e = (getWidth() - getPaddingRight()) - paddingLeft;
            this.f11832f = (getHeight() - getPaddingBottom()) - paddingTop;
            h();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new d(bitmap));
    }

    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.f11830d.set(matrix);
        m();
    }

    public void setMaxBitmapSize(int i10) {
        this.C = i10;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setTransformImageListener(b bVar) {
        this.f11833g = bVar;
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11827a = new float[8];
        this.f11828b = new float[2];
        this.f11829c = new float[9];
        this.f11830d = new Matrix();
        this.f11836j = false;
        this.f11837w = false;
        this.C = 0;
        g();
    }
}
