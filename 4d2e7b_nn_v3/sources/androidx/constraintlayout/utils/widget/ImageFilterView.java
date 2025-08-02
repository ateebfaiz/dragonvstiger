package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

public class ImageFilterView extends AppCompatImageView {
    private float mCrossfade = 0.0f;
    private c mImageMatrix = new c();
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay = true;
    private Path mPath;
    RectF mRect;
    /* access modifiers changed from: private */
    public float mRound = Float.NaN;
    /* access modifiers changed from: private */
    public float mRoundPercent = 0.0f;
    ViewOutlineProvider mViewOutlineProvider;

    class a extends ViewOutlineProvider {
        a() {
        }

        public void getOutline(View view, Outline outline) {
            int width = ImageFilterView.this.getWidth();
            int height = ImageFilterView.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterView.this.mRoundPercent) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.mRound);
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        float[] f14749a = new float[20];

        /* renamed from: b  reason: collision with root package name */
        ColorMatrix f14750b = new ColorMatrix();

        /* renamed from: c  reason: collision with root package name */
        ColorMatrix f14751c = new ColorMatrix();

        /* renamed from: d  reason: collision with root package name */
        float f14752d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        float f14753e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        float f14754f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        float f14755g = 1.0f;

        c() {
        }

        private void a(float f10) {
            float[] fArr = this.f14749a;
            fArr[0] = f10;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f10;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f10;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void b(float f10) {
            float f11 = 1.0f - f10;
            float f12 = 0.2999f * f11;
            float f13 = 0.587f * f11;
            float f14 = f11 * 0.114f;
            float[] fArr = this.f14749a;
            fArr[0] = f12 + f10;
            fArr[1] = f13;
            fArr[2] = f14;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f12;
            fArr[6] = f13 + f10;
            fArr[7] = f14;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f12;
            fArr[11] = f13;
            fArr[12] = f14 + f10;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void d(float f10) {
            float f11;
            float f12;
            float f13;
            if (f10 <= 0.0f) {
                f10 = 0.01f;
            }
            float f14 = (5000.0f / f10) / 100.0f;
            if (f14 > 66.0f) {
                double d10 = (double) (f14 - 60.0f);
                f12 = ((float) Math.pow(d10, -0.13320475816726685d)) * 329.69873f;
                f11 = ((float) Math.pow(d10, 0.07551484555006027d)) * 288.12216f;
            } else {
                f11 = (((float) Math.log((double) f14)) * 99.4708f) - 161.11957f;
                f12 = 255.0f;
            }
            if (f14 >= 66.0f) {
                f13 = 255.0f;
            } else if (f14 > 19.0f) {
                f13 = (((float) Math.log((double) (f14 - 10.0f))) * 138.51773f) - 305.0448f;
            } else {
                f13 = 0.0f;
            }
            float min = Math.min(255.0f, Math.max(f12, 0.0f));
            float min2 = Math.min(255.0f, Math.max(f11, 0.0f));
            float min3 = Math.min(255.0f, Math.max(f13, 0.0f));
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max((((float) Math.log((double) 50.0f)) * 99.4708f) - 161.11957f, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max((((float) Math.log((double) 40.0f)) * 138.51773f) - 305.0448f, 0.0f));
            float[] fArr = this.f14749a;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        /* access modifiers changed from: package-private */
        public void c(ImageView imageView) {
            boolean z10;
            this.f14750b.reset();
            float f10 = this.f14753e;
            boolean z11 = true;
            if (f10 != 1.0f) {
                b(f10);
                this.f14750b.set(this.f14749a);
                z10 = true;
            } else {
                z10 = false;
            }
            float f11 = this.f14754f;
            if (f11 != 1.0f) {
                this.f14751c.setScale(f11, f11, f11, 1.0f);
                this.f14750b.postConcat(this.f14751c);
                z10 = true;
            }
            float f12 = this.f14755g;
            if (f12 != 1.0f) {
                d(f12);
                this.f14751c.set(this.f14749a);
                this.f14750b.postConcat(this.f14751c);
                z10 = true;
            }
            float f13 = this.f14752d;
            if (f13 != 1.0f) {
                a(f13);
                this.f14751c.set(this.f14749a);
                this.f14750b.postConcat(this.f14751c);
            } else {
                z11 = z10;
            }
            if (z11) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f14750b));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.mCrossfade = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.mOverlay));
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                this.mLayers = drawableArr;
                drawableArr[0] = getDrawable();
                this.mLayers[1] = drawable;
                LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
                this.mLayer = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
                super.setImageDrawable(this.mLayer);
            }
        }
    }

    private void setOverlay(boolean z10) {
        this.mOverlay = z10;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.mImageMatrix.f14752d;
    }

    public float getContrast() {
        return this.mImageMatrix.f14754f;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getSaturation() {
        return this.mImageMatrix.f14753e;
    }

    public float getWarmth() {
        return this.mImageMatrix.f14755g;
    }

    public void setBrightness(float f10) {
        c cVar = this.mImageMatrix;
        cVar.f14752d = f10;
        cVar.c(this);
    }

    public void setContrast(float f10) {
        c cVar = this.mImageMatrix;
        cVar.f14754f = f10;
        cVar.c(this);
    }

    public void setCrossfade(float f10) {
        this.mCrossfade = f10;
        if (this.mLayers != null) {
            if (!this.mOverlay) {
                this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
            }
            this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
            super.setImageDrawable(this.mLayer);
        }
    }

    @RequiresApi(21)
    public void setRound(float f10) {
        boolean z10;
        if (Float.isNaN(f10)) {
            this.mRound = f10;
            float f11 = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            setRoundPercent(f11);
            return;
        }
        if (this.mRound != f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.mRound = f10;
        if (f10 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                b bVar = new b();
                this.mViewOutlineProvider = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.mRect.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.mPath.reset();
            Path path = this.mPath;
            RectF rectF = this.mRect;
            float f12 = this.mRound;
            path.addRoundRect(rectF, f12, f12, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f10) {
        boolean z10;
        if (this.mRoundPercent != f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.mRoundPercent = f10;
        if (f10 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                a aVar = new a();
                this.mViewOutlineProvider = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.mRoundPercent) / 2.0f;
            this.mRect.set(0.0f, 0.0f, (float) width, (float) height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f10) {
        c cVar = this.mImageMatrix;
        cVar.f14753e = f10;
        cVar.c(this);
    }

    public void setWarmth(float f10) {
        c cVar = this.mImageMatrix;
        cVar.f14755g = f10;
        cVar.c(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(context, attributeSet);
    }
}
