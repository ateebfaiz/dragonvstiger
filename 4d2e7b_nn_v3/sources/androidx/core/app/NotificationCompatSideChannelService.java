package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.DeprecatedSinceApi;

public abstract class NotificationCompatSideChannelService extends Service {
    public abstract void cancel(String str, int i10, String str2);

    public abstract void cancelAll(String str);

    /* access modifiers changed from: package-private */
    public void checkPermission(int i10, String str) {
        String[] packagesForUid = getPackageManager().getPackagesForUid(i10);
        int length = packagesForUid.length;
        int i11 = 0;
        while (i11 < length) {
            if (!packagesForUid[i11].equals(str)) {
                i11++;
            } else {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + i10 + " is not authorized for package " + str);
    }

    public abstract void notify(String str, int i10, String str2, Notification notification);

    @DeprecatedSinceApi(api = 19, message = "SDKs past 19 have no need for side channeling.")
    public IBinder onBind(Intent intent) {
        intent.getAction().equals(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL);
        return null;
    }
}
