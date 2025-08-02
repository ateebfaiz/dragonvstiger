package com.google.android.material.color;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.R;

public class HarmonizedColorsOptions {
    @AttrRes
    private final int colorAttributeToHarmonizeWith;
    @Nullable
    private final HarmonizedColorAttributes colorAttributes;
    @NonNull
    @ColorRes
    private final int[] colorResourceIds;

    public static class Builder {
        /* access modifiers changed from: private */
        @AttrRes
        public int colorAttributeToHarmonizeWith = R.attr.colorPrimary;
        /* access modifiers changed from: private */
        @Nullable
        public HarmonizedColorAttributes colorAttributes;
        /* access modifiers changed from: private */
        @NonNull
        @ColorRes
        public int[] colorResourceIds = new int[0];

        @NonNull
        public HarmonizedColorsOptions build() {
            return new HarmonizedColorsOptions(this);
        }

        @NonNull
        public Builder setColorAttributeToHarmonizeWith(@AttrRes int i10) {
            this.colorAttributeToHarmonizeWith = i10;
            return this;
        }

        @NonNull
        public Builder setColorAttributes(@Nullable HarmonizedColorAttributes harmonizedColorAttributes) {
            this.colorAttributes = harmonizedColorAttributes;
            return this;
        }

        @NonNull
        public Builder setColorResourceIds(@NonNull @ColorRes int[] iArr) {
            this.colorResourceIds = iArr;
            return this;
        }
    }

    @NonNull
    public static HarmonizedColorsOptions createMaterialDefaults() {
        return new Builder().setColorAttributes(HarmonizedColorAttributes.createMaterialDefaults()).build();
    }

    @AttrRes
    public int getColorAttributeToHarmonizeWith() {
        return this.colorAttributeToHarmonizeWith;
    }

    @Nullable
    public HarmonizedColorAttributes getColorAttributes() {
        return this.colorAttributes;
    }

    @NonNull
    @ColorRes
    public int[] getColorResourceIds() {
        return this.colorResourceIds;
    }

    /* access modifiers changed from: package-private */
    @StyleRes
    public int getThemeOverlayResourceId(@StyleRes int i10) {
        HarmonizedColorAttributes harmonizedColorAttributes = this.colorAttributes;
        if (harmonizedColorAttributes == null || harmonizedColorAttributes.getThemeOverlay() == 0) {
            return i10;
        }
        return this.colorAttributes.getThemeOverlay();
    }

    private HarmonizedColorsOptions(Builder builder) {
        this.colorResourceIds = builder.colorResourceIds;
        this.colorAttributes = builder.colorAttributes;
        this.colorAttributeToHarmonizeWith = builder.colorAttributeToHarmonizeWith;
    }
}
