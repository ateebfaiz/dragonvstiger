package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;

public final class PathUtils {

    static class a {
        @DoNotInline
        static float[] a(Path path, float f10) {
            return path.approximate(f10);
        }
    }

    private PathUtils() {
    }

    @RequiresApi(26)
    @NonNull
    public static Collection<PathSegment> flatten(@NonNull Path path) {
        return flatten(path, 0.5f);
    }

    @RequiresApi(26)
    @NonNull
    public static Collection<PathSegment> flatten(@NonNull Path path, @FloatRange(from = 0.0d) float f10) {
        float[] a10 = a.a(path, f10);
        int length = a10.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 1; i10 < length; i10++) {
            int i11 = i10 * 3;
            int i12 = (i10 - 1) * 3;
            float f11 = a10[i11];
            float f12 = a10[i11 + 1];
            float f13 = a10[i11 + 2];
            float f14 = a10[i12];
            float f15 = a10[i12 + 1];
            float f16 = a10[i12 + 2];
            if (!(f11 == f14 || (f12 == f15 && f13 == f16))) {
                arrayList.add(new PathSegment(new PointF(f15, f16), f14, new PointF(f12, f13), f11));
            }
        }
        return arrayList;
    }
}
