package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import kotlin.ranges.IntRange;

public final class SpannableStringKt {
    public static final void clearSpans(Spannable spannable) {
        for (Object removeSpan : spannable.getSpans(0, spannable.length(), Object.class)) {
            spannable.removeSpan(removeSpan);
        }
    }

    public static final void set(Spannable spannable, int i10, int i11, Object obj) {
        spannable.setSpan(obj, i10, i11, 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        return SpannableString.valueOf(charSequence);
    }

    public static final void set(Spannable spannable, IntRange intRange, Object obj) {
        spannable.setSpan(obj, intRange.getStart().intValue(), intRange.getEndInclusive().intValue(), 17);
    }
}
