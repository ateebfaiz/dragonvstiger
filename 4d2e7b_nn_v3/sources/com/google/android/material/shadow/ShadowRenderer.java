package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ShadowRenderer {
    private static final int COLOR_ALPHA_END = 0;
    private static final int COLOR_ALPHA_MIDDLE = 20;
    private static final int COLOR_ALPHA_START = 68;
    private static final int[] cornerColors = new int[4];
    private static final float[] cornerPositions = {0.0f, 0.0f, 0.5f, 1.0f};
    private static final int[] edgeColors = new int[3];
    private static final float[] edgePositions = {0.0f, 0.5f, 1.0f};
    @NonNull
    private final Paint cornerShadowPaint;
    @NonNull
    private final Paint edgeShadowPaint;
    private final Path scratch;
    private int shadowEndColor;
    private int shadowMiddleColor;
    @NonNull
    private final Paint shadowPaint;
    private int shadowStartColor;
    private Paint transparentPaint;

    public ShadowRenderer() {
        this(ViewCompat.MEASURED_STATE_MASK);
    }

    public void drawCornerShadow(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i10, float f10, float f11) {
        boolean z10;
        Canvas canvas2 = canvas;
        RectF rectF2 = rectF;
        int i11 = i10;
        float f12 = f11;
        if (f12 < 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        Path path = this.scratch;
        if (z10) {
            int[] iArr = cornerColors;
            iArr[0] = 0;
            iArr[1] = this.shadowEndColor;
            iArr[2] = this.shadowMiddleColor;
            iArr[3] = this.shadowStartColor;
            float f13 = f10;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF2, f10, f12);
            path.close();
            float f14 = (float) (-i11);
            rectF2.inset(f14, f14);
            int[] iArr2 = cornerColors;
            iArr2[0] = 0;
            iArr2[1] = this.shadowStartColor;
            iArr2[2] = this.shadowMiddleColor;
            iArr2[3] = this.shadowEndColor;
        }
        float width = rectF.width() / 2.0f;
        if (width > 0.0f) {
            float f15 = 1.0f - (((float) i11) / width);
            float[] fArr = cornerPositions;
            fArr[1] = f15;
            fArr[2] = ((1.0f - f15) / 2.0f) + f15;
            this.cornerShadowPaint.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, cornerColors, fArr, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            canvas2.scale(1.0f, rectF.height() / rectF.width());
            if (!z10) {
                canvas2.clipPath(path, Region.Op.DIFFERENCE);
                canvas2.drawPath(path, this.transparentPaint);
            }
            canvas.drawArc(rectF, f10, f11, true, this.cornerShadowPaint);
            canvas.restore();
        }
    }

    public void drawEdgeShadow(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i10) {
        rectF.bottom += (float) i10;
        rectF.offset(0.0f, (float) (-i10));
        int[] iArr = edgeColors;
        iArr[0] = this.shadowEndColor;
        iArr[1] = this.shadowMiddleColor;
        iArr[2] = this.shadowStartColor;
        Paint paint = this.edgeShadowPaint;
        float f10 = rectF.left;
        paint.setShader(new LinearGradient(f10, rectF.top, f10, rectF.bottom, iArr, edgePositions, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.edgeShadowPaint);
        canvas.restore();
    }

    @NonNull
    public Paint getShadowPaint() {
        return this.shadowPaint;
    }

    public void setShadowColor(int i10) {
        this.shadowStartColor = ColorUtils.setAlphaComponent(i10, COLOR_ALPHA_START);
        this.shadowMiddleColor = ColorUtils.setAlphaComponent(i10, 20);
        this.shadowEndColor = ColorUtils.setAlphaComponent(i10, 0);
        this.shadowPaint.setColor(this.shadowStartColor);
    }

    public ShadowRenderer(int i10) {
        this.scratch = new Path();
        this.transparentPaint = new Paint();
        this.shadowPaint = new Paint();
        setShadowColor(i10);
        this.transparentPaint.setColor(0);
        Paint paint = new Paint(4);
        this.cornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.edgeShadowPaint = new Paint(paint);
    }
}
