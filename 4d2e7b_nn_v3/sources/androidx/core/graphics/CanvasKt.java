package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.k;

public final class CanvasKt {
    public static final void withClip(Canvas canvas, Rect rect, Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.clipRect(rect);
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }

    public static final void withMatrix(Canvas canvas, Matrix matrix, Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            matrix = new Matrix();
        }
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }

    public static final void withRotation(Canvas canvas, float f10, float f11, float f12, Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.rotate(f10, f11, f12);
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f10, float f11, float f12, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        int save = canvas.save();
        canvas.rotate(f10, f11, f12);
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }

    public static final void withSave(Canvas canvas, Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }

    public static final void withScale(Canvas canvas, float f10, float f11, float f12, float f13, Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.scale(f10, f11, f12, f13);
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f10, float f11, float f12, float f13, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 1.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 1.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        if ((i10 & 8) != 0) {
            f13 = 0.0f;
        }
        int save = canvas.save();
        canvas.scale(f10, f11, f12, f13);
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }

    public static final void withSkew(Canvas canvas, float f10, float f11, Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.skew(f10, f11);
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f10, float f11, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        int save = canvas.save();
        canvas.skew(f10, f11);
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }

    public static final void withTranslation(Canvas canvas, float f10, float f11, Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.translate(f10, f11);
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f10, float f11, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        int save = canvas.save();
        canvas.translate(f10, f11);
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }

    public static final void withClip(Canvas canvas, RectF rectF, Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.clipRect(rectF);
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }

    public static final void withClip(Canvas canvas, int i10, int i11, int i12, int i13, Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.clipRect(i10, i11, i12, i13);
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }

    public static final void withClip(Canvas canvas, float f10, float f11, float f12, float f13, Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.clipRect(f10, f11, f12, f13);
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }

    public static final void withClip(Canvas canvas, Path path, Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.clipPath(path);
        try {
            function1.invoke(canvas);
        } finally {
            k.b(1);
            canvas.restoreToCount(save);
            k.a(1);
        }
    }
}
