package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.CommonNotificationBuilder;
import com.google.firebase.messaging.Constants;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class c {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f9221a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f9222b;

    /* renamed from: c  reason: collision with root package name */
    private final NotificationParams f9223c;

    public c(Context context, NotificationParams notificationParams, ExecutorService executorService) {
        this.f9221a = executorService;
        this.f9222b = context;
        this.f9223c = notificationParams;
    }

    private boolean b() {
        if (((KeyguardManager) this.f9222b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!PlatformVersion.isAtLeastLollipop()) {
            SystemClock.sleep(10);
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f9222b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                if (next.importance == 100) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private void c(CommonNotificationBuilder.DisplayNotificationInfo displayNotificationInfo) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, "Showing notification");
        }
        ((NotificationManager) this.f9222b.getSystemService("notification")).notify(displayNotificationInfo.tag, displayNotificationInfo.f9196id, displayNotificationInfo.notificationBuilder.build());
    }

    private ImageDownload d() {
        ImageDownload create = ImageDownload.create(this.f9223c.getString(Constants.MessageNotificationKeys.IMAGE_URL));
        if (create != null) {
            create.start(this.f9221a);
        }
        return create;
    }

    private void e(NotificationCompat.Builder builder, ImageDownload imageDownload) {
        if (imageDownload != null) {
            try {
                Bitmap bitmap = (Bitmap) Tasks.await(imageDownload.getTask(), 5, TimeUnit.SECONDS);
                builder.setLargeIcon(bitmap);
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon((Bitmap) null));
            } catch (ExecutionException e10) {
                Log.w(Constants.TAG, "Failed to download image: " + e10.getCause());
            } catch (InterruptedException unused) {
                Log.w(Constants.TAG, "Interrupted while downloading image, showing notification without it");
                imageDownload.close();
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                Log.w(Constants.TAG, "Failed to download image in time, showing notification without it");
                imageDownload.close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        if (this.f9223c.getBoolean(Constants.MessageNotificationKeys.NO_UI)) {
            return true;
        }
        if (b()) {
            return false;
        }
        ImageDownload d10 = d();
        CommonNotificationBuilder.DisplayNotificationInfo createNotificationInfo = CommonNotificationBuilder.createNotificationInfo(this.f9222b, this.f9223c);
        e(createNotificationInfo.notificationBuilder, d10);
        c(createNotificationInfo);
        return true;
    }
}
