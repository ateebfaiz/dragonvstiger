package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import java.util.ArrayList;
import java.util.List;

public final class AFf1jSDK {
    private final List<AFf1kSDK> valueOf = new ArrayList();

    @NonNull
    public final synchronized AFf1kSDK[] AFInAppEventParameterName() {
        return (AFf1kSDK[]) this.valueOf.toArray(new AFf1kSDK[0]);
    }

    public final synchronized void AFKeystoreWrapper(AFf1kSDK aFf1kSDK) {
        this.valueOf.add(aFf1kSDK);
    }

    public final void valueOf(Context context, Runnable runnable, AFc1vSDK aFc1vSDK) {
        List<ResolveInfo> queryIntentContentProviders = context.getPackageManager().queryIntentContentProviders(new Intent("com.appsflyer.referrer.INSTALL_PROVIDER"), 0);
        if (queryIntentContentProviders != null && !queryIntentContentProviders.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (ResolveInfo resolveInfo : queryIntentContentProviders) {
                ProviderInfo providerInfo = resolveInfo.providerInfo;
                if (providerInfo != null) {
                    arrayList.add(new AFf1lSDK(providerInfo, runnable, aFc1vSDK));
                } else {
                    AFLogger.afWarnLog("[Preinstall]: com.appsflyer.referrer.INSTALL_PROVIDER Action is set for non ContentProvider component");
                }
            }
            if (!arrayList.isEmpty()) {
                this.valueOf.addAll(arrayList);
                StringBuilder sb2 = new StringBuilder("[Preinstall]: Detected ");
                sb2.append(arrayList.size());
                sb2.append(" valid preinstall provider(s)");
                AFLogger.afDebugLog(sb2.toString());
            }
        }
    }
}
