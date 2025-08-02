package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TypefaceUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    @NonNull
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final float FADE_MODE_THRESHOLD_FRACTION_RELATIVE = 0.5f;
    private static final String TAG = "CollapsingTextHelper";
    private static final boolean USE_SCALING_TEXTURE = false;
    private boolean boundsChanged;
    @NonNull
    private final Rect collapsedBounds;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private CancelableFontCallback collapsedFontCallback;
    private float collapsedLetterSpacing;
    private ColorStateList collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private float collapsedTextBlend;
    private ColorStateList collapsedTextColor;
    private int collapsedTextGravity = 16;
    private float collapsedTextSize = 15.0f;
    private float collapsedTextWidth;
    private Typeface collapsedTypeface;
    private Typeface collapsedTypefaceBold;
    private Typeface collapsedTypefaceDefault;
    @NonNull
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private float currentLetterSpacing;
    private int currentOffsetY;
    private int currentShadowColor;
    private float currentShadowDx;
    private float currentShadowDy;
    private float currentShadowRadius;
    private float currentTextSize;
    private Typeface currentTypeface;
    private boolean drawTitle;
    @NonNull
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private CancelableFontCallback expandedFontCallback;
    private float expandedFraction;
    private float expandedLetterSpacing;
    private int expandedLineCount;
    private ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private float expandedTextBlend;
    private ColorStateList expandedTextColor;
    private int expandedTextGravity = 16;
    private float expandedTextSize = 15.0f;
    @Nullable
    private Bitmap expandedTitleTexture;
    private Typeface expandedTypeface;
    private Typeface expandedTypefaceBold;
    private Typeface expandedTypefaceDefault;
    private boolean fadeModeEnabled;
    private float fadeModeStartFraction;
    private float fadeModeThresholdFraction;
    private int hyphenationFrequency = a.f8343n;
    private boolean isRtl;
    private boolean isRtlTextDirectionHeuristicsEnabled = true;
    private float lineSpacingAdd = 0.0f;
    private float lineSpacingMultiplier = 1.0f;
    private int maxLines = 1;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;
    @Nullable
    private CharSequence text;
    private StaticLayout textLayout;
    @NonNull
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;
    @Nullable
    private CharSequence textToDraw;
    private CharSequence textToDrawCollapsed;
    private Paint texturePaint;
    @NonNull
    private final TextPaint tmpPaint;
    private boolean useTexture;
    private final View view;

    class a implements CancelableFontCallback.ApplyFont {
        a() {
        }

        public void apply(Typeface typeface) {
            CollapsingTextHelper.this.setCollapsedTypeface(typeface);
        }
    }

    class b implements CancelableFontCallback.ApplyFont {
        b() {
        }

        public void apply(Typeface typeface) {
            CollapsingTextHelper.this.setExpandedTypeface(typeface);
        }
    }

    public CollapsingTextHelper(View view2) {
        this.view = view2;
        TextPaint textPaint2 = new TextPaint(129);
        this.textPaint = textPaint2;
        this.tmpPaint = new TextPaint(textPaint2);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
        maybeUpdateFontWeightAdjustment(view2.getContext().getResources().getConfiguration());
    }

    @ColorInt
    private static int blendARGB(@ColorInt int i10, @ColorInt int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        float f11 = 1.0f - f10;
        return Color.argb(Math.round((((float) Color.alpha(i10)) * f11) + (((float) Color.alpha(i11)) * f10)), Math.round((((float) Color.red(i10)) * f11) + (((float) Color.red(i11)) * f10)), Math.round((((float) Color.green(i10)) * f11) + (((float) Color.green(i11)) * f10)), Math.round((((float) Color.blue(i10)) * f11) + (((float) Color.blue(i11)) * f10)));
    }

    private void calculateBaseOffsets(boolean z10) {
        float f10;
        int i10;
        StaticLayout staticLayout;
        calculateUsingTextSize(1.0f, z10);
        CharSequence charSequence = this.textToDraw;
        if (!(charSequence == null || (staticLayout = this.textLayout) == null)) {
            this.textToDrawCollapsed = TextUtils.ellipsize(charSequence, this.textPaint, (float) staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.textToDrawCollapsed;
        float f11 = 0.0f;
        if (charSequence2 != null) {
            this.collapsedTextWidth = measureTextWidth(this.textPaint, charSequence2);
        } else {
            this.collapsedTextWidth = 0.0f;
        }
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        int i11 = absoluteGravity & 112;
        if (i11 == 48) {
            this.collapsedDrawY = (float) this.collapsedBounds.top;
        } else if (i11 != 80) {
            this.collapsedDrawY = ((float) this.collapsedBounds.centerY()) - ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f);
        } else {
            this.collapsedDrawY = ((float) this.collapsedBounds.bottom) + this.textPaint.ascent();
        }
        int i12 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i12 == 1) {
            this.collapsedDrawX = ((float) this.collapsedBounds.centerX()) - (this.collapsedTextWidth / 2.0f);
        } else if (i12 != 5) {
            this.collapsedDrawX = (float) this.collapsedBounds.left;
        } else {
            this.collapsedDrawX = ((float) this.collapsedBounds.right) - this.collapsedTextWidth;
        }
        calculateUsingTextSize(0.0f, z10);
        StaticLayout staticLayout2 = this.textLayout;
        if (staticLayout2 != null) {
            f10 = (float) staticLayout2.getHeight();
        } else {
            f10 = 0.0f;
        }
        StaticLayout staticLayout3 = this.textLayout;
        if (staticLayout3 == null || this.maxLines <= 1) {
            CharSequence charSequence3 = this.textToDraw;
            if (charSequence3 != null) {
                f11 = measureTextWidth(this.textPaint, charSequence3);
            }
        } else {
            f11 = (float) staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.textLayout;
        if (staticLayout4 != null) {
            i10 = staticLayout4.getLineCount();
        } else {
            i10 = 0;
        }
        this.expandedLineCount = i10;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int i13 = absoluteGravity2 & 112;
        if (i13 == 48) {
            this.expandedDrawY = (float) this.expandedBounds.top;
        } else if (i13 != 80) {
            this.expandedDrawY = ((float) this.expandedBounds.centerY()) - (f10 / 2.0f);
        } else {
            this.expandedDrawY = (((float) this.expandedBounds.bottom) - f10) + this.textPaint.descent();
        }
        int i14 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i14 == 1) {
            this.expandedDrawX = ((float) this.expandedBounds.centerX()) - (f11 / 2.0f);
        } else if (i14 != 5) {
            this.expandedDrawX = (float) this.expandedBounds.left;
        } else {
            this.expandedDrawX = ((float) this.expandedBounds.right) - f11;
        }
        clearTexture();
        setInterpolatedTextSize(this.expandedFraction);
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private float calculateFadeModeTextAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        float f11 = this.fadeModeThresholdFraction;
        if (f10 <= f11) {
            return AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f11, f10);
        }
        return AnimationUtils.lerp(0.0f, 1.0f, f11, 1.0f, f10);
    }

    private float calculateFadeModeThresholdFraction() {
        float f10 = this.fadeModeStartFraction;
        return f10 + ((1.0f - f10) * 0.5f);
    }

    private boolean calculateIsRtl(@NonNull CharSequence charSequence) {
        boolean isDefaultIsRtl = isDefaultIsRtl();
        if (this.isRtlTextDirectionHeuristicsEnabled) {
            return isTextDirectionHeuristicsIsRtl(charSequence, isDefaultIsRtl);
        }
        return isDefaultIsRtl;
    }

    private void calculateOffsets(float f10) {
        float f11;
        interpolateBounds(f10);
        if (!this.fadeModeEnabled) {
            this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f10, this.positionInterpolator);
            this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f10, this.positionInterpolator);
            setInterpolatedTextSize(f10);
            f11 = f10;
        } else if (f10 < this.fadeModeThresholdFraction) {
            this.currentDrawX = this.expandedDrawX;
            this.currentDrawY = this.expandedDrawY;
            setInterpolatedTextSize(0.0f);
            f11 = 0.0f;
        } else {
            this.currentDrawX = this.collapsedDrawX;
            this.currentDrawY = this.collapsedDrawY - ((float) Math.max(0, this.currentOffsetY));
            setInterpolatedTextSize(1.0f);
            f11 = 1.0f;
        }
        TimeInterpolator timeInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - f10, timeInterpolator));
        setExpandedTextBlend(lerp(1.0f, 0.0f, f10, timeInterpolator));
        if (this.collapsedTextColor != this.expandedTextColor) {
            this.textPaint.setColor(blendARGB(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f11));
        } else {
            this.textPaint.setColor(getCurrentCollapsedTextColor());
        }
        float f12 = this.collapsedLetterSpacing;
        float f13 = this.expandedLetterSpacing;
        if (f12 != f13) {
            this.textPaint.setLetterSpacing(lerp(f13, f12, f10, timeInterpolator));
        } else {
            this.textPaint.setLetterSpacing(f12);
        }
        this.currentShadowRadius = lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f10, (TimeInterpolator) null);
        this.currentShadowDx = lerp(this.expandedShadowDx, this.collapsedShadowDx, f10, (TimeInterpolator) null);
        this.currentShadowDy = lerp(this.expandedShadowDy, this.collapsedShadowDy, f10, (TimeInterpolator) null);
        int blendARGB = blendARGB(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f10);
        this.currentShadowColor = blendARGB;
        this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, blendARGB);
        if (this.fadeModeEnabled) {
            this.textPaint.setAlpha((int) (calculateFadeModeTextAlpha(f10) * ((float) this.textPaint.getAlpha())));
        }
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private void calculateUsingTextSize(float f10) {
        calculateUsingTextSize(f10, false);
    }

    private void clearTexture() {
        Bitmap bitmap = this.expandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            this.expandedTitleTexture = null;
        }
    }

    private StaticLayout createStaticLayout(int i10, float f10, boolean z10) {
        Layout.Alignment alignment;
        if (i10 == 1) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            alignment = getMultilineTextLayoutAlignment();
        }
        return (StaticLayout) Preconditions.checkNotNull(a.b(this.text, this.textPaint, (int) f10).d(TextUtils.TruncateAt.END).g(z10).c(alignment).f(false).i(i10).h(this.lineSpacingAdd, this.lineSpacingMultiplier).e(this.hyphenationFrequency).a());
    }

    private void drawMultilineTransition(@NonNull Canvas canvas, float f10, float f11) {
        int alpha = this.textPaint.getAlpha();
        canvas.translate(f10, f11);
        float f12 = (float) alpha;
        this.textPaint.setAlpha((int) (this.expandedTextBlend * f12));
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            TextPaint textPaint2 = this.textPaint;
            textPaint2.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, textPaint2.getAlpha()));
        }
        Canvas canvas2 = canvas;
        this.textLayout.draw(canvas);
        this.textPaint.setAlpha((int) (this.collapsedTextBlend * f12));
        if (i10 >= 31) {
            TextPaint textPaint3 = this.textPaint;
            textPaint3.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, textPaint3.getAlpha()));
        }
        int lineBaseline = this.textLayout.getLineBaseline(0);
        CharSequence charSequence = this.textToDrawCollapsed;
        float f13 = (float) lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f13, this.textPaint);
        if (i10 >= 31) {
            this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, this.currentShadowColor);
        }
        if (!this.fadeModeEnabled) {
            String trim = this.textToDrawCollapsed.toString().trim();
            if (trim.endsWith(ELLIPSIS_NORMAL)) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.textPaint.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.textLayout.getLineEnd(0), str.length()), 0.0f, f13, this.textPaint);
        }
    }

    private void ensureExpandedTexture() {
        if (this.expandedTitleTexture == null && !this.expandedBounds.isEmpty() && !TextUtils.isEmpty(this.textToDraw)) {
            calculateOffsets(0.0f);
            int width = this.textLayout.getWidth();
            int height = this.textLayout.getHeight();
            if (width > 0 && height > 0) {
                this.expandedTitleTexture = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.textLayout.draw(new Canvas(this.expandedTitleTexture));
                if (this.texturePaint == null) {
                    this.texturePaint = new Paint(3);
                }
            }
        }
    }

    private float getCollapsedTextLeftBound(int i10, int i11) {
        if (i11 == 17 || (i11 & 7) == 1) {
            return (((float) i10) / 2.0f) - (this.collapsedTextWidth / 2.0f);
        }
        if ((i11 & GravityCompat.END) == 8388613 || (i11 & 5) == 5) {
            if (this.isRtl) {
                return (float) this.collapsedBounds.left;
            }
            return ((float) this.collapsedBounds.right) - this.collapsedTextWidth;
        } else if (this.isRtl) {
            return ((float) this.collapsedBounds.right) - this.collapsedTextWidth;
        } else {
            return (float) this.collapsedBounds.left;
        }
    }

    private float getCollapsedTextRightBound(@NonNull RectF rectF, int i10, int i11) {
        if (i11 == 17 || (i11 & 7) == 1) {
            return (((float) i10) / 2.0f) + (this.collapsedTextWidth / 2.0f);
        }
        if ((i11 & GravityCompat.END) == 8388613 || (i11 & 5) == 5) {
            if (this.isRtl) {
                return rectF.left + this.collapsedTextWidth;
            }
            return (float) this.collapsedBounds.right;
        } else if (this.isRtl) {
            return (float) this.collapsedBounds.right;
        } else {
            return rectF.left + this.collapsedTextWidth;
        }
    }

    @ColorInt
    private int getCurrentColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.state;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    @ColorInt
    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    private Layout.Alignment getMultilineTextLayoutAlignment() {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0) & 7;
        if (absoluteGravity == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (absoluteGravity != 5) {
            if (this.isRtl) {
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        } else if (this.isRtl) {
            return Layout.Alignment.ALIGN_NORMAL;
        } else {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    private void getTextPaintCollapsed(@NonNull TextPaint textPaint2) {
        textPaint2.setTextSize(this.collapsedTextSize);
        textPaint2.setTypeface(this.collapsedTypeface);
        textPaint2.setLetterSpacing(this.collapsedLetterSpacing);
    }

    private void getTextPaintExpanded(@NonNull TextPaint textPaint2) {
        textPaint2.setTextSize(this.expandedTextSize);
        textPaint2.setTypeface(this.expandedTypeface);
        textPaint2.setLetterSpacing(this.expandedLetterSpacing);
    }

    private void interpolateBounds(float f10) {
        Rect rect;
        if (this.fadeModeEnabled) {
            RectF rectF = this.currentBounds;
            if (f10 < this.fadeModeThresholdFraction) {
                rect = this.expandedBounds;
            } else {
                rect = this.collapsedBounds;
            }
            rectF.set(rect);
            return;
        }
        this.currentBounds.left = lerp((float) this.expandedBounds.left, (float) this.collapsedBounds.left, f10, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, f10, this.positionInterpolator);
        this.currentBounds.right = lerp((float) this.expandedBounds.right, (float) this.collapsedBounds.right, f10, this.positionInterpolator);
        this.currentBounds.bottom = lerp((float) this.expandedBounds.bottom, (float) this.collapsedBounds.bottom, f10, this.positionInterpolator);
    }

    private static boolean isClose(float f10, float f11) {
        if (Math.abs(f10 - f11) < 1.0E-5f) {
            return true;
        }
        return false;
    }

    private boolean isDefaultIsRtl() {
        if (ViewCompat.getLayoutDirection(this.view) == 1) {
            return true;
        }
        return false;
    }

    private boolean isTextDirectionHeuristicsIsRtl(@NonNull CharSequence charSequence, boolean z10) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        if (z10) {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
        } else {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        }
        return textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    private static float lerp(float f10, float f11, float f12, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f12 = timeInterpolator.getInterpolation(f12);
        }
        return AnimationUtils.lerp(f10, f11, f12);
    }

    private float measureTextWidth(TextPaint textPaint2, CharSequence charSequence) {
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    private static boolean rectEquals(@NonNull Rect rect, int i10, int i11, int i12, int i13) {
        if (rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13) {
            return true;
        }
        return false;
    }

    private void setCollapsedTextBlend(float f10) {
        this.collapsedTextBlend = f10;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private boolean setCollapsedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.collapsedTypefaceDefault == typeface) {
            return false;
        }
        this.collapsedTypefaceDefault = typeface;
        Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), typeface);
        this.collapsedTypefaceBold = maybeCopyWithFontWeightAdjustment;
        if (maybeCopyWithFontWeightAdjustment == null) {
            maybeCopyWithFontWeightAdjustment = this.collapsedTypefaceDefault;
        }
        this.collapsedTypeface = maybeCopyWithFontWeightAdjustment;
        return true;
    }

    private void setExpandedTextBlend(float f10) {
        this.expandedTextBlend = f10;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private boolean setExpandedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.expandedTypefaceDefault == typeface) {
            return false;
        }
        this.expandedTypefaceDefault = typeface;
        Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), typeface);
        this.expandedTypefaceBold = maybeCopyWithFontWeightAdjustment;
        if (maybeCopyWithFontWeightAdjustment == null) {
            maybeCopyWithFontWeightAdjustment = this.expandedTypefaceDefault;
        }
        this.expandedTypeface = maybeCopyWithFontWeightAdjustment;
        return true;
    }

    private void setInterpolatedTextSize(float f10) {
        boolean z10;
        calculateUsingTextSize(f10);
        if (!USE_SCALING_TEXTURE || this.scale == 1.0f) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.useTexture = z10;
        if (z10) {
            ensureExpandedTexture();
        }
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private boolean shouldDrawMultiline() {
        if (this.maxLines <= 1 || ((this.isRtl && !this.fadeModeEnabled) || this.useTexture)) {
            return false;
        }
        return true;
    }

    public void draw(@NonNull Canvas canvas) {
        boolean z10;
        int save = canvas.save();
        if (this.textToDraw != null && this.drawTitle) {
            this.textPaint.setTextSize(this.currentTextSize);
            float f10 = this.currentDrawX;
            float f11 = this.currentDrawY;
            if (!this.useTexture || this.expandedTitleTexture == null) {
                z10 = false;
            } else {
                z10 = true;
            }
            float f12 = this.scale;
            if (f12 != 1.0f && !this.fadeModeEnabled) {
                canvas.scale(f12, f12, f10, f11);
            }
            if (z10) {
                canvas.drawBitmap(this.expandedTitleTexture, f10, f11, this.texturePaint);
                canvas.restoreToCount(save);
                return;
            }
            if (!shouldDrawMultiline() || (this.fadeModeEnabled && this.expandedFraction <= this.fadeModeThresholdFraction)) {
                canvas.translate(f10, f11);
                this.textLayout.draw(canvas);
            } else {
                drawMultilineTransition(canvas, this.currentDrawX - ((float) this.textLayout.getLineStart(0)), f11);
            }
            canvas.restoreToCount(save);
        }
    }

    public void getCollapsedTextActualBounds(@NonNull RectF rectF, int i10, int i11) {
        this.isRtl = calculateIsRtl(this.text);
        rectF.left = getCollapsedTextLeftBound(i10, i11);
        rectF.top = (float) this.collapsedBounds.top;
        rectF.right = getCollapsedTextRightBound(rectF, i10, i11);
        rectF.bottom = ((float) this.collapsedBounds.top) + getCollapsedTextHeight();
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public float getCollapsedTextHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.collapsedTypeface;
        if (typeface != null) {
            return typeface;
        }
        return Typeface.DEFAULT;
    }

    @ColorInt
    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    public int getExpandedLineCount() {
        return this.expandedLineCount;
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public float getExpandedTextFullHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return (-this.tmpPaint.ascent()) + this.tmpPaint.descent();
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public float getExpandedTextHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.expandedTypeface;
        if (typeface != null) {
            return typeface;
        }
        return Typeface.DEFAULT;
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public float getFadeModeThresholdFraction() {
        return this.fadeModeThresholdFraction;
    }

    @RequiresApi(23)
    public int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    @RequiresApi(23)
    public float getLineSpacingAdd() {
        return this.textLayout.getSpacingAdd();
    }

    @RequiresApi(23)
    public float getLineSpacingMultiplier() {
        return this.textLayout.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    @Nullable
    public TimeInterpolator getPositionInterpolator() {
        return this.positionInterpolator;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.isRtlTextDirectionHeuristicsEnabled;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.collapsedTextColor;
        if ((colorStateList2 == null || !colorStateList2.isStateful()) && ((colorStateList = this.expandedTextColor) == null || !colorStateList.isStateful())) {
            return false;
        }
        return true;
    }

    public void maybeUpdateFontWeightAdjustment(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.collapsedTypefaceDefault;
            if (typeface != null) {
                this.collapsedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(configuration, typeface);
            }
            Typeface typeface2 = this.expandedTypefaceDefault;
            if (typeface2 != null) {
                this.expandedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(configuration, typeface2);
            }
            Typeface typeface3 = this.collapsedTypefaceBold;
            if (typeface3 == null) {
                typeface3 = this.collapsedTypefaceDefault;
            }
            this.collapsedTypeface = typeface3;
            Typeface typeface4 = this.expandedTypefaceBold;
            if (typeface4 == null) {
                typeface4 = this.expandedTypefaceDefault;
            }
            this.expandedTypeface = typeface4;
            recalculate(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void onBoundsChanged() {
        boolean z10;
        if (this.collapsedBounds.width() <= 0 || this.collapsedBounds.height() <= 0 || this.expandedBounds.width() <= 0 || this.expandedBounds.height() <= 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.drawTitle = z10;
    }

    public void recalculate() {
        recalculate(false);
    }

    public void setCollapsedBounds(int i10, int i11, int i12, int i13) {
        if (!rectEquals(this.collapsedBounds, i10, i11, i12, i13)) {
            this.collapsedBounds.set(i10, i11, i12, i13);
            this.boundsChanged = true;
            onBoundsChanged();
        }
    }

    public void setCollapsedTextAppearance(int i10) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i10);
        if (textAppearance.getTextColor() != null) {
            this.collapsedTextColor = textAppearance.getTextColor();
        }
        if (textAppearance.getTextSize() != 0.0f) {
            this.collapsedTextSize = textAppearance.getTextSize();
        }
        ColorStateList colorStateList = textAppearance.shadowColor;
        if (colorStateList != null) {
            this.collapsedShadowColor = colorStateList;
        }
        this.collapsedShadowDx = textAppearance.shadowDx;
        this.collapsedShadowDy = textAppearance.shadowDy;
        this.collapsedShadowRadius = textAppearance.shadowRadius;
        this.collapsedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.collapsedFontCallback = new CancelableFontCallback(new a(), textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setCollapsedTextGravity(int i10) {
        if (this.collapsedTextGravity != i10) {
            this.collapsedTextGravity = i10;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f10) {
        if (this.collapsedTextSize != f10) {
            this.collapsedTextSize = f10;
            recalculate();
        }
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (setCollapsedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setCurrentOffsetY(int i10) {
        this.currentOffsetY = i10;
    }

    public void setExpandedBounds(int i10, int i11, int i12, int i13) {
        if (!rectEquals(this.expandedBounds, i10, i11, i12, i13)) {
            this.expandedBounds.set(i10, i11, i12, i13);
            this.boundsChanged = true;
            onBoundsChanged();
        }
    }

    public void setExpandedLetterSpacing(float f10) {
        if (this.expandedLetterSpacing != f10) {
            this.expandedLetterSpacing = f10;
            recalculate();
        }
    }

    public void setExpandedTextAppearance(int i10) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i10);
        if (textAppearance.getTextColor() != null) {
            this.expandedTextColor = textAppearance.getTextColor();
        }
        if (textAppearance.getTextSize() != 0.0f) {
            this.expandedTextSize = textAppearance.getTextSize();
        }
        ColorStateList colorStateList = textAppearance.shadowColor;
        if (colorStateList != null) {
            this.expandedShadowColor = colorStateList;
        }
        this.expandedShadowDx = textAppearance.shadowDx;
        this.expandedShadowDy = textAppearance.shadowDy;
        this.expandedShadowRadius = textAppearance.shadowRadius;
        this.expandedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.expandedFontCallback = new CancelableFontCallback(new b(), textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.expandedTextColor != colorStateList) {
            this.expandedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextGravity(int i10) {
        if (this.expandedTextGravity != i10) {
            this.expandedTextGravity = i10;
            recalculate();
        }
    }

    public void setExpandedTextSize(float f10) {
        if (this.expandedTextSize != f10) {
            this.expandedTextSize = f10;
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (setExpandedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpansionFraction(float f10) {
        float clamp = MathUtils.clamp(f10, 0.0f, 1.0f);
        if (clamp != this.expandedFraction) {
            this.expandedFraction = clamp;
            calculateCurrentOffsets();
        }
    }

    public void setFadeModeEnabled(boolean z10) {
        this.fadeModeEnabled = z10;
    }

    public void setFadeModeStartFraction(float f10) {
        this.fadeModeStartFraction = f10;
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
    }

    @RequiresApi(23)
    public void setHyphenationFrequency(int i10) {
        this.hyphenationFrequency = i10;
    }

    @RequiresApi(23)
    public void setLineSpacingAdd(float f10) {
        this.lineSpacingAdd = f10;
    }

    @RequiresApi(23)
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f10) {
        this.lineSpacingMultiplier = f10;
    }

    public void setMaxLines(int i10) {
        if (i10 != this.maxLines) {
            this.maxLines = i10;
            clearTexture();
            recalculate();
        }
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        this.positionInterpolator = timeInterpolator;
        recalculate();
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z10) {
        this.isRtlTextDirectionHeuristicsEnabled = z10;
    }

    public final boolean setState(int[] iArr) {
        this.state = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textToDraw = null;
            clearTexture();
            recalculate();
        }
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        this.textSizeInterpolator = timeInterpolator;
        recalculate();
    }

    public void setTypefaces(Typeface typeface) {
        boolean collapsedTypefaceInternal = setCollapsedTypefaceInternal(typeface);
        boolean expandedTypefaceInternal = setExpandedTypefaceInternal(typeface);
        if (collapsedTypefaceInternal || expandedTypefaceInternal) {
            recalculate();
        }
    }

    private void calculateUsingTextSize(float f10, boolean z10) {
        float f11;
        float f12;
        boolean z11;
        boolean z12;
        if (this.text != null) {
            float width = (float) this.collapsedBounds.width();
            float width2 = (float) this.expandedBounds.width();
            boolean z13 = false;
            int i10 = 1;
            if (isClose(f10, 1.0f)) {
                f12 = this.collapsedTextSize;
                f11 = this.collapsedLetterSpacing;
                this.scale = 1.0f;
                Typeface typeface = this.currentTypeface;
                Typeface typeface2 = this.collapsedTypeface;
                if (typeface != typeface2) {
                    this.currentTypeface = typeface2;
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else {
                float f13 = this.expandedTextSize;
                float f14 = this.expandedLetterSpacing;
                Typeface typeface3 = this.currentTypeface;
                Typeface typeface4 = this.expandedTypeface;
                if (typeface3 != typeface4) {
                    this.currentTypeface = typeface4;
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (isClose(f10, 0.0f)) {
                    this.scale = 1.0f;
                } else {
                    this.scale = lerp(this.expandedTextSize, this.collapsedTextSize, f10, this.textSizeInterpolator) / this.expandedTextSize;
                }
                float f15 = this.collapsedTextSize / this.expandedTextSize;
                float f16 = width2 * f15;
                if (!z10 && f16 > width) {
                    width = Math.min(width / f15, width2);
                } else {
                    width = width2;
                }
                f12 = f13;
                f11 = f14;
                z11 = z12;
            }
            if (width > 0.0f) {
                z11 = ((this.currentTextSize > f12 ? 1 : (this.currentTextSize == f12 ? 0 : -1)) != 0) || ((this.currentLetterSpacing > f11 ? 1 : (this.currentLetterSpacing == f11 ? 0 : -1)) != 0) || this.boundsChanged || z11;
                this.currentTextSize = f12;
                this.currentLetterSpacing = f11;
                this.boundsChanged = false;
            }
            if (this.textToDraw == null || z11) {
                this.textPaint.setTextSize(this.currentTextSize);
                this.textPaint.setTypeface(this.currentTypeface);
                this.textPaint.setLetterSpacing(this.currentLetterSpacing);
                TextPaint textPaint2 = this.textPaint;
                if (this.scale != 1.0f) {
                    z13 = true;
                }
                textPaint2.setLinearText(z13);
                this.isRtl = calculateIsRtl(this.text);
                if (shouldDrawMultiline()) {
                    i10 = this.maxLines;
                }
                StaticLayout createStaticLayout = createStaticLayout(i10, width, this.isRtl);
                this.textLayout = createStaticLayout;
                this.textToDraw = createStaticLayout.getText();
            }
        }
    }

    public void recalculate(boolean z10) {
        if ((this.view.getHeight() > 0 && this.view.getWidth() > 0) || z10) {
            calculateBaseOffsets(z10);
            calculateCurrentOffsets();
        }
    }

    public void setCollapsedBounds(@NonNull Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setExpandedBounds(@NonNull Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
