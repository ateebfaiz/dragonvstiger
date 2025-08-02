package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public final class ContextKt {
    public static final void withStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, @AttrRes int i10, @StyleRes int i11, Function1<? super TypedArray, Unit> function1) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11, Function1 function1, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            attributeSet = null;
        }
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(Context context, @StyleRes int i10, int[] iArr, Function1<? super TypedArray, Unit> function1) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, iArr);
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
