package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ServiceCompat {
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_Q = 255;
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U = 1073745919;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StopForegroundFlags {
    }

    static class a {
        @DoNotInline
        static void a(Service service, int i10) {
            service.stopForeground(i10);
        }
    }

    static class b {
        @DoNotInline
        static void a(Service service, int i10, Notification notification, int i11) {
            if (i11 == 0 || i11 == -1) {
                service.startForeground(i10, notification, i11);
            } else {
                service.startForeground(i10, notification, i11 & 255);
            }
        }
    }

    static class c {
        @DoNotInline
        static void a(Service service, int i10, Notification notification, int i11) {
            if (i11 == 0 || i11 == -1) {
                service.startForeground(i10, notification, i11);
            } else {
                service.startForeground(i10, notification, i11 & ServiceCompat.FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U);
            }
        }
    }

    private ServiceCompat() {
    }

    public static void startForeground(@NonNull Service service, int i10, @NonNull Notification notification, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 34) {
            c.a(service, i10, notification, i11);
        } else if (i12 >= 29) {
            b.a(service, i10, notification, i11);
        } else {
            service.startForeground(i10, notification);
        }
    }

    public static void stopForeground(@NonNull Service service, int i10) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.a(service, i10);
            return;
        }
        boolean z10 = true;
        if ((i10 & 1) == 0) {
            z10 = false;
        }
        service.stopForeground(z10);
    }
}
