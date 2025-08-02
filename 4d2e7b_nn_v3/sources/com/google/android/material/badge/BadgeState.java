package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class BadgeState {
    private static final String BADGE_RESOURCE_TAG = "badge";
    private static final int DEFAULT_MAX_BADGE_CHARACTER_COUNT = 4;
    final float badgeRadius;
    final float badgeWidePadding;
    final float badgeWithTextRadius;
    private final State currentState;
    private final State overridingState;

    BadgeState(Context context, @XmlRes int i10, @AttrRes int i11, @StyleRes int i12, @Nullable State state) {
        int i13;
        CharSequence charSequence;
        int i14;
        int i15;
        boolean z10;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        Locale locale;
        State state2 = new State();
        this.currentState = state2;
        state = state == null ? new State() : state;
        if (i10 != 0) {
            int unused = state.badgeResId = i10;
        }
        TypedArray generateTypedArray = generateTypedArray(context, state.badgeResId, i11, i12);
        Resources resources = context.getResources();
        this.badgeRadius = (float) generateTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeRadius, resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius));
        this.badgeWidePadding = (float) generateTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeWidePadding, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding));
        this.badgeWithTextRadius = (float) generateTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeWithTextRadius, resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius));
        if (state.alpha == -2) {
            i13 = 255;
        } else {
            i13 = state.alpha;
        }
        int unused2 = state2.alpha = i13;
        if (state.contentDescriptionNumberless == null) {
            charSequence = context.getString(R.string.mtrl_badge_numberless_content_description);
        } else {
            charSequence = state.contentDescriptionNumberless;
        }
        CharSequence unused3 = state2.contentDescriptionNumberless = charSequence;
        if (state.contentDescriptionQuantityStrings == 0) {
            i14 = R.plurals.mtrl_badge_content_description;
        } else {
            i14 = state.contentDescriptionQuantityStrings;
        }
        int unused4 = state2.contentDescriptionQuantityStrings = i14;
        if (state.contentDescriptionExceedsMaxBadgeNumberRes == 0) {
            i15 = R.string.mtrl_exceed_max_badge_number_content_description;
        } else {
            i15 = state.contentDescriptionExceedsMaxBadgeNumberRes;
        }
        int unused5 = state2.contentDescriptionExceedsMaxBadgeNumberRes = i15;
        int i24 = 0;
        if (state.isVisible == null || state.isVisible.booleanValue()) {
            z10 = true;
        } else {
            z10 = false;
        }
        Boolean unused6 = state2.isVisible = Boolean.valueOf(z10);
        if (state.maxCharacterCount == -2) {
            i16 = generateTypedArray.getInt(R.styleable.Badge_maxCharacterCount, 4);
        } else {
            i16 = state.maxCharacterCount;
        }
        int unused7 = state2.maxCharacterCount = i16;
        if (state.number != -2) {
            int unused8 = state2.number = state.number;
        } else if (generateTypedArray.hasValue(R.styleable.Badge_number)) {
            int unused9 = state2.number = generateTypedArray.getInt(R.styleable.Badge_number, 0);
        } else {
            int unused10 = state2.number = -1;
        }
        if (state.backgroundColor == null) {
            i17 = readColorFromAttributes(context, generateTypedArray, R.styleable.Badge_backgroundColor);
        } else {
            i17 = state.backgroundColor.intValue();
        }
        Integer unused11 = state2.backgroundColor = Integer.valueOf(i17);
        if (state.badgeTextColor != null) {
            Integer unused12 = state2.badgeTextColor = state.badgeTextColor;
        } else if (generateTypedArray.hasValue(R.styleable.Badge_badgeTextColor)) {
            Integer unused13 = state2.badgeTextColor = Integer.valueOf(readColorFromAttributes(context, generateTypedArray, R.styleable.Badge_badgeTextColor));
        } else {
            Integer unused14 = state2.badgeTextColor = Integer.valueOf(new TextAppearance(context, R.style.TextAppearance_MaterialComponents_Badge).getTextColor().getDefaultColor());
        }
        if (state.badgeGravity == null) {
            i18 = generateTypedArray.getInt(R.styleable.Badge_badgeGravity, 8388661);
        } else {
            i18 = state.badgeGravity.intValue();
        }
        Integer unused15 = state2.badgeGravity = Integer.valueOf(i18);
        if (state.horizontalOffsetWithoutText == null) {
            i19 = generateTypedArray.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0);
        } else {
            i19 = state.horizontalOffsetWithoutText.intValue();
        }
        Integer unused16 = state2.horizontalOffsetWithoutText = Integer.valueOf(i19);
        if (state.horizontalOffsetWithoutText == null) {
            i20 = generateTypedArray.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0);
        } else {
            i20 = state.verticalOffsetWithoutText.intValue();
        }
        Integer unused17 = state2.verticalOffsetWithoutText = Integer.valueOf(i20);
        if (state.horizontalOffsetWithText == null) {
            i21 = generateTypedArray.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, state2.horizontalOffsetWithoutText.intValue());
        } else {
            i21 = state.horizontalOffsetWithText.intValue();
        }
        Integer unused18 = state2.horizontalOffsetWithText = Integer.valueOf(i21);
        if (state.verticalOffsetWithText == null) {
            i22 = generateTypedArray.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, state2.verticalOffsetWithoutText.intValue());
        } else {
            i22 = state.verticalOffsetWithText.intValue();
        }
        Integer unused19 = state2.verticalOffsetWithText = Integer.valueOf(i22);
        if (state.additionalHorizontalOffset == null) {
            i23 = 0;
        } else {
            i23 = state.additionalHorizontalOffset.intValue();
        }
        Integer unused20 = state2.additionalHorizontalOffset = Integer.valueOf(i23);
        Integer unused21 = state2.additionalVerticalOffset = Integer.valueOf(state.additionalVerticalOffset != null ? state.additionalVerticalOffset.intValue() : i24);
        generateTypedArray.recycle();
        if (state.numberLocale == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = Locale.getDefault(Locale.Category.FORMAT);
            } else {
                locale = Locale.getDefault();
            }
            Locale unused22 = state2.numberLocale = locale;
        } else {
            Locale unused23 = state2.numberLocale = state.numberLocale;
        }
        this.overridingState = state;
    }

    private TypedArray generateTypedArray(Context context, @XmlRes int i10, @AttrRes int i11, @StyleRes int i12) {
        AttributeSet attributeSet;
        int i13;
        int i14;
        if (i10 != 0) {
            AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context, i10, BADGE_RESOURCE_TAG);
            i13 = parseDrawableXml.getStyleAttribute();
            attributeSet = parseDrawableXml;
        } else {
            attributeSet = null;
            i13 = 0;
        }
        if (i13 == 0) {
            i14 = i12;
        } else {
            i14 = i13;
        }
        return ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Badge, i11, i14, new int[0]);
    }

    private static int readColorFromAttributes(Context context, @NonNull TypedArray typedArray, @StyleableRes int i10) {
        return MaterialResources.getColorStateList(context, typedArray, i10).getDefaultColor();
    }

    /* access modifiers changed from: package-private */
    public void clearNumber() {
        setNumber(-1);
    }

    /* access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int getAdditionalHorizontalOffset() {
        return this.currentState.additionalHorizontalOffset.intValue();
    }

    /* access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int getAdditionalVerticalOffset() {
        return this.currentState.additionalVerticalOffset.intValue();
    }

    /* access modifiers changed from: package-private */
    public int getAlpha() {
        return this.currentState.alpha;
    }

    /* access modifiers changed from: package-private */
    @ColorInt
    public int getBackgroundColor() {
        return this.currentState.backgroundColor.intValue();
    }

    /* access modifiers changed from: package-private */
    public int getBadgeGravity() {
        return this.currentState.badgeGravity.intValue();
    }

    /* access modifiers changed from: package-private */
    @ColorInt
    public int getBadgeTextColor() {
        return this.currentState.badgeTextColor.intValue();
    }

    /* access modifiers changed from: package-private */
    @StringRes
    public int getContentDescriptionExceedsMaxBadgeNumberStringResource() {
        return this.currentState.contentDescriptionExceedsMaxBadgeNumberRes;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getContentDescriptionNumberless() {
        return this.currentState.contentDescriptionNumberless;
    }

    /* access modifiers changed from: package-private */
    @PluralsRes
    public int getContentDescriptionQuantityStrings() {
        return this.currentState.contentDescriptionQuantityStrings;
    }

    /* access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int getHorizontalOffsetWithText() {
        return this.currentState.horizontalOffsetWithText.intValue();
    }

    /* access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int getHorizontalOffsetWithoutText() {
        return this.currentState.horizontalOffsetWithoutText.intValue();
    }

    /* access modifiers changed from: package-private */
    public int getMaxCharacterCount() {
        return this.currentState.maxCharacterCount;
    }

    /* access modifiers changed from: package-private */
    public int getNumber() {
        return this.currentState.number;
    }

    /* access modifiers changed from: package-private */
    public Locale getNumberLocale() {
        return this.currentState.numberLocale;
    }

    /* access modifiers changed from: package-private */
    public State getOverridingState() {
        return this.overridingState;
    }

    /* access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int getVerticalOffsetWithText() {
        return this.currentState.verticalOffsetWithText.intValue();
    }

    /* access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int getVerticalOffsetWithoutText() {
        return this.currentState.verticalOffsetWithoutText.intValue();
    }

    /* access modifiers changed from: package-private */
    public boolean hasNumber() {
        if (this.currentState.number != -1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isVisible() {
        return this.currentState.isVisible.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public void setAdditionalHorizontalOffset(@Dimension(unit = 1) int i10) {
        Integer unused = this.overridingState.additionalHorizontalOffset = Integer.valueOf(i10);
        Integer unused2 = this.currentState.additionalHorizontalOffset = Integer.valueOf(i10);
    }

    /* access modifiers changed from: package-private */
    public void setAdditionalVerticalOffset(@Dimension(unit = 1) int i10) {
        Integer unused = this.overridingState.additionalVerticalOffset = Integer.valueOf(i10);
        Integer unused2 = this.currentState.additionalVerticalOffset = Integer.valueOf(i10);
    }

    /* access modifiers changed from: package-private */
    public void setAlpha(int i10) {
        int unused = this.overridingState.alpha = i10;
        int unused2 = this.currentState.alpha = i10;
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundColor(@ColorInt int i10) {
        Integer unused = this.overridingState.backgroundColor = Integer.valueOf(i10);
        Integer unused2 = this.currentState.backgroundColor = Integer.valueOf(i10);
    }

    /* access modifiers changed from: package-private */
    public void setBadgeGravity(int i10) {
        Integer unused = this.overridingState.badgeGravity = Integer.valueOf(i10);
        Integer unused2 = this.currentState.badgeGravity = Integer.valueOf(i10);
    }

    /* access modifiers changed from: package-private */
    public void setBadgeTextColor(@ColorInt int i10) {
        Integer unused = this.overridingState.badgeTextColor = Integer.valueOf(i10);
        Integer unused2 = this.currentState.badgeTextColor = Integer.valueOf(i10);
    }

    /* access modifiers changed from: package-private */
    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int i10) {
        int unused = this.overridingState.contentDescriptionExceedsMaxBadgeNumberRes = i10;
        int unused2 = this.currentState.contentDescriptionExceedsMaxBadgeNumberRes = i10;
    }

    /* access modifiers changed from: package-private */
    public void setContentDescriptionNumberless(CharSequence charSequence) {
        CharSequence unused = this.overridingState.contentDescriptionNumberless = charSequence;
        CharSequence unused2 = this.currentState.contentDescriptionNumberless = charSequence;
    }

    /* access modifiers changed from: package-private */
    public void setContentDescriptionQuantityStringsResource(@PluralsRes int i10) {
        int unused = this.overridingState.contentDescriptionQuantityStrings = i10;
        int unused2 = this.currentState.contentDescriptionQuantityStrings = i10;
    }

    /* access modifiers changed from: package-private */
    public void setHorizontalOffsetWithText(@Dimension(unit = 1) int i10) {
        Integer unused = this.overridingState.horizontalOffsetWithText = Integer.valueOf(i10);
        Integer unused2 = this.currentState.horizontalOffsetWithText = Integer.valueOf(i10);
    }

    /* access modifiers changed from: package-private */
    public void setHorizontalOffsetWithoutText(@Dimension(unit = 1) int i10) {
        Integer unused = this.overridingState.horizontalOffsetWithoutText = Integer.valueOf(i10);
        Integer unused2 = this.currentState.horizontalOffsetWithoutText = Integer.valueOf(i10);
    }

    /* access modifiers changed from: package-private */
    public void setMaxCharacterCount(int i10) {
        int unused = this.overridingState.maxCharacterCount = i10;
        int unused2 = this.currentState.maxCharacterCount = i10;
    }

    /* access modifiers changed from: package-private */
    public void setNumber(int i10) {
        int unused = this.overridingState.number = i10;
        int unused2 = this.currentState.number = i10;
    }

    /* access modifiers changed from: package-private */
    public void setNumberLocale(Locale locale) {
        Locale unused = this.overridingState.numberLocale = locale;
        Locale unused2 = this.currentState.numberLocale = locale;
    }

    /* access modifiers changed from: package-private */
    public void setVerticalOffsetWithText(@Dimension(unit = 1) int i10) {
        Integer unused = this.overridingState.verticalOffsetWithText = Integer.valueOf(i10);
        Integer unused2 = this.currentState.verticalOffsetWithText = Integer.valueOf(i10);
    }

    /* access modifiers changed from: package-private */
    public void setVerticalOffsetWithoutText(@Dimension(unit = 1) int i10) {
        Integer unused = this.overridingState.verticalOffsetWithoutText = Integer.valueOf(i10);
        Integer unused2 = this.currentState.verticalOffsetWithoutText = Integer.valueOf(i10);
    }

    /* access modifiers changed from: package-private */
    public void setVisible(boolean z10) {
        Boolean unused = this.overridingState.isVisible = Boolean.valueOf(z10);
        Boolean unused2 = this.currentState.isVisible = Boolean.valueOf(z10);
    }

    public static final class State implements Parcelable {
        private static final int BADGE_NUMBER_NONE = -1;
        public static final Parcelable.Creator<State> CREATOR = new a();
        private static final int NOT_SET = -2;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public Integer additionalHorizontalOffset;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public Integer additionalVerticalOffset;
        /* access modifiers changed from: private */
        public int alpha = 255;
        /* access modifiers changed from: private */
        @ColorInt
        public Integer backgroundColor;
        /* access modifiers changed from: private */
        public Integer badgeGravity;
        /* access modifiers changed from: private */
        @XmlRes
        public int badgeResId;
        /* access modifiers changed from: private */
        @ColorInt
        public Integer badgeTextColor;
        /* access modifiers changed from: private */
        @StringRes
        public int contentDescriptionExceedsMaxBadgeNumberRes;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence contentDescriptionNumberless;
        /* access modifiers changed from: private */
        @PluralsRes
        public int contentDescriptionQuantityStrings;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public Integer horizontalOffsetWithText;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public Integer horizontalOffsetWithoutText;
        /* access modifiers changed from: private */
        public Boolean isVisible = Boolean.TRUE;
        /* access modifiers changed from: private */
        public int maxCharacterCount = -2;
        /* access modifiers changed from: private */
        public int number = -2;
        /* access modifiers changed from: private */
        public Locale numberLocale;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public Integer verticalOffsetWithText;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public Integer verticalOffsetWithoutText;

        class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public State createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            /* renamed from: b */
            public State[] newArray(int i10) {
                return new State[i10];
            }
        }

        public State() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            String str;
            parcel.writeInt(this.badgeResId);
            parcel.writeSerializable(this.backgroundColor);
            parcel.writeSerializable(this.badgeTextColor);
            parcel.writeInt(this.alpha);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            CharSequence charSequence = this.contentDescriptionNumberless;
            if (charSequence == null) {
                str = null;
            } else {
                str = charSequence.toString();
            }
            parcel.writeString(str);
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeSerializable(this.badgeGravity);
            parcel.writeSerializable(this.horizontalOffsetWithoutText);
            parcel.writeSerializable(this.verticalOffsetWithoutText);
            parcel.writeSerializable(this.horizontalOffsetWithText);
            parcel.writeSerializable(this.verticalOffsetWithText);
            parcel.writeSerializable(this.additionalHorizontalOffset);
            parcel.writeSerializable(this.additionalVerticalOffset);
            parcel.writeSerializable(this.isVisible);
            parcel.writeSerializable(this.numberLocale);
        }

        State(@NonNull Parcel parcel) {
            this.badgeResId = parcel.readInt();
            this.backgroundColor = (Integer) parcel.readSerializable();
            this.badgeTextColor = (Integer) parcel.readSerializable();
            this.alpha = parcel.readInt();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = (Integer) parcel.readSerializable();
            this.horizontalOffsetWithoutText = (Integer) parcel.readSerializable();
            this.verticalOffsetWithoutText = (Integer) parcel.readSerializable();
            this.horizontalOffsetWithText = (Integer) parcel.readSerializable();
            this.verticalOffsetWithText = (Integer) parcel.readSerializable();
            this.additionalHorizontalOffset = (Integer) parcel.readSerializable();
            this.additionalVerticalOffset = (Integer) parcel.readSerializable();
            this.isVisible = (Boolean) parcel.readSerializable();
            this.numberLocale = (Locale) parcel.readSerializable();
        }
    }
}
