package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.google.android.games.paddleboat.GameControllerManager;

public final class AFd1lSDK extends AFd1iSDK<String> {
    @NonNull
    private final String afRDLog;
    @Nullable
    private final AFe1oSDK afWarnLog;

    public AFd1lSDK(@NonNull AFc1vSDK aFc1vSDK, @NonNull String str, @Nullable AFe1oSDK aFe1oSDK) {
        super(AFd1rSDK.IMPRESSIONS, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, str);
        this.afRDLog = str;
        this.afWarnLog = aFe1oSDK;
    }

    /* access modifiers changed from: protected */
    public final AFc1jSDK<String> AFInAppEventType(@NonNull String str) {
        return this.AFLogger.values(this.afRDLog);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean afRDLog() {
        return false;
    }

    public final void values() {
        super.values();
        AFd1zSDK<Result> aFd1zSDK = this.afErrorLog;
        if (aFd1zSDK != null) {
            int statusCode = aFd1zSDK.getStatusCode();
            if (statusCode == 200) {
                StringBuilder sb2 = new StringBuilder("Cross promotion impressions success: ");
                sb2.append(this.afRDLog);
                AFLogger.afInfoLog(sb2.toString(), false);
            } else if (statusCode == 301 || statusCode == 302) {
                StringBuilder sb3 = new StringBuilder("Cross promotion redirection success: ");
                sb3.append(this.afRDLog);
                AFLogger.afInfoLog(sb3.toString(), false);
                String values = aFd1zSDK.values("Location");
                AFe1oSDK aFe1oSDK = this.afWarnLog;
                if (aFe1oSDK != null && values != null) {
                    aFe1oSDK.AFKeystoreWrapper = values;
                    Context context = aFe1oSDK.valueOf.get();
                    if (context != null) {
                        try {
                            if (aFe1oSDK.AFKeystoreWrapper != null) {
                                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(aFe1oSDK.AFKeystoreWrapper)).setFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR));
                            }
                        } catch (Exception e10) {
                            AFLogger.afErrorLog("Failed to open cross promotion url, does OS have browser installed?".concat(String.valueOf(e10)), e10);
                        }
                    }
                }
            } else {
                StringBuilder sb4 = new StringBuilder("call to ");
                sb4.append(this.afRDLog);
                sb4.append(" failed: ");
                sb4.append(statusCode);
                AFLogger.afInfoLog(sb4.toString());
            }
        }
    }
}
