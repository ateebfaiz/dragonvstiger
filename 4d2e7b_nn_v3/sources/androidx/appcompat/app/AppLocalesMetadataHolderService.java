package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

public final class AppLocalesMetadataHolderService extends Service {

    private static class a {
        @DoNotInline
        static int a() {
            return 512;
        }
    }

    @NonNull
    public static ServiceInfo getServiceInfo(@NonNull Context context) throws PackageManager.NameNotFoundException {
        int i10;
        if (Build.VERSION.SDK_INT >= 24) {
            i10 = a.a() | 128;
        } else {
            i10 = 640;
        }
        return context.getPackageManager().getServiceInfo(new ComponentName(context, AppLocalesMetadataHolderService.class), i10);
    }

    @NonNull
    public IBinder onBind(@NonNull Intent intent) {
        throw new UnsupportedOperationException();
    }
}
