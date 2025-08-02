package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzeh extends y0 {
    /* access modifiers changed from: private */
    public char zza = 0;
    /* access modifiers changed from: private */
    public long zzb = -1;
    @GuardedBy("this")
    private String zzc;
    private final zzef zzd = new zzef(this, 6, false, false);
    private final zzef zze = new zzef(this, 6, true, false);
    private final zzef zzf = new zzef(this, 6, false, true);
    private final zzef zzg = new zzef(this, 5, false, false);
    private final zzef zzh = new zzef(this, 5, true, false);
    private final zzef zzi = new zzef(this, 5, false, true);
    private final zzef zzj = new zzef(this, 4, false, false);
    private final zzef zzk = new zzef(this, 3, false, false);
    private final zzef zzl = new zzef(this, 2, false, false);

    zzeh(zzfr zzfr) {
        super(zzfr);
    }

    protected static Object zzn(String str) {
        if (str == null) {
            return null;
        }
        return new r(str);
    }

    static String zzo(boolean z10, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String zzp = zzp(z10, obj);
        String zzp2 = zzp(z10, obj2);
        String zzp3 = zzp(z10, obj3);
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(zzp)) {
            sb2.append(str2);
            sb2.append(zzp);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(zzp2)) {
            sb2.append(str2);
            sb2.append(zzp2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(zzp3)) {
            sb2.append(str3);
            sb2.append(zzp3);
        }
        return sb2.toString();
    }

    @VisibleForTesting
    static String zzp(boolean z10, Object obj) {
        String str;
        String className;
        String str2 = "";
        if (obj == null) {
            return str2;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i10 = 0;
        if (obj instanceof Long) {
            if (!z10) {
                return obj.toString();
            }
            Long l10 = (Long) obj;
            if (Math.abs(l10.longValue()) < 100) {
                return obj.toString();
            }
            if (obj.toString().charAt(0) == '-') {
                str2 = "-";
            }
            String valueOf = String.valueOf(Math.abs(l10.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 4.0d);
            return str2 + round + "..." + str2 + round2;
        } else if (obj instanceof Boolean) {
            return obj.toString();
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                if (z10) {
                    str = th.getClass().getName();
                } else {
                    str = th.toString();
                }
                StringBuilder sb2 = new StringBuilder(str);
                String zzy = zzy(zzfr.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i10];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzy(className).equals(zzy)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                    i10++;
                }
                return sb2.toString();
            } else if (obj instanceof r) {
                return ((r) obj).f7689a;
            } else {
                if (z10) {
                    return "-";
                }
                return obj.toString();
            }
        }
    }

    private static String zzy(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public final zzef zzc() {
        return this.zzk;
    }

    public final zzef zzd() {
        return this.zzd;
    }

    public final zzef zze() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }

    public final zzef zzh() {
        return this.zze;
    }

    public final zzef zzi() {
        return this.zzj;
    }

    public final zzef zzj() {
        return this.zzl;
    }

    public final zzef zzk() {
        return this.zzg;
    }

    public final zzef zzl() {
        return this.zzi;
    }

    public final zzef zzm() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    @VisibleForTesting
    public final String zzq() {
        String str;
        synchronized (this) {
            try {
                if (this.zzc == null) {
                    if (this.zzt.zzy() != null) {
                        this.zzc = this.zzt.zzy();
                    } else {
                        this.zzc = this.zzt.zzf().zzn();
                    }
                }
                Preconditions.checkNotNull(this.zzc);
                str = this.zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final void zzt(int i10, boolean z10, boolean z11, String str, Object obj, Object obj2, Object obj3) {
        if (!z10 && Log.isLoggable(zzq(), i10)) {
            Log.println(i10, zzq(), zzo(false, str, obj, obj2, obj3));
        }
        if (!z11 && i10 >= 5) {
            Preconditions.checkNotNull(str);
            zzfo zzo = this.zzt.zzo();
            if (zzo == null) {
                Log.println(6, zzq(), "Scheduler not set. Not logging error/warn");
            } else if (!zzo.zzx()) {
                Log.println(6, zzq(), "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i10 >= 9) {
                    i10 = 8;
                }
                zzo.zzp(new q(this, i10, str, obj, obj2, obj3));
            }
        }
    }
}
