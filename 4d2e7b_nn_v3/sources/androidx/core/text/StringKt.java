package androidx.core.text;

import android.text.TextUtils;

public final class StringKt {
    public static final String htmlEncode(String str) {
        return TextUtils.htmlEncode(str);
    }
}
