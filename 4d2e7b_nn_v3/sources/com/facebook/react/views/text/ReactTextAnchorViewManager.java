package com.facebook.react.views.text;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.autofill.HintConstants;
import androidx.core.view.ViewCompat;
import com.adjust.sdk.Constants;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.g0;
import com.facebook.react.views.text.c;
import com.facebook.yoga.e;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import h7.a;
import h7.b;

public abstract class ReactTextAnchorViewManager<T extends View, C extends c> extends BaseViewManager<T, C> {
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    private static final String TAG = "ReactTextAnchorViewManager";

    @a(name = "accessible")
    public void setAccessible(ReactTextView reactTextView, boolean z10) {
        reactTextView.setFocusable(z10);
    }

    @a(name = "adjustsFontSizeToFit")
    public void setAdjustFontSizeToFit(ReactTextView reactTextView, boolean z10) {
        reactTextView.setAdjustFontSizeToFit(z10);
    }

    @a(name = "android_hyphenationFrequency")
    public void setAndroidHyphenationFrequency(ReactTextView reactTextView, @Nullable String str) {
        if (str == null || str.equals(DevicePublicKeyStringDef.NONE)) {
            reactTextView.setHyphenationFrequency(0);
        } else if (str.equals("full")) {
            reactTextView.setHyphenationFrequency(2);
        } else if (str.equals(Constants.NORMAL)) {
            reactTextView.setHyphenationFrequency(1);
        } else {
            z2.a.G("ReactNative", "Invalid android_hyphenationFrequency: " + str);
            reactTextView.setHyphenationFrequency(0);
        }
    }

    @b(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactTextView reactTextView, int i10, Integer num) {
        float f10;
        float f11 = Float.NaN;
        if (num == null) {
            f10 = Float.NaN;
        } else {
            f10 = (float) (num.intValue() & ViewCompat.MEASURED_SIZE_MASK);
        }
        if (num != null) {
            f11 = (float) (num.intValue() >>> 24);
        }
        reactTextView.e(SPACING_TYPES[i10], f10, f11);
    }

    @b(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactTextView reactTextView, int i10, float f10) {
        if (!e.a(f10)) {
            f10 = g0.d(f10);
        }
        if (i10 == 0) {
            reactTextView.setBorderRadius(f10);
        } else {
            reactTextView.f(f10, i10 - 1);
        }
    }

    @a(name = "borderStyle")
    public void setBorderStyle(ReactTextView reactTextView, @Nullable String str) {
        reactTextView.setBorderStyle(str);
    }

    @b(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactTextView reactTextView, int i10, float f10) {
        if (!e.a(f10)) {
            f10 = g0.d(f10);
        }
        reactTextView.g(SPACING_TYPES[i10], f10);
    }

    @a(name = "dataDetectorType")
    public void setDataDetectorType(ReactTextView reactTextView, @Nullable String str) {
        if (str != null) {
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1192969641:
                    if (str.equals(HintConstants.AUTOFILL_HINT_PHONE_NUMBER)) {
                        c10 = 0;
                        break;
                    }
                    break;
                case 96673:
                    if (str.equals("all")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 3321850:
                    if (str.equals("link")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 96619420:
                    if (str.equals("email")) {
                        c10 = 3;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    reactTextView.setLinkifyMask(4);
                    return;
                case 1:
                    reactTextView.setLinkifyMask(15);
                    return;
                case 2:
                    reactTextView.setLinkifyMask(1);
                    return;
                case 3:
                    reactTextView.setLinkifyMask(2);
                    return;
            }
        }
        reactTextView.setLinkifyMask(0);
    }

    @a(defaultBoolean = false, name = "disabled")
    public void setDisabled(ReactTextView reactTextView, boolean z10) {
        reactTextView.setEnabled(!z10);
    }

    @a(name = "ellipsizeMode")
    public void setEllipsizeMode(ReactTextView reactTextView, @Nullable String str) {
        if (str == null || str.equals("tail")) {
            reactTextView.setEllipsizeLocation(TextUtils.TruncateAt.END);
        } else if (str.equals("head")) {
            reactTextView.setEllipsizeLocation(TextUtils.TruncateAt.START);
        } else if (str.equals("middle")) {
            reactTextView.setEllipsizeLocation(TextUtils.TruncateAt.MIDDLE);
        } else if (str.equals("clip")) {
            reactTextView.setEllipsizeLocation((TextUtils.TruncateAt) null);
        } else {
            z2.a.G("ReactNative", "Invalid ellipsizeMode: " + str);
            reactTextView.setEllipsizeLocation(TextUtils.TruncateAt.END);
        }
    }

    @a(name = "fontSize")
    public void setFontSize(ReactTextView reactTextView, float f10) {
        reactTextView.setFontSize(f10);
    }

    @a(defaultBoolean = true, name = "includeFontPadding")
    public void setIncludeFontPadding(ReactTextView reactTextView, boolean z10) {
        reactTextView.setIncludeFontPadding(z10);
    }

    @a(defaultFloat = 0.0f, name = "letterSpacing")
    public void setLetterSpacing(ReactTextView reactTextView, float f10) {
        reactTextView.setLetterSpacing(f10);
    }

    @a(name = "onInlineViewLayout")
    public void setNotifyOnInlineViewLayout(ReactTextView reactTextView, boolean z10) {
        reactTextView.setNotifyOnInlineViewLayout(z10);
    }

    @a(defaultInt = Integer.MAX_VALUE, name = "numberOfLines")
    public void setNumberOfLines(ReactTextView reactTextView, int i10) {
        reactTextView.setNumberOfLines(i10);
    }

    @a(name = "selectable")
    public void setSelectable(ReactTextView reactTextView, boolean z10) {
        reactTextView.setTextIsSelectable(z10);
    }

    @a(customType = "Color", name = "selectionColor")
    public void setSelectionColor(ReactTextView reactTextView, @Nullable Integer num) {
        if (num == null) {
            reactTextView.setHighlightColor(a.c(reactTextView.getContext()));
        } else {
            reactTextView.setHighlightColor(num.intValue());
        }
    }

    @a(name = "textAlignVertical")
    public void setTextAlignVertical(ReactTextView reactTextView, @Nullable String str) {
        if (str == null || "auto".equals(str)) {
            reactTextView.setGravityVertical(0);
        } else if ("top".equals(str)) {
            reactTextView.setGravityVertical(48);
        } else if ("bottom".equals(str)) {
            reactTextView.setGravityVertical(80);
        } else if ("center".equals(str)) {
            reactTextView.setGravityVertical(16);
        } else {
            z2.a.G("ReactNative", "Invalid textAlignVertical: " + str);
            reactTextView.setGravityVertical(0);
        }
    }
}
