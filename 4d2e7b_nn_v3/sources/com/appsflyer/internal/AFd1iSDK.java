package com.appsflyer.internal;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.io.IOException;

public abstract class AFd1iSDK<Result> extends AFd1pSDK<AFd1zSDK<Result>> {
    protected final AFc1kSDK AFLogger;
    public final AFe1nSDK afDebugLog;
    @Nullable
    public AFd1zSDK<Result> afErrorLog;
    protected final AFb1sSDK afInfoLog;
    private AFb1zSDK afRDLog;
    @Nullable
    private String afWarnLog;

    private AFd1iSDK(@NonNull AFd1rSDK aFd1rSDK, @NonNull AFd1rSDK[] aFd1rSDKArr, @NonNull AFc1kSDK aFc1kSDK, @NonNull AFe1nSDK aFe1nSDK, @NonNull AFb1sSDK aFb1sSDK, @NonNull AFb1zSDK aFb1zSDK, @Nullable String str) {
        super(aFd1rSDK, aFd1rSDKArr, str);
        this.AFLogger = aFc1kSDK;
        this.afDebugLog = aFe1nSDK;
        this.afInfoLog = aFb1sSDK;
        this.afRDLog = aFb1zSDK;
    }

    public final void AFInAppEventParameterName() {
        String str;
        super.AFInAppEventParameterName();
        if (afRDLog() && (str = this.afDebugLog.values) != null && !str.trim().isEmpty()) {
            AFKeystoreWrapper(AFInAppEventType(str).AFKeystoreWrapper);
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public abstract AFc1jSDK<Result> AFInAppEventType(@NonNull String str);

    @CallSuper
    @NonNull
    public AFd1tSDK AFInAppEventType() throws Exception {
        if (!getLevel() || !this.afDebugLog.AFInAppEventParameterName()) {
            String str = this.afDebugLog.values;
            if (str == null || str.trim().isEmpty()) {
                AppsFlyerRequestListener AFLogger2 = AFLogger();
                if (AFLogger2 != null) {
                    AFLogger2.onError(RequestError.NO_DEV_KEY, AFb1aSDK.valueOf);
                }
                throw new AFd1qSDK();
            }
            AFc1jSDK AFInAppEventType = AFInAppEventType(str);
            if (afRDLog()) {
                AFKeystoreWrapper(AFInAppEventType.AFKeystoreWrapper);
            }
            AFd1zSDK<Result> AFInAppEventParameterName = AFInAppEventType.AFInAppEventParameterName();
            this.afErrorLog = AFInAppEventParameterName;
            this.afInfoLog.AFKeystoreWrapper(AFInAppEventType.AFKeystoreWrapper.valueOf(), AFInAppEventParameterName.getStatusCode(), AFInAppEventParameterName.getBody().toString());
            AppsFlyerRequestListener AFLogger3 = AFLogger();
            if (AFLogger3 != null) {
                if (AFInAppEventParameterName.isSuccessful()) {
                    AFLogger3.onSuccess();
                } else {
                    int i10 = RequestError.RESPONSE_CODE_FAILURE;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(AFb1aSDK.AFInAppEventParameterName);
                    sb2.append(" ");
                    sb2.append(AFInAppEventParameterName.getStatusCode());
                    AFLogger3.onError(i10, sb2.toString());
                }
            }
            if (AFInAppEventParameterName.isSuccessful()) {
                return AFd1tSDK.SUCCESS;
            }
            return AFd1tSDK.FAILURE;
        }
        AppsFlyerRequestListener AFLogger4 = AFLogger();
        if (AFLogger4 != null) {
            AFLogger4.onError(RequestError.STOP_TRACKING, AFb1aSDK.AFInAppEventType);
        }
        throw new AFd1jSDK();
    }

    public boolean AFKeystoreWrapper() {
        if (afInfoLog() instanceof AFd1jSDK) {
            return false;
        }
        if (this.valueOf == AFd1tSDK.TIMEOUT) {
            return true;
        }
        Throwable afInfoLog2 = afInfoLog();
        if (!(afInfoLog2 instanceof IOException) || (afInfoLog2 instanceof ParsingException)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract AppsFlyerRequestListener AFLogger();

    /* access modifiers changed from: protected */
    public abstract boolean afRDLog();

    /* access modifiers changed from: protected */
    public boolean getLevel() {
        return true;
    }

    public long valueOf() {
        return 60000;
    }

    @CallSuper
    public void values() {
        String str;
        if (this.valueOf == AFd1tSDK.SUCCESS) {
            String str2 = this.afWarnLog;
            if (str2 != null) {
                this.afRDLog.AFKeystoreWrapper(str2);
            }
        } else if (!AFKeystoreWrapper() && (str = this.afWarnLog) != null) {
            this.afRDLog.AFKeystoreWrapper(str);
        }
    }

    public AFd1iSDK(@NonNull AFd1rSDK aFd1rSDK, @NonNull AFd1rSDK[] aFd1rSDKArr, @NonNull AFc1vSDK aFc1vSDK, @Nullable String str) {
        this(aFd1rSDK, aFd1rSDKArr, aFc1vSDK.AFInAppEventType(), aFc1vSDK.getLevel(), aFc1vSDK.afErrorLogForExcManagerOnly(), aFc1vSDK.afWarnLog(), str);
    }

    @WorkerThread
    private void AFKeystoreWrapper(AFc1rSDK aFc1rSDK) {
        String str = this.afWarnLog;
        this.afWarnLog = this.afRDLog.AFInAppEventType(new AFa1oSDK(aFc1rSDK.valueOf(), aFc1rSDK.AFInAppEventType(), "6.10.2", this.AFInAppEventType));
        if (str != null) {
            this.afRDLog.AFKeystoreWrapper(str);
        }
    }

    @CallSuper
    public final void AFInAppEventParameterName(Throwable th) {
        AFLogger.afErrorLog("Error while sending request to server: ".concat(String.valueOf(th)), th, true);
        AppsFlyerRequestListener AFLogger2 = AFLogger();
        if (AFLogger2 != null) {
            String message = th.getMessage();
            int i10 = RequestError.NETWORK_FAILURE;
            if (message == null) {
                message = "";
            }
            AFLogger2.onError(i10, message);
        }
    }

    public AFd1iSDK(@NonNull AFd1rSDK aFd1rSDK, @NonNull AFd1rSDK[] aFd1rSDKArr, @NonNull AFc1vSDK aFc1vSDK, @Nullable String str, @Nullable String str2) {
        this(aFd1rSDK, aFd1rSDKArr, aFc1vSDK.AFInAppEventType(), aFc1vSDK.getLevel(), aFc1vSDK.afErrorLogForExcManagerOnly(), aFc1vSDK.afWarnLog(), str);
        this.afWarnLog = str2;
    }
}
