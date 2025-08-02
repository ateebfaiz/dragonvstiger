package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.adjust.sdk.Constants;
import com.appsflyer.internal.AFb1xSDK;

public class MultipleInstallBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent != null) {
            try {
                str = intent.getStringExtra(Constants.REFERRER);
            } catch (Throwable th) {
                AFLogger.afErrorLog("error in BroadcastReceiver ", th);
                str = null;
            }
            if (str == null || AFb1xSDK.AFKeystoreWrapper(context).getString(Constants.REFERRER, (String) null) == null) {
                AFLogger.afInfoLog("MultipleInstallBroadcastReceiver called");
                AFb1xSDK.AFInAppEventType().AFInAppEventParameterName(context, intent);
                for (ResolveInfo next : context.getPackageManager().queryBroadcastReceivers(new Intent("com.android.vending.INSTALL_REFERRER"), 0)) {
                    String action = intent.getAction();
                    if (next.activityInfo.packageName.equals(context.getPackageName()) && "com.android.vending.INSTALL_REFERRER".equals(action) && !getClass().getName().equals(next.activityInfo.name)) {
                        StringBuilder sb2 = new StringBuilder("trigger onReceive: class: ");
                        sb2.append(next.activityInfo.name);
                        AFLogger.afInfoLog(sb2.toString());
                        try {
                            ((BroadcastReceiver) Class.forName(next.activityInfo.name).newInstance()).onReceive(context, intent);
                        } catch (Throwable th2) {
                            StringBuilder sb3 = new StringBuilder("error in BroadcastReceiver ");
                            sb3.append(next.activityInfo.name);
                            AFLogger.afErrorLog(sb3.toString(), th2);
                        }
                    }
                }
                return;
            }
            AFb1xSDK.AFInAppEventType().valueOf(context, str);
        }
    }
}
