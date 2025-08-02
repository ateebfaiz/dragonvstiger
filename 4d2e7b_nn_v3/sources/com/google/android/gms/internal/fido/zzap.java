package com.google.android.gms.internal.fido;

import com.google.firebase.analytics.FirebaseAnalytics;

public final class zzap {
    public static int zza(int i10, int i11, String str) {
        String str2;
        if (i10 >= 0 && i10 < i11) {
            return i10;
        }
        if (i10 < 0) {
            str2 = zzaq.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i10));
        } else if (i11 < 0) {
            throw new IllegalArgumentException("negative size: " + i11);
        } else {
            str2 = zzaq.zza("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IndexOutOfBoundsException(str2);
    }

    public static int zzb(int i10, int i11, String str) {
        if (i10 >= 0 && i10 <= i11) {
            return i10;
        }
        throw new IndexOutOfBoundsException(zzf(i10, i11, FirebaseAnalytics.Param.INDEX));
    }

    public static void zzc(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzd(boolean z10, String str, char c10) {
        if (!z10) {
            throw new IllegalArgumentException(zzaq.zza(str, Character.valueOf(c10)));
        }
    }

    public static void zze(int i10, int i11, int i12) {
        String str;
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            if (i10 < 0 || i10 > i12) {
                str = zzf(i10, i12, "start index");
            } else if (i11 < 0 || i11 > i12) {
                str = zzf(i11, i12, "end index");
            } else {
                str = zzaq.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    private static String zzf(int i10, int i11, String str) {
        if (i10 < 0) {
            return zzaq.zza("%s (%s) must not be negative", str, Integer.valueOf(i10));
        } else if (i11 >= 0) {
            return zzaq.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        } else {
            throw new IllegalArgumentException("negative size: " + i11);
        }
    }
}
