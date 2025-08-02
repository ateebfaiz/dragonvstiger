package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executors;

public final class PackageManagerCompat {
    @SuppressLint({"ActionValue"})
    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String LOG_TAG = "PackageManagerCompat";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface UnusedAppRestrictionsStatus {
    }

    private static class a {
        static boolean a(Context context) {
            return !context.getPackageManager().isAutoRevokeWhitelisted();
        }
    }

    private PackageManagerCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean areUnusedAppRestrictionsAvailable(@NonNull PackageManager packageManager) {
        boolean z10;
        boolean z11;
        boolean z12;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i10 < 30) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getPermissionRevocationVerifierApp(packageManager) != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z10 || (z11 && z12)) {
            return true;
        }
        return false;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String getPermissionRevocationVerifierApp(@NonNull PackageManager packageManager) {
        String str = null;
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(new Intent(ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", "com.example", (String) null)), 0)) {
            String str2 = resolveInfo.activityInfo.packageName;
            if (packageManager.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", str2) == 0) {
                if (str != null) {
                    return str;
                }
                str = str2;
            }
        }
        return str;
    }

    @NonNull
    public static ListenableFuture<Integer> getUnusedAppRestrictionsStatus(@NonNull Context context) {
        ResolvableFuture create = ResolvableFuture.create();
        if (!UserManagerCompat.isUserUnlocked(context)) {
            create.set(0);
            Log.e(LOG_TAG, "User is in locked direct boot mode");
            return create;
        } else if (!areUnusedAppRestrictionsAvailable(context.getPackageManager())) {
            create.set(1);
            return create;
        } else {
            int i10 = context.getApplicationInfo().targetSdkVersion;
            if (i10 < 30) {
                create.set(0);
                Log.e(LOG_TAG, "Target SDK version below API 30");
                return create;
            }
            int i11 = Build.VERSION.SDK_INT;
            int i12 = 2;
            int i13 = 4;
            if (i11 >= 31) {
                if (a.a(context)) {
                    if (i10 >= 31) {
                        i13 = 5;
                    }
                    create.set(Integer.valueOf(i13));
                } else {
                    create.set(2);
                }
                return create;
            } else if (i11 == 30) {
                if (a.a(context)) {
                    i12 = 4;
                }
                create.set(Integer.valueOf(i12));
                return create;
            } else {
                w wVar = new w(context);
                create.addListener(new v(wVar), Executors.newSingleThreadExecutor());
                wVar.a(create);
                return create;
            }
        }
    }
}
