package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;

public final class zzec {
    protected static final AtomicReference zza = new AtomicReference();
    protected static final AtomicReference zzb = new AtomicReference();
    protected static final AtomicReference zzc = new AtomicReference();
    private final zzeb zzd;

    public zzec(zzeb zzeb) {
        this.zzd = zzeb;
    }

    private static final String zzg(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        boolean z10;
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        if (strArr.length == strArr2.length) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        for (int i10 = 0; i10 < strArr.length; i10++) {
            String str3 = strArr[i10];
            if (str == str3 || str.equals(str3)) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i10];
                        if (str2 == null) {
                            str2 = strArr2[i10] + "(" + strArr[i10] + ")";
                            strArr3[i10] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final String zza(Object[] objArr) {
        String str;
        if (objArr == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (Bundle bundle : objArr) {
            if (bundle instanceof Bundle) {
                str = zzb(bundle);
            } else {
                str = String.valueOf(bundle);
            }
            if (str != null) {
                if (sb2.length() != 1) {
                    sb2.append(", ");
                }
                sb2.append(str);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public final String zzb(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return bundle.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Bundle[{");
        for (String next : bundle.keySet()) {
            if (sb2.length() != 8) {
                sb2.append(", ");
            }
            sb2.append(zze(next));
            sb2.append("=");
            Object obj = bundle.get(next);
            if (obj instanceof Bundle) {
                str = zza(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                str = zza((Object[]) obj);
            } else if (obj instanceof ArrayList) {
                str = zza(((ArrayList) obj).toArray());
            } else {
                str = String.valueOf(obj);
            }
            sb2.append(str);
        }
        sb2.append("}]");
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public final String zzc(zzaw zzaw) {
        String str;
        if (!this.zzd.zza()) {
            return zzaw.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("origin=");
        sb2.append(zzaw.zzc);
        sb2.append(",name=");
        sb2.append(zzd(zzaw.zza));
        sb2.append(",params=");
        zzau zzau = zzaw.zzb;
        if (zzau == null) {
            str = null;
        } else if (!this.zzd.zza()) {
            str = zzau.toString();
        } else {
            str = zzb(zzau.zzc());
        }
        sb2.append(str);
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public final String zzd(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        return zzg(str, zzgo.zzc, zzgo.zza, zza);
    }

    /* access modifiers changed from: protected */
    public final String zze(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        return zzg(str, zzgp.zzb, zzgp.zza, zzb);
    }

    /* access modifiers changed from: protected */
    public final String zzf(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zzg(str, zzgq.zzb, zzgq.zza, zzc);
        }
        return "experiment_id(" + str + ")";
    }
}
