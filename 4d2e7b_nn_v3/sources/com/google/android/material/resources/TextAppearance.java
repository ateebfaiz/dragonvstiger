package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextPaint;
import android.util.Log;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextAppearance {
    private static final String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    /* access modifiers changed from: private */
    public Typeface font;
    @Nullable
    public final String fontFamily;
    @FontRes
    private final int fontFamilyResourceId;
    /* access modifiers changed from: private */
    public boolean fontResolved = false;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;
    @Nullable
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;
    @Nullable
    private ColorStateList textColor;
    @Nullable
    public final ColorStateList textColorHint;
    @Nullable
    public final ColorStateList textColorLink;
    private float textSize;
    public final int textStyle;
    public final int typeface;

    class a extends ResourcesCompat.FontCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextAppearanceFontCallback f8426a;

        a(TextAppearanceFontCallback textAppearanceFontCallback) {
            this.f8426a = textAppearanceFontCallback;
        }

        public void onFontRetrievalFailed(int i10) {
            boolean unused = TextAppearance.this.fontResolved = true;
            this.f8426a.onFontRetrievalFailed(i10);
        }

        public void onFontRetrieved(Typeface typeface) {
            TextAppearance textAppearance = TextAppearance.this;
            Typeface unused = textAppearance.font = Typeface.create(typeface, textAppearance.textStyle);
            boolean unused2 = TextAppearance.this.fontResolved = true;
            this.f8426a.onFontRetrieved(TextAppearance.this.font, false);
        }
    }

    class b extends TextAppearanceFontCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f8428a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextPaint f8429b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextAppearanceFontCallback f8430c;

        b(Context context, TextPaint textPaint, TextAppearanceFontCallback textAppearanceFontCallback) {
            this.f8428a = context;
            this.f8429b = textPaint;
            this.f8430c = textAppearanceFontCallback;
        }

        public void onFontRetrievalFailed(int i10) {
            this.f8430c.onFontRetrievalFailed(i10);
        }

        public void onFontRetrieved(Typeface typeface, boolean z10) {
            TextAppearance.this.updateTextPaintMeasureState(this.f8428a, this.f8429b, typeface);
            this.f8430c.onFontRetrieved(typeface, z10);
        }
    }

    public TextAppearance(@NonNull Context context, @StyleRes int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, R.styleable.TextAppearance);
        setTextSize(obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f));
        setTextColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor));
        this.textColorHint = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int indexWithValue = MaterialResources.getIndexWithValue(obtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = obtainStyledAttributes.getResourceId(indexWithValue, 0);
        this.fontFamily = obtainStyledAttributes.getString(indexWithValue);
        this.textAllCaps = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i10, R.styleable.MaterialTextAppearance);
        this.hasLetterSpacing = obtainStyledAttributes2.hasValue(R.styleable.MaterialTextAppearance_android_letterSpacing);
        this.letterSpacing = obtainStyledAttributes2.getFloat(R.styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    private void createFallbackFont() {
        String str;
        if (this.font == null && (str = this.fontFamily) != null) {
            this.font = Typeface.create(str, this.textStyle);
        }
        if (this.font == null) {
            int i10 = this.typeface;
            if (i10 == 1) {
                this.font = Typeface.SANS_SERIF;
            } else if (i10 == 2) {
                this.font = Typeface.SERIF;
            } else if (i10 != 3) {
                this.font = Typeface.DEFAULT;
            } else {
                this.font = Typeface.MONOSPACE;
            }
            this.font = Typeface.create(this.font, this.textStyle);
        }
    }

    private boolean shouldLoadFontSynchronously(Context context) {
        Typeface typeface2;
        if (TextAppearanceConfig.shouldLoadFontSynchronously()) {
            return true;
        }
        int i10 = this.fontFamilyResourceId;
        if (i10 != 0) {
            typeface2 = ResourcesCompat.getCachedFont(context, i10);
        } else {
            typeface2 = null;
        }
        if (typeface2 != null) {
            return true;
        }
        return false;
    }

    public Typeface getFallbackFont() {
        createFallbackFont();
        return this.font;
    }

    @VisibleForTesting
    @NonNull
    public Typeface getFont(@NonNull Context context) {
        if (this.fontResolved) {
            return this.font;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font2 = ResourcesCompat.getFont(context, this.fontFamilyResourceId);
                this.font = font2;
                if (font2 != null) {
                    this.font = Typeface.create(font2, this.textStyle);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e10) {
                Log.d(TAG, "Error loading font " + this.fontFamily, e10);
            }
        }
        createFallbackFont();
        this.fontResolved = true;
        return this.font;
    }

    public void getFontAsync(@NonNull Context context, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        if (shouldLoadFontSynchronously(context)) {
            getFont(context);
        } else {
            createFallbackFont();
        }
        int i10 = this.fontFamilyResourceId;
        if (i10 == 0) {
            this.fontResolved = true;
        }
        if (this.fontResolved) {
            textAppearanceFontCallback.onFontRetrieved(this.font, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i10, new a(textAppearanceFontCallback), (Handler) null);
        } catch (Resources.NotFoundException unused) {
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(1);
        } catch (Exception e10) {
            Log.d(TAG, "Error loading font " + this.fontFamily, e10);
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(-3);
        }
    }

    @Nullable
    public ColorStateList getTextColor() {
        return this.textColor;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        this.textColor = colorStateList;
    }

    public void setTextSize(float f10) {
        this.textSize = f10;
    }

    public void updateDrawState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        int i10;
        int i11;
        updateMeasureState(context, textPaint, textAppearanceFontCallback);
        ColorStateList colorStateList = this.textColor;
        if (colorStateList != null) {
            i10 = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
        } else {
            i10 = ViewCompat.MEASURED_STATE_MASK;
        }
        textPaint.setColor(i10);
        float f10 = this.shadowRadius;
        float f11 = this.shadowDx;
        float f12 = this.shadowDy;
        ColorStateList colorStateList2 = this.shadowColor;
        if (colorStateList2 != null) {
            i11 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
        } else {
            i11 = 0;
        }
        textPaint.setShadowLayer(f10, f11, f12, i11);
    }

    public void updateMeasureState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        if (shouldLoadFontSynchronously(context)) {
            updateTextPaintMeasureState(context, textPaint, getFont(context));
        } else {
            getFontAsync(context, textPaint, textAppearanceFontCallback);
        }
    }

    public void updateTextPaintMeasureState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull Typeface typeface2) {
        boolean z10;
        float f10;
        Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(context, typeface2);
        if (maybeCopyWithFontWeightAdjustment != null) {
            typeface2 = maybeCopyWithFontWeightAdjustment;
        }
        textPaint.setTypeface(typeface2);
        int i10 = this.textStyle & (~typeface2.getStyle());
        if ((i10 & 1) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        textPaint.setFakeBoldText(z10);
        if ((i10 & 2) != 0) {
            f10 = -0.25f;
        } else {
            f10 = 0.0f;
        }
        textPaint.setTextSkewX(f10);
        textPaint.setTextSize(this.textSize);
        if (this.hasLetterSpacing) {
            textPaint.setLetterSpacing(this.letterSpacing);
        }
    }

    public void getFontAsync(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        updateTextPaintMeasureState(context, textPaint, getFallbackFont());
        getFontAsync(context, new b(context, textPaint, textAppearanceFontCallback));
    }
}
