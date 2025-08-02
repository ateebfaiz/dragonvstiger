package com.appsflyer.internal;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.PurchaseHandler;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.AFc1oSDK;
import com.zing.zalo.zalosdk.common.Constant;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AFd1kSDK extends AFd1iSDK<String> {
    private final AFc1ySDK AFLogger$LogLevel;
    @Nullable
    private final PurchaseHandler.PurchaseValidationCallback afErrorLogForExcManagerOnly;
    private final AFc1zSDK afRDLog;
    @NonNull
    private final Map<String, Object> afWarnLog;

    public AFd1kSDK(@NonNull AFd1rSDK aFd1rSDK, @NonNull AFd1rSDK[] aFd1rSDKArr, @NonNull AFc1vSDK aFc1vSDK, @Nullable String str, Map<String, Object> map, @Nullable PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        super(aFd1rSDK, aFd1rSDKArr, aFc1vSDK, str);
        String str2;
        String str3;
        AFc1zSDK values = aFc1vSDK.values();
        this.afRDLog = values;
        AFc1ySDK afInfoLog = aFc1vSDK.afInfoLog();
        this.AFLogger$LogLevel = afInfoLog;
        HashMap hashMap = new HashMap(new HashMap(map));
        hashMap.put(Constant.PARAM_APP_ID, values.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName());
        String values2 = AFc1zSDK.values();
        if (values2 != null) {
            hashMap.put("cuid", values2);
        }
        Context context = values.AFKeystoreWrapper.AFKeystoreWrapper;
        hashMap.put("app_version_name", AFa1cSDK.values(context, context.getPackageName()));
        HashMap hashMap2 = new HashMap();
        AFc1oSDK.AFa1xSDK values3 = AFa1bSDK.values(values.AFKeystoreWrapper.AFKeystoreWrapper, (Map<String, Object>) new HashMap());
        String str4 = null;
        if (values3 != null) {
            str2 = values3.AFInAppEventParameterName;
        } else {
            str2 = null;
        }
        if (!AFb1mSDK.valueOf(str2)) {
            hashMap2.put("advertising_id", str2);
        }
        AFc1oSDK.AFa1xSDK values4 = AFa1bSDK.values(values.AFKeystoreWrapper.AFKeystoreWrapper.getContentResolver());
        if (values4 != null) {
            str3 = values4.AFInAppEventParameterName;
        } else {
            str3 = null;
        }
        if (!AFb1mSDK.valueOf(str3)) {
            hashMap2.put("oaid", str3);
        }
        AFc1oSDK.AFa1xSDK values5 = AFa1bSDK.values(values.AFKeystoreWrapper.AFKeystoreWrapper.getContentResolver());
        str4 = values5 != null ? values5.AFInAppEventParameterName : str4;
        if (!AFb1mSDK.valueOf(str4)) {
            hashMap2.put("amazon_aid", str4);
        }
        if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            String values6 = this.afDebugLog.values(afInfoLog);
            if (!AFb1mSDK.valueOf(values6)) {
                hashMap2.put("imei", values6);
            }
        }
        hashMap2.put("appsflyer_id", AFb1wSDK.AFKeystoreWrapper(new WeakReference(values.AFKeystoreWrapper.AFKeystoreWrapper)));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Build.VERSION.SDK_INT);
        hashMap2.put("os_version", sb2.toString());
        hashMap2.put("sdk_version", AFb1xSDK.AFKeystoreWrapper);
        hashMap.put("device_data", hashMap2);
        this.afWarnLog = hashMap;
        this.afErrorLogForExcManagerOnly = purchaseValidationCallback;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean afRDLog() {
        return true;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final Map<String, Object> afWarnLog() {
        return this.afWarnLog;
    }

    public final void values() {
        PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback;
        PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback2;
        super.values();
        Throwable afInfoLog = afInfoLog();
        if (!(afInfoLog == null || (purchaseValidationCallback2 = this.afErrorLogForExcManagerOnly) == null)) {
            purchaseValidationCallback2.onFailure(afInfoLog);
        }
        AFd1zSDK<Result> aFd1zSDK = this.afErrorLog;
        if (aFd1zSDK != null && (purchaseValidationCallback = this.afErrorLogForExcManagerOnly) != null) {
            purchaseValidationCallback.onResponse(aFd1zSDK);
        }
    }
}
