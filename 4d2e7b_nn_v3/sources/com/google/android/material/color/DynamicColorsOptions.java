package com.google.android.material.color;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import com.google.android.material.color.DynamicColors;

public class DynamicColorsOptions {
    /* access modifiers changed from: private */
    public static final DynamicColors.Precondition ALWAYS_ALLOW = new a();
    /* access modifiers changed from: private */
    public static final DynamicColors.OnAppliedCallback NO_OP_CALLBACK = new b();
    @NonNull
    private final DynamicColors.OnAppliedCallback onAppliedCallback;
    @NonNull
    private final DynamicColors.Precondition precondition;
    @StyleRes
    private final int themeOverlay;

    public static class Builder {
        /* access modifiers changed from: private */
        @NonNull
        public DynamicColors.OnAppliedCallback onAppliedCallback = DynamicColorsOptions.NO_OP_CALLBACK;
        /* access modifiers changed from: private */
        @NonNull
        public DynamicColors.Precondition precondition = DynamicColorsOptions.ALWAYS_ALLOW;
        /* access modifiers changed from: private */
        @StyleRes
        public int themeOverlay;

        @NonNull
        public DynamicColorsOptions build() {
            return new DynamicColorsOptions(this, (a) null);
        }

        @NonNull
        public Builder setOnAppliedCallback(@NonNull DynamicColors.OnAppliedCallback onAppliedCallback2) {
            this.onAppliedCallback = onAppliedCallback2;
            return this;
        }

        @NonNull
        public Builder setPrecondition(@NonNull DynamicColors.Precondition precondition2) {
            this.precondition = precondition2;
            return this;
        }

        @NonNull
        public Builder setThemeOverlay(@StyleRes int i10) {
            this.themeOverlay = i10;
            return this;
        }
    }

    class a implements DynamicColors.Precondition {
        a() {
        }

        public boolean shouldApplyDynamicColors(Activity activity, int i10) {
            return true;
        }
    }

    class b implements DynamicColors.OnAppliedCallback {
        b() {
        }

        public void onApplied(Activity activity) {
        }
    }

    /* synthetic */ DynamicColorsOptions(Builder builder, a aVar) {
        this(builder);
    }

    @NonNull
    public DynamicColors.OnAppliedCallback getOnAppliedCallback() {
        return this.onAppliedCallback;
    }

    @NonNull
    public DynamicColors.Precondition getPrecondition() {
        return this.precondition;
    }

    @StyleRes
    public int getThemeOverlay() {
        return this.themeOverlay;
    }

    private DynamicColorsOptions(Builder builder) {
        this.themeOverlay = builder.themeOverlay;
        this.precondition = builder.precondition;
        this.onAppliedCallback = builder.onAppliedCallback;
    }
}
