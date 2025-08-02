package com.engagelab.privates.common.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.core.api.WakeMessage;
import com.engagelab.privates.push.api.AliasMessage;
import com.engagelab.privates.push.api.CustomMessage;
import com.engagelab.privates.push.api.MobileNumberMessage;
import com.engagelab.privates.push.api.NotificationMessage;
import com.engagelab.privates.push.api.PlatformTokenMessage;
import com.engagelab.privates.push.api.TagMessage;
import h1.a;

public class MTCommonReceiver extends BroadcastReceiver {
    private static final String TAG = "MTCommonReceiver";

    public void onAliasMessage(Context context, AliasMessage aliasMessage) {
    }

    public void onConnectStatus(Context context, boolean z10) {
    }

    public void onCustomMessage(Context context, CustomMessage customMessage) {
    }

    public void onMobileNumber(Context context, MobileNumberMessage mobileNumberMessage) {
    }

    public void onNotificationArrived(Context context, NotificationMessage notificationMessage) {
    }

    public void onNotificationClicked(Context context, NotificationMessage notificationMessage) {
    }

    public void onNotificationDeleted(Context context, NotificationMessage notificationMessage) {
    }

    public void onNotificationStatus(Context context, boolean z10) {
    }

    public void onPlatformToken(Context context, PlatformTokenMessage platformTokenMessage) {
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            if (TextUtils.equals(action, "android.net.conn.CONNECTIVITY_CHANGE")) {
                a.i(context.getApplicationContext(), 1007, extras);
                return;
            }
            a.i(context.getApplicationContext(), Integer.parseInt(action), extras);
        } catch (Throwable th) {
            s1.a.h(TAG, "onReceiver failed " + th.getMessage());
        }
    }

    public void onTagMessage(Context context, TagMessage tagMessage) {
    }

    public void onWake(Context context, WakeMessage wakeMessage) {
    }
}
