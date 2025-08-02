package com.google.android.gms.internal.auth;

final class b1 implements l1 {

    /* renamed from: a  reason: collision with root package name */
    private static final b1 f6900a = new b1();

    private b1() {
    }

    public static b1 c() {
        return f6900a;
    }

    public final k1 a(Class cls) {
        Class<zzeu> cls2 = zzeu.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (k1) zzeu.zza(cls.asSubclass(cls2)).zzi(3, (Object) null, (Object) null);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e10);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }

    public final boolean b(Class cls) {
        return zzeu.class.isAssignableFrom(cls);
    }
}
