package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;
    private static final float ARROW_HEAD_ANGLE = ((float) Math.toRadians(45.0d));
    private float mArrowHeadLength;
    private float mArrowShaftLength;
    private float mBarGap;
    private float mBarLength;
    private int mDirection = 2;
    private float mMaxCutForBarSize;
    private final Paint mPaint;
    private final Path mPath = new Path();
    private float mProgress;
    private final int mSize;
    private boolean mSpin;
    private boolean mVerticalMirror = false;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize((float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.mSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.mBarLength = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.mArrowHeadLength = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.mArrowShaftLength = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private static float lerp(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    public void draw(Canvas canvas) {
        float f10;
        float f11;
        int i10;
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        int i11 = this.mDirection;
        boolean z10 = false;
        if (i11 != 0 && (i11 == 1 || (i11 == 3 ? DrawableCompat.getLayoutDirection(this) == 0 : DrawableCompat.getLayoutDirection(this) == 1))) {
            z10 = true;
        }
        float f12 = this.mArrowHeadLength;
        float lerp = lerp(this.mBarLength, (float) Math.sqrt((double) (f12 * f12 * 2.0f)), this.mProgress);
        float lerp2 = lerp(this.mBarLength, this.mArrowShaftLength, this.mProgress);
        float round = (float) Math.round(lerp(0.0f, this.mMaxCutForBarSize, this.mProgress));
        float lerp3 = lerp(0.0f, ARROW_HEAD_ANGLE, this.mProgress);
        if (z10) {
            f10 = 0.0f;
        } else {
            f10 = -180.0f;
        }
        if (z10) {
            f11 = 180.0f;
        } else {
            f11 = 0.0f;
        }
        float lerp4 = lerp(f10, f11, this.mProgress);
        double d10 = (double) lerp;
        float f13 = lerp4;
        double d11 = (double) lerp3;
        boolean z11 = z10;
        float round2 = (float) Math.round(Math.cos(d11) * d10);
        float round3 = (float) Math.round(d10 * Math.sin(d11));
        this.mPath.rewind();
        float lerp5 = lerp(this.mBarGap + this.mPaint.getStrokeWidth(), -this.mMaxCutForBarSize, this.mProgress);
        float f14 = (-lerp2) / 2.0f;
        this.mPath.moveTo(f14 + round, 0.0f);
        this.mPath.rLineTo(lerp2 - (round * 2.0f), 0.0f);
        this.mPath.moveTo(f14, lerp5);
        this.mPath.rLineTo(round2, round3);
        this.mPath.moveTo(f14, -lerp5);
        this.mPath.rLineTo(round2, -round3);
        this.mPath.close();
        canvas.save();
        float strokeWidth = this.mPaint.getStrokeWidth();
        float height = ((float) bounds.height()) - (3.0f * strokeWidth);
        float f15 = this.mBarGap;
        canvas2.translate((float) bounds.centerX(), ((float) ((((int) (height - (2.0f * f15))) / 4) * 2)) + (strokeWidth * 1.5f) + f15);
        if (this.mSpin) {
            if (this.mVerticalMirror ^ z11) {
                i10 = -1;
            } else {
                i10 = 1;
            }
            canvas2.rotate(f13 * ((float) i10));
        } else if (z11) {
            canvas2.rotate(180.0f);
        }
        canvas2.drawPath(this.mPath, this.mPaint);
        canvas.restore();
    }

    public float getArrowHeadLength() {
        return this.mArrowHeadLength;
    }

    public float getArrowShaftLength() {
        return this.mArrowShaftLength;
    }

    public float getBarLength() {
        return this.mBarLength;
    }

    public float getBarThickness() {
        return this.mPaint.getStrokeWidth();
    }

    @ColorInt
    public int getColor() {
        return this.mPaint.getColor();
    }

    public int getDirection() {
        return this.mDirection;
    }

    public float getGapSize() {
        return this.mBarGap;
    }

    public int getIntrinsicHeight() {
        return this.mSize;
    }

    public int getIntrinsicWidth() {
        return this.mSize;
    }

    public int getOpacity() {
        return -3;
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.mProgress;
    }

    public boolean isSpinEnabled() {
        return this.mSpin;
    }

    public void setAlpha(int i10) {
        if (i10 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i10);
            invalidateSelf();
        }
    }

    public void setArrowHeadLength(float f10) {
        if (this.mArrowHeadLength != f10) {
            this.mArrowHeadLength = f10;
            invalidateSelf();
        }
    }

    public void setArrowShaftLength(float f10) {
        if (this.mArrowShaftLength != f10) {
            this.mArrowShaftLength = f10;
            invalidateSelf();
        }
    }

    public void setBarLength(float f10) {
        if (this.mBarLength != f10) {
            this.mBarLength = f10;
            invalidateSelf();
        }
    }

    public void setBarThickness(float f10) {
        if (this.mPaint.getStrokeWidth() != f10) {
            this.mPaint.setStrokeWidth(f10);
            this.mMaxCutForBarSize = (float) (((double) (f10 / 2.0f)) * Math.cos((double) ARROW_HEAD_ANGLE));
            invalidateSelf();
        }
    }

    public void setColor(@ColorInt int i10) {
        if (i10 != this.mPaint.getColor()) {
            this.mPaint.setColor(i10);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDirection(int i10) {
        if (i10 != this.mDirection) {
            this.mDirection = i10;
            invalidateSelf();
        }
    }

    public void setGapSize(float f10) {
        if (f10 != this.mBarGap) {
            this.mBarGap = f10;
            invalidateSelf();
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        if (this.mProgress != f10) {
            this.mProgress = f10;
            invalidateSelf();
        }
    }

    public void setSpinEnabled(boolean z10) {
        if (this.mSpin != z10) {
            this.mSpin = z10;
            invalidateSelf();
        }
    }

    public void setVerticalMirror(boolean z10) {
        if (this.mVerticalMirror != z10) {
            this.mVerticalMirror = z10;
            invalidateSelf();
        }
    }
}
