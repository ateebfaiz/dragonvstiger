package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

abstract class y3 {

    /* renamed from: a  reason: collision with root package name */
    private static final Class f7363a;

    /* renamed from: b  reason: collision with root package name */
    private static final j4 f7364b = C(false);

    /* renamed from: c  reason: collision with root package name */
    private static final j4 f7365c = C(true);

    /* renamed from: d  reason: collision with root package name */
    private static final j4 f7366d = new k4();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f7363a = cls;
    }

    static int A(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjm.zzA(i10 << 3) + 1);
    }

    static void B(j3 j3Var, Object obj, Object obj2, long j10) {
        r4.x(obj, j10, j3.b(r4.k(obj, j10), r4.k(obj2, j10)));
    }

    private static j4 C(boolean z10) {
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
            return (j4) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z10)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int D(List list) {
        return list.size();
    }

    static int E(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = size * zzjm.zzz(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            zzz += zzjm.zzt((zzje) list.get(i11));
        }
        return zzz;
    }

    static int F(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return G(list) + (size * zzjm.zzz(i10));
    }

    static int G(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof b3) {
            b3 b3Var = (b3) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzv(b3Var.a(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzjm.zzv(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int H(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjm.zzA(i10 << 3) + 4);
    }

    static int I(List list) {
        return list.size() * 4;
    }

    static int J(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjm.zzA(i10 << 3) + 8);
    }

    static int K(List list) {
        return list.size() * 8;
    }

    static int L(int i10, List list, w3 w3Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += zzjm.zzu(i10, (zzlm) list.get(i12), w3Var);
        }
        return i11;
    }

    static int M(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return N(list) + (size * zzjm.zzz(i10));
    }

    static int N(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof b3) {
            b3 b3Var = (b3) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzv(b3Var.a(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzjm.zzv(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int O(int i10, List list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return P(list) + (list.size() * zzjm.zzz(i10));
    }

    static int P(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f3) {
            f3 f3Var = (f3) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzB(f3Var.zza(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzjm.zzB(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    static int Q(int i10, Object obj, w3 w3Var) {
        if (!(obj instanceof zzks)) {
            return zzjm.zzA(i10 << 3) + zzjm.zzx((zzlm) obj, w3Var);
        }
        int zzA = zzjm.zzA(i10 << 3);
        int zza = ((zzks) obj).zza();
        return zzA + zzjm.zzA(zza) + zza;
    }

    static int R(int i10, List list, w3 w3Var) {
        int zzx;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzjm.zzz(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (obj instanceof zzks) {
                zzx = zzjm.zzw((zzks) obj);
            } else {
                zzx = zzjm.zzx((zzlm) obj, w3Var);
            }
            zzz += zzx;
        }
        return zzz;
    }

    static int S(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return T(list) + (size * zzjm.zzz(i10));
    }

    static int T(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof b3) {
            b3 b3Var = (b3) list;
            i10 = 0;
            while (i11 < size) {
                int a10 = b3Var.a(i11);
                i10 += zzjm.zzA((a10 >> 31) ^ (a10 + a10));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                int intValue = ((Integer) list.get(i11)).intValue();
                i12 = i10 + zzjm.zzA((intValue >> 31) ^ (intValue + intValue));
                i11++;
            }
        }
        return i10;
    }

    static int U(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return V(list) + (size * zzjm.zzz(i10));
    }

    static int V(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f3) {
            f3 f3Var = (f3) list;
            i10 = 0;
            while (i11 < size) {
                long zza = f3Var.zza(i11);
                i10 += zzjm.zzB((zza >> 63) ^ (zza + zza));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                long longValue = ((Long) list.get(i11)).longValue();
                i12 = i10 + zzjm.zzB((longValue >> 63) ^ (longValue + longValue));
                i11++;
            }
        }
        return i10;
    }

    static int W(int i10, List list) {
        int zzy;
        int zzy2;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int zzz = zzjm.zzz(i10) * size;
        if (list instanceof zzku) {
            zzku zzku = (zzku) list;
            while (i11 < size) {
                Object zzf = zzku.zzf(i11);
                if (zzf instanceof zzje) {
                    zzy2 = zzjm.zzt((zzje) zzf);
                } else {
                    zzy2 = zzjm.zzy((String) zzf);
                }
                zzz += zzy2;
                i11++;
            }
        } else {
            while (i11 < size) {
                Object obj = list.get(i11);
                if (obj instanceof zzje) {
                    zzy = zzjm.zzt((zzje) obj);
                } else {
                    zzy = zzjm.zzy((String) obj);
                }
                zzz += zzy;
                i11++;
            }
        }
        return zzz;
    }

    static int X(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return Y(list) + (size * zzjm.zzz(i10));
    }

    static int Y(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof b3) {
            b3 b3Var = (b3) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzA(b3Var.a(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzjm.zzA(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int Z(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return a0(list) + (size * zzjm.zzz(i10));
    }

    public static j4 a() {
        return f7365c;
    }

    static int a0(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f3) {
            f3 f3Var = (f3) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzB(f3Var.zza(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzjm.zzB(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static j4 b() {
        return f7366d;
    }

    public static j4 b0() {
        return f7364b;
    }

    static Object c(Object obj, int i10, List list, zzkj zzkj, Object obj2, j4 j4Var) {
        Object obj3 = null;
        if (zzkj == null) {
            return null;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                Integer num = (Integer) list.get(i12);
                int intValue = num.intValue();
                if (zzkj.zza(intValue)) {
                    if (i12 != i11) {
                        list.set(i11, num);
                    }
                    i11++;
                } else {
                    obj3 = d(obj, i10, intValue, obj3, j4Var);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
                return obj3;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzkj.zza(intValue2)) {
                    obj3 = d(obj, i10, intValue2, obj3, j4Var);
                    it.remove();
                }
            }
        }
        return obj3;
    }

    static Object d(Object obj, int i10, int i11, Object obj2, j4 j4Var) {
        if (obj2 == null) {
            obj2 = j4Var.c(obj);
        }
        j4Var.f(obj2, i10, (long) i11);
        return obj2;
    }

    static void e(v2 v2Var, Object obj, Object obj2) {
        v2Var.a(obj2);
        throw null;
    }

    static void f(j4 j4Var, Object obj, Object obj2) {
        j4Var.h(obj, j4Var.e(j4Var.d(obj), j4Var.d(obj2)));
    }

    public static void g(Class cls) {
        Class cls2;
        if (!zzkf.class.isAssignableFrom(cls) && (cls2 = f7363a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void h(int i10, List list, x4 x4Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            x4Var.i(i10, list, z10);
        }
    }

    public static void i(int i10, List list, x4 x4Var) {
        if (list != null && !list.isEmpty()) {
            x4Var.c(i10, list);
        }
    }

    public static void j(int i10, List list, x4 x4Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            x4Var.B(i10, list, z10);
        }
    }

    public static void k(int i10, List list, x4 x4Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            x4Var.q(i10, list, z10);
        }
    }

    public static void l(int i10, List list, x4 x4Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            x4Var.m(i10, list, z10);
        }
    }

    public static void m(int i10, List list, x4 x4Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            x4Var.u(i10, list, z10);
        }
    }

    public static void n(int i10, List list, x4 x4Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            x4Var.E(i10, list, z10);
        }
    }

    public static void o(int i10, List list, x4 x4Var, w3 w3Var) {
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((t2) x4Var).l(i10, list.get(i11), w3Var);
            }
        }
    }

    public static void p(int i10, List list, x4 x4Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            x4Var.o(i10, list, z10);
        }
    }

    public static void q(int i10, List list, x4 x4Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            x4Var.y(i10, list, z10);
        }
    }

    public static void r(int i10, List list, x4 x4Var, w3 w3Var) {
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((t2) x4Var).H(i10, list.get(i11), w3Var);
            }
        }
    }

    public static void s(int i10, List list, x4 x4Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            x4Var.A(i10, list, z10);
        }
    }

    public static void t(int i10, List list, x4 x4Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            x4Var.b(i10, list, z10);
        }
    }

    public static void u(int i10, List list, x4 x4Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            x4Var.x(i10, list, z10);
        }
    }

    public static void v(int i10, List list, x4 x4Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            x4Var.G(i10, list, z10);
        }
    }

    public static void w(int i10, List list, x4 x4Var) {
        if (list != null && !list.isEmpty()) {
            x4Var.s(i10, list);
        }
    }

    public static void x(int i10, List list, x4 x4Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            x4Var.k(i10, list, z10);
        }
    }

    public static void y(int i10, List list, x4 x4Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            x4Var.z(i10, list, z10);
        }
    }

    static boolean z(Object obj, Object obj2) {
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
}
