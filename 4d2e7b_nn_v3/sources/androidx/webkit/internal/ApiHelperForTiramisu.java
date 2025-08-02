package androidx.webkit.internal;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import androidx.annotation.RequiresApi;

@RequiresApi(33)
public class ApiHelperForTiramisu {
    private ApiHelperForTiramisu() {
    }

    static ServiceInfo getServiceInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException {
        return packageManager.getServiceInfo(componentName, componentInfoFlags);
    }

    static PackageManager.ComponentInfoFlags of(long j10) {
        return PackageManager.ComponentInfoFlags.of(j10);
    }
}
