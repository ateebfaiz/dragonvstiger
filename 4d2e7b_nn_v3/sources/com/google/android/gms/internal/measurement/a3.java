package com.google.android.gms.internal.measurement;

final class a3 implements m3 {

    /* renamed from: a  reason: collision with root package name */
    private static final a3 f7116a = new a3();

    private a3() {
    }

    public static a3 c() {
        return f7116a;
    }

    public final l3 a(Class cls) {
        Class<zzkf> cls2 = zzkf.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (l3) zzkf.zzbz(cls.asSubclass(cls2)).zzl(3, (Object) null, (Object) null);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e10);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }

    public final boolean b(Class cls) {
        return zzkf.class.isAssignableFrom(cls);
    }
}
