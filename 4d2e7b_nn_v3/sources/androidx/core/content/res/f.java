package androidx.core.content.res;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.StyleableRes;
import kotlin.jvm.internal.m;

final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f14906a = new f();

    private f() {
    }

    @DoNotInline
    public static final Typeface a(TypedArray typedArray, @StyleableRes int i10) {
        Typeface font = typedArray.getFont(i10);
        m.c(font);
        return font;
    }
}
