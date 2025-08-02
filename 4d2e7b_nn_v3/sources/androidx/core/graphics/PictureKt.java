package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.k;

public final class PictureKt {
    public static final Picture record(Picture picture, int i10, int i11, Function1<? super Canvas, Unit> function1) {
        try {
            function1.invoke(picture.beginRecording(i10, i11));
            return picture;
        } finally {
            k.b(1);
            picture.endRecording();
            k.a(1);
        }
    }
}
