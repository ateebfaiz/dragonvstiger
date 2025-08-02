package com.google.android.gms.internal.fido;

import java.util.Arrays;
import java.util.Set;

public abstract class zzbc extends zzav implements Set {
    private transient zzaz zza;

    zzbc() {
    }

    private static zzbc zzf(int i10, Object... objArr) {
        if (i10 == 0) {
            return s.f7090g;
        }
        if (i10 != 1) {
            int zzh = zzh(i10);
            Object[] objArr2 = new Object[zzh];
            int i11 = zzh - 1;
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                Object obj = objArr[i14];
                zzbq.zza(obj, i14);
                int hashCode = obj.hashCode();
                int a10 = g.a(hashCode);
                while (true) {
                    int i15 = a10 & i11;
                    Object obj2 = objArr2[i15];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        a10++;
                    } else {
                        objArr[i13] = obj;
                        objArr2[i15] = obj;
                        i12 += hashCode;
                        i13++;
                        break;
                    }
                }
            }
            Arrays.fill(objArr, i13, i10, (Object) null);
            if (i13 == 1) {
                Object obj3 = objArr[0];
                obj3.getClass();
                return new w(obj3);
            }
            if (zzh(i13) < zzh / 2) {
                return zzf(i13, objArr);
            }
            if (i13 <= 0) {
                objArr = Arrays.copyOf(objArr, i13);
            }
            return new s(objArr, i12, objArr2, i11, i13);
        }
        Object obj4 = objArr[0];
        obj4.getClass();
        return new w(obj4);
    }

    static int zzh(int i10) {
        int max = Math.max(i10, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (((double) highestOneBit) * 0.7d < ((double) max));
            return highestOneBit;
        } else if (max < 1073741824) {
            return 1073741824;
        } else {
            throw new IllegalArgumentException("collection too large");
        }
    }

    public static zzbc zzk(Object obj, Object obj2) {
        return zzf(2, obj, obj2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzbc) && zzg() && ((zzbc) obj).zzg() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        return zzbx.zza(this);
    }

    /* renamed from: zzd */
    public abstract zzcb iterator();

    /* access modifiers changed from: package-private */
    public boolean zzg() {
        return false;
    }

    public zzaz zzi() {
        zzaz zzaz = this.zza;
        if (zzaz != null) {
            return zzaz;
        }
        zzaz zzj = zzj();
        this.zza = zzj;
        return zzj;
    }

    /* access modifiers changed from: package-private */
    public zzaz zzj() {
        Object[] array = toArray();
        int i10 = zzaz.zzd;
        return zzaz.zzh(array, array.length);
    }
}
