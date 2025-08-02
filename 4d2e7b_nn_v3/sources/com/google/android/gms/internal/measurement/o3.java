package com.google.android.gms.internal.measurement;

import androidx.core.text.HtmlCompat;
import androidx.core.view.MotionEventCompat;
import c.d;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class o3 implements w3 {

    /* renamed from: p  reason: collision with root package name */
    private static final int[] f7243p = new int[0];

    /* renamed from: q  reason: collision with root package name */
    private static final Unsafe f7244q = r4.l();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f7245a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f7246b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7247c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7248d;

    /* renamed from: e  reason: collision with root package name */
    private final zzlm f7249e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f7250f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f7251g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f7252h;

    /* renamed from: i  reason: collision with root package name */
    private final int f7253i;

    /* renamed from: j  reason: collision with root package name */
    private final int f7254j;

    /* renamed from: k  reason: collision with root package name */
    private final e3 f7255k;

    /* renamed from: l  reason: collision with root package name */
    private final j4 f7256l;

    /* renamed from: m  reason: collision with root package name */
    private final v2 f7257m;

    /* renamed from: n  reason: collision with root package name */
    private final q3 f7258n;

    /* renamed from: o  reason: collision with root package name */
    private final j3 f7259o;

    private o3(int[] iArr, Object[] objArr, int i10, int i11, zzlm zzlm, boolean z10, boolean z11, int[] iArr2, int i12, int i13, q3 q3Var, e3 e3Var, j4 j4Var, v2 v2Var, j3 j3Var, byte[] bArr) {
        zzlm zzlm2 = zzlm;
        v2 v2Var2 = v2Var;
        this.f7245a = iArr;
        this.f7246b = objArr;
        this.f7247c = i10;
        this.f7248d = i11;
        this.f7251g = z10;
        boolean z12 = false;
        if (v2Var2 != null && v2Var2.c(zzlm)) {
            z12 = true;
        }
        this.f7250f = z12;
        this.f7252h = iArr2;
        this.f7253i = i12;
        this.f7254j = i13;
        this.f7258n = q3Var;
        this.f7255k = e3Var;
        this.f7256l = j4Var;
        this.f7257m = v2Var2;
        this.f7249e = zzlm2;
        this.f7259o = j3Var;
    }

    private final boolean A(Object obj, Object obj2, int i10) {
        if (B(obj, i10) == B(obj2, i10)) {
            return true;
        }
        return false;
    }

    private final boolean B(Object obj, int i10) {
        int X = X(i10);
        long j10 = (long) (X & 1048575);
        if (j10 == 1048575) {
            int j11 = j(i10);
            long j12 = (long) (j11 & 1048575);
            switch (i(j11)) {
                case 0:
                    if (Double.doubleToRawLongBits(r4.f(obj, j12)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(r4.g(obj, j12)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (r4.i(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (r4.i(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (r4.h(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (r4.i(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (r4.h(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return r4.B(obj, j12);
                case 8:
                    Object k10 = r4.k(obj, j12);
                    if (k10 instanceof String) {
                        if (!((String) k10).isEmpty()) {
                            return true;
                        }
                        return false;
                    } else if (!(k10 instanceof zzje)) {
                        throw new IllegalArgumentException();
                    } else if (!zzje.zzb.equals(k10)) {
                        return true;
                    } else {
                        return false;
                    }
                case 9:
                    if (r4.k(obj, j12) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    if (!zzje.zzb.equals(r4.k(obj, j12))) {
                        return true;
                    }
                    return false;
                case 11:
                    if (r4.h(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (r4.h(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (r4.h(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (r4.i(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (r4.h(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (r4.i(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (r4.k(obj, j12) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else if ((r4.h(obj, j10) & (1 << (X >>> 20))) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private final boolean C(Object obj, int i10, int i11, int i12, int i13) {
        if (i11 == 1048575) {
            return B(obj, i10);
        }
        if ((i12 & i13) != 0) {
            return true;
        }
        return false;
    }

    private static boolean D(Object obj, int i10, w3 w3Var) {
        return w3Var.c(r4.k(obj, (long) (i10 & 1048575)));
    }

    private static boolean E(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzkf) {
            return ((zzkf) obj).zzbO();
        }
        return true;
    }

    private final boolean F(Object obj, int i10, int i11) {
        if (r4.h(obj, (long) (X(i11) & 1048575)) == i10) {
            return true;
        }
        return false;
    }

    private static boolean G(Object obj, long j10) {
        return ((Boolean) r4.k(obj, j10)).booleanValue();
    }

    private static final void H(int i10, Object obj, x4 x4Var) {
        if (obj instanceof String) {
            x4Var.g(i10, (String) obj);
        } else {
            x4Var.n(i10, (zzje) obj);
        }
    }

    static zzmp J(Object obj) {
        zzkf zzkf = (zzkf) obj;
        zzmp zzmp = zzkf.zzc;
        if (zzmp != zzmp.zzc()) {
            return zzmp;
        }
        zzmp zzf = zzmp.zzf();
        zzkf.zzc = zzf;
        return zzf;
    }

    static o3 K(Class cls, l3 l3Var, q3 q3Var, e3 e3Var, j4 j4Var, v2 v2Var, j3 j3Var) {
        if (l3Var instanceof v3) {
            return L((v3) l3Var, q3Var, e3Var, j4Var, v2Var, j3Var);
        }
        d.a(l3Var);
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0384  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.measurement.o3 L(com.google.android.gms.internal.measurement.v3 r34, com.google.android.gms.internal.measurement.q3 r35, com.google.android.gms.internal.measurement.e3 r36, com.google.android.gms.internal.measurement.j4 r37, com.google.android.gms.internal.measurement.v2 r38, com.google.android.gms.internal.measurement.j3 r39) {
        /*
            int r0 = r34.zzc()
            r1 = 2
            r2 = 0
            if (r0 != r1) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = r2
        L_0x000b:
            java.lang.String r0 = r34.a()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0057
            int[] r6 = f7243p
            r8 = r2
            r9 = r8
            r11 = r9
            r12 = r11
            r14 = r12
            r16 = r14
            r13 = r6
            r6 = r16
            goto L_0x0166
        L_0x0057:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0076
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0063:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0073
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0063
        L_0x0073:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0076:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0095
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0082:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0092
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0082
        L_0x0092:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0095:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b4
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a1:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b1
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a1
        L_0x00b1:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b4:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c0:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00d0
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c0
        L_0x00d0:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d3:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00df:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ef
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00df
        L_0x00ef:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f2:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0111
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fe:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fe
        L_0x010e:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0111:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0132
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011d:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011d
        L_0x012e:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0132:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0155
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013e:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x0150
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013e
        L_0x0150:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0155:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0166:
            sun.misc.Unsafe r15 = f7244q
            java.lang.Object[] r17 = r34.b()
            com.google.android.gms.internal.measurement.zzlm r18 = r34.zza()
            java.lang.Class r2 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0184:
            if (r4 >= r1) goto L_0x03d3
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ac
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0194:
            int r26 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01a6
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r26
            goto L_0x0194
        L_0x01a6:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r26
            goto L_0x01ae
        L_0x01ac:
            r3 = r24
        L_0x01ae:
            int r24 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01db
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bc:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r1) goto L_0x01d5
            r1 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r3 = r3 | r1
            int r24 = r24 + 13
            r5 = r27
            r1 = r28
            goto L_0x01bc
        L_0x01d5:
            int r1 = r5 << r24
            r3 = r3 | r1
            r1 = r27
            goto L_0x01df
        L_0x01db:
            r28 = r1
            r1 = r24
        L_0x01df:
            r5 = r3 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r3 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ed
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ed:
            r14 = 51
            if (r5 < r14) goto L_0x029d
            int r14 = r1 + 1
            char r1 = r0.charAt(r1)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r14) goto L_0x0223
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0204:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021d
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r1 = r1 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0204
        L_0x021d:
            int r12 = r14 << r27
            r1 = r1 | r12
            r14 = r31
            goto L_0x0227
        L_0x0223:
            r32 = r12
            r14 = r27
        L_0x0227:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x024a
            r14 = 17
            if (r12 != r14) goto L_0x0234
            goto L_0x024a
        L_0x0234:
            r14 = 12
            if (r12 != r14) goto L_0x0258
            if (r10 != 0) goto L_0x0258
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0247:
            r16 = r14
            goto L_0x0258
        L_0x024a:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0247
        L_0x0258:
            int r1 = r1 + r1
            r12 = r17[r1]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0265
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
        L_0x0261:
            r31 = r7
            r14 = r8
            goto L_0x026e
        L_0x0265:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = q(r2, r12)
            r17[r1] = r12
            goto L_0x0261
        L_0x026e:
            long r7 = r15.objectFieldOffset(r12)
            int r7 = (int) r7
            int r1 = r1 + 1
            r8 = r17[r1]
            boolean r12 = r8 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027f
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
        L_0x027d:
            r1 = r7
            goto L_0x0288
        L_0x027f:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = q(r2, r8)
            r17[r1] = r8
            goto L_0x027d
        L_0x0288:
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r30 = r0
            r29 = r11
            r0 = r16
            r26 = r27
            r25 = 1
            r16 = r7
            r7 = r1
            r1 = 0
            goto L_0x0398
        L_0x029d:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = q(r2, r8)
            r12 = 9
            if (r5 == r12) goto L_0x02b4
            r12 = 17
            if (r5 != r12) goto L_0x02b7
        L_0x02b4:
            r25 = 1
            goto L_0x0318
        L_0x02b7:
            r12 = 27
            if (r5 == r12) goto L_0x02bf
            r12 = 49
            if (r5 != r12) goto L_0x02c2
        L_0x02bf:
            r25 = 1
            goto L_0x030c
        L_0x02c2:
            r12 = 12
            if (r5 == r12) goto L_0x02fa
            r12 = 30
            if (r5 == r12) goto L_0x02fa
            r12 = 44
            if (r5 != r12) goto L_0x02cf
            goto L_0x02fa
        L_0x02cf:
            r12 = 50
            if (r5 != r12) goto L_0x02ef
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r29 = r16 + 2
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r3 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02f3
            int r7 = r16 + 3
            int r22 = r22 + 1
            r16 = r17[r29]
            r11[r22] = r16
            r22 = r12
        L_0x02ef:
            r25 = 1
        L_0x02f1:
            r12 = r7
            goto L_0x0324
        L_0x02f3:
            r22 = r12
            r12 = r29
            r25 = 1
            goto L_0x0324
        L_0x02fa:
            if (r10 != 0) goto L_0x02ef
            int r12 = r9 / 3
            int r16 = r16 + 2
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x0309:
            r12 = r16
            goto L_0x0324
        L_0x030c:
            int r12 = r9 / 3
            int r16 = r16 + 2
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x0309
        L_0x0318:
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r16 = r8.getType()
            r11[r12] = r16
            goto L_0x02f1
        L_0x0324:
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r8 = r3 & 4096(0x1000, float:5.74E-42)
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r8 != r11) goto L_0x0384
            r8 = 17
            if (r5 > r8) goto L_0x0384
            int r8 = r1 + 1
            char r1 = r0.charAt(r1)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r11) goto L_0x035d
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0347:
            int r26 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r11) goto L_0x0359
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r16
            r1 = r1 | r8
            int r16 = r16 + 13
            r8 = r26
            goto L_0x0347
        L_0x0359:
            int r8 = r8 << r16
            r1 = r1 | r8
            goto L_0x035f
        L_0x035d:
            r26 = r8
        L_0x035f:
            int r8 = r6 + r6
            int r16 = r1 / 32
            int r8 = r8 + r16
            r11 = r17[r8]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0371
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
        L_0x036f:
            r0 = r12
            goto L_0x037a
        L_0x0371:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = q(r2, r11)
            r17[r8] = r11
            goto L_0x036f
        L_0x037a:
            long r11 = r15.objectFieldOffset(r11)
            int r8 = (int) r11
            int r1 = r1 % 32
            r16 = r8
            goto L_0x038a
        L_0x0384:
            r30 = r0
            r0 = r12
            r26 = r1
            r1 = 0
        L_0x038a:
            r8 = 18
            if (r5 < r8) goto L_0x0398
            r8 = 49
            if (r5 > r8) goto L_0x0398
            int r8 = r23 + 1
            r13[r23] = r7
            r23 = r8
        L_0x0398:
            int r8 = r9 + 1
            r31[r9] = r4
            int r4 = r9 + 2
            r11 = r3 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x03a5
            r11 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03a6
        L_0x03a5:
            r11 = 0
        L_0x03a6:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x03ad
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03ae
        L_0x03ad:
            r3 = 0
        L_0x03ae:
            r3 = r3 | r11
            int r5 = r5 << 20
            r3 = r3 | r5
            r3 = r3 | r7
            r31[r8] = r3
            int r9 = r9 + 3
            int r1 = r1 << 20
            r1 = r1 | r16
            r31[r4] = r1
            r16 = r0
            r8 = r14
            r14 = r24
            r4 = r26
            r1 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0184
        L_0x03d3:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.measurement.o3 r0 = new com.google.android.gms.internal.measurement.o3
            r4 = r0
            com.google.android.gms.internal.measurement.zzlm r9 = r34.zza()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.o3.L(com.google.android.gms.internal.measurement.v3, com.google.android.gms.internal.measurement.q3, com.google.android.gms.internal.measurement.e3, com.google.android.gms.internal.measurement.j4, com.google.android.gms.internal.measurement.v2, com.google.android.gms.internal.measurement.j3):com.google.android.gms.internal.measurement.o3");
    }

    private static double M(Object obj, long j10) {
        return ((Double) r4.k(obj, j10)).doubleValue();
    }

    private static float N(Object obj, long j10) {
        return ((Float) r4.k(obj, j10)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0315, code lost:
        r6 = r6 + r3;
        r12 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0426, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0052, code lost:
        r6 = r6 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0427, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0435, code lost:
        r3 = r3 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0444, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0489, code lost:
        r4 = r4 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x051b, code lost:
        r6 = r6 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x054c, code lost:
        r5 = r5 + 3;
        r4 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008a, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008b, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0099, code lost:
        r3 = r3 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a8, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ef, code lost:
        r4 = r4 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0188, code lost:
        r6 = r6 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01ee, code lost:
        r4 = r4 + r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int O(java.lang.Object r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = f7244q
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r4
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x000c:
            int[] r9 = r0.f7245a
            int r9 = r9.length
            if (r5 >= r9) goto L_0x0553
            int r9 = r15.j(r5)
            int[] r10 = r0.f7245a
            r11 = r10[r5]
            int r12 = i(r9)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x0035
            int r13 = r5 + 2
            r10 = r10[r13]
            r13 = r10 & r4
            int r10 = r10 >>> 20
            int r10 = r14 << r10
            if (r13 == r8) goto L_0x0036
            long r7 = (long) r13
            int r7 = r2.getInt(r1, r7)
            r8 = r13
            goto L_0x0036
        L_0x0035:
            r10 = 0
        L_0x0036:
            r9 = r9 & r4
            long r3 = (long) r9
            r9 = 63
            switch(r12) {
                case 0: goto L_0x053f;
                case 1: goto L_0x0532;
                case 2: goto L_0x051e;
                case 3: goto L_0x0508;
                case 4: goto L_0x04f3;
                case 5: goto L_0x04e6;
                case 6: goto L_0x04d9;
                case 7: goto L_0x04cb;
                case 8: goto L_0x049f;
                case 9: goto L_0x048c;
                case 10: goto L_0x0470;
                case 11: goto L_0x045c;
                case 12: goto L_0x0448;
                case 13: goto L_0x0439;
                case 14: goto L_0x042a;
                case 15: goto L_0x040e;
                case 16: goto L_0x03f4;
                case 17: goto L_0x03e0;
                case 18: goto L_0x03d4;
                case 19: goto L_0x03c8;
                case 20: goto L_0x03bc;
                case 21: goto L_0x03b0;
                case 22: goto L_0x03a4;
                case 23: goto L_0x0398;
                case 24: goto L_0x038c;
                case 25: goto L_0x037e;
                case 26: goto L_0x0372;
                case 27: goto L_0x0362;
                case 28: goto L_0x0356;
                case 29: goto L_0x0349;
                case 30: goto L_0x033d;
                case 31: goto L_0x0331;
                case 32: goto L_0x0325;
                case 33: goto L_0x0319;
                case 34: goto L_0x030a;
                case 35: goto L_0x02f4;
                case 36: goto L_0x02de;
                case 37: goto L_0x02c8;
                case 38: goto L_0x02b2;
                case 39: goto L_0x029c;
                case 40: goto L_0x0286;
                case 41: goto L_0x0270;
                case 42: goto L_0x025a;
                case 43: goto L_0x0245;
                case 44: goto L_0x0230;
                case 45: goto L_0x021b;
                case 46: goto L_0x0206;
                case 47: goto L_0x01f1;
                case 48: goto L_0x01da;
                case 49: goto L_0x01ca;
                case 50: goto L_0x01bd;
                case 51: goto L_0x01af;
                case 52: goto L_0x01a1;
                case 53: goto L_0x018c;
                case 54: goto L_0x0174;
                case 55: goto L_0x015e;
                case 56: goto L_0x0150;
                case 57: goto L_0x0142;
                case 58: goto L_0x0133;
                case 59: goto L_0x0106;
                case 60: goto L_0x00f2;
                case 61: goto L_0x00d5;
                case 62: goto L_0x00c0;
                case 63: goto L_0x00ab;
                case 64: goto L_0x009c;
                case 65: goto L_0x008d;
                case 66: goto L_0x0071;
                case 67: goto L_0x0056;
                case 68: goto L_0x003e;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0053
        L_0x003e:
            boolean r9 = r15.F(r1, r11, r5)
            if (r9 == 0) goto L_0x0053
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlm r3 = (com.google.android.gms.internal.measurement.zzlm) r3
            com.google.android.gms.internal.measurement.w3 r4 = r15.m(r5)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzu(r11, r3, r4)
        L_0x0052:
            int r6 = r6 + r3
        L_0x0053:
            r12 = 0
            goto L_0x054c
        L_0x0056:
            boolean r10 = r15.F(r1, r11, r5)
            if (r10 == 0) goto L_0x0053
            long r3 = k(r1, r3)
            int r10 = r11 << 3
            int r10 = com.google.android.gms.internal.measurement.zzjm.zzA(r10)
            long r11 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r11
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzB(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x0053
        L_0x0071:
            boolean r9 = r15.F(r1, r11, r5)
            if (r9 == 0) goto L_0x0053
            int r3 = Q(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x008a:
            int r4 = r4 + r3
        L_0x008b:
            int r6 = r6 + r4
            goto L_0x0053
        L_0x008d:
            boolean r3 = r15.F(r1, r11, r5)
            if (r3 == 0) goto L_0x0053
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x0099:
            int r3 = r3 + 8
            goto L_0x0052
        L_0x009c:
            boolean r3 = r15.F(r1, r11, r5)
            if (r3 == 0) goto L_0x0053
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x00a8:
            int r3 = r3 + 4
            goto L_0x0052
        L_0x00ab:
            boolean r9 = r15.F(r1, r11, r5)
            if (r9 == 0) goto L_0x0053
            int r3 = Q(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzv(r3)
            goto L_0x008a
        L_0x00c0:
            boolean r9 = r15.F(r1, r11, r5)
            if (r9 == 0) goto L_0x0053
            int r3 = Q(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x008a
        L_0x00d5:
            boolean r9 = r15.F(r1, r11, r5)
            if (r9 == 0) goto L_0x0053
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzje r3 = (com.google.android.gms.internal.measurement.zzje) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x00ef:
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x008b
        L_0x00f2:
            boolean r9 = r15.F(r1, r11, r5)
            if (r9 == 0) goto L_0x0053
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.w3 r4 = r15.m(r5)
            int r3 = com.google.android.gms.internal.measurement.y3.Q(r11, r3, r4)
            goto L_0x0052
        L_0x0106:
            boolean r9 = r15.F(r1, r11, r5)
            if (r9 == 0) goto L_0x0053
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzje
            if (r4 == 0) goto L_0x0125
            com.google.android.gms.internal.measurement.zzje r3 = (com.google.android.gms.internal.measurement.zzje) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x00ef
        L_0x0125:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzy(r3)
            goto L_0x008a
        L_0x0133:
            boolean r3 = r15.F(r1, r11, r5)
            if (r3 == 0) goto L_0x0053
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            int r3 = r3 + r14
            goto L_0x0052
        L_0x0142:
            boolean r3 = r15.F(r1, r11, r5)
            if (r3 == 0) goto L_0x0053
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x00a8
        L_0x0150:
            boolean r3 = r15.F(r1, r11, r5)
            if (r3 == 0) goto L_0x0053
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0099
        L_0x015e:
            boolean r9 = r15.F(r1, r11, r5)
            if (r9 == 0) goto L_0x0053
            int r3 = Q(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzv(r3)
            goto L_0x008a
        L_0x0174:
            boolean r9 = r15.F(r1, r11, r5)
            if (r9 == 0) goto L_0x0053
            long r3 = k(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzB(r3)
        L_0x0188:
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x0053
        L_0x018c:
            boolean r9 = r15.F(r1, r11, r5)
            if (r9 == 0) goto L_0x0053
            long r3 = k(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzB(r3)
            goto L_0x0188
        L_0x01a1:
            boolean r3 = r15.F(r1, r11, r5)
            if (r3 == 0) goto L_0x0053
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x00a8
        L_0x01af:
            boolean r3 = r15.F(r1, r11, r5)
            if (r3 == 0) goto L_0x0053
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0099
        L_0x01bd:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r15.n(r5)
            com.google.android.gms.internal.measurement.j3.a(r11, r3, r4)
            goto L_0x0053
        L_0x01ca:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.w3 r4 = r15.m(r5)
            int r3 = com.google.android.gms.internal.measurement.y3.L(r11, r3, r4)
            goto L_0x0052
        L_0x01da:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.V(r3)
            if (r3 <= 0) goto L_0x0053
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x01ee:
            int r4 = r4 + r9
            goto L_0x008a
        L_0x01f1:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.T(r3)
            if (r3 <= 0) goto L_0x0053
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01ee
        L_0x0206:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.K(r3)
            if (r3 <= 0) goto L_0x0053
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01ee
        L_0x021b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.I(r3)
            if (r3 <= 0) goto L_0x0053
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01ee
        L_0x0230:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.G(r3)
            if (r3 <= 0) goto L_0x0053
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01ee
        L_0x0245:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.Y(r3)
            if (r3 <= 0) goto L_0x0053
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01ee
        L_0x025a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.D(r3)
            if (r3 <= 0) goto L_0x0053
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01ee
        L_0x0270:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.I(r3)
            if (r3 <= 0) goto L_0x0053
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01ee
        L_0x0286:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.K(r3)
            if (r3 <= 0) goto L_0x0053
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01ee
        L_0x029c:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.N(r3)
            if (r3 <= 0) goto L_0x0053
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01ee
        L_0x02b2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.a0(r3)
            if (r3 <= 0) goto L_0x0053
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01ee
        L_0x02c8:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.P(r3)
            if (r3 <= 0) goto L_0x0053
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01ee
        L_0x02de:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.I(r3)
            if (r3 <= 0) goto L_0x0053
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01ee
        L_0x02f4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.K(r3)
            if (r3 <= 0) goto L_0x0053
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01ee
        L_0x030a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r9 = 0
            int r3 = com.google.android.gms.internal.measurement.y3.U(r11, r3, r9)
        L_0x0315:
            int r6 = r6 + r3
            r12 = r9
            goto L_0x054c
        L_0x0319:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.S(r11, r3, r9)
            goto L_0x0315
        L_0x0325:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.J(r11, r3, r9)
            goto L_0x0315
        L_0x0331:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.H(r11, r3, r9)
            goto L_0x0315
        L_0x033d:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.F(r11, r3, r9)
            goto L_0x0315
        L_0x0349:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.X(r11, r3, r9)
            goto L_0x0052
        L_0x0356:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.E(r11, r3)
            goto L_0x0052
        L_0x0362:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.w3 r4 = r15.m(r5)
            int r3 = com.google.android.gms.internal.measurement.y3.R(r11, r3, r4)
            goto L_0x0052
        L_0x0372:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.W(r11, r3)
            goto L_0x0052
        L_0x037e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r12 = 0
            int r3 = com.google.android.gms.internal.measurement.y3.A(r11, r3, r12)
        L_0x0389:
            int r6 = r6 + r3
            goto L_0x054c
        L_0x038c:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.H(r11, r3, r12)
            goto L_0x0389
        L_0x0398:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.J(r11, r3, r12)
            goto L_0x0389
        L_0x03a4:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.M(r11, r3, r12)
            goto L_0x0389
        L_0x03b0:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.Z(r11, r3, r12)
            goto L_0x0389
        L_0x03bc:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.O(r11, r3, r12)
            goto L_0x0389
        L_0x03c8:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.H(r11, r3, r12)
            goto L_0x0389
        L_0x03d4:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.y3.J(r11, r3, r12)
            goto L_0x0389
        L_0x03e0:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054c
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlm r3 = (com.google.android.gms.internal.measurement.zzlm) r3
            com.google.android.gms.internal.measurement.w3 r4 = r15.m(r5)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzu(r11, r3, r4)
            goto L_0x0389
        L_0x03f4:
            r12 = 0
            r10 = r10 & r7
            if (r10 == 0) goto L_0x054c
            long r3 = r2.getLong(r1, r3)
            int r10 = r11 << 3
            int r10 = com.google.android.gms.internal.measurement.zzjm.zzA(r10)
            long r13 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r13
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzB(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x054c
        L_0x040e:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054c
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x0426:
            int r4 = r4 + r3
        L_0x0427:
            int r6 = r6 + r4
            goto L_0x054c
        L_0x042a:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054c
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x0435:
            int r3 = r3 + 8
            goto L_0x0389
        L_0x0439:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054c
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x0444:
            int r3 = r3 + 4
            goto L_0x0389
        L_0x0448:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054c
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzv(r3)
            goto L_0x0426
        L_0x045c:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054c
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0426
        L_0x0470:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054c
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzje r3 = (com.google.android.gms.internal.measurement.zzje) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x0489:
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x0427
        L_0x048c:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054c
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.w3 r4 = r15.m(r5)
            int r3 = com.google.android.gms.internal.measurement.y3.Q(r11, r3, r4)
            goto L_0x0389
        L_0x049f:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054c
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzje
            if (r4 == 0) goto L_0x04bd
            com.google.android.gms.internal.measurement.zzje r3 = (com.google.android.gms.internal.measurement.zzje) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0489
        L_0x04bd:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzy(r3)
            goto L_0x0426
        L_0x04cb:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054c
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            int r3 = r3 + r14
            goto L_0x0389
        L_0x04d9:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054c
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0444
        L_0x04e6:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054c
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0435
        L_0x04f3:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054c
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzv(r3)
            goto L_0x0426
        L_0x0508:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054c
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzB(r3)
        L_0x051b:
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x054c
        L_0x051e:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054c
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzB(r3)
            goto L_0x051b
        L_0x0532:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054c
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0444
        L_0x053f:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054c
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0435
        L_0x054c:
            int r5 = r5 + 3
            r4 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000c
        L_0x0553:
            com.google.android.gms.internal.measurement.j4 r2 = r0.f7256l
            java.lang.Object r3 = r2.d(r1)
            int r2 = r2.a(r3)
            int r6 = r6 + r2
            boolean r2 = r0.f7250f
            if (r2 != 0) goto L_0x0563
            return r6
        L_0x0563:
            com.google.android.gms.internal.measurement.v2 r2 = r0.f7257m
            r2.a(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.o3.O(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x054f, code lost:
        r2 = r2 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0092, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a1, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e8, code lost:
        r5 = r5 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0139, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0183, code lost:
        r3 = r3 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01e9, code lost:
        r5 = r5 + r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int P(java.lang.Object r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = f7244q
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0005:
            int[] r4 = r11.f7245a
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0553
            int r4 = r11.j(r2)
            int r5 = i(r4)
            int[] r6 = r11.f7245a
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.measurement.zzjx r4 = com.google.android.gms.internal.measurement.zzjx.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.measurement.zzjx r4 = com.google.android.gms.internal.measurement.zzjx.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.f7245a
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0541;
                case 1: goto L_0x0533;
                case 2: goto L_0x051d;
                case 3: goto L_0x0507;
                case 4: goto L_0x04f1;
                case 5: goto L_0x04e3;
                case 6: goto L_0x04d5;
                case 7: goto L_0x04c7;
                case 8: goto L_0x0499;
                case 9: goto L_0x0485;
                case 10: goto L_0x0469;
                case 11: goto L_0x0453;
                case 12: goto L_0x043d;
                case 13: goto L_0x042f;
                case 14: goto L_0x0421;
                case 15: goto L_0x0406;
                case 16: goto L_0x03eb;
                case 17: goto L_0x03d5;
                case 18: goto L_0x03c9;
                case 19: goto L_0x03bd;
                case 20: goto L_0x03b1;
                case 21: goto L_0x03a5;
                case 22: goto L_0x0399;
                case 23: goto L_0x038d;
                case 24: goto L_0x0381;
                case 25: goto L_0x0375;
                case 26: goto L_0x0369;
                case 27: goto L_0x0359;
                case 28: goto L_0x034d;
                case 29: goto L_0x0341;
                case 30: goto L_0x0335;
                case 31: goto L_0x0329;
                case 32: goto L_0x031d;
                case 33: goto L_0x0311;
                case 34: goto L_0x0305;
                case 35: goto L_0x02ef;
                case 36: goto L_0x02d9;
                case 37: goto L_0x02c3;
                case 38: goto L_0x02ad;
                case 39: goto L_0x0297;
                case 40: goto L_0x0281;
                case 41: goto L_0x026b;
                case 42: goto L_0x0255;
                case 43: goto L_0x0240;
                case 44: goto L_0x022b;
                case 45: goto L_0x0216;
                case 46: goto L_0x0201;
                case 47: goto L_0x01ec;
                case 48: goto L_0x01d5;
                case 49: goto L_0x01c5;
                case 50: goto L_0x01b8;
                case 51: goto L_0x01aa;
                case 52: goto L_0x019c;
                case 53: goto L_0x0187;
                case 54: goto L_0x016f;
                case 55: goto L_0x0159;
                case 56: goto L_0x014b;
                case 57: goto L_0x013d;
                case 58: goto L_0x012d;
                case 59: goto L_0x0100;
                case 60: goto L_0x00ec;
                case 61: goto L_0x00ce;
                case 62: goto L_0x00b9;
                case 63: goto L_0x00a4;
                case 64: goto L_0x0095;
                case 65: goto L_0x0086;
                case 66: goto L_0x006c;
                case 67: goto L_0x004f;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x054f
        L_0x0038:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            com.google.android.gms.internal.measurement.zzlm r4 = (com.google.android.gms.internal.measurement.zzlm) r4
            com.google.android.gms.internal.measurement.w3 r5 = r11.m(r2)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzu(r6, r4, r5)
        L_0x004c:
            int r3 = r3 + r4
            goto L_0x054f
        L_0x004f:
            boolean r5 = r11.F(r12, r6, r2)
            if (r5 == 0) goto L_0x054f
            long r7 = k(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzB(r6)
        L_0x0068:
            int r5 = r5 + r4
        L_0x0069:
            int r3 = r3 + r5
            goto L_0x054f
        L_0x006c:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = Q(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0068
        L_0x0086:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
        L_0x0092:
            int r4 = r4 + 8
            goto L_0x004c
        L_0x0095:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
        L_0x00a1:
            int r4 = r4 + 4
            goto L_0x004c
        L_0x00a4:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = Q(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzv(r4)
            goto L_0x0068
        L_0x00b9:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = Q(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0068
        L_0x00ce:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            com.google.android.gms.internal.measurement.zzje r4 = (com.google.android.gms.internal.measurement.zzje) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
        L_0x00e8:
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x0069
        L_0x00ec:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            com.google.android.gms.internal.measurement.w3 r5 = r11.m(r2)
            int r4 = com.google.android.gms.internal.measurement.y3.Q(r6, r4, r5)
            goto L_0x004c
        L_0x0100:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzje
            if (r5 == 0) goto L_0x011f
            com.google.android.gms.internal.measurement.zzje r4 = (com.google.android.gms.internal.measurement.zzje) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x00e8
        L_0x011f:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzy(r4)
            goto L_0x0068
        L_0x012d:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
        L_0x0139:
            int r4 = r4 + 1
            goto L_0x004c
        L_0x013d:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x00a1
        L_0x014b:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0092
        L_0x0159:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = Q(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzv(r4)
            goto L_0x0068
        L_0x016f:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            long r4 = k(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzB(r4)
        L_0x0183:
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x054f
        L_0x0187:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            long r4 = k(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzB(r4)
            goto L_0x0183
        L_0x019c:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x00a1
        L_0x01aa:
            boolean r4 = r11.F(r12, r6, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0092
        L_0x01b8:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.lang.Object r5 = r11.n(r2)
            com.google.android.gms.internal.measurement.j3.a(r6, r4, r5)
            goto L_0x054f
        L_0x01c5:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.w3 r5 = r11.m(r2)
            int r4 = com.google.android.gms.internal.measurement.y3.L(r6, r4, r5)
            goto L_0x004c
        L_0x01d5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.V(r4)
            if (r4 <= 0) goto L_0x054f
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
        L_0x01e9:
            int r5 = r5 + r6
            goto L_0x0068
        L_0x01ec:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.T(r4)
            if (r4 <= 0) goto L_0x054f
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x01e9
        L_0x0201:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.K(r4)
            if (r4 <= 0) goto L_0x054f
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x01e9
        L_0x0216:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.I(r4)
            if (r4 <= 0) goto L_0x054f
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x01e9
        L_0x022b:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.G(r4)
            if (r4 <= 0) goto L_0x054f
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x01e9
        L_0x0240:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.Y(r4)
            if (r4 <= 0) goto L_0x054f
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x01e9
        L_0x0255:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.D(r4)
            if (r4 <= 0) goto L_0x054f
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x01e9
        L_0x026b:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.I(r4)
            if (r4 <= 0) goto L_0x054f
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x01e9
        L_0x0281:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.K(r4)
            if (r4 <= 0) goto L_0x054f
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x01e9
        L_0x0297:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.N(r4)
            if (r4 <= 0) goto L_0x054f
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x01e9
        L_0x02ad:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.a0(r4)
            if (r4 <= 0) goto L_0x054f
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x01e9
        L_0x02c3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.P(r4)
            if (r4 <= 0) goto L_0x054f
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x01e9
        L_0x02d9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.I(r4)
            if (r4 <= 0) goto L_0x054f
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x01e9
        L_0x02ef:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.K(r4)
            if (r4 <= 0) goto L_0x054f
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x01e9
        L_0x0305:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.U(r6, r4, r1)
            goto L_0x004c
        L_0x0311:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.S(r6, r4, r1)
            goto L_0x004c
        L_0x031d:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.J(r6, r4, r1)
            goto L_0x004c
        L_0x0329:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.H(r6, r4, r1)
            goto L_0x004c
        L_0x0335:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.F(r6, r4, r1)
            goto L_0x004c
        L_0x0341:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.X(r6, r4, r1)
            goto L_0x004c
        L_0x034d:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.E(r6, r4)
            goto L_0x004c
        L_0x0359:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.w3 r5 = r11.m(r2)
            int r4 = com.google.android.gms.internal.measurement.y3.R(r6, r4, r5)
            goto L_0x004c
        L_0x0369:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.W(r6, r4)
            goto L_0x004c
        L_0x0375:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.A(r6, r4, r1)
            goto L_0x004c
        L_0x0381:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.H(r6, r4, r1)
            goto L_0x004c
        L_0x038d:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.J(r6, r4, r1)
            goto L_0x004c
        L_0x0399:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.M(r6, r4, r1)
            goto L_0x004c
        L_0x03a5:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.Z(r6, r4, r1)
            goto L_0x004c
        L_0x03b1:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.O(r6, r4, r1)
            goto L_0x004c
        L_0x03bd:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.H(r6, r4, r1)
            goto L_0x004c
        L_0x03c9:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.y3.J(r6, r4, r1)
            goto L_0x004c
        L_0x03d5:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            com.google.android.gms.internal.measurement.zzlm r4 = (com.google.android.gms.internal.measurement.zzlm) r4
            com.google.android.gms.internal.measurement.w3 r5 = r11.m(r2)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzu(r6, r4, r5)
            goto L_0x004c
        L_0x03eb:
            boolean r5 = r11.B(r12, r2)
            if (r5 == 0) goto L_0x054f
            long r7 = com.google.android.gms.internal.measurement.r4.i(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzB(r6)
            goto L_0x0068
        L_0x0406:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = com.google.android.gms.internal.measurement.r4.h(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0068
        L_0x0421:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0092
        L_0x042f:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x00a1
        L_0x043d:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = com.google.android.gms.internal.measurement.r4.h(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzv(r4)
            goto L_0x0068
        L_0x0453:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = com.google.android.gms.internal.measurement.r4.h(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0068
        L_0x0469:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            com.google.android.gms.internal.measurement.zzje r4 = (com.google.android.gms.internal.measurement.zzje) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x00e8
        L_0x0485:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            com.google.android.gms.internal.measurement.w3 r5 = r11.m(r2)
            int r4 = com.google.android.gms.internal.measurement.y3.Q(r6, r4, r5)
            goto L_0x004c
        L_0x0499:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            java.lang.Object r4 = com.google.android.gms.internal.measurement.r4.k(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzje
            if (r5 == 0) goto L_0x04b9
            com.google.android.gms.internal.measurement.zzje r4 = (com.google.android.gms.internal.measurement.zzje) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x00e8
        L_0x04b9:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzy(r4)
            goto L_0x0068
        L_0x04c7:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0139
        L_0x04d5:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x00a1
        L_0x04e3:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0092
        L_0x04f1:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = com.google.android.gms.internal.measurement.r4.h(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzv(r4)
            goto L_0x0068
        L_0x0507:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            long r4 = com.google.android.gms.internal.measurement.r4.i(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzB(r4)
            goto L_0x0183
        L_0x051d:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            long r4 = com.google.android.gms.internal.measurement.r4.i(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzB(r4)
            goto L_0x0183
        L_0x0533:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x00a1
        L_0x0541:
            boolean r4 = r11.B(r12, r2)
            if (r4 == 0) goto L_0x054f
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0092
        L_0x054f:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0553:
            com.google.android.gms.internal.measurement.j4 r0 = r11.f7256l
            java.lang.Object r12 = r0.d(r12)
            int r12 = r0.a(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.o3.P(java.lang.Object):int");
    }

    private static int Q(Object obj, long j10) {
        return ((Integer) r4.k(obj, j10)).intValue();
    }

    private final int R(Object obj, byte[] bArr, int i10, int i11, int i12, long j10, i2 i2Var) {
        Unsafe unsafe = f7244q;
        Object n10 = n(i12);
        Object object = unsafe.getObject(obj, j10);
        if (!((zzlg) object).zze()) {
            zzlg zzb = zzlg.zza().zzb();
            j3.b(zzb, object);
            unsafe.putObject(obj, j10, zzb);
        }
        zzlf zzlf = (zzlf) n10;
        throw null;
    }

    private final int S(Object obj, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, int i17, i2 i2Var) {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i18 = i10;
        int i19 = i12;
        int i20 = i13;
        int i21 = i14;
        long j11 = j10;
        int i22 = i17;
        i2 i2Var2 = i2Var;
        Unsafe unsafe = f7244q;
        long j12 = (long) (this.f7245a[i22 + 2] & 1048575);
        switch (i16) {
            case 51:
                if (i21 == 1) {
                    unsafe.putObject(obj2, j11, Double.valueOf(Double.longBitsToDouble(j2.p(bArr, i10))));
                    unsafe.putInt(obj2, j12, i20);
                    return i18 + 8;
                }
                break;
            case 52:
                if (i21 == 5) {
                    unsafe.putObject(obj2, j11, Float.valueOf(Float.intBitsToFloat(j2.b(bArr, i10))));
                    unsafe.putInt(obj2, j12, i20);
                    return i18 + 4;
                }
                break;
            case 53:
            case 54:
                if (i21 == 0) {
                    int m10 = j2.m(bArr2, i18, i2Var2);
                    unsafe.putObject(obj2, j11, Long.valueOf(i2Var2.f7199b));
                    unsafe.putInt(obj2, j12, i20);
                    return m10;
                }
                break;
            case 55:
            case 62:
                if (i21 == 0) {
                    int j13 = j2.j(bArr2, i18, i2Var2);
                    unsafe.putObject(obj2, j11, Integer.valueOf(i2Var2.f7198a));
                    unsafe.putInt(obj2, j12, i20);
                    return j13;
                }
                break;
            case 56:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH:
                if (i21 == 1) {
                    unsafe.putObject(obj2, j11, Long.valueOf(j2.p(bArr, i10)));
                    unsafe.putInt(obj2, j12, i20);
                    return i18 + 8;
                }
                break;
            case 57:
            case 64:
                if (i21 == 5) {
                    unsafe.putObject(obj2, j11, Integer.valueOf(j2.b(bArr, i10)));
                    unsafe.putInt(obj2, j12, i20);
                    return i18 + 4;
                }
                break;
            case 58:
                if (i21 == 0) {
                    int m11 = j2.m(bArr2, i18, i2Var2);
                    unsafe.putObject(obj2, j11, Boolean.valueOf(i2Var2.f7199b != 0));
                    unsafe.putInt(obj2, j12, i20);
                    return m11;
                }
                break;
            case 59:
                if (i21 == 2) {
                    int j14 = j2.j(bArr2, i18, i2Var2);
                    int i23 = i2Var2.f7198a;
                    if (i23 == 0) {
                        unsafe.putObject(obj2, j11, "");
                    } else if ((i15 & 536870912) == 0 || w4.f(bArr2, j14, j14 + i23)) {
                        unsafe.putObject(obj2, j11, new String(bArr2, j14, i23, zzkn.zzb));
                        j14 += i23;
                    } else {
                        throw zzkp.zzc();
                    }
                    unsafe.putInt(obj2, j12, i20);
                    return j14;
                }
                break;
            case 60:
                if (i21 == 2) {
                    Object p10 = p(obj2, i20, i22);
                    int o10 = j2.o(p10, m(i22), bArr, i10, i11, i2Var);
                    x(obj2, i20, i22, p10);
                    return o10;
                }
                break;
            case 61:
                if (i21 == 2) {
                    int a10 = j2.a(bArr2, i18, i2Var2);
                    unsafe.putObject(obj2, j11, i2Var2.f7200c);
                    unsafe.putInt(obj2, j12, i20);
                    return a10;
                }
                break;
            case HtmlCompat.FROM_HTML_MODE_COMPACT /*63*/:
                if (i21 == 0) {
                    int j15 = j2.j(bArr2, i18, i2Var2);
                    int i24 = i2Var2.f7198a;
                    zzkj l10 = l(i22);
                    if (l10 == null || l10.zza(i24)) {
                        unsafe.putObject(obj2, j11, Integer.valueOf(i24));
                        unsafe.putInt(obj2, j12, i20);
                    } else {
                        J(obj).zzj(i19, Long.valueOf((long) i24));
                    }
                    return j15;
                }
                break;
            case 66:
                if (i21 == 0) {
                    int j16 = j2.j(bArr2, i18, i2Var2);
                    unsafe.putObject(obj2, j11, Integer.valueOf(zzji.zzb(i2Var2.f7198a)));
                    unsafe.putInt(obj2, j12, i20);
                    return j16;
                }
                break;
            case 67:
                if (i21 == 0) {
                    int m12 = j2.m(bArr2, i18, i2Var2);
                    unsafe.putObject(obj2, j11, Long.valueOf(zzji.zzc(i2Var2.f7199b)));
                    unsafe.putInt(obj2, j12, i20);
                    return m12;
                }
                break;
            case 68:
                if (i21 == 3) {
                    Object p11 = p(obj2, i20, i22);
                    int n10 = j2.n(p11, m(i22), bArr, i10, i11, (i19 & -8) | 4, i2Var);
                    x(obj2, i20, i22, p11);
                    return n10;
                }
                break;
        }
        return i18;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02b5, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02e6, code lost:
        if (r0 != r15) goto L_0x029d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0306, code lost:
        if (r0 != r15) goto L_0x029d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008a, code lost:
        r23 = r32;
        r11 = r34;
        r10 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008f, code lost:
        r13 = r4;
        r32 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b0, code lost:
        r2 = r10;
        r0 = r13;
        r1 = r23;
        r8 = -1;
        r10 = 1048575;
        r13 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d2, code lost:
        r6 = r6 | r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d3, code lost:
        r13 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f0, code lost:
        r6 = r6 | r8;
        r13 = r33;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0148, code lost:
        r6 = r32 | r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x014b, code lost:
        r13 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01a2, code lost:
        r0 = r13 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0210, code lost:
        r6 = r32;
        r28 = r9;
        r19 = r10;
        r2 = r13;
        r18 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x029b, code lost:
        if (r0 != r15) goto L_0x029d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int T(java.lang.Object r30, byte[] r31, int r32, int r33, com.google.android.gms.internal.measurement.i2 r34) {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r(r30)
            sun.misc.Unsafe r9 = f7244q
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r16 = 0
            r8 = -1
            r0 = r32
            r1 = r8
            r7 = r10
            r2 = r16
            r6 = r2
        L_0x001c:
            if (r0 >= r13) goto L_0x032a
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002e
            int r0 = com.google.android.gms.internal.measurement.j2.k(r0, r12, r3, r11)
            int r3 = r11.f7198a
            r4 = r0
            r17 = r3
            goto L_0x0031
        L_0x002e:
            r17 = r0
            r4 = r3
        L_0x0031:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003f
            int r2 = r2 / 3
            int r0 = r15.W(r5, r2)
        L_0x003d:
            r2 = r0
            goto L_0x0044
        L_0x003f:
            int r0 = r15.V(r5)
            goto L_0x003d
        L_0x0044:
            if (r2 != r8) goto L_0x0051
            r2 = r4
            r23 = r5
            r18 = r8
            r28 = r9
            r19 = r16
            goto L_0x0309
        L_0x0051:
            int[] r0 = r15.f7245a
            int r1 = r2 + 1
            r1 = r0[r1]
            int r13 = i(r1)
            r8 = r1 & r10
            long r10 = (long) r8
            r8 = 17
            r32 = r5
            if (r13 > r8) goto L_0x021b
            int r8 = r2 + 2
            r0 = r0[r8]
            int r8 = r0 >>> 20
            r5 = 1
            int r8 = r5 << r8
            r21 = r10
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r10
            if (r0 == r7) goto L_0x0086
            if (r7 == r10) goto L_0x007e
            long r10 = (long) r7
            r9.putInt(r14, r10, r6)
            r10 = 1048575(0xfffff, float:1.469367E-39)
        L_0x007e:
            if (r0 == r10) goto L_0x0085
            long r6 = (long) r0
            int r6 = r9.getInt(r14, r6)
        L_0x0085:
            r7 = r0
        L_0x0086:
            r0 = 5
            switch(r13) {
                case 0: goto L_0x01f7;
                case 1: goto L_0x01dc;
                case 2: goto L_0x01bb;
                case 3: goto L_0x01bb;
                case 4: goto L_0x01a5;
                case 5: goto L_0x0188;
                case 6: goto L_0x0173;
                case 7: goto L_0x014e;
                case 8: goto L_0x0129;
                case 9: goto L_0x0109;
                case 10: goto L_0x00f5;
                case 11: goto L_0x01a5;
                case 12: goto L_0x00de;
                case 13: goto L_0x0173;
                case 14: goto L_0x0188;
                case 15: goto L_0x00bc;
                case 16: goto L_0x0094;
                default: goto L_0x008a;
            }
        L_0x008a:
            r23 = r32
            r11 = r34
            r10 = r2
        L_0x008f:
            r13 = r4
            r32 = r6
            goto L_0x0210
        L_0x0094:
            if (r3 != 0) goto L_0x008a
            r11 = r34
            r0 = r21
            int r13 = com.google.android.gms.internal.measurement.j2.m(r12, r4, r11)
            long r3 = r11.f7199b
            long r4 = com.google.android.gms.internal.measurement.zzji.zzc(r3)
            r0 = r9
            r1 = r30
            r10 = r2
            r2 = r21
            r23 = r32
            r0.putLong(r1, r2, r4)
            r6 = r6 | r8
        L_0x00b0:
            r2 = r10
            r0 = r13
            r1 = r23
            r8 = -1
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r33
            goto L_0x001c
        L_0x00bc:
            r23 = r32
            r11 = r34
            r10 = r2
            if (r3 != 0) goto L_0x008f
            int r0 = com.google.android.gms.internal.measurement.j2.j(r12, r4, r11)
            int r1 = r11.f7198a
            int r1 = com.google.android.gms.internal.measurement.zzji.zzb(r1)
            r2 = r21
            r9.putInt(r14, r2, r1)
        L_0x00d2:
            r6 = r6 | r8
        L_0x00d3:
            r13 = r33
        L_0x00d5:
            r2 = r10
            r1 = r23
            r8 = -1
        L_0x00d9:
            r10 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x001c
        L_0x00de:
            r23 = r32
            r11 = r34
            r10 = r2
            r0 = r21
            if (r3 != 0) goto L_0x008f
            int r2 = com.google.android.gms.internal.measurement.j2.j(r12, r4, r11)
            int r3 = r11.f7198a
            r9.putInt(r14, r0, r3)
        L_0x00f0:
            r6 = r6 | r8
            r13 = r33
            r0 = r2
            goto L_0x00d5
        L_0x00f5:
            r23 = r32
            r11 = r34
            r10 = r2
            r0 = r21
            r2 = 2
            if (r3 != r2) goto L_0x008f
            int r2 = com.google.android.gms.internal.measurement.j2.a(r12, r4, r11)
            java.lang.Object r3 = r11.f7200c
            r9.putObject(r14, r0, r3)
            goto L_0x00f0
        L_0x0109:
            r23 = r32
            r11 = r34
            r10 = r2
            r2 = 2
            if (r3 != r2) goto L_0x008f
            java.lang.Object r13 = r15.o(r14, r10)
            com.google.android.gms.internal.measurement.w3 r1 = r15.m(r10)
            r0 = r13
            r2 = r31
            r3 = r4
            r4 = r33
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.j2.o(r0, r1, r2, r3, r4, r5)
            r15.w(r14, r10, r13)
            goto L_0x00d2
        L_0x0129:
            r23 = r32
            r11 = r34
            r10 = r2
            r32 = r6
            r5 = r21
            r0 = 2
            if (r3 != r0) goto L_0x014b
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x013f
            int r0 = com.google.android.gms.internal.measurement.j2.g(r12, r4, r11)
            goto L_0x0143
        L_0x013f:
            int r0 = com.google.android.gms.internal.measurement.j2.h(r12, r4, r11)
        L_0x0143:
            java.lang.Object r1 = r11.f7200c
            r9.putObject(r14, r5, r1)
        L_0x0148:
            r6 = r32 | r8
            goto L_0x00d3
        L_0x014b:
            r13 = r4
            goto L_0x0210
        L_0x014e:
            r23 = r32
            r11 = r34
            r10 = r2
            r0 = r5
            r32 = r6
            r5 = r21
            if (r3 != 0) goto L_0x014b
            int r1 = com.google.android.gms.internal.measurement.j2.m(r12, r4, r11)
            long r2 = r11.f7199b
            r20 = 0
            int r2 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r2 == 0) goto L_0x0167
            goto L_0x0169
        L_0x0167:
            r0 = r16
        L_0x0169:
            com.google.android.gms.internal.measurement.r4.r(r14, r5, r0)
            r6 = r32 | r8
            r13 = r33
            r0 = r1
            goto L_0x00d5
        L_0x0173:
            r23 = r32
            r11 = r34
            r10 = r2
            r32 = r6
            r5 = r21
            if (r3 != r0) goto L_0x014b
            int r0 = com.google.android.gms.internal.measurement.j2.b(r12, r4)
            r9.putInt(r14, r5, r0)
            int r0 = r4 + 4
            goto L_0x0148
        L_0x0188:
            r23 = r32
            r11 = r34
            r10 = r2
            r0 = r5
            r32 = r6
            r5 = r21
            if (r3 != r0) goto L_0x014b
            long r20 = com.google.android.gms.internal.measurement.j2.p(r12, r4)
            r0 = r9
            r1 = r30
            r2 = r5
            r13 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
        L_0x01a2:
            int r0 = r13 + 8
            goto L_0x0148
        L_0x01a5:
            r23 = r32
            r11 = r34
            r10 = r2
            r13 = r4
            r32 = r6
            r5 = r21
            if (r3 != 0) goto L_0x0210
            int r0 = com.google.android.gms.internal.measurement.j2.j(r12, r13, r11)
            int r1 = r11.f7198a
            r9.putInt(r14, r5, r1)
            goto L_0x0148
        L_0x01bb:
            r23 = r32
            r11 = r34
            r10 = r2
            r13 = r4
            r32 = r6
            r5 = r21
            if (r3 != 0) goto L_0x0210
            int r13 = com.google.android.gms.internal.measurement.j2.m(r12, r13, r11)
            long r2 = r11.f7199b
            r0 = r9
            r1 = r30
            r20 = r2
            r2 = r5
            r4 = r20
            r0.putLong(r1, r2, r4)
            r6 = r32 | r8
            goto L_0x00b0
        L_0x01dc:
            r23 = r32
            r11 = r34
            r10 = r2
            r13 = r4
            r32 = r6
            r5 = r21
            if (r3 != r0) goto L_0x0210
            int r0 = com.google.android.gms.internal.measurement.j2.b(r12, r13)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.r4.u(r14, r5, r0)
            int r0 = r13 + 4
            goto L_0x0148
        L_0x01f7:
            r23 = r32
            r11 = r34
            r10 = r2
            r13 = r4
            r0 = r5
            r32 = r6
            r5 = r21
            if (r3 != r0) goto L_0x0210
            long r0 = com.google.android.gms.internal.measurement.j2.p(r12, r13)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.r4.t(r14, r5, r0)
            goto L_0x01a2
        L_0x0210:
            r6 = r32
            r28 = r9
            r19 = r10
            r2 = r13
            r18 = -1
            goto L_0x0309
        L_0x021b:
            r23 = r32
            r8 = r6
            r5 = r10
            r11 = r34
            r10 = r2
            r0 = 27
            if (r13 != r0) goto L_0x026a
            r0 = 2
            if (r3 != r0) goto L_0x025d
            java.lang.Object r0 = r9.getObject(r14, r5)
            com.google.android.gms.internal.measurement.zzkm r0 = (com.google.android.gms.internal.measurement.zzkm) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0246
            int r1 = r0.size()
            if (r1 != 0) goto L_0x023e
            r1 = 10
            goto L_0x023f
        L_0x023e:
            int r1 = r1 + r1
        L_0x023f:
            com.google.android.gms.internal.measurement.zzkm r0 = r0.zzd(r1)
            r9.putObject(r14, r5, r0)
        L_0x0246:
            r5 = r0
            com.google.android.gms.internal.measurement.w3 r0 = r15.m(r10)
            r1 = r17
            r2 = r31
            r3 = r4
            r4 = r33
            r6 = r34
            int r0 = com.google.android.gms.internal.measurement.j2.e(r0, r1, r2, r3, r4, r5, r6)
            r13 = r33
            r6 = r8
            goto L_0x00d5
        L_0x025d:
            r15 = r4
            r26 = r7
            r27 = r8
            r28 = r9
            r19 = r10
            r18 = -1
            goto L_0x02e9
        L_0x026a:
            r0 = 49
            if (r13 > r0) goto L_0x02bb
            long r1 = (long) r1
            r0 = r29
            r20 = r1
            r1 = r30
            r2 = r31
            r32 = r3
            r3 = r4
            r15 = r4
            r4 = r33
            r24 = r5
            r5 = r17
            r6 = r23
            r26 = r7
            r7 = r32
            r27 = r8
            r18 = -1
            r8 = r10
            r28 = r9
            r19 = r10
            r9 = r20
            r11 = r13
            r12 = r24
            r14 = r34
            int r0 = r0.U(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02b5
        L_0x029d:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r8 = r18
            r2 = r19
            r1 = r23
            r7 = r26
            r6 = r27
        L_0x02b1:
            r9 = r28
            goto L_0x00d9
        L_0x02b5:
            r2 = r0
        L_0x02b6:
            r7 = r26
            r6 = r27
            goto L_0x0309
        L_0x02bb:
            r32 = r3
            r15 = r4
            r24 = r5
            r26 = r7
            r27 = r8
            r28 = r9
            r19 = r10
            r18 = -1
            r0 = 50
            if (r13 != r0) goto L_0x02eb
            r7 = r32
            r0 = 2
            if (r7 != r0) goto L_0x02e9
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r19
            r6 = r24
            r8 = r34
            int r0 = r0.R(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02b5
            goto L_0x029d
        L_0x02e9:
            r2 = r15
            goto L_0x02b6
        L_0x02eb:
            r7 = r32
            r0 = r29
            r8 = r1
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r17
            r6 = r23
            r9 = r13
            r10 = r24
            r12 = r19
            r13 = r34
            int r0 = r0.S(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02b5
            goto L_0x029d
        L_0x0309:
            com.google.android.gms.internal.measurement.zzmp r4 = J(r30)
            r0 = r17
            r1 = r31
            r3 = r33
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.j2.i(r0, r1, r2, r3, r4, r5)
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r8 = r18
            r2 = r19
            r1 = r23
            goto L_0x02b1
        L_0x032a:
            r27 = r6
            r28 = r9
            r1 = r10
            if (r7 == r1) goto L_0x033b
            long r1 = (long) r7
            r3 = r30
            r6 = r27
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x033b:
            r1 = r33
            if (r0 != r1) goto L_0x0340
            return r0
        L_0x0340:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.o3.T(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.i2):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x03c8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01e8  */
    private final int U(java.lang.Object r15, byte[] r16, int r17, int r18, int r19, int r20, int r21, int r22, long r23, int r25, long r26, com.google.android.gms.internal.measurement.i2 r28) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r2 = r19
            r6 = r21
            r8 = r22
            r9 = r26
            r7 = r28
            sun.misc.Unsafe r11 = f7244q
            java.lang.Object r12 = r11.getObject(r15, r9)
            com.google.android.gms.internal.measurement.zzkm r12 = (com.google.android.gms.internal.measurement.zzkm) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0031
            int r13 = r12.size()
            if (r13 != 0) goto L_0x0029
            r13 = 10
            goto L_0x002a
        L_0x0029:
            int r13 = r13 + r13
        L_0x002a:
            com.google.android.gms.internal.measurement.zzkm r12 = r12.zzd(r13)
            r11.putObject(r15, r9, r12)
        L_0x0031:
            r9 = 1
            r10 = 5
            r11 = 0
            r13 = 2
            switch(r25) {
                case 18: goto L_0x03a7;
                case 19: goto L_0x037b;
                case 20: goto L_0x0338;
                case 21: goto L_0x0338;
                case 22: goto L_0x031d;
                case 23: goto L_0x02dc;
                case 24: goto L_0x029b;
                case 25: goto L_0x0273;
                case 26: goto L_0x01be;
                case 27: goto L_0x01a3;
                case 28: goto L_0x0149;
                case 29: goto L_0x031d;
                case 30: goto L_0x0118;
                case 31: goto L_0x029b;
                case 32: goto L_0x02dc;
                case 33: goto L_0x00c9;
                case 34: goto L_0x007a;
                case 35: goto L_0x03a7;
                case 36: goto L_0x037b;
                case 37: goto L_0x0338;
                case 38: goto L_0x0338;
                case 39: goto L_0x031d;
                case 40: goto L_0x02dc;
                case 41: goto L_0x029b;
                case 42: goto L_0x0273;
                case 43: goto L_0x031d;
                case 44: goto L_0x0118;
                case 45: goto L_0x029b;
                case 46: goto L_0x02dc;
                case 47: goto L_0x00c9;
                case 48: goto L_0x007a;
                default: goto L_0x0038;
            }
        L_0x0038:
            r1 = 3
            if (r6 != r1) goto L_0x03c7
            com.google.android.gms.internal.measurement.w3 r1 = r14.m(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r20 = r1
            r21 = r16
            r22 = r17
            r23 = r18
            r24 = r6
            r25 = r28
            int r4 = com.google.android.gms.internal.measurement.j2.c(r20, r21, r22, r23, r24, r25)
            java.lang.Object r8 = r7.f7200c
            r12.add(r8)
        L_0x0058:
            if (r4 >= r5) goto L_0x0079
            int r8 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r9 = r7.f7198a
            if (r2 == r9) goto L_0x0063
            goto L_0x0079
        L_0x0063:
            r20 = r1
            r21 = r16
            r22 = r8
            r23 = r18
            r24 = r6
            r25 = r28
            int r4 = com.google.android.gms.internal.measurement.j2.c(r20, r21, r22, r23, r24, r25)
            java.lang.Object r8 = r7.f7200c
            r12.add(r8)
            goto L_0x0058
        L_0x0079:
            return r4
        L_0x007a:
            if (r6 != r13) goto L_0x009e
            com.google.android.gms.internal.measurement.f3 r12 = (com.google.android.gms.internal.measurement.f3) r12
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r2 = r7.f7198a
            int r2 = r2 + r1
        L_0x0085:
            if (r1 >= r2) goto L_0x0095
            int r1 = com.google.android.gms.internal.measurement.j2.m(r3, r1, r7)
            long r4 = r7.f7199b
            long r4 = com.google.android.gms.internal.measurement.zzji.zzc(r4)
            r12.c(r4)
            goto L_0x0085
        L_0x0095:
            if (r1 != r2) goto L_0x0099
            goto L_0x03c8
        L_0x0099:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r1
        L_0x009e:
            if (r6 != 0) goto L_0x03c7
            com.google.android.gms.internal.measurement.f3 r12 = (com.google.android.gms.internal.measurement.f3) r12
            int r1 = com.google.android.gms.internal.measurement.j2.m(r3, r4, r7)
            long r8 = r7.f7199b
            long r8 = com.google.android.gms.internal.measurement.zzji.zzc(r8)
            r12.c(r8)
        L_0x00af:
            if (r1 >= r5) goto L_0x00c8
            int r4 = com.google.android.gms.internal.measurement.j2.j(r3, r1, r7)
            int r6 = r7.f7198a
            if (r2 == r6) goto L_0x00ba
            goto L_0x00c8
        L_0x00ba:
            int r1 = com.google.android.gms.internal.measurement.j2.m(r3, r4, r7)
            long r8 = r7.f7199b
            long r8 = com.google.android.gms.internal.measurement.zzji.zzc(r8)
            r12.c(r8)
            goto L_0x00af
        L_0x00c8:
            return r1
        L_0x00c9:
            if (r6 != r13) goto L_0x00ed
            com.google.android.gms.internal.measurement.b3 r12 = (com.google.android.gms.internal.measurement.b3) r12
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r2 = r7.f7198a
            int r2 = r2 + r1
        L_0x00d4:
            if (r1 >= r2) goto L_0x00e4
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r1, r7)
            int r4 = r7.f7198a
            int r4 = com.google.android.gms.internal.measurement.zzji.zzb(r4)
            r12.d(r4)
            goto L_0x00d4
        L_0x00e4:
            if (r1 != r2) goto L_0x00e8
            goto L_0x03c8
        L_0x00e8:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r1
        L_0x00ed:
            if (r6 != 0) goto L_0x03c7
            com.google.android.gms.internal.measurement.b3 r12 = (com.google.android.gms.internal.measurement.b3) r12
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r4 = r7.f7198a
            int r4 = com.google.android.gms.internal.measurement.zzji.zzb(r4)
            r12.d(r4)
        L_0x00fe:
            if (r1 >= r5) goto L_0x0117
            int r4 = com.google.android.gms.internal.measurement.j2.j(r3, r1, r7)
            int r6 = r7.f7198a
            if (r2 == r6) goto L_0x0109
            goto L_0x0117
        L_0x0109:
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r4 = r7.f7198a
            int r4 = com.google.android.gms.internal.measurement.zzji.zzb(r4)
            r12.d(r4)
            goto L_0x00fe
        L_0x0117:
            return r1
        L_0x0118:
            if (r6 != r13) goto L_0x011f
            int r2 = com.google.android.gms.internal.measurement.j2.f(r3, r4, r12, r7)
            goto L_0x0130
        L_0x011f:
            if (r6 != 0) goto L_0x03c7
            r2 = r19
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r12
            r7 = r28
            int r2 = com.google.android.gms.internal.measurement.j2.l(r2, r3, r4, r5, r6, r7)
        L_0x0130:
            com.google.android.gms.internal.measurement.zzkj r3 = r14.l(r8)
            r4 = 0
            com.google.android.gms.internal.measurement.j4 r5 = r0.f7256l
            r21 = r15
            r22 = r20
            r23 = r12
            r24 = r3
            r25 = r4
            r26 = r5
            com.google.android.gms.internal.measurement.y3.c(r21, r22, r23, r24, r25, r26)
            r1 = r2
            goto L_0x03c8
        L_0x0149:
            if (r6 != r13) goto L_0x03c7
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r4 = r7.f7198a
            if (r4 < 0) goto L_0x019e
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0199
            if (r4 != 0) goto L_0x015f
            com.google.android.gms.internal.measurement.zzje r4 = com.google.android.gms.internal.measurement.zzje.zzb
            r12.add(r4)
            goto L_0x0167
        L_0x015f:
            com.google.android.gms.internal.measurement.zzje r6 = com.google.android.gms.internal.measurement.zzje.zzl(r3, r1, r4)
            r12.add(r6)
        L_0x0166:
            int r1 = r1 + r4
        L_0x0167:
            if (r1 >= r5) goto L_0x0198
            int r4 = com.google.android.gms.internal.measurement.j2.j(r3, r1, r7)
            int r6 = r7.f7198a
            if (r2 == r6) goto L_0x0172
            goto L_0x0198
        L_0x0172:
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r4 = r7.f7198a
            if (r4 < 0) goto L_0x0193
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x018e
            if (r4 != 0) goto L_0x0186
            com.google.android.gms.internal.measurement.zzje r4 = com.google.android.gms.internal.measurement.zzje.zzb
            r12.add(r4)
            goto L_0x0167
        L_0x0186:
            com.google.android.gms.internal.measurement.zzje r6 = com.google.android.gms.internal.measurement.zzje.zzl(r3, r1, r4)
            r12.add(r6)
            goto L_0x0166
        L_0x018e:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r1
        L_0x0193:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzd()
            throw r1
        L_0x0198:
            return r1
        L_0x0199:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r1
        L_0x019e:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzd()
            throw r1
        L_0x01a3:
            if (r6 == r13) goto L_0x01a7
            goto L_0x03c7
        L_0x01a7:
            com.google.android.gms.internal.measurement.w3 r1 = r14.m(r8)
            r20 = r1
            r21 = r19
            r22 = r16
            r23 = r17
            r24 = r18
            r25 = r12
            r26 = r28
            int r1 = com.google.android.gms.internal.measurement.j2.e(r20, r21, r22, r23, r24, r25, r26)
            return r1
        L_0x01be:
            if (r6 != r13) goto L_0x03c7
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r23 & r8
            r10 = 0
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x0213
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r4 = r7.f7198a
            if (r4 < 0) goto L_0x020e
            if (r4 != 0) goto L_0x01db
            r12.add(r6)
            goto L_0x01e6
        L_0x01db:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkn.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
        L_0x01e5:
            int r1 = r1 + r4
        L_0x01e6:
            if (r1 >= r5) goto L_0x03c8
            int r4 = com.google.android.gms.internal.measurement.j2.j(r3, r1, r7)
            int r8 = r7.f7198a
            if (r2 != r8) goto L_0x03c8
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r4 = r7.f7198a
            if (r4 < 0) goto L_0x0209
            if (r4 != 0) goto L_0x01fe
            r12.add(r6)
            goto L_0x01e6
        L_0x01fe:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkn.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
            goto L_0x01e5
        L_0x0209:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzd()
            throw r1
        L_0x020e:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzd()
            throw r1
        L_0x0213:
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r4 = r7.f7198a
            if (r4 < 0) goto L_0x026e
            if (r4 != 0) goto L_0x0221
            r12.add(r6)
            goto L_0x0234
        L_0x0221:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.w4.f(r3, r1, r8)
            if (r9 == 0) goto L_0x0269
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzkn.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
        L_0x0233:
            r1 = r8
        L_0x0234:
            if (r1 >= r5) goto L_0x03c8
            int r4 = com.google.android.gms.internal.measurement.j2.j(r3, r1, r7)
            int r8 = r7.f7198a
            if (r2 != r8) goto L_0x03c8
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r4 = r7.f7198a
            if (r4 < 0) goto L_0x0264
            if (r4 != 0) goto L_0x024c
            r12.add(r6)
            goto L_0x0234
        L_0x024c:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.w4.f(r3, r1, r8)
            if (r9 == 0) goto L_0x025f
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzkn.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
            goto L_0x0233
        L_0x025f:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzc()
            throw r1
        L_0x0264:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzd()
            throw r1
        L_0x0269:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzc()
            throw r1
        L_0x026e:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzd()
            throw r1
        L_0x0273:
            if (r6 != r13) goto L_0x028e
            c.d.a(r12)
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r2 = r7.f7198a
            int r2 = r2 + r1
            if (r1 < r2) goto L_0x028a
            if (r1 != r2) goto L_0x0285
            goto L_0x03c8
        L_0x0285:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r1
        L_0x028a:
            com.google.android.gms.internal.measurement.j2.m(r3, r1, r7)
            throw r11
        L_0x028e:
            if (r6 == 0) goto L_0x0292
            goto L_0x03c7
        L_0x0292:
            c.d.a(r12)
            com.google.android.gms.internal.measurement.j2.m(r3, r4, r7)
            long r1 = r7.f7199b
            throw r11
        L_0x029b:
            if (r6 != r13) goto L_0x02bb
            com.google.android.gms.internal.measurement.b3 r12 = (com.google.android.gms.internal.measurement.b3) r12
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r2 = r7.f7198a
            int r2 = r2 + r1
        L_0x02a6:
            if (r1 >= r2) goto L_0x02b2
            int r4 = com.google.android.gms.internal.measurement.j2.b(r3, r1)
            r12.d(r4)
            int r1 = r1 + 4
            goto L_0x02a6
        L_0x02b2:
            if (r1 != r2) goto L_0x02b6
            goto L_0x03c8
        L_0x02b6:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r1
        L_0x02bb:
            if (r6 != r10) goto L_0x03c7
            com.google.android.gms.internal.measurement.b3 r12 = (com.google.android.gms.internal.measurement.b3) r12
            int r1 = com.google.android.gms.internal.measurement.j2.b(r16, r17)
            r12.d(r1)
        L_0x02c6:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02db
            int r4 = com.google.android.gms.internal.measurement.j2.j(r3, r1, r7)
            int r6 = r7.f7198a
            if (r2 == r6) goto L_0x02d3
            goto L_0x02db
        L_0x02d3:
            int r1 = com.google.android.gms.internal.measurement.j2.b(r3, r4)
            r12.d(r1)
            goto L_0x02c6
        L_0x02db:
            return r1
        L_0x02dc:
            if (r6 != r13) goto L_0x02fc
            com.google.android.gms.internal.measurement.f3 r12 = (com.google.android.gms.internal.measurement.f3) r12
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r2 = r7.f7198a
            int r2 = r2 + r1
        L_0x02e7:
            if (r1 >= r2) goto L_0x02f3
            long r4 = com.google.android.gms.internal.measurement.j2.p(r3, r1)
            r12.c(r4)
            int r1 = r1 + 8
            goto L_0x02e7
        L_0x02f3:
            if (r1 != r2) goto L_0x02f7
            goto L_0x03c8
        L_0x02f7:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r1
        L_0x02fc:
            if (r6 != r9) goto L_0x03c7
            com.google.android.gms.internal.measurement.f3 r12 = (com.google.android.gms.internal.measurement.f3) r12
            long r8 = com.google.android.gms.internal.measurement.j2.p(r16, r17)
            r12.c(r8)
        L_0x0307:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x031c
            int r4 = com.google.android.gms.internal.measurement.j2.j(r3, r1, r7)
            int r6 = r7.f7198a
            if (r2 == r6) goto L_0x0314
            goto L_0x031c
        L_0x0314:
            long r8 = com.google.android.gms.internal.measurement.j2.p(r3, r4)
            r12.c(r8)
            goto L_0x0307
        L_0x031c:
            return r1
        L_0x031d:
            if (r6 != r13) goto L_0x0325
            int r1 = com.google.android.gms.internal.measurement.j2.f(r3, r4, r12, r7)
            goto L_0x03c8
        L_0x0325:
            if (r6 == 0) goto L_0x0329
            goto L_0x03c7
        L_0x0329:
            r20 = r16
            r21 = r17
            r22 = r18
            r23 = r12
            r24 = r28
            int r1 = com.google.android.gms.internal.measurement.j2.l(r19, r20, r21, r22, r23, r24)
            return r1
        L_0x0338:
            if (r6 != r13) goto L_0x0358
            com.google.android.gms.internal.measurement.f3 r12 = (com.google.android.gms.internal.measurement.f3) r12
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r2 = r7.f7198a
            int r2 = r2 + r1
        L_0x0343:
            if (r1 >= r2) goto L_0x034f
            int r1 = com.google.android.gms.internal.measurement.j2.m(r3, r1, r7)
            long r4 = r7.f7199b
            r12.c(r4)
            goto L_0x0343
        L_0x034f:
            if (r1 != r2) goto L_0x0353
            goto L_0x03c8
        L_0x0353:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r1
        L_0x0358:
            if (r6 != 0) goto L_0x03c7
            com.google.android.gms.internal.measurement.f3 r12 = (com.google.android.gms.internal.measurement.f3) r12
            int r1 = com.google.android.gms.internal.measurement.j2.m(r3, r4, r7)
            long r8 = r7.f7199b
            r12.c(r8)
        L_0x0365:
            if (r1 >= r5) goto L_0x037a
            int r4 = com.google.android.gms.internal.measurement.j2.j(r3, r1, r7)
            int r6 = r7.f7198a
            if (r2 == r6) goto L_0x0370
            goto L_0x037a
        L_0x0370:
            int r1 = com.google.android.gms.internal.measurement.j2.m(r3, r4, r7)
            long r8 = r7.f7199b
            r12.c(r8)
            goto L_0x0365
        L_0x037a:
            return r1
        L_0x037b:
            if (r6 != r13) goto L_0x0399
            c.d.a(r12)
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r2 = r7.f7198a
            int r2 = r2 + r1
            if (r1 < r2) goto L_0x0391
            if (r1 != r2) goto L_0x038c
            goto L_0x03c8
        L_0x038c:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r1
        L_0x0391:
            int r1 = com.google.android.gms.internal.measurement.j2.b(r3, r1)
            java.lang.Float.intBitsToFloat(r1)
            throw r11
        L_0x0399:
            if (r6 == r10) goto L_0x039c
            goto L_0x03c7
        L_0x039c:
            c.d.a(r12)
            int r1 = com.google.android.gms.internal.measurement.j2.b(r16, r17)
            java.lang.Float.intBitsToFloat(r1)
            throw r11
        L_0x03a7:
            if (r6 != r13) goto L_0x03c5
            c.d.a(r12)
            int r1 = com.google.android.gms.internal.measurement.j2.j(r3, r4, r7)
            int r2 = r7.f7198a
            int r2 = r2 + r1
            if (r1 < r2) goto L_0x03bd
            if (r1 != r2) goto L_0x03b8
            goto L_0x03c8
        L_0x03b8:
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r1
        L_0x03bd:
            long r1 = com.google.android.gms.internal.measurement.j2.p(r3, r1)
            java.lang.Double.longBitsToDouble(r1)
            throw r11
        L_0x03c5:
            if (r6 == r9) goto L_0x03c9
        L_0x03c7:
            r1 = r4
        L_0x03c8:
            return r1
        L_0x03c9:
            c.d.a(r12)
            long r1 = com.google.android.gms.internal.measurement.j2.p(r16, r17)
            java.lang.Double.longBitsToDouble(r1)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.o3.U(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.i2):int");
    }

    private final int V(int i10) {
        if (i10 < this.f7247c || i10 > this.f7248d) {
            return -1;
        }
        return Y(i10, 0);
    }

    private final int W(int i10, int i11) {
        if (i10 < this.f7247c || i10 > this.f7248d) {
            return -1;
        }
        return Y(i10, i11);
    }

    private final int X(int i10) {
        return this.f7245a[i10 + 2];
    }

    private final int Y(int i10, int i11) {
        int length = (this.f7245a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = this.f7245a[i13];
            if (i10 == i14) {
                return i13;
            }
            if (i10 < i14) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    private static int i(int i10) {
        return (i10 >>> 20) & 255;
    }

    private final int j(int i10) {
        return this.f7245a[i10 + 1];
    }

    private static long k(Object obj, long j10) {
        return ((Long) r4.k(obj, j10)).longValue();
    }

    private final zzkj l(int i10) {
        int i11 = i10 / 3;
        return (zzkj) this.f7246b[i11 + i11 + 1];
    }

    private final w3 m(int i10) {
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        w3 w3Var = (w3) this.f7246b[i12];
        if (w3Var != null) {
            return w3Var;
        }
        w3 b10 = t3.a().b((Class) this.f7246b[i12 + 1]);
        this.f7246b[i12] = b10;
        return b10;
    }

    private final Object n(int i10) {
        int i11 = i10 / 3;
        return this.f7246b[i11 + i11];
    }

    private final Object o(Object obj, int i10) {
        w3 m10 = m(i10);
        long j10 = (long) (j(i10) & 1048575);
        if (!B(obj, i10)) {
            return m10.zze();
        }
        Object object = f7244q.getObject(obj, j10);
        if (E(object)) {
            return object;
        }
        Object zze = m10.zze();
        if (object != null) {
            m10.e(zze, object);
        }
        return zze;
    }

    private final Object p(Object obj, int i10, int i11) {
        w3 m10 = m(i11);
        if (!F(obj, i10, i11)) {
            return m10.zze();
        }
        Object object = f7244q.getObject(obj, (long) (j(i11) & 1048575));
        if (E(object)) {
            return object;
        }
        Object zze = m10.zze();
        if (object != null) {
            m10.e(zze, object);
        }
        return zze;
    }

    private static Field q(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void r(Object obj) {
        if (!E(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void s(Object obj, Object obj2, int i10) {
        if (B(obj2, i10)) {
            long j10 = (long) (j(i10) & 1048575);
            Unsafe unsafe = f7244q;
            Object object = unsafe.getObject(obj2, j10);
            if (object != null) {
                w3 m10 = m(i10);
                if (!B(obj, i10)) {
                    if (!E(object)) {
                        unsafe.putObject(obj, j10, object);
                    } else {
                        Object zze = m10.zze();
                        m10.e(zze, object);
                        unsafe.putObject(obj, j10, zze);
                    }
                    u(obj, i10);
                    return;
                }
                Object object2 = unsafe.getObject(obj, j10);
                if (!E(object2)) {
                    Object zze2 = m10.zze();
                    m10.e(zze2, object2);
                    unsafe.putObject(obj, j10, zze2);
                    object2 = zze2;
                }
                m10.e(object2, object);
                return;
            }
            int i11 = this.f7245a[i10];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i11 + " is present but null: " + obj3);
        }
    }

    private final void t(Object obj, Object obj2, int i10) {
        int i11 = this.f7245a[i10];
        if (F(obj2, i11, i10)) {
            long j10 = (long) (j(i10) & 1048575);
            Unsafe unsafe = f7244q;
            Object object = unsafe.getObject(obj2, j10);
            if (object != null) {
                w3 m10 = m(i10);
                if (!F(obj, i11, i10)) {
                    if (!E(object)) {
                        unsafe.putObject(obj, j10, object);
                    } else {
                        Object zze = m10.zze();
                        m10.e(zze, object);
                        unsafe.putObject(obj, j10, zze);
                    }
                    v(obj, i11, i10);
                    return;
                }
                Object object2 = unsafe.getObject(obj, j10);
                if (!E(object2)) {
                    Object zze2 = m10.zze();
                    m10.e(zze2, object2);
                    unsafe.putObject(obj, j10, zze2);
                    object2 = zze2;
                }
                m10.e(object2, object);
                return;
            }
            int i12 = this.f7245a[i10];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i12 + " is present but null: " + obj3);
        }
    }

    private final void u(Object obj, int i10) {
        int X = X(i10);
        long j10 = (long) (1048575 & X);
        if (j10 != 1048575) {
            r4.v(obj, j10, (1 << (X >>> 20)) | r4.h(obj, j10));
        }
    }

    private final void v(Object obj, int i10, int i11) {
        r4.v(obj, (long) (X(i11) & 1048575), i10);
    }

    private final void w(Object obj, int i10, Object obj2) {
        f7244q.putObject(obj, (long) (j(i10) & 1048575), obj2);
        u(obj, i10);
    }

    private final void x(Object obj, int i10, int i11, Object obj2) {
        f7244q.putObject(obj, (long) (j(i11) & 1048575), obj2);
        v(obj, i10, i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:156:0x044c, code lost:
        r7 = r7 + 3;
        r5 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0250, code lost:
        r13 = r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void y(java.lang.Object r17, com.google.android.gms.internal.measurement.x4 r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r0.f7250f
            if (r3 != 0) goto L_0x045d
            int[] r3 = r0.f7245a
            int r3 = r3.length
            sun.misc.Unsafe r4 = f7244q
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r5
            r7 = 0
            r8 = 0
        L_0x0015:
            if (r7 >= r3) goto L_0x0453
            int r10 = r0.j(r7)
            int[] r11 = r0.f7245a
            r12 = r11[r7]
            int r13 = i(r10)
            r14 = 17
            r15 = 1
            if (r13 > r14) goto L_0x003b
            int r14 = r7 + 2
            r11 = r11[r14]
            r14 = r11 & r5
            if (r14 == r9) goto L_0x0036
            long r8 = (long) r14
            int r8 = r4.getInt(r1, r8)
            r9 = r14
        L_0x0036:
            int r11 = r11 >>> 20
            int r11 = r15 << r11
            goto L_0x003c
        L_0x003b:
            r11 = 0
        L_0x003c:
            r10 = r10 & r5
            long r5 = (long) r10
            switch(r13) {
                case 0: goto L_0x0440;
                case 1: goto L_0x0433;
                case 2: goto L_0x0426;
                case 3: goto L_0x0419;
                case 4: goto L_0x040c;
                case 5: goto L_0x03ff;
                case 6: goto L_0x03f2;
                case 7: goto L_0x03e5;
                case 8: goto L_0x03d7;
                case 9: goto L_0x03c5;
                case 10: goto L_0x03b5;
                case 11: goto L_0x03a7;
                case 12: goto L_0x0399;
                case 13: goto L_0x038b;
                case 14: goto L_0x037d;
                case 15: goto L_0x036f;
                case 16: goto L_0x0361;
                case 17: goto L_0x034f;
                case 18: goto L_0x033f;
                case 19: goto L_0x032f;
                case 20: goto L_0x031f;
                case 21: goto L_0x030f;
                case 22: goto L_0x02ff;
                case 23: goto L_0x02ef;
                case 24: goto L_0x02df;
                case 25: goto L_0x02cf;
                case 26: goto L_0x02c0;
                case 27: goto L_0x02ad;
                case 28: goto L_0x029e;
                case 29: goto L_0x028f;
                case 30: goto L_0x0280;
                case 31: goto L_0x0271;
                case 32: goto L_0x0262;
                case 33: goto L_0x0253;
                case 34: goto L_0x0242;
                case 35: goto L_0x0233;
                case 36: goto L_0x0224;
                case 37: goto L_0x0215;
                case 38: goto L_0x0206;
                case 39: goto L_0x01f7;
                case 40: goto L_0x01e8;
                case 41: goto L_0x01d9;
                case 42: goto L_0x01ca;
                case 43: goto L_0x01bb;
                case 44: goto L_0x01ac;
                case 45: goto L_0x019d;
                case 46: goto L_0x018e;
                case 47: goto L_0x017f;
                case 48: goto L_0x0170;
                case 49: goto L_0x015d;
                case 50: goto L_0x0154;
                case 51: goto L_0x0145;
                case 52: goto L_0x0136;
                case 53: goto L_0x0127;
                case 54: goto L_0x0118;
                case 55: goto L_0x0109;
                case 56: goto L_0x00fa;
                case 57: goto L_0x00eb;
                case 58: goto L_0x00dc;
                case 59: goto L_0x00cd;
                case 60: goto L_0x00ba;
                case 61: goto L_0x00aa;
                case 62: goto L_0x009c;
                case 63: goto L_0x008e;
                case 64: goto L_0x0080;
                case 65: goto L_0x0072;
                case 66: goto L_0x0064;
                case 67: goto L_0x0056;
                case 68: goto L_0x0044;
                default: goto L_0x0041;
            }
        L_0x0041:
            r13 = 0
            goto L_0x044c
        L_0x0044:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.w3 r6 = r0.m(r7)
            r2.l(r12, r5, r6)
            goto L_0x0041
        L_0x0056:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = k(r1, r5)
            r2.I(r12, r5)
            goto L_0x0041
        L_0x0064:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = Q(r1, r5)
            r2.f(r12, r5)
            goto L_0x0041
        L_0x0072:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = k(r1, r5)
            r2.j(r12, r5)
            goto L_0x0041
        L_0x0080:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = Q(r1, r5)
            r2.v(r12, r5)
            goto L_0x0041
        L_0x008e:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = Q(r1, r5)
            r2.p(r12, r5)
            goto L_0x0041
        L_0x009c:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = Q(r1, r5)
            r2.a(r12, r5)
            goto L_0x0041
        L_0x00aa:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzje r5 = (com.google.android.gms.internal.measurement.zzje) r5
            r2.n(r12, r5)
            goto L_0x0041
        L_0x00ba:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.w3 r6 = r0.m(r7)
            r2.H(r12, r5, r6)
            goto L_0x0041
        L_0x00cd:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            H(r12, r5, r2)
            goto L_0x0041
        L_0x00dc:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            boolean r5 = G(r1, r5)
            r2.e(r12, r5)
            goto L_0x0041
        L_0x00eb:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = Q(r1, r5)
            r2.d(r12, r5)
            goto L_0x0041
        L_0x00fa:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = k(r1, r5)
            r2.F(r12, r5)
            goto L_0x0041
        L_0x0109:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = Q(r1, r5)
            r2.r(r12, r5)
            goto L_0x0041
        L_0x0118:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = k(r1, r5)
            r2.C(r12, r5)
            goto L_0x0041
        L_0x0127:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = k(r1, r5)
            r2.h(r12, r5)
            goto L_0x0041
        L_0x0136:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            float r5 = N(r1, r5)
            r2.w(r12, r5)
            goto L_0x0041
        L_0x0145:
            boolean r10 = r0.F(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            double r5 = M(r1, r5)
            r2.t(r12, r5)
            goto L_0x0041
        L_0x0154:
            java.lang.Object r5 = r4.getObject(r1, r5)
            r0.z(r2, r12, r5, r7)
            goto L_0x0041
        L_0x015d:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.w3 r6 = r0.m(r7)
            com.google.android.gms.internal.measurement.y3.o(r10, r5, r2, r6)
            goto L_0x0041
        L_0x0170:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.v(r10, r5, r2, r15)
            goto L_0x0041
        L_0x017f:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.u(r10, r5, r2, r15)
            goto L_0x0041
        L_0x018e:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.t(r10, r5, r2, r15)
            goto L_0x0041
        L_0x019d:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.s(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01ac:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.k(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01bb:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.x(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01ca:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.h(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01d9:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.l(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01e8:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.m(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01f7:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.p(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0206:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.y(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0215:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.q(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0224:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.n(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0233:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.j(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0242:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r11 = 0
            com.google.android.gms.internal.measurement.y3.v(r10, r5, r2, r11)
        L_0x0250:
            r13 = r11
            goto L_0x044c
        L_0x0253:
            r11 = 0
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.u(r10, r5, r2, r11)
            goto L_0x0250
        L_0x0262:
            r11 = 0
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.t(r10, r5, r2, r11)
            goto L_0x0250
        L_0x0271:
            r11 = 0
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.s(r10, r5, r2, r11)
            goto L_0x0250
        L_0x0280:
            r11 = 0
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.k(r10, r5, r2, r11)
            goto L_0x0250
        L_0x028f:
            r11 = 0
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.x(r10, r5, r2, r11)
            goto L_0x0250
        L_0x029e:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.i(r10, r5, r2)
            goto L_0x0041
        L_0x02ad:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.w3 r6 = r0.m(r7)
            com.google.android.gms.internal.measurement.y3.r(r10, r5, r2, r6)
            goto L_0x0041
        L_0x02c0:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.w(r10, r5, r2)
            goto L_0x0041
        L_0x02cf:
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r13 = 0
            com.google.android.gms.internal.measurement.y3.h(r10, r5, r2, r13)
            goto L_0x044c
        L_0x02df:
            r13 = 0
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.l(r10, r5, r2, r13)
            goto L_0x044c
        L_0x02ef:
            r13 = 0
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.m(r10, r5, r2, r13)
            goto L_0x044c
        L_0x02ff:
            r13 = 0
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.p(r10, r5, r2, r13)
            goto L_0x044c
        L_0x030f:
            r13 = 0
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.y(r10, r5, r2, r13)
            goto L_0x044c
        L_0x031f:
            r13 = 0
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.q(r10, r5, r2, r13)
            goto L_0x044c
        L_0x032f:
            r13 = 0
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.n(r10, r5, r2, r13)
            goto L_0x044c
        L_0x033f:
            r13 = 0
            int[] r10 = r0.f7245a
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.y3.j(r10, r5, r2, r13)
            goto L_0x044c
        L_0x034f:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.w3 r6 = r0.m(r7)
            r2.l(r12, r5, r6)
            goto L_0x044c
        L_0x0361:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.I(r12, r5)
            goto L_0x044c
        L_0x036f:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.f(r12, r5)
            goto L_0x044c
        L_0x037d:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.j(r12, r5)
            goto L_0x044c
        L_0x038b:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.v(r12, r5)
            goto L_0x044c
        L_0x0399:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.p(r12, r5)
            goto L_0x044c
        L_0x03a7:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.a(r12, r5)
            goto L_0x044c
        L_0x03b5:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzje r5 = (com.google.android.gms.internal.measurement.zzje) r5
            r2.n(r12, r5)
            goto L_0x044c
        L_0x03c5:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.w3 r6 = r0.m(r7)
            r2.H(r12, r5, r6)
            goto L_0x044c
        L_0x03d7:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            H(r12, r5, r2)
            goto L_0x044c
        L_0x03e5:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            boolean r5 = com.google.android.gms.internal.measurement.r4.B(r1, r5)
            r2.e(r12, r5)
            goto L_0x044c
        L_0x03f2:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.d(r12, r5)
            goto L_0x044c
        L_0x03ff:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.F(r12, r5)
            goto L_0x044c
        L_0x040c:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.r(r12, r5)
            goto L_0x044c
        L_0x0419:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.C(r12, r5)
            goto L_0x044c
        L_0x0426:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.h(r12, r5)
            goto L_0x044c
        L_0x0433:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            float r5 = com.google.android.gms.internal.measurement.r4.g(r1, r5)
            r2.w(r12, r5)
            goto L_0x044c
        L_0x0440:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            double r5 = com.google.android.gms.internal.measurement.r4.f(r1, r5)
            r2.t(r12, r5)
        L_0x044c:
            int r7 = r7 + 3
            r5 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0015
        L_0x0453:
            com.google.android.gms.internal.measurement.j4 r3 = r0.f7256l
            java.lang.Object r1 = r3.d(r1)
            r3.i(r1, r2)
            return
        L_0x045d:
            com.google.android.gms.internal.measurement.v2 r2 = r0.f7257m
            r2.a(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.o3.y(java.lang.Object, com.google.android.gms.internal.measurement.x4):void");
    }

    private final void z(x4 x4Var, int i10, Object obj, int i11) {
        if (obj != null) {
            zzlf zzlf = (zzlf) n(i11);
            throw null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x036b, code lost:
        if (r0 != r15) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0387, code lost:
        r7 = r36;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x03af, code lost:
        if (r0 != r15) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x03d2, code lost:
        if (r0 != r15) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cf, code lost:
        r11 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0109, code lost:
        r1 = r7;
        r2 = r11;
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x010c, code lost:
        r6 = r25;
        r13 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0114, code lost:
        r21 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0136, code lost:
        r5 = r24 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01de, code lost:
        r2 = r11;
        r3 = r13;
        r6 = r25;
        r13 = r35;
        r11 = r36;
        r29 = r5;
        r5 = r24 | r22;
        r1 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01ef, code lost:
        r21 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0250, code lost:
        r0 = r6 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0252, code lost:
        r5 = r24 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0254, code lost:
        r2 = r11;
        r3 = r13;
        r1 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02ca, code lost:
        r7 = r36;
        r2 = r6;
        r28 = r10;
        r34 = r11;
        r18 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int I(java.lang.Object r32, byte[] r33, int r34, int r35, int r36, com.google.android.gms.internal.measurement.i2 r37) {
        /*
            r31 = this;
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            r9 = r37
            r(r32)
            sun.misc.Unsafe r10 = f7244q
            r16 = 0
            r0 = r34
            r1 = r16
            r3 = r1
            r5 = r3
            r2 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001d:
            r17 = 0
            if (r0 >= r13) goto L_0x0442
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0030
            int r0 = com.google.android.gms.internal.measurement.j2.k(r0, r12, r1, r9)
            int r1 = r9.f7198a
            r4 = r1
            r1 = r0
            goto L_0x0031
        L_0x0030:
            r4 = r0
        L_0x0031:
            int r0 = r4 >>> 3
            r8 = r4 & 7
            r7 = 3
            if (r0 <= r2) goto L_0x0040
            int r3 = r3 / r7
            int r2 = r15.W(r0, r3)
        L_0x003d:
            r3 = r2
            r2 = -1
            goto L_0x0045
        L_0x0040:
            int r2 = r15.V(r0)
            goto L_0x003d
        L_0x0045:
            if (r3 != r2) goto L_0x0056
            r34 = r0
            r19 = r2
            r8 = r4
            r24 = r5
            r28 = r10
            r7 = r11
            r18 = r16
            r2 = r1
            goto L_0x03d5
        L_0x0056:
            int[] r2 = r15.f7245a
            int r20 = r3 + 1
            r7 = r2[r20]
            int r11 = i(r7)
            r20 = r1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r7 & r18
            long r12 = (long) r1
            r1 = 17
            r21 = r4
            if (r11 > r1) goto L_0x02d9
            int r1 = r3 + 2
            r1 = r2[r1]
            int r2 = r1 >>> 20
            r4 = 1
            int r22 = r4 << r2
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r2
            if (r1 == r6) goto L_0x008f
            r18 = r3
            if (r6 == r2) goto L_0x0085
            long r2 = (long) r6
            r10.putInt(r14, r2, r5)
        L_0x0085:
            long r2 = (long) r1
            int r2 = r10.getInt(r14, r2)
            r25 = r1
            r24 = r2
            goto L_0x0095
        L_0x008f:
            r18 = r3
            r24 = r5
            r25 = r6
        L_0x0095:
            r1 = 5
            switch(r11) {
                case 0: goto L_0x02af;
                case 1: goto L_0x0292;
                case 2: goto L_0x0273;
                case 3: goto L_0x0273;
                case 4: goto L_0x025a;
                case 5: goto L_0x0232;
                case 6: goto L_0x0217;
                case 7: goto L_0x01f3;
                case 8: goto L_0x01b9;
                case 9: goto L_0x018f;
                case 10: goto L_0x0173;
                case 11: goto L_0x025a;
                case 12: goto L_0x0139;
                case 13: goto L_0x0217;
                case 14: goto L_0x0232;
                case 15: goto L_0x0118;
                case 16: goto L_0x00e2;
                default: goto L_0x0099;
            }
        L_0x0099:
            r2 = 3
            if (r8 != r2) goto L_0x00d3
            r3 = r18
            java.lang.Object r7 = r15.o(r14, r3)
            com.google.android.gms.internal.measurement.w3 r1 = r15.m(r3)
            int r2 = r0 << 3
            r5 = r2 | 4
            r11 = r0
            r0 = r7
            r6 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r2 = r33
            r8 = r3
            r3 = r6
            r12 = r21
            r4 = r35
            r6 = r37
            int r0 = com.google.android.gms.internal.measurement.j2.n(r0, r1, r2, r3, r4, r5, r6)
            r15.w(r14, r8, r7)
            r5 = r24 | r22
            r13 = r35
            r3 = r8
            r2 = r11
            r1 = r12
            r6 = r25
            r12 = r33
        L_0x00cf:
            r11 = r36
            goto L_0x001d
        L_0x00d3:
            r11 = r0
            r8 = r18
            r6 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            r13 = r8
            goto L_0x02ca
        L_0x00e2:
            r11 = r0
            r4 = r18
            r6 = r20
            r7 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            if (r8 != 0) goto L_0x0111
            r2 = r12
            r12 = r33
            int r6 = com.google.android.gms.internal.measurement.j2.m(r12, r6, r9)
            long r0 = r9.f7199b
            long r20 = com.google.android.gms.internal.measurement.zzji.zzc(r0)
            r0 = r10
            r1 = r32
            r13 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
            r5 = r24 | r22
            r0 = r6
        L_0x0109:
            r1 = r7
            r2 = r11
            r3 = r13
        L_0x010c:
            r6 = r25
            r13 = r35
            goto L_0x00cf
        L_0x0111:
            r12 = r33
            r13 = r4
        L_0x0114:
            r21 = r7
            goto L_0x02ca
        L_0x0118:
            r11 = r0
            r2 = r12
            r13 = r18
            r6 = r20
            r7 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            if (r8 != 0) goto L_0x0114
            int r0 = com.google.android.gms.internal.measurement.j2.j(r12, r6, r9)
            int r1 = r9.f7198a
            int r1 = com.google.android.gms.internal.measurement.zzji.zzb(r1)
            r10.putInt(r14, r2, r1)
        L_0x0136:
            r5 = r24 | r22
            goto L_0x0109
        L_0x0139:
            r11 = r0
            r2 = r12
            r13 = r18
            r6 = r20
            r7 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            if (r8 != 0) goto L_0x0114
            int r0 = com.google.android.gms.internal.measurement.j2.j(r12, r6, r9)
            int r1 = r9.f7198a
            com.google.android.gms.internal.measurement.zzkj r4 = r15.l(r13)
            if (r4 == 0) goto L_0x016f
            boolean r4 = r4.zza(r1)
            if (r4 == 0) goto L_0x015d
            goto L_0x016f
        L_0x015d:
            com.google.android.gms.internal.measurement.zzmp r2 = J(r32)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzj(r7, r1)
            r1 = r7
            r2 = r11
            r3 = r13
            r5 = r24
            goto L_0x010c
        L_0x016f:
            r10.putInt(r14, r2, r1)
            goto L_0x0136
        L_0x0173:
            r11 = r0
            r2 = r12
            r13 = r18
            r6 = r20
            r7 = r21
            r0 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            if (r8 != r0) goto L_0x0114
            int r0 = com.google.android.gms.internal.measurement.j2.a(r12, r6, r9)
            java.lang.Object r1 = r9.f7200c
            r10.putObject(r14, r2, r1)
            goto L_0x0136
        L_0x018f:
            r12 = r33
            r11 = r0
            r13 = r18
            r6 = r20
            r7 = r21
            r0 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            if (r8 != r0) goto L_0x0114
            java.lang.Object r8 = r15.o(r14, r13)
            com.google.android.gms.internal.measurement.w3 r1 = r15.m(r13)
            r0 = r8
            r2 = r33
            r3 = r6
            r4 = r35
            r5 = r37
            int r0 = com.google.android.gms.internal.measurement.j2.o(r0, r1, r2, r3, r4, r5)
            r15.w(r14, r13, r8)
            goto L_0x0136
        L_0x01b9:
            r11 = r0
            r2 = r12
            r13 = r18
            r6 = r20
            r5 = r21
            r0 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            if (r8 != r0) goto L_0x01ef
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r7
            if (r0 != 0) goto L_0x01d5
            int r0 = com.google.android.gms.internal.measurement.j2.g(r12, r6, r9)
            goto L_0x01d9
        L_0x01d5:
            int r0 = com.google.android.gms.internal.measurement.j2.h(r12, r6, r9)
        L_0x01d9:
            java.lang.Object r1 = r9.f7200c
            r10.putObject(r14, r2, r1)
        L_0x01de:
            r1 = r24 | r22
            r2 = r11
            r3 = r13
            r6 = r25
            r13 = r35
            r11 = r36
            r29 = r5
            r5 = r1
            r1 = r29
            goto L_0x001d
        L_0x01ef:
            r21 = r5
            goto L_0x02ca
        L_0x01f3:
            r11 = r0
            r2 = r12
            r13 = r18
            r6 = r20
            r5 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            if (r8 != 0) goto L_0x01ef
            int r0 = com.google.android.gms.internal.measurement.j2.m(r12, r6, r9)
            long r6 = r9.f7199b
            r20 = 0
            int r1 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1))
            if (r1 == 0) goto L_0x0211
            goto L_0x0213
        L_0x0211:
            r4 = r16
        L_0x0213:
            com.google.android.gms.internal.measurement.r4.r(r14, r2, r4)
            goto L_0x01de
        L_0x0217:
            r11 = r0
            r2 = r12
            r13 = r18
            r6 = r20
            r5 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            if (r8 != r1) goto L_0x01ef
            int r0 = com.google.android.gms.internal.measurement.j2.b(r12, r6)
            r10.putInt(r14, r2, r0)
            int r0 = r6 + 4
            goto L_0x01de
        L_0x0232:
            r11 = r0
            r2 = r12
            r13 = r18
            r6 = r20
            r5 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            if (r8 != r4) goto L_0x01ef
            long r7 = com.google.android.gms.internal.measurement.j2.p(r12, r6)
            r0 = r10
            r1 = r32
            r21 = r5
            r4 = r7
            r0.putLong(r1, r2, r4)
        L_0x0250:
            int r0 = r6 + 8
        L_0x0252:
            r5 = r24 | r22
        L_0x0254:
            r2 = r11
            r3 = r13
            r1 = r21
            goto L_0x010c
        L_0x025a:
            r11 = r0
            r2 = r12
            r13 = r18
            r6 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            if (r8 != 0) goto L_0x02ca
            int r0 = com.google.android.gms.internal.measurement.j2.j(r12, r6, r9)
            int r1 = r9.f7198a
            r10.putInt(r14, r2, r1)
            goto L_0x0252
        L_0x0273:
            r11 = r0
            r2 = r12
            r13 = r18
            r6 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            if (r8 != 0) goto L_0x02ca
            int r6 = com.google.android.gms.internal.measurement.j2.m(r12, r6, r9)
            long r4 = r9.f7199b
            r0 = r10
            r1 = r32
            r0.putLong(r1, r2, r4)
            r5 = r24 | r22
            r0 = r6
            goto L_0x0254
        L_0x0292:
            r11 = r0
            r2 = r12
            r13 = r18
            r6 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            if (r8 != r1) goto L_0x02ca
            int r0 = com.google.android.gms.internal.measurement.j2.b(r12, r6)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.r4.u(r14, r2, r0)
            int r0 = r6 + 4
            goto L_0x0252
        L_0x02af:
            r11 = r0
            r2 = r12
            r13 = r18
            r6 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            if (r8 != r4) goto L_0x02ca
            long r0 = com.google.android.gms.internal.measurement.j2.p(r12, r6)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.r4.t(r14, r2, r0)
            goto L_0x0250
        L_0x02ca:
            r7 = r36
            r2 = r6
            r28 = r10
            r34 = r11
            r18 = r13
        L_0x02d3:
            r8 = r21
            r6 = r25
            goto L_0x03d5
        L_0x02d9:
            r1 = r0
            r4 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r29 = r12
            r12 = r33
            r13 = r3
            r2 = r29
            r0 = 27
            if (r11 != r0) goto L_0x033d
            r0 = 2
            if (r8 != r0) goto L_0x0330
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.measurement.zzkm r0 = (com.google.android.gms.internal.measurement.zzkm) r0
            boolean r7 = r0.zzc()
            if (r7 != 0) goto L_0x030c
            int r7 = r0.size()
            if (r7 != 0) goto L_0x0304
            r7 = 10
            goto L_0x0305
        L_0x0304:
            int r7 = r7 + r7
        L_0x0305:
            com.google.android.gms.internal.measurement.zzkm r0 = r0.zzd(r7)
            r10.putObject(r14, r2, r0)
        L_0x030c:
            r7 = r0
            com.google.android.gms.internal.measurement.w3 r0 = r15.m(r13)
            r8 = r1
            r1 = r21
            r2 = r33
            r3 = r4
            r4 = r35
            r24 = r5
            r5 = r7
            r25 = r6
            r6 = r37
            int r0 = com.google.android.gms.internal.measurement.j2.e(r0, r1, r2, r3, r4, r5, r6)
            r11 = r36
            r2 = r8
            r3 = r13
            r5 = r24
            r6 = r25
            r13 = r35
            goto L_0x001d
        L_0x0330:
            r24 = r5
            r25 = r6
            r34 = r1
            r15 = r4
            r28 = r10
            r18 = r13
            goto L_0x03b2
        L_0x033d:
            r24 = r5
            r25 = r6
            r5 = r1
            r0 = 49
            if (r11 > r0) goto L_0x038c
            long r6 = (long) r7
            r0 = r31
            r1 = r32
            r22 = r2
            r2 = r33
            r3 = r4
            r15 = r4
            r4 = r35
            r34 = r5
            r5 = r21
            r26 = r6
            r6 = r34
            r7 = r8
            r8 = r13
            r28 = r10
            r9 = r26
            r18 = r13
            r12 = r22
            r14 = r37
            int r0 = r0.U(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0387
        L_0x036d:
            r15 = r31
            r14 = r32
            r12 = r33
            r2 = r34
            r13 = r35
            r11 = r36
            r9 = r37
            r3 = r18
            r1 = r21
            r5 = r24
            r6 = r25
            r10 = r28
            goto L_0x001d
        L_0x0387:
            r7 = r36
            r2 = r0
            goto L_0x02d3
        L_0x038c:
            r22 = r2
            r15 = r4
            r34 = r5
            r28 = r10
            r18 = r13
            r0 = 50
            if (r11 != r0) goto L_0x03b7
            r0 = 2
            if (r8 != r0) goto L_0x03b2
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r18
            r6 = r22
            r8 = r37
            int r0 = r0.R(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x0387
            goto L_0x036d
        L_0x03b2:
            r7 = r36
            r2 = r15
            goto L_0x02d3
        L_0x03b7:
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r21
            r6 = r34
            r9 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            r10 = r22
            r12 = r18
            r13 = r37
            int r0 = r0.S(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0387
            goto L_0x036d
        L_0x03d5:
            if (r8 != r7) goto L_0x03e6
            if (r7 == 0) goto L_0x03e6
            r9 = r31
            r12 = r32
            r0 = r2
            r1 = r8
            r5 = r24
        L_0x03e1:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x044c
        L_0x03e6:
            r9 = r31
            boolean r0 = r9.f7250f
            if (r0 == 0) goto L_0x041b
            r10 = r37
            com.google.android.gms.internal.measurement.zzjr r0 = r10.f7201d
            com.google.android.gms.internal.measurement.zzjr r1 = com.google.android.gms.internal.measurement.zzjr.zza
            if (r0 == r1) goto L_0x0416
            com.google.android.gms.internal.measurement.zzlm r1 = r9.f7249e
            r11 = r34
            com.google.android.gms.internal.measurement.zzkd r0 = r0.zzb(r1, r11)
            if (r0 != 0) goto L_0x0410
            com.google.android.gms.internal.measurement.zzmp r4 = J(r32)
            r0 = r8
            r1 = r33
            r3 = r35
            r5 = r37
            int r0 = com.google.android.gms.internal.measurement.j2.i(r0, r1, r2, r3, r4, r5)
            r12 = r32
            goto L_0x0430
        L_0x0410:
            r12 = r32
            r0 = r12
            com.google.android.gms.internal.measurement.zzkc r0 = (com.google.android.gms.internal.measurement.zzkc) r0
            throw r17
        L_0x0416:
            r12 = r32
            r11 = r34
            goto L_0x0421
        L_0x041b:
            r12 = r32
            r11 = r34
            r10 = r37
        L_0x0421:
            com.google.android.gms.internal.measurement.zzmp r4 = J(r32)
            r0 = r8
            r1 = r33
            r3 = r35
            r5 = r37
            int r0 = com.google.android.gms.internal.measurement.j2.i(r0, r1, r2, r3, r4, r5)
        L_0x0430:
            r13 = r35
            r1 = r8
            r15 = r9
            r9 = r10
            r2 = r11
            r14 = r12
            r3 = r18
            r5 = r24
            r10 = r28
            r12 = r33
            r11 = r7
            goto L_0x001d
        L_0x0442:
            r24 = r5
            r25 = r6
            r28 = r10
            r7 = r11
            r12 = r14
            r9 = r15
            goto L_0x03e1
        L_0x044c:
            if (r6 == r2) goto L_0x0454
            long r3 = (long) r6
            r6 = r28
            r6.putInt(r12, r3, r5)
        L_0x0454:
            int r3 = r9.f7253i
        L_0x0456:
            int r4 = r9.f7254j
            if (r3 >= r4) goto L_0x0481
            int[] r4 = r9.f7252h
            r4 = r4[r3]
            int[] r5 = r9.f7245a
            r5 = r5[r4]
            int r5 = r9.j(r4)
            r5 = r5 & r2
            long r5 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.r4.k(r12, r5)
            if (r5 != 0) goto L_0x046f
            goto L_0x0475
        L_0x046f:
            com.google.android.gms.internal.measurement.zzkj r6 = r9.l(r4)
            if (r6 != 0) goto L_0x0478
        L_0x0475:
            int r3 = r3 + 1
            goto L_0x0456
        L_0x0478:
            com.google.android.gms.internal.measurement.zzlg r5 = (com.google.android.gms.internal.measurement.zzlg) r5
            java.lang.Object r0 = r9.n(r4)
            com.google.android.gms.internal.measurement.zzlf r0 = (com.google.android.gms.internal.measurement.zzlf) r0
            throw r17
        L_0x0481:
            if (r7 != 0) goto L_0x048d
            r2 = r35
            if (r0 != r2) goto L_0x0488
            goto L_0x0493
        L_0x0488:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zze()
            throw r0
        L_0x048d:
            r2 = r35
            if (r0 > r2) goto L_0x0494
            if (r1 != r7) goto L_0x0494
        L_0x0493:
            return r0
        L_0x0494:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.o3.I(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.i2):int");
    }

    public final int a(Object obj) {
        if (this.f7251g) {
            return P(obj);
        }
        return O(obj);
    }

    public final void b(Object obj) {
        if (E(obj)) {
            if (obj instanceof zzkf) {
                zzkf zzkf = (zzkf) obj;
                zzkf.zzbM(Integer.MAX_VALUE);
                zzkf.zzb = 0;
                zzkf.zzbK();
            }
            int length = this.f7245a.length;
            for (int i10 = 0; i10 < length; i10 += 3) {
                int j10 = j(i10);
                long j11 = (long) (1048575 & j10);
                int i11 = i(j10);
                if (i11 != 9) {
                    switch (i11) {
                        case 17:
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case MotionEventCompat.AXIS_GENERIC_2 /*33*/:
                        case 34:
                        case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                        case 36:
                        case MotionEventCompat.AXIS_GENERIC_6 /*37*/:
                        case MotionEventCompat.AXIS_GENERIC_7 /*38*/:
                        case MotionEventCompat.AXIS_GENERIC_8 /*39*/:
                        case MotionEventCompat.AXIS_GENERIC_9 /*40*/:
                        case MotionEventCompat.AXIS_GENERIC_10 /*41*/:
                        case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                        case MotionEventCompat.AXIS_GENERIC_12 /*43*/:
                        case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
                        case MotionEventCompat.AXIS_GENERIC_14 /*45*/:
                        case MotionEventCompat.AXIS_GENERIC_15 /*46*/:
                        case MotionEventCompat.AXIS_GENERIC_16 /*47*/:
                        case 48:
                        case 49:
                            this.f7255k.a(obj, j11);
                            continue;
                        case 50:
                            Unsafe unsafe = f7244q;
                            Object object = unsafe.getObject(obj, j11);
                            if (object != null) {
                                ((zzlg) object).zzc();
                                unsafe.putObject(obj, j11, object);
                                break;
                            } else {
                                continue;
                            }
                    }
                }
                if (B(obj, i10)) {
                    m(i10).b(f7244q.getObject(obj, j11));
                }
            }
            this.f7256l.g(obj);
            if (this.f7250f) {
                this.f7257m.b(obj);
            }
        }
    }

    public final boolean c(Object obj) {
        int i10;
        int i11;
        Object obj2 = obj;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.f7253i) {
            int i15 = this.f7252h[i14];
            int i16 = this.f7245a[i15];
            int j10 = j(i15);
            int i17 = this.f7245a[i15 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i12) {
                if (i18 != 1048575) {
                    i13 = f7244q.getInt(obj2, (long) i18);
                }
                i10 = i13;
                i11 = i18;
            } else {
                i11 = i12;
                i10 = i13;
            }
            if ((268435456 & j10) != 0 && !C(obj, i15, i11, i10, i19)) {
                return false;
            }
            int i20 = i(j10);
            if (i20 != 9 && i20 != 17) {
                if (i20 != 27) {
                    if (i20 == 60 || i20 == 68) {
                        if (F(obj2, i16, i15) && !D(obj2, j10, m(i15))) {
                            return false;
                        }
                    } else if (i20 != 49) {
                        if (i20 == 50 && !((zzlg) r4.k(obj2, (long) (j10 & 1048575))).isEmpty()) {
                            zzlf zzlf = (zzlf) n(i15);
                            throw null;
                        }
                    }
                }
                List list = (List) r4.k(obj2, (long) (j10 & 1048575));
                if (!list.isEmpty()) {
                    w3 m10 = m(i15);
                    for (int i21 = 0; i21 < list.size(); i21++) {
                        if (!m10.c(list.get(i21))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (C(obj, i15, i11, i10, i19) && !D(obj2, j10, m(i15))) {
                return false;
            }
            i14++;
            i12 = i11;
            i13 = i10;
        }
        if (!this.f7250f) {
            return true;
        }
        this.f7257m.a(obj2);
        throw null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x016c, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x022a, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(java.lang.Object r9) {
        /*
            r8 = this;
            int[] r0 = r8.f7245a
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022e
            int r3 = r8.j(r1)
            int[] r4 = r8.f7245a
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = i(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x021a;
                case 1: goto L_0x020e;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f6;
                case 4: goto L_0x01ee;
                case 5: goto L_0x01e2;
                case 6: goto L_0x01da;
                case 7: goto L_0x01ce;
                case 8: goto L_0x01c0;
                case 9: goto L_0x01b5;
                case 10: goto L_0x01a9;
                case 11: goto L_0x01a1;
                case 12: goto L_0x0199;
                case 13: goto L_0x0191;
                case 14: goto L_0x0185;
                case 15: goto L_0x017d;
                case 16: goto L_0x0171;
                case 17: goto L_0x0162;
                case 18: goto L_0x0156;
                case 19: goto L_0x0156;
                case 20: goto L_0x0156;
                case 21: goto L_0x0156;
                case 22: goto L_0x0156;
                case 23: goto L_0x0156;
                case 24: goto L_0x0156;
                case 25: goto L_0x0156;
                case 26: goto L_0x0156;
                case 27: goto L_0x0156;
                case 28: goto L_0x0156;
                case 29: goto L_0x0156;
                case 30: goto L_0x0156;
                case 31: goto L_0x0156;
                case 32: goto L_0x0156;
                case 33: goto L_0x0156;
                case 34: goto L_0x0156;
                case 35: goto L_0x0156;
                case 36: goto L_0x0156;
                case 37: goto L_0x0156;
                case 38: goto L_0x0156;
                case 39: goto L_0x0156;
                case 40: goto L_0x0156;
                case 41: goto L_0x0156;
                case 42: goto L_0x0156;
                case 43: goto L_0x0156;
                case 44: goto L_0x0156;
                case 45: goto L_0x0156;
                case 46: goto L_0x0156;
                case 47: goto L_0x0156;
                case 48: goto L_0x0156;
                case 49: goto L_0x0156;
                case 50: goto L_0x014a;
                case 51: goto L_0x0134;
                case 52: goto L_0x0122;
                case 53: goto L_0x0110;
                case 54: goto L_0x00fe;
                case 55: goto L_0x00f0;
                case 56: goto L_0x00de;
                case 57: goto L_0x00d0;
                case 58: goto L_0x00be;
                case 59: goto L_0x00aa;
                case 60: goto L_0x0099;
                case 61: goto L_0x0088;
                case 62: goto L_0x007b;
                case 63: goto L_0x006e;
                case 64: goto L_0x0061;
                case 65: goto L_0x0050;
                case 66: goto L_0x0043;
                case 67: goto L_0x0032;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x022a
        L_0x001f:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.r4.k(r9, r5)
            int r3 = r3.hashCode()
        L_0x002f:
            int r2 = r2 + r3
            goto L_0x022a
        L_0x0032:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            long r3 = k(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x002f
        L_0x0043:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            int r3 = Q(r9, r5)
            goto L_0x002f
        L_0x0050:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            long r3 = k(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x002f
        L_0x0061:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            int r3 = Q(r9, r5)
            goto L_0x002f
        L_0x006e:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            int r3 = Q(r9, r5)
            goto L_0x002f
        L_0x007b:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            int r3 = Q(r9, r5)
            goto L_0x002f
        L_0x0088:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.r4.k(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x002f
        L_0x0099:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.r4.k(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x002f
        L_0x00aa:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.r4.k(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x002f
        L_0x00be:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            boolean r3 = G(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zza(r3)
            goto L_0x002f
        L_0x00d0:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            int r3 = Q(r9, r5)
            goto L_0x002f
        L_0x00de:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            long r3 = k(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x002f
        L_0x00f0:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            int r3 = Q(r9, r5)
            goto L_0x002f
        L_0x00fe:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            long r3 = k(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x002f
        L_0x0110:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            long r3 = k(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x002f
        L_0x0122:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            float r3 = N(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x002f
        L_0x0134:
            boolean r3 = r8.F(r9, r4, r1)
            if (r3 == 0) goto L_0x022a
            int r2 = r2 * 53
            double r3 = M(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x002f
        L_0x014a:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.r4.k(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x002f
        L_0x0156:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.r4.k(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x002f
        L_0x0162:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.r4.k(r9, r5)
            if (r3 == 0) goto L_0x016c
            int r7 = r3.hashCode()
        L_0x016c:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x022a
        L_0x0171:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.r4.i(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x002f
        L_0x017d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.r4.h(r9, r5)
            goto L_0x002f
        L_0x0185:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.r4.i(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x002f
        L_0x0191:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.r4.h(r9, r5)
            goto L_0x002f
        L_0x0199:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.r4.h(r9, r5)
            goto L_0x002f
        L_0x01a1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.r4.h(r9, r5)
            goto L_0x002f
        L_0x01a9:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.r4.k(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x002f
        L_0x01b5:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.r4.k(r9, r5)
            if (r3 == 0) goto L_0x016c
            int r7 = r3.hashCode()
            goto L_0x016c
        L_0x01c0:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.r4.k(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x002f
        L_0x01ce:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.r4.B(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zza(r3)
            goto L_0x002f
        L_0x01da:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.r4.h(r9, r5)
            goto L_0x002f
        L_0x01e2:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.r4.i(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x002f
        L_0x01ee:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.r4.h(r9, r5)
            goto L_0x002f
        L_0x01f6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.r4.i(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x002f
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.r4.i(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x002f
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.r4.g(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x002f
        L_0x021a:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.r4.f(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x002f
        L_0x022a:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022e:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.j4 r0 = r8.f7256l
            java.lang.Object r0 = r0.d(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f7250f
            if (r0 != 0) goto L_0x0240
            return r2
        L_0x0240:
            com.google.android.gms.internal.measurement.v2 r0 = r8.f7257m
            r0.a(r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.o3.d(java.lang.Object):int");
    }

    public final void e(Object obj, Object obj2) {
        r(obj);
        obj2.getClass();
        for (int i10 = 0; i10 < this.f7245a.length; i10 += 3) {
            int j10 = j(i10);
            long j11 = (long) (1048575 & j10);
            int i11 = this.f7245a[i10];
            switch (i(j10)) {
                case 0:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.t(obj, j11, r4.f(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 1:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.u(obj, j11, r4.g(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 2:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.w(obj, j11, r4.i(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 3:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.w(obj, j11, r4.i(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 4:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.v(obj, j11, r4.h(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 5:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.w(obj, j11, r4.i(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 6:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.v(obj, j11, r4.h(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 7:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.r(obj, j11, r4.B(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 8:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.x(obj, j11, r4.k(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 9:
                    s(obj, obj2, i10);
                    break;
                case 10:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.x(obj, j11, r4.k(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 11:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.v(obj, j11, r4.h(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 12:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.v(obj, j11, r4.h(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 13:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.v(obj, j11, r4.h(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 14:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.w(obj, j11, r4.i(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 15:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.v(obj, j11, r4.h(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 16:
                    if (!B(obj2, i10)) {
                        break;
                    } else {
                        r4.w(obj, j11, r4.i(obj2, j11));
                        u(obj, i10);
                        break;
                    }
                case 17:
                    s(obj, obj2, i10);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
                case 29:
                case 30:
                case 31:
                case 32:
                case MotionEventCompat.AXIS_GENERIC_2 /*33*/:
                case 34:
                case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                case 36:
                case MotionEventCompat.AXIS_GENERIC_6 /*37*/:
                case MotionEventCompat.AXIS_GENERIC_7 /*38*/:
                case MotionEventCompat.AXIS_GENERIC_8 /*39*/:
                case MotionEventCompat.AXIS_GENERIC_9 /*40*/:
                case MotionEventCompat.AXIS_GENERIC_10 /*41*/:
                case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                case MotionEventCompat.AXIS_GENERIC_12 /*43*/:
                case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
                case MotionEventCompat.AXIS_GENERIC_14 /*45*/:
                case MotionEventCompat.AXIS_GENERIC_15 /*46*/:
                case MotionEventCompat.AXIS_GENERIC_16 /*47*/:
                case 48:
                case 49:
                    this.f7255k.b(obj, obj2, j11);
                    break;
                case 50:
                    y3.B(this.f7259o, obj, obj2, j11);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!F(obj2, i11, i10)) {
                        break;
                    } else {
                        r4.x(obj, j11, r4.k(obj2, j11));
                        v(obj, i11, i10);
                        break;
                    }
                case 60:
                    t(obj, obj2, i10);
                    break;
                case 61:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /*63*/:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH:
                case 66:
                case 67:
                    if (!F(obj2, i11, i10)) {
                        break;
                    } else {
                        r4.x(obj, j11, r4.k(obj2, j11));
                        v(obj, i11, i10);
                        break;
                    }
                case 68:
                    t(obj, obj2, i10);
                    break;
            }
        }
        y3.f(this.f7256l, obj, obj2);
        if (this.f7250f) {
            y3.e(this.f7257m, obj, obj2);
        }
    }

    public final void f(Object obj, x4 x4Var) {
        if (!this.f7251g) {
            y(obj, x4Var);
        } else if (!this.f7250f) {
            int length = this.f7245a.length;
            for (int i10 = 0; i10 < length; i10 += 3) {
                int j10 = j(i10);
                int i11 = this.f7245a[i10];
                switch (i(j10)) {
                    case 0:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.t(i11, r4.f(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 1:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.w(i11, r4.g(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 2:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.h(i11, r4.i(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 3:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.C(i11, r4.i(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 4:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.r(i11, r4.h(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 5:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.F(i11, r4.i(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 6:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.d(i11, r4.h(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 7:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.e(i11, r4.B(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 8:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            H(i11, r4.k(obj, (long) (j10 & 1048575)), x4Var);
                            break;
                        }
                    case 9:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.H(i11, r4.k(obj, (long) (j10 & 1048575)), m(i10));
                            break;
                        }
                    case 10:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.n(i11, (zzje) r4.k(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 11:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.a(i11, r4.h(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 12:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.p(i11, r4.h(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 13:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.v(i11, r4.h(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 14:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.j(i11, r4.i(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 15:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.f(i11, r4.h(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 16:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.I(i11, r4.i(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 17:
                        if (!B(obj, i10)) {
                            break;
                        } else {
                            x4Var.l(i11, r4.k(obj, (long) (j10 & 1048575)), m(i10));
                            break;
                        }
                    case 18:
                        y3.j(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, false);
                        break;
                    case 19:
                        y3.n(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, false);
                        break;
                    case 20:
                        y3.q(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, false);
                        break;
                    case 21:
                        y3.y(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, false);
                        break;
                    case 22:
                        y3.p(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, false);
                        break;
                    case 23:
                        y3.m(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, false);
                        break;
                    case 24:
                        y3.l(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, false);
                        break;
                    case 25:
                        y3.h(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, false);
                        break;
                    case 26:
                        y3.w(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var);
                        break;
                    case 27:
                        y3.r(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, m(i10));
                        break;
                    case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
                        y3.i(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var);
                        break;
                    case 29:
                        y3.x(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, false);
                        break;
                    case 30:
                        y3.k(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, false);
                        break;
                    case 31:
                        y3.s(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, false);
                        break;
                    case 32:
                        y3.t(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, false);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_2 /*33*/:
                        y3.u(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, false);
                        break;
                    case 34:
                        y3.v(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, false);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                        y3.j(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, true);
                        break;
                    case 36:
                        y3.n(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_6 /*37*/:
                        y3.q(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_7 /*38*/:
                        y3.y(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_8 /*39*/:
                        y3.p(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_9 /*40*/:
                        y3.m(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_10 /*41*/:
                        y3.l(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                        y3.h(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_12 /*43*/:
                        y3.x(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
                        y3.k(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_14 /*45*/:
                        y3.s(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_15 /*46*/:
                        y3.t(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_16 /*47*/:
                        y3.u(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, true);
                        break;
                    case 48:
                        y3.v(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, true);
                        break;
                    case 49:
                        y3.o(i11, (List) r4.k(obj, (long) (j10 & 1048575)), x4Var, m(i10));
                        break;
                    case 50:
                        z(x4Var, i11, r4.k(obj, (long) (j10 & 1048575)), i10);
                        break;
                    case 51:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.t(i11, M(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 52:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.w(i11, N(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 53:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.h(i11, k(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 54:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.C(i11, k(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 55:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.r(i11, Q(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 56:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.F(i11, k(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 57:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.d(i11, Q(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 58:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.e(i11, G(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 59:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            H(i11, r4.k(obj, (long) (j10 & 1048575)), x4Var);
                            break;
                        }
                    case 60:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.H(i11, r4.k(obj, (long) (j10 & 1048575)), m(i10));
                            break;
                        }
                    case 61:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.n(i11, (zzje) r4.k(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 62:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.a(i11, Q(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case HtmlCompat.FROM_HTML_MODE_COMPACT /*63*/:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.p(i11, Q(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 64:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.v(i11, Q(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.j(i11, k(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 66:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.f(i11, Q(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 67:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.I(i11, k(obj, (long) (j10 & 1048575)));
                            break;
                        }
                    case 68:
                        if (!F(obj, i11, i10)) {
                            break;
                        } else {
                            x4Var.l(i11, r4.k(obj, (long) (j10 & 1048575)), m(i10));
                            break;
                        }
                }
            }
            j4 j4Var = this.f7256l;
            j4Var.i(j4Var.d(obj), x4Var);
        } else {
            this.f7257m.a(obj);
            throw null;
        }
    }

    public final void g(Object obj, byte[] bArr, int i10, int i11, i2 i2Var) {
        if (this.f7251g) {
            T(obj, bArr, i10, i11, i2Var);
        } else {
            I(obj, bArr, i10, i11, 0, i2Var);
        }
    }

    public final boolean h(Object obj, Object obj2) {
        boolean z10;
        int length = this.f7245a.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int j10 = j(i10);
            long j11 = (long) (j10 & 1048575);
            switch (i(j10)) {
                case 0:
                    if (A(obj, obj2, i10) && Double.doubleToLongBits(r4.f(obj, j11)) == Double.doubleToLongBits(r4.f(obj2, j11))) {
                        continue;
                    }
                case 1:
                    if (A(obj, obj2, i10) && Float.floatToIntBits(r4.g(obj, j11)) == Float.floatToIntBits(r4.g(obj2, j11))) {
                        continue;
                    }
                case 2:
                    if (A(obj, obj2, i10) && r4.i(obj, j11) == r4.i(obj2, j11)) {
                        continue;
                    }
                case 3:
                    if (A(obj, obj2, i10) && r4.i(obj, j11) == r4.i(obj2, j11)) {
                        continue;
                    }
                case 4:
                    if (A(obj, obj2, i10) && r4.h(obj, j11) == r4.h(obj2, j11)) {
                        continue;
                    }
                case 5:
                    if (A(obj, obj2, i10) && r4.i(obj, j11) == r4.i(obj2, j11)) {
                        continue;
                    }
                case 6:
                    if (A(obj, obj2, i10) && r4.h(obj, j11) == r4.h(obj2, j11)) {
                        continue;
                    }
                case 7:
                    if (A(obj, obj2, i10) && r4.B(obj, j11) == r4.B(obj2, j11)) {
                        continue;
                    }
                case 8:
                    if (A(obj, obj2, i10) && y3.z(r4.k(obj, j11), r4.k(obj2, j11))) {
                        continue;
                    }
                case 9:
                    if (A(obj, obj2, i10) && y3.z(r4.k(obj, j11), r4.k(obj2, j11))) {
                        continue;
                    }
                case 10:
                    if (A(obj, obj2, i10) && y3.z(r4.k(obj, j11), r4.k(obj2, j11))) {
                        continue;
                    }
                case 11:
                    if (A(obj, obj2, i10) && r4.h(obj, j11) == r4.h(obj2, j11)) {
                        continue;
                    }
                case 12:
                    if (A(obj, obj2, i10) && r4.h(obj, j11) == r4.h(obj2, j11)) {
                        continue;
                    }
                case 13:
                    if (A(obj, obj2, i10) && r4.h(obj, j11) == r4.h(obj2, j11)) {
                        continue;
                    }
                case 14:
                    if (A(obj, obj2, i10) && r4.i(obj, j11) == r4.i(obj2, j11)) {
                        continue;
                    }
                case 15:
                    if (A(obj, obj2, i10) && r4.h(obj, j11) == r4.h(obj2, j11)) {
                        continue;
                    }
                case 16:
                    if (A(obj, obj2, i10) && r4.i(obj, j11) == r4.i(obj2, j11)) {
                        continue;
                    }
                case 17:
                    if (A(obj, obj2, i10) && y3.z(r4.k(obj, j11), r4.k(obj2, j11))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
                case 29:
                case 30:
                case 31:
                case 32:
                case MotionEventCompat.AXIS_GENERIC_2 /*33*/:
                case 34:
                case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                case 36:
                case MotionEventCompat.AXIS_GENERIC_6 /*37*/:
                case MotionEventCompat.AXIS_GENERIC_7 /*38*/:
                case MotionEventCompat.AXIS_GENERIC_8 /*39*/:
                case MotionEventCompat.AXIS_GENERIC_9 /*40*/:
                case MotionEventCompat.AXIS_GENERIC_10 /*41*/:
                case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                case MotionEventCompat.AXIS_GENERIC_12 /*43*/:
                case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
                case MotionEventCompat.AXIS_GENERIC_14 /*45*/:
                case MotionEventCompat.AXIS_GENERIC_15 /*46*/:
                case MotionEventCompat.AXIS_GENERIC_16 /*47*/:
                case 48:
                case 49:
                    z10 = y3.z(r4.k(obj, j11), r4.k(obj2, j11));
                    break;
                case 50:
                    z10 = y3.z(r4.k(obj, j11), r4.k(obj2, j11));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /*63*/:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH:
                case 66:
                case 67:
                case 68:
                    long X = (long) (X(i10) & 1048575);
                    if (r4.h(obj, X) == r4.h(obj2, X) && y3.z(r4.k(obj, j11), r4.k(obj2, j11))) {
                        continue;
                    }
            }
            if (!z10) {
                return false;
            }
        }
        if (!this.f7256l.d(obj).equals(this.f7256l.d(obj2))) {
            return false;
        }
        if (!this.f7250f) {
            return true;
        }
        this.f7257m.a(obj);
        this.f7257m.a(obj2);
        throw null;
    }

    public final Object zze() {
        return ((zzkf) this.f7249e).zzbA();
    }
}
