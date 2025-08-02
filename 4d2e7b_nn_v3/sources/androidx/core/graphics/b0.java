package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.FontResourcesParserCompat;
import java.lang.reflect.Field;

abstract class b0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Field f14929a;

    /* renamed from: b  reason: collision with root package name */
    private static final LongSparseArray f14930b = new LongSparseArray(3);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f14931c = new Object();

    static {
        Field field;
        try {
            field = Typeface.class.getDeclaredField("native_instance");
            field.setAccessible(true);
        } catch (Exception e10) {
            Log.e("WeightTypeface", e10.getClass().getName(), e10);
            field = null;
        }
        f14929a = field;
    }

    static Typeface a(a0 a0Var, Context context, Typeface typeface, int i10, boolean z10) {
        if (!d()) {
            return null;
        }
        boolean z11 = (i10 << 1) | z10;
        synchronized (f14931c) {
            try {
                long c10 = c(typeface);
                LongSparseArray longSparseArray = f14930b;
                SparseArray sparseArray = (SparseArray) longSparseArray.get(c10);
                if (sparseArray == null) {
                    sparseArray = new SparseArray(4);
                    longSparseArray.put(c10, sparseArray);
                } else {
                    Typeface typeface2 = (Typeface) sparseArray.get(z11);
                    if (typeface2 != null) {
                        return typeface2;
                    }
                }
                Typeface b10 = b(a0Var, context, typeface, i10, z10);
                if (b10 == null) {
                    b10 = e(typeface, i10, z10);
                }
                sparseArray.put(z11 ? 1 : 0, b10);
                return b10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Typeface b(a0 a0Var, Context context, Typeface typeface, int i10, boolean z10) {
        FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamily = a0Var.getFontFamily(typeface);
        if (fontFamily == null) {
            return null;
        }
        return a0Var.createFromFontFamilyFilesResourceEntry(context, fontFamily, context.getResources(), i10, z10);
    }

    private static long c(Typeface typeface) {
        try {
            return ((Number) f14929a.get(typeface)).longValue();
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static boolean d() {
        if (f14929a != null) {
            return true;
        }
        return false;
    }

    private static Typeface e(Typeface typeface, int i10, boolean z10) {
        boolean z11;
        int i11 = 0;
        if (i10 >= 600) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || z10) {
            if (!z11) {
                i11 = 2;
            } else if (!z10) {
                i11 = 1;
            } else {
                i11 = 3;
            }
        }
        return Typeface.create(typeface, i11);
    }
}
