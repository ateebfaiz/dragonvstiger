package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.google.android.games.paddleboat.GameControllerManager;

public final class zzhp {
    static volatile zzig zza = zzig.zzc();
    private static final Object zzb = new Object();

    public static boolean zza(Context context, Uri uri) {
        int i10;
        String authority = uri.getAuthority();
        boolean z10 = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            Log.e("PhenotypeClientHelper", String.valueOf(authority).concat(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."));
            return false;
        } else if (zza.zzb()) {
            return ((Boolean) zza.zza()).booleanValue();
        } else {
            synchronized (zzb) {
                try {
                    if (zza.zzb()) {
                        boolean booleanValue = ((Boolean) zza.zza()).booleanValue();
                        return booleanValue;
                    }
                    if (!"com.google.android.gms".equals(context.getPackageName())) {
                        PackageManager packageManager = context.getPackageManager();
                        if (Build.VERSION.SDK_INT < 29) {
                            i10 = 0;
                        } else {
                            i10 = GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR;
                        }
                        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider("com.google.android.gms.phenotype", i10);
                        if (resolveContentProvider != null) {
                            if (!"com.google.android.gms".equals(resolveContentProvider.packageName)) {
                            }
                        }
                        zza = zzig.zzd(Boolean.valueOf(z10));
                        return ((Boolean) zza.zza()).booleanValue();
                    }
                    try {
                        if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0) {
                            z10 = true;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                    zza = zzig.zzd(Boolean.valueOf(z10));
                    return ((Boolean) zza.zza()).booleanValue();
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }
}
