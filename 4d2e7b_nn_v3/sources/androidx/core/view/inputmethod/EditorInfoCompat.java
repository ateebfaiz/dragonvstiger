package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Preconditions;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;
    @VisibleForTesting
    static final int MAX_INITIAL_SELECTION_LENGTH = 1024;
    @VisibleForTesting
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;
    private static final String STYLUS_HANDWRITING_ENABLED_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED";

    private static class a {
        static CharSequence a(EditorInfo editorInfo, int i10) {
            return editorInfo.getInitialSelectedText(i10);
        }

        static CharSequence b(EditorInfo editorInfo, int i10, int i11) {
            return editorInfo.getInitialTextAfterCursor(i10, i11);
        }

        static CharSequence c(EditorInfo editorInfo, int i10, int i11) {
            return editorInfo.getInitialTextBeforeCursor(i10, i11);
        }

        static void d(EditorInfo editorInfo, CharSequence charSequence, int i10) {
            editorInfo.setInitialSurroundingSubText(charSequence, i10);
        }
    }

    @NonNull
    public static String[] getContentMimeTypes(@NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] a10 = editorInfo.contentMimeTypes;
            if (a10 != null) {
                return a10;
            }
            return EMPTY_STRING_ARRAY;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return EMPTY_STRING_ARRAY;
        }
        String[] stringArray = bundle.getStringArray(CONTENT_MIME_TYPES_KEY);
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
        }
        if (stringArray != null) {
            return stringArray;
        }
        return EMPTY_STRING_ARRAY;
    }

    @Nullable
    public static CharSequence getInitialSelectedText(@NonNull EditorInfo editorInfo, int i10) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return a.a(editorInfo, i10);
        }
        if (editorInfo.extras == null) {
            return null;
        }
        int min = Math.min(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int max = Math.max(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int i11 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int i12 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int i13 = max - min;
        if (editorInfo.initialSelStart < 0 || editorInfo.initialSelEnd < 0 || i12 - i11 != i13 || (charSequence = editorInfo.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        if ((i10 & 1) != 0) {
            return charSequence.subSequence(i11, i12);
        }
        return TextUtils.substring(charSequence, i11, i12);
    }

    @Nullable
    public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo editorInfo, int i10, int i11) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return a.b(editorInfo, i10, i11);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i12 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int min = Math.min(i10, charSequence.length() - i12);
        if ((i11 & 1) != 0) {
            return charSequence.subSequence(i12, min + i12);
        }
        return TextUtils.substring(charSequence, i12, min + i12);
    }

    @Nullable
    public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo editorInfo, int i10, int i11) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return a.c(editorInfo, i10, i11);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i12 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int min = Math.min(i10, i12);
        if ((i11 & 1) != 0) {
            return charSequence.subSequence(i12 - min, i12);
        }
        return TextUtils.substring(charSequence, i12 - min, i12);
    }

    static int getProtocol(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            return 1;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return 0;
        }
        boolean containsKey = bundle.containsKey(CONTENT_MIME_TYPES_KEY);
        boolean containsKey2 = editorInfo.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
        if (containsKey && containsKey2) {
            return 4;
        }
        if (containsKey) {
            return 3;
        }
        if (containsKey2) {
            return 2;
        }
        return 0;
    }

    private static boolean isCutOnSurrogate(CharSequence charSequence, int i10, int i11) {
        if (i11 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i10));
        }
        if (i11 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i10));
    }

    private static boolean isPasswordInputType(int i10) {
        int i11 = i10 & 4095;
        return i11 == 129 || i11 == 225 || i11 == 18;
    }

    public static boolean isStylusHandwritingEnabled(@NonNull EditorInfo editorInfo) {
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(STYLUS_HANDWRITING_ENABLED_KEY);
    }

    public static void setContentMimeTypes(@NonNull EditorInfo editorInfo, @Nullable String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_KEY, strArr);
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, strArr);
    }

    public static void setInitialSurroundingSubText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence, int i10) {
        int i11;
        int i12;
        Preconditions.checkNotNull(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            a.d(editorInfo, charSequence, i10);
            return;
        }
        int i13 = editorInfo.initialSelStart;
        int i14 = editorInfo.initialSelEnd;
        if (i13 > i14) {
            i11 = i14 - i10;
        } else {
            i11 = i13 - i10;
        }
        if (i13 > i14) {
            i12 = i13 - i10;
        } else {
            i12 = i14 - i10;
        }
        int length = charSequence.length();
        if (i10 < 0 || i11 < 0 || i12 > length) {
            setSurroundingText(editorInfo, (CharSequence) null, 0, 0);
        } else if (isPasswordInputType(editorInfo.inputType)) {
            setSurroundingText(editorInfo, (CharSequence) null, 0, 0);
        } else if (length <= 2048) {
            setSurroundingText(editorInfo, charSequence, i11, i12);
        } else {
            trimLongSurroundingText(editorInfo, charSequence, i11, i12);
        }
    }

    public static void setInitialSurroundingText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            a.d(editorInfo, charSequence, 0);
        } else {
            setInitialSurroundingSubText(editorInfo, charSequence, 0);
        }
    }

    public static void setStylusHandwritingEnabled(@NonNull EditorInfo editorInfo, boolean z10) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putBoolean(STYLUS_HANDWRITING_ENABLED_KEY, z10);
    }

    private static void setSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i10, int i11) {
        SpannableStringBuilder spannableStringBuilder;
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        if (charSequence != null) {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
        } else {
            spannableStringBuilder = null;
        }
        editorInfo.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, spannableStringBuilder);
        editorInfo.extras.putInt(CONTENT_SELECTION_HEAD_KEY, i10);
        editorInfo.extras.putInt(CONTENT_SELECTION_END_KEY, i11);
    }

    private static void trimLongSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i10, int i11) {
        int i12;
        CharSequence charSequence2;
        int i13 = i11 - i10;
        if (i13 > 1024) {
            i12 = 0;
        } else {
            i12 = i13;
        }
        int i14 = 2048 - i12;
        int min = Math.min(charSequence.length() - i11, i14 - Math.min(i10, (int) (((double) i14) * 0.8d)));
        int min2 = Math.min(i10, i14 - min);
        int i15 = i10 - min2;
        if (isCutOnSurrogate(charSequence, i15, 0)) {
            i15++;
            min2--;
        }
        if (isCutOnSurrogate(charSequence, (i11 + min) - 1, 1)) {
            min--;
        }
        int i16 = min2 + i12 + min;
        if (i12 != i13) {
            charSequence2 = TextUtils.concat(new CharSequence[]{charSequence.subSequence(i15, i15 + min2), charSequence.subSequence(i11, min + i11)});
        } else {
            charSequence2 = charSequence.subSequence(i15, i16 + i15);
        }
        setSurroundingText(editorInfo, charSequence2, min2, i12 + min2);
    }
}
