package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.SideEffectFree;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class DeviceProperties {
    @Nullable
    private static Boolean zza;
    @Nullable
    private static Boolean zzb;
    @Nullable
    private static Boolean zzc;
    @Nullable
    private static Boolean zzd;
    @Nullable
    private static Boolean zze;
    @Nullable
    private static Boolean zzf;
    @Nullable
    private static Boolean zzg;
    @Nullable
    private static Boolean zzh;
    @Nullable
    private static Boolean zzi;
    @Nullable
    private static Boolean zzj;
    @Nullable
    private static Boolean zzk;
    @Nullable
    private static Boolean zzl;

    private DeviceProperties() {
    }

    @KeepForSdk
    public static boolean isAuto(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zzi == null) {
            boolean z10 = false;
            if (PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z10 = true;
            }
            zzi = Boolean.valueOf(z10);
        }
        return zzi.booleanValue();
    }

    @KeepForSdk
    public static boolean isBstar(@NonNull Context context) {
        if (zzl == null) {
            boolean z10 = false;
            if (PlatformVersion.isAtLeastR() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
                z10 = true;
            }
            zzl = Boolean.valueOf(z10);
        }
        return zzl.booleanValue();
    }

    @KeepForSdk
    public static boolean isLatchsky(@NonNull Context context) {
        if (zzf == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z10 = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z10 = true;
            }
            zzf = Boolean.valueOf(z10);
        }
        return zzf.booleanValue();
    }

    @KeepForSdk
    public static boolean isPhone(@NonNull Context context) {
        if (zza == null) {
            boolean z10 = false;
            if (!isTablet(context) && !isWearable(context) && !zzb(context)) {
                if (zzh == null) {
                    zzh = Boolean.valueOf(context.getPackageManager().hasSystemFeature("org.chromium.arc"));
                }
                if (!zzh.booleanValue() && !isAuto(context) && !isTv(context)) {
                    if (zzk == null) {
                        zzk = Boolean.valueOf(context.getPackageManager().hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE"));
                    }
                    if (!zzk.booleanValue() && !isBstar(context)) {
                        z10 = true;
                    }
                }
            }
            zza = Boolean.valueOf(z10);
        }
        return zza.booleanValue();
    }

    @KeepForSdk
    public static boolean isSevenInchTablet(@NonNull Context context) {
        return zzc(context.getResources());
    }

    @TargetApi(21)
    @KeepForSdk
    public static boolean isSidewinder(@NonNull Context context) {
        return zza(context);
    }

    @KeepForSdk
    public static boolean isTablet(@NonNull Context context) {
        return isTablet(context.getResources());
    }

    @KeepForSdk
    public static boolean isTv(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zzj == null) {
            boolean z10 = true;
            if (!packageManager.hasSystemFeature("com.google.android.tv") && !packageManager.hasSystemFeature("android.hardware.type.television") && !packageManager.hasSystemFeature("android.software.leanback")) {
                z10 = false;
            }
            zzj = Boolean.valueOf(z10);
        }
        return zzj.booleanValue();
    }

    @KeepForSdk
    public static boolean isUserBuild() {
        int i10 = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return "user".equals(Build.TYPE);
    }

    @SideEffectFree
    @TargetApi(20)
    @KeepForSdk
    public static boolean isWearable(@NonNull Context context) {
        return zzd(context.getPackageManager());
    }

    @TargetApi(26)
    @KeepForSdk
    public static boolean isWearableWithoutPlayStore(@NonNull Context context) {
        if (isWearable(context) && !PlatformVersion.isAtLeastN()) {
            return true;
        }
        if (!zza(context)) {
            return false;
        }
        if (!PlatformVersion.isAtLeastO() || PlatformVersion.isAtLeastR()) {
            return true;
        }
        return false;
    }

    @TargetApi(21)
    public static boolean zza(@NonNull Context context) {
        if (zze == null) {
            boolean z10 = false;
            if (PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z10 = true;
            }
            zze = Boolean.valueOf(z10);
        }
        return zze.booleanValue();
    }

    public static boolean zzb(@NonNull Context context) {
        if (zzg == null) {
            boolean z10 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z10 = false;
            }
            zzg = Boolean.valueOf(z10);
        }
        return zzg.booleanValue();
    }

    public static boolean zzc(@NonNull Resources resources) {
        boolean z10 = false;
        if (resources == null) {
            return false;
        }
        if (zzc == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z10 = true;
            }
            zzc = Boolean.valueOf(z10);
        }
        return zzc.booleanValue();
    }

    @SideEffectFree
    @TargetApi(20)
    public static boolean zzd(@NonNull PackageManager packageManager) {
        if (zzd == null) {
            boolean z10 = false;
            if (PlatformVersion.isAtLeastKitKatWatch() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z10 = true;
            }
            zzd = Boolean.valueOf(z10);
        }
        return zzd.booleanValue();
    }

    @KeepForSdk
    public static boolean isTablet(@NonNull Resources resources) {
        boolean z10 = false;
        if (resources == null) {
            return false;
        }
        if (zzb == null) {
            if ((resources.getConfiguration().screenLayout & 15) > 3 || zzc(resources)) {
                z10 = true;
            }
            zzb = Boolean.valueOf(z10);
        }
        return zzb.booleanValue();
    }
}
