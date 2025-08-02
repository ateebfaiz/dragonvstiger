package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

abstract class a {

    /* renamed from: androidx.profileinstaller.a$a  reason: collision with other inner class name */
    private static class C0205a {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    private static class b {
        static File a(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    static boolean a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            boolean z10 = true;
            for (File a10 : listFiles) {
                if (!a(a10) || !z10) {
                    z10 = false;
                } else {
                    z10 = true;
                }
            }
            return z10;
        }
        file.delete();
        return true;
    }

    static void b(Context context, ProfileInstallReceiver.a aVar) {
        File file;
        if (Build.VERSION.SDK_INT >= 24) {
            file = b.a(context);
        } else {
            file = C0205a.a(context);
        }
        if (a(file)) {
            aVar.onResultReceived(14, (Object) null);
        } else {
            aVar.onResultReceived(15, (Object) null);
        }
    }
}
