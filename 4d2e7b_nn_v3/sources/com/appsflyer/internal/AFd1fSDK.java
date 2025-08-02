package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.deeplink.DeepLinkResult;

public final class AFd1fSDK extends AFd1pSDK<DeepLinkResult> {
    private final AFb1oSDK AFLogger;
    private DeepLinkResult afRDLog;

    /* renamed from: com.appsflyer.internal.AFd1fSDK$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] AFInAppEventParameterName;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.appsflyer.deeplink.DeepLinkResult$Status[] r0 = com.appsflyer.deeplink.DeepLinkResult.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                AFInAppEventParameterName = r0
                com.appsflyer.deeplink.DeepLinkResult$Status r1 = com.appsflyer.deeplink.DeepLinkResult.Status.FOUND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = AFInAppEventParameterName     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.deeplink.DeepLinkResult$Status r1 = com.appsflyer.deeplink.DeepLinkResult.Status.NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = AFInAppEventParameterName     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.appsflyer.deeplink.DeepLinkResult$Status r1 = com.appsflyer.deeplink.DeepLinkResult.Status.ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1fSDK.AnonymousClass1.<clinit>():void");
        }
    }

    public AFd1fSDK(@NonNull AFb1oSDK aFb1oSDK) {
        super(AFd1rSDK.DLSDK, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, "DdlSdk");
        this.AFLogger = aFb1oSDK;
    }

    @NonNull
    public final AFd1tSDK AFInAppEventType() throws Exception {
        DeepLinkResult afInfoLog = this.AFLogger.afInfoLog();
        this.afRDLog = afInfoLog;
        if (AnonymousClass1.AFInAppEventParameterName[afInfoLog.getStatus().ordinal()] == 1) {
            return AFd1tSDK.SUCCESS;
        }
        if (this.afRDLog.getError() == DeepLinkResult.Error.TIMEOUT) {
            return AFd1tSDK.TIMEOUT;
        }
        return AFd1tSDK.FAILURE;
    }

    public final boolean AFKeystoreWrapper() {
        return false;
    }

    public final long valueOf() {
        return 90000;
    }
}
