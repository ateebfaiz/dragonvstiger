package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
    }

    public static int getAttr(@NonNull Context context, int i10, int i11) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i10, typedValue, true);
        if (typedValue.resourceId != 0) {
            return i10;
        }
        return i11;
    }

    public static boolean getBoolean(@NonNull TypedArray typedArray, @StyleableRes int i10, @StyleableRes int i11, boolean z10) {
        return typedArray.getBoolean(i10, typedArray.getBoolean(i11, z10));
    }

    @Nullable
    public static Drawable getDrawable(@NonNull TypedArray typedArray, @StyleableRes int i10, @StyleableRes int i11) {
        Drawable drawable = typedArray.getDrawable(i10);
        if (drawable == null) {
            return typedArray.getDrawable(i11);
        }
        return drawable;
    }

    public static int getInt(@NonNull TypedArray typedArray, @StyleableRes int i10, @StyleableRes int i11, int i12) {
        return typedArray.getInt(i10, typedArray.getInt(i11, i12));
    }

    public static boolean getNamedBoolean(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i10, boolean z10) {
        if (!hasAttribute(xmlPullParser, str)) {
            return z10;
        }
        return typedArray.getBoolean(i10, z10);
    }

    @ColorInt
    public static int getNamedColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i10, @ColorInt int i11) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i11;
        }
        return typedArray.getColor(i10, i11);
    }

    @Nullable
    public static ColorStateList getNamedColorStateList(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i10) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i10, typedValue);
        int i11 = typedValue.type;
        if (i11 == 2) {
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + i10 + ": " + typedValue);
        } else if (i11 < 28 || i11 > 31) {
            return ColorStateListInflaterCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i10, 0), theme);
        } else {
            return getNamedColorStateListFromInt(typedValue);
        }
    }

    @NonNull
    private static ColorStateList getNamedColorStateListFromInt(@NonNull TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static ComplexColorCompat getNamedComplexColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i10, @ColorInt int i11) {
        if (hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i10, typedValue);
            int i12 = typedValue.type;
            if (i12 >= 28 && i12 <= 31) {
                return ComplexColorCompat.from(typedValue.data);
            }
            ComplexColorCompat inflate = ComplexColorCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i10, 0), theme);
            if (inflate != null) {
                return inflate;
            }
        }
        return ComplexColorCompat.from(i11);
    }

    public static float getNamedFloat(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i10, float f10) {
        if (!hasAttribute(xmlPullParser, str)) {
            return f10;
        }
        return typedArray.getFloat(i10, f10);
    }

    public static int getNamedInt(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i10, int i11) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i11;
        }
        return typedArray.getInt(i10, i11);
    }

    @AnyRes
    public static int getNamedResourceId(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i10, @AnyRes int i11) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i11;
        }
        return typedArray.getResourceId(i10, i11);
    }

    @Nullable
    public static String getNamedString(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i10) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i10);
    }

    @AnyRes
    public static int getResourceId(@NonNull TypedArray typedArray, @StyleableRes int i10, @StyleableRes int i11, @AnyRes int i12) {
        return typedArray.getResourceId(i10, typedArray.getResourceId(i11, i12));
    }

    @Nullable
    public static String getString(@NonNull TypedArray typedArray, @StyleableRes int i10, @StyleableRes int i11) {
        String string = typedArray.getString(i10);
        if (string == null) {
            return typedArray.getString(i11);
        }
        return string;
    }

    @Nullable
    public static CharSequence getText(@NonNull TypedArray typedArray, @StyleableRes int i10, @StyleableRes int i11) {
        CharSequence text = typedArray.getText(i10);
        if (text == null) {
            return typedArray.getText(i11);
        }
        return text;
    }

    @Nullable
    public static CharSequence[] getTextArray(@NonNull TypedArray typedArray, @StyleableRes int i10, @StyleableRes int i11) {
        CharSequence[] textArray = typedArray.getTextArray(i10);
        if (textArray == null) {
            return typedArray.getTextArray(i11);
        }
        return textArray;
    }

    public static boolean hasAttribute(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        if (xmlPullParser.getAttributeValue(NAMESPACE, str) != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public static TypedArray obtainAttributes(@NonNull Resources resources, @Nullable Resources.Theme theme, @NonNull AttributeSet attributeSet, @NonNull int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @Nullable
    public static TypedValue peekNamedValue(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i10) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(i10);
    }
}
