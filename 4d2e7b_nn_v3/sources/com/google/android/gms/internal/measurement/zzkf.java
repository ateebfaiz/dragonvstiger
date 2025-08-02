package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzkf;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzkf<MessageType extends zzkf<MessageType, BuilderType>, BuilderType extends zzkb<MessageType, BuilderType>> extends zzio<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    protected zzmp zzc = zzmp.zzc();
    private int zzd = -1;

    private final int zza(w3 w3Var) {
        if (w3Var == null) {
            return t3.a().b(getClass()).a(this);
        }
        return w3Var.a(this);
    }

    protected static zzkk zzbB() {
        return b3.c();
    }

    protected static zzkl zzbC() {
        return f3.a();
    }

    protected static zzkl zzbD(zzkl zzkl) {
        int i10;
        int size = zzkl.size();
        if (size == 0) {
            i10 = 10;
        } else {
            i10 = size + size;
        }
        return zzkl.zze(i10);
    }

    protected static zzkm zzbE() {
        return u3.a();
    }

    protected static zzkm zzbF(zzkm zzkm) {
        int i10;
        int size = zzkm.size();
        if (size == 0) {
            i10 = 10;
        } else {
            i10 = size + size;
        }
        return zzkm.zzd(i10);
    }

    static Object zzbH(Method method, Object obj, Object... objArr) {
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

    protected static Object zzbI(zzlm zzlm, String str, Object[] objArr) {
        return new v3(zzlm, str, objArr);
    }

    protected static void zzbL(Class cls, zzkf zzkf) {
        zza.put(cls, zzkf);
        zzkf.zzbJ();
    }

    static zzkf zzbz(Class cls) {
        Map map = zza;
        zzkf zzkf = (zzkf) map.get(cls);
        if (zzkf == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzkf = (zzkf) map.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (zzkf == null) {
            zzkf = (zzkf) ((zzkf) r4.j(cls)).zzl(6, (Object) null, (Object) null);
            if (zzkf != null) {
                map.put(cls, zzkf);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzkf;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return t3.a().b(getClass()).h(this, (zzkf) obj);
        }
        return false;
    }

    public final int hashCode() {
        if (zzbO()) {
            return zzbv();
        }
        int i10 = this.zzb;
        if (i10 != 0) {
            return i10;
        }
        int zzbv = zzbv();
        this.zzb = zzbv;
        return zzbv;
    }

    public final String toString() {
        return n3.a(this, super.toString());
    }

    /* access modifiers changed from: package-private */
    public final zzkf zzbA() {
        return (zzkf) zzl(4, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzll zzbG() {
        return (zzkb) zzl(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final void zzbJ() {
        t3.a().b(getClass()).b(this);
        zzbK();
    }

    /* access modifiers changed from: package-private */
    public final void zzbK() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final void zzbM(int i10) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final void zzbN(zzjm zzjm) throws IOException {
        t3.a().b(getClass()).f(this, t2.K(zzjm));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbO() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final /* synthetic */ zzlm zzbS() {
        return (zzkf) zzl(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zzbr(w3 w3Var) {
        if (zzbO()) {
            int zza2 = zza(w3Var);
            if (zza2 >= 0) {
                return zza2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
        }
        int i10 = this.zzd & Integer.MAX_VALUE;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        int zza3 = zza(w3Var);
        if (zza3 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza3;
            return zza3;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza3);
    }

    /* access modifiers changed from: package-private */
    public final int zzbv() {
        return t3.a().b(getClass()).d(this);
    }

    public final int zzbw() {
        int i10;
        if (zzbO()) {
            i10 = zza((w3) null);
            if (i10 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i10);
            }
        } else {
            i10 = this.zzd & Integer.MAX_VALUE;
            if (i10 == Integer.MAX_VALUE) {
                i10 = zza((w3) null);
                if (i10 >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i10;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i10);
                }
            }
        }
        return i10;
    }

    /* access modifiers changed from: protected */
    public final zzkb zzbx() {
        return (zzkb) zzl(5, (Object) null, (Object) null);
    }

    public final zzkb zzby() {
        zzkb zzkb = (zzkb) zzl(5, (Object) null, (Object) null);
        zzkb.zzaA(this);
        return zzkb;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzl(int i10, Object obj, Object obj2);
}
