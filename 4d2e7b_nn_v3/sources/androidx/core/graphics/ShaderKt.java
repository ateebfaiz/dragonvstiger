package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public final class ShaderKt {
    public static final void transform(Shader shader, Function1<? super Matrix, Unit> function1) {
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        function1.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
