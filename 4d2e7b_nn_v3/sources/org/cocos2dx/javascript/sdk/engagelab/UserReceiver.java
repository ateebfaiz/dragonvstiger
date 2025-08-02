package org.cocos2dx.javascript.sdk.engagelab;

import android.content.Context;
import android.util.Log;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.push.api.CustomMessage;
import com.engagelab.privates.push.api.NotificationMessage;
import com.engagelab.privates.push.api.PlatformTokenMessage;
import w1.a;

public class UserReceiver extends MTCommonReceiver {
    private static final String TAG = "UserReceiver";
    private static final String TAG_SUFFIX = "ENGAGELAB-PRIVATES-APP";

    public void onConnectStatus(Context context, boolean z10) {
        Log.i(TAG, " [ENGAGELAB-PRIVATES-APP] onConnectState:" + z10);
        Global.isConnectEnable = z10;
        if (StatusObserver.getInstance().getListener() != null) {
            StatusObserver.getInstance().getListener().onConnectStatus(z10);
        }
        if (z10) {
            String b10 = a.b(context);
            Log.i(TAG, " [ENGAGELAB-PRIVATES-APP] registrationId:" + b10);
        }
    }

    public void onCustomMessage(Context context, CustomMessage customMessage) {
        Log.i(TAG, " [ENGAGELAB-PRIVATES-APP] onCustomMessage:" + customMessage.toString());
    }

    public void onNotificationArrived(Context context, NotificationMessage notificationMessage) {
        Log.i(TAG, " [ENGAGELAB-PRIVATES-APP] onNotificationArrived:" + notificationMessage.toString());
    }

    public void onNotificationClicked(Context context, NotificationMessage notificationMessage) {
        Log.i(TAG, " [ENGAGELAB-PRIVATES-APP] onNotificationClicked:" + notificationMessage.toString());
    }

    public void onNotificationDeleted(Context context, NotificationMessage notificationMessage) {
        Log.i(TAG, " [ENGAGELAB-PRIVATES-APP] onNotificationDeleted:" + notificationMessage.toString());
    }

    public void onNotificationStatus(Context context, boolean z10) {
        Log.i(TAG, " [ENGAGELAB-PRIVATES-APP] onNotificationStatus:" + z10);
        Global.isNotificationEnable = z10;
        if (StatusObserver.getInstance().getListener() != null) {
            StatusObserver.getInstance().getListener().onNotificationStatus(z10);
        }
    }

    public void onPlatformToken(Context context, PlatformTokenMessage platformTokenMessage) {
        Log.i(TAG, " [ENGAGELAB-PRIVATES-APP] onPlatformToken:" + platformTokenMessage.toString());
    }
}
