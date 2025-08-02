package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzes;
import com.google.android.gms.internal.auth.zzeu;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzeu<MessageType extends zzeu<MessageType, BuilderType>, BuilderType extends zzes<MessageType, BuilderType>> extends zzdp<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzgz zzc = zzgz.zza();

    static zzeu zza(Class cls) {
        Map map = zzb;
        zzeu zzeu = (zzeu) map.get(cls);
        if (zzeu == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzeu = (zzeu) map.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (zzeu == null) {
            zzeu = (zzeu) ((zzeu) p2.e(cls)).zzi(6, (Object) null, (Object) null);
            if (zzeu != null) {
                map.put(cls, zzeu);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzeu;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        if (r1 != false) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static com.google.android.gms.internal.auth.zzeu zzb(com.google.android.gms.internal.auth.zzeu r3, byte[] r4) throws com.google.android.gms.internal.auth.zzfa {
        /*
            int r0 = r4.length
            com.google.android.gms.internal.auth.zzek r1 = com.google.android.gms.internal.auth.zzek.zza
            r2 = 0
            com.google.android.gms.internal.auth.zzeu r3 = zzj(r3, r4, r2, r0, r1)
            if (r3 == 0) goto L_0x0044
            r4 = 1
            r0 = 0
            java.lang.Object r1 = r3.zzi(r4, r0, r0)
            java.lang.Byte r1 = (java.lang.Byte) r1
            byte r1 = r1.byteValue()
            if (r1 != r4) goto L_0x0019
            goto L_0x0044
        L_0x0019:
            if (r1 == 0) goto L_0x0037
            com.google.android.gms.internal.auth.s1 r1 = com.google.android.gms.internal.auth.s1.a()
            java.lang.Class r2 = r3.getClass()
            com.google.android.gms.internal.auth.v1 r1 = r1.b(r2)
            boolean r1 = r1.e(r3)
            if (r4 == r1) goto L_0x002f
            r4 = r0
            goto L_0x0030
        L_0x002f:
            r4 = r3
        L_0x0030:
            r2 = 2
            r3.zzi(r2, r4, r0)
            if (r1 == 0) goto L_0x0037
            goto L_0x0044
        L_0x0037:
            com.google.android.gms.internal.auth.zzgx r4 = new com.google.android.gms.internal.auth.zzgx
            r4.<init>(r3)
            com.google.android.gms.internal.auth.zzfa r4 = r4.zza()
            r4.zze(r3)
            throw r4
        L_0x0044:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzeu.zzb(com.google.android.gms.internal.auth.zzeu, byte[]):com.google.android.gms.internal.auth.zzeu");
    }

    protected static zzey zzc() {
        return t1.a();
    }

    static Object zze(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Object zzf(zzfw zzfw, String str, Object[] objArr) {
        return new u1(zzfw, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", objArr);
    }

    protected static void zzg(Class cls, zzeu zzeu) {
        zzb.put(cls, zzeu);
    }

    private static zzeu zzj(zzeu zzeu, byte[] bArr, int i10, int i11, zzek zzek) throws zzfa {
        zzeu zzeu2 = (zzeu) zzeu.zzi(4, (Object) null, (Object) null);
        try {
            v1 b10 = s1.a().b(zzeu2.getClass());
            b10.b(zzeu2, bArr, 0, i11, new n0(zzek));
            b10.c(zzeu2);
            if (zzeu2.zza == 0) {
                return zzeu2;
            }
            throw new RuntimeException();
        } catch (zzfa e10) {
            e10.zze(zzeu2);
            throw e10;
        } catch (zzgx e11) {
            zzfa zza = e11.zza();
            zza.zze(zzeu2);
            throw zza;
        } catch (IOException e12) {
            if (e12.getCause() instanceof zzfa) {
                throw ((zzfa) e12.getCause());
            }
            zzfa zzfa = new zzfa(e12);
            zzfa.zze(zzeu2);
            throw zzfa;
        } catch (IndexOutOfBoundsException unused) {
            zzfa zzf = zzfa.zzf();
            zzf.zze(zzeu2);
            throw zzf;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return s1.a().b(getClass()).f(this, (zzeu) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.zza;
        if (i10 != 0) {
            return i10;
        }
        int a10 = s1.a().b(getClass()).a(this);
        this.zza = a10;
        return a10;
    }

    public final String toString() {
        return m1.a(this, super.toString());
    }

    public final /* synthetic */ zzfv zzd() {
        zzes zzes = (zzes) zzi(5, (Object) null, (Object) null);
        zzes.zze(this);
        return zzes;
    }

    public final /* synthetic */ zzfw zzh() {
        return (zzeu) zzi(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object zzi(int i10, Object obj, Object obj2);
}
