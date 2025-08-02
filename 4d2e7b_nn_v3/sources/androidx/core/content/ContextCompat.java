package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.LocaleManagerCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class ContextCompat {
    private static final String DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    public static final int RECEIVER_VISIBLE_TO_INSTANT_APPS = 1;
    private static final String TAG = "ContextCompat";
    private static final Object sSync = new Object();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RegisterReceiverFlags {
    }

    static class a {
        @DoNotInline
        static File a(Context context) {
            return context.getCodeCacheDir();
        }

        @DoNotInline
        static Drawable b(Context context, int i10) {
            return context.getDrawable(i10);
        }

        @DoNotInline
        static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    static class b {
        @DoNotInline
        static int a(Context context, int i10) {
            return context.getColor(i10);
        }

        @DoNotInline
        static <T> T b(Context context, Class<T> cls) {
            return context.getSystemService(cls);
        }

        @DoNotInline
        static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    static class c {
        @DoNotInline
        static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        @DoNotInline
        static File b(Context context) {
            return context.getDataDir();
        }

        @DoNotInline
        static boolean c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    static class d {
        @DoNotInline
        static Intent a(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i10) {
            if ((i10 & 4) != 0 && str == null) {
                return context.registerReceiver(broadcastReceiver, intentFilter, ContextCompat.obtainAndCheckReceiverPermission(context), handler);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i10 & 1);
        }

        @DoNotInline
        static ComponentName b(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    static class e {
        @DoNotInline
        static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    static class f {
        @DoNotInline
        @NonNull
        static Context a(@NonNull Context context, @Nullable String str) {
            return context.createAttributionContext(str);
        }

        @DoNotInline
        static String b(Context context) {
            return context.getAttributionTag();
        }

        @DoNotInline
        static Display c(Context context) {
            try {
                return context.getDisplay();
            } catch (UnsupportedOperationException unused) {
                Log.w(ContextCompat.TAG, "The context:" + context + " is not associated with any display. Return a fallback display instead.");
                return ((DisplayManager) context.getSystemService(DisplayManager.class)).getDisplay(0);
            }
        }
    }

    static class g {
        @DoNotInline
        static Intent a(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i10) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i10);
        }
    }

    protected ContextCompat() {
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        ObjectsCompat.requireNonNull(str, "permission must be non-null");
        if (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            return 0;
        }
        return -1;
    }

    @NonNull
    public static Context createAttributionContext(@NonNull Context context, @Nullable String str) {
        if (Build.VERSION.SDK_INT >= 30) {
            return f.a(context, str);
        }
        return context;
    }

    @Nullable
    public static Context createDeviceProtectedStorageContext(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return c.a(context);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File createFilesDir(java.io.File r4) {
        /*
            java.lang.Object r0 = sSync
            monitor-enter(r0)
            boolean r1 = r4.exists()     // Catch:{ all -> 0x0011 }
            if (r1 != 0) goto L_0x002d
            boolean r1 = r4.mkdirs()     // Catch:{ all -> 0x0011 }
            if (r1 == 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return r4
        L_0x0011:
            r4 = move-exception
            goto L_0x002f
        L_0x0013:
            java.lang.String r1 = "ContextCompat"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0011 }
            r2.<init>()     // Catch:{ all -> 0x0011 }
            java.lang.String r3 = "Unable to create files subdir "
            r2.append(r3)     // Catch:{ all -> 0x0011 }
            java.lang.String r3 = r4.getPath()     // Catch:{ all -> 0x0011 }
            r2.append(r3)     // Catch:{ all -> 0x0011 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0011 }
            android.util.Log.w(r1, r2)     // Catch:{ all -> 0x0011 }
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return r4
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.ContextCompat.createFilesDir(java.io.File):java.io.File");
    }

    @Nullable
    public static String getAttributionTag(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return f.b(context);
        }
        return null;
    }

    @NonNull
    public static File getCodeCacheDir(@NonNull Context context) {
        return a.a(context);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @ColorRes int i10) {
        return b.a(context, i10);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context context, @ColorRes int i10) {
        return ResourcesCompat.getColorStateList(context.getResources(), i10, context.getTheme());
    }

    @NonNull
    public static Context getContextForLanguage(@NonNull Context context) {
        LocaleListCompat applicationLocales = LocaleManagerCompat.getApplicationLocales(context);
        if (Build.VERSION.SDK_INT > 32 || applicationLocales.isEmpty()) {
            return context;
        }
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        ConfigurationCompat.setLocales(configuration, applicationLocales);
        return context.createConfigurationContext(configuration);
    }

    @Nullable
    public static File getDataDir(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return c.b(context);
        }
        String str = context.getApplicationInfo().dataDir;
        if (str != null) {
            return new File(str);
        }
        return null;
    }

    @NonNull
    public static Display getDisplayOrDefault(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return f.c(context);
        }
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int i10) {
        return a.b(context, i10);
    }

    @NonNull
    public static File[] getExternalCacheDirs(@NonNull Context context) {
        return context.getExternalCacheDirs();
    }

    @NonNull
    public static File[] getExternalFilesDirs(@NonNull Context context, @Nullable String str) {
        return context.getExternalFilesDirs(str);
    }

    @NonNull
    public static Executor getMainExecutor(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return e.a(context);
        }
        return ExecutorCompat.create(new Handler(context.getMainLooper()));
    }

    @Nullable
    public static File getNoBackupFilesDir(@NonNull Context context) {
        return a.c(context);
    }

    @NonNull
    public static File[] getObbDirs(@NonNull Context context) {
        return context.getObbDirs();
    }

    @NonNull
    public static String getString(@NonNull Context context, int i10) {
        return getContextForLanguage(context).getString(i10);
    }

    @Nullable
    public static <T> T getSystemService(@NonNull Context context, @NonNull Class<T> cls) {
        return b.b(context, cls);
    }

    @Nullable
    public static String getSystemServiceName(@NonNull Context context, @NonNull Class<?> cls) {
        return b.c(context, cls);
    }

    public static boolean isDeviceProtectedStorage(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return c.c(context);
        }
        return false;
    }

    static String obtainAndCheckReceiverPermission(Context context) {
        String str = context.getPackageName() + DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX;
        if (PermissionChecker.checkSelfPermission(context, str) == 0) {
            return str;
        }
        throw new RuntimeException("Permission " + str + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    @Nullable
    public static Intent registerReceiver(@NonNull Context context, @Nullable BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter, int i10) {
        return registerReceiver(context, broadcastReceiver, intentFilter, (String) null, (Handler) null, i10);
    }

    public static boolean startActivities(@NonNull Context context, @NonNull Intent[] intentArr) {
        return startActivities(context, intentArr, (Bundle) null);
    }

    public static void startActivity(@NonNull Context context, @NonNull Intent intent, @Nullable Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    public static void startForegroundService(@NonNull Context context, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            d.b(context, intent);
        } else {
            context.startService(intent);
        }
    }

    @Nullable
    public static Intent registerReceiver(@NonNull Context context, @Nullable BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter, @Nullable String str, @Nullable Handler handler, int i10) {
        int i11 = i10 & 1;
        if (i11 == 0 || (i10 & 4) == 0) {
            if (i11 != 0) {
                i10 |= 2;
            }
            int i12 = i10;
            int i13 = i12 & 2;
            if (i13 == 0 && (i12 & 4) == 0) {
                throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
            } else if (i13 == 0 || (i12 & 4) == 0) {
                int i14 = Build.VERSION.SDK_INT;
                if (i14 >= 33) {
                    return g.a(context, broadcastReceiver, intentFilter, str, handler, i12);
                }
                if (i14 >= 26) {
                    return d.a(context, broadcastReceiver, intentFilter, str, handler, i12);
                }
                if ((i12 & 4) == 0 || str != null) {
                    return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
                }
                return context.registerReceiver(broadcastReceiver, intentFilter, obtainAndCheckReceiverPermission(context), handler);
            } else {
                throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
            }
        } else {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
        }
    }

    public static boolean startActivities(@NonNull Context context, @NonNull Intent[] intentArr, @Nullable Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }
}
