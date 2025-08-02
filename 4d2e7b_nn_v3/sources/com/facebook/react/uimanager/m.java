package com.facebook.react.uimanager;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import com.facebook.react.bridge.ReadableArray;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f3811a = new m();

    private m() {
    }

    private final ColorMatrix b(float f10) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(f10, f10, f10, 1.0f);
        return colorMatrix;
    }

    private final RenderEffect d(ColorMatrix colorMatrix, RenderEffect renderEffect) {
        if (renderEffect == null) {
            RenderEffect a10 = RenderEffect.createColorFilterEffect(new ColorMatrixColorFilter(colorMatrix));
            kotlin.jvm.internal.m.c(a10);
            return a10;
        }
        RenderEffect a11 = RenderEffect.createColorFilterEffect(new ColorMatrixColorFilter(colorMatrix), renderEffect);
        kotlin.jvm.internal.m.c(a11);
        return a11;
    }

    private final ColorMatrix e(float f10) {
        float f11 = ((float) 255) * ((-(f10 / 2.0f)) + 0.5f);
        return new ColorMatrix(new float[]{f10, 0.0f, 0.0f, 0.0f, f11, 0.0f, f10, 0.0f, 0.0f, f11, 0.0f, 0.0f, f10, 0.0f, f11, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    private final ColorMatrix g(float f10) {
        float f11 = ((float) 1) - f10;
        float f12 = 0.7152f - (f11 * 0.7152f);
        float f13 = 0.0722f - (f11 * 0.0722f);
        float f14 = 0.2126f - (f11 * 0.2126f);
        return new ColorMatrix(new float[]{(0.7874f * f11) + 0.2126f, f12, f13, 0.0f, 0.0f, f14, (0.2848f * f11) + 0.7152f, f13, 0.0f, 0.0f, f14, f12, (f11 * 0.9278f) + 0.0722f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    private final ColorMatrix i(float f10) {
        double radians = Math.toRadians((double) f10);
        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);
        float f11 = 0.715f - (cos * 0.715f);
        float f12 = sin * 0.715f;
        float f13 = 0.072f - (cos * 0.072f);
        float f14 = 0.213f - (cos * 0.213f);
        return new ColorMatrix(new float[]{((cos * 0.787f) + 0.213f) - (sin * 0.213f), f11 - f12, (sin * 0.928f) + f13, 0.0f, 0.0f, (0.143f * sin) + f14, (0.285f * cos) + 0.715f + (0.14f * sin), f13 - (0.283f * sin), 0.0f, 0.0f, f14 - (0.787f * sin), f11 + f12, (cos * 0.928f) + 0.072f + (sin * 0.072f), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    private final ColorMatrix k(float f10) {
        float f11 = ((float) 1) - (((float) 2) * f10);
        float f12 = f10 * ((float) 255);
        return new ColorMatrix(new float[]{f11, 0.0f, 0.0f, 0.0f, f12, 0.0f, f11, 0.0f, 0.0f, f12, 0.0f, 0.0f, f11, 0.0f, f12, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    private final ColorMatrix o(float f10) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(f10);
        return colorMatrix;
    }

    private final ColorMatrix q(float f10) {
        float f11 = ((float) 1) - f10;
        return new ColorMatrix(new float[]{(0.607f * f11) + 0.393f, 0.769f - (f11 * 0.769f), 0.189f - (f11 * 0.189f), 0.0f, 0.0f, 0.349f - (f11 * 0.349f), (0.314f * f11) + 0.686f, 0.168f - (f11 * 0.168f), 0.0f, 0.0f, 0.272f - (f11 * 0.272f), 0.534f - (f11 * 0.534f), (f11 * 0.869f) + 0.131f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public static final boolean s(ReadableArray readableArray) {
        if (readableArray == null) {
            return false;
        }
        int size = readableArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (kotlin.jvm.internal.m.b((String) readableArray.getMap(i10).getEntryIterator().next().getKey(), "blur")) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b4, code lost:
        r0.preConcat(r3);
        r2 = r2 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.graphics.ColorMatrixColorFilter t(com.facebook.react.bridge.ReadableArray r7) {
        /*
            if (r7 != 0) goto L_0x0004
            r7 = 0
            return r7
        L_0x0004:
            android.graphics.ColorMatrix r0 = new android.graphics.ColorMatrix
            r0.<init>()
            int r1 = r7.size()
            r2 = 0
        L_0x000e:
            if (r2 >= r1) goto L_0x00d2
            com.facebook.react.bridge.ReadableMap r3 = r7.getMap(r2)
            java.util.Iterator r3 = r3.getEntryIterator()
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.getValue()
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Double"
            kotlin.jvm.internal.m.d(r3, r5)
            java.lang.Double r3 = (java.lang.Double) r3
            double r5 = r3.doubleValue()
            float r3 = (float) r5
            int r5 = r4.hashCode()
            switch(r5) {
                case -2114203985: goto L_0x00a6;
                case -1267206133: goto L_0x0097;
                case -1183703082: goto L_0x0088;
                case -905411385: goto L_0x0079;
                case -566947070: goto L_0x006a;
                case 109324790: goto L_0x005b;
                case 648162385: goto L_0x004c;
                case 650888307: goto L_0x003d;
                default: goto L_0x003b;
            }
        L_0x003b:
            goto L_0x00bb
        L_0x003d:
            java.lang.String r5 = "hueRotate"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00bb
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.ColorMatrix r3 = r4.i(r3)
            goto L_0x00b4
        L_0x004c:
            java.lang.String r5 = "brightness"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00bb
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.ColorMatrix r3 = r4.b(r3)
            goto L_0x00b4
        L_0x005b:
            java.lang.String r5 = "sepia"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00bb
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.ColorMatrix r3 = r4.q(r3)
            goto L_0x00b4
        L_0x006a:
            java.lang.String r5 = "contrast"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00bb
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.ColorMatrix r3 = r4.e(r3)
            goto L_0x00b4
        L_0x0079:
            java.lang.String r5 = "grayscale"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00bb
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.ColorMatrix r3 = r4.g(r3)
            goto L_0x00b4
        L_0x0088:
            java.lang.String r5 = "invert"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00bb
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.ColorMatrix r3 = r4.k(r3)
            goto L_0x00b4
        L_0x0097:
            java.lang.String r5 = "opacity"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00bb
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.ColorMatrix r3 = r4.m(r3)
            goto L_0x00b4
        L_0x00a6:
            java.lang.String r5 = "saturate"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00bb
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.ColorMatrix r3 = r4.o(r3)
        L_0x00b4:
            r0.preConcat(r3)
            int r2 = r2 + 1
            goto L_0x000e
        L_0x00bb:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid color matrix filter: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x00d2:
            android.graphics.ColorMatrixColorFilter r7 = new android.graphics.ColorMatrixColorFilter
            r7.<init>(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.m.t(com.facebook.react.bridge.ReadableArray):android.graphics.ColorMatrixColorFilter");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bf, code lost:
        r2 = r2 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.graphics.RenderEffect u(com.facebook.react.bridge.ReadableArray r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r7.size()
            r2 = 0
        L_0x0009:
            if (r2 >= r1) goto L_0x00da
            com.facebook.react.bridge.ReadableMap r3 = r7.getMap(r2)
            java.util.Iterator r3 = r3.getEntryIterator()
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.getValue()
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Double"
            kotlin.jvm.internal.m.d(r3, r5)
            java.lang.Double r3 = (java.lang.Double) r3
            double r5 = r3.doubleValue()
            float r3 = (float) r5
            int r5 = r4.hashCode()
            switch(r5) {
                case -2114203985: goto L_0x00b1;
                case -1267206133: goto L_0x00a2;
                case -1183703082: goto L_0x0093;
                case -905411385: goto L_0x0084;
                case -566947070: goto L_0x0075;
                case 3027047: goto L_0x0066;
                case 109324790: goto L_0x0057;
                case 648162385: goto L_0x0048;
                case 650888307: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x00c3
        L_0x0038:
            java.lang.String r5 = "hueRotate"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00c3
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.RenderEffect r0 = r4.j(r3, r0)
            goto L_0x00bf
        L_0x0048:
            java.lang.String r5 = "brightness"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00c3
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.RenderEffect r0 = r4.c(r3, r0)
            goto L_0x00bf
        L_0x0057:
            java.lang.String r5 = "sepia"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00c3
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.RenderEffect r0 = r4.r(r3, r0)
            goto L_0x00bf
        L_0x0066:
            java.lang.String r5 = "blur"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00c3
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.RenderEffect r0 = r4.a(r3, r0)
            goto L_0x00bf
        L_0x0075:
            java.lang.String r5 = "contrast"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00c3
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.RenderEffect r0 = r4.f(r3, r0)
            goto L_0x00bf
        L_0x0084:
            java.lang.String r5 = "grayscale"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00c3
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.RenderEffect r0 = r4.h(r3, r0)
            goto L_0x00bf
        L_0x0093:
            java.lang.String r5 = "invert"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00c3
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.RenderEffect r0 = r4.l(r3, r0)
            goto L_0x00bf
        L_0x00a2:
            java.lang.String r5 = "opacity"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00c3
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.RenderEffect r0 = r4.n(r3, r0)
            goto L_0x00bf
        L_0x00b1:
            java.lang.String r5 = "saturate"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00c3
            com.facebook.react.uimanager.m r4 = f3811a
            android.graphics.RenderEffect r0 = r4.p(r3, r0)
        L_0x00bf:
            int r2 = r2 + 1
            goto L_0x0009
        L_0x00c3:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid filter name: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x00da:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.m.u(com.facebook.react.bridge.ReadableArray):android.graphics.RenderEffect");
    }

    public final RenderEffect a(float f10, RenderEffect renderEffect) {
        if (((double) f10) <= 0.5d) {
            return null;
        }
        float d10 = (g0.d(f10) - 0.5f) / 0.57735f;
        if (renderEffect == null) {
            return RenderEffect.createBlurEffect(d10, d10, Shader.TileMode.DECAL);
        }
        return RenderEffect.createBlurEffect(d10, d10, renderEffect, Shader.TileMode.DECAL);
    }

    public final RenderEffect c(float f10, RenderEffect renderEffect) {
        return d(b(f10), renderEffect);
    }

    public final RenderEffect f(float f10, RenderEffect renderEffect) {
        return d(e(f10), renderEffect);
    }

    public final RenderEffect h(float f10, RenderEffect renderEffect) {
        return d(g(f10), renderEffect);
    }

    public final RenderEffect j(float f10, RenderEffect renderEffect) {
        return d(i(f10), renderEffect);
    }

    public final RenderEffect l(float f10, RenderEffect renderEffect) {
        return d(k(f10), renderEffect);
    }

    public final ColorMatrix m(float f10) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.0f, 1.0f, 1.0f, f10);
        return colorMatrix;
    }

    public final RenderEffect n(float f10, RenderEffect renderEffect) {
        return d(m(f10), renderEffect);
    }

    public final RenderEffect p(float f10, RenderEffect renderEffect) {
        return d(o(f10), renderEffect);
    }

    public final RenderEffect r(float f10, RenderEffect renderEffect) {
        return d(q(f10), renderEffect);
    }
}
