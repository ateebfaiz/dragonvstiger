package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R;

public class ImageFilterButton extends AppCompatImageButton {
    private float mCrossfade = 0.0f;
    private ImageFilterView.c mImageMatrix = new ImageFilterView.c();
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
            int width = ImageFilterButton.this.getWidth();
            int height = ImageFilterButton.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterButton.this.mRoundPercent) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.mRound);
        }
    }

    public ImageFilterButton(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
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
        ImageFilterView.c cVar = this.mImageMatrix;
        cVar.f14752d = f10;
        cVar.c(this);
    }

    public void setContrast(float f10) {
        ImageFilterView.c cVar = this.mImageMatrix;
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
        ImageFilterView.c cVar = this.mImageMatrix;
        cVar.f14753e = f10;
        cVar.c(this);
    }

    public void setWarmth(float f10) {
        ImageFilterView.c cVar = this.mImageMatrix;
        cVar.f14755g = f10;
        cVar.c(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(context, attributeSet);
    }
}
