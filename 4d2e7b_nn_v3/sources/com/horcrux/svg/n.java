package com.horcrux.svg;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.yalantis.ucrop.UCropActivity;
import java.util.ArrayList;

abstract class n {

    /* renamed from: a  reason: collision with root package name */
    static float f9910a;

    /* renamed from: b  reason: collision with root package name */
    private static int f9911b;

    /* renamed from: c  reason: collision with root package name */
    private static int f9912c;

    /* renamed from: d  reason: collision with root package name */
    private static String f9913d;

    /* renamed from: e  reason: collision with root package name */
    private static Path f9914e;

    /* renamed from: f  reason: collision with root package name */
    static ArrayList f9915f;

    /* renamed from: g  reason: collision with root package name */
    private static float f9916g;

    /* renamed from: h  reason: collision with root package name */
    private static float f9917h;

    /* renamed from: i  reason: collision with root package name */
    private static float f9918i;

    /* renamed from: j  reason: collision with root package name */
    private static float f9919j;

    /* renamed from: k  reason: collision with root package name */
    private static float f9920k;

    /* renamed from: l  reason: collision with root package name */
    private static float f9921l;

    /* renamed from: m  reason: collision with root package name */
    private static boolean f9922m;

    private static void A(float f10, float f11, float f12, float f13) {
        f9918i = f10;
        f9919j = f11;
        e((f9916g * 2.0f) - f9918i, (f9917h * 2.0f) - f9919j, f10, f11, f12, f13);
    }

    private static void B(float f10, float f11) {
        C(f10 + f9916g, f11 + f9917h);
    }

    private static void C(float f10, float f11) {
        u((f9916g * 2.0f) - f9918i, (f9917h * 2.0f) - f9919j, f10, f11);
    }

    private static void a(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14) {
        b(f10, f11, f12, z10, z11, f13 + f9916g, f14 + f9917h);
    }

