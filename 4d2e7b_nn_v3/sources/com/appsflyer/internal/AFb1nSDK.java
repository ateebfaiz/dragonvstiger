package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Map;
import org.json.JSONException;

public final class AFb1nSDK {
    public final double values;

    public AFb1nSDK() {
    }

    private static void AFInAppEventType(Map<String, String> map) {
        if (AFb1xSDK.AFInAppEventType != null) {
            try {
                StringBuilder sb2 = new StringBuilder("Calling onAppOpenAttribution with:\n");
                sb2.append(map.toString());
                AFLogger.afDebugLog(sb2.toString());
                AFb1xSDK.AFInAppEventType.onAppOpenAttribution(map);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    public static void AFKeystoreWrapper(Map<String, String> map) {
        DeepLinkResult deepLinkResult;
        if (AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().onInstallConversionDataLoadedNative().valueOf != null) {
            try {
                DeepLink values2 = DeepLink.values(map);
                values2.values.put("is_deferred", false);
                deepLinkResult = new DeepLinkResult(values2, (DeepLinkResult.Error) null);
            } catch (JSONException e10) {
                AFLogger.afErrorLog("[DDL] Error occurred", e10, true);
                deepLinkResult = new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.UNEXPECTED);
            } catch (Throwable th) {
                AFInAppEventType(new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null));
                throw th;
            }
            AFInAppEventType(deepLinkResult);
            return;
        }
        AFInAppEventType(map);
    }

    public AFb1nSDK(double d10) {
        this.values = d10;
    }

    private static void AFInAppEventType(String str) {
        if (AFb1xSDK.AFInAppEventType != null) {
            try {
                AFLogger.afDebugLog("Calling onAppOpenAttributionFailure with: ".concat(String.valueOf(str)));
                AFb1xSDK.AFInAppEventType.onAttributionFailure(str);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    public static void AFInAppEventType(String str, DeepLinkResult.Error error) {
        if (AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().onInstallConversionDataLoadedNative().valueOf != null) {
            AFLogger.afDebugLog("[DDL] Error occurred: ".concat(String.valueOf(str)));
            AFInAppEventType(new DeepLinkResult((DeepLink) null, error));
            return;
        }
        AFInAppEventType(str);
    }

    static void AFInAppEventType(DeepLinkResult deepLinkResult) {
        AFa1tSDK onInstallConversionDataLoadedNative = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().onInstallConversionDataLoadedNative();
        if (onInstallConversionDataLoadedNative.valueOf != null) {
            StringBuilder sb2 = new StringBuilder("[DDL] Calling onDeepLinking with:\n");
            sb2.append(deepLinkResult.toString());
            AFLogger.afDebugLog(sb2.toString());
            try {
                onInstallConversionDataLoadedNative.valueOf.onDeepLinking(deepLinkResult);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        } else {
            AFLogger.afDebugLog("[DDL] skipping, no callback registered");
        }
    }
}
