package com.swmansion.reanimated;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReactNativeUtils {
    private static Method getCornerRadiiMethod;
    private static Field mBorderRadiusField;

    public static class BorderRadii {
        public float bottomLeft;
        public float bottomRight;
        public float full;
        public float topLeft;
        public float topRight;

        public BorderRadii(float f10, float f11, float f12, float f13, float f14) {
            this.full = Float.isNaN(f10) ? 0.0f : f10;
            this.topLeft = Float.isNaN(f11) ? this.full : f11;
            this.topRight = Float.isNaN(f12) ? this.full : f12;
            this.bottomLeft = Float.isNaN(f13) ? this.full : f13;
            this.bottomRight = Float.isNaN(f14) ? this.full : f14;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.swmansion.reanimated.ReactNativeUtils.BorderRadii getBorderRadii(android.view.View r15) {
        /*
            r0 = 0
            r1 = 1
            android.graphics.drawable.Drawable r2 = r15.getBackground()
            if (r2 == 0) goto L_0x000d
            com.swmansion.reanimated.ReactNativeUtils$BorderRadii r15 = com.swmansion.reanimated.BorderRadiiDrawableUtils.getBorderRadii(r15)
            return r15
        L_0x000d:
            boolean r2 = r15 instanceof com.facebook.react.views.image.ReactImageView
            if (r2 == 0) goto L_0x0062
            java.lang.reflect.Field r2 = mBorderRadiusField     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            java.lang.Class<com.facebook.react.views.image.ReactImageView> r3 = com.facebook.react.views.image.ReactImageView.class
            if (r2 != 0) goto L_0x0022
            java.lang.String r2 = "T0"
            java.lang.reflect.Field r2 = r3.getDeclaredField(r2)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            mBorderRadiusField = r2     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            r2.setAccessible(r1)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
        L_0x0022:
            java.lang.reflect.Field r2 = mBorderRadiusField     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            float r2 = r2.getFloat(r15)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            java.lang.reflect.Method r4 = getCornerRadiiMethod     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            if (r4 != 0) goto L_0x003d
            java.lang.String r4 = "m"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            java.lang.Class<float[]> r6 = float[].class
            r5[r0] = r6     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            getCornerRadiiMethod = r3     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            r3.setAccessible(r1)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
        L_0x003d:
            boolean r3 = java.lang.Float.isNaN(r2)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            if (r3 == 0) goto L_0x0044
            r2 = 0
        L_0x0044:
            r4 = r2
            r2 = 4
            float[] r2 = new float[r2]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            java.lang.reflect.Method r3 = getCornerRadiiMethod     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            r5[r0] = r2     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            r3.invoke(r15, r5)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            com.swmansion.reanimated.ReactNativeUtils$BorderRadii r15 = new com.swmansion.reanimated.ReactNativeUtils$BorderRadii     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            r5 = r2[r0]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            r6 = r2[r1]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            r0 = 2
            r7 = r2[r0]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            r0 = 3
            r8 = r2[r0]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            r3 = r15
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x0062 }
            return r15
        L_0x0062:
            com.swmansion.reanimated.ReactNativeUtils$BorderRadii r15 = new com.swmansion.reanimated.ReactNativeUtils$BorderRadii
            r13 = 0
            r14 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r9 = r15
            r9.<init>(r10, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.reanimated.ReactNativeUtils.getBorderRadii(android.view.View):com.swmansion.reanimated.ReactNativeUtils$BorderRadii");
    }
}
