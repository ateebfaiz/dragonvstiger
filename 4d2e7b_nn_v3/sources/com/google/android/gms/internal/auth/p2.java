package com.google.android.gms.internal.auth;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

abstract class p2 {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f6981a;

    /* renamed from: b  reason: collision with root package name */
    private static final Class f6982b = m0.a();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f6983c;

    /* renamed from: d  reason: collision with root package name */
    private static final o2 f6984d;

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f6985e;

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f6986f;

    /* renamed from: g  reason: collision with root package name */
    static final boolean f6987g;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0129  */
    static {
        /*
            r0 = 3
            r1 = 2
            r2 = 0
            r3 = 1
            java.lang.Class<java.lang.Class> r4 = java.lang.Class.class
            sun.misc.Unsafe r5 = g()
            f6981a = r5
            java.lang.Class r6 = com.google.android.gms.internal.auth.m0.a()
            f6982b = r6
            java.lang.Class r6 = java.lang.Long.TYPE
            boolean r7 = s(r6)
            f6983c = r7
            java.lang.Class r8 = java.lang.Integer.TYPE
            boolean r8 = s(r8)
            r9 = 0
            if (r5 != 0) goto L_0x0024
            goto L_0x0033
        L_0x0024:
            if (r7 == 0) goto L_0x002c
            com.google.android.gms.internal.auth.n2 r9 = new com.google.android.gms.internal.auth.n2
            r9.<init>(r5)
            goto L_0x0033
        L_0x002c:
            if (r8 == 0) goto L_0x0033
            com.google.android.gms.internal.auth.m2 r9 = new com.google.android.gms.internal.auth.m2
            r9.<init>(r5)
        L_0x0033:
            f6984d = r9
            java.lang.String r5 = "getLong"
            java.lang.String r7 = "objectFieldOffset"
            java.lang.Class<java.lang.reflect.Field> r8 = java.lang.reflect.Field.class
            java.lang.Class<java.lang.Object> r10 = java.lang.Object.class
            if (r9 != 0) goto L_0x0041
        L_0x003f:
            r6 = r2
            goto L_0x0065
        L_0x0041:
            sun.misc.Unsafe r9 = r9.f6976a
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x0060 }
            java.lang.Class[] r11 = new java.lang.Class[r3]     // Catch:{ all -> 0x0060 }
            r11[r2] = r8     // Catch:{ all -> 0x0060 }
            r9.getMethod(r7, r11)     // Catch:{ all -> 0x0060 }
            java.lang.Class[] r11 = new java.lang.Class[r1]     // Catch:{ all -> 0x0060 }
            r11[r2] = r10     // Catch:{ all -> 0x0060 }
            r11[r3] = r6     // Catch:{ all -> 0x0060 }
            r9.getMethod(r5, r11)     // Catch:{ all -> 0x0060 }
            java.lang.reflect.Field r6 = y()     // Catch:{ all -> 0x0060 }
            if (r6 != 0) goto L_0x005e
            goto L_0x003f
        L_0x005e:
            r6 = r3
            goto L_0x0065
        L_0x0060:
            r6 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.auth.p2.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r6.toString()))
            goto L_0x003f
        L_0x0065:
            f6985e = r6
            com.google.android.gms.internal.auth.o2 r6 = f6984d
            if (r6 != 0) goto L_0x006d
        L_0x006b:
            r0 = r2
            goto L_0x00dd
        L_0x006d:
            sun.misc.Unsafe r6 = r6.f6976a
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
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.auth.p2.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r0.toString()))
            goto L_0x006b
        L_0x00dd:
            f6986f = r0
            java.lang.Class<byte[]> r0 = byte[].class
            w(r0)
            java.lang.Class<boolean[]> r0 = boolean[].class
            w(r0)
            x(r0)
            java.lang.Class<int[]> r0 = int[].class
            w(r0)
            x(r0)
            java.lang.Class<long[]> r0 = long[].class
            w(r0)
            x(r0)
            java.lang.Class<float[]> r0 = float[].class
            w(r0)
            x(r0)
            java.lang.Class<double[]> r0 = double[].class
            w(r0)
            x(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            w(r0)
            x(r0)
            java.lang.reflect.Field r0 = y()
            if (r0 == 0) goto L_0x0121
            com.google.android.gms.internal.auth.o2 r1 = f6984d
            if (r1 == 0) goto L_0x0121
            r1.k(r0)
        L_0x0121:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x012a
            r2 = r3
        L_0x012a:
            f6987g = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.p2.<clinit>():void");
    }

    static double a(Object obj, long j10) {
        return f6984d.a(obj, j10);
    }

    static float b(Object obj, long j10) {
        return f6984d.b(obj, j10);
    }

    static int c(Object obj, long j10) {
        return f6984d.i(obj, j10);
    }

    static long d(Object obj, long j10) {
        return f6984d.j(obj, j10);
    }

    static Object e(Class cls) {
        try {
            return f6981a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    static Object f(Object obj, long j10) {
        return f6984d.l(obj, j10);
    }

    static Unsafe g() {
        try {
            return (Unsafe) AccessController.doPrivileged(new l2());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ void i(Object obj, long j10, boolean z10) {
        long j11 = -4 & j10;
        o2 o2Var = f6984d;
        int i10 = o2Var.i(obj, j11);
        int i11 = ((~((int) j10)) & 3) << 3;
        o2Var.m(obj, j11, ((z10 ? 1 : 0) << i11) | ((~(255 << i11)) & i10));
    }

    static /* synthetic */ void j(Object obj, long j10, boolean z10) {
        long j11 = -4 & j10;
        o2 o2Var = f6984d;
        int i10 = o2Var.i(obj, j11);
        int i11 = (((int) j10) & 3) << 3;
        o2Var.m(obj, j11, ((z10 ? 1 : 0) << i11) | ((~(255 << i11)) & i10));
    }

    static void k(Object obj, long j10, boolean z10) {
        f6984d.c(obj, j10, z10);
    }

    static void l(Object obj, long j10, double d10) {
        f6984d.d(obj, j10, d10);
    }

    static void m(Object obj, long j10, float f10) {
        f6984d.e(obj, j10, f10);
    }

    static void n(Object obj, long j10, int i10) {
        f6984d.m(obj, j10, i10);
    }

    static void o(Object obj, long j10, long j11) {
        f6984d.n(obj, j10, j11);
    }

    static void p(Object obj, long j10, Object obj2) {
        f6984d.o(obj, j10, obj2);
    }

    static /* bridge */ /* synthetic */ boolean q(Object obj, long j10) {
        if (((byte) ((f6984d.i(obj, -4 & j10) >>> ((int) (((~j10) & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    static /* bridge */ /* synthetic */ boolean r(Object obj, long j10) {
        if (((byte) ((f6984d.i(obj, -4 & j10) >>> ((int) ((j10 & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    static boolean s(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        int i10 = m0.f6950a;
        try {
            Class cls3 = f6982b;
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

    static boolean t(Object obj, long j10) {
        return f6984d.f(obj, j10);
    }

    static boolean u() {
        return f6986f;
    }

    static boolean v() {
        return f6985e;
    }

    private static int w(Class cls) {
        if (f6986f) {
            return f6984d.g(cls);
        }
        return -1;
    }

    private static int x(Class cls) {
        if (f6986f) {
            return f6984d.h(cls);
        }
        return -1;
    }

    private static Field y() {
        int i10 = m0.f6950a;
        Class<Buffer> cls = Buffer.class;
        Field z10 = z(cls, "effectiveDirectAddress");
        if (z10 != null) {
            return z10;
        }
        Field z11 = z(cls, "address");
        if (z11 == null || z11.getType() != Long.TYPE) {
            return null;
        }
        return z11;
    }

    private static Field z(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
