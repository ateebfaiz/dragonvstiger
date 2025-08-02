package d2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.h;
import com.engagelab.privates.push.api.NotificationMessage;
import s1.a;

public abstract class g {
    public static String a(Context context, boolean z10, NotificationMessage notificationMessage) {
        boolean z11;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        String b10 = b(context, z10, notificationMessage);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager.getNotificationChannel(b10) != null) {
            return b10;
        }
        String d10 = d(context, z10, notificationMessage);
        int c10 = c(context, z10, notificationMessage);
        NotificationChannel a10 = h.a(b10, d10, c10);
        Uri s10 = i.s(context, z10, notificationMessage);
        int f10 = i.f(context, z10, notificationMessage);
        a10.setLockscreenVisibility(i.v(context, z10, notificationMessage));
        a10.setSound(s10, Notification.AUDIO_ATTRIBUTES_DEFAULT);
        boolean z12 = false;
        if ((f10 & 4) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        a10.enableLights(z11);
        if ((f10 & 2) != 0) {
            z12 = true;
        }
        a10.enableVibration(z12);
        notificationManager.createNotificationChannel(a10);
        a.a("NotificationChannelUtil", "build channel channelId:" + b10 + ", channelName:" + d10 + ", channelImportance:" + c10);
        return b10;
    }

    private static String b(Context context, boolean z10, NotificationMessage notificationMessage) {
        if (z10) {
            return "ENGAGELAB_PRIVATES_CHANNEL_low";
        }
        if (!TextUtils.isEmpty(notificationMessage.f())) {
            return notificationMessage.f();
        }
        int s10 = notificationMessage.s();
        if (s10 == -2 || s10 == -1) {
            return "ENGAGELAB_PRIVATES_CHANNEL_low";
        }
        if (s10 == 1 || s10 == 2) {
            if (TextUtils.isEmpty(notificationMessage.u())) {
                return "ENGAGELAB_PRIVATES_CHANNEL_high_" + notificationMessage.h();
            }
            return "ENGAGELAB_PRIVATES_CHANNEL_high_" + notificationMessage.h() + "_" + notificationMessage.u();
        } else if (TextUtils.isEmpty(notificationMessage.u())) {
            return "ENGAGELAB_PRIVATES_CHANNEL_default_" + notificationMessage.h();
        } else {
            return "ENGAGELAB_PRIVATES_CHANNEL_default_" + notificationMessage.h() + "_" + notificationMessage.u();
        }
    }

    private static int c(Context context, boolean z10, NotificationMessage notificationMessage) {
        int s10;
        if (Build.VERSION.SDK_INT < 24) {
            return 0;
        }
        if (z10 || (s10 = notificationMessage.s()) == -2 || s10 == -1) {
            return 2;
        }
        if (s10 == 1 || s10 == 2) {
            return 4;
        }
        return 3;
    }

    private static String d(Context context, boolean z10, NotificationMessage notificationMessage) {
        String str = "ENGAGELAB_PRIVATES_CHANNEL_low";
        if (z10) {
            return context.getString(context.getResources().getIdentifier(str, "string", context.getPackageName()));
        }
        int s10 = notificationMessage.s();
        if (!(s10 == -2 || s10 == -1)) {
            str = (s10 == 1 || s10 == 2) ? "ENGAGELAB_PRIVATES_CHANNEL_high" : "ENGAGELAB_PRIVATES_CHANNEL_default";
        }
        int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
        if (identifier > 0) {
            return context.getString(identifier);
        }
        return "NORMAL";
    }
}