    private static void b(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14) {
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        boolean z12 = z10;
        boolean z13 = z11;
        float f20 = f9916g;
        float f21 = f9917h;
        if (f11 != 0.0f) {
            f15 = f11;
        } else if (f10 == 0.0f) {
            f15 = f14 - f21;
        } else {
            f15 = f10;
        }
        float abs = Math.abs(f15);
        if (f10 == 0.0f) {
            f16 = f13 - f20;
        } else {
            f16 = f10;
        }
        float abs2 = Math.abs(f16);
        if (abs2 == 0.0f || abs == 0.0f || (f13 == f20 && f14 == f21)) {
            l(f13, f14);
            return;
        }
        float radians = (float) Math.toRadians((double) f12);
        double d10 = (double) radians;
        float cos = (float) Math.cos(d10);
        float sin = (float) Math.sin(d10);
        float f22 = f13 - f20;
        float f23 = f14 - f21;
        float f24 = ((cos * f22) / 2.0f) + ((sin * f23) / 2.0f);
        float f25 = -sin;
        float f26 = ((f25 * f22) / 2.0f) + ((cos * f23) / 2.0f);
        float f27 = abs2 * abs2;
        float f28 = f27 * abs * abs;
        float f29 = abs * abs * f24 * f24;
        float f30 = f27 * f26 * f26;
        float f31 = (f28 - f30) - f29;
        if (f31 < 0.0f) {
            f17 = f25;
            float sqrt = (float) Math.sqrt((double) (1.0f - (f31 / f28)));
            abs2 *= sqrt;
            abs *= sqrt;
            f18 = f22 / 2.0f;
            f19 = f23 / 2.0f;
        } else {
            f17 = f25;
            float sqrt2 = (float) Math.sqrt((double) (f31 / (f30 + f29)));
            if (z12 == z13) {
                sqrt2 = -sqrt2;
            }
            float f32 = (((-sqrt2) * f26) * abs2) / abs;
            float f33 = ((sqrt2 * f24) * abs) / abs2;
            f18 = ((cos * f32) - (sin * f33)) + (f22 / 2.0f);
            f19 = (f23 / 2.0f) + (f32 * sin) + (f33 * cos);
        }
        float f34 = cos / abs2;
        float f35 = sin / abs2;
        float f36 = f17 / abs;
        float f37 = cos / abs;
        float f38 = -f18;
        float f39 = -f19;
        float f40 = abs;
        float f41 = abs2;
        float f42 = radians;
        float atan2 = (float) Math.atan2((double) ((f36 * f38) + (f37 * f39)), (double) ((f38 * f34) + (f39 * f35)));
        float f43 = f22 - f18;
        float f44 = f23 - f19;
        float atan22 = (float) Math.atan2((double) ((f36 * f43) + (f37 * f44)), (double) ((f34 * f43) + (f35 * f44)));
        float f45 = f18 + f20;
        float f46 = f19 + f21;
        float f47 = f22 + f20;
        float f48 = f23 + f21;
        w();
        f9918i = f47;
        f9916g = f47;
        f9919j = f48;
        f9917h = f48;
        if (f41 == f40 && f42 == 0.0f) {
            float degrees = (float) Math.toDegrees((double) atan2);
            float abs3 = Math.abs((degrees - ((float) Math.toDegrees((double) atan22))) % 360.0f);
            if (!z10 ? abs3 > 180.0f : abs3 < 180.0f) {
                abs3 = 360.0f - abs3;
            }
            if (!z11) {
                abs3 = -abs3;
            }
            float f49 = f9910a;
            f9914e.arcTo(new RectF((f45 - f41) * f49, (f46 - f41) * f49, (f45 + f41) * f49, (f46 + f41) * f49), degrees, abs3);
            f9915f.add(new m(c.kCGPathElementAddCurveToPoint, new o[]{new o((double) f47, (double) f48)}));
            return;
        }
        c(f45, f46, f41, f40, atan2, atan22, z11, f42);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0067 A[LOOP:0: B:10:0x0065->B:11:0x0067, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(float r24, float r25, float r26, float r27, float r28, float r29, boolean r30, float r31) {
        /*
            r0 = r28
            r3 = r31
            double r3 = (double) r3
            double r5 = java.lang.Math.cos(r3)
            float r5 = (float) r5
            double r3 = java.lang.Math.sin(r3)
            float r3 = (float) r3
            float r4 = r5 * r26
            float r6 = -r3
            float r6 = r6 * r27
            float r3 = r3 * r26
            float r5 = r5 * r27
            float r7 = r29 - r0
            r8 = 0
            int r9 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            r10 = 4618760256179416344(0x401921fb54442d18, double:6.283185307179586)
            if (r9 >= 0) goto L_0x002a
            if (r30 == 0) goto L_0x002a
            double r7 = (double) r7
            double r7 = r7 + r10
        L_0x0028:
            float r7 = (float) r7
            goto L_0x0033
        L_0x002a:
            int r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x0033
            if (r30 != 0) goto L_0x0033
            double r7 = (double) r7
            double r7 = r7 - r10
            goto L_0x0028
        L_0x0033:
            double r8 = (double) r7
            r10 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            double r8 = r8 / r10
            double r8 = v(r8)
            double r8 = java.lang.Math.abs(r8)
            double r8 = java.lang.Math.ceil(r8)
            int r8 = (int) r8
            float r9 = (float) r8
            float r7 = r7 / r9
            r9 = 1082130432(0x40800000, float:4.0)
            float r9 = r7 / r9
            double r9 = (double) r9
            double r9 = java.lang.Math.tan(r9)
            r11 = 4608683618675807573(0x3ff5555555555555, double:1.3333333333333333)
            double r9 = r9 * r11
            float r9 = (float) r9
            double r10 = (double) r0
            double r12 = java.lang.Math.cos(r10)
            float r12 = (float) r12
            double r10 = java.lang.Math.sin(r10)
            float r10 = (float) r10
            r11 = 0
        L_0x0065:
            if (r11 >= r8) goto L_0x0119
            float r13 = r9 * r10
            float r13 = r12 - r13
            float r12 = r12 * r9
            float r10 = r10 + r12
            float r0 = r0 + r7
            double r14 = (double) r0
            double r1 = java.lang.Math.cos(r14)
            float r1 = (float) r1
            double r14 = java.lang.Math.sin(r14)
            float r2 = (float) r14
            float r14 = r9 * r2
            float r14 = r14 + r1
            float r15 = r9 * r1
            float r15 = r2 - r15
            float r16 = r4 * r13
            float r16 = r24 + r16
            float r17 = r6 * r10
            float r12 = r16 + r17
            float r13 = r13 * r3
            float r13 = r25 + r13
            float r10 = r10 * r5
            float r13 = r13 + r10
            float r10 = r4 * r14
            float r10 = r24 + r10
            float r16 = r6 * r15
            float r10 = r10 + r16
            float r14 = r14 * r3
            float r14 = r25 + r14
            float r15 = r15 * r5
            float r14 = r14 + r15
            float r15 = r4 * r1
            float r15 = r24 + r15
            float r16 = r6 * r2
            float r15 = r15 + r16
            float r16 = r3 * r1
            float r16 = r25 + r16
            float r17 = r5 * r2
            r27 = r0
            float r0 = r16 + r17
            android.graphics.Path r16 = f9914e
            float r17 = f9910a
            float r18 = r12 * r17
            float r19 = r13 * r17
            float r20 = r10 * r17
            float r21 = r14 * r17
            float r22 = r15 * r17
            float r23 = r0 * r17
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r21 = r22
            r22 = r23
            r16.cubicTo(r17, r18, r19, r20, r21, r22)
            r16 = r1
            java.util.ArrayList r1 = f9915f
            r17 = r2
            com.horcrux.svg.m r2 = new com.horcrux.svg.m
            r31 = r3
            com.horcrux.svg.c r3 = com.horcrux.svg.c.kCGPathElementAddCurveToPoint
            r18 = r4
            com.horcrux.svg.o r4 = new com.horcrux.svg.o
            r20 = r5
            r19 = r6
            double r5 = (double) r12
            double r12 = (double) r13
            r4.<init>(r5, r12)
            com.horcrux.svg.o r5 = new com.horcrux.svg.o
            double r12 = (double) r10
            r29 = r7
            double r6 = (double) r14
            r5.<init>(r12, r6)
            com.horcrux.svg.o r6 = new com.horcrux.svg.o
            double r12 = (double) r15
            double r14 = (double) r0
            r6.<init>(r12, r14)
            r0 = 3
            com.horcrux.svg.o[] r0 = new com.horcrux.svg.o[r0]
            r7 = 0
            r0[r7] = r4
            r4 = 1
            r0[r4] = r5
            r5 = 2
            r0[r5] = r6
            r2.<init>(r3, r0)
            r1.add(r2)
            int r11 = r11 + r4
            r0 = r27
            r7 = r29
            r3 = r31
            r12 = r16
            r10 = r17
            r4 = r18
            r6 = r19
            r5 = r20
            goto L_0x0065
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.n.c(float, float, float, float, float, float, boolean, float):void");
    }

    private static void d() {
        if (f9922m) {
            f9916g = f9920k;
            f9917h = f9921l;
            f9922m = false;
            f9914e.close();
            f9915f.add(new m(c.kCGPathElementCloseSubpath, new o[]{new o((double) f9916g, (double) f9917h)}));
        }
    }

    private static void e(float f10, float f11, float f12, float f13, float f14, float f15) {
        w();
        f9916g = f14;
        f9917h = f15;
        Path path = f9914e;
        float f16 = f9910a;
        path.cubicTo(f10 * f16, f11 * f16, f12 * f16, f13 * f16, f14 * f16, f15 * f16);
        f9915f.add(new m(c.kCGPathElementAddCurveToPoint, new o[]{new o((double) f10, (double) f11), new o((double) f12, (double) f13), new o((double) f14, (double) f15)}));
    }

    private static void f(float f10, float f11, float f12, float f13, float f14, float f15) {
        float f16 = f9916g;
        float f17 = f9917h;
        g(f10 + f16, f11 + f17, f12 + f16, f13 + f17, f14 + f16, f15 + f17);
    }

    private static void g(float f10, float f11, float f12, float f13, float f14, float f15) {
        f9918i = f12;
        f9919j = f13;
        e(f10, f11, f12, f13, f14, f15);
    }

    private static boolean h(char c10) {
        return Character.isUpperCase(c10);
    }

    private static boolean i(char c10) {
        switch (c10) {
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH:
            case 'C':
            case 'H':
            case 'L':
            case 'M':
            case 'Q':
            case 'S':
            case 'T':
            case ModuleDescriptor.MODULE_VERSION:
            case UCropActivity.DEFAULT_COMPRESS_QUALITY /*90*/:
            case 'a':
            case 'c':
            case LocationRequestCompat.QUALITY_LOW_POWER /*104*/:
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /*108*/:
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /*109*/:
            case 'q':
            case 's':
            case 't':
            case 'v':
            case 'z':
                return true;
            default:
                return false;
        }
    }

    private static boolean j(char c10) {
        return (c10 >= '0' && c10 <= '9') || c10 == '.' || c10 == '-' || c10 == '+';
    }

    private static void k(float f10, float f11) {
        l(f10 + f9916g, f11 + f9917h);
    }

    private static void l(float f10, float f11) {
        w();
        f9916g = f10;
        f9918i = f10;
        f9917h = f11;
        f9919j = f11;
        Path path = f9914e;
        float f12 = f9910a;
        path.lineTo(f10 * f12, f12 * f11);
        f9915f.add(new m(c.kCGPathElementAddLineToPoint, new o[]{new o((double) f10, (double) f11)}));
    }

    private static void m(float f10, float f11) {
        n(f10 + f9916g, f11 + f9917h);
    }

    private static void n(float f10, float f11) {
        f9916g = f10;
        f9918i = f10;
        f9920k = f10;
        f9917h = f11;
        f9919j = f11;
        f9921l = f11;
        Path path = f9914e;
        float f12 = f9910a;
        path.moveTo(f10 * f12, f12 * f11);
        f9915f.add(new m(c.kCGPathElementMoveToPoint, new o[]{new o((double) f10, (double) f11)}));
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00ae A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0031 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Path o(java.lang.String r26) {
        /*
            r0 = 3
            r1 = 2
            r2 = 1
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            f9915f = r4
            android.graphics.Path r4 = new android.graphics.Path
            r4.<init>()
            f9914e = r4
            if (r26 != 0) goto L_0x0015
            return r4
        L_0x0015:
            int r4 = r26.length()
            f9912c = r4
            f9913d = r26
            f9911b = r3
            r4 = 0
            f9916g = r4
            f9917h = r4
            f9918i = r4
            f9919j = r4
            f9920k = r4
            f9921l = r4
            f9922m = r3
            r5 = 32
            r6 = r5
        L_0x0031:
            int r7 = f9911b
            int r8 = f9912c
            if (r7 >= r8) goto L_0x0243
            y()
            int r7 = f9911b
            int r8 = f9912c
            if (r7 < r8) goto L_0x0042
            goto L_0x0243
        L_0x0042:
            if (r6 == r5) goto L_0x0046
            r8 = r2
            goto L_0x0047
        L_0x0046:
            r8 = r3
        L_0x0047:
            java.lang.String r9 = f9913d
            char r7 = r9.charAt(r7)
            java.lang.String r9 = "Unexpected character '%c' (i=%d, s=%s)"
            r10 = 109(0x6d, float:1.53E-43)
            r11 = 77
            if (r8 != 0) goto L_0x0078
            if (r7 == r11) goto L_0x0078
            if (r7 != r10) goto L_0x005a
            goto L_0x0078
        L_0x005a:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.Character r5 = java.lang.Character.valueOf(r7)
            int r6 = f9911b
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r3] = r5
            r0[r2] = r6
            java.lang.String r2 = f9913d
            r0[r1] = r2
            java.lang.String r0 = java.lang.String.format(r9, r0)
            r4.<init>(r0)
            throw r4
        L_0x0078:
            boolean r12 = i(r7)
            if (r12 == 0) goto L_0x0086
            int r6 = f9911b
            int r6 = r6 + r2
            f9911b = r6
            r6 = r7
        L_0x0084:
            r7 = r3
            goto L_0x00a7
        L_0x0086:
            boolean r12 = j(r7)
            if (r12 == 0) goto L_0x0225
            if (r8 == 0) goto L_0x0225
            r7 = 90
            if (r6 == r7) goto L_0x0213
            r7 = 122(0x7a, float:1.71E-43)
            if (r6 == r7) goto L_0x0213
            if (r6 == r11) goto L_0x009a
            if (r6 != r10) goto L_0x0084
        L_0x009a:
            boolean r6 = h(r6)
            if (r6 == 0) goto L_0x00a4
            r6 = 76
        L_0x00a2:
            r7 = r2
            goto L_0x00a7
        L_0x00a4:
            r6 = 108(0x6c, float:1.51E-43)
            goto L_0x00a2
        L_0x00a7:
            boolean r8 = h(r6)
            switch(r6) {
                case 65: goto L_0x01ea;
                case 67: goto L_0x01ce;
                case 72: goto L_0x01c4;
                case 76: goto L_0x01b8;
                case 77: goto L_0x01ac;
                case 81: goto L_0x0198;
                case 83: goto L_0x0184;
                case 84: goto L_0x0177;
                case 86: goto L_0x016c;
                case 90: goto L_0x0167;
                case 97: goto L_0x0146;
                case 99: goto L_0x0129;
                case 104: goto L_0x0120;
                case 108: goto L_0x0113;
                case 109: goto L_0x0106;
                case 113: goto L_0x00f1;
                case 115: goto L_0x00dc;
                case 116: goto L_0x00cf;
                case 118: goto L_0x00c6;
                case 122: goto L_0x0167;
                default: goto L_0x00ae;
            }
        L_0x00ae:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.Character r4 = java.lang.Character.valueOf(r6)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r4
            java.lang.String r3 = f9913d
            r1[r2] = r3
            java.lang.String r2 = "Unexpected comand '%c' (s=%s)"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.<init>(r1)
            throw r0
        L_0x00c6:
            float r9 = q()
            k(r4, r9)
            goto L_0x0209
        L_0x00cf:
            float r9 = q()
            float r12 = q()
            B(r9, r12)
            goto L_0x0209
        L_0x00dc:
            float r9 = q()
            float r12 = q()
            float r13 = q()
            float r14 = q()
            z(r9, r12, r13, r14)
            goto L_0x0209
        L_0x00f1:
            float r9 = q()
            float r12 = q()
            float r13 = q()
            float r14 = q()
            t(r9, r12, r13, r14)
            goto L_0x0209
        L_0x0106:
            float r9 = q()
            float r12 = q()
            m(r9, r12)
            goto L_0x0209
        L_0x0113:
            float r9 = q()
            float r12 = q()
            k(r9, r12)
            goto L_0x0209
        L_0x0120:
            float r9 = q()
            k(r9, r4)
            goto L_0x0209
        L_0x0129:
            float r12 = q()
            float r13 = q()
            float r14 = q()
            float r15 = q()
            float r16 = q()
            float r17 = q()
            f(r12, r13, r14, r15, r16, r17)
            goto L_0x0209
        L_0x0146:
            float r18 = q()
            float r19 = q()
            float r20 = q()
            boolean r21 = p()
            boolean r22 = p()
            float r23 = q()
            float r24 = q()
            a(r18, r19, r20, r21, r22, r23, r24)
            goto L_0x0209
        L_0x0167:
            d()
            goto L_0x0209
        L_0x016c:
            float r9 = f9916g
            float r12 = q()
            l(r9, r12)
            goto L_0x0209
        L_0x0177:
            float r9 = q()
            float r12 = q()
            C(r9, r12)
            goto L_0x0209
        L_0x0184:
            float r9 = q()
            float r12 = q()
            float r13 = q()
            float r14 = q()
            A(r9, r12, r13, r14)
            goto L_0x0209
        L_0x0198:
            float r9 = q()
            float r12 = q()
            float r13 = q()
            float r14 = q()
            u(r9, r12, r13, r14)
            goto L_0x0209
        L_0x01ac:
            float r9 = q()
            float r12 = q()
            n(r9, r12)
            goto L_0x0209
        L_0x01b8:
            float r9 = q()
            float r12 = q()
            l(r9, r12)
            goto L_0x0209
        L_0x01c4:
            float r9 = q()
            float r12 = f9917h
            l(r9, r12)
            goto L_0x0209
        L_0x01ce:
            float r13 = q()
            float r14 = q()
            float r15 = q()
            float r16 = q()
            float r17 = q()
            float r18 = q()
            g(r13, r14, r15, r16, r17, r18)
            goto L_0x0209
        L_0x01ea:
            float r19 = q()
            float r20 = q()
            float r21 = q()
            boolean r22 = p()
            boolean r23 = p()
            float r24 = q()
            float r25 = q()
            b(r19, r20, r21, r22, r23, r24, r25)
        L_0x0209:
            if (r7 == 0) goto L_0x0031
            if (r8 == 0) goto L_0x0210
            r6 = r11
            goto L_0x0031
        L_0x0210:
            r6 = r10
            goto L_0x0031
        L_0x0213:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r2 = f9913d
            r1[r3] = r2
            java.lang.String r2 = "Unexpected number after 'z' (s=%s)"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.<init>(r1)
            throw r0
        L_0x0225:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.Character r5 = java.lang.Character.valueOf(r7)
            int r6 = f9911b
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r3] = r5
            r0[r2] = r6
            java.lang.String r2 = f9913d
            r0[r1] = r2
            java.lang.String r0 = java.lang.String.format(r9, r0)
            r4.<init>(r0)
            throw r4
        L_0x0243:
            android.graphics.Path r0 = f9914e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.n.o(java.lang.String):android.graphics.Path");
    }

    private static boolean p() {
        y();
        char charAt = f9913d.charAt(f9911b);
        if (charAt == '0' || charAt == '1') {
            int i10 = f9911b + 1;
            f9911b = i10;
            if (i10 < f9912c && f9913d.charAt(i10) == ',') {
                f9911b++;
            }
            y();
            if (charAt == '1') {
                return true;
            }
            return false;
        }
        throw new Error(String.format("Unexpected flag '%c' (i=%d, s=%s)", new Object[]{Character.valueOf(charAt), Integer.valueOf(f9911b), f9913d}));
    }

    private static float q() {
        if (f9911b != f9912c) {
            float s10 = s();
            y();
            r();
            return s10;
        }
        throw new Error(String.format("Unexpected end (s=%s)", new Object[]{f9913d}));
    }

    private static void r() {
        int i10 = f9911b;
        if (i10 < f9912c && f9913d.charAt(i10) == ',') {
            f9911b++;
        }
    }

    private static float s() {
        char charAt;
        y();
        int i10 = f9911b;
        if (i10 != f9912c) {
            char charAt2 = f9913d.charAt(i10);
            if (charAt2 == '-' || charAt2 == '+') {
                int i11 = f9911b + 1;
                f9911b = i11;
                charAt2 = f9913d.charAt(i11);
            }
            if (charAt2 >= '0' && charAt2 <= '9') {
                x();
                int i12 = f9911b;
                if (i12 < f9912c) {
                    charAt2 = f9913d.charAt(i12);
                }
            } else if (charAt2 != '.') {
                throw new IllegalArgumentException(String.format("Invalid number formating character '%c' (i=%d, s=%s)", new Object[]{Character.valueOf(charAt2), Integer.valueOf(f9911b), f9913d}));
            }
            if (charAt2 == '.') {
                f9911b++;
                x();
                int i13 = f9911b;
                if (i13 < f9912c) {
                    charAt2 = f9913d.charAt(i13);
                }
            }
            if (charAt2 == 'e' || charAt2 == 'E') {
                int i14 = f9911b;
                if (!(i14 + 1 >= f9912c || (charAt = f9913d.charAt(i14 + 1)) == 'm' || charAt == 'x')) {
                    int i15 = f9911b + 1;
                    f9911b = i15;
                    char charAt3 = f9913d.charAt(i15);
                    if (charAt3 == '+' || charAt3 == '-') {
                        f9911b++;
                        x();
                    } else if (charAt3 < '0' || charAt3 > '9') {
                        throw new IllegalArgumentException(String.format("Invalid number formating character '%c' (i=%d, s=%s)", new Object[]{Character.valueOf(charAt3), Integer.valueOf(f9911b), f9913d}));
                    } else {
                        x();
                    }
                }
            }
            String substring = f9913d.substring(i10, f9911b);
            float parseFloat = Float.parseFloat(substring);
            if (!Float.isInfinite(parseFloat) && !Float.isNaN(parseFloat)) {
                return parseFloat;
            }
            throw new IllegalArgumentException(String.format("Invalid number '%s' (start=%d, i=%d, s=%s)", new Object[]{substring, Integer.valueOf(i10), Integer.valueOf(f9911b), f9913d}));
        }
        throw new Error(String.format("Unexpected end (s=%s)", new Object[]{f9913d}));
    }

    private static void t(float f10, float f11, float f12, float f13) {
        float f14 = f9916g;
        float f15 = f9917h;
        u(f10 + f14, f11 + f15, f12 + f14, f13 + f15);
    }

    private static void u(float f10, float f11, float f12, float f13) {
        f9918i = f10;
        f9919j = f11;
        float f14 = f10 * 2.0f;
        float f15 = f11 * 2.0f;
        float f16 = (f9916g + f14) / 3.0f;
        float f17 = (f9917h + f15) / 3.0f;
        e(f16, f17, (f12 + f14) / 3.0f, (f13 + f15) / 3.0f, f12, f13);
    }

    private static double v(double d10) {
        double pow = Math.pow(10.0d, 4.0d);
        return ((double) Math.round(d10 * pow)) / pow;
    }

    private static void w() {
        if (!f9922m) {
            f9920k = f9916g;
            f9921l = f9917h;
            f9922m = true;
        }
    }

    private static void x() {
        while (true) {
            int i10 = f9911b;
            if (i10 < f9912c && Character.isDigit(f9913d.charAt(i10))) {
                f9911b++;
            } else {
                return;
            }
        }
    }

    private static void y() {
        while (true) {
            int i10 = f9911b;
            if (i10 < f9912c && Character.isWhitespace(f9913d.charAt(i10))) {
                f9911b++;
            } else {
                return;
            }
        }
    }

    private static void z(float f10, float f11, float f12, float f13) {
        float f14 = f9916g;
        float f15 = f9917h;
        A(f10 + f14, f11 + f15, f12 + f14, f13 + f15);
    }
}
