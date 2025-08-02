package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    static class a {
        @DoNotInline
        static <T> T a(Context context, Class<T> cls) {
            return context.getSystemService(cls);
        }

        @DoNotInline
        static int b(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOp(str, str2);
        }

        @DoNotInline
        static int c(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }

        @DoNotInline
        static String d(String str) {
            return AppOpsManager.permissionToOp(str);
        }
    }

    static class b {
        @DoNotInline
        static int a(@Nullable AppOpsManager appOpsManager, @NonNull String str, int i10, @NonNull String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i10, str2);
        }

        @DoNotInline
        @NonNull
        static String b(@NonNull Context context) {
            return context.getOpPackageName();
        }

        @DoNotInline
        @Nullable
        static AppOpsManager c(@NonNull Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    private AppOpsManagerCompat() {
    }

    public static int checkOrNoteProxyOp(@NonNull Context context, int i10, @NonNull String str, @NonNull String str2) {
        if (Build.VERSION.SDK_INT < 29) {
            return noteProxyOpNoThrow(context, str, str2);
        }
        AppOpsManager c10 = b.c(context);
        int a10 = b.a(c10, str, Binder.getCallingUid(), str2);
        if (a10 != 0) {
            return a10;
        }
        return b.a(c10, str, i10, b.b(context));
    }

    public static int noteOp(@NonNull Context context, @NonNull String str, int i10, @NonNull String str2) {
        return ((AppOpsManager) context.getSystemService("appops")).noteOp(str, i10, str2);
    }

    public static int noteOpNoThrow(@NonNull Context context, @NonNull String str, int i10, @NonNull String str2) {
        return ((AppOpsManager) context.getSystemService("appops")).noteOpNoThrow(str, i10, str2);
    }

    public static int noteProxyOp(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return a.b((AppOpsManager) a.a(context, AppOpsManager.class), str, str2);
    }

    public static int noteProxyOpNoThrow(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return a.c((AppOpsManager) a.a(context, AppOpsManager.class), str, str2);
    }

    @Nullable
    public static String permissionToOp(@NonNull String str) {
        return a.d(str);
    }
}
