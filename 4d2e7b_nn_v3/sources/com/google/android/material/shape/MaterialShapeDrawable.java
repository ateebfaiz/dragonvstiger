package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.ShapePath;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private static final String TAG = "MaterialShapeDrawable";
    private static final Paint clearPaint;
    /* access modifiers changed from: private */
    public final BitSet containsIncompatibleShadowOp;
    /* access modifiers changed from: private */
    public final ShapePath.d[] cornerShadowOperation;
    private c drawableState;
    /* access modifiers changed from: private */
    public final ShapePath.d[] edgeShadowOperation;
    private final Paint fillPaint;
    private final RectF insetRectF;
    private final Matrix matrix;
    private final Path path;
    @NonNull
    private final RectF pathBounds;
    /* access modifiers changed from: private */
    public boolean pathDirty;
    private final Path pathInsetByStroke;
    private final ShapeAppearancePathProvider pathProvider;
    @NonNull
    private final ShapeAppearancePathProvider.PathListener pathShadowListener;
    private final RectF rectF;
    private int resolvedTintColor;
    private final Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final ShadowRenderer shadowRenderer;
    private final Paint strokePaint;
    private ShapeAppearanceModel strokeShapeAppearance;
    @Nullable
    private PorterDuffColorFilter strokeTintFilter;
    @Nullable
    private PorterDuffColorFilter tintFilter;
    private final Region transparentRegion;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    class a implements ShapeAppearancePathProvider.PathListener {
        a() {
        }

        public void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i10) {
            MaterialShapeDrawable.this.containsIncompatibleShadowOp.set(i10, shapePath.containsIncompatibleShadowOp());
            MaterialShapeDrawable.this.cornerShadowOperation[i10] = shapePath.createShadowCompatOperation(matrix);
        }

        public void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i10) {
            MaterialShapeDrawable.this.containsIncompatibleShadowOp.set(i10 + 4, shapePath.containsIncompatibleShadowOp());
            MaterialShapeDrawable.this.edgeShadowOperation[i10] = shapePath.createShadowCompatOperation(matrix);
        }
    }

    class b implements ShapeAppearanceModel.CornerSizeUnaryOperator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f8436a;

        b(float f10) {
            this.f8436a = f10;
        }

        public CornerSize apply(CornerSize cornerSize) {
            if (cornerSize instanceof RelativeCornerSize) {
                return cornerSize;
            }
            return new AdjustedCornerSize(this.f8436a, cornerSize);
        }
    }

    static {
        Paint paint = new Paint(1);
        clearPaint = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* synthetic */ MaterialShapeDrawable(c cVar, a aVar) {
        this(cVar);
    }

    @Nullable
    private PorterDuffColorFilter calculatePaintColorTintFilter(@NonNull Paint paint, boolean z10) {
        if (!z10) {
            return null;
        }
        int color = paint.getColor();
        int compositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(color);
        this.resolvedTintColor = compositeElevationOverlayIfNeeded;
        if (compositeElevationOverlayIfNeeded != color) {
            return new PorterDuffColorFilter(compositeElevationOverlayIfNeeded, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private void calculatePath(@NonNull RectF rectF2, @NonNull Path path2) {
        calculatePathForSize(rectF2, path2);
        if (this.drawableState.f8447j != 1.0f) {
            this.matrix.reset();
            Matrix matrix2 = this.matrix;
            float f10 = this.drawableState.f8447j;
            matrix2.setScale(f10, f10, rectF2.width() / 2.0f, rectF2.height() / 2.0f);
            path2.transform(this.matrix);
        }
        path2.computeBounds(this.pathBounds, true);
    }

    private void calculateStrokePath() {
        ShapeAppearanceModel withTransformedCornerSizes = getShapeAppearanceModel().withTransformedCornerSizes(new b(-getStrokeInsetLength()));
        this.strokeShapeAppearance = withTransformedCornerSizes;
        this.pathProvider.calculatePath(withTransformedCornerSizes, this.drawableState.f8448k, getBoundsInsetByStroke(), this.pathInsetByStroke);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintColorTintFilter(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z10) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z10) {
            colorForState = compositeElevationOverlayIfNeeded(colorForState);
        }
        this.resolvedTintColor = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintFilter(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z10) {
        if (colorStateList == null || mode == null) {
            return calculatePaintColorTintFilter(paint, z10);
        }
        return calculateTintColorTintFilter(colorStateList, mode, z10);
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context context) {
        return createWithElevationOverlay(context, 0.0f);
    }

    private void drawCompatShadow(@NonNull Canvas canvas) {
        if (this.containsIncompatibleShadowOp.cardinality() > 0) {
            Log.w(TAG, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.drawableState.f8456s != 0) {
            canvas.drawPath(this.path, this.shadowRenderer.getShadowPaint());
        }
        for (int i10 = 0; i10 < 4; i10++) {
            this.cornerShadowOperation[i10].b(this.shadowRenderer, this.drawableState.f8455r, canvas);
            this.edgeShadowOperation[i10].b(this.shadowRenderer, this.drawableState.f8455r, canvas);
        }
        if (this.shadowBitmapDrawingEnable) {
            int shadowOffsetX = getShadowOffsetX();
            int shadowOffsetY = getShadowOffsetY();
            canvas.translate((float) (-shadowOffsetX), (float) (-shadowOffsetY));
            canvas.drawPath(this.path, clearPaint);
            canvas.translate((float) shadowOffsetX, (float) shadowOffsetY);
        }
    }

    private void drawFillShape(@NonNull Canvas canvas) {
        drawShape(canvas, this.fillPaint, this.path, this.drawableState.f8438a, getBoundsAsRectF());
    }

    @NonNull
    private RectF getBoundsInsetByStroke() {
        this.insetRectF.set(getBoundsAsRectF());
        float strokeInsetLength = getStrokeInsetLength();
        this.insetRectF.inset(strokeInsetLength, strokeInsetLength);
        return this.insetRectF;
    }

    private float getStrokeInsetLength() {
        if (hasStroke()) {
            return this.strokePaint.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean hasCompatShadow() {
        c cVar = this.drawableState;
        int i10 = cVar.f8454q;
        if (i10 == 1 || cVar.f8455r <= 0 || (i10 != 2 && !requiresCompatShadow())) {
            return false;
        }
        return true;
    }

    private boolean hasFill() {
        Paint.Style style = this.drawableState.f8459v;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            return true;
        }
        return false;
    }

    private boolean hasStroke() {
        Paint.Style style = this.drawableState.f8459v;
        if ((style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.strokePaint.getStrokeWidth() > 0.0f) {
            return true;
        }
        return false;
    }

    private void invalidateSelfIgnoreShape() {
        super.invalidateSelf();
    }

    private void maybeDrawCompatShadow(@NonNull Canvas canvas) {
        if (hasCompatShadow()) {
            canvas.save();
            prepareCanvasForShadow(canvas);
            if (!this.shadowBitmapDrawingEnable) {
                drawCompatShadow(canvas);
                canvas.restore();
                return;
            }
            int width = (int) (this.pathBounds.width() - ((float) getBounds().width()));
            int height = (int) (this.pathBounds.height() - ((float) getBounds().height()));
            if (width < 0 || height < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.pathBounds.width()) + (this.drawableState.f8455r * 2) + width, ((int) this.pathBounds.height()) + (this.drawableState.f8455r * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f10 = (float) ((getBounds().left - this.drawableState.f8455r) - width);
            float f11 = (float) ((getBounds().top - this.drawableState.f8455r) - height);
            canvas2.translate(-f10, -f11);
            drawCompatShadow(canvas2);
            canvas.drawBitmap(createBitmap, f10, f11, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
        }
    }

    private static int modulateAlpha(int i10, int i11) {
        return (i10 * (i11 + (i11 >>> 7))) >>> 8;
    }

    private void prepareCanvasForShadow(@NonNull Canvas canvas) {
        canvas.translate((float) getShadowOffsetX(), (float) getShadowOffsetY());
    }

    private boolean updateColorsForState(int[] iArr) {
        boolean z10;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.drawableState.f8441d == null || (color2 = this.fillPaint.getColor()) == (colorForState2 = this.drawableState.f8441d.getColorForState(iArr, color2))) {
            z10 = false;
        } else {
            this.fillPaint.setColor(colorForState2);
            z10 = true;
        }
        if (this.drawableState.f8442e == null || (color = this.strokePaint.getColor()) == (colorForState = this.drawableState.f8442e.getColorForState(iArr, color))) {
            return z10;
        }
        this.strokePaint.setColor(colorForState);
        return true;
    }

    private boolean updateTintFilter() {
        PorterDuffColorFilter porterDuffColorFilter = this.tintFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.strokeTintFilter;
        c cVar = this.drawableState;
        this.tintFilter = calculateTintFilter(cVar.f8444g, cVar.f8445h, this.fillPaint, true);
        c cVar2 = this.drawableState;
        this.strokeTintFilter = calculateTintFilter(cVar2.f8443f, cVar2.f8445h, this.strokePaint, false);
        c cVar3 = this.drawableState;
        if (cVar3.f8458u) {
            this.shadowRenderer.setShadowColor(cVar3.f8444g.getColorForState(getState(), 0));
        }
        if (!ObjectsCompat.equals(porterDuffColorFilter, this.tintFilter) || !ObjectsCompat.equals(porterDuffColorFilter2, this.strokeTintFilter)) {
            return true;
        }
        return false;
    }

    private void updateZ() {
        float z10 = getZ();
        this.drawableState.f8455r = (int) Math.ceil((double) (0.75f * z10));
        this.drawableState.f8456s = (int) Math.ceil((double) (z10 * SHADOW_OFFSET_MULTIPLIER));
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void calculatePathForSize(@NonNull RectF rectF2, @NonNull Path path2) {
        ShapeAppearancePathProvider shapeAppearancePathProvider = this.pathProvider;
        c cVar = this.drawableState;
        ShapeAppearanceModel shapeAppearanceModel = cVar.f8438a;
        float f10 = cVar.f8448k;
        shapeAppearancePathProvider.calculatePath(shapeAppearanceModel, f10, rectF2, this.pathShadowListener, path2);
    }

    /* access modifiers changed from: protected */
    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int compositeElevationOverlayIfNeeded(@ColorInt int i10) {
        float z10 = getZ() + getParentAbsoluteElevation();
        ElevationOverlayProvider elevationOverlayProvider = this.drawableState.f8439b;
        if (elevationOverlayProvider != null) {
            return elevationOverlayProvider.compositeOverlayIfNeeded(i10, z10);
        }
        return i10;
    }

    public void draw(@NonNull Canvas canvas) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int alpha = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(alpha, this.drawableState.f8450m));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.f8449l);
        int alpha2 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(alpha2, this.drawableState.f8450m));
        if (this.pathDirty) {
            calculateStrokePath();
            calculatePath(getBoundsAsRectF(), this.path);
            this.pathDirty = false;
        }
        maybeDrawCompatShadow(canvas);
        if (hasFill()) {
            drawFillShape(canvas);
        }
        if (hasStroke()) {
            drawStrokeShape(canvas);
        }
        this.fillPaint.setAlpha(alpha);
        this.strokePaint.setAlpha(alpha2);
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void drawShape(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path2, @NonNull RectF rectF2) {
        drawShape(canvas, paint, path2, this.drawableState.f8438a, rectF2);
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void drawStrokeShape(@NonNull Canvas canvas) {
        drawShape(canvas, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearance, getBoundsInsetByStroke());
    }

    public int getAlpha() {
        return this.drawableState.f8450m;
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.drawableState.f8438a.getBottomLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.drawableState.f8438a.getBottomRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    /* access modifiers changed from: protected */
    @NonNull
    public RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public float getElevation() {
        return this.drawableState.f8452o;
    }

    @Nullable
    public ColorStateList getFillColor() {
        return this.drawableState.f8441d;
    }

    public float getInterpolation() {
        return this.drawableState.f8448k;
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.drawableState.f8454q != 2) {
            if (isRoundRect()) {
                outline.setRoundRect(getBounds(), getTopLeftCornerResolvedSize() * this.drawableState.f8448k);
                return;
            }
            calculatePath(getBoundsAsRectF(), this.path);
            if (this.path.isConvex() || Build.VERSION.SDK_INT >= 29) {
                try {
                    outline.setConvexPath(this.path);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.drawableState.f8446i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public Paint.Style getPaintStyle() {
        return this.drawableState.f8459v;
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.f8451n;
    }

    @Deprecated
    public void getPathForSize(int i10, int i11, @NonNull Path path2) {
        calculatePathForSize(new RectF(0.0f, 0.0f, (float) i10, (float) i11), path2);
    }

    @ColorInt
    public int getResolvedTintColor() {
        return this.resolvedTintColor;
    }

    public float getScale() {
        return this.drawableState.f8447j;
    }

    public int getShadowCompatRotation() {
        return this.drawableState.f8457t;
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.f8454q;
    }

    @Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    public int getShadowOffsetX() {
        c cVar = this.drawableState;
        return (int) (((double) cVar.f8456s) * Math.sin(Math.toRadians((double) cVar.f8457t)));
    }

    public int getShadowOffsetY() {
        c cVar = this.drawableState;
        return (int) (((double) cVar.f8456s) * Math.cos(Math.toRadians((double) cVar.f8457t)));
    }

    public int getShadowRadius() {
        return this.drawableState.f8455r;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getShadowVerticalOffset() {
        return this.drawableState.f8456s;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.f8438a;
    }

    @Deprecated
    @Nullable
    public ShapePathModel getShapedViewModel() {
        ShapeAppearanceModel shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof ShapePathModel) {
            return (ShapePathModel) shapeAppearanceModel;
        }
        return null;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.drawableState.f8442e;
    }

    @Nullable
    public ColorStateList getStrokeTintList() {
        return this.drawableState.f8443f;
    }

    public float getStrokeWidth() {
        return this.drawableState.f8449l;
    }

    @Nullable
    public ColorStateList getTintList() {
        return this.drawableState.f8444g;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.drawableState.f8438a.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.drawableState.f8438a.getTopRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.drawableState.f8453p;
    }

    public Region getTransparentRegion() {
        this.transparentRegion.set(getBounds());
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public float getZ() {
        return getElevation() + getTranslationZ();
    }

    public void initializeElevationOverlay(Context context) {
        this.drawableState.f8439b = new ElevationOverlayProvider(context);
        updateZ();
    }

    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        ElevationOverlayProvider elevationOverlayProvider = this.drawableState.f8439b;
        if (elevationOverlayProvider == null || !elevationOverlayProvider.isThemeElevationOverlayEnabled()) {
            return false;
        }
        return true;
    }

    public boolean isElevationOverlayInitialized() {
        if (this.drawableState.f8439b != null) {
            return true;
        }
        return false;
    }

    public boolean isPointInTransparentRegion(int i10, int i11) {
        return getTransparentRegion().contains(i10, i11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect() {
        return this.drawableState.f8438a.isRoundRect(getBoundsAsRectF());
    }

    @Deprecated
    public boolean isShadowEnabled() {
        int i10 = this.drawableState.f8454q;
        if (i10 == 0 || i10 == 2) {
            return true;
        }
        return false;
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        if (super.isStateful() || (((colorStateList = this.drawableState.f8444g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.drawableState.f8443f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.drawableState.f8442e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.drawableState.f8441d) != null && colorStateList4.isStateful()))))) {
            return true;
        }
        return false;
    }

    @NonNull
    public Drawable mutate() {
        this.drawableState = new c(this.drawableState);
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.pathDirty = true;
        super.onBoundsChange(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        boolean updateColorsForState = updateColorsForState(iArr);
        boolean updateTintFilter = updateTintFilter();
        if (updateColorsForState || updateTintFilter) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    public boolean requiresCompatShadow() {
        int i10 = Build.VERSION.SDK_INT;
        if (isRoundRect() || this.path.isConvex() || i10 >= 29) {
            return false;
        }
        return true;
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i10) {
        c cVar = this.drawableState;
        if (cVar.f8450m != i10) {
            cVar.f8450m = i10;
            invalidateSelfIgnoreShape();
        }
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.drawableState.f8440c = colorFilter;
        invalidateSelfIgnoreShape();
    }

    public void setCornerSize(float f10) {
        setShapeAppearanceModel(this.drawableState.f8438a.withCornerSize(f10));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEdgeIntersectionCheckEnable(boolean z10) {
        this.pathProvider.setEdgeIntersectionCheckEnable(z10);
    }

    public void setElevation(float f10) {
        c cVar = this.drawableState;
        if (cVar.f8452o != f10) {
            cVar.f8452o = f10;
            updateZ();
        }
    }

    public void setFillColor(@Nullable ColorStateList colorStateList) {
        c cVar = this.drawableState;
        if (cVar.f8441d != colorStateList) {
            cVar.f8441d = colorStateList;
            onStateChange(getState());
        }
    }

    public void setInterpolation(float f10) {
        c cVar = this.drawableState;
        if (cVar.f8448k != f10) {
            cVar.f8448k = f10;
            this.pathDirty = true;
            invalidateSelf();
        }
    }

    public void setPadding(int i10, int i11, int i12, int i13) {
        c cVar = this.drawableState;
        if (cVar.f8446i == null) {
            cVar.f8446i = new Rect();
        }
        this.drawableState.f8446i.set(i10, i11, i12, i13);
        invalidateSelf();
    }

    public void setPaintStyle(Paint.Style style) {
        this.drawableState.f8459v = style;
        invalidateSelfIgnoreShape();
    }

    public void setParentAbsoluteElevation(float f10) {
        c cVar = this.drawableState;
        if (cVar.f8451n != f10) {
            cVar.f8451n = f10;
            updateZ();
        }
    }

    public void setScale(float f10) {
        c cVar = this.drawableState;
        if (cVar.f8447j != f10) {
            cVar.f8447j = f10;
            invalidateSelf();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowBitmapDrawingEnable(boolean z10) {
        this.shadowBitmapDrawingEnable = z10;
    }

    public void setShadowColor(int i10) {
        this.shadowRenderer.setShadowColor(i10);
        this.drawableState.f8458u = false;
        invalidateSelfIgnoreShape();
    }

    public void setShadowCompatRotation(int i10) {
        c cVar = this.drawableState;
        if (cVar.f8457t != i10) {
            cVar.f8457t = i10;
            invalidateSelfIgnoreShape();
        }
    }

    public void setShadowCompatibilityMode(int i10) {
        c cVar = this.drawableState;
        if (cVar.f8454q != i10) {
            cVar.f8454q = i10;
            invalidateSelfIgnoreShape();
        }
    }

    @Deprecated
    public void setShadowElevation(int i10) {
        setElevation((float) i10);
    }

    @Deprecated
    public void setShadowEnabled(boolean z10) {
        setShadowCompatibilityMode(z10 ^ true ? 1 : 0);
    }

    @Deprecated
    public void setShadowRadius(int i10) {
        this.drawableState.f8455r = i10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowVerticalOffset(int i10) {
        c cVar = this.drawableState;
        if (cVar.f8456s != i10) {
            cVar.f8456s = i10;
            invalidateSelfIgnoreShape();
        }
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.drawableState.f8438a = shapeAppearanceModel;
        invalidateSelf();
    }

    @Deprecated
    public void setShapedViewModel(@NonNull ShapePathModel shapePathModel) {
        setShapeAppearanceModel(shapePathModel);
    }

    public void setStroke(float f10, @ColorInt int i10) {
        setStrokeWidth(f10);
        setStrokeColor(ColorStateList.valueOf(i10));
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        c cVar = this.drawableState;
        if (cVar.f8442e != colorStateList) {
            cVar.f8442e = colorStateList;
            onStateChange(getState());
        }
    }

    public void setStrokeTint(ColorStateList colorStateList) {
        this.drawableState.f8443f = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setStrokeWidth(float f10) {
        this.drawableState.f8449l = f10;
        invalidateSelf();
    }

    public void setTint(@ColorInt int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.drawableState.f8444g = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        c cVar = this.drawableState;
        if (cVar.f8445h != mode) {
            cVar.f8445h = mode;
            updateTintFilter();
            invalidateSelfIgnoreShape();
        }
    }

    public void setTranslationZ(float f10) {
        c cVar = this.drawableState;
        if (cVar.f8453p != f10) {
            cVar.f8453p = f10;
            updateZ();
        }
    }

    public void setUseTintColorForShadow(boolean z10) {
        c cVar = this.drawableState;
        if (cVar.f8458u != z10) {
            cVar.f8458u = z10;
            invalidateSelf();
        }
    }

    public void setZ(float f10) {
        setTranslationZ(f10 - getElevation());
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context context, float f10) {
        int color = MaterialColors.getColor(context, R.attr.colorSurface, MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
        materialShapeDrawable.setElevation(f10);
        return materialShapeDrawable;
    }

    private void drawShape(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path2, @NonNull ShapeAppearanceModel shapeAppearanceModel, @NonNull RectF rectF2) {
        if (shapeAppearanceModel.isRoundRect(rectF2)) {
            float cornerSize = shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF2) * this.drawableState.f8448k;
            canvas.drawRoundRect(rectF2, cornerSize, cornerSize, paint);
            return;
        }
        canvas.drawPath(path2, paint);
    }

    public void setCornerSize(@NonNull CornerSize cornerSize) {
        setShapeAppearanceModel(this.drawableState.f8438a.withCornerSize(cornerSize));
    }

    public MaterialShapeDrawable(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10, @StyleRes int i11) {
        this(ShapeAppearanceModel.builder(context, attributeSet, i10, i11).build());
    }

    public void setStroke(float f10, @Nullable ColorStateList colorStateList) {
        setStrokeWidth(f10);
        setStrokeColor(colorStateList);
    }

    @Deprecated
    public MaterialShapeDrawable(@NonNull ShapePathModel shapePathModel) {
        this((ShapeAppearanceModel) shapePathModel);
    }

    public void setStrokeTint(@ColorInt int i10) {
        setStrokeTint(ColorStateList.valueOf(i10));
    }

    public MaterialShapeDrawable(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this(new c(shapeAppearanceModel, (ElevationOverlayProvider) null));
    }

    private MaterialShapeDrawable(@NonNull c cVar) {
        ShapeAppearancePathProvider shapeAppearancePathProvider;
        this.cornerShadowOperation = new ShapePath.d[4];
        this.edgeShadowOperation = new ShapePath.d[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint paint = new Paint(1);
        this.fillPaint = paint;
        Paint paint2 = new Paint(1);
        this.strokePaint = paint2;
        this.shadowRenderer = new ShadowRenderer();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            shapeAppearancePathProvider = ShapeAppearancePathProvider.getInstance();
        } else {
            shapeAppearancePathProvider = new ShapeAppearancePathProvider();
        }
        this.pathProvider = shapeAppearancePathProvider;
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new a();
    }

    static final class c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public ShapeAppearanceModel f8438a;

        /* renamed from: b  reason: collision with root package name */
        public ElevationOverlayProvider f8439b;

        /* renamed from: c  reason: collision with root package name */
        public ColorFilter f8440c;

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f8441d = null;

        /* renamed from: e  reason: collision with root package name */
        public ColorStateList f8442e = null;

        /* renamed from: f  reason: collision with root package name */
        public ColorStateList f8443f = null;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f8444g = null;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f8445h = PorterDuff.Mode.SRC_IN;

        /* renamed from: i  reason: collision with root package name */
        public Rect f8446i = null;

        /* renamed from: j  reason: collision with root package name */
        public float f8447j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f8448k = 1.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f8449l;

        /* renamed from: m  reason: collision with root package name */
        public int f8450m = 255;

        /* renamed from: n  reason: collision with root package name */
        public float f8451n = 0.0f;

        /* renamed from: o  reason: collision with root package name */
        public float f8452o = 0.0f;

        /* renamed from: p  reason: collision with root package name */
        public float f8453p = 0.0f;

        /* renamed from: q  reason: collision with root package name */
        public int f8454q = 0;

        /* renamed from: r  reason: collision with root package name */
        public int f8455r = 0;

        /* renamed from: s  reason: collision with root package name */
        public int f8456s = 0;

        /* renamed from: t  reason: collision with root package name */
        public int f8457t = 0;

        /* renamed from: u  reason: collision with root package name */
        public boolean f8458u = false;

        /* renamed from: v  reason: collision with root package name */
        public Paint.Style f8459v = Paint.Style.FILL_AND_STROKE;

        public c(ShapeAppearanceModel shapeAppearanceModel, ElevationOverlayProvider elevationOverlayProvider) {
            this.f8438a = shapeAppearanceModel;
            this.f8439b = elevationOverlayProvider;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this, (a) null);
            boolean unused = materialShapeDrawable.pathDirty = true;
            return materialShapeDrawable;
        }

        public c(c cVar) {
            this.f8438a = cVar.f8438a;
            this.f8439b = cVar.f8439b;
            this.f8449l = cVar.f8449l;
            this.f8440c = cVar.f8440c;
            this.f8441d = cVar.f8441d;
            this.f8442e = cVar.f8442e;
            this.f8445h = cVar.f8445h;
            this.f8444g = cVar.f8444g;
            this.f8450m = cVar.f8450m;
            this.f8447j = cVar.f8447j;
            this.f8456s = cVar.f8456s;
            this.f8454q = cVar.f8454q;
            this.f8458u = cVar.f8458u;
            this.f8448k = cVar.f8448k;
            this.f8451n = cVar.f8451n;
            this.f8452o = cVar.f8452o;
            this.f8453p = cVar.f8453p;
            this.f8455r = cVar.f8455r;
            this.f8457t = cVar.f8457t;
            this.f8443f = cVar.f8443f;
            this.f8459v = cVar.f8459v;
            if (cVar.f8446i != null) {
                this.f8446i = new Rect(cVar.f8446i);
            }
        }
    }
}
