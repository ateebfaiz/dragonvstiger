package com.google.android.gms.internal.auth;

import androidx.core.text.HtmlCompat;
import androidx.core.view.MotionEventCompat;
import c.d;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class n1 implements v1 {

    /* renamed from: o  reason: collision with root package name */
    private static final int[] f6956o = new int[0];

    /* renamed from: p  reason: collision with root package name */
    private static final Unsafe f6957p = p2.g();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f6958a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f6959b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6960c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6961d;

    /* renamed from: e  reason: collision with root package name */
    private final zzfw f6962e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f6963f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f6964g;

    /* renamed from: h  reason: collision with root package name */
    private final int f6965h;

    /* renamed from: i  reason: collision with root package name */
    private final int f6966i;

    /* renamed from: j  reason: collision with root package name */
    private final e1 f6967j;

    /* renamed from: k  reason: collision with root package name */
    private final h2 f6968k;

    /* renamed from: l  reason: collision with root package name */
    private final x0 f6969l;

    /* renamed from: m  reason: collision with root package name */
    private final p1 f6970m;

    /* renamed from: n  reason: collision with root package name */
    private final i1 f6971n;

    private n1(int[] iArr, Object[] objArr, int i10, int i11, zzfw zzfw, boolean z10, boolean z11, int[] iArr2, int i12, int i13, p1 p1Var, e1 e1Var, h2 h2Var, x0 x0Var, i1 i1Var, byte[] bArr) {
        this.f6958a = iArr;
        this.f6959b = objArr;
        this.f6960c = i10;
        this.f6961d = i11;
        this.f6963f = z10;
        this.f6964g = iArr2;
        this.f6965h = i12;
        this.f6966i = i13;
        this.f6970m = p1Var;
        this.f6967j = e1Var;
        this.f6968k = h2Var;
        this.f6969l = x0Var;
        this.f6962e = zzfw;
        this.f6971n = i1Var;
    }

    private final int A(int i10, int i11) {
        if (i10 < this.f6960c || i10 > this.f6961d) {
            return -1;
        }
        return C(i10, i11);
    }

    private final int B(int i10) {
        return this.f6958a[i10 + 2];
    }

    private final int C(int i10, int i11) {
        int length = (this.f6958a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = this.f6958a[i13];
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

    private static int D(int i10) {
        return (i10 >>> 20) & 255;
    }

    private final int E(int i10) {
        return this.f6958a[i10 + 1];
    }

    private static long F(Object obj, long j10) {
        return ((Long) p2.f(obj, j10)).longValue();
    }

    private final zzex G(int i10) {
        int i11 = i10 / 3;
        return (zzex) this.f6959b[i11 + i11 + 1];
    }

    private final v1 H(int i10) {
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        v1 v1Var = (v1) this.f6959b[i12];
        if (v1Var != null) {
            return v1Var;
        }
        v1 b10 = s1.a().b((Class) this.f6959b[i12 + 1]);
        this.f6959b[i12] = b10;
        return b10;
    }

    private final Object I(int i10) {
        int i11 = i10 / 3;
        return this.f6959b[i11 + i11];
    }

    private static Field g(Class cls, String str) {
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

    private final void h(Object obj, Object obj2, int i10) {
        long E = (long) (E(i10) & 1048575);
        if (m(obj2, i10)) {
            Object f10 = p2.f(obj, E);
            Object f11 = p2.f(obj2, E);
            if (f10 != null && f11 != null) {
                p2.p(obj, E, zzez.zzg(f10, f11));
                j(obj, i10);
            } else if (f11 != null) {
                p2.p(obj, E, f11);
                j(obj, i10);
            }
        }
    }

    private final void i(Object obj, Object obj2, int i10) {
        Object obj3;
        int E = E(i10);
        int i11 = this.f6958a[i10];
        long j10 = (long) (E & 1048575);
        if (p(obj2, i11, i10)) {
            if (p(obj, i11, i10)) {
                obj3 = p2.f(obj, j10);
            } else {
                obj3 = null;
            }
            Object f10 = p2.f(obj2, j10);
            if (obj3 != null && f10 != null) {
                p2.p(obj, j10, zzez.zzg(obj3, f10));
                k(obj, i11, i10);
            } else if (f10 != null) {
                p2.p(obj, j10, f10);
                k(obj, i11, i10);
            }
        }
    }

    private final void j(Object obj, int i10) {
        int B = B(i10);
        long j10 = (long) (1048575 & B);
        if (j10 != 1048575) {
            p2.n(obj, j10, (1 << (B >>> 20)) | p2.c(obj, j10));
        }
    }

    private final void k(Object obj, int i10, int i11) {
        p2.n(obj, (long) (B(i11) & 1048575), i10);
    }

    private final boolean l(Object obj, Object obj2, int i10) {
        if (m(obj, i10) == m(obj2, i10)) {
            return true;
        }
        return false;
    }

    private final boolean m(Object obj, int i10) {
        int B = B(i10);
        long j10 = (long) (B & 1048575);
        if (j10 == 1048575) {
            int E = E(i10);
            long j11 = (long) (E & 1048575);
            switch (D(E)) {
                case 0:
                    if (Double.doubleToRawLongBits(p2.a(obj, j11)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(p2.b(obj, j11)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (p2.d(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (p2.d(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (p2.c(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (p2.d(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (p2.c(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return p2.t(obj, j11);
                case 8:
                    Object f10 = p2.f(obj, j11);
                    if (f10 instanceof String) {
                        if (!((String) f10).isEmpty()) {
                            return true;
                        }
                        return false;
                    } else if (!(f10 instanceof zzee)) {
                        throw new IllegalArgumentException();
                    } else if (!zzee.zzb.equals(f10)) {
                        return true;
                    } else {
                        return false;
                    }
                case 9:
                    if (p2.f(obj, j11) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    if (!zzee.zzb.equals(p2.f(obj, j11))) {
                        return true;
                    }
                    return false;
                case 11:
                    if (p2.c(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (p2.c(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (p2.c(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (p2.d(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (p2.c(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (p2.d(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (p2.f(obj, j11) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else if ((p2.c(obj, j10) & (1 << (B >>> 20))) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private final boolean n(Object obj, int i10, int i11, int i12, int i13) {
        if (i11 == 1048575) {
            return m(obj, i10);
        }
        if ((i12 & i13) != 0) {
            return true;
        }
        return false;
    }

    private static boolean o(Object obj, int i10, v1 v1Var) {
        return v1Var.e(p2.f(obj, (long) (i10 & 1048575)));
    }

    private final boolean p(Object obj, int i10, int i11) {
        if (p2.c(obj, (long) (B(i11) & 1048575)) == i10) {
            return true;
        }
        return false;
    }

    static zzgz r(Object obj) {
        zzeu zzeu = (zzeu) obj;
        zzgz zzgz = zzeu.zzc;
        if (zzgz != zzgz.zza()) {
            return zzgz;
        }
        zzgz zzc = zzgz.zzc();
        zzeu.zzc = zzc;
        return zzc;
    }

    static n1 s(Class cls, k1 k1Var, p1 p1Var, e1 e1Var, h2 h2Var, x0 x0Var, i1 i1Var) {
        if (k1Var instanceof u1) {
            return t((u1) k1Var, p1Var, e1Var, h2Var, x0Var, i1Var);
        }
        d.a(k1Var);
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0384  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.auth.n1 t(com.google.android.gms.internal.auth.u1 r34, com.google.android.gms.internal.auth.p1 r35, com.google.android.gms.internal.auth.e1 r36, com.google.android.gms.internal.auth.h2 r37, com.google.android.gms.internal.auth.x0 r38, com.google.android.gms.internal.auth.i1 r39) {
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
            int[] r6 = f6956o
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
            sun.misc.Unsafe r15 = f6957p
            java.lang.Object[] r17 = r34.b()
            com.google.android.gms.internal.auth.zzfw r18 = r34.zza()
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
            java.lang.reflect.Field r12 = g(r2, r12)
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
            java.lang.reflect.Field r8 = g(r2, r8)
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
            java.lang.reflect.Field r8 = g(r2, r8)
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
            java.lang.reflect.Field r11 = g(r2, r11)
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
            com.google.android.gms.internal.auth.n1 r0 = new com.google.android.gms.internal.auth.n1
            r4 = r0
            com.google.android.gms.internal.auth.zzfw r9 = r34.zza()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.n1.t(com.google.android.gms.internal.auth.u1, com.google.android.gms.internal.auth.p1, com.google.android.gms.internal.auth.e1, com.google.android.gms.internal.auth.h2, com.google.android.gms.internal.auth.x0, com.google.android.gms.internal.auth.i1):com.google.android.gms.internal.auth.n1");
    }

    private static int u(Object obj, long j10) {
        return ((Integer) p2.f(obj, j10)).intValue();
    }

    private final int v(Object obj, byte[] bArr, int i10, int i11, int i12, long j10, n0 n0Var) {
        Unsafe unsafe = f6957p;
        Object I = I(i12);
        Object object = unsafe.getObject(obj, j10);
        if (!((zzfq) object).zze()) {
            zzfq zzb = zzfq.zza().zzb();
            i1.a(zzb, object);
            unsafe.putObject(obj, j10, zzb);
        }
        zzfp zzfp = (zzfp) I;
        throw null;
    }

    private final int w(Object obj, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, int i17, n0 n0Var) {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i18 = i10;
        int i19 = i12;
        int i20 = i13;
        int i21 = i14;
        long j11 = j10;
        int i22 = i17;
        n0 n0Var2 = n0Var;
        Unsafe unsafe = f6957p;
        long j12 = (long) (this.f6958a[i22 + 2] & 1048575);
        switch (i16) {
            case 51:
                if (i21 == 1) {
                    unsafe.putObject(obj2, j11, Double.valueOf(Double.longBitsToDouble(o0.n(bArr, i10))));
                    unsafe.putInt(obj2, j12, i20);
                    return i18 + 8;
                }
                break;
            case 52:
                if (i21 == 5) {
                    unsafe.putObject(obj2, j11, Float.valueOf(Float.intBitsToFloat(o0.b(bArr, i10))));
                    unsafe.putInt(obj2, j12, i20);
                    return i18 + 4;
                }
                break;
            case 53:
            case 54:
                if (i21 == 0) {
                    int m10 = o0.m(bArr2, i18, n0Var2);
                    unsafe.putObject(obj2, j11, Long.valueOf(n0Var2.f6953b));
                    unsafe.putInt(obj2, j12, i20);
                    return m10;
                }
                break;
            case 55:
            case 62:
                if (i21 == 0) {
                    int j13 = o0.j(bArr2, i18, n0Var2);
                    unsafe.putObject(obj2, j11, Integer.valueOf(n0Var2.f6952a));
                    unsafe.putInt(obj2, j12, i20);
                    return j13;
                }
                break;
            case 56:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH:
                if (i21 == 1) {
                    unsafe.putObject(obj2, j11, Long.valueOf(o0.n(bArr, i10)));
                    unsafe.putInt(obj2, j12, i20);
                    return i18 + 8;
                }
                break;
            case 57:
            case 64:
                if (i21 == 5) {
                    unsafe.putObject(obj2, j11, Integer.valueOf(o0.b(bArr, i10)));
                    unsafe.putInt(obj2, j12, i20);
                    return i18 + 4;
                }
                break;
            case 58:
                if (i21 == 0) {
                    int m11 = o0.m(bArr2, i18, n0Var2);
                    unsafe.putObject(obj2, j11, Boolean.valueOf(n0Var2.f6953b != 0));
                    unsafe.putInt(obj2, j12, i20);
                    return m11;
                }
                break;
            case 59:
                if (i21 == 2) {
                    int j14 = o0.j(bArr2, i18, n0Var2);
                    int i23 = n0Var2.f6952a;
                    if (i23 == 0) {
                        unsafe.putObject(obj2, j11, "");
                    } else if ((i15 & 536870912) == 0 || t2.d(bArr2, j14, j14 + i23)) {
                        unsafe.putObject(obj2, j11, new String(bArr2, j14, i23, zzez.zzb));
                        j14 += i23;
                    } else {
                        throw zzfa.zzb();
                    }
                    unsafe.putInt(obj2, j12, i20);
                    return j14;
                }
                break;
            case 60:
                if (i21 == 2) {
                    int d10 = o0.d(H(i22), bArr2, i18, i11, n0Var2);
                    Object object = unsafe.getInt(obj2, j12) == i20 ? unsafe.getObject(obj2, j11) : null;
                    if (object == null) {
                        unsafe.putObject(obj2, j11, n0Var2.f6954c);
                    } else {
                        unsafe.putObject(obj2, j11, zzez.zzg(object, n0Var2.f6954c));
                    }
                    unsafe.putInt(obj2, j12, i20);
                    return d10;
                }
                break;
            case 61:
                if (i21 == 2) {
                    int a10 = o0.a(bArr2, i18, n0Var2);
                    unsafe.putObject(obj2, j11, n0Var2.f6954c);
                    unsafe.putInt(obj2, j12, i20);
                    return a10;
                }
                break;
            case HtmlCompat.FROM_HTML_MODE_COMPACT /*63*/:
                if (i21 == 0) {
                    int j15 = o0.j(bArr2, i18, n0Var2);
                    int i24 = n0Var2.f6952a;
                    zzex G = G(i22);
                    if (G == null || G.zza()) {
                        unsafe.putObject(obj2, j11, Integer.valueOf(i24));
                        unsafe.putInt(obj2, j12, i20);
                    } else {
                        r(obj).zzf(i19, Long.valueOf((long) i24));
                    }
                    return j15;
                }
                break;
            case 66:
                if (i21 == 0) {
                    int j16 = o0.j(bArr2, i18, n0Var2);
                    unsafe.putObject(obj2, j11, Integer.valueOf(zzei.zzb(n0Var2.f6952a)));
                    unsafe.putInt(obj2, j12, i20);
                    return j16;
                }
                break;
            case 67:
                if (i21 == 0) {
                    int m12 = o0.m(bArr2, i18, n0Var2);
                    unsafe.putObject(obj2, j11, Long.valueOf(zzei.zzc(n0Var2.f6953b)));
                    unsafe.putInt(obj2, j12, i20);
                    return m12;
                }
                break;
            case 68:
                if (i21 == 3) {
                    int c10 = o0.c(H(i22), bArr, i10, i11, (i19 & -8) | 4, n0Var);
                    Object object2 = unsafe.getInt(obj2, j12) == i20 ? unsafe.getObject(obj2, j11) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj2, j11, n0Var2.f6954c);
                    } else {
                        unsafe.putObject(obj2, j11, zzez.zzg(object2, n0Var2.f6954c));
                    }
                    unsafe.putInt(obj2, j12, i20);
                    return c10;
                }
                break;
        }
        return i18;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02c0, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02f4, code lost:
        if (r0 != r14) goto L_0x02a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0313, code lost:
        if (r0 != r14) goto L_0x02a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ad, code lost:
        r6 = r6 | r22;
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bf, code lost:
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00da, code lost:
        r6 = r6 | r22;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0154, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01a6, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0212, code lost:
        r2 = r8;
        r28 = r9;
        r24 = r10;
        r18 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02a4, code lost:
        if (r0 != r32) goto L_0x02a6;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int x(java.lang.Object r30, byte[] r31, int r32, int r33, com.google.android.gms.internal.auth.n0 r34) {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            sun.misc.Unsafe r9 = f6957p
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r16 = 0
            r8 = -1
            r0 = r32
            r1 = r8
            r7 = r10
            r2 = r16
            r6 = r2
        L_0x0019:
            if (r0 >= r13) goto L_0x033d
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.auth.o0.k(r0, r12, r3, r11)
            int r3 = r11.f6952a
            r4 = r0
            r17 = r3
            goto L_0x002e
        L_0x002b:
            r17 = r0
            r4 = r3
        L_0x002e:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003c
            int r2 = r2 / 3
            int r0 = r15.A(r5, r2)
        L_0x003a:
            r2 = r0
            goto L_0x0041
        L_0x003c:
            int r0 = r15.z(r5)
            goto L_0x003a
        L_0x0041:
            if (r2 != r8) goto L_0x004e
            r2 = r4
            r21 = r5
            r18 = r8
            r28 = r9
            r24 = r16
            goto L_0x0316
        L_0x004e:
            int[] r0 = r15.f6958a
            int r1 = r2 + 1
            r1 = r0[r1]
            int r8 = D(r1)
            r32 = r5
            r5 = r1 & r10
            long r10 = (long) r5
            r5 = 17
            r20 = r10
            if (r8 > r5) goto L_0x021b
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r11 = 1
            int r22 = r11 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            if (r0 == r7) goto L_0x0080
            if (r7 == r5) goto L_0x0078
            long r10 = (long) r7
            r9.putInt(r14, r10, r6)
        L_0x0078:
            if (r0 == r5) goto L_0x007f
            long r6 = (long) r0
            int r6 = r9.getInt(r14, r6)
        L_0x007f:
            r7 = r0
        L_0x0080:
            r0 = 5
            switch(r8) {
                case 0: goto L_0x01f9;
                case 1: goto L_0x01de;
                case 2: goto L_0x01bf;
                case 3: goto L_0x01bf;
                case 4: goto L_0x01a9;
                case 5: goto L_0x018c;
                case 6: goto L_0x0177;
                case 7: goto L_0x0158;
                case 8: goto L_0x0133;
                case 9: goto L_0x0109;
                case 10: goto L_0x00f3;
                case 11: goto L_0x01a9;
                case 12: goto L_0x00de;
                case 13: goto L_0x0177;
                case 14: goto L_0x018c;
                case 15: goto L_0x00c2;
                case 16: goto L_0x008e;
                default: goto L_0x0084;
            }
        L_0x0084:
            r21 = r32
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = r5
            goto L_0x0212
        L_0x008e:
            if (r3 != 0) goto L_0x00b8
            r11 = r34
            r0 = r20
            int r8 = com.google.android.gms.internal.auth.o0.m(r12, r4, r11)
            long r3 = r11.f6953b
            long r19 = com.google.android.gms.internal.auth.zzei.zzc(r3)
            r3 = r0
            r0 = r9
            r1 = r30
            r10 = r2
            r2 = r3
            r21 = r32
            r24 = r5
            r4 = r19
            r0.putLong(r1, r2, r4)
        L_0x00ad:
            r6 = r6 | r22
            r0 = r8
        L_0x00b0:
            r2 = r10
            r1 = r21
            r10 = r24
            r8 = -1
            goto L_0x0019
        L_0x00b8:
            r21 = r32
            r11 = r34
            r10 = r2
            r24 = r5
        L_0x00bf:
            r8 = r4
            goto L_0x0212
        L_0x00c2:
            r11 = r34
            r10 = r2
            r24 = r5
            r0 = r20
            r21 = r32
            if (r3 != 0) goto L_0x00bf
            int r2 = com.google.android.gms.internal.auth.o0.j(r12, r4, r11)
            int r3 = r11.f6952a
            int r3 = com.google.android.gms.internal.auth.zzei.zzb(r3)
            r9.putInt(r14, r0, r3)
        L_0x00da:
            r6 = r6 | r22
            r0 = r2
            goto L_0x00b0
        L_0x00de:
            r11 = r34
            r10 = r2
            r24 = r5
            r0 = r20
            r21 = r32
            if (r3 != 0) goto L_0x00bf
            int r2 = com.google.android.gms.internal.auth.o0.j(r12, r4, r11)
            int r3 = r11.f6952a
            r9.putInt(r14, r0, r3)
            goto L_0x00da
        L_0x00f3:
            r11 = r34
            r10 = r2
            r24 = r5
            r0 = r20
            r2 = 2
            r21 = r32
            if (r3 != r2) goto L_0x00bf
            int r2 = com.google.android.gms.internal.auth.o0.a(r12, r4, r11)
            java.lang.Object r3 = r11.f6954c
            r9.putObject(r14, r0, r3)
            goto L_0x00da
        L_0x0109:
            r11 = r34
            r10 = r2
            r24 = r5
            r0 = r20
            r2 = 2
            r21 = r32
            if (r3 != r2) goto L_0x00bf
            com.google.android.gms.internal.auth.v1 r2 = r15.H(r10)
            int r2 = com.google.android.gms.internal.auth.o0.d(r2, r12, r4, r13, r11)
            java.lang.Object r3 = r9.getObject(r14, r0)
            if (r3 != 0) goto L_0x0129
            java.lang.Object r3 = r11.f6954c
            r9.putObject(r14, r0, r3)
            goto L_0x00da
        L_0x0129:
            java.lang.Object r4 = r11.f6954c
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzez.zzg(r3, r4)
            r9.putObject(r14, r0, r3)
            goto L_0x00da
        L_0x0133:
            r11 = r34
            r10 = r2
            r24 = r5
            r25 = r20
            r0 = 2
            r21 = r32
            if (r3 != r0) goto L_0x00bf
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x0149
            int r0 = com.google.android.gms.internal.auth.o0.g(r12, r4, r11)
            goto L_0x014d
        L_0x0149:
            int r0 = com.google.android.gms.internal.auth.o0.h(r12, r4, r11)
        L_0x014d:
            java.lang.Object r1 = r11.f6954c
            r2 = r25
            r9.putObject(r14, r2, r1)
        L_0x0154:
            r6 = r6 | r22
            goto L_0x00b0
        L_0x0158:
            r11 = r34
            r10 = r2
            r24 = r5
            r1 = r20
            r21 = r32
            if (r3 != 0) goto L_0x00bf
            int r0 = com.google.android.gms.internal.auth.o0.m(r12, r4, r11)
            long r3 = r11.f6953b
            r19 = 0
            int r3 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r3 == 0) goto L_0x0171
            r3 = 1
            goto L_0x0173
        L_0x0171:
            r3 = r16
        L_0x0173:
            com.google.android.gms.internal.auth.p2.k(r14, r1, r3)
            goto L_0x0154
        L_0x0177:
            r11 = r34
            r10 = r2
            r24 = r5
            r1 = r20
            r21 = r32
            if (r3 != r0) goto L_0x00bf
            int r0 = com.google.android.gms.internal.auth.o0.b(r12, r4)
            r9.putInt(r14, r1, r0)
            int r0 = r4 + 4
            goto L_0x0154
        L_0x018c:
            r11 = r34
            r10 = r2
            r24 = r5
            r1 = r20
            r0 = 1
            r21 = r32
            if (r3 != r0) goto L_0x00bf
            long r19 = com.google.android.gms.internal.auth.o0.n(r12, r4)
            r0 = r9
            r2 = r1
            r1 = r30
            r8 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
        L_0x01a6:
            int r0 = r8 + 8
            goto L_0x0154
        L_0x01a9:
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = r5
            r4 = r20
            r21 = r32
            if (r3 != 0) goto L_0x0212
            int r0 = com.google.android.gms.internal.auth.o0.j(r12, r8, r11)
            int r1 = r11.f6952a
            r9.putInt(r14, r4, r1)
            goto L_0x0154
        L_0x01bf:
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = r5
            r4 = r20
            r21 = r32
            if (r3 != 0) goto L_0x0212
            int r8 = com.google.android.gms.internal.auth.o0.m(r12, r8, r11)
            long r2 = r11.f6953b
            r0 = r9
            r1 = r30
            r19 = r2
            r2 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x00ad
        L_0x01de:
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = r5
            r4 = r20
            r21 = r32
            if (r3 != r0) goto L_0x0212
            int r0 = com.google.android.gms.internal.auth.o0.b(r12, r8)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.auth.p2.m(r14, r4, r0)
            int r0 = r8 + 4
            goto L_0x0154
        L_0x01f9:
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = r5
            r4 = r20
            r0 = 1
            r21 = r32
            if (r3 != r0) goto L_0x0212
            long r0 = com.google.android.gms.internal.auth.o0.n(r12, r8)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.auth.p2.l(r14, r4, r0)
            goto L_0x01a6
        L_0x0212:
            r2 = r8
            r28 = r9
            r24 = r10
            r18 = -1
            goto L_0x0316
        L_0x021b:
            r11 = r34
            r10 = r2
            r2 = r4
            r4 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            r0 = 27
            if (r8 != r0) goto L_0x026c
            r0 = 2
            if (r3 != r0) goto L_0x0260
            java.lang.Object r0 = r9.getObject(r14, r4)
            com.google.android.gms.internal.auth.zzey r0 = (com.google.android.gms.internal.auth.zzey) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x024a
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0242
            r1 = 10
            goto L_0x0243
        L_0x0242:
            int r1 = r1 + r1
        L_0x0243:
            com.google.android.gms.internal.auth.zzey r0 = r0.zzd(r1)
            r9.putObject(r14, r4, r0)
        L_0x024a:
            r5 = r0
            com.google.android.gms.internal.auth.v1 r0 = r15.H(r10)
            r1 = r17
            r3 = r2
            r2 = r31
            r4 = r33
            r8 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.auth.o0.e(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
            goto L_0x00b0
        L_0x0260:
            r14 = r2
            r23 = r6
            r15 = r7
            r28 = r9
            r24 = r10
            r18 = -1
            goto L_0x02f7
        L_0x026c:
            r0 = 49
            if (r8 > r0) goto L_0x02c6
            long r0 = (long) r1
            r19 = r0
            r0 = r29
            r1 = r30
            r32 = r2
            r2 = r31
            r22 = r3
            r3 = r32
            r25 = r4
            r4 = r33
            r5 = r17
            r15 = r6
            r6 = r21
            r23 = r15
            r15 = r7
            r7 = r22
            r27 = r8
            r18 = -1
            r8 = r10
            r28 = r9
            r24 = r10
            r9 = r19
            r11 = r27
            r12 = r25
            r14 = r34
            int r0 = r0.y(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            r14 = r32
            if (r0 == r14) goto L_0x02c0
        L_0x02a6:
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r7 = r15
            r8 = r18
            r1 = r21
            r6 = r23
            r2 = r24
            r9 = r28
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r15 = r29
            goto L_0x0019
        L_0x02c0:
            r2 = r0
        L_0x02c1:
            r7 = r15
            r6 = r23
            goto L_0x0316
        L_0x02c6:
            r14 = r2
            r22 = r3
            r25 = r4
            r23 = r6
            r15 = r7
            r27 = r8
            r28 = r9
            r24 = r10
            r18 = -1
            r0 = 50
            r9 = r27
            if (r9 != r0) goto L_0x02f9
            r7 = r22
            r0 = 2
            if (r7 != r0) goto L_0x02f7
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r14
            r4 = r33
            r5 = r24
            r6 = r25
            r8 = r34
            int r0 = r0.v(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r14) goto L_0x02c0
            goto L_0x02a6
        L_0x02f7:
            r2 = r14
            goto L_0x02c1
        L_0x02f9:
            r7 = r22
            r0 = r29
            r8 = r1
            r1 = r30
            r2 = r31
            r3 = r14
            r4 = r33
            r5 = r17
            r6 = r21
            r10 = r25
            r12 = r24
            r13 = r34
            int r0 = r0.w(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r14) goto L_0x02c0
            goto L_0x02a6
        L_0x0316:
            com.google.android.gms.internal.auth.zzgz r4 = r(r30)
            r0 = r17
            r1 = r31
            r3 = r33
            r5 = r34
            int r0 = com.google.android.gms.internal.auth.o0.i(r0, r1, r2, r3, r4, r5)
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r8 = r18
            r1 = r21
            r2 = r24
            r9 = r28
            r10 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0019
        L_0x033d:
            r23 = r6
            r15 = r7
            r28 = r9
            r1 = r10
            if (r15 == r1) goto L_0x034f
            long r1 = (long) r15
            r3 = r30
            r6 = r23
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x034f:
            r1 = r33
            if (r0 != r1) goto L_0x0354
            return r0
        L_0x0354:
            com.google.android.gms.internal.auth.zzfa r0 = com.google.android.gms.internal.auth.zzfa.zzd()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.n1.x(java.lang.Object, byte[], int, int, com.google.android.gms.internal.auth.n0):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0340 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01b3  */
    private final int y(java.lang.Object r15, byte[] r16, int r17, int r18, int r19, int r20, int r21, int r22, long r23, int r25, long r26, com.google.android.gms.internal.auth.n0 r28) {
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
            sun.misc.Unsafe r11 = f6957p
            java.lang.Object r12 = r11.getObject(r15, r9)
            com.google.android.gms.internal.auth.zzey r12 = (com.google.android.gms.internal.auth.zzey) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0031
            int r13 = r12.size()
            if (r13 != 0) goto L_0x0029
            r13 = 10
            goto L_0x002a
        L_0x0029:
            int r13 = r13 + r13
        L_0x002a:
            com.google.android.gms.internal.auth.zzey r12 = r12.zzd(r13)
            r11.putObject(r15, r9, r12)
        L_0x0031:
            r9 = 1
            r10 = 5
            r11 = 2
            r13 = 0
            switch(r25) {
                case 18: goto L_0x031f;
                case 19: goto L_0x02f3;
                case 20: goto L_0x02cd;
                case 21: goto L_0x02cd;
                case 22: goto L_0x02b2;
                case 23: goto L_0x028c;
                case 24: goto L_0x0266;
                case 25: goto L_0x023e;
                case 26: goto L_0x0189;
                case 27: goto L_0x016e;
                case 28: goto L_0x0114;
                case 29: goto L_0x02b2;
                case 30: goto L_0x00da;
                case 31: goto L_0x0266;
                case 32: goto L_0x028c;
                case 33: goto L_0x00aa;
                case 34: goto L_0x007a;
                case 35: goto L_0x031f;
                case 36: goto L_0x02f3;
                case 37: goto L_0x02cd;
                case 38: goto L_0x02cd;
                case 39: goto L_0x02b2;
                case 40: goto L_0x028c;
                case 41: goto L_0x0266;
                case 42: goto L_0x023e;
                case 43: goto L_0x02b2;
                case 44: goto L_0x00da;
                case 45: goto L_0x0266;
                case 46: goto L_0x028c;
                case 47: goto L_0x00aa;
                case 48: goto L_0x007a;
                default: goto L_0x0038;
            }
        L_0x0038:
            r1 = 3
            if (r6 != r1) goto L_0x033f
            com.google.android.gms.internal.auth.v1 r1 = r14.H(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r20 = r1
            r21 = r16
            r22 = r17
            r23 = r18
            r24 = r6
            r25 = r28
            int r4 = com.google.android.gms.internal.auth.o0.c(r20, r21, r22, r23, r24, r25)
            java.lang.Object r8 = r7.f6954c
            r12.add(r8)
        L_0x0058:
            if (r4 >= r5) goto L_0x0079
            int r8 = com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r9 = r7.f6952a
            if (r2 == r9) goto L_0x0063
            goto L_0x0079
        L_0x0063:
            r20 = r1
            r21 = r16
            r22 = r8
            r23 = r18
            r24 = r6
            r25 = r28
            int r4 = com.google.android.gms.internal.auth.o0.c(r20, r21, r22, r23, r24, r25)
            java.lang.Object r8 = r7.f6954c
            r12.add(r8)
            goto L_0x0058
        L_0x0079:
            return r4
        L_0x007a:
            if (r6 != r11) goto L_0x009a
            c.d.a(r12)
            int r1 = com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r2 = r7.f6952a
            int r2 = r2 + r1
            if (r1 < r2) goto L_0x0091
            if (r1 != r2) goto L_0x008c
            goto L_0x0340
        L_0x008c:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0091:
            com.google.android.gms.internal.auth.o0.m(r3, r1, r7)
            long r1 = r7.f6953b
            com.google.android.gms.internal.auth.zzei.zzc(r1)
            throw r13
        L_0x009a:
            if (r6 == 0) goto L_0x009e
            goto L_0x033f
        L_0x009e:
            c.d.a(r12)
            com.google.android.gms.internal.auth.o0.m(r3, r4, r7)
            long r1 = r7.f6953b
            com.google.android.gms.internal.auth.zzei.zzc(r1)
            throw r13
        L_0x00aa:
            if (r6 != r11) goto L_0x00ca
            c.d.a(r12)
            int r1 = com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r2 = r7.f6952a
            int r2 = r2 + r1
            if (r1 < r2) goto L_0x00c1
            if (r1 != r2) goto L_0x00bc
            goto L_0x0340
        L_0x00bc:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x00c1:
            com.google.android.gms.internal.auth.o0.j(r3, r1, r7)
            int r1 = r7.f6952a
            com.google.android.gms.internal.auth.zzei.zzb(r1)
            throw r13
        L_0x00ca:
            if (r6 == 0) goto L_0x00ce
            goto L_0x033f
        L_0x00ce:
            c.d.a(r12)
            com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r1 = r7.f6952a
            com.google.android.gms.internal.auth.zzei.zzb(r1)
            throw r13
        L_0x00da:
            if (r6 != r11) goto L_0x00e1
            int r2 = com.google.android.gms.internal.auth.o0.f(r3, r4, r12, r7)
            goto L_0x00f2
        L_0x00e1:
            if (r6 != 0) goto L_0x033f
            r2 = r19
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r12
            r7 = r28
            int r2 = com.google.android.gms.internal.auth.o0.l(r2, r3, r4, r5, r6, r7)
        L_0x00f2:
            com.google.android.gms.internal.auth.zzeu r1 = (com.google.android.gms.internal.auth.zzeu) r1
            com.google.android.gms.internal.auth.zzgz r3 = r1.zzc
            com.google.android.gms.internal.auth.zzgz r4 = com.google.android.gms.internal.auth.zzgz.zza()
            if (r3 != r4) goto L_0x00fd
            goto L_0x00fe
        L_0x00fd:
            r13 = r3
        L_0x00fe:
            com.google.android.gms.internal.auth.zzex r3 = r14.G(r8)
            com.google.android.gms.internal.auth.h2 r4 = r0.f6968k
            r5 = r20
            java.lang.Object r3 = com.google.android.gms.internal.auth.x1.d(r5, r12, r3, r13, r4)
            if (r3 != 0) goto L_0x010f
            r1 = r2
            goto L_0x0340
        L_0x010f:
            com.google.android.gms.internal.auth.zzgz r3 = (com.google.android.gms.internal.auth.zzgz) r3
            r1.zzc = r3
            return r2
        L_0x0114:
            if (r6 != r11) goto L_0x033f
            int r1 = com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r4 = r7.f6952a
            if (r4 < 0) goto L_0x0169
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0164
            if (r4 != 0) goto L_0x012a
            com.google.android.gms.internal.auth.zzee r4 = com.google.android.gms.internal.auth.zzee.zzb
            r12.add(r4)
            goto L_0x0132
        L_0x012a:
            com.google.android.gms.internal.auth.zzee r6 = com.google.android.gms.internal.auth.zzee.zzk(r3, r1, r4)
            r12.add(r6)
        L_0x0131:
            int r1 = r1 + r4
        L_0x0132:
            if (r1 >= r5) goto L_0x0163
            int r4 = com.google.android.gms.internal.auth.o0.j(r3, r1, r7)
            int r6 = r7.f6952a
            if (r2 == r6) goto L_0x013d
            goto L_0x0163
        L_0x013d:
            int r1 = com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r4 = r7.f6952a
            if (r4 < 0) goto L_0x015e
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0159
            if (r4 != 0) goto L_0x0151
            com.google.android.gms.internal.auth.zzee r4 = com.google.android.gms.internal.auth.zzee.zzb
            r12.add(r4)
            goto L_0x0132
        L_0x0151:
            com.google.android.gms.internal.auth.zzee r6 = com.google.android.gms.internal.auth.zzee.zzk(r3, r1, r4)
            r12.add(r6)
            goto L_0x0131
        L_0x0159:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x015e:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x0163:
            return r1
        L_0x0164:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0169:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x016e:
            if (r6 == r11) goto L_0x0172
            goto L_0x033f
        L_0x0172:
            com.google.android.gms.internal.auth.v1 r1 = r14.H(r8)
            r20 = r1
            r21 = r19
            r22 = r16
            r23 = r17
            r24 = r18
            r25 = r12
            r26 = r28
            int r1 = com.google.android.gms.internal.auth.o0.e(r20, r21, r22, r23, r24, r25, r26)
            return r1
        L_0x0189:
            if (r6 != r11) goto L_0x033f
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r23 & r8
            r10 = 0
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x01de
            int r1 = com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r4 = r7.f6952a
            if (r4 < 0) goto L_0x01d9
            if (r4 != 0) goto L_0x01a6
            r12.add(r6)
            goto L_0x01b1
        L_0x01a6:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.auth.zzez.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
        L_0x01b0:
            int r1 = r1 + r4
        L_0x01b1:
            if (r1 >= r5) goto L_0x0340
            int r4 = com.google.android.gms.internal.auth.o0.j(r3, r1, r7)
            int r8 = r7.f6952a
            if (r2 != r8) goto L_0x0340
            int r1 = com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r4 = r7.f6952a
            if (r4 < 0) goto L_0x01d4
            if (r4 != 0) goto L_0x01c9
            r12.add(r6)
            goto L_0x01b1
        L_0x01c9:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.auth.zzez.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
            goto L_0x01b0
        L_0x01d4:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x01d9:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x01de:
            int r1 = com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r4 = r7.f6952a
            if (r4 < 0) goto L_0x0239
            if (r4 != 0) goto L_0x01ec
            r12.add(r6)
            goto L_0x01ff
        L_0x01ec:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.auth.t2.d(r3, r1, r8)
            if (r9 == 0) goto L_0x0234
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.auth.zzez.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
        L_0x01fe:
            r1 = r8
        L_0x01ff:
            if (r1 >= r5) goto L_0x0340
            int r4 = com.google.android.gms.internal.auth.o0.j(r3, r1, r7)
            int r8 = r7.f6952a
            if (r2 != r8) goto L_0x0340
            int r1 = com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r4 = r7.f6952a
            if (r4 < 0) goto L_0x022f
            if (r4 != 0) goto L_0x0217
            r12.add(r6)
            goto L_0x01ff
        L_0x0217:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.auth.t2.d(r3, r1, r8)
            if (r9 == 0) goto L_0x022a
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.auth.zzez.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
            goto L_0x01fe
        L_0x022a:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzb()
            throw r1
        L_0x022f:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x0234:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzb()
            throw r1
        L_0x0239:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x023e:
            if (r6 != r11) goto L_0x0259
            c.d.a(r12)
            int r1 = com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r2 = r7.f6952a
            int r2 = r2 + r1
            if (r1 < r2) goto L_0x0255
            if (r1 != r2) goto L_0x0250
            goto L_0x0340
        L_0x0250:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0255:
            com.google.android.gms.internal.auth.o0.m(r3, r1, r7)
            throw r13
        L_0x0259:
            if (r6 == 0) goto L_0x025d
            goto L_0x033f
        L_0x025d:
            c.d.a(r12)
            com.google.android.gms.internal.auth.o0.m(r3, r4, r7)
            long r1 = r7.f6953b
            throw r13
        L_0x0266:
            if (r6 != r11) goto L_0x0281
            c.d.a(r12)
            int r1 = com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r2 = r7.f6952a
            int r2 = r2 + r1
            if (r1 < r2) goto L_0x027d
            if (r1 != r2) goto L_0x0278
            goto L_0x0340
        L_0x0278:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x027d:
            com.google.android.gms.internal.auth.o0.b(r3, r1)
            throw r13
        L_0x0281:
            if (r6 == r10) goto L_0x0285
            goto L_0x033f
        L_0x0285:
            c.d.a(r12)
            com.google.android.gms.internal.auth.o0.b(r16, r17)
            throw r13
        L_0x028c:
            if (r6 != r11) goto L_0x02a7
            c.d.a(r12)
            int r1 = com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r2 = r7.f6952a
            int r2 = r2 + r1
            if (r1 < r2) goto L_0x02a3
            if (r1 != r2) goto L_0x029e
            goto L_0x0340
        L_0x029e:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x02a3:
            com.google.android.gms.internal.auth.o0.n(r3, r1)
            throw r13
        L_0x02a7:
            if (r6 == r9) goto L_0x02ab
            goto L_0x033f
        L_0x02ab:
            c.d.a(r12)
            com.google.android.gms.internal.auth.o0.n(r16, r17)
            throw r13
        L_0x02b2:
            if (r6 != r11) goto L_0x02ba
            int r1 = com.google.android.gms.internal.auth.o0.f(r3, r4, r12, r7)
            goto L_0x0340
        L_0x02ba:
            if (r6 == 0) goto L_0x02be
            goto L_0x033f
        L_0x02be:
            r20 = r16
            r21 = r17
            r22 = r18
            r23 = r12
            r24 = r28
            int r1 = com.google.android.gms.internal.auth.o0.l(r19, r20, r21, r22, r23, r24)
            return r1
        L_0x02cd:
            if (r6 != r11) goto L_0x02e7
            c.d.a(r12)
            int r1 = com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r2 = r7.f6952a
            int r2 = r2 + r1
            if (r1 < r2) goto L_0x02e3
            if (r1 != r2) goto L_0x02de
            goto L_0x0340
        L_0x02de:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x02e3:
            com.google.android.gms.internal.auth.o0.m(r3, r1, r7)
            throw r13
        L_0x02e7:
            if (r6 == 0) goto L_0x02ea
            goto L_0x033f
        L_0x02ea:
            c.d.a(r12)
            com.google.android.gms.internal.auth.o0.m(r3, r4, r7)
            long r1 = r7.f6953b
            throw r13
        L_0x02f3:
            if (r6 != r11) goto L_0x0311
            c.d.a(r12)
            int r1 = com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r2 = r7.f6952a
            int r2 = r2 + r1
            if (r1 < r2) goto L_0x0309
            if (r1 != r2) goto L_0x0304
            goto L_0x0340
        L_0x0304:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0309:
            int r1 = com.google.android.gms.internal.auth.o0.b(r3, r1)
            java.lang.Float.intBitsToFloat(r1)
            throw r13
        L_0x0311:
            if (r6 == r10) goto L_0x0314
            goto L_0x033f
        L_0x0314:
            c.d.a(r12)
            int r1 = com.google.android.gms.internal.auth.o0.b(r16, r17)
            java.lang.Float.intBitsToFloat(r1)
            throw r13
        L_0x031f:
            if (r6 != r11) goto L_0x033d
            c.d.a(r12)
            int r1 = com.google.android.gms.internal.auth.o0.j(r3, r4, r7)
            int r2 = r7.f6952a
            int r2 = r2 + r1
            if (r1 < r2) goto L_0x0335
            if (r1 != r2) goto L_0x0330
            goto L_0x0340
        L_0x0330:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0335:
            long r1 = com.google.android.gms.internal.auth.o0.n(r3, r1)
            java.lang.Double.longBitsToDouble(r1)
            throw r13
        L_0x033d:
            if (r6 == r9) goto L_0x0341
        L_0x033f:
            r1 = r4
        L_0x0340:
            return r1
        L_0x0341:
            c.d.a(r12)
            long r1 = com.google.android.gms.internal.auth.o0.n(r16, r17)
            java.lang.Double.longBitsToDouble(r1)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.n1.y(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.auth.n0):int");
    }

    private final int z(int i10) {
        if (i10 < this.f6960c || i10 > this.f6961d) {
            return -1;
        }
        return C(i10, 0);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x017e, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x023c, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.Object r9) {
        /*
            r8 = this;
            int[] r0 = r8.f6958a
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x0240
            int r3 = r8.E(r1)
            int[] r4 = r8.f6958a
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = D(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x022c;
                case 1: goto L_0x0220;
                case 2: goto L_0x0214;
                case 3: goto L_0x0208;
                case 4: goto L_0x0200;
                case 5: goto L_0x01f4;
                case 6: goto L_0x01ec;
                case 7: goto L_0x01e0;
                case 8: goto L_0x01d2;
                case 9: goto L_0x01c7;
                case 10: goto L_0x01bb;
                case 11: goto L_0x01b3;
                case 12: goto L_0x01ab;
                case 13: goto L_0x01a3;
                case 14: goto L_0x0197;
                case 15: goto L_0x018f;
                case 16: goto L_0x0183;
                case 17: goto L_0x0174;
                case 18: goto L_0x0168;
                case 19: goto L_0x0168;
                case 20: goto L_0x0168;
                case 21: goto L_0x0168;
                case 22: goto L_0x0168;
                case 23: goto L_0x0168;
                case 24: goto L_0x0168;
                case 25: goto L_0x0168;
                case 26: goto L_0x0168;
                case 27: goto L_0x0168;
                case 28: goto L_0x0168;
                case 29: goto L_0x0168;
                case 30: goto L_0x0168;
                case 31: goto L_0x0168;
                case 32: goto L_0x0168;
                case 33: goto L_0x0168;
                case 34: goto L_0x0168;
                case 35: goto L_0x0168;
                case 36: goto L_0x0168;
                case 37: goto L_0x0168;
                case 38: goto L_0x0168;
                case 39: goto L_0x0168;
                case 40: goto L_0x0168;
                case 41: goto L_0x0168;
                case 42: goto L_0x0168;
                case 43: goto L_0x0168;
                case 44: goto L_0x0168;
                case 45: goto L_0x0168;
                case 46: goto L_0x0168;
                case 47: goto L_0x0168;
                case 48: goto L_0x0168;
                case 49: goto L_0x0168;
                case 50: goto L_0x015c;
                case 51: goto L_0x0140;
                case 52: goto L_0x0128;
                case 53: goto L_0x0116;
                case 54: goto L_0x0104;
                case 55: goto L_0x00f6;
                case 56: goto L_0x00e4;
                case 57: goto L_0x00d6;
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
            goto L_0x023c
        L_0x001f:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.p2.f(r9, r5)
            int r3 = r3.hashCode()
        L_0x002f:
            int r2 = r2 + r3
            goto L_0x023c
        L_0x0032:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            long r3 = F(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x002f
        L_0x0043:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            int r3 = u(r9, r5)
            goto L_0x002f
        L_0x0050:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            long r3 = F(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x002f
        L_0x0061:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            int r3 = u(r9, r5)
            goto L_0x002f
        L_0x006e:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            int r3 = u(r9, r5)
            goto L_0x002f
        L_0x007b:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            int r3 = u(r9, r5)
            goto L_0x002f
        L_0x0088:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.p2.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x002f
        L_0x0099:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.p2.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x002f
        L_0x00aa:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.p2.f(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x002f
        L_0x00be:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.p2.f(r9, r5)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            int r3 = com.google.android.gms.internal.auth.zzez.zza(r3)
            goto L_0x002f
        L_0x00d6:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            int r3 = u(r9, r5)
            goto L_0x002f
        L_0x00e4:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            long r3 = F(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x002f
        L_0x00f6:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            int r3 = u(r9, r5)
            goto L_0x002f
        L_0x0104:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            long r3 = F(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x002f
        L_0x0116:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            long r3 = F(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x002f
        L_0x0128:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.p2.f(r9, r5)
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x002f
        L_0x0140:
            boolean r3 = r8.p(r9, r4, r1)
            if (r3 == 0) goto L_0x023c
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.p2.f(r9, r5)
            java.lang.Double r3 = (java.lang.Double) r3
            double r3 = r3.doubleValue()
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x002f
        L_0x015c:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.p2.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x002f
        L_0x0168:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.p2.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x002f
        L_0x0174:
            java.lang.Object r3 = com.google.android.gms.internal.auth.p2.f(r9, r5)
            if (r3 == 0) goto L_0x017e
            int r7 = r3.hashCode()
        L_0x017e:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x023c
        L_0x0183:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.p2.d(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x002f
        L_0x018f:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.p2.c(r9, r5)
            goto L_0x002f
        L_0x0197:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.p2.d(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x002f
        L_0x01a3:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.p2.c(r9, r5)
            goto L_0x002f
        L_0x01ab:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.p2.c(r9, r5)
            goto L_0x002f
        L_0x01b3:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.p2.c(r9, r5)
            goto L_0x002f
        L_0x01bb:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.p2.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x002f
        L_0x01c7:
            java.lang.Object r3 = com.google.android.gms.internal.auth.p2.f(r9, r5)
            if (r3 == 0) goto L_0x017e
            int r7 = r3.hashCode()
            goto L_0x017e
        L_0x01d2:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.p2.f(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x002f
        L_0x01e0:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.auth.p2.t(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zza(r3)
            goto L_0x002f
        L_0x01ec:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.p2.c(r9, r5)
            goto L_0x002f
        L_0x01f4:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.p2.d(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x002f
        L_0x0200:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.p2.c(r9, r5)
            goto L_0x002f
        L_0x0208:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.p2.d(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x002f
        L_0x0214:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.p2.d(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x002f
        L_0x0220:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.auth.p2.b(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x002f
        L_0x022c:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.auth.p2.a(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x002f
        L_0x023c:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x0240:
            int r2 = r2 * 53
            com.google.android.gms.internal.auth.h2 r0 = r8.f6968k
            java.lang.Object r9 = r0.a(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.n1.a(java.lang.Object):int");
    }

    public final void b(Object obj, byte[] bArr, int i10, int i11, n0 n0Var) {
        if (this.f6963f) {
            x(obj, bArr, i10, i11, n0Var);
        } else {
            q(obj, bArr, i10, i11, 0, n0Var);
        }
    }

    public final void c(Object obj) {
        int i10;
        int i11 = this.f6965h;
        while (true) {
            i10 = this.f6966i;
            if (i11 >= i10) {
                break;
            }
            long E = (long) (E(this.f6964g[i11]) & 1048575);
            Object f10 = p2.f(obj, E);
            if (f10 != null) {
                ((zzfq) f10).zzc();
                p2.p(obj, E, f10);
            }
            i11++;
        }
        int length = this.f6964g.length;
        while (i10 < length) {
            this.f6967j.a(obj, (long) this.f6964g[i10]);
            i10++;
        }
        this.f6968k.e(obj);
    }

    public final void d(Object obj, Object obj2) {
        obj2.getClass();
        for (int i10 = 0; i10 < this.f6958a.length; i10 += 3) {
            int E = E(i10);
            long j10 = (long) (1048575 & E);
            int i11 = this.f6958a[i10];
            switch (D(E)) {
                case 0:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.l(obj, j10, p2.a(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 1:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.m(obj, j10, p2.b(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 2:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.o(obj, j10, p2.d(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 3:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.o(obj, j10, p2.d(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 4:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.n(obj, j10, p2.c(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 5:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.o(obj, j10, p2.d(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 6:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.n(obj, j10, p2.c(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 7:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.k(obj, j10, p2.t(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 8:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.p(obj, j10, p2.f(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 9:
                    h(obj, obj2, i10);
                    break;
                case 10:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.p(obj, j10, p2.f(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 11:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.n(obj, j10, p2.c(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 12:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.n(obj, j10, p2.c(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 13:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.n(obj, j10, p2.c(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 14:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.o(obj, j10, p2.d(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 15:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.n(obj, j10, p2.c(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 16:
                    if (!m(obj2, i10)) {
                        break;
                    } else {
                        p2.o(obj, j10, p2.d(obj2, j10));
                        j(obj, i10);
                        break;
                    }
                case 17:
                    h(obj, obj2, i10);
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
                    this.f6967j.b(obj, obj2, j10);
                    break;
                case 50:
                    x1.i(this.f6971n, obj, obj2, j10);
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
                    if (!p(obj2, i11, i10)) {
                        break;
                    } else {
                        p2.p(obj, j10, p2.f(obj2, j10));
                        k(obj, i11, i10);
                        break;
                    }
                case 60:
                    i(obj, obj2, i10);
                    break;
                case 61:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /*63*/:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH:
                case 66:
                case 67:
                    if (!p(obj2, i11, i10)) {
                        break;
                    } else {
                        p2.p(obj, j10, p2.f(obj2, j10));
                        k(obj, i11, i10);
                        break;
                    }
                case 68:
                    i(obj, obj2, i10);
                    break;
            }
        }
        x1.f(this.f6968k, obj, obj2);
    }

    public final boolean e(Object obj) {
        int i10;
        int i11;
        Object obj2 = obj;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.f6965h) {
            int i15 = this.f6964g[i14];
            int i16 = this.f6958a[i15];
            int E = E(i15);
            int i17 = this.f6958a[i15 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i12) {
                if (i18 != 1048575) {
                    i13 = f6957p.getInt(obj2, (long) i18);
                }
                i10 = i13;
                i11 = i18;
            } else {
                i11 = i12;
                i10 = i13;
            }
            if ((268435456 & E) != 0 && !n(obj, i15, i11, i10, i19)) {
                return false;
            }
            int D = D(E);
            if (D != 9 && D != 17) {
                if (D != 27) {
                    if (D == 60 || D == 68) {
                        if (p(obj2, i16, i15) && !o(obj2, E, H(i15))) {
                            return false;
                        }
                    } else if (D != 49) {
                        if (D == 50 && !((zzfq) p2.f(obj2, (long) (E & 1048575))).isEmpty()) {
                            zzfp zzfp = (zzfp) I(i15);
                            throw null;
                        }
                    }
                }
                List list = (List) p2.f(obj2, (long) (E & 1048575));
                if (!list.isEmpty()) {
                    v1 H = H(i15);
                    for (int i20 = 0; i20 < list.size(); i20++) {
                        if (!H.e(list.get(i20))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (n(obj, i15, i11, i10, i19) && !o(obj2, E, H(i15))) {
                return false;
            }
            i14++;
            i12 = i11;
            i13 = i10;
        }
        return true;
    }

    public final boolean f(Object obj, Object obj2) {
        boolean z10;
        int length = this.f6958a.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int E = E(i10);
            long j10 = (long) (E & 1048575);
            switch (D(E)) {
                case 0:
                    if (l(obj, obj2, i10) && Double.doubleToLongBits(p2.a(obj, j10)) == Double.doubleToLongBits(p2.a(obj2, j10))) {
                        continue;
                    }
                case 1:
                    if (l(obj, obj2, i10) && Float.floatToIntBits(p2.b(obj, j10)) == Float.floatToIntBits(p2.b(obj2, j10))) {
                        continue;
                    }
                case 2:
                    if (l(obj, obj2, i10) && p2.d(obj, j10) == p2.d(obj2, j10)) {
                        continue;
                    }
                case 3:
                    if (l(obj, obj2, i10) && p2.d(obj, j10) == p2.d(obj2, j10)) {
                        continue;
                    }
                case 4:
                    if (l(obj, obj2, i10) && p2.c(obj, j10) == p2.c(obj2, j10)) {
                        continue;
                    }
                case 5:
                    if (l(obj, obj2, i10) && p2.d(obj, j10) == p2.d(obj2, j10)) {
                        continue;
                    }
                case 6:
                    if (l(obj, obj2, i10) && p2.c(obj, j10) == p2.c(obj2, j10)) {
                        continue;
                    }
                case 7:
                    if (l(obj, obj2, i10) && p2.t(obj, j10) == p2.t(obj2, j10)) {
                        continue;
                    }
                case 8:
                    if (l(obj, obj2, i10) && x1.h(p2.f(obj, j10), p2.f(obj2, j10))) {
                        continue;
                    }
                case 9:
                    if (l(obj, obj2, i10) && x1.h(p2.f(obj, j10), p2.f(obj2, j10))) {
                        continue;
                    }
                case 10:
                    if (l(obj, obj2, i10) && x1.h(p2.f(obj, j10), p2.f(obj2, j10))) {
                        continue;
                    }
                case 11:
                    if (l(obj, obj2, i10) && p2.c(obj, j10) == p2.c(obj2, j10)) {
                        continue;
                    }
                case 12:
                    if (l(obj, obj2, i10) && p2.c(obj, j10) == p2.c(obj2, j10)) {
                        continue;
                    }
                case 13:
                    if (l(obj, obj2, i10) && p2.c(obj, j10) == p2.c(obj2, j10)) {
                        continue;
                    }
                case 14:
                    if (l(obj, obj2, i10) && p2.d(obj, j10) == p2.d(obj2, j10)) {
                        continue;
                    }
                case 15:
                    if (l(obj, obj2, i10) && p2.c(obj, j10) == p2.c(obj2, j10)) {
                        continue;
                    }
                case 16:
                    if (l(obj, obj2, i10) && p2.d(obj, j10) == p2.d(obj2, j10)) {
                        continue;
                    }
                case 17:
                    if (l(obj, obj2, i10) && x1.h(p2.f(obj, j10), p2.f(obj2, j10))) {
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
                    z10 = x1.h(p2.f(obj, j10), p2.f(obj2, j10));
                    break;
                case 50:
                    z10 = x1.h(p2.f(obj, j10), p2.f(obj2, j10));
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
                    long B = (long) (B(i10) & 1048575);
                    if (p2.c(obj, B) == p2.c(obj2, B) && x1.h(p2.f(obj, j10), p2.f(obj2, j10))) {
                        continue;
                    }
            }
            if (!z10) {
                return false;
            }
        }
        if (!this.f6968k.a(obj).equals(this.f6968k.a(obj2))) {
            return false;
        }
        return true;
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
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v53, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v58, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x031e, code lost:
        r7 = r36;
        r22 = r6;
        r28 = r10;
        r2 = r11;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x03b8, code lost:
        if (r0 != r15) goto L_0x03ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03d4, code lost:
        r7 = r36;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x03fa, code lost:
        if (r0 != r15) goto L_0x03ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x041d, code lost:
        if (r0 != r15) goto L_0x03ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00eb, code lost:
        r13 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0119, code lost:
        r1 = r13;
        r2 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0146, code lost:
        r5 = r6 | r22;
        r11 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x014a, code lost:
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x014c, code lost:
        r20 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0218, code lost:
        r2 = r6 | r22;
        r11 = r36;
        r3 = r0;
        r0 = r1;
        r1 = r13;
        r6 = r23;
        r13 = r5;
        r5 = r2;
        r2 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0227, code lost:
        r20 = r13;
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x029a, code lost:
        r0 = r11 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x029c, code lost:
        r5 = r6 | r22;
        r11 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02a0, code lost:
        r3 = r13;
        r2 = r17;
        r1 = r20;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int q(java.lang.Object r32, byte[] r33, int r34, int r35, int r36, com.google.android.gms.internal.auth.n0 r37) {
        /*
            r31 = this;
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            r9 = r37
            sun.misc.Unsafe r10 = f6957p
            r16 = 0
            r0 = r34
            r1 = r16
            r3 = r1
            r5 = r3
            r2 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            if (r0 >= r13) goto L_0x044e
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.auth.o0.k(r0, r12, r1, r9)
            int r1 = r9.f6952a
            r4 = r1
            r1 = r0
            goto L_0x002c
        L_0x002b:
            r4 = r0
        L_0x002c:
            int r0 = r4 >>> 3
            r8 = r4 & 7
            r7 = 3
            if (r0 <= r2) goto L_0x003b
            int r3 = r3 / r7
            int r2 = r15.A(r0, r3)
        L_0x0038:
            r3 = r2
            r2 = -1
            goto L_0x0040
        L_0x003b:
            int r2 = r15.z(r0)
            goto L_0x0038
        L_0x0040:
            if (r3 != r2) goto L_0x0051
            r17 = r0
            r19 = r2
            r8 = r4
            r22 = r5
            r28 = r10
            r7 = r11
            r18 = r16
            r2 = r1
            goto L_0x0420
        L_0x0051:
            int[] r2 = r15.f6958a
            int r19 = r3 + 1
            r7 = r2[r19]
            int r11 = D(r7)
            r19 = r1
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r7 & r17
            long r12 = (long) r1
            r1 = 17
            r20 = r4
            if (r11 > r1) goto L_0x032d
            int r1 = r3 + 2
            r1 = r2[r1]
            int r2 = r1 >>> 20
            r4 = 1
            int r22 = r4 << r2
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r2
            if (r1 == r6) goto L_0x0089
            r17 = r3
            if (r6 == r2) goto L_0x0080
            long r2 = (long) r6
            r10.putInt(r14, r2, r5)
        L_0x0080:
            long r2 = (long) r1
            int r2 = r10.getInt(r14, r2)
            r23 = r1
            r6 = r2
            goto L_0x008e
        L_0x0089:
            r17 = r3
            r23 = r6
            r6 = r5
        L_0x008e:
            r1 = 5
            switch(r11) {
                case 0: goto L_0x0301;
                case 1: goto L_0x02e3;
                case 2: goto L_0x02c1;
                case 3: goto L_0x02c1;
                case 4: goto L_0x02a7;
                case 5: goto L_0x0275;
                case 6: goto L_0x0255;
                case 7: goto L_0x022c;
                case 8: goto L_0x01ee;
                case 9: goto L_0x01a5;
                case 10: goto L_0x0188;
                case 11: goto L_0x02a7;
                case 12: goto L_0x014f;
                case 13: goto L_0x0255;
                case 14: goto L_0x0275;
                case 15: goto L_0x0127;
                case 16: goto L_0x00ee;
                default: goto L_0x0092;
            }
        L_0x0092:
            r2 = 3
            if (r8 != r2) goto L_0x00de
            r3 = r17
            com.google.android.gms.internal.auth.v1 r1 = r15.H(r3)
            int r2 = r0 << 3
            r4 = r2 | 4
            r17 = r0
            r0 = r1
            r11 = r19
            r1 = r33
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r2 = r11
            r7 = r3
            r3 = r35
            r8 = r20
            r5 = r37
            int r0 = com.google.android.gms.internal.auth.o0.c(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00c1
            java.lang.Object r1 = r9.f6954c
            r10.putObject(r14, r12, r1)
            goto L_0x00ce
        L_0x00c1:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r9.f6954c
            java.lang.Object r1 = com.google.android.gms.internal.auth.zzez.zzg(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x00ce:
            r5 = r6 | r22
            r12 = r33
            r13 = r35
            r11 = r36
            r3 = r7
            r1 = r8
            r2 = r17
            r6 = r23
            goto L_0x001a
        L_0x00de:
            r7 = r17
            r11 = r19
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r17 = r0
            r12 = r33
        L_0x00eb:
            r13 = r7
            goto L_0x031e
        L_0x00ee:
            r7 = r17
            r11 = r19
            r4 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r17 = r0
            if (r8 != 0) goto L_0x0122
            r2 = r12
            r12 = r33
            int r8 = com.google.android.gms.internal.auth.o0.m(r12, r11, r9)
            long r0 = r9.f6953b
            long r20 = com.google.android.gms.internal.auth.zzei.zzc(r0)
            r0 = r10
            r1 = r32
            r13 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
            r5 = r6 | r22
            r11 = r36
            r3 = r7
            r0 = r8
        L_0x0119:
            r1 = r13
            r2 = r17
        L_0x011c:
            r6 = r23
            r13 = r35
            goto L_0x001a
        L_0x0122:
            r12 = r33
            r20 = r4
            goto L_0x00eb
        L_0x0127:
            r2 = r12
            r7 = r17
            r11 = r19
            r13 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            r17 = r0
            if (r8 != 0) goto L_0x014c
            int r0 = com.google.android.gms.internal.auth.o0.j(r12, r11, r9)
            int r1 = r9.f6952a
            int r1 = com.google.android.gms.internal.auth.zzei.zzb(r1)
            r10.putInt(r14, r2, r1)
        L_0x0146:
            r5 = r6 | r22
            r11 = r36
        L_0x014a:
            r3 = r7
            goto L_0x0119
        L_0x014c:
            r20 = r13
            goto L_0x00eb
        L_0x014f:
            r2 = r12
            r7 = r17
            r11 = r19
            r13 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            r17 = r0
            if (r8 != 0) goto L_0x014c
            int r0 = com.google.android.gms.internal.auth.o0.j(r12, r11, r9)
            int r1 = r9.f6952a
            com.google.android.gms.internal.auth.zzex r4 = r15.G(r7)
            if (r4 == 0) goto L_0x0184
            boolean r4 = r4.zza()
            if (r4 == 0) goto L_0x0174
            goto L_0x0184
        L_0x0174:
            com.google.android.gms.internal.auth.zzgz r2 = r(r32)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzf(r13, r1)
            r11 = r36
            r5 = r6
            goto L_0x014a
        L_0x0184:
            r10.putInt(r14, r2, r1)
            goto L_0x0146
        L_0x0188:
            r2 = r12
            r7 = r17
            r11 = r19
            r13 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            r17 = r0
            r0 = 2
            if (r8 != r0) goto L_0x014c
            int r0 = com.google.android.gms.internal.auth.o0.a(r12, r11, r9)
            java.lang.Object r1 = r9.f6954c
            r10.putObject(r14, r2, r1)
            goto L_0x0146
        L_0x01a5:
            r2 = r12
            r7 = r17
            r11 = r19
            r13 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            r17 = r0
            r0 = 2
            if (r8 != r0) goto L_0x01ea
            com.google.android.gms.internal.auth.v1 r0 = r15.H(r7)
            r5 = r35
            int r0 = com.google.android.gms.internal.auth.o0.d(r0, r12, r11, r5, r9)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x01cc
            java.lang.Object r1 = r9.f6954c
            r10.putObject(r14, r2, r1)
            goto L_0x01d9
        L_0x01cc:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.f6954c
            java.lang.Object r1 = com.google.android.gms.internal.auth.zzez.zzg(r1, r4)
            r10.putObject(r14, r2, r1)
        L_0x01d9:
            r1 = r6 | r22
            r11 = r36
            r3 = r7
            r2 = r17
            r6 = r23
            r29 = r5
            r5 = r1
            r1 = r13
            r13 = r29
            goto L_0x001a
        L_0x01ea:
            r5 = r35
            goto L_0x014c
        L_0x01ee:
            r5 = r35
            r2 = r12
            r11 = r19
            r13 = r20
            r1 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            r29 = r17
            r17 = r0
            r0 = r29
            if (r8 != r1) goto L_0x0227
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            r1 = r1 & r7
            if (r1 != 0) goto L_0x020f
            int r1 = com.google.android.gms.internal.auth.o0.g(r12, r11, r9)
            goto L_0x0213
        L_0x020f:
            int r1 = com.google.android.gms.internal.auth.o0.h(r12, r11, r9)
        L_0x0213:
            java.lang.Object r4 = r9.f6954c
            r10.putObject(r14, r2, r4)
        L_0x0218:
            r2 = r6 | r22
            r11 = r36
            r3 = r0
            r0 = r1
            r1 = r13
            r6 = r23
            r13 = r5
            r5 = r2
            r2 = r17
            goto L_0x001a
        L_0x0227:
            r20 = r13
            r13 = r0
            goto L_0x031e
        L_0x022c:
            r5 = r35
            r2 = r12
            r11 = r19
            r13 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            r29 = r17
            r17 = r0
            r0 = r29
            if (r8 != 0) goto L_0x0227
            int r1 = com.google.android.gms.internal.auth.o0.m(r12, r11, r9)
            long r7 = r9.f6953b
            r20 = 0
            int r7 = (r7 > r20 ? 1 : (r7 == r20 ? 0 : -1))
            if (r7 == 0) goto L_0x024f
            goto L_0x0251
        L_0x024f:
            r4 = r16
        L_0x0251:
            com.google.android.gms.internal.auth.p2.k(r14, r2, r4)
            goto L_0x0218
        L_0x0255:
            r5 = r35
            r2 = r12
            r11 = r19
            r13 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            r29 = r17
            r17 = r0
            r0 = r29
            if (r8 != r1) goto L_0x0227
            int r1 = com.google.android.gms.internal.auth.o0.b(r12, r11)
            r10.putInt(r14, r2, r1)
            int r1 = r11 + 4
            goto L_0x0218
        L_0x0275:
            r5 = r35
            r2 = r12
            r11 = r19
            r13 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            r29 = r17
            r17 = r0
            r0 = r29
            if (r8 != r4) goto L_0x0227
            long r7 = com.google.android.gms.internal.auth.o0.n(r12, r11)
            r4 = r0
            r0 = r10
            r1 = r32
            r20 = r13
            r13 = r4
            r4 = r7
            r0.putLong(r1, r2, r4)
        L_0x029a:
            int r0 = r11 + 8
        L_0x029c:
            r5 = r6 | r22
            r11 = r36
        L_0x02a0:
            r3 = r13
            r2 = r17
            r1 = r20
            goto L_0x011c
        L_0x02a7:
            r2 = r12
            r13 = r17
            r11 = r19
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            r17 = r0
            if (r8 != 0) goto L_0x031e
            int r0 = com.google.android.gms.internal.auth.o0.j(r12, r11, r9)
            int r1 = r9.f6952a
            r10.putInt(r14, r2, r1)
            goto L_0x029c
        L_0x02c1:
            r2 = r12
            r13 = r17
            r11 = r19
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            r17 = r0
            if (r8 != 0) goto L_0x031e
            int r7 = com.google.android.gms.internal.auth.o0.m(r12, r11, r9)
            long r4 = r9.f6953b
            r0 = r10
            r1 = r32
            r0.putLong(r1, r2, r4)
            r5 = r6 | r22
            r11 = r36
            r0 = r7
            goto L_0x02a0
        L_0x02e3:
            r2 = r12
            r13 = r17
            r11 = r19
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            r17 = r0
            if (r8 != r1) goto L_0x031e
            int r0 = com.google.android.gms.internal.auth.o0.b(r12, r11)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.auth.p2.m(r14, r2, r0)
            int r0 = r11 + 4
            goto L_0x029c
        L_0x0301:
            r2 = r12
            r13 = r17
            r11 = r19
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r12 = r33
            r17 = r0
            if (r8 != r4) goto L_0x031e
            long r0 = com.google.android.gms.internal.auth.o0.n(r12, r11)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.auth.p2.l(r14, r2, r0)
            goto L_0x029a
        L_0x031e:
            r7 = r36
            r22 = r6
            r28 = r10
            r2 = r11
            r18 = r13
        L_0x0327:
            r8 = r20
            r6 = r23
            goto L_0x0420
        L_0x032d:
            r17 = r0
            r4 = r19
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = -1
            r29 = r12
            r12 = r33
            r13 = r3
            r2 = r29
            r0 = 27
            if (r11 != r0) goto L_0x038c
            r0 = 2
            if (r8 != r0) goto L_0x0381
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.auth.zzey r0 = (com.google.android.gms.internal.auth.zzey) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0361
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0359
            r1 = 10
            goto L_0x035a
        L_0x0359:
            int r1 = r1 + r1
        L_0x035a:
            com.google.android.gms.internal.auth.zzey r0 = r0.zzd(r1)
            r10.putObject(r14, r2, r0)
        L_0x0361:
            r7 = r0
            com.google.android.gms.internal.auth.v1 r0 = r15.H(r13)
            r1 = r20
            r2 = r33
            r3 = r4
            r4 = r35
            r22 = r5
            r5 = r7
            r23 = r6
            r6 = r37
            int r0 = com.google.android.gms.internal.auth.o0.e(r0, r1, r2, r3, r4, r5, r6)
            r11 = r36
            r3 = r13
            r2 = r17
            r5 = r22
            goto L_0x011c
        L_0x0381:
            r22 = r5
            r23 = r6
            r15 = r4
            r28 = r10
            r18 = r13
            goto L_0x03fd
        L_0x038c:
            r22 = r5
            r23 = r6
            r0 = 49
            if (r11 > r0) goto L_0x03d9
            long r6 = (long) r7
            r0 = r31
            r1 = r32
            r24 = r2
            r2 = r33
            r3 = r4
            r5 = r4
            r4 = r35
            r15 = r5
            r5 = r20
            r26 = r6
            r6 = r17
            r7 = r8
            r8 = r13
            r28 = r10
            r9 = r26
            r18 = r13
            r12 = r24
            r14 = r37
            int r0 = r0.y(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x03d4
        L_0x03ba:
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            r9 = r37
            r2 = r17
            r3 = r18
            r1 = r20
            r5 = r22
            r6 = r23
        L_0x03d0:
            r10 = r28
            goto L_0x001a
        L_0x03d4:
            r7 = r36
            r2 = r0
            goto L_0x0327
        L_0x03d9:
            r24 = r2
            r15 = r4
            r28 = r10
            r18 = r13
            r0 = 50
            if (r11 != r0) goto L_0x0402
            r0 = 2
            if (r8 != r0) goto L_0x03fd
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r18
            r6 = r24
            r8 = r37
            int r0 = r0.v(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x03d4
            goto L_0x03ba
        L_0x03fd:
            r7 = r36
            r2 = r15
            goto L_0x0327
        L_0x0402:
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r20
            r6 = r17
            r9 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            r10 = r24
            r12 = r18
            r13 = r37
            int r0 = r0.w(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x03d4
            goto L_0x03ba
        L_0x0420:
            if (r8 != r7) goto L_0x042c
            if (r7 == 0) goto L_0x042c
            r0 = r2
            r1 = r8
            r5 = r22
        L_0x0428:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0456
        L_0x042c:
            com.google.android.gms.internal.auth.zzgz r4 = r(r32)
            r0 = r8
            r1 = r33
            r3 = r35
            r5 = r37
            int r0 = com.google.android.gms.internal.auth.o0.i(r0, r1, r2, r3, r4, r5)
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r9 = r37
            r11 = r7
            r1 = r8
            r2 = r17
            r3 = r18
            r5 = r22
            goto L_0x03d0
        L_0x044e:
            r22 = r5
            r23 = r6
            r28 = r10
            r7 = r11
            goto L_0x0428
        L_0x0456:
            if (r6 == r2) goto L_0x0463
            long r3 = (long) r6
            r6 = r32
            r8 = r28
            r8.putInt(r6, r3, r5)
        L_0x0460:
            r3 = r31
            goto L_0x0466
        L_0x0463:
            r6 = r32
            goto L_0x0460
        L_0x0466:
            int r4 = r3.f6965h
        L_0x0468:
            int r5 = r3.f6966i
            if (r4 >= r5) goto L_0x0494
            int[] r5 = r3.f6964g
            r5 = r5[r4]
            int[] r8 = r3.f6958a
            r8 = r8[r5]
            int r8 = r3.E(r5)
            r8 = r8 & r2
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.auth.p2.f(r6, r8)
            if (r8 != 0) goto L_0x0481
            goto L_0x0487
        L_0x0481:
            com.google.android.gms.internal.auth.zzex r9 = r3.G(r5)
            if (r9 != 0) goto L_0x048a
        L_0x0487:
            int r4 = r4 + 1
            goto L_0x0468
        L_0x048a:
            com.google.android.gms.internal.auth.zzfq r8 = (com.google.android.gms.internal.auth.zzfq) r8
            java.lang.Object r0 = r3.I(r5)
            com.google.android.gms.internal.auth.zzfp r0 = (com.google.android.gms.internal.auth.zzfp) r0
            r0 = 0
            throw r0
        L_0x0494:
            if (r7 != 0) goto L_0x04a0
            r2 = r35
            if (r0 != r2) goto L_0x049b
            goto L_0x04a6
        L_0x049b:
            com.google.android.gms.internal.auth.zzfa r0 = com.google.android.gms.internal.auth.zzfa.zzd()
            throw r0
        L_0x04a0:
            r2 = r35
            if (r0 > r2) goto L_0x04a7
            if (r1 != r7) goto L_0x04a7
        L_0x04a6:
            return r0
        L_0x04a7:
            com.google.android.gms.internal.auth.zzfa r0 = com.google.android.gms.internal.auth.zzfa.zzd()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.n1.q(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.n0):int");
    }

    public final Object zzd() {
        return ((zzeu) this.f6962e).zzi(4, (Object) null, (Object) null);
    }
}
