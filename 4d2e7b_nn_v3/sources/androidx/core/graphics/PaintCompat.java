package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;

public final class PaintCompat {
    private static final String EM_STRING = "m";
    private static final String TOFU_STRING = "󟿽";
    private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = new ThreadLocal<>();

    static class a {
        @DoNotInline
        static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    static class b {
        @DoNotInline
        static void a(Paint paint, Object obj) {
            paint.setBlendMode((BlendMode) obj);
        }
    }

    private PaintCompat() {
    }

    public static boolean hasGlyph(@NonNull Paint paint, @NonNull String str) {
        return a.a(paint, str);
    }

    private static Pair<Rect, Rect> obtainEmptyRects() {
        ThreadLocal<Pair<Rect, Rect>> threadLocal = sRectThreadLocal;
        Pair<Rect, Rect> pair = threadLocal.get();
        if (pair == null) {
            Pair<Rect, Rect> pair2 = new Pair<>(new Rect(), new Rect());
            threadLocal.set(pair2);
            return pair2;
        }
        ((Rect) pair.first).setEmpty();
        ((Rect) pair.second).setEmpty();
        return pair;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: android.graphics.PorterDuffXfermode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: android.graphics.PorterDuffXfermode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.graphics.PorterDuffXfermode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.graphics.PorterDuffXfermode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: android.graphics.PorterDuffXfermode} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean setBlendMode(@androidx.annotation.NonNull android.graphics.Paint r4, @androidx.annotation.Nullable androidx.core.graphics.BlendModeCompat r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            r2 = 1
            r3 = 0
            if (r0 < r1) goto L_0x0012
            if (r5 == 0) goto L_0x000e
            java.lang.Object r3 = androidx.core.graphics.d.b.a(r5)
        L_0x000e:
            androidx.core.graphics.PaintCompat.b.a(r4, r3)
            return r2
        L_0x0012:
            if (r5 == 0) goto L_0x0027
            android.graphics.PorterDuff$Mode r5 = androidx.core.graphics.d.a(r5)
            if (r5 == 0) goto L_0x001f
            android.graphics.PorterDuffXfermode r3 = new android.graphics.PorterDuffXfermode
            r3.<init>(r5)
        L_0x001f:
            r4.setXfermode(r3)
            if (r5 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            return r2
        L_0x0027:
            r4.setXfermode(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PaintCompat.setBlendMode(android.graphics.Paint, androidx.core.graphics.BlendModeCompat):boolean");
    }
}
