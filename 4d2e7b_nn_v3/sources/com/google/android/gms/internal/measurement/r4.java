package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

abstract class r4 {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f7294a;

    /* renamed from: b  reason: collision with root package name */
    private static final Class f7295b = h2.a();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f7296c;

    /* renamed from: d  reason: collision with root package name */
    private static final q4 f7297d;

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f7298e;

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f7299f;

    /* renamed from: g  reason: collision with root package name */
    static final long f7300g = ((long) E(byte[].class));

    /* renamed from: h  reason: collision with root package name */
    static final boolean f7301h;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x012d  */
    static {
        /*
            r0 = 3
            r1 = 2
            r2 = 0
            r3 = 1
            java.lang.Class<java.lang.Class> r4 = java.lang.Class.class
            sun.misc.Unsafe r5 = l()
            f7294a = r5
            java.lang.Class r6 = com.google.android.gms.internal.measurement.h2.a()
            f7295b = r6
            java.lang.Class r6 = java.lang.Long.TYPE
            boolean r7 = A(r6)
            f7296c = r7
            java.lang.Class r8 = java.lang.Integer.TYPE
            boolean r8 = A(r8)
            r9 = 0
            if (r5 != 0) goto L_0x0024
            goto L_0x0033
        L_0x0024:
            if (r7 == 0) goto L_0x002c
            com.google.android.gms.internal.measurement.p4 r9 = new com.google.android.gms.internal.measurement.p4
            r9.<init>(r5)
            goto L_0x0033
        L_0x002c:
            if (r8 == 0) goto L_0x0033
            com.google.android.gms.internal.measurement.o4 r9 = new com.google.android.gms.internal.measurement.o4
            r9.<init>(r5)
        L_0x0033:
            f7297d = r9
            java.lang.String r5 = "getLong"
            java.lang.String r7 = "objectFieldOffset"
            java.lang.Class<java.lang.reflect.Field> r8 = java.lang.reflect.Field.class
            java.lang.Class<java.lang.Object> r10 = java.lang.Object.class
            if (r9 != 0) goto L_0x0041
        L_0x003f:
            r6 = r2
            goto L_0x0065
        L_0x0041:
            sun.misc.Unsafe r9 = r9.f7276a
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x0060 }
            java.lang.Class[] r11 = new java.lang.Class[r3]     // Catch:{ all -> 0x0060 }
            r11[r2] = r8     // Catch:{ all -> 0x0060 }
            r9.getMethod(r7, r11)     // Catch:{ all -> 0x0060 }
            java.lang.Class[] r11 = new java.lang.Class[r1]     // Catch:{ all -> 0x0060 }
            r11[r2] = r10     // Catch:{ all -> 0x0060 }
            r11[r3] = r6     // Catch:{ all -> 0x0060 }
            r9.getMethod(r5, r11)     // Catch:{ all -> 0x0060 }
            java.lang.reflect.Field r6 = b()     // Catch:{ all -> 0x0060 }
            if (r6 != 0) goto L_0x005e
            goto L_0x003f
        L_0x005e:
            r6 = r3
            goto L_0x0065
        L_0x0060:
            r6 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.measurement.r4.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r6.toString()))
            goto L_0x003f
        L_0x0065:
            f7298e = r6
            com.google.android.gms.internal.measurement.q4 r6 = f7297d
            if (r6 != 0) goto L_0x006d
        L_0x006b:
            r0 = r2
            goto L_0x00dd
        L_0x006d:
            sun.misc.Unsafe r6 = r6.f7276a
            java.lang.Class r6 = r6.getClass()     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch:{ all -> 0x00d8 }
            r9[r2] = r8     // Catch:{ all -> 0x00d8 }
            r6.getMethod(r7, r9)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ all -> 0x00d8 }
            r7[r2] = r4     // Catch:{ all -> 0x00d8 }
            java.lang.String r8 = "arrayBaseOffset"
            r6.getMethod(r8, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ all -> 0x00d8 }
            r7[r2] = r4     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = "arrayIndexScale"
            r6.getMethod(r4, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r7 = new java.lang.Class[r1]     // Catch:{ all -> 0x00d8 }
            r7[r2] = r10     // Catch:{ all -> 0x00d8 }
            r7[r3] = r4     // Catch:{ all -> 0x00d8 }
            java.lang.String r8 = "getInt"
            r6.getMethod(r8, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r7 = new java.lang.Class[r0]     // Catch:{ all -> 0x00d8 }
            r7[r2] = r10     // Catch:{ all -> 0x00d8 }
            r7[r3] = r4     // Catch:{ all -> 0x00d8 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00d8 }
            r7[r1] = r8     // Catch:{ all -> 0x00d8 }
            java.lang.String r8 = "putInt"
            r6.getMethod(r8, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r7 = new java.lang.Class[r1]     // Catch:{ all -> 0x00d8 }
            r7[r2] = r10     // Catch:{ all -> 0x00d8 }
            r7[r3] = r4     // Catch:{ all -> 0x00d8 }
            r6.getMethod(r5, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x00d8 }
            r5[r2] = r10     // Catch:{ all -> 0x00d8 }
            r5[r3] = r4     // Catch:{ all -> 0x00d8 }
            r5[r1] = r4     // Catch:{ all -> 0x00d8 }
            java.lang.String r7 = "putLong"
            r6.getMethod(r7, r5)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ all -> 0x00d8 }
            r5[r2] = r10     // Catch:{ all -> 0x00d8 }
            r5[r3] = r4     // Catch:{ all -> 0x00d8 }
            java.lang.String r7 = "getObject"
            r6.getMethod(r7, r5)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x00d8 }
            r0[r2] = r10     // Catch:{ all -> 0x00d8 }
            r0[r3] = r4     // Catch:{ all -> 0x00d8 }
            r0[r1] = r10     // Catch:{ all -> 0x00d8 }
            java.lang.String r1 = "putObject"
            r6.getMethod(r1, r0)     // Catch:{ all -> 0x00d8 }
            r0 = r3
            goto L_0x00dd
        L_0x00d8:
            r0 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.measurement.r4.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r0.toString()))
            goto L_0x006b
        L_0x00dd:
            f7299f = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = E(r0)
            long r0 = (long) r0
            f7300g = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            E(r0)
            a(r0)
            java.lang.Class<int[]> r0 = int[].class
            E(r0)
            a(r0)
            java.lang.Class<long[]> r0 = long[].class
            E(r0)
            a(r0)
            java.lang.Class<float[]> r0 = float[].class
            E(r0)
            a(r0)
            java.lang.Class<double[]> r0 = double[].class
            E(r0)
            a(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            E(r0)
            a(r0)
            java.lang.reflect.Field r0 = b()
            if (r0 == 0) goto L_0x0125
            com.google.android.gms.internal.measurement.q4 r1 = f7297d
            if (r1 == 0) goto L_0x0125
            r1.l(r0)
        L_0x0125:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x012e
            r2 = r3
        L_0x012e:
            f7301h = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.r4.<clinit>():void");
    }

    static boolean A(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        int i10 = h2.f7184a;
        try {
            Class cls3 = f7295b;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean B(Object obj, long j10) {
        return f7297d.g(obj, j10);
    }

    static boolean C() {
        return f7299f;
    }

    static boolean D() {
        return f7298e;
    }

    private static int E(Class cls) {
        if (f7299f) {
            return f7297d.h(cls);
        }
        return -1;
    }

    private static int a(Class cls) {
        if (f7299f) {
            return f7297d.i(cls);
        }
        return -1;
    }

    private static Field b() {
        int i10 = h2.f7184a;
        Class<Buffer> cls = Buffer.class;
        Field c10 = c(cls, "effectiveDirectAddress");
        if (c10 != null) {
            return c10;
        }
        Field c11 = c(cls, "address");
        if (c11 == null || c11.getType() != Long.TYPE) {
            return null;
        }
        return c11;
    }

    private static Field c(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void d(Object obj, long j10, byte b10) {
        long j11 = -4 & j10;
        q4 q4Var = f7297d;
        int j12 = q4Var.j(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        q4Var.n(obj, j11, ((255 & b10) << i10) | (j12 & (~(255 << i10))));
    }

    /* access modifiers changed from: private */
    public static void e(Object obj, long j10, byte b10) {
        long j11 = -4 & j10;
        q4 q4Var = f7297d;
        int i10 = (((int) j10) & 3) << 3;
        q4Var.n(obj, j11, ((255 & b10) << i10) | (q4Var.j(obj, j11) & (~(255 << i10))));
    }

    static double f(Object obj, long j10) {
        return f7297d.a(obj, j10);
    }

    static float g(Object obj, long j10) {
        return f7297d.b(obj, j10);
    }

    static int h(Object obj, long j10) {
        return f7297d.j(obj, j10);
    }

    static long i(Object obj, long j10) {
        return f7297d.k(obj, j10);
    }

    static Object j(Class cls) {
        try {
            return f7294a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    static Object k(Object obj, long j10) {
        return f7297d.m(obj, j10);
    }

    static Unsafe l() {
        try {
            return (Unsafe) AccessController.doPrivileged(new n4());
        } catch (Throwable unused) {
            return null;
        }
    }

    static void r(Object obj, long j10, boolean z10) {
        f7297d.c(obj, j10, z10);
    }

    static void s(byte[] bArr, long j10, byte b10) {
        f7297d.d(bArr, f7300g + j10, b10);
    }

    static void t(Object obj, long j10, double d10) {
        f7297d.e(obj, j10, d10);
    }

    static void u(Object obj, long j10, float f10) {
        f7297d.f(obj, j10, f10);
    }

    static void v(Object obj, long j10, int i10) {
        f7297d.n(obj, j10, i10);
    }

    static void w(Object obj, long j10, long j11) {
        f7297d.o(obj, j10, j11);
    }

    static void x(Object obj, long j10, Object obj2) {
        f7297d.p(obj, j10, obj2);
    }

    static /* bridge */ /* synthetic */ boolean y(Object obj, long j10) {
        if (((byte) ((f7297d.j(obj, -4 & j10) >>> ((int) (((~j10) & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    static /* bridge */ /* synthetic */ boolean z(Object obj, long j10) {
        if (((byte) ((f7297d.j(obj, -4 & j10) >>> ((int) ((j10 & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }
}
