package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int[] EMPTY_STATE_SET = new int[0];
    public static final Rect INSETS_NONE = new Rect();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final boolean f14239a;

        /* renamed from: b  reason: collision with root package name */
        private static final Method f14240b;

        /* renamed from: c  reason: collision with root package name */
        private static final Field f14241c;

        /* renamed from: d  reason: collision with root package name */
        private static final Field f14242d;

        /* renamed from: e  reason: collision with root package name */
        private static final Field f14243e;

        /* renamed from: f  reason: collision with root package name */
        private static final Field f14244f;

        /* JADX WARNING: Removed duplicated region for block: B:43:0x004a  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0057  */
        static {
            /*
                r0 = 1
                r1 = 0
                r2 = 0
                java.lang.String r3 = "android.graphics.Insets"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ NoSuchMethodException -> 0x0043, ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
                java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
                java.lang.String r5 = "getOpticalInsets"
                java.lang.reflect.Method r4 = r4.getMethod(r5, r1)     // Catch:{ NoSuchMethodException -> 0x0043, ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
                java.lang.String r5 = "left"
                java.lang.reflect.Field r5 = r3.getField(r5)     // Catch:{ NoSuchMethodException -> 0x003a, ClassNotFoundException -> 0x0037, NoSuchFieldException -> 0x0034 }
                java.lang.String r6 = "top"
                java.lang.reflect.Field r6 = r3.getField(r6)     // Catch:{ NoSuchMethodException -> 0x0032, ClassNotFoundException -> 0x0030, NoSuchFieldException -> 0x002d }
                java.lang.String r7 = "right"
                java.lang.reflect.Field r7 = r3.getField(r7)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException -> 0x002b }
                java.lang.String r8 = "bottom"
                java.lang.reflect.Field r3 = r3.getField(r8)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException -> 0x0046 }
                r8 = r0
                goto L_0x0048
            L_0x002b:
                r7 = r1
                goto L_0x0046
            L_0x002d:
                r6 = r1
            L_0x002e:
                r7 = r6
                goto L_0x0046
            L_0x0030:
                r6 = r1
                goto L_0x002e
            L_0x0032:
                r6 = r1
                goto L_0x002e
            L_0x0034:
                r5 = r1
            L_0x0035:
                r6 = r5
                goto L_0x002e
            L_0x0037:
                r5 = r1
            L_0x0038:
                r6 = r5
                goto L_0x002e
            L_0x003a:
                r5 = r1
            L_0x003b:
                r6 = r5
                goto L_0x002e
            L_0x003d:
                r4 = r1
                r5 = r4
                goto L_0x0035
            L_0x0040:
                r4 = r1
                r5 = r4
                goto L_0x0038
            L_0x0043:
                r4 = r1
                r5 = r4
                goto L_0x003b
            L_0x0046:
                r3 = r1
                r8 = r2
            L_0x0048:
                if (r8 == 0) goto L_0x0057
                f14240b = r4
                f14241c = r5
                f14242d = r6
                f14243e = r7
                f14244f = r3
                f14239a = r0
                goto L_0x0063
            L_0x0057:
                f14240b = r1
                f14241c = r1
                f14242d = r1
                f14243e = r1
                f14244f = r1
                f14239a = r2
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DrawableUtils.a.<clinit>():void");
        }

        static Rect a(Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && f14239a) {
                try {
                    Object invoke = f14240b.invoke(drawable, (Object[]) null);
                    if (invoke != null) {
                        return new Rect(f14241c.getInt(invoke), f14242d.getInt(invoke), f14243e.getInt(invoke), f14244f.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return DrawableUtils.INSETS_NONE;
        }
    }

    static class b {
        @DoNotInline
        static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    private DrawableUtils() {
    }

    public static boolean canSafelyMutateDrawable(@NonNull Drawable drawable) {
        return true;
    }

    static void fixDrawable(@NonNull Drawable drawable) {
        String name = drawable.getClass().getName();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29 && i10 < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            forceDrawableStateChange(drawable);
        }
    }

    private static void forceDrawableStateChange(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(CHECKED_STATE_SET);
        } else {
            drawable.setState(EMPTY_STATE_SET);
        }
        drawable.setState(state);
    }

    @NonNull
    public static Rect getOpticalBounds(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT < 29) {
            return a.a(DrawableCompat.unwrap(drawable));
        }
        Insets a10 = b.a(drawable);
        return new Rect(a10.left, a10.top, a10.right, a10.bottom);
    }

    public static PorterDuff.Mode parseTintMode(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
