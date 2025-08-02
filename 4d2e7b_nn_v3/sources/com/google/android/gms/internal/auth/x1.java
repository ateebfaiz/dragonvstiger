package com.google.android.gms.internal.auth;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

abstract class x1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Class f7014a;

    /* renamed from: b  reason: collision with root package name */
    private static final h2 f7015b = j(false);

    /* renamed from: c  reason: collision with root package name */
    private static final h2 f7016c = j(true);

    /* renamed from: d  reason: collision with root package name */
    private static final h2 f7017d = new i2();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f7014a = cls;
    }

    public static h2 a() {
        return f7015b;
    }

    public static h2 b() {
        return f7016c;
    }

    public static h2 c() {
        return f7017d;
    }

    static Object d(int i10, List list, zzex zzex, Object obj, h2 h2Var) {
        if (zzex == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                Integer num = (Integer) list.get(i12);
                int intValue = num.intValue();
                if (zzex.zza()) {
                    if (i12 != i11) {
                        list.set(i11, num);
                    }
                    i11++;
                } else {
                    obj = e(i10, intValue, obj, h2Var);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
                return obj;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzex.zza()) {
                    obj = e(i10, intValue2, obj, h2Var);
                    it.remove();
                }
            }
        }
        return obj;
    }

    static Object e(int i10, int i11, Object obj, h2 h2Var) {
        if (obj == null) {
            obj = h2Var.c();
        }
        h2Var.d(obj, i10, (long) i11);
        return obj;
    }

    static void f(h2 h2Var, Object obj, Object obj2) {
        h2Var.f(obj, h2Var.b(h2Var.a(obj), h2Var.a(obj2)));
    }

    public static void g(Class cls) {
        Class cls2;
        if (!zzeu.class.isAssignableFrom(cls) && (cls2 = f7014a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean h(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    static void i(i1 i1Var, Object obj, Object obj2, long j10) {
        p2.p(obj, j10, i1.a(p2.f(obj, j10), p2.f(obj2, j10)));
    }

    private static h2 j(boolean z10) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (h2) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z10)});
        } catch (Throwable unused2) {
            return null;
        }
    }
}
