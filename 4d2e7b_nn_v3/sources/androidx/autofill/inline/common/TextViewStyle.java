package androidx.autofill.inline.common;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.autofill.inline.common.ViewStyle;
import androidx.core.util.Preconditions;

@RequiresApi(api = 30)
public final class TextViewStyle extends ViewStyle {
    private static final String KEY_TEXT_COLOR = "text_color";
    private static final String KEY_TEXT_FONT_FAMILY = "text_font_family";
    private static final String KEY_TEXT_FONT_STYLE = "text_font_style";
    private static final String KEY_TEXT_SIZE = "text_size";
    private static final String KEY_TEXT_SIZE_UNIT = "text_size_unit";
    private static final String KEY_TEXT_VIEW_STYLE = "text_view_style";

    public static final class Builder extends ViewStyle.BaseBuilder<TextViewStyle, Builder> {
        public Builder() {
            super(TextViewStyle.KEY_TEXT_VIEW_STYLE);
        }

        /* access modifiers changed from: protected */
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder getThis() {
            return this;
        }

        @NonNull
        public Builder setTextColor(@ColorInt int i10) {
            this.mBundle.putInt(TextViewStyle.KEY_TEXT_COLOR, i10);
            return this;
        }

        @NonNull
        public Builder setTextSize(float f10) {
            this.mBundle.putFloat(TextViewStyle.KEY_TEXT_SIZE, f10);
            return this;
        }

        @NonNull
        public Builder setTypeface(@NonNull String str, int i10) {
            Preconditions.checkNotNull(str, "fontFamily should not be null");
            this.mBundle.putString(TextViewStyle.KEY_TEXT_FONT_FAMILY, str);
            this.mBundle.putInt(TextViewStyle.KEY_TEXT_FONT_STYLE, i10);
            return this;
        }

        @NonNull
        public TextViewStyle build() {
            return new TextViewStyle(this.mBundle);
        }

        @NonNull
        public Builder setTextSize(int i10, float f10) {
            this.mBundle.putInt(TextViewStyle.KEY_TEXT_SIZE_UNIT, i10);
            this.mBundle.putFloat(TextViewStyle.KEY_TEXT_SIZE, f10);
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public TextViewStyle(@NonNull Bundle bundle) {
        super(bundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void applyStyleOnTextViewIfValid(@NonNull TextView textView) {
        int i10;
        if (isValid()) {
            super.applyStyleOnViewIfValid(textView);
            if (this.mBundle.containsKey(KEY_TEXT_COLOR)) {
                textView.setTextColor(this.mBundle.getInt(KEY_TEXT_COLOR));
            }
            if (this.mBundle.containsKey(KEY_TEXT_SIZE)) {
                if (this.mBundle.containsKey(KEY_TEXT_SIZE_UNIT)) {
                    i10 = this.mBundle.getInt(KEY_TEXT_SIZE_UNIT);
                } else {
                    i10 = 2;
                }
                textView.setTextSize(i10, this.mBundle.getFloat(KEY_TEXT_SIZE));
            }
            if (this.mBundle.containsKey(KEY_TEXT_FONT_FAMILY)) {
                String string = this.mBundle.getString(KEY_TEXT_FONT_FAMILY);
                if (!TextUtils.isEmpty(string)) {
                    textView.setTypeface(Typeface.create(string, this.mBundle.getInt(KEY_TEXT_FONT_STYLE)));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String getStyleKey() {
        return KEY_TEXT_VIEW_STYLE;
    }
}
